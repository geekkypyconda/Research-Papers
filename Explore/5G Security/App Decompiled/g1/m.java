package g1;

import java.util.Collection;
import java.util.Iterator;
import q0.a0;

class m extends l {
   public static boolean h(CharSequence var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.length();
      boolean var2 = false;
      if (var1 != 0) {
         boolean var4;
         label35: {
            d1.c var3 = n.p(var0);
            if (!(var3 instanceof Collection) || !((Collection)var3).isEmpty()) {
               Iterator var5 = var3.iterator();

               while(var5.hasNext()) {
                  if (!a.c(var0.charAt(((a0)var5).nextInt()))) {
                     var4 = false;
                     break label35;
                  }
               }
            }

            var4 = true;
         }

         if (!var4) {
            return var2;
         }
      }

      var2 = true;
      return var2;
   }

   public static final boolean i(String var0, int var1, String var2, int var3, int var4, boolean var5) {
      a1.k.e(var0, "<this>");
      a1.k.e(var2, "other");
      if (!var5) {
         var5 = var0.regionMatches(var1, var2, var3, var4);
      } else {
         var5 = var0.regionMatches(var5, var1, var2, var3, var4);
      }

      return var5;
   }

   public static final String j(String var0, String var1, String var2, boolean var3) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "oldValue");
      a1.k.e(var2, "newValue");
      int var4 = 0;
      int var5 = n.s(var0, var1, 0, var3);
      if (var5 < 0) {
         return var0;
      } else {
         int var6 = var1.length();
         int var7 = d1.d.a(var6, 1);
         int var8 = var0.length() - var6 + var2.length();
         if (var8 < 0) {
            throw new OutOfMemoryError();
         } else {
            StringBuilder var9 = new StringBuilder(var8);

            int var10;
            do {
               var9.append(var0, var4, var5);
               var9.append(var2);
               var8 = var5 + var6;
               if (var5 >= var0.length()) {
                  break;
               }

               var10 = n.s(var0, var1, var5 + var7, var3);
               var4 = var8;
               var5 = var10;
            } while(var10 > 0);

            var9.append(var0, var8, var0.length());
            var0 = var9.toString();
            a1.k.d(var0, "stringBuilder.append(this, i, length).toString()");
            return var0;
         }
      }
   }

   // $FF: synthetic method
   public static String k(String var0, String var1, String var2, boolean var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = false;
      }

      return j(var0, var1, var2, var3);
   }

   public static final boolean l(String var0, String var1, boolean var2) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "prefix");
      return !var2 ? var0.startsWith(var1) : i(var0, 0, var1, 0, var1.length(), var2);
   }

   // $FF: synthetic method
   public static boolean m(String var0, String var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      return l(var0, var1, var2);
   }
}
