package h1;

// $FF: synthetic class
final class g {
   public static final h1 a(e0 var0, r0.g var1, g0 var2, z0.p<? super e0, ? super r0.d<? super p0.q>, ? extends Object> var3) {
      r0.g var4 = a0.d(var0, var1);
      Object var5;
      if (var2.c()) {
         var5 = new q1(var4, var3);
      } else {
         var5 = new w1(var4, true);
      }

      ((a)var5).J0(var2, var5, var3);
      return (h1)var5;
   }

   // $FF: synthetic method
   public static h1 b(e0 var0, r0.g var1, g0 var2, z0.p var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = r0.h.e;
      }

      if ((var4 & 2) != 0) {
         var2 = g0.e;
      }

      return f.a(var0, (r0.g)var1, var2, var3);
   }
}
