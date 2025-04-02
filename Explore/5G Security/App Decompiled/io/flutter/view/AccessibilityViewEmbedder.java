package io.flutter.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class AccessibilityViewEmbedder {
   private static final String TAG = "AccessibilityBridge";
   private final Map<View, Rect> embeddedViewToDisplayBounds;
   private final SparseArray<AccessibilityViewEmbedder.c> flutterIdToOrigin = new SparseArray();
   private int nextFlutterId;
   private final Map<AccessibilityViewEmbedder.c, Integer> originToFlutterId;
   private final AccessibilityViewEmbedder.b reflectionAccessors = new AccessibilityViewEmbedder.b();
   private final View rootAccessibilityView;

   AccessibilityViewEmbedder(View var1, int var2) {
      this.rootAccessibilityView = var1;
      this.nextFlutterId = var2;
      this.originToFlutterId = new HashMap();
      this.embeddedViewToDisplayBounds = new HashMap();
   }

   private void addChildrenToFlutterNode(AccessibilityNodeInfo var1, View var2, AccessibilityNodeInfo var3) {
      for(int var4 = 0; var4 < var1.getChildCount(); ++var4) {
         Long var5 = this.reflectionAccessors.f(var1, var4);
         if (var5 != null) {
            int var6 = AccessibilityViewEmbedder.b.j(var5);
            AccessibilityViewEmbedder.c var8 = new AccessibilityViewEmbedder.c(var2, var6);
            int var7;
            if (this.originToFlutterId.containsKey(var8)) {
               var7 = (Integer)this.originToFlutterId.get(var8);
            } else {
               var7 = this.nextFlutterId++;
               this.cacheVirtualIdMappings(var2, var6, var7);
            }

            var3.addChild(this.rootAccessibilityView, var7);
         }
      }

   }

   private void cacheVirtualIdMappings(View var1, int var2, int var3) {
      AccessibilityViewEmbedder.c var4 = new AccessibilityViewEmbedder.c(var1, var2);
      this.originToFlutterId.put(var4, var3);
      this.flutterIdToOrigin.put(var3, var4);
   }

   private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo var1, int var2, View var3) {
      AccessibilityNodeInfo var4 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, var2);
      var4.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
      var4.setSource(this.rootAccessibilityView, var2);
      var4.setClassName(var1.getClassName());
      Rect var5 = (Rect)this.embeddedViewToDisplayBounds.get(var3);
      this.copyAccessibilityFields(var1, var4);
      this.setFlutterNodesTranslateBounds(var1, var5, var4);
      this.addChildrenToFlutterNode(var1, var3, var4);
      this.setFlutterNodeParent(var1, var3, var4);
      return var4;
   }

   private void copyAccessibilityFields(AccessibilityNodeInfo var1, AccessibilityNodeInfo var2) {
      var2.setAccessibilityFocused(var1.isAccessibilityFocused());
      var2.setCheckable(var1.isCheckable());
      var2.setChecked(var1.isChecked());
      var2.setContentDescription(var1.getContentDescription());
      var2.setEnabled(var1.isEnabled());
      var2.setClickable(var1.isClickable());
      var2.setFocusable(var1.isFocusable());
      var2.setFocused(var1.isFocused());
      var2.setLongClickable(var1.isLongClickable());
      var2.setMovementGranularities(var1.getMovementGranularities());
      var2.setPassword(var1.isPassword());
      var2.setScrollable(var1.isScrollable());
      var2.setSelected(var1.isSelected());
      var2.setText(var1.getText());
      var2.setVisibleToUser(var1.isVisibleToUser());
      var2.setEditable(var1.isEditable());
      var2.setCanOpenPopup(var1.canOpenPopup());
      var2.setCollectionInfo(var1.getCollectionInfo());
      var2.setCollectionItemInfo(var1.getCollectionItemInfo());
      var2.setContentInvalid(var1.isContentInvalid());
      var2.setDismissable(var1.isDismissable());
      var2.setInputType(var1.getInputType());
      var2.setLiveRegion(var1.getLiveRegion());
      var2.setMultiLine(var1.isMultiLine());
      var2.setRangeInfo(var1.getRangeInfo());
      var2.setError(var1.getError());
      var2.setMaxTextLength(var1.getMaxTextLength());
      int var3 = VERSION.SDK_INT;
      if (var3 >= 23) {
         l.a(var2, i.a(var1));
      }

      if (var3 >= 24) {
         n.a(var2, m.a(var1));
         a.a(var2, o.a(var1));
      }

      if (var3 >= 26) {
         q.a(var2, p.a(var1));
         io.flutter.view.c.a(var2, r.a(var1));
         k.a(var2, j.a(var1));
      }

   }

   private void setFlutterNodeParent(AccessibilityNodeInfo var1, View var2, AccessibilityNodeInfo var3) {
      Long var5 = this.reflectionAccessors.g(var1);
      if (var5 != null) {
         int var4 = AccessibilityViewEmbedder.b.j(var5);
         Integer var6 = (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.c(var2, var4));
         if (var6 != null) {
            var3.setParent(this.rootAccessibilityView, var6);
         }

      }
   }

   private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo var1, Rect var2, AccessibilityNodeInfo var3) {
      Rect var4 = new Rect();
      var1.getBoundsInParent(var4);
      var3.setBoundsInParent(var4);
      var4 = new Rect();
      var1.getBoundsInScreen(var4);
      var4.offset(var2.left, var2.top);
      var3.setBoundsInScreen(var4);
   }

   public AccessibilityNodeInfo createAccessibilityNodeInfo(int var1) {
      AccessibilityViewEmbedder.c var2 = (AccessibilityViewEmbedder.c)this.flutterIdToOrigin.get(var1);
      if (var2 == null) {
         return null;
      } else if (!this.embeddedViewToDisplayBounds.containsKey(var2.a)) {
         return null;
      } else if (var2.a.getAccessibilityNodeProvider() == null) {
         return null;
      } else {
         AccessibilityNodeInfo var3 = var2.a.getAccessibilityNodeProvider().createAccessibilityNodeInfo(var2.b);
         return var3 == null ? null : this.convertToFlutterNode(var3, var1, var2.a);
      }
   }

   public Integer getRecordFlutterId(View var1, AccessibilityRecord var2) {
      Long var4 = this.reflectionAccessors.h(var2);
      if (var4 == null) {
         return null;
      } else {
         int var3 = AccessibilityViewEmbedder.b.j(var4);
         return (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.c(var1, var3));
      }
   }

   public AccessibilityNodeInfo getRootNode(View var1, int var2, Rect var3) {
      AccessibilityNodeInfo var4 = var1.createAccessibilityNodeInfo();
      Long var5 = this.reflectionAccessors.i(var4);
      if (var5 == null) {
         return null;
      } else {
         this.embeddedViewToDisplayBounds.put(var1, var3);
         this.cacheVirtualIdMappings(var1, AccessibilityViewEmbedder.b.j(var5), var2);
         return this.convertToFlutterNode(var4, var2, var1);
      }
   }

   public boolean onAccessibilityHoverEvent(int var1, MotionEvent var2) {
      AccessibilityViewEmbedder.c var3 = (AccessibilityViewEmbedder.c)this.flutterIdToOrigin.get(var1);
      var1 = 0;
      if (var3 == null) {
         return false;
      } else {
         Rect var4 = (Rect)this.embeddedViewToDisplayBounds.get(var3.a);
         int var5 = var2.getPointerCount();
         PointerProperties[] var6 = new PointerProperties[var5];

         PointerCoords[] var7;
         for(var7 = new PointerCoords[var5]; var1 < var2.getPointerCount(); ++var1) {
            PointerProperties var8 = new PointerProperties();
            var6[var1] = var8;
            var2.getPointerProperties(var1, var8);
            PointerCoords var9 = new PointerCoords();
            var2.getPointerCoords(var1, var9);
            var9 = new PointerCoords(var9);
            var7[var1] = var9;
            var9.x -= (float)var4.left;
            var9.y -= (float)var4.top;
         }

         var2 = MotionEvent.obtain(var2.getDownTime(), var2.getEventTime(), var2.getAction(), var2.getPointerCount(), var6, var7, var2.getMetaState(), var2.getButtonState(), var2.getXPrecision(), var2.getYPrecision(), var2.getDeviceId(), var2.getEdgeFlags(), var2.getSource(), var2.getFlags());
         return var3.a.dispatchGenericMotionEvent(var2);
      }
   }

   public boolean performAction(int var1, int var2, Bundle var3) {
      AccessibilityViewEmbedder.c var4 = (AccessibilityViewEmbedder.c)this.flutterIdToOrigin.get(var1);
      if (var4 == null) {
         return false;
      } else {
         AccessibilityNodeProvider var5 = var4.a.getAccessibilityNodeProvider();
         return var5 == null ? false : var5.performAction(var4.b, var2, var3);
      }
   }

   public View platformViewOfNode(int var1) {
      AccessibilityViewEmbedder.c var2 = (AccessibilityViewEmbedder.c)this.flutterIdToOrigin.get(var1);
      return var2 == null ? null : var2.a;
   }

   public boolean requestSendAccessibilityEvent(View var1, View var2, AccessibilityEvent var3) {
      AccessibilityEvent var4 = AccessibilityEvent.obtain(var3);
      Long var5 = this.reflectionAccessors.h(var3);
      if (var5 == null) {
         return false;
      } else {
         int var6 = AccessibilityViewEmbedder.b.j(var5);
         Integer var7 = (Integer)this.originToFlutterId.get(new AccessibilityViewEmbedder.c(var1, var6));
         Integer var10 = var7;
         int var8;
         if (var7 == null) {
            var8 = this.nextFlutterId++;
            var10 = var8;
            this.cacheVirtualIdMappings(var1, var6, var10);
         }

         var4.setSource(this.rootAccessibilityView, var10);
         var4.setClassName(var3.getClassName());
         var4.setPackageName(var3.getPackageName());

         for(var6 = 0; var6 < var4.getRecordCount(); ++var6) {
            AccessibilityRecord var9 = var4.getRecord(var6);
            var5 = this.reflectionAccessors.h(var9);
            if (var5 == null) {
               return false;
            }

            AccessibilityViewEmbedder.c var11 = new AccessibilityViewEmbedder.c(var1, AccessibilityViewEmbedder.b.j(var5));
            if (!this.originToFlutterId.containsKey(var11)) {
               return false;
            }

            var8 = (Integer)this.originToFlutterId.get(var11);
            var9.setSource(this.rootAccessibilityView, var8);
         }

         return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(var2, var4);
      }
   }

   private static class b {
      private final Method a;
      private final Method b;
      private final Method c;
      private final Method d;
      private final Field e;
      private final Method f;

      private b() {
         Method var1 = null;
         Method var2 = null;

         Method var3;
         try {
            var3 = AccessibilityNodeInfo.class.getMethod("getSourceNodeId");
         } catch (NoSuchMethodException var11) {
            y.b.g("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
            var3 = null;
         }

         Method var5;
         try {
            var5 = AccessibilityRecord.class.getMethod("getSourceNodeId");
         } catch (NoSuchMethodException var10) {
            y.b.g("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
            var5 = null;
         }

         Method var4;
         Field var6;
         label43: {
            if (VERSION.SDK_INT <= 26) {
               try {
                  var4 = AccessibilityNodeInfo.class.getMethod("getParentNodeId");
               } catch (NoSuchMethodException var9) {
                  y.b.g("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
                  var4 = null;
               }

               try {
                  var2 = AccessibilityNodeInfo.class.getMethod("getChildId", Integer.TYPE);
               } catch (NoSuchMethodException var8) {
                  y.b.g("AccessibilityBridge", "can't invoke getChildId with reflection");
                  var2 = null;
               }

               var1 = var4;
               var4 = var2;
               var2 = var1;
            } else {
               label41: {
                  try {
                     var6 = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                     var6.setAccessible(true);
                     var4 = Class.forName("android.util.LongArray").getMethod("get", Integer.TYPE);
                  } catch (ClassNotFoundException | NoSuchMethodException | NullPointerException | NoSuchFieldException var12) {
                     y.b.g("AccessibilityBridge", "can't access childNodeIdsField with reflection");
                     var4 = null;
                     break label41;
                  }

                  var2 = var4;
                  var4 = null;
                  break label43;
               }
            }

            Object var7 = null;
            var6 = null;
            var1 = var2;
            var2 = (Method)var7;
         }

         this.a = var3;
         this.b = var1;
         this.c = var5;
         this.d = var4;
         this.e = var6;
         this.f = var2;
      }

      // $FF: synthetic method
      b(Object var1) {
         this();
      }

      private Long f(AccessibilityNodeInfo var1, int var2) {
         Method var3 = this.d;
         if (var3 == null && (this.e == null || this.f == null)) {
            return null;
         } else {
            Object var11;
            String var13;
            if (var3 != null) {
               try {
                  Long var12 = (Long)var3.invoke(var1, var2);
                  return var12;
               } catch (IllegalAccessException var6) {
                  var11 = var6;
                  var13 = "Failed to access getChildId method.";
               } catch (InvocationTargetException var7) {
                  var11 = var7;
                  var13 = "The getChildId method threw an exception when invoked.";
               }
            } else {
               label31: {
                  try {
                     long var4 = (Long)this.f.invoke(this.e.get(var1), var2);
                     return var4;
                  } catch (IllegalAccessException var8) {
                     var11 = var8;
                     var13 = "Failed to access longArrayGetIndex method or the childNodeId field.";
                     break label31;
                  } catch (InvocationTargetException var9) {
                     var11 = var9;
                  } catch (ArrayIndexOutOfBoundsException var10) {
                     var11 = var10;
                  }

                  var13 = "The longArrayGetIndex method threw an exception when invoked.";
               }
            }

            y.b.h("AccessibilityBridge", var13, (Throwable)var11);
            return null;
         }
      }

      private Long g(AccessibilityNodeInfo var1) {
         Method var2 = this.b;
         if (var2 != null) {
            String var5;
            Object var8;
            label16: {
               long var3;
               try {
                  var3 = (Long)var2.invoke(var1);
               } catch (IllegalAccessException var6) {
                  var8 = var6;
                  var5 = "Failed to access getParentNodeId method.";
                  break label16;
               } catch (InvocationTargetException var7) {
                  var8 = var7;
                  var5 = "The getParentNodeId method threw an exception when invoked.";
                  break label16;
               }

               return var3;
            }

            y.b.h("AccessibilityBridge", var5, (Throwable)var8);
         }

         return l(var1);
      }

      private Long h(AccessibilityRecord var1) {
         Method var2 = this.c;
         if (var2 == null) {
            return null;
         } else {
            Object var5;
            String var7;
            try {
               Long var6 = (Long)var2.invoke(var1);
               return var6;
            } catch (IllegalAccessException var3) {
               var5 = var3;
               var7 = "Failed to access the getRecordSourceNodeId method.";
            } catch (InvocationTargetException var4) {
               var5 = var4;
               var7 = "The getRecordSourceNodeId method threw an exception when invoked.";
            }

            y.b.h("AccessibilityBridge", var7, (Throwable)var5);
            return null;
         }
      }

      private Long i(AccessibilityNodeInfo var1) {
         Method var2 = this.a;
         if (var2 == null) {
            return null;
         } else {
            String var5;
            Object var7;
            try {
               Long var6 = (Long)var2.invoke(var1);
               return var6;
            } catch (IllegalAccessException var3) {
               var7 = var3;
               var5 = "Failed to access getSourceNodeId method.";
            } catch (InvocationTargetException var4) {
               var7 = var4;
               var5 = "The getSourceNodeId method threw an exception when invoked.";
            }

            y.b.h("AccessibilityBridge", var5, (Throwable)var7);
            return null;
         }
      }

      private static int j(long var0) {
         return (int)(var0 >> 32);
      }

      private static boolean k(long var0, int var2) {
         boolean var3;
         if ((var0 & 1L << var2) != 0L) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      private static Long l(AccessibilityNodeInfo var0) {
         int var1 = VERSION.SDK_INT;
         Object var2 = null;
         if (var1 < 26) {
            y.b.g("AccessibilityBridge", "Unexpected Android version. Unable to find the parent ID.");
            return null;
         } else {
            var0 = AccessibilityNodeInfo.obtain(var0);
            Parcel var3 = Parcel.obtain();
            var3.setDataPosition(0);
            var0.writeToParcel(var3, 0);
            var3.setDataPosition(0);
            long var4 = var3.readLong();
            if (k(var4, 0)) {
               var3.readInt();
            }

            if (k(var4, 1)) {
               var3.readLong();
            }

            if (k(var4, 2)) {
               var3.readInt();
            }

            Long var6 = (Long)var2;
            if (k(var4, 3)) {
               var6 = var3.readLong();
            }

            var3.recycle();
            return var6;
         }
      }
   }

   private static class c {
      final View a;
      final int b;

      private c(View var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      // $FF: synthetic method
      c(View var1, int var2, Object var3) {
         this(var1, var2);
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AccessibilityViewEmbedder.c)) {
            return false;
         } else {
            AccessibilityViewEmbedder.c var3 = (AccessibilityViewEmbedder.c)var1;
            if (this.b != var3.b || !this.a.equals(var3.a)) {
               var2 = false;
            }

            return var2;
         }
      }

      public int hashCode() {
         return (this.a.hashCode() + 31) * 31 + this.b;
      }
   }
}
