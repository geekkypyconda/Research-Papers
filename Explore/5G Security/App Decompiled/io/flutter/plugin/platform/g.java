package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.View.OnSystemUiVisibilityChangeListener;
import java.util.List;

public class g {
   private final Activity a;
   private final j0.k b;
   private final g.d c;
   private j0.k.j d;
   private int e;
   final j0.k.h f;

   public g(Activity var1, j0.k var2, g.d var3) {
      j0.k.h var4 = new j0.k.h() {
         public void a() {
            g.this.y();
         }

         public void b(j0.k.g var1) {
            g.this.F(var1);
         }

         public void c() {
            g.this.t();
         }

         public void d(j0.k.j var1) {
            g.this.C(var1);
         }

         public void e() {
            g.this.u();
         }

         public void f(String var1) {
            g.this.v(var1);
         }

         public void g(int var1) {
            g.this.B(var1);
         }

         public void h(boolean var1) {
            g.this.w(var1);
         }

         public void i(List<j0.k.l> var1) {
            g.this.A(var1);
         }

         public void j(String var1) {
            g.this.D(var1);
         }

         public void k(j0.k.c var1) {
            g.this.x(var1);
         }

         public void l(j0.k.k var1) {
            g.this.z(var1);
         }

         public boolean m() {
            return g.this.p();
         }

         public CharSequence n(j0.k.e var1) {
            return g.this.r(var1);
         }

         public void o(j0.k.i var1) {
            g.this.s(var1);
         }
      };
      this.f = var4;
      this.a = var1;
      this.b = var2;
      var2.l(var4);
      this.c = var3;
      this.e = 1280;
   }

   private void A(List<j0.k.l> var1) {
      int var2;
      if (var1.size() == 0) {
         var2 = 5894;
      } else {
         var2 = 1798;
      }

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         j0.k.l var4 = (j0.k.l)var1.get(var3);
         int var5 = null.b[var4.ordinal()];
         if (var5 != 1) {
            if (var5 == 2) {
               var2 = var2 & -513 & -3;
            }
         } else {
            var2 &= -5;
         }
      }

      this.e = var2;
      this.E();
   }

   private void B(int var1) {
      this.a.setRequestedOrientation(var1);
   }

   private void C(j0.k.j var1) {
      Window var2 = this.a.getWindow();
      androidx.core.view.c0 var3 = new androidx.core.view.c0(var2, var2.getDecorView());
      int var4 = VERSION.SDK_INT;
      if (var4 < 30) {
         var2.addFlags(Integer.MIN_VALUE);
         var2.clearFlags(201326592);
      }

      j0.k.d var5;
      int var6;
      if (var4 >= 23) {
         var5 = var1.b;
         if (var5 != null) {
            var6 = null.c[var5.ordinal()];
            if (var6 != 1) {
               if (var6 == 2) {
                  var3.b(false);
               }
            } else {
               var3.b(true);
            }
         }

         Integer var9 = var1.a;
         if (var9 != null) {
            var2.setStatusBarColor(var9);
         }
      }

      Boolean var10 = var1.c;
      if (var10 != null && var4 >= 29) {
         io.flutter.plugin.platform.d.a(var2, var10);
      }

      Integer var7;
      if (var4 >= 26) {
         var5 = var1.e;
         if (var5 != null) {
            var6 = null.c[var5.ordinal()];
            if (var6 != 1) {
               if (var6 == 2) {
                  var3.a(false);
               }
            } else {
               var3.a(true);
            }
         }

         var7 = var1.d;
         if (var7 != null) {
            var2.setNavigationBarColor(var7);
         }
      }

      var7 = var1.f;
      if (var7 != null && var4 >= 28) {
         io.flutter.plugin.platform.e.a(var2, var7);
      }

      Boolean var8 = var1.g;
      if (var8 != null && var4 >= 29) {
         io.flutter.plugin.platform.f.a(var2, var8);
      }

      this.d = var1;
   }

   private void D(String var1) {
      Intent var2 = new Intent();
      var2.setAction("android.intent.action.SEND");
      var2.setType("text/plain");
      var2.putExtra("android.intent.extra.TEXT", var1);
      this.a.startActivity(Intent.createChooser(var2, (CharSequence)null));
   }

   private boolean p() {
      ClipboardManager var1 = (ClipboardManager)this.a.getSystemService("clipboard");
      if (!var1.hasPrimaryClip()) {
         return false;
      } else {
         ClipDescription var2 = var1.getPrimaryClipDescription();
         return var2 == null ? false : var2.hasMimeType("text/*");
      }
   }

   private CharSequence r(j0.k.e param1) {
      // $FF: Couldn't be decompiled
   }

   private void s(j0.k.i var1) {
      if (var1 == j0.k.i.f) {
         this.a.getWindow().getDecorView().playSoundEffect(0);
      }

   }

   private void t() {
      g.d var1 = this.c;
      if (var1 == null || !var1.c()) {
         Activity var2 = this.a;
         if (!(var2 instanceof b.b)) {
            var2.finish();
         } else {
            ((b.b)var2).l();
            throw null;
         }
      }
   }

   private void u() {
      this.E();
   }

   private void v(String var1) {
      ((ClipboardManager)this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", var1));
   }

   private void w(boolean var1) {
      g.d var2 = this.c;
      if (var2 != null) {
         var2.h(var1);
      }

   }

   private void x(j0.k.c var1) {
      if (VERSION.SDK_INT < 28) {
         this.a.setTaskDescription(new TaskDescription(var1.b, (Bitmap)null, var1.a));
      } else {
         TaskDescription var2 = new TaskDescription(var1.b, 0, var1.a);
         this.a.setTaskDescription(var2);
      }

   }

   private void y() {
      final View var1 = this.a.getWindow().getDecorView();
      var1.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
         // $FF: synthetic method
         public static void a(Object var0, int var1x) {
            var0.b(var1x);
         }

         // $FF: synthetic method
         private void b(int var1x) {
            j0.k var2;
            boolean var3;
            if ((var1x & 4) == 0) {
               var2 = g.this.b;
               var3 = true;
            } else {
               var2 = g.this.b;
               var3 = false;
            }

            var2.m(var3);
         }

         public void onSystemUiVisibilityChange(int var1x) {
            var1.post(new h(this, var1x));
         }
      });
   }

   private void z(j0.k.k var1) {
      short var2;
      if (var1 == j0.k.k.f) {
         var2 = 1798;
      } else if (var1 == j0.k.k.g) {
         var2 = 3846;
      } else if (var1 == j0.k.k.h) {
         var2 = 5894;
      } else {
         if (var1 != j0.k.k.i || VERSION.SDK_INT < 29) {
            return;
         }

         var2 = 1792;
      }

      this.e = var2;
      this.E();
   }

   public void E() {
      this.a.getWindow().getDecorView().setSystemUiVisibility(this.e);
      j0.k.j var1 = this.d;
      if (var1 != null) {
         this.C(var1);
      }

   }

   void F(j0.k.g var1) {
      View var2;
      byte var4;
      label40: {
         var2 = this.a.getWindow().getDecorView();
         int var3 = null.a[var1.ordinal()];
         var4 = 1;
         if (var3 != 1) {
            if (var3 == 2) {
               break label40;
            }

            var4 = 3;
            if (var3 == 3) {
               break label40;
            }

            var4 = 4;
            if (var3 != 4) {
               if (var3 != 5) {
                  return;
               }
               break label40;
            }

            if (VERSION.SDK_INT < 23) {
               return;
            }

            var4 = 6;
         } else {
            var4 = 0;
         }

         var2.performHapticFeedback(var4);
         return;
      }

      var2.performHapticFeedback(var4);
   }

   public void q() {
      this.b.l((j0.k.h)null);
   }

   public interface d {
      boolean c();

      void h(boolean var1);
   }
}
