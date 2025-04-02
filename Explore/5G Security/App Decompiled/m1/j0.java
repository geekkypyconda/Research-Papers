package m1;

// $FF: synthetic class
final class j0 {
   private static final int a = Runtime.getRuntime().availableProcessors();

   public static final int a() {
      return a;
   }

   public static final String b(String var0) {
      try {
         var0 = System.getProperty(var0);
      } catch (SecurityException var1) {
         var0 = null;
      }

      return var0;
   }
}
