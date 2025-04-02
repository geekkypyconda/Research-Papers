package q0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class m {
   public static final <T> Object[] a(T[] var0, boolean var1) {
      a1.k.e(var0, "<this>");
      if (!var1 || !a1.k.a(var0.getClass(), Object[].class)) {
         var0 = Arrays.copyOf(var0, var0.length, Object[].class);
         a1.k.d(var0, "copyOf(this, this.size, Array<Any?>::class.java)");
      }

      return var0;
   }

   public static <T> List<T> b(T var0) {
      List var1 = Collections.singletonList(var0);
      a1.k.d(var1, "singletonList(element)");
      return var1;
   }
}
