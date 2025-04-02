package d1;

class f extends e {
   public static int a(int var0, int var1) {
      int var2 = var0;
      if (var0 < var1) {
         var2 = var1;
      }

      return var2;
   }

   public static long b(long var0, long var2) {
      long var4 = var0;
      if (var0 < var2) {
         var4 = var2;
      }

      return var4;
   }

   public static int c(int var0, int var1) {
      int var2 = var0;
      if (var0 > var1) {
         var2 = var1;
      }

      return var2;
   }

   public static long d(long var0, long var2) {
      long var4 = var0;
      if (var0 > var2) {
         var4 = var2;
      }

      return var4;
   }

   public static int e(int var0, int var1, int var2) {
      if (var1 <= var2) {
         if (var0 < var1) {
            return var1;
         } else {
            return var0 > var2 ? var2 : var0;
         }
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("Cannot coerce value to an empty range: maximum ");
         var3.append(var2);
         var3.append(" is less than minimum ");
         var3.append(var1);
         var3.append('.');
         throw new IllegalArgumentException(var3.toString());
      }
   }

   public static a f(int var0, int var1) {
      return a.h.a(var0, var1, -1);
   }

   public static c g(int var0, int var1) {
      return var1 <= Integer.MIN_VALUE ? c.i.a() : new c(var0, var1 - 1);
   }
}
