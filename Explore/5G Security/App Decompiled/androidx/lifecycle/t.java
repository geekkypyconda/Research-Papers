package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;

public final class t implements l {
   public static final t.b i = new t.b((a1.g)null);
   private static final t j = new t();
   private int a;
   private int b;
   private boolean c = true;
   private boolean d = true;
   private Handler e;
   private final m f = new m(this);
   private final Runnable g = new r(this);
   private final v.a h = new v.a() {
      public void a() {
      }

      public void b() {
         t.this.f();
      }

      public void c() {
         t.this.g();
      }
   };

   private t() {
   }

   // $FF: synthetic method
   public static void a(t var0) {
      j(var0);
   }

   private static final void j(t var0) {
      a1.k.e(var0, "this$0");
      var0.k();
      var0.m();
   }

   public static final l n() {
      return i.a();
   }

   public h b() {
      return this.f;
   }

   public final void e() {
      int var1 = this.b - 1;
      this.b = var1;
      if (var1 == 0) {
         Handler var2 = this.e;
         a1.k.b(var2);
         var2.postDelayed(this.g, 700L);
      }

   }

   public final void f() {
      int var1 = this.b + 1;
      this.b = var1;
      if (var1 == 1) {
         if (this.c) {
            this.f.g(h.a.ON_RESUME);
            this.c = false;
         } else {
            Handler var2 = this.e;
            a1.k.b(var2);
            var2.removeCallbacks(this.g);
         }
      }

   }

   public final void g() {
      int var1 = this.a + 1;
      this.a = var1;
      if (var1 == 1 && this.d) {
         this.f.g(h.a.ON_START);
         this.d = false;
      }

   }

   public final void h() {
      --this.a;
      this.m();
   }

   public final void i(Context var1) {
      a1.k.e(var1, "context");
      this.e = new Handler();
      this.f.g(h.a.ON_CREATE);
      var1 = var1.getApplicationContext();
      a1.k.c(var1, "null cannot be cast to non-null type android.app.Application");
      ((Application)var1).registerActivityLifecycleCallbacks(new f() {
         public void onActivityCreated(Activity var1, Bundle var2) {
            a1.k.e(var1, "activity");
            if (VERSION.SDK_INT < 29) {
               v.b.b(var1).e(t.this.h);
            }

         }

         public void onActivityPaused(Activity var1) {
            a1.k.e(var1, "activity");
            t.this.e();
         }

         public void onActivityPreCreated(Activity var1, Bundle var2) {
            a1.k.e(var1, "activity");
            t.a.a(var1, new f() {
               // $FF: synthetic field
               final t this$0;

               {
                  this.this$0 = var1;
               }

               public void onActivityPostResumed(Activity var1) {
                  a1.k.e(var1, "activity");
                  this.this$0.f();
               }

               public void onActivityPostStarted(Activity var1) {
                  a1.k.e(var1, "activity");
                  this.this$0.g();
               }
            });
         }

         public void onActivityStopped(Activity var1) {
            a1.k.e(var1, "activity");
            t.this.h();
         }
      });
   }

   public final void k() {
      if (this.b == 0) {
         this.c = true;
         this.f.g(h.a.ON_PAUSE);
      }

   }

   public final void m() {
      if (this.a == 0 && this.c) {
         this.f.g(h.a.ON_STOP);
         this.d = true;
      }

   }

   public static final class a {
      public static final t.a a = new t.a();

      private a() {
      }

      public static final void a(Activity var0, ActivityLifecycleCallbacks var1) {
         a1.k.e(var0, "activity");
         a1.k.e(var1, "callback");
         s.a(var0, var1);
      }
   }

   public static final class b {
      private b() {
      }

      // $FF: synthetic method
      public b(a1.g var1) {
         this();
      }

      public final l a() {
         return t.j;
      }

      public final void b(Context var1) {
         a1.k.e(var1, "context");
         t.j.i(var1);
      }
   }
}
