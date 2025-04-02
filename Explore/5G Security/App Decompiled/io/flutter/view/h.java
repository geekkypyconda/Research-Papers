package io.flutter.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan.Builder;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h extends AccessibilityNodeProvider {
   private static final int A;
   private static int B;
   static int C;
   private static final int z;
   private final View a;
   private final j0.a b;
   private final AccessibilityManager c;
   private final AccessibilityViewEmbedder d;
   private final io.flutter.plugin.platform.q e;
   private final ContentResolver f;
   private final Map<Integer, io.flutter.view.h.l> g;
   private final Map<Integer, io.flutter.view.h.h> h;
   private io.flutter.view.h.l i;
   private Integer j;
   private Integer k;
   private int l;
   private io.flutter.view.h.l m;
   private io.flutter.view.h.l n;
   private io.flutter.view.h.l o;
   private final List<Integer> p;
   private int q;
   private Integer r;
   private io.flutter.view.h.k s;
   private boolean t;
   private boolean u;
   private final j0.a.b v;
   private final AccessibilityStateChangeListener w;
   private final TouchExplorationStateChangeListener x;
   private final ContentObserver y;

   static {
      z = io.flutter.view.h.g.i.e | io.flutter.view.h.g.h.e | io.flutter.view.h.g.j.e | io.flutter.view.h.g.k.e;
      A = io.flutter.view.h.i.f.e | io.flutter.view.h.i.g.e | io.flutter.view.h.i.h.e | io.flutter.view.h.i.j.e | io.flutter.view.h.i.k.e | io.flutter.view.h.i.l.e | io.flutter.view.h.i.m.e | io.flutter.view.h.i.n.e | io.flutter.view.h.i.v.e | io.flutter.view.h.i.w.e | io.flutter.view.h.i.A.e | io.flutter.view.h.i.C.e;
      B = 267386881;
      C = io.flutter.view.h.g.u.e & io.flutter.view.h.g.v.e & io.flutter.view.h.g.n.e;
   }

   public h(View var1, j0.a var2, AccessibilityManager var3, ContentResolver var4, io.flutter.plugin.platform.q var5) {
      this(var1, var2, var3, var4, new AccessibilityViewEmbedder(var1, 65536), var5);
   }

   public h(View var1, j0.a var2, final AccessibilityManager var3, ContentResolver var4, AccessibilityViewEmbedder var5, io.flutter.plugin.platform.q var6) {
      this.g = new HashMap();
      this.h = new HashMap();
      this.l = 0;
      this.p = new ArrayList();
      this.q = 0;
      this.r = 0;
      this.t = false;
      this.u = false;
      this.v = new j0.a.b() {
         public void a(ByteBuffer var1, String[] var2, ByteBuffer[] var3) {
            var1.order(ByteOrder.LITTLE_ENDIAN);
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               var3[var5].order(ByteOrder.LITTLE_ENDIAN);
            }

            h.this.d0(var1, var2, var3);
         }

         public void b(ByteBuffer var1, String[] var2) {
            var1.order(ByteOrder.LITTLE_ENDIAN);
            h.this.c0(var1, var2);
         }

         public void c(String var1) {
            if (VERSION.SDK_INT < 28) {
               AccessibilityEvent var2 = h.this.I(0, 32);
               var2.getText().add(var1);
               h.this.U(var2);
            }
         }

         public void d(int var1) {
            h.this.T(var1, 8);
         }

         public void e(int var1) {
            h.this.T(var1, 2);
         }

         public void f(String var1) {
            h.this.a.announceForAccessibility(var1);
         }

         public void g(int var1) {
            h.this.T(var1, 1);
         }
      };
      AccessibilityStateChangeListener var7 = new AccessibilityStateChangeListener() {
         public void onAccessibilityStateChanged(boolean var1) {
            if (!h.this.u) {
               io.flutter.view.h var2 = h.this;
               if (var1) {
                  var2.b.g(h.this.v);
                  h.this.b.e();
               } else {
                  var2.Y(false);
                  h.this.b.g((j0.a.b)null);
                  h.this.b.d();
               }

               if (h.this.s != null) {
                  h.this.s.a(var1, h.this.c.isTouchExplorationEnabled());
               }

            }
         }
      };
      this.w = var7;
      ContentObserver var8 = new ContentObserver(new Handler()) {
         public void onChange(boolean var1) {
            this.onChange(var1, (Uri)null);
         }

         public void onChange(boolean var1, Uri var2) {
            if (!h.this.u) {
               boolean var3;
               if (Global.getFloat(h.this.f, "transition_animation_scale", 1.0F) == 0.0F) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               if (var3) {
                  io.flutter.view.h.f(h.this, io.flutter.view.h.f.h.e);
               } else {
                  io.flutter.view.h.e(h.this, io.flutter.view.h.f.h.e);
               }

               h.this.V();
            }
         }
      };
      this.y = var8;
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.f = var4;
      this.d = var5;
      this.e = var6;
      var7.onAccessibilityStateChanged(var3.isEnabled());
      var3.addAccessibilityStateChangeListener(var7);
      TouchExplorationStateChangeListener var9 = new TouchExplorationStateChangeListener() {
         public void onTouchExplorationStateChanged(boolean var1) {
            if (!h.this.u) {
               if (!var1) {
                  h.this.Y(false);
                  h.this.N();
               }

               if (h.this.s != null) {
                  h.this.s.a(var3.isEnabled(), var1);
               }

            }
         }
      };
      this.x = var9;
      var9.onTouchExplorationStateChanged(var3.isTouchExplorationEnabled());
      var3.addTouchExplorationStateChangeListener(var9);
      var8.onChange(false);
      var4.registerContentObserver(Global.getUriFor("transition_animation_scale"), false, var8);
      if (VERSION.SDK_INT >= 31) {
         this.Z();
      }

      var6.b(this);
   }

   private io.flutter.view.h.l A() {
      return (io.flutter.view.h.l)this.g.get(0);
   }

   private void B(float var1, float var2, boolean var3) {
      if (!this.g.isEmpty()) {
         io.flutter.view.h.l var4 = this.A().y0(new float[]{var1, var2, 0.0F, 1.0F}, var3);
         if (var4 != this.o) {
            if (var4 != null) {
               this.T(var4.b, 128);
            }

            io.flutter.view.h.l var5 = this.o;
            if (var5 != null) {
               this.T(var5.b, 256);
            }

            this.o = var4;
         }

      }
   }

   private boolean D(io.flutter.view.h.l var1) {
      boolean var2 = var1.x0(io.flutter.view.h.i.q);
      boolean var3 = false;
      if (var2) {
         return false;
      } else if (var1.t0() != null) {
         return true;
      } else {
         if ((var1.d & C) != 0) {
            var3 = true;
         }

         return var3;
      }
   }

   // $FF: synthetic method
   private static boolean F(io.flutter.view.h.l var0, io.flutter.view.h.l var1) {
      boolean var2;
      if (var1 == var0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   // $FF: synthetic method
   private static boolean G(io.flutter.view.h.l var0) {
      return var0.x0(io.flutter.view.h.i.x);
   }

   private AccessibilityEvent I(int var1, int var2) {
      AccessibilityEvent var3 = this.H(var2);
      var3.setPackageName(this.a.getContext().getPackageName());
      var3.setSource(this.a, var1);
      return var3;
   }

   private void N() {
      io.flutter.view.h.l var1 = this.o;
      if (var1 != null) {
         this.T(var1.b, 256);
         this.o = null;
      }

   }

   private void O(io.flutter.view.h.l var1) {
      String var2 = var1.p0();
      String var3 = var2;
      if (var2 == null) {
         var3 = " ";
      }

      if (VERSION.SDK_INT >= 28) {
         this.X(var3);
      } else {
         AccessibilityEvent var4 = this.I(var1.b, 32);
         var4.getText().add(var3);
         this.U(var4);
      }

   }

   private boolean P(io.flutter.view.h.l var1, int var2, Bundle var3, boolean var4) {
      int var5 = var3.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
      boolean var6 = var3.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
      int var7 = var1.g;
      int var8 = var1.h;
      this.R(var1, var5, var4, var6);
      if (var7 != var1.g || var8 != var1.h) {
         String var10;
         if (var1.r != null) {
            var10 = var1.r;
         } else {
            var10 = "";
         }

         AccessibilityEvent var9 = this.I(var1.b, 8192);
         var9.getText().add(var10);
         var9.setFromIndex(var1.g);
         var9.setToIndex(var1.h);
         var9.setItemCount(var10.length());
         this.U(var9);
      }

      io.flutter.view.h.g var11;
      if (var5 != 1) {
         if (var5 != 2) {
            if (var5 == 4 || var5 == 8 || var5 == 16) {
               return true;
            }
         } else {
            if (var4) {
               var11 = io.flutter.view.h.g.y;
               if (var1.w0(var11)) {
                  this.b.c(var2, var11, var6);
                  return true;
               }
            }

            if (!var4) {
               var11 = io.flutter.view.h.g.z;
               if (var1.w0(var11)) {
                  this.b.c(var2, var11, var6);
                  return true;
               }
            }
         }
      } else {
         if (var4) {
            var11 = io.flutter.view.h.g.o;
            if (var1.w0(var11)) {
               this.b.c(var2, var11, var6);
               return true;
            }
         }

         if (!var4) {
            var11 = io.flutter.view.h.g.p;
            if (var1.w0(var11)) {
               this.b.c(var2, var11, var6);
               return true;
            }
         }
      }

      return false;
   }

   private boolean Q(io.flutter.view.h.l var1, int var2, Bundle var3) {
      String var4;
      if (var3 != null && var3.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) {
         var4 = var3.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
      } else {
         var4 = "";
      }

      this.b.c(var2, io.flutter.view.h.g.A, var4);
      var1.r = var4;
      var1.s = null;
      return true;
   }

   private void R(io.flutter.view.h.l var1, int var2, boolean var3, boolean var4) {
      if (var1.h >= 0 && var1.g >= 0) {
         if (var2 == 1) {
            if (var3 && var1.h < var1.r.length()) {
               io.flutter.view.h.l.n(var1, 1);
            } else if (!var3 && var1.h > 0) {
               io.flutter.view.h.l.o(var1, 1);
            }
         } else {
            label97: {
               Matcher var5;
               label86: {
                  label85: {
                     label101: {
                        label82: {
                           if (var2 != 2) {
                              if (var2 != 4) {
                                 if (var2 != 8 && var2 != 16) {
                                    break label97;
                                 }

                                 if (!var3) {
                                    break label101;
                                 }
                              } else {
                                 if (!var3 || var1.h >= var1.r.length()) {
                                    if (var3 || var1.h <= 0) {
                                       break label97;
                                    }

                                    var5 = Pattern.compile("(?s:.*)(\\n)").matcher(var1.r.substring(0, var1.h));
                                    if (!var5.find()) {
                                       break label101;
                                    }
                                    break label82;
                                 }

                                 var5 = Pattern.compile("(?!^)(\\n)").matcher(var1.r.substring(var1.h));
                                 if (var5.find()) {
                                    break label86;
                                 }
                              }
                           } else {
                              if (!var3 || var1.h >= var1.r.length()) {
                                 if (var3 || var1.h <= 0) {
                                    break label97;
                                 }

                                 var5 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(var1.r.substring(0, var1.h));
                                 if (!var5.find()) {
                                    break label97;
                                 }
                                 break label82;
                              }

                              var5 = Pattern.compile("\\p{L}(\\b)").matcher(var1.r.substring(var1.h));
                              var5.find();
                              if (var5.find()) {
                                 break label86;
                              }
                           }

                           var2 = var1.r.length();
                           break label85;
                        }

                        var2 = var5.start(1);
                        break label85;
                     }

                     var1.h = 0;
                     break label97;
                  }

                  var1.h = var2;
                  break label97;
               }

               io.flutter.view.h.l.n(var1, var5.start(1));
            }
         }

         if (!var4) {
            var1.g = var1.h;
         }
      }

   }

   private void U(AccessibilityEvent var1) {
      if (this.c.isEnabled()) {
         this.a.getParent().requestSendAccessibilityEvent(this.a, var1);
      }
   }

   private void V() {
      this.b.f(this.l);
   }

   private void W(int var1) {
      AccessibilityEvent var2 = this.I(var1, 2048);
      var2.setContentChangeTypes(1);
      this.U(var2);
   }

   private void X(String var1) {
      androidx.core.view.p.a(this.a, var1);
   }

   private void Y(boolean var1) {
      if (this.t != var1) {
         this.t = var1;
         int var2;
         if (var1) {
            var2 = this.l | io.flutter.view.h.f.f.e;
         } else {
            var2 = this.l & io.flutter.view.h.f.f.e;
         }

         this.l = var2;
         this.V();
      }
   }

   private void Z() {
      View var1 = this.a;
      if (var1 != null && var1.getResources() != null) {
         int var2 = this.a.getResources().getConfiguration().fontWeightAdjustment;
         boolean var3;
         if (var2 != Integer.MAX_VALUE && var2 >= 300) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var3) {
            var2 = this.l | io.flutter.view.h.f.i.e;
         } else {
            var2 = this.l & io.flutter.view.h.f.i.e;
         }

         this.l = var2;
         this.V();
      }

   }

   // $FF: synthetic method
   public static boolean a(io.flutter.view.h.l var0) {
      return G(var0);
   }

   // $FF: synthetic method
   public static boolean b(io.flutter.view.h.l var0, io.flutter.view.h.l var1) {
      return F(var0, var1);
   }

   private boolean b0(io.flutter.view.h.l var1) {
      boolean var2;
      if (var1.j <= 0 || !io.flutter.view.h.l.C0(this.i, new io.flutter.view.f(var1)) && io.flutter.view.h.l.C0(this.i, new io.flutter.view.g())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   // $FF: synthetic method
   static int e(io.flutter.view.h var0, int var1) {
      var1 &= var0.l;
      var0.l = var1;
      return var1;
   }

   private void e0(io.flutter.view.h.l var1) {
      var1.R = null;
      if (var1.i != -1) {
         Integer var2 = this.j;
         if (var2 != null && this.d.platformViewOfNode(var2) == this.e.d(var1.i)) {
            this.T(this.j, 65536);
            this.j = null;
         }
      }

      if (var1.i != -1) {
         View var3 = this.e.d(var1.i);
         if (var3 != null) {
            var3.setImportantForAccessibility(4);
         }
      }

      io.flutter.view.h.l var4 = this.i;
      if (var4 == var1) {
         this.T(var4.b, 65536);
         this.i = null;
      }

      if (this.m == var1) {
         this.m = null;
      }

      if (this.o == var1) {
         this.o = null;
      }

   }

   // $FF: synthetic method
   static int f(io.flutter.view.h var0, int var1) {
      var1 |= var0.l;
      var0.l = var1;
      return var1;
   }

   private AccessibilityEvent u(int var1, String var2, String var3) {
      AccessibilityEvent var4 = this.I(var1, 16);
      var4.setBeforeText(var2);
      var4.getText().add(var3);

      for(var1 = 0; var1 < var2.length() && var1 < var3.length() && var2.charAt(var1) == var3.charAt(var1); ++var1) {
      }

      if (var1 >= var2.length() && var1 >= var3.length()) {
         return null;
      } else {
         var4.setFromIndex(var1);
         int var5 = var2.length() - 1;

         int var6;
         for(var6 = var3.length() - 1; var5 >= var1 && var6 >= var1 && var2.charAt(var5) == var3.charAt(var6); --var6) {
            --var5;
         }

         var4.setRemovedCount(var5 - var1 + 1);
         var4.setAddedCount(var6 - var1 + 1);
         return var4;
      }
   }

   private boolean v() {
      Activity var1 = o0.i.e(this.a.getContext());
      boolean var2 = false;
      boolean var3 = var2;
      if (var1 != null) {
         if (var1.getWindow() == null) {
            var3 = var2;
         } else {
            int var4 = var1.getWindow().getAttributes().layoutInDisplayCutoutMode;
            if (var4 != 2) {
               var3 = var2;
               if (var4 != 0) {
                  return var3;
               }
            }

            var3 = true;
         }
      }

      return var3;
   }

   private Rect x(Rect var1) {
      Rect var2 = new Rect(var1);
      int[] var3 = new int[2];
      this.a.getLocationOnScreen(var3);
      var2.offset(var3[0], var3[1]);
      return var2;
   }

   private io.flutter.view.h.h y(int var1) {
      io.flutter.view.h.h var2 = (io.flutter.view.h.h)this.h.get(var1);
      io.flutter.view.h.h var3 = var2;
      if (var2 == null) {
         var3 = new io.flutter.view.h.h();
         var3.b = var1;
         var3.a = B + var1;
         this.h.put(var1, var3);
      }

      return var3;
   }

   private io.flutter.view.h.l z(int var1) {
      io.flutter.view.h.l var2 = (io.flutter.view.h.l)this.g.get(var1);
      io.flutter.view.h.l var3 = var2;
      if (var2 == null) {
         var3 = new io.flutter.view.h.l(this);
         var3.b = var1;
         this.g.put(var1, var3);
      }

      return var3;
   }

   public boolean C() {
      return this.c.isEnabled();
   }

   public boolean E() {
      return this.c.isTouchExplorationEnabled();
   }

   public AccessibilityEvent H(int var1) {
      return AccessibilityEvent.obtain(var1);
   }

   public AccessibilityNodeInfo J(View var1) {
      return AccessibilityNodeInfo.obtain(var1);
   }

   public AccessibilityNodeInfo K(View var1, int var2) {
      return AccessibilityNodeInfo.obtain(var1, var2);
   }

   public boolean L(MotionEvent var1) {
      return this.M(var1, false);
   }

   public boolean M(MotionEvent var1, boolean var2) {
      if (!this.c.isTouchExplorationEnabled()) {
         return false;
      } else if (this.g.isEmpty()) {
         return false;
      } else {
         io.flutter.view.h.l var3 = this.A().y0(new float[]{var1.getX(), var1.getY(), 0.0F, 1.0F}, var2);
         if (var3 != null && var3.i != -1) {
            return var2 ? false : this.d.onAccessibilityHoverEvent(var3.b, var1);
         } else {
            if (var1.getAction() != 9 && var1.getAction() != 7) {
               if (var1.getAction() != 10) {
                  StringBuilder var4 = new StringBuilder();
                  var4.append("unexpected accessibility hover event: ");
                  var4.append(var1);
                  y.b.a("flutter", var4.toString());
                  return false;
               }

               this.N();
            } else {
               this.B(var1.getX(), var1.getY(), var2);
            }

            return true;
         }
      }
   }

   public void S() {
      this.u = true;
      this.e.a();
      this.a0((io.flutter.view.h.k)null);
      this.c.removeAccessibilityStateChangeListener(this.w);
      this.c.removeTouchExplorationStateChangeListener(this.x);
      this.f.unregisterContentObserver(this.y);
      this.b.g((j0.a.b)null);
   }

   public void T(int var1, int var2) {
      if (this.c.isEnabled()) {
         this.U(this.I(var1, var2));
      }
   }

   public void a0(io.flutter.view.h.k var1) {
      this.s = var1;
   }

   void c0(ByteBuffer var1, String[] var2) {
      io.flutter.view.h.h var3;
      String var6;
      for(; var1.hasRemaining(); var3.e = var6) {
         var3 = this.y(var1.getInt());
         var3.c = var1.getInt();
         int var4 = var1.getInt();
         Object var5 = null;
         if (var4 == -1) {
            var6 = null;
         } else {
            var6 = var2[var4];
         }

         var3.d = var6;
         var4 = var1.getInt();
         if (var4 == -1) {
            var6 = (String)var5;
         } else {
            var6 = var2[var4];
         }
      }

   }

   public AccessibilityNodeInfo createAccessibilityNodeInfo(int var1) {
      boolean var2 = true;
      this.Y(true);
      if (var1 >= 65536) {
         return this.d.createAccessibilityNodeInfo(var1);
      } else if (var1 == -1) {
         AccessibilityNodeInfo var29 = this.J(this.a);
         this.a.onInitializeAccessibilityNodeInfo(var29);
         if (this.g.containsKey(0)) {
            var29.addChild(this.a, 0);
         }

         if (VERSION.SDK_INT >= 24) {
            io.flutter.view.a.a(var29, false);
         }

         return var29;
      } else {
         io.flutter.view.h.l var4 = (io.flutter.view.h.l)this.g.get(var1);
         if (var4 == null) {
            return null;
         } else {
            Rect var18;
            View var26;
            if (var4.i != -1 && this.e.c(var4.i)) {
               var26 = this.e.d(var4.i);
               if (var26 == null) {
                  return null;
               } else {
                  var18 = var4.m0();
                  return this.d.getRootNode(var26, var4.b, var18);
               }
            } else {
               AccessibilityNodeInfo var6 = this.K(this.a, var1);
               int var7 = VERSION.SDK_INT;
               if (var7 >= 24) {
                  io.flutter.view.a.a(var6, this.D(var4));
               }

               String var8 = "";
               var6.setViewIdResourceName("");
               if (var4.o != null) {
                  var6.setViewIdResourceName(var4.o);
               }

               var6.setPackageName(this.a.getContext().getPackageName());
               var6.setClassName("android.view.View");
               var6.setSource(this.a, var1);
               var6.setFocusable(var4.z0());
               io.flutter.view.h.l var3 = this.m;
               boolean var9;
               if (var3 != null) {
                  if (var3.b == var1) {
                     var9 = true;
                  } else {
                     var9 = false;
                  }

                  var6.setFocused(var9);
               }

               var3 = this.i;
               if (var3 != null) {
                  if (var3.b == var1) {
                     var9 = true;
                  } else {
                     var9 = false;
                  }

                  var6.setAccessibilityFocused(var9);
               }

               io.flutter.view.h.i var5 = io.flutter.view.h.i.j;
               if (var4.x0(var5)) {
                  var6.setPassword(var4.x0(io.flutter.view.h.i.p));
                  io.flutter.view.h.i var17 = io.flutter.view.h.i.z;
                  if (!var4.x0(var17)) {
                     var6.setClassName("android.widget.EditText");
                  }

                  var6.setEditable(var4.x0(var17) ^ true);
                  if (var4.g != -1 && var4.h != -1) {
                     var6.setTextSelection(var4.g, var4.h);
                  }

                  var3 = this.i;
                  if (var3 != null && var3.b == var1) {
                     var6.setLiveRegion(1);
                  }

                  byte var10;
                  if (var4.w0(io.flutter.view.h.g.o)) {
                     var6.addAction(256);
                     var10 = 1;
                  } else {
                     var10 = 0;
                  }

                  int var11 = var10;
                  if (var4.w0(io.flutter.view.h.g.p)) {
                     var6.addAction(512);
                     var11 = var10 | 1;
                  }

                  int var30 = var11;
                  if (var4.w0(io.flutter.view.h.g.y)) {
                     var6.addAction(256);
                     var30 = var11 | 2;
                  }

                  var11 = var30;
                  if (var4.w0(io.flutter.view.h.g.z)) {
                     var6.addAction(512);
                     var11 = var30 | 2;
                  }

                  var6.setMovementGranularities(var11);
                  if (var4.e >= 0) {
                     if (var4.r == null) {
                        var11 = 0;
                     } else {
                        var11 = var4.r.length();
                     }

                     var4.f;
                     var4.e;
                     var6.setMaxTextLength(var11 - var4.f + var4.e);
                  }
               }

               if (var4.w0(io.flutter.view.h.g.q)) {
                  var6.addAction(131072);
               }

               if (var4.w0(io.flutter.view.h.g.r)) {
                  var6.addAction(16384);
               }

               if (var4.w0(io.flutter.view.h.g.s)) {
                  var6.addAction(65536);
               }

               if (var4.w0(io.flutter.view.h.g.t)) {
                  var6.addAction(32768);
               }

               if (var4.w0(io.flutter.view.h.g.A)) {
                  var6.addAction(2097152);
               }

               if (var4.x0(io.flutter.view.h.i.i) || var4.x0(io.flutter.view.h.i.B)) {
                  var6.setClassName("android.widget.Button");
               }

               if (var4.x0(io.flutter.view.h.i.t)) {
                  var6.setClassName("android.widget.ImageView");
               }

               if (var4.w0(io.flutter.view.h.g.x)) {
                  var6.setDismissable(true);
                  var6.addAction(1048576);
               }

               if (var4.R != null) {
                  var6.setParent(this.a, var4.R.b);
               } else {
                  var6.setParent(this.a);
               }

               if (var4.A != -1 && var7 >= 22) {
                  io.flutter.view.b.a(var6, this.a, var4.A);
               }

               Rect var12 = var4.m0();
               if (var4.R != null) {
                  var18 = var4.R.m0();
                  Rect var13 = new Rect(var12);
                  var13.offset(-var18.left, -var18.top);
                  var6.setBoundsInParent(var13);
               } else {
                  var6.setBoundsInParent(var12);
               }

               var6.setBoundsInScreen(this.x(var12));
               var6.setVisibleToUser(true);
               if (var4.x0(io.flutter.view.h.i.l) && !var4.x0(io.flutter.view.h.i.m)) {
                  var9 = false;
               } else {
                  var9 = true;
               }

               var6.setEnabled(var9);
               if (var4.w0(io.flutter.view.h.g.f)) {
                  if (var4.V != null) {
                     var6.addAction(new AccessibilityAction(16, var4.V.e));
                  } else {
                     var6.addAction(16);
                  }

                  var6.setClickable(true);
               }

               if (var4.w0(io.flutter.view.h.g.g)) {
                  if (var4.W != null) {
                     var6.addAction(new AccessibilityAction(32, var4.W.e));
                  } else {
                     var6.addAction(32);
                  }

                  var6.setLongClickable(true);
               }

               io.flutter.view.h.g var31 = io.flutter.view.h.g.h;
               String var19;
               if (var4.w0(var31) || var4.w0(io.flutter.view.h.g.j) || var4.w0(io.flutter.view.h.g.i) || var4.w0(io.flutter.view.h.g.k)) {
                  var6.setScrollable(true);
                  if (var4.x0(io.flutter.view.h.i.x)) {
                     label362: {
                        CollectionInfo var20;
                        label369: {
                           if (!var4.w0(var31) && !var4.w0(io.flutter.view.h.g.i)) {
                              if (this.b0(var4)) {
                                 var20 = CollectionInfo.obtain(var4.j, 0, false);
                                 break label369;
                              }

                              var19 = "android.widget.ScrollView";
                           } else {
                              if (this.b0(var4)) {
                                 var20 = CollectionInfo.obtain(0, var4.j, false);
                                 break label369;
                              }

                              var19 = "android.widget.HorizontalScrollView";
                           }

                           var6.setClassName(var19);
                           break label362;
                        }

                        var6.setCollectionInfo(var20);
                     }
                  }

                  if (var4.w0(var31) || var4.w0(io.flutter.view.h.g.j)) {
                     var6.addAction(4096);
                  }

                  if (var4.w0(io.flutter.view.h.g.i) || var4.w0(io.flutter.view.h.g.k)) {
                     var6.addAction(8192);
                  }
               }

               io.flutter.view.h.g var22 = io.flutter.view.h.g.l;
               if (var4.w0(var22) || var4.w0(io.flutter.view.h.g.m)) {
                  var6.setClassName("android.widget.SeekBar");
                  if (var4.w0(var22)) {
                     var6.addAction(4096);
                  }

                  if (var4.w0(io.flutter.view.h.g.m)) {
                     var6.addAction(8192);
                  }
               }

               if (var4.x0(io.flutter.view.h.i.u)) {
                  var6.setLiveRegion(1);
               }

               if (var4.x0(var5)) {
                  var6.setText(var4.s0());
                  if (var7 >= 28) {
                     io.flutter.view.c.a(var6, var4.r0());
                  }
               } else if (!var4.x0(io.flutter.view.h.i.q)) {
                  CharSequence var23 = var4.t0();
                  Object var21 = var23;
                  if (var7 < 28) {
                     var21 = var23;
                     if (var4.z != null) {
                        var21 = var8;
                        if (var23 != null) {
                           var21 = var23;
                        }

                        StringBuilder var24 = new StringBuilder();
                        var24.append(var21);
                        var24.append("\n");
                        var24.append(var4.z);
                        var21 = var24.toString();
                     }
                  }

                  if (var21 != null) {
                     var6.setContentDescription((CharSequence)var21);
                  }
               }

               if (var7 >= 28 && var4.z != null) {
                  io.flutter.view.d.a(var6, var4.z);
               }

               boolean var14 = var4.x0(io.flutter.view.h.i.f);
               boolean var15 = var4.x0(io.flutter.view.h.i.v);
               var9 = var2;
               if (!var14) {
                  if (var15) {
                     var9 = var2;
                  } else {
                     var9 = false;
                  }
               }

               label265: {
                  var6.setCheckable(var9);
                  if (var14) {
                     var6.setChecked(var4.x0(io.flutter.view.h.i.g));
                     if (var4.x0(io.flutter.view.h.i.n)) {
                        var19 = "android.widget.RadioButton";
                     } else {
                        var19 = "android.widget.CheckBox";
                     }
                  } else {
                     if (!var15) {
                        break label265;
                     }

                     var6.setChecked(var4.x0(io.flutter.view.h.i.w));
                     var19 = "android.widget.Switch";
                  }

                  var6.setClassName(var19);
               }

               var6.setSelected(var4.x0(io.flutter.view.h.i.h));
               if (var7 >= 28) {
                  io.flutter.view.e.a(var6, var4.x0(io.flutter.view.h.i.o));
               }

               var3 = this.i;
               short var16;
               if (var3 != null && var3.b == var1) {
                  var16 = 128;
               } else {
                  var16 = 64;
               }

               var6.addAction(var16);
               if (var4.U != null) {
                  Iterator var28 = var4.U.iterator();

                  while(var28.hasNext()) {
                     io.flutter.view.h.h var25 = (io.flutter.view.h.h)var28.next();
                     var6.addAction(new AccessibilityAction(var25.a, var25.d));
                  }
               }

               Iterator var27 = var4.S.iterator();

               while(true) {
                  while(true) {
                     do {
                        if (!var27.hasNext()) {
                           return var6;
                        }

                        var3 = (io.flutter.view.h.l)var27.next();
                     } while(var3.x0(io.flutter.view.h.i.s));

                     if (var3.i != -1) {
                        var26 = this.e.d(var3.i);
                        if (!this.e.c(var3.i)) {
                           var6.addChild(var26);
                           continue;
                        }
                     }

                     var6.addChild(this.a, var3.b);
                  }
               }
            }
         }
      }
   }

   void d0(ByteBuffer var1, String[] var2, ByteBuffer[] var3) {
      ArrayList var4 = new ArrayList();

      while(var1.hasRemaining()) {
         io.flutter.view.h.l var5 = this.z(var1.getInt());
         var5.F0(var1, var2, var3);
         if (!var5.x0(io.flutter.view.h.i.s)) {
            if (var5.x0(io.flutter.view.h.i.k)) {
               this.m = var5;
            }

            if (var5.C) {
               var4.add(var5);
            }

            if (var5.i != -1 && !this.e.c(var5.i)) {
               View var23 = this.e.d(var5.i);
               if (var23 != null) {
                  var23.setImportantForAccessibility(0);
               }
            }
         }
      }

      HashSet var16 = new HashSet();
      io.flutter.view.h.l var12 = this.A();
      ArrayList var25 = new ArrayList();
      int var6;
      if (var12 != null) {
         float[] var13 = new float[16];
         Matrix.setIdentityM(var13, 0);
         var6 = VERSION.SDK_INT;
         if (var6 >= 23) {
            boolean var7;
            if (var6 >= 28) {
               var7 = this.v();
            } else {
               var7 = true;
            }

            if (var7) {
               WindowInsets var8 = androidx.core.view.h.a(this.a);
               if (var8 != null) {
                  if (!this.r.equals(var8.getSystemWindowInsetLeft())) {
                     var12.Z = true;
                     var12.X = true;
                  }

                  Integer var27 = var8.getSystemWindowInsetLeft();
                  this.r = var27;
                  Matrix.translateM(var13, 0, (float)var27, 0.0F, 0.0F);
               }
            }
         }

         var12.E0(var13, var16, false);
         var12.g0(var25);
      }

      Iterator var28 = var25.iterator();
      var12 = null;

      io.flutter.view.h.l var14;
      while(var28.hasNext()) {
         var14 = (io.flutter.view.h.l)var28.next();
         if (!this.p.contains(var14.b)) {
            var12 = var14;
         }
      }

      var14 = var12;
      if (var12 == null) {
         var14 = var12;
         if (var25.size() > 0) {
            var14 = (io.flutter.view.h.l)var25.get(var25.size() - 1);
         }
      }

      if (var14 != null && (var14.b != this.q || var25.size() != this.p.size())) {
         this.q = var14.b;
         this.O(var14);
      }

      this.p.clear();
      Iterator var20 = var25.iterator();

      while(var20.hasNext()) {
         var12 = (io.flutter.view.h.l)var20.next();
         this.p.add(var12.b);
      }

      var20 = this.g.entrySet().iterator();

      while(var20.hasNext()) {
         var12 = (io.flutter.view.h.l)((Entry)var20.next()).getValue();
         if (!var16.contains(var12)) {
            this.e0(var12);
            var20.remove();
         }
      }

      this.W(0);
      Iterator var21 = var4.iterator();

      while(true) {
         io.flutter.view.h.l var17;
         AccessibilityEvent var22;
         String var26;
         do {
            do {
               io.flutter.view.h.i var18;
               do {
                  do {
                     do {
                        do {
                           if (!var21.hasNext()) {
                              return;
                           }

                           var17 = (io.flutter.view.h.l)var21.next();
                           if (var17.j0()) {
                              var22 = this.I(var17.b, 4096);
                              float var9 = var17.l;
                              float var10 = var17.m;
                              float var11 = var9;
                              if (Float.isInfinite(var17.m)) {
                                 var11 = var9;
                                 if (var9 > 70000.0F) {
                                    var11 = 70000.0F;
                                 }

                                 var10 = 100000.0F;
                              }

                              if (Float.isInfinite(var17.n)) {
                                 var10 += 100000.0F;
                                 var9 = var11;
                                 if (var11 < -70000.0F) {
                                    var9 = -70000.0F;
                                 }

                                 var11 = var9 + 100000.0F;
                                 var9 = var10;
                              } else {
                                 var9 = var10 - var17.n;
                                 var11 -= var17.n;
                              }

                              if (!var17.u0(io.flutter.view.h.g.j) && !var17.u0(io.flutter.view.h.g.k)) {
                                 if (var17.u0(io.flutter.view.h.g.h) || var17.u0(io.flutter.view.h.g.i)) {
                                    var22.setScrollX((int)var11);
                                    var22.setMaxScrollX((int)var9);
                                 }
                              } else {
                                 var22.setScrollY((int)var11);
                                 var22.setMaxScrollY((int)var9);
                              }

                              if (var17.j > 0) {
                                 var22.setItemCount(var17.j);
                                 var22.setFromIndex(var17.k);
                                 Iterator var15 = var17.T.iterator();
                                 var6 = 0;

                                 while(var15.hasNext()) {
                                    if (!((io.flutter.view.h.l)var15.next()).x0(io.flutter.view.h.i.s)) {
                                       ++var6;
                                    }
                                 }

                                 var22.setToIndex(var17.k + var6 - 1);
                              }

                              this.U(var22);
                           }

                           if (var17.x0(io.flutter.view.h.i.u) && var17.i0()) {
                              this.W(var17.b);
                           }

                           var12 = this.i;
                           if (var12 != null && var12.b == var17.b) {
                              var18 = io.flutter.view.h.i.h;
                              if (!var17.v0(var18) && var17.x0(var18)) {
                                 AccessibilityEvent var19 = this.I(var17.b, 4);
                                 var19.getText().add(var17.p);
                                 this.U(var19);
                              }
                           }

                           label177: {
                              var12 = this.m;
                              if (var12 != null && var12.b == var17.b) {
                                 var12 = this.n;
                                 if (var12 == null || var12.b != this.m.b) {
                                    this.n = this.m;
                                    this.U(this.I(var17.b, 8));
                                    break label177;
                                 }
                              }

                              if (this.m == null) {
                                 this.n = null;
                              }
                           }

                           var12 = this.m;
                        } while(var12 == null);
                     } while(var12.b != var17.b);

                     var18 = io.flutter.view.h.i.j;
                  } while(!var17.v0(var18));
               } while(!var17.x0(var18));

               var12 = this.i;
            } while(var12 != null && var12.b != this.m.b);

            String var24 = var17.K;
            var26 = "";
            if (var24 != null) {
               var24 = var17.K;
            } else {
               var24 = "";
            }

            if (var17.r != null) {
               var26 = var17.r;
            }

            var22 = this.u(var17.b, var24, var26);
            if (var22 != null) {
               this.U(var22);
            }
         } while(var17.F == var17.g && var17.G == var17.h);

         var22 = this.I(var17.b, 8192);
         var22.getText().add(var26);
         var22.setFromIndex(var17.g);
         var22.setToIndex(var17.h);
         var22.setItemCount(var26.length());
         this.U(var22);
      }
   }

   public AccessibilityNodeInfo findFocus(int var1) {
      io.flutter.view.h.l var2;
      label46: {
         Integer var3;
         label34: {
            if (var1 != 1) {
               if (var1 != 2) {
                  return null;
               }
            } else {
               var2 = this.m;
               if (var2 != null) {
                  break label46;
               }

               var3 = this.k;
               if (var3 != null) {
                  break label34;
               }
            }

            var2 = this.i;
            if (var2 != null) {
               break label46;
            }

            var3 = this.j;
            if (var3 == null) {
               return null;
            }
         }

         var1 = var3;
         return this.createAccessibilityNodeInfo(var1);
      }

      var1 = var2.b;
      return this.createAccessibilityNodeInfo(var1);
   }

   public boolean performAction(int var1, int var2, Bundle var3) {
      if (var1 >= 65536) {
         boolean var4 = this.d.performAction(var1, var2, var3);
         if (var4 && var2 == 128) {
            this.j = null;
         }

         return var4;
      } else {
         io.flutter.view.h.l var5 = (io.flutter.view.h.l)this.g.get(var1);
         boolean var6 = false;
         if (var5 == null) {
            return false;
         } else {
            io.flutter.view.h.l var9;
            io.flutter.view.h.g var10;
            switch(var2) {
            case 16:
               this.b.b(var1, io.flutter.view.h.g.f);
               return true;
            case 32:
               this.b.b(var1, io.flutter.view.h.g.g);
               return true;
            case 64:
               if (this.i == null) {
                  this.a.invalidate();
               }

               this.i = var5;
               this.b.b(var1, io.flutter.view.h.g.u);
               HashMap var13 = new HashMap();
               var13.put("type", "didGainFocus");
               var13.put("nodeId", var5.b);
               this.b.a.c(var13);
               this.T(var1, 32768);
               if (var5.w0(io.flutter.view.h.g.l) || var5.w0(io.flutter.view.h.g.m)) {
                  this.T(var1, 4);
               }

               return true;
            case 128:
               var9 = this.i;
               if (var9 != null && var9.b == var1) {
                  this.i = null;
               }

               Integer var12 = this.j;
               if (var12 != null && var12 == var1) {
                  this.j = null;
               }

               this.b.b(var1, io.flutter.view.h.g.v);
               this.T(var1, 65536);
               return true;
            case 256:
               return this.P(var5, var1, var3, true);
            case 512:
               return this.P(var5, var1, var3, false);
            case 4096:
               var10 = io.flutter.view.h.g.j;
               if (!var5.w0(var10)) {
                  var10 = io.flutter.view.h.g.h;
                  if (!var5.w0(var10)) {
                     var10 = io.flutter.view.h.g.l;
                     if (!var5.w0(var10)) {
                        return false;
                     }

                     var5.r = var5.t;
                     var5.s = var5.u;
                     this.T(var1, 4);
                  }
               }

               this.b.b(var1, var10);
               return true;
            case 8192:
               var10 = io.flutter.view.h.g.k;
               if (!var5.w0(var10)) {
                  var10 = io.flutter.view.h.g.i;
                  if (!var5.w0(var10)) {
                     var10 = io.flutter.view.h.g.m;
                     if (!var5.w0(var10)) {
                        return false;
                     }

                     var5.r = var5.v;
                     var5.s = var5.w;
                     this.T(var1, 4);
                  }
               }

               this.b.b(var1, var10);
               return true;
            case 16384:
               this.b.b(var1, io.flutter.view.h.g.r);
               return true;
            case 32768:
               this.b.b(var1, io.flutter.view.h.g.t);
               return true;
            case 65536:
               this.b.b(var1, io.flutter.view.h.g.s);
               return true;
            case 131072:
               HashMap var7 = new HashMap();
               boolean var8 = var6;
               if (var3 != null) {
                  var8 = var6;
                  if (var3.containsKey("ACTION_ARGUMENT_SELECTION_START_INT")) {
                     var8 = var6;
                     if (var3.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                        var8 = true;
                     }
                  }
               }

               if (var8) {
                  var7.put("base", var3.getInt("ACTION_ARGUMENT_SELECTION_START_INT"));
                  var2 = var3.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
               } else {
                  var7.put("base", var5.h);
                  var2 = var5.h;
               }

               var7.put("extent", var2);
               this.b.c(var1, io.flutter.view.h.g.q, var7);
               var9 = (io.flutter.view.h.l)this.g.get(var1);
               var9.g = (Integer)var7.get("base");
               var9.h = (Integer)var7.get("extent");
               return true;
            case 1048576:
               this.b.b(var1, io.flutter.view.h.g.x);
               return true;
            case 2097152:
               return this.Q(var5, var1, var3);
            case 16908342:
               this.b.b(var1, io.flutter.view.h.g.n);
               return true;
            default:
               int var11 = B;
               io.flutter.view.h.h var14 = (io.flutter.view.h.h)this.h.get(var2 - var11);
               if (var14 != null) {
                  this.b.c(var1, io.flutter.view.h.g.w, var14.b);
                  return true;
               } else {
                  return false;
               }
            }
         }
      }
   }

   public boolean w(View var1, View var2, AccessibilityEvent var3) {
      if (!this.d.requestSendAccessibilityEvent(var1, var2, var3)) {
         return false;
      } else {
         Integer var5 = this.d.getRecordFlutterId(var1, var3);
         if (var5 == null) {
            return false;
         } else {
            int var4 = var3.getEventType();
            if (var4 != 8) {
               if (var4 != 128) {
                  if (var4 != 32768) {
                     if (var4 == 65536) {
                        this.k = null;
                        this.j = null;
                     }
                  } else {
                     this.j = var5;
                     this.i = null;
                  }
               } else {
                  this.o = null;
               }
            } else {
               this.k = var5;
               this.m = null;
            }

            return true;
         }
      }
   }

   private static enum f {
      f(1),
      g(2),
      h(4),
      i(8),
      j(16),
      k(32),
      l(64);

      final int e;

      private f(int var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static io.flutter.view.h.f[] a() {
         return new io.flutter.view.h.f[]{f, g, h, i, j, k, l};
      }
   }

   public static enum g {
      A(2097152),
      B(4194304),
      f(1),
      g(2),
      h(4),
      i(8),
      j(16),
      k(32),
      l(64),
      m(128),
      n(256),
      o(512),
      p(1024),
      q(2048),
      r(4096),
      s(8192),
      t(16384),
      u(32768),
      v(65536),
      w(131072),
      x(262144),
      y(524288),
      z(1048576);

      public final int e;

      private g(int var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static io.flutter.view.h.g[] a() {
         return new io.flutter.view.h.g[]{f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B};
      }
   }

   private static class h {
      private int a = -1;
      private int b = -1;
      private int c = -1;
      private String d;
      private String e;

      h() {
      }
   }

   static enum i {
      A(2097152),
      B(4194304),
      C(8388608),
      D(16777216),
      E(33554432),
      F(67108864),
      G(134217728),
      f(1),
      g(2),
      h(4),
      i(8),
      j(16),
      k(32),
      l(64),
      m(128),
      n(256),
      o(512),
      p(1024),
      q(2048),
      r(4096),
      s(8192),
      t(16384),
      u(32768),
      v(65536),
      w(131072),
      x(262144),
      y(524288),
      z(1048576);

      final int e;

      private i(int var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static io.flutter.view.h.i[] a() {
         return new io.flutter.view.h.i[]{f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G};
      }
   }

   private static class j extends io.flutter.view.h.n {
      String d;

      private j() {
         super(null);
      }

      // $FF: synthetic method
      j(Object var1) {
         this();
      }
   }

   public interface k {
      void a(boolean var1, boolean var2);
   }

   private static class l {
      private int A = -1;
      private io.flutter.view.h.p B;
      private boolean C = false;
      private int D;
      private int E;
      private int F;
      private int G;
      private float H;
      private float I;
      private float J;
      private String K;
      private String L;
      private float M;
      private float N;
      private float O;
      private float P;
      private float[] Q;
      private io.flutter.view.h.l R;
      private List<io.flutter.view.h.l> S = new ArrayList();
      private List<io.flutter.view.h.l> T = new ArrayList();
      private List<io.flutter.view.h.h> U;
      private io.flutter.view.h.h V;
      private io.flutter.view.h.h W;
      private boolean X = true;
      private float[] Y;
      private boolean Z = true;
      final io.flutter.view.h a;
      private float[] a0;
      private int b = -1;
      private Rect b0;
      private int c;
      private int d;
      private int e;
      private int f;
      private int g;
      private int h;
      private int i;
      private int j;
      private int k;
      private float l;
      private float m;
      private float n;
      private String o;
      private String p;
      private List<io.flutter.view.h.n> q;
      private String r;
      private List<io.flutter.view.h.n> s;
      private String t;
      private List<io.flutter.view.h.n> u;
      private String v;
      private List<io.flutter.view.h.n> w;
      private String x;
      private List<io.flutter.view.h.n> y;
      private String z;

      l(io.flutter.view.h var1) {
         this.a = var1;
      }

      private float A0(float var1, float var2, float var3, float var4) {
         return Math.max(var1, Math.max(var2, Math.max(var3, var4)));
      }

      private float B0(float var1, float var2, float var3, float var4) {
         return Math.min(var1, Math.min(var2, Math.min(var3, var4)));
      }

      private static boolean C0(io.flutter.view.h.l var0, o0.e<io.flutter.view.h.l> var1) {
         boolean var2;
         if (var0 != null && var0.l0(var1) != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      private void D0(float[] var1, float[] var2, float[] var3) {
         Matrix.multiplyMV(var1, 0, var2, 0, var3, 0);
         float var4 = var1[3];
         var1[0] /= var4;
         var1[1] /= var4;
         var1[2] /= var4;
         var1[3] = 0.0F;
      }

      private void E0(float[] var1, Set<io.flutter.view.h.l> var2, boolean var3) {
         var2.add(this);
         if (this.Z) {
            var3 = true;
         }

         if (var3) {
            if (this.a0 == null) {
               this.a0 = new float[16];
            }

            if (this.Q == null) {
               this.Q = new float[16];
            }

            Matrix.multiplyMM(this.a0, 0, var1, 0, this.Q, 0);
            float[] var4 = new float[]{0.0F, 0.0F, 0.0F, 1.0F};
            float[] var5 = new float[4];
            float[] var6 = new float[4];
            var1 = new float[4];
            float[] var7 = new float[4];
            var4[0] = this.M;
            var4[1] = this.N;
            this.D0(var5, this.a0, var4);
            var4[0] = this.O;
            var4[1] = this.N;
            this.D0(var6, this.a0, var4);
            var4[0] = this.O;
            var4[1] = this.P;
            this.D0(var1, this.a0, var4);
            var4[0] = this.M;
            var4[1] = this.P;
            this.D0(var7, this.a0, var4);
            if (this.b0 == null) {
               this.b0 = new Rect();
            }

            this.b0.set(Math.round(this.B0(var5[0], var6[0], var1[0], var7[0])), Math.round(this.B0(var5[1], var6[1], var1[1], var7[1])), Math.round(this.A0(var5[0], var6[0], var1[0], var7[0])), Math.round(this.A0(var5[1], var6[1], var1[1], var7[1])));
            this.Z = false;
         }

         int var8 = -1;
         Iterator var9 = this.S.iterator();

         while(var9.hasNext()) {
            io.flutter.view.h.l var10 = (io.flutter.view.h.l)var9.next();
            var10.A = var8;
            var8 = var10.b;
            var10.E0(this.a0, var2, var3);
         }

      }

      private void F0(ByteBuffer var1, String[] var2, ByteBuffer[] var3) {
         this.C = true;
         this.K = this.r;
         this.L = this.p;
         this.D = this.c;
         this.E = this.d;
         this.F = this.g;
         this.G = this.h;
         this.H = this.l;
         this.I = this.m;
         this.J = this.n;
         this.c = var1.getInt();
         this.d = var1.getInt();
         this.e = var1.getInt();
         this.f = var1.getInt();
         this.g = var1.getInt();
         this.h = var1.getInt();
         this.i = var1.getInt();
         this.j = var1.getInt();
         this.k = var1.getInt();
         this.l = var1.getFloat();
         this.m = var1.getFloat();
         this.n = var1.getFloat();
         int var4 = var1.getInt();
         String var5;
         if (var4 == -1) {
            var5 = null;
         } else {
            var5 = var2[var4];
         }

         this.o = var5;
         var4 = var1.getInt();
         if (var4 == -1) {
            var5 = null;
         } else {
            var5 = var2[var4];
         }

         this.p = var5;
         this.q = this.q0(var1, var3);
         var4 = var1.getInt();
         if (var4 == -1) {
            var5 = null;
         } else {
            var5 = var2[var4];
         }

         this.r = var5;
         this.s = this.q0(var1, var3);
         var4 = var1.getInt();
         if (var4 == -1) {
            var5 = null;
         } else {
            var5 = var2[var4];
         }

         this.t = var5;
         this.u = this.q0(var1, var3);
         var4 = var1.getInt();
         if (var4 == -1) {
            var5 = null;
         } else {
            var5 = var2[var4];
         }

         this.v = var5;
         this.w = this.q0(var1, var3);
         var4 = var1.getInt();
         if (var4 == -1) {
            var5 = null;
         } else {
            var5 = var2[var4];
         }

         this.x = var5;
         this.y = this.q0(var1, var3);
         var4 = var1.getInt();
         String var8;
         if (var4 == -1) {
            var8 = null;
         } else {
            var8 = var2[var4];
         }

         this.z = var8;
         this.B = io.flutter.view.h.p.b(var1.getInt());
         this.M = var1.getFloat();
         this.N = var1.getFloat();
         this.O = var1.getFloat();
         this.P = var1.getFloat();
         if (this.Q == null) {
            this.Q = new float[16];
         }

         byte var6 = 0;

         for(var4 = 0; var4 < 16; ++var4) {
            this.Q[var4] = var1.getFloat();
         }

         this.X = true;
         this.Z = true;
         int var7 = var1.getInt();
         this.S.clear();
         this.T.clear();

         io.flutter.view.h.l var9;
         for(var4 = 0; var4 < var7; ++var4) {
            var9 = this.a.z(var1.getInt());
            var9.R = this;
            this.S.add(var9);
         }

         for(var4 = 0; var4 < var7; ++var4) {
            var9 = this.a.z(var1.getInt());
            var9.R = this;
            this.T.add(var9);
         }

         var7 = var1.getInt();
         if (var7 == 0) {
            this.U = null;
         } else {
            List var10 = this.U;
            if (var10 == null) {
               this.U = new ArrayList(var7);
               var4 = var6;
            } else {
               var10.clear();
               var4 = var6;
            }

            while(var4 < var7) {
               io.flutter.view.h.h var11 = this.a.y(var1.getInt());
               if (var11.c == io.flutter.view.h.g.f.e) {
                  this.V = var11;
               } else if (var11.c == io.flutter.view.h.g.g.e) {
                  this.W = var11;
               } else {
                  this.U.add(var11);
               }

               this.U.add(var11);
               ++var4;
            }
         }

      }

      private void g0(List<io.flutter.view.h.l> var1) {
         if (this.x0(io.flutter.view.h.i.q)) {
            var1.add(this);
         }

         Iterator var2 = this.S.iterator();

         while(var2.hasNext()) {
            ((io.flutter.view.h.l)var2.next()).g0(var1);
         }

      }

      private SpannableString h0(String var1, List<io.flutter.view.h.n> var2) {
         if (var1 == null) {
            return null;
         } else {
            SpannableString var5 = new SpannableString(var1);
            if (var2 != null) {
               Iterator var6 = var2.iterator();

               while(var6.hasNext()) {
                  io.flutter.view.h.n var3 = (io.flutter.view.h.n)var6.next();
                  int var4 = null.a[var3.c.ordinal()];
                  if (var4 != 1) {
                     if (var4 == 2) {
                        var5.setSpan(new LocaleSpan(Locale.forLanguageTag(((io.flutter.view.h.j)var3).d)), var3.a, var3.b, 0);
                     }
                  } else {
                     var5.setSpan((new Builder("android.type.verbatim")).build(), var3.a, var3.b, 0);
                  }
               }
            }

            return var5;
         }
      }

      private boolean i0() {
         String var1 = this.p;
         boolean var2 = false;
         if (var1 == null && this.L == null) {
            return false;
         } else {
            if (var1 != null) {
               String var3 = this.L;
               if (var3 != null && var1.equals(var3)) {
                  return var2;
               }
            }

            var2 = true;
            return var2;
         }
      }

      private boolean j0() {
         boolean var1;
         if (!Float.isNaN(this.l) && !Float.isNaN(this.H) && this.H != this.l) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      private void k0() {
         if (this.X) {
            this.X = false;
            if (this.Y == null) {
               this.Y = new float[16];
            }

            if (!Matrix.invertM(this.Y, 0, this.Q, 0)) {
               Arrays.fill(this.Y, 0.0F);
            }

         }
      }

      private io.flutter.view.h.l l0(o0.e<io.flutter.view.h.l> var1) {
         for(io.flutter.view.h.l var2 = this.R; var2 != null; var2 = var2.R) {
            if (var1.test(var2)) {
               return var2;
            }
         }

         return null;
      }

      private Rect m0() {
         return this.b0;
      }

      // $FF: synthetic method
      static int n(io.flutter.view.h.l var0, int var1) {
         var1 += var0.h;
         var0.h = var1;
         return var1;
      }

      private CharSequence n0() {
         return this.h0(this.x, this.y);
      }

      // $FF: synthetic method
      static int o(io.flutter.view.h.l var0, int var1) {
         var1 = var0.h - var1;
         var0.h = var1;
         return var1;
      }

      private CharSequence o0() {
         return this.h0(this.p, this.q);
      }

      private String p0() {
         if (this.x0(io.flutter.view.h.i.r)) {
            String var1 = this.p;
            if (var1 != null && !var1.isEmpty()) {
               return this.p;
            }
         }

         Iterator var3 = this.S.iterator();

         String var2;
         do {
            if (!var3.hasNext()) {
               return null;
            }

            var2 = ((io.flutter.view.h.l)var3.next()).p0();
         } while(var2 == null || var2.isEmpty());

         return var2;
      }

      private List<io.flutter.view.h.n> q0(ByteBuffer var1, ByteBuffer[] var2) {
         int var3 = var1.getInt();
         if (var3 == -1) {
            return null;
         } else {
            ArrayList var4 = new ArrayList(var3);

            for(int var5 = 0; var5 < var3; ++var5) {
               int var6 = var1.getInt();
               int var7 = var1.getInt();
               io.flutter.view.h.o var8 = io.flutter.view.h.o.values()[var1.getInt()];
               int var9 = null.a[var8.ordinal()];
               if (var9 != 1) {
                  if (var9 == 2) {
                     ByteBuffer var10 = var2[var1.getInt()];
                     io.flutter.view.h.j var11 = new io.flutter.view.h.j();
                     var11.a = var6;
                     var11.b = var7;
                     var11.c = var8;
                     var11.d = Charset.forName("UTF-8").decode(var10).toString();
                     var4.add(var11);
                  }
               } else {
                  var1.getInt();
                  io.flutter.view.h.m var12 = new io.flutter.view.h.m();
                  var12.a = var6;
                  var12.b = var7;
                  var12.c = var8;
                  var4.add(var12);
               }
            }

            return var4;
         }
      }

      private CharSequence r0() {
         CharSequence var1 = this.o0();
         CharSequence var2 = this.n0();
         CharSequence var3 = null;

         CharSequence var6;
         for(int var4 = 0; var4 < 2; var3 = var6) {
            CharSequence var5 = (new CharSequence[]{var1, var2})[var4];
            var6 = var3;
            if (var5 != null) {
               var6 = var3;
               if (var5.length() > 0) {
                  if (var3 != null && var3.length() != 0) {
                     var6 = TextUtils.concat(new CharSequence[]{var3, ", ", var5});
                  } else {
                     var6 = var5;
                  }
               }
            }

            ++var4;
         }

         return var3;
      }

      private CharSequence s0() {
         return this.h0(this.r, this.s);
      }

      private CharSequence t0() {
         CharSequence var1 = this.s0();
         CharSequence var2 = this.o0();
         CharSequence var3 = this.n0();
         CharSequence var4 = null;

         CharSequence var7;
         for(int var5 = 0; var5 < 3; var4 = var7) {
            CharSequence var6 = (new CharSequence[]{var1, var2, var3})[var5];
            var7 = var4;
            if (var6 != null) {
               var7 = var4;
               if (var6.length() > 0) {
                  if (var4 != null && var4.length() != 0) {
                     var7 = TextUtils.concat(new CharSequence[]{var4, ", ", var6});
                  } else {
                     var7 = var6;
                  }
               }
            }

            ++var5;
         }

         return var4;
      }

      private boolean u0(io.flutter.view.h.g var1) {
         int var2 = this.E;
         boolean var3;
         if ((var1.e & var2) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      private boolean v0(io.flutter.view.h.i var1) {
         int var2 = this.D;
         boolean var3;
         if ((var1.e & var2) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      private boolean w0(io.flutter.view.h.g var1) {
         int var2 = this.d;
         boolean var3;
         if ((var1.e & var2) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      private boolean x0(io.flutter.view.h.i var1) {
         int var2 = this.c;
         boolean var3;
         if ((var1.e & var2) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      private io.flutter.view.h.l y0(float[] var1, boolean var2) {
         float var3 = var1[3];
         boolean var4 = false;
         float var5 = var1[0] / var3;
         float var6 = var1[1] / var3;
         var3 = this.M;
         Object var7 = null;
         io.flutter.view.h.l var8 = (io.flutter.view.h.l)var7;
         if (!(var5 < var3)) {
            var8 = (io.flutter.view.h.l)var7;
            if (!(var5 >= this.O)) {
               var8 = (io.flutter.view.h.l)var7;
               if (!(var6 < this.N)) {
                  if (var6 >= this.P) {
                     var8 = (io.flutter.view.h.l)var7;
                  } else {
                     float[] var12 = new float[4];
                     Iterator var9 = this.T.iterator();

                     while(var9.hasNext()) {
                        io.flutter.view.h.l var10 = (io.flutter.view.h.l)var9.next();
                        if (!var10.x0(io.flutter.view.h.i.s)) {
                           var10.k0();
                           Matrix.multiplyMV(var12, 0, var10.Y, 0, var1, 0);
                           var10 = var10.y0(var12, var2);
                           if (var10 != null) {
                              return var10;
                           }
                        }
                     }

                     boolean var11 = var4;
                     if (var2) {
                        var11 = var4;
                        if (this.i != -1) {
                           var11 = true;
                        }
                     }

                     if (!this.z0()) {
                        var8 = (io.flutter.view.h.l)var7;
                        if (!var11) {
                           return var8;
                        }
                     }

                     var8 = this;
                  }
               }
            }
         }

         return var8;
      }

      private boolean z0() {
         boolean var1 = this.x0(io.flutter.view.h.i.q);
         boolean var2 = false;
         if (var1) {
            return false;
         } else if (this.x0(io.flutter.view.h.i.A)) {
            return true;
         } else {
            if ((this.d & io.flutter.view.h.z) == 0 && (this.c & io.flutter.view.h.A) == 0) {
               String var3 = this.p;
               if (var3 == null || var3.isEmpty()) {
                  var3 = this.r;
                  if (var3 == null || var3.isEmpty()) {
                     var3 = this.x;
                     var1 = var2;
                     if (var3 == null) {
                        return var1;
                     }

                     var1 = var2;
                     if (var3.isEmpty()) {
                        return var1;
                     }
                  }
               }
            }

            var1 = true;
            return var1;
         }
      }
   }

   private static class m extends io.flutter.view.h.n {
      private m() {
         super(null);
      }

      // $FF: synthetic method
      m(Object var1) {
         this();
      }
   }

   private static class n {
      int a;
      int b;
      io.flutter.view.h.o c;

      private n() {
      }

      // $FF: synthetic method
      n(Object var1) {
         this();
      }
   }

   private static enum o {
      e,
      f;

      // $FF: synthetic method
      private static io.flutter.view.h.o[] a() {
         return new io.flutter.view.h.o[]{e, f};
      }
   }

   private static enum p {
      e,
      f,
      g;

      // $FF: synthetic method
      private static io.flutter.view.h.p[] a() {
         return new io.flutter.view.h.p[]{e, f, g};
      }

      public static io.flutter.view.h.p b(int var0) {
         if (var0 != 1) {
            return var0 != 2 ? e : f;
         } else {
            return g;
         }
      }
   }
}
