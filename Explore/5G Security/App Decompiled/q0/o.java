package q0;

import java.util.Collection;

class o extends n {
   public static <T> int j(Iterable<? extends T> var0, int var1) {
      a1.k.e(var0, "<this>");
      if (var0 instanceof Collection) {
         var1 = ((Collection)var0).size();
      }

      return var1;
   }
}
