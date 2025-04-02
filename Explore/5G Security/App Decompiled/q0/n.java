package q0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class n extends m {
   public static <T> ArrayList<T> c(T... var0) {
      a1.k.e(var0, "elements");
      ArrayList var1;
      if (var0.length == 0) {
         var1 = new ArrayList();
      } else {
         var1 = new ArrayList(new d(var0, true));
      }

      return var1;
   }

   public static final <T> Collection<T> d(T[] var0) {
      a1.k.e(var0, "<this>");
      return new d(var0, false);
   }

   public static <T> List<T> e() {
      return x.e;
   }

   public static <T> int f(List<? extends T> var0) {
      a1.k.e(var0, "<this>");
      return var0.size() - 1;
   }

   public static <T> List<T> g(T... var0) {
      a1.k.e(var0, "elements");
      List var1;
      if (var0.length > 0) {
         var1 = f.b(var0);
      } else {
         var1 = l.e();
      }

      return var1;
   }

   public static <T> List<T> h(List<? extends T> var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.size();
      if (var1 != 0) {
         if (var1 == 1) {
            var0 = l.b(var0.get(0));
         }
      } else {
         var0 = l.e();
      }

      return var0;
   }

   public static void i() {
      throw new ArithmeticException("Index overflow has happened.");
   }
}
