package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements k.a<ProfileInstallerInitializer.c> {
   // $FF: synthetic method
   public static void c(ProfileInstallerInitializer var0, Context var1) {
      var0.i(var1);
   }

   // $FF: synthetic method
   public static void d(Context var0) {
      j(var0);
   }

   // $FF: synthetic method
   public static void e(Context var0) {
      k(var0);
   }

   // $FF: synthetic method
   private void i(Context var1) {
      this.h(var1);
   }

   // $FF: synthetic method
   private static void j(Context var0) {
      l(var0);
   }

   // $FF: synthetic method
   private static void k(Context var0) {
      j.i(var0);
   }

   private static void l(Context var0) {
      (new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue())).execute(new m(var0));
   }

   public List<Class<? extends k.a<?>>> a() {
      return Collections.emptyList();
   }

   public ProfileInstallerInitializer.c f(Context var1) {
      if (VERSION.SDK_INT < 24) {
         return new ProfileInstallerInitializer.c();
      } else {
         this.g(var1.getApplicationContext());
         return new ProfileInstallerInitializer.c();
      }
   }

   void g(Context var1) {
      ProfileInstallerInitializer.a.c(new k(this, var1));
   }

   void h(Context var1) {
      Handler var2;
      if (VERSION.SDK_INT >= 28) {
         var2 = ProfileInstallerInitializer.b.a(Looper.getMainLooper());
      } else {
         var2 = new Handler(Looper.getMainLooper());
      }

      int var3 = (new Random()).nextInt(Math.max(1000, 1));
      var2.postDelayed(new l(var1), (long)(var3 + 5000));
   }

   private static class a {
      // $FF: synthetic method
      public static void a(Runnable var0, long var1) {
         b(var0, var1);
      }

      // $FF: synthetic method
      private static void b(Runnable var0, long var1) {
         var0.run();
      }

      public static void c(Runnable var0) {
         Choreographer.getInstance().postFrameCallback(new n(var0));
      }
   }

   private static class b {
      public static Handler a(Looper var0) {
         return c.e.a(var0);
      }
   }

   public static class c {
   }
}
