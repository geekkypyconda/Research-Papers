package q0;

import java.util.Collection;
import java.util.Iterator;

class s extends r {
   public static <T> boolean k(Collection<? super T> var0, Iterable<? extends T> var1) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "elements");
      if (var1 instanceof Collection) {
         return var0.addAll((Collection)var1);
      } else {
         boolean var2 = false;
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            if (var0.add(var3.next())) {
               var2 = true;
            }
         }

         return var2;
      }
   }
}
