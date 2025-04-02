package i1;

import a1.g;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.view.Choreographer;
import java.lang.reflect.Constructor;
import p0.k;
import p0.l;

public final class e {
   public static final d a;
   private static volatile Choreographer choreographer;

   static {
      Object var0 = null;

      Object var1;
      label32:
      try {
         k.a var5 = k.e;
         c var6 = new c(a(Looper.getMainLooper(), true), (String)null, 2, (g)null);
         var1 = k.a(var6);
      } catch (Throwable var4) {
         k.a var2 = k.e;
         var1 = k.a(l.a(var4));
         break label32;
      }

      if (k.c(var1)) {
         var1 = var0;
      }

      a = (d)var1;
   }

   public static final Handler a(Looper var0, boolean var1) {
      if (var1) {
         Object var4;
         if (VERSION.SDK_INT >= 28) {
            var4 = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke((Object)null, var0);
            a1.k.c(var4, "null cannot be cast to non-null type android.os.Handler");
         } else {
            Constructor var2;
            try {
               var2 = Handler.class.getDeclaredConstructor(Looper.class, Callback.class, Boolean.TYPE);
            } catch (NoSuchMethodException var3) {
               return new Handler(var0);
            }

            var4 = var2.newInstance(var0, null, Boolean.TRUE);
         }

         return (Handler)var4;
      } else {
         return new Handler(var0);
      }
   }
}
