package q0;

import java.util.Arrays;
import java.util.List;

class i extends h {
   public static <T> List<T> b(T[] var0) {
      a1.k.e(var0, "<this>");
      List var1 = k.a(var0);
      a1.k.d(var1, "asList(this)");
      return var1;
   }

   public static final <T> T[] c(T[] var0, T[] var1, int var2, int var3, int var4) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "destination");
      System.arraycopy(var0, var3, var1, var2, var4 - var3);
      return var1;
   }

   // $FF: synthetic method
   public static Object[] d(Object[] var0, Object[] var1, int var2, int var3, int var4, int var5, Object var6) {
      if ((var5 & 2) != 0) {
         var2 = 0;
      }

      if ((var5 & 4) != 0) {
         var3 = 0;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.length;
      }

      return c(var0, var1, var2, var3, var4);
   }

   public static final <T> void e(T[] var0, T var1, int var2, int var3) {
      a1.k.e(var0, "<this>");
      Arrays.fill(var0, var2, var3, var1);
   }
}
