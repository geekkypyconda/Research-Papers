package q0;

import java.util.Set;

class i0 extends h0 {
   public static final <T> Set<T> b() {
      return z.e;
   }

   public static final <T> Set<T> c(Set<? extends T> var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.size();
      if (var1 != 0) {
         if (var1 == 1) {
            var0 = h0.a(var0.iterator().next());
         }
      } else {
         var0 = b();
      }

      return var0;
   }
}
