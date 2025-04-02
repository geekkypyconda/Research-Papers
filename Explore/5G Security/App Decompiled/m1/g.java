package m1;

import java.util.Collection;
import java.util.ServiceLoader;

public final class g {
   private static final Collection<h1.c0> a = f1.c.e(f1.c.a(ServiceLoader.load(h1.c0.class, h1.c0.class.getClassLoader()).iterator()));

   public static final Collection<h1.c0> a() {
      return a;
   }

   public static final void b(Throwable var0) {
      Thread var1 = Thread.currentThread();
      var1.getUncaughtExceptionHandler().uncaughtException(var1, var0);
   }
}
