package e;

class b {
   static final int[] a = new int[0];
   static final long[] b = new long[0];
   static final Object[] c = new Object[0];

   static int a(int[] var0, int var1, int var2) {
      --var1;
      int var3 = 0;

      while(var3 <= var1) {
         int var4 = var3 + var1 >>> 1;
         int var5 = var0[var4];
         if (var5 < var2) {
            var3 = var4 + 1;
         } else {
            if (var5 <= var2) {
               return var4;
            }

            var1 = var4 - 1;
         }
      }

      return var3;
   }

   public static boolean b(Object var0, Object var1) {
      boolean var2;
      if (var0 == var1 || var0 != null && var0.equals(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }
}
