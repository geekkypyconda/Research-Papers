package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.hardware.display.VirtualDisplay.Callback;
import android.os.Handler;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver.OnDrawListener;

class g0 {
   private static Callback i = new Callback() {
      public void onPaused() {
      }

      public void onResumed() {
      }
   };
   SingleViewPresentation a;
   private final Context b;
   private final a c;
   private final int d;
   private final int e;
   private final n f;
   private final OnFocusChangeListener g;
   private VirtualDisplay h;

   private g0(Context var1, a var2, VirtualDisplay var3, i var4, n var5, OnFocusChangeListener var6, int var7, Object var8) {
      this.b = var1;
      this.c = var2;
      this.f = var5;
      this.g = var6;
      this.e = var7;
      this.h = var3;
      this.d = var1.getResources().getDisplayMetrics().densityDpi;
      SingleViewPresentation var9 = new SingleViewPresentation(var1, this.h.getDisplay(), var4, var2, var7, var6);
      this.a = var9;
      var9.show();
   }

   public static g0 b(Context var0, a var1, i var2, n var3, int var4, int var5, int var6, Object var7, OnFocusChangeListener var8) {
      DisplayMetrics var9 = null;
      g0 var10 = var9;
      if (var4 != 0) {
         if (var5 == 0) {
            var10 = var9;
         } else {
            DisplayManager var11 = (DisplayManager)var0.getSystemService("display");
            var9 = var0.getResources().getDisplayMetrics();
            var3.a(var4, var5);
            StringBuilder var12 = new StringBuilder();
            var12.append("flutter-vd#");
            var12.append(var6);
            VirtualDisplay var13 = var11.createVirtualDisplay(var12.toString(), var4, var5, var9.densityDpi, var3.getSurface(), 0, i, (Handler)null);
            if (var13 == null) {
               return null;
            }

            var10 = new g0(var0, var1, var13, var2, var3, var8, var6, var7);
         }
      }

      return var10;
   }

   private void l(View var1, int var2, int var3, Runnable var4) {
      this.f.a(var2, var3);
      this.h.resize(var2, var3, this.d);
      this.h.setSurface(this.f.getSurface());
      var1.postDelayed(var4, 0L);
   }

   public void a() {
      this.h.setSurface((Surface)null);
   }

   public void c(MotionEvent var1) {
      SingleViewPresentation var2 = this.a;
      if (var2 != null) {
         var2.dispatchTouchEvent(var1);
      }
   }

   public void d() {
      this.a.cancel();
      this.a.detachState();
      this.h.release();
      this.f.release();
   }

   public int e() {
      n var1 = this.f;
      return var1 != null ? var1.getHeight() : 0;
   }

   public int f() {
      n var1 = this.f;
      return var1 != null ? var1.getWidth() : 0;
   }

   public View g() {
      SingleViewPresentation var1 = this.a;
      return var1 == null ? null : var1.getView().f();
   }

   void h() {
      SingleViewPresentation var1 = this.a;
      if (var1 != null && var1.getView() != null) {
         this.a.getView().e();
      }

   }

   void i() {
      SingleViewPresentation var1 = this.a;
      if (var1 != null && var1.getView() != null) {
         this.a.getView().d();
      }

   }

   public void j() {
      int var1 = this.f();
      int var2 = this.e();
      boolean var3 = this.g().isFocused();
      SingleViewPresentation.d var4 = this.a.detachState();
      this.h.setSurface((Surface)null);
      this.h.release();
      DisplayManager var5 = (DisplayManager)this.b.getSystemService("display");
      StringBuilder var6 = new StringBuilder();
      var6.append("flutter-vd#");
      var6.append(this.e);
      this.h = var5.createVirtualDisplay(var6.toString(), var1, var2, this.d, this.f.getSurface(), 0, i, (Handler)null);
      SingleViewPresentation var7 = new SingleViewPresentation(this.b, this.h.getDisplay(), this.c, var4, this.g, var3);
      var7.show();
      this.a.cancel();
      this.a = var7;
   }

   public void k(int var1, int var2, final Runnable var3) {
      if (var1 == this.f() && var2 == this.e()) {
         this.g().postDelayed(var3, 0L);
      } else if (VERSION.SDK_INT >= 31) {
         this.l(this.g(), var1, var2, var3);
      } else {
         boolean var4 = this.g().isFocused();
         SingleViewPresentation.d var5 = this.a.detachState();
         this.h.setSurface((Surface)null);
         this.h.release();
         DisplayManager var6 = (DisplayManager)this.b.getSystemService("display");
         this.f.a(var1, var2);
         StringBuilder var7 = new StringBuilder();
         var7.append("flutter-vd#");
         var7.append(this.e);
         this.h = var6.createVirtualDisplay(var7.toString(), var1, var2, this.d, this.f.getSurface(), 0, i, (Handler)null);
         final View var8 = this.g();
         var8.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View var1) {
               g0.c.a(var8, new Runnable() {
                  // $FF: synthetic field
                  final <undefinedtype> e;

                  {
                     this.e = var1;
                  }

                  public void run() {
                     <undefinedtype> var1 = this.e;
                     var1.a.postDelayed(var1.b, 128L);
                  }
               });
               var8.removeOnAttachStateChangeListener(this);
            }

            public void onViewDetachedFromWindow(View var1) {
            }
         });
         SingleViewPresentation var9 = new SingleViewPresentation(this.b, this.h.getDisplay(), this.c, var5, this.g, var4);
         var9.show();
         this.a.cancel();
         this.a = var9;
      }
   }

   static class c implements OnDrawListener {
      final View a;
      Runnable b;

      c(View var1, Runnable var2) {
         this.a = var1;
         this.b = var2;
      }

      static void a(View var0, Runnable var1) {
         g0.c var2 = new g0.c(var0, var1);
         var0.getViewTreeObserver().addOnDrawListener(var2);
      }

      public void onDraw() {
         Runnable var1 = this.b;
         if (var1 != null) {
            var1.run();
            this.b = null;
            this.a.post(new Runnable() {
               // $FF: synthetic field
               final g0.c e;

               {
                  this.e = var1;
               }

               public void run() {
                  this.e.a.getViewTreeObserver().removeOnDrawListener(this.e);
               }
            });
         }
      }
   }
}
