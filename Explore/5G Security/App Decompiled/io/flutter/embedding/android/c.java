package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.InputDevice.MotionRange;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class c {
   private static final Matrix f = new Matrix();
   private final FlutterRenderer a;
   private final d0 b;
   private final boolean c;
   private final Map<Integer, float[]> d = new HashMap();
   private int e;

   public c(FlutterRenderer var1, boolean var2) {
      this.a = var1;
      this.b = d0.a();
      this.c = var2;
   }

   private void a(MotionEvent var1, int var2, int var3, int var4, Matrix var5, ByteBuffer var6) {
      this.b(var1, var2, var3, var4, var5, var6, (Context)null);
   }

   private void b(MotionEvent var1, int var2, int var3, int var4, Matrix var5, ByteBuffer var6, Context var7) {
      int var8 = -1;
      if (var3 != -1) {
         int var9 = var1.getPointerId(var2);
         int var10 = this.f(var1.getToolType(var2));
         float[] var11 = new float[]{var1.getX(var2), var1.getY(var2)};
         var5.mapPoints(var11);
         long var12;
         long var14;
         if (var10 == 1) {
            var12 = (long)(var1.getButtonState() & 31);
            var14 = var12;
            if (var12 == 0L) {
               var14 = var12;
               if (var1.getSource() == 8194) {
                  var14 = var12;
                  if (var3 == 4) {
                     this.d.put(var9, var11);
                     var14 = var12;
                  }
               }
            }
         } else if (var10 == 2) {
            var14 = (long)(var1.getButtonState() >> 4 & 15);
         } else {
            var14 = 0L;
         }

         boolean var16 = this.d.containsKey(var9);
         if (var16) {
            var8 = this.e(var3);
            if (var8 == -1) {
               return;
            }
         }

         if (this.c) {
            var12 = this.b.c(var1).d();
         } else {
            var12 = 0L;
         }

         byte var17;
         if (var1.getActionMasked() == 8) {
            var17 = 1;
         } else {
            var17 = 0;
         }

         long var18 = var1.getEventTime();
         var6.putLong(var12);
         var6.putLong(var18 * 1000L);
         if (var16) {
            var6.putLong((long)var8);
            var12 = 4L;
         } else {
            var6.putLong((long)var3);
            var12 = (long)var10;
         }

         var6.putLong(var12);
         var6.putLong((long)var17);
         var6.putLong((long)var9);
         var6.putLong(0L);
         double var20;
         if (var16) {
            float[] var29 = (float[])this.d.get(var9);
            var6.putDouble((double)var29[0]);
            var20 = (double)var29[1];
         } else {
            var6.putDouble((double)var11[0]);
            var20 = (double)var11[1];
         }

         double var22;
         label81: {
            var6.putDouble(var20);
            var6.putDouble(0.0D);
            var6.putDouble(0.0D);
            var6.putLong(var14);
            var6.putLong(0L);
            var6.putLong(0L);
            var6.putDouble((double)var1.getPressure(var2));
            if (var1.getDevice() != null) {
               MotionRange var30 = var1.getDevice().getMotionRange(2);
               if (var30 != null) {
                  var22 = (double)var30.getMin();
                  var20 = (double)var30.getMax();
                  break label81;
               }
            }

            var20 = 1.0D;
            var22 = 0.0D;
         }

         var6.putDouble(var22);
         var6.putDouble(var20);
         if (var10 == 2) {
            var6.putDouble((double)var1.getAxisValue(24, var2));
         } else {
            var6.putDouble(0.0D);
         }

         var6.putDouble(0.0D);
         var6.putDouble((double)var1.getSize(var2));
         var6.putDouble((double)var1.getToolMajor(var2));
         var6.putDouble((double)var1.getToolMinor(var2));
         var6.putDouble(0.0D);
         var6.putDouble(0.0D);
         var6.putDouble((double)var1.getAxisValue(8, var2));
         if (var10 == 2) {
            var6.putDouble((double)var1.getAxisValue(25, var2));
         } else {
            var6.putDouble(0.0D);
         }

         var6.putLong((long)var4);
         if (var17 == 1) {
            var20 = 48.0D;
            if (var7 != null) {
               var20 = (double)this.c(var7);
               var22 = (double)this.g(var7);
            } else {
               var22 = 48.0D;
            }

            double var24 = (double)(-var1.getAxisValue(10, var2));
            double var26 = (double)(-var1.getAxisValue(9, var2));
            var6.putDouble(var20 * var24);
            var6.putDouble(var22 * var26);
         } else {
            var6.putDouble(0.0D);
            var6.putDouble(0.0D);
         }

         if (var16) {
            float[] var28 = (float[])this.d.get(var9);
            var6.putDouble((double)(var11[0] - var28[0]));
            var6.putDouble((double)(var11[1] - var28[1]));
         } else {
            var6.putDouble(0.0D);
            var6.putDouble(0.0D);
         }

         var6.putDouble(0.0D);
         var6.putDouble(0.0D);
         var6.putDouble(1.0D);
         var6.putDouble(0.0D);
         var6.putLong(0L);
         if (var16 && var8 == 9) {
            this.d.remove(var9);
         }

      }
   }

   private float c(Context var1) {
      return VERSION.SDK_INT >= 26 ? io.flutter.embedding.android.b.a(ViewConfiguration.get(var1)) : (float)this.i(var1);
   }

   private int d(int var1) {
      if (var1 == 0) {
         return 4;
      } else if (var1 == 1) {
         return 6;
      } else if (var1 == 5) {
         return 4;
      } else if (var1 == 6) {
         return 6;
      } else if (var1 == 2) {
         return 5;
      } else if (var1 == 7) {
         return 3;
      } else if (var1 == 3) {
         return 0;
      } else {
         return var1 == 8 ? 3 : -1;
      }
   }

   private int e(int var1) {
      if (var1 == 4) {
         return 7;
      } else if (var1 == 5) {
         return 8;
      } else {
         return var1 != 6 && var1 != 0 ? -1 : 9;
      }
   }

   private int f(int var1) {
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               return var1 != 4 ? 5 : 3;
            } else {
               return 1;
            }
         } else {
            return 2;
         }
      } else {
         return 0;
      }
   }

   private float g(Context var1) {
      return VERSION.SDK_INT >= 26 ? this.h(var1) : (float)this.i(var1);
   }

   private float h(Context var1) {
      return io.flutter.embedding.android.a.a(ViewConfiguration.get(var1));
   }

   private int i(Context var1) {
      if (this.e == 0) {
         TypedValue var2 = new TypedValue();
         if (!var1.getTheme().resolveAttribute(16842829, var2, true)) {
            return 48;
         }

         this.e = (int)var2.getDimension(var1.getResources().getDisplayMetrics());
      }

      return this.e;
   }

   public boolean j(MotionEvent var1, Context var2) {
      boolean var3 = var1.isFromSource(2);
      boolean var4;
      if (var1.getActionMasked() != 7 && var1.getActionMasked() != 8) {
         var4 = false;
      } else {
         var4 = true;
      }

      if (var3 && var4) {
         int var6 = this.d(var1.getActionMasked());
         ByteBuffer var5 = ByteBuffer.allocateDirect(var1.getPointerCount() * 36 * 8);
         var5.order(ByteOrder.LITTLE_ENDIAN);
         this.b(var1, var1.getActionIndex(), var6, 0, f, var5, var2);
         if (var5.position() % 288 == 0) {
            this.a.m(var5, var5.position());
            return true;
         } else {
            throw new AssertionError("Packet position is not on field boundary.");
         }
      } else {
         return false;
      }
   }

   public boolean k(MotionEvent var1) {
      return this.l(var1, f);
   }

   public boolean l(MotionEvent var1, Matrix var2) {
      int var3 = var1.getPointerCount();
      ByteBuffer var4 = ByteBuffer.allocateDirect(var3 * 36 * 8);
      var4.order(ByteOrder.LITTLE_ENDIAN);
      int var5 = var1.getActionMasked();
      int var6 = this.d(var1.getActionMasked());
      boolean var7;
      if (var5 != 0 && var5 != 5) {
         var7 = false;
      } else {
         var7 = true;
      }

      boolean var9;
      if (var7 || var5 != 1 && var5 != 6) {
         var9 = false;
      } else {
         var9 = true;
      }

      label45: {
         if (!var7) {
            int var10 = 0;
            byte var8 = 0;
            if (!var9) {
               while(true) {
                  if (var10 >= var3) {
                     break label45;
                  }

                  this.a(var1, var10, var6, 0, var2, var4);
                  ++var10;
               }
            }

            for(var5 = var8; var5 < var3; ++var5) {
               if (var5 != var1.getActionIndex() && var1.getToolType(var5) == 1) {
                  this.a(var1, var5, 5, 1, var2, var4);
               }
            }
         }

         this.a(var1, var1.getActionIndex(), var6, 0, var2, var4);
      }

      if (var4.position() % 288 == 0) {
         this.a.m(var4, var4.position());
         return true;
      } else {
         throw new AssertionError("Packet position is not on field boundary");
      }
   }
}
