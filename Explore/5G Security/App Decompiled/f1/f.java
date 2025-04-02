package f1;

import a1.k;
import java.util.Iterator;

class f extends e {
   public static <T> b<T> a(final Iterator<? extends T> var0) {
      k.e(var0, "<this>");
      return b(new b<T>() {
         public Iterator<T> iterator() {
            return var0;
         }
      });
   }

   public static final <T> b<T> b(b<? extends T> var0) {
      k.e(var0, "<this>");
      if (!(var0 instanceof a)) {
         var0 = new a((b)var0);
      }

      return (b)var0;
   }
}
