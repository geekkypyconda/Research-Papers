package l1;

import a1.t;
import m1.l0;

public final class e {
   // $FF: synthetic method
   public static final k1.d a(k1.d var0, r0.g var1) {
      return d(var0, var1);
   }

   public static final <T, V> Object b(r0.g var0, V var1, Object var2, z0.p<? super V, ? super r0.d<? super T>, ? extends Object> var3, r0.d<? super T> var4) {
      var2 = l0.c(var0, var2);

      try {
         p var5 = new p(var4, var0);
         var1 = ((z0.p)t.a(var3, 2)).h(var1, var5);
      } finally {
         l0.a(var0, var2);
      }

      if (var1 == s0.b.c()) {
         t0.h.c(var4);
      }

      return var1;
   }

   // $FF: synthetic method
   public static Object c(r0.g var0, Object var1, Object var2, z0.p var3, r0.d var4, int var5, Object var6) {
      if ((var5 & 4) != 0) {
         var2 = l0.b(var0);
      }

      return b(var0, var1, var2, var3, var4);
   }

   private static final <T> k1.d<T> d(k1.d<? super T> var0, r0.g var1) {
      if (!(var0 instanceof o)) {
         var0 = new q((k1.d)var0, var1);
      }

      return (k1.d)var0;
   }
}
