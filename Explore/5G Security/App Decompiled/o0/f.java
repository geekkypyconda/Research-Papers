package o0;

public final class f implements AutoCloseable {
   private f(String var1) {
      a(var1);
   }

   public static void a(String var0) {
      l.a.c(c(var0));
   }

   public static void b(String var0, int var1) {
      l.a.a(c(var0), var1);
   }

   private static String c(String var0) {
      if (var0.length() >= 124) {
         StringBuilder var1 = new StringBuilder();
         var1.append(var0.substring(0, 124));
         var1.append("...");
         var0 = var1.toString();
      }

      return var0;
   }

   public static void d() {
      l.a.f();
   }

   public static void e(String var0, int var1) {
      l.a.d(c(var0), var1);
   }

   public static f f(String var0) {
      return new f(var0);
   }

   public void close() {
      d();
   }
}
