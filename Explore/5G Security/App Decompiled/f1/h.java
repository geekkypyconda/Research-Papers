package f1;

import a1.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import z0.l;

class h extends g {
   public static <T, R> b<R> c(b<? extends T> var0, l<? super T, ? extends R> var1) {
      k.e(var0, "<this>");
      k.e(var1, "transform");
      return new i(var0, var1);
   }

   public static final <T, C extends Collection<? super T>> C d(b<? extends T> var0, C var1) {
      k.e(var0, "<this>");
      k.e(var1, "destination");
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(var2.next());
      }

      return var1;
   }

   public static <T> List<T> e(b<? extends T> var0) {
      k.e(var0, "<this>");
      return q0.l.h(f(var0));
   }

   public static final <T> List<T> f(b<? extends T> var0) {
      k.e(var0, "<this>");
      return (List)d(var0, new ArrayList());
   }
}
