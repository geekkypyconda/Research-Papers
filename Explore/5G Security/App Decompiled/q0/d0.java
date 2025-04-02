package q0;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

class d0 extends c0 {
   public static int a(int var0) {
      if (var0 >= 0) {
         if (var0 < 3) {
            ++var0;
         } else if (var0 < 1073741824) {
            var0 = (int)((float)var0 / 0.75F + 1.0F);
         } else {
            var0 = Integer.MAX_VALUE;
         }
      }

      return var0;
   }

   public static final <K, V> Map<K, V> b(p0.j<? extends K, ? extends V> var0) {
      a1.k.e(var0, "pair");
      Map var1 = Collections.singletonMap(var0.c(), var0.d());
      a1.k.d(var1, "singletonMap(pair.first, pair.second)");
      return var1;
   }

   public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> var0) {
      a1.k.e(var0, "<this>");
      Entry var1 = (Entry)var0.entrySet().iterator().next();
      var0 = Collections.singletonMap(var1.getKey(), var1.getValue());
      a1.k.d(var0, "with(entries.iterator().…ingletonMap(key, value) }");
      return var0;
   }
}
