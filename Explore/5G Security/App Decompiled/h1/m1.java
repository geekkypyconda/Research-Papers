package h1;

import java.util.concurrent.CancellationException;

// $FF: synthetic class
final class m1 {
   public static final s a(h1 var0) {
      return new k1(var0);
   }

   // $FF: synthetic method
   public static s b(h1 var0, int var1, Object var2) {
      if ((var1 & 1) != 0) {
         var0 = null;
      }

      return l1.a(var0);
   }

   public static final void c(r0.g var0, CancellationException var1) {
      h1 var2 = (h1)var0.b(h1.b);
      if (var2 != null) {
         var2.c(var1);
      }

   }

   public static final void d(h1 var0) {
      if (!var0.d()) {
         throw var0.k();
      }
   }

   public static final void e(r0.g var0) {
      h1 var1 = (h1)var0.b(h1.b);
      if (var1 != null) {
         l1.d(var1);
      }

   }
}
