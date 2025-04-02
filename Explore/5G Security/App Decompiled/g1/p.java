package g1;

import java.util.NoSuchElementException;

class p extends o {
   public static final String X(String var0, int var1) {
      a1.k.e(var0, "<this>");
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2) {
         var0 = var0.substring(d1.d.c(var1, var0.length()));
         a1.k.d(var0, "this as java.lang.String).substring(startIndex)");
         return var0;
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("Requested character count ");
         var3.append(var1);
         var3.append(" is less than zero.");
         throw new IllegalArgumentException(var3.toString().toString());
      }
   }

   public static char Y(CharSequence var0) {
      a1.k.e(var0, "<this>");
      boolean var1;
      if (var0.length() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (!var1) {
         return var0.charAt(n.q(var0));
      } else {
         throw new NoSuchElementException("Char sequence is empty.");
      }
   }
}
