package y;

import android.util.Log;

public class b {
   public static void a(String var0, String var1) {
   }

   public static void b(String var0, String var1) {
      Log.e(var0, var1);
   }

   public static void c(String var0, String var1, Throwable var2) {
      Log.e(var0, var1, var2);
   }

   public static String d(Throwable var0) {
      return Log.getStackTraceString(var0);
   }

   public static void e(String var0, String var1) {
   }

   public static void f(String var0, String var1) {
   }

   public static void g(String var0, String var1) {
      Log.w(var0, var1);
   }

   public static void h(String var0, String var1, Throwable var2) {
      Log.w(var0, var1, var2);
   }
}
