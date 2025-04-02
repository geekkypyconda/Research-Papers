package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Build.VERSION;

public class v extends Fragment {
   public static final v.b b = new v.b((a1.g)null);
   private v.a a;

   private final void a(h.a var1) {
      if (VERSION.SDK_INT < 29) {
         v.b var2 = b;
         Activity var3 = this.getActivity();
         a1.k.d(var3, "activity");
         var2.a(var3, var1);
      }

   }

   private final void b(v.a var1) {
      if (var1 != null) {
         var1.a();
      }

   }

   private final void c(v.a var1) {
      if (var1 != null) {
         var1.b();
      }

   }

   private final void d(v.a var1) {
      if (var1 != null) {
         var1.c();
      }

   }

   public final void e(v.a var1) {
      this.a = var1;
   }

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      this.b(this.a);
      this.a(h.a.ON_CREATE);
   }

   public void onDestroy() {
      super.onDestroy();
      this.a(h.a.ON_DESTROY);
      this.a = null;
   }

   public void onPause() {
      super.onPause();
      this.a(h.a.ON_PAUSE);
   }

   public void onResume() {
      super.onResume();
      this.c(this.a);
      this.a(h.a.ON_RESUME);
   }

   public void onStart() {
      super.onStart();
      this.d(this.a);
      this.a(h.a.ON_START);
   }

   public void onStop() {
      super.onStop();
      this.a(h.a.ON_STOP);
   }

   public interface a {
      void a();

      void b();

      void c();
   }

   public static final class b {
      private b() {
      }

      // $FF: synthetic method
      public b(a1.g var1) {
         this();
      }

      public final void a(Activity var1, h.a var2) {
         a1.k.e(var1, "activity");
         a1.k.e(var2, "event");
         if (var1 instanceof n) {
            ((n)var1).b().g(var2);
         } else {
            if (var1 instanceof l) {
               h var3 = ((l)var1).b();
               if (var3 instanceof m) {
                  ((m)var3).g(var2);
               }
            }

         }
      }

      public final v b(Activity var1) {
         a1.k.e(var1, "<this>");
         Fragment var2 = var1.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
         a1.k.c(var2, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
         return (v)var2;
      }

      public final void c(Activity var1) {
         a1.k.e(var1, "activity");
         if (VERSION.SDK_INT >= 29) {
            v.c.Companion.a(var1);
         }

         FragmentManager var2 = var1.getFragmentManager();
         if (var2.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            var2.beginTransaction().add(new v(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            var2.executePendingTransactions();
         }

      }
   }

   public static final class c implements ActivityLifecycleCallbacks {
      public static final v.c.a Companion = new v.c.a((a1.g)null);

      public static final void registerIn(Activity var0) {
         Companion.a(var0);
      }

      public void onActivityCreated(Activity var1, Bundle var2) {
         a1.k.e(var1, "activity");
      }

      public void onActivityDestroyed(Activity var1) {
         a1.k.e(var1, "activity");
      }

      public void onActivityPaused(Activity var1) {
         a1.k.e(var1, "activity");
      }

      public void onActivityPostCreated(Activity var1, Bundle var2) {
         a1.k.e(var1, "activity");
         v.b.a(var1, h.a.ON_CREATE);
      }

      public void onActivityPostResumed(Activity var1) {
         a1.k.e(var1, "activity");
         v.b.a(var1, h.a.ON_RESUME);
      }

      public void onActivityPostStarted(Activity var1) {
         a1.k.e(var1, "activity");
         v.b.a(var1, h.a.ON_START);
      }

      public void onActivityPreDestroyed(Activity var1) {
         a1.k.e(var1, "activity");
         v.b.a(var1, h.a.ON_DESTROY);
      }

      public void onActivityPrePaused(Activity var1) {
         a1.k.e(var1, "activity");
         v.b.a(var1, h.a.ON_PAUSE);
      }

      public void onActivityPreStopped(Activity var1) {
         a1.k.e(var1, "activity");
         v.b.a(var1, h.a.ON_STOP);
      }

      public void onActivityResumed(Activity var1) {
         a1.k.e(var1, "activity");
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
         a1.k.e(var1, "activity");
         a1.k.e(var2, "bundle");
      }

      public void onActivityStarted(Activity var1) {
         a1.k.e(var1, "activity");
      }

      public void onActivityStopped(Activity var1) {
         a1.k.e(var1, "activity");
      }

      public static final class a {
         private a() {
         }

         // $FF: synthetic method
         public a(a1.g var1) {
            this();
         }

         public final void a(Activity var1) {
            a1.k.e(var1, "activity");
            s.a(var1, new v.c());
         }
      }
   }
}
