package q0;

import java.lang.reflect.Array;

class g {
   public static final <T> T[] a(T[] var0, int var1) {
      a1.k.e(var0, "reference");
      Object var2 = Array.newInstance(var0.getClass().getComponentType(), var1);
      a1.k.c(var2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
      return (Object[])var2;
   }
}
