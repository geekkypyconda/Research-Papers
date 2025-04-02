package e1;

import a1.k;

public final class c {
   public static final <T> T a(b<T> var0, Object var1) {
      k.e(var0, "<this>");
      if (var0.d(var1)) {
         k.c(var1, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
         return var1;
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("Value cannot be cast to ");
         var2.append(var0.a());
         throw new ClassCastException(var2.toString());
      }
   }
}
