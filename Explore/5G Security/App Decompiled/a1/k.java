package a1;

import java.util.Arrays;

public class k {
   private k() {
   }

   public static boolean a(Object var0, Object var1) {
      boolean var2;
      if (var0 == null) {
         if (var1 == null) {
            var2 = true;
         } else {
            var2 = false;
         }
      } else {
         var2 = var0.equals(var1);
      }

      return var2;
   }

   public static void b(Object var0) {
      if (var0 == null) {
         j();
      }

   }

   public static void c(Object var0, String var1) {
      if (var0 == null) {
         k(var1);
      }

   }

   public static void d(Object var0, String var1) {
      if (var0 == null) {
         StringBuilder var2 = new StringBuilder();
         var2.append(var1);
         var2.append(" must not be null");
         throw (NullPointerException)h(new NullPointerException(var2.toString()));
      }
   }

   public static void e(Object var0, String var1) {
      if (var0 == null) {
         l(var1);
      }

   }

   public static int f(int var0, int var1) {
      byte var2;
      if (var0 < var1) {
         var2 = -1;
      } else if (var0 == var1) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      return var2;
   }

   private static String g(String var0) {
      StackTraceElement[] var1 = Thread.currentThread().getStackTrace();
      String var2 = k.class.getName();
      int var3 = 0;

      while(true) {
         int var4 = var3;
         if (var1[var3].getClassName().equals(var2)) {
            while(var1[var4].getClassName().equals(var2)) {
               ++var4;
            }

            StackTraceElement var6 = var1[var4];
            var2 = var6.getClassName();
            String var7 = var6.getMethodName();
            StringBuilder var5 = new StringBuilder();
            var5.append("Parameter specified as non-null is null: method ");
            var5.append(var2);
            var5.append(".");
            var5.append(var7);
            var5.append(", parameter ");
            var5.append(var0);
            return var5.toString();
         }

         ++var3;
      }
   }

   private static <T extends Throwable> T h(T var0) {
      return i(var0, k.class.getName());
   }

   static <T extends Throwable> T i(T var0, String var1) {
      StackTraceElement[] var2 = var0.getStackTrace();
      int var3 = var2.length;
      int var4 = -1;

      for(int var5 = 0; var5 < var3; ++var5) {
         if (var1.equals(var2[var5].getClassName())) {
            var4 = var5;
         }
      }

      var0.setStackTrace((StackTraceElement[])Arrays.copyOfRange(var2, var4 + 1, var3));
      return var0;
   }

   public static void j() {
      throw (NullPointerException)h(new NullPointerException());
   }

   public static void k(String var0) {
      throw (NullPointerException)h(new NullPointerException(var0));
   }

   private static void l(String var0) {
      throw (NullPointerException)h(new NullPointerException(g(var0)));
   }

   public static void m(String var0) {
      throw (p0.p)h(new p0.p(var0));
   }

   public static void n(String var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append("lateinit property ");
      var1.append(var0);
      var1.append(" has not been initialized");
      m(var1.toString());
   }
}
