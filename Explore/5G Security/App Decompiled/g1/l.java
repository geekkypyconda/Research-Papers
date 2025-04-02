package g1;

class l extends k {
   public static Long f(String var0) {
      a1.k.e(var0, "<this>");
      return g(var0, 10);
   }

   public static final Long g(String var0, int var1) {
      a1.k.e(var0, "<this>");
      a.a(var1);
      int var2 = var0.length();
      if (var2 == 0) {
         return null;
      } else {
         int var3;
         int var5;
         long var6;
         boolean var8;
         label56: {
            var3 = 0;
            char var4 = var0.charAt(0);
            var5 = a1.k.f(var4, 48);
            var6 = -9223372036854775807L;
            var8 = true;
            if (var5 < 0) {
               if (var2 == 1) {
                  return null;
               }

               if (var4 == '-') {
                  var6 = Long.MIN_VALUE;
                  var3 = 1;
                  break label56;
               }

               if (var4 != '+') {
                  return null;
               }

               var3 = 1;
            }

            var8 = false;
         }

         long var9 = 0L;
         long var11 = -256204778801521550L;

         while(true) {
            if (var3 >= var2) {
               Long var15;
               if (var8) {
                  var15 = var9;
               } else {
                  var15 = -var9;
               }

               return var15;
            }

            var5 = a.b(var0.charAt(var3), var1);
            if (var5 < 0) {
               return null;
            }

            long var13 = var11;
            if (var9 < var11) {
               if (var11 != -256204778801521550L) {
                  break;
               }

               var11 = var6 / (long)var1;
               var13 = var11;
               if (var9 < var11) {
                  break;
               }
            }

            var9 *= (long)var1;
            var11 = (long)var5;
            if (var9 < var6 + var11) {
               return null;
            }

            var9 -= var11;
            ++var3;
            var11 = var13;
         }

         return null;
      }
   }
}
