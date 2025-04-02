package h1;

public final class y {
   public static final <T> Object a(Object var0, r0.d<? super T> var1) {
      Object var2 = var0;
      if (var0 instanceof u) {
         p0.k.a var3 = p0.k.e;
         var2 = p0.l.a(((u)var0).a);
      }

      return p0.k.a(var2);
   }

   public static final <T> Object b(Object var0, j<?> var1) {
      Throwable var2 = p0.k.b(var0);
      if (var2 != null) {
         var0 = new u(var2, false, 2, (a1.g)null);
      }

      return var0;
   }

   public static final <T> Object c(Object var0, z0.l<? super Throwable, p0.q> var1) {
      Throwable var2 = p0.k.b(var0);
      Object var3;
      if (var2 == null) {
         var3 = var0;
         if (var1 != null) {
            var3 = new v(var0, var1);
         }
      } else {
         var3 = new u(var2, false, 2, (a1.g)null);
      }

      return var3;
   }

   // $FF: synthetic method
   public static Object d(Object var0, z0.l var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      return c(var0, var1);
   }
}
