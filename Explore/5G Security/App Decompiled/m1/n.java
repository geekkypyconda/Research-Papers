package m1;

import java.util.ArrayList;

public final class n<E> {
   public static <E> Object a(Object var0) {
      return var0;
   }

   // $FF: synthetic method
   public static Object b(Object var0, int var1, a1.g var2) {
      if ((var1 & 1) != 0) {
         var0 = null;
      }

      return a(var0);
   }

   public static final Object c(Object var0, E var1) {
      if (var0 == null) {
         var0 = a(var1);
      } else if (var0 instanceof ArrayList) {
         a1.k.c(var0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
         ((ArrayList)var0).add(var1);
         var0 = a(var0);
      } else {
         ArrayList var2 = new ArrayList(4);
         var2.add(var0);
         var2.add(var1);
         var0 = a(var2);
      }

      return var0;
   }
}
