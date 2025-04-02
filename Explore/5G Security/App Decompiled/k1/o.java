package k1;

import m1.h0;

public final class o {
   private static final h0 a = new h0("NONE");
   private static final h0 b = new h0("PENDING");

   public static final <T> j<T> a(T var0) {
      Object var1 = var0;
      if (var0 == null) {
         var1 = l1.k.a;
      }

      return new n(var1);
   }

   // $FF: synthetic method
   public static final h0 b() {
      return a;
   }

   // $FF: synthetic method
   public static final h0 c() {
      return b;
   }

   public static final <T> c<T> d(m<? extends T> var0, r0.g var1, int var2, j1.a var3) {
      boolean var4 = false;
      boolean var5 = var4;
      if (var2 >= 0) {
         var5 = var4;
         if (var2 < 2) {
            var5 = true;
         }
      }

      return (c)((var5 || var2 == -2) && var3 == j1.a.f ? var0 : l.a(var0, var1, var2, var3));
   }
}
