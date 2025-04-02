package m1;

// $FF: synthetic class
final class k0 {
   public static final int a(String var0, int var1, int var2, int var3) {
      return (int)i0.c(var0, (long)var1, (long)var2, (long)var3);
   }

   public static final long b(String var0, long var1, long var3, long var5) {
      String var7 = i0.d(var0);
      if (var7 == null) {
         return var1;
      } else {
         Long var8 = g1.d.f(var7);
         if (var8 != null) {
            var1 = var8;
            boolean var9 = false;
            boolean var10 = var9;
            if (var3 <= var1) {
               var10 = var9;
               if (var1 <= var5) {
                  var10 = true;
               }
            }

            if (var10) {
               return var1;
            } else {
               StringBuilder var11 = new StringBuilder();
               var11.append("System property '");
               var11.append(var0);
               var11.append("' should be in range ");
               var11.append(var3);
               var11.append("..");
               var11.append(var5);
               var11.append(", but is '");
               var11.append(var1);
               var11.append('\'');
               throw new IllegalStateException(var11.toString().toString());
            }
         } else {
            StringBuilder var12 = new StringBuilder();
            var12.append("System property '");
            var12.append(var0);
            var12.append("' has unrecognized value '");
            var12.append(var7);
            var12.append('\'');
            throw new IllegalStateException(var12.toString().toString());
         }
      }
   }

   public static final String c(String var0, String var1) {
      var0 = i0.d(var0);
      if (var0 == null) {
         var0 = var1;
      }

      return var0;
   }

   public static final boolean d(String var0, boolean var1) {
      var0 = i0.d(var0);
      if (var0 != null) {
         var1 = Boolean.parseBoolean(var0);
      }

      return var1;
   }

   // $FF: synthetic method
   public static int e(String var0, int var1, int var2, int var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var2 = 1;
      }

      if ((var4 & 8) != 0) {
         var3 = Integer.MAX_VALUE;
      }

      return i0.b(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static long f(String var0, long var1, long var3, long var5, int var7, Object var8) {
      if ((var7 & 4) != 0) {
         var3 = 1L;
      }

      if ((var7 & 8) != 0) {
         var5 = Long.MAX_VALUE;
      }

      return i0.c(var0, var1, var3, var5);
   }
}
