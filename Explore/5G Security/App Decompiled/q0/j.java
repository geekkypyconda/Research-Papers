package q0;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class j extends i {
   public static final <T> boolean f(T[] var0, T var1) {
      a1.k.e(var0, "<this>");
      boolean var2;
      if (i(var0, var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static <T> List<T> g(T[] var0, int var1) {
      a1.k.e(var0, "<this>");
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2) {
         return l(var0, d1.d.a(var0.length - var1, 0));
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("Requested element count ");
         var3.append(var1);
         var3.append(" is less than zero.");
         throw new IllegalArgumentException(var3.toString().toString());
      }
   }

   public static final <T> int h(T[] var0) {
      a1.k.e(var0, "<this>");
      return var0.length - 1;
   }

   public static final <T> int i(T[] var0, T var1) {
      a1.k.e(var0, "<this>");
      byte var2 = 0;
      int var3 = 0;
      if (var1 == null) {
         for(int var5 = var0.length; var3 < var5; ++var3) {
            if (var0[var3] == null) {
               return var3;
            }
         }
      } else {
         int var4 = var0.length;

         for(var3 = var2; var3 < var4; ++var3) {
            if (a1.k.a(var1, var0[var3])) {
               return var3;
            }
         }
      }

      return -1;
   }

   public static char j(char[] var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.length;
      if (var1 != 0) {
         if (var1 == 1) {
            return var0[0];
         } else {
            throw new IllegalArgumentException("Array has more than one element.");
         }
      } else {
         throw new NoSuchElementException("Array is empty.");
      }
   }

   public static <T> T k(T[] var0) {
      a1.k.e(var0, "<this>");
      Object var1;
      if (var0.length == 1) {
         var1 = var0[0];
      } else {
         var1 = null;
      }

      return var1;
   }

   public static final <T> List<T> l(T[] var0, int var1) {
      a1.k.e(var0, "<this>");
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (!var2) {
         StringBuilder var4 = new StringBuilder();
         var4.append("Requested element count ");
         var4.append(var1);
         var4.append(" is less than zero.");
         throw new IllegalArgumentException(var4.toString().toString());
      } else if (var1 == 0) {
         return l.e();
      } else {
         int var5 = var0.length;
         if (var1 >= var5) {
            return m(var0);
         } else if (var1 == 1) {
            return l.b(var0[var5 - 1]);
         } else {
            ArrayList var3 = new ArrayList(var1);

            for(var1 = var5 - var1; var1 < var5; ++var1) {
               var3.add(var0[var1]);
            }

            return var3;
         }
      }
   }

   public static final <T> List<T> m(T[] var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.length;
      List var2;
      if (var1 != 0) {
         if (var1 != 1) {
            var2 = n(var0);
         } else {
            var2 = l.b(var0[0]);
         }
      } else {
         var2 = l.e();
      }

      return var2;
   }

   public static final <T> List<T> n(T[] var0) {
      a1.k.e(var0, "<this>");
      return new ArrayList(n.d(var0));
   }
}
