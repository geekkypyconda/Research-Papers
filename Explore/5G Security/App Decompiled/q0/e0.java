package q0;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class e0 extends d0 {
   public static final <K, V> Map<K, V> d() {
      y var0 = y.e;
      a1.k.c(var0, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
      return var0;
   }

   public static final <K, V> Map<K, V> e(Map<K, ? extends V> var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.size();
      if (var1 != 0) {
         if (var1 == 1) {
            var0 = d0.c(var0);
         }
      } else {
         var0 = d();
      }

      return var0;
   }

   public static final <K, V> void f(Map<? super K, ? super V> var0, Iterable<? extends p0.j<? extends K, ? extends V>> var1) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "pairs");
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         p0.j var2 = (p0.j)var3.next();
         var0.put(var2.a(), var2.b());
      }

   }

   public static <K, V> Map<K, V> g(Iterable<? extends p0.j<? extends K, ? extends V>> var0) {
      a1.k.e(var0, "<this>");
      if (var0 instanceof Collection) {
         Collection var1 = (Collection)var0;
         int var2 = var1.size();
         Map var3;
         if (var2 != 0) {
            if (var2 != 1) {
               var3 = h(var0, new LinkedHashMap(b0.a(var1.size())));
            } else {
               Object var4;
               if (var0 instanceof List) {
                  var4 = ((List)var0).get(0);
               } else {
                  var4 = var0.iterator().next();
               }

               var3 = d0.b((p0.j)var4);
            }
         } else {
            var3 = d();
         }

         return var3;
      } else {
         return e(h(var0, new LinkedHashMap()));
      }
   }

   public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends p0.j<? extends K, ? extends V>> var0, M var1) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "destination");
      f(var1, var0);
      return var1;
   }
}
