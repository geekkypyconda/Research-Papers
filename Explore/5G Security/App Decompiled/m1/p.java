package m1;

public final class p {
   public static final void a(int var0) {
      boolean var1 = true;
      if (var0 < 1) {
         var1 = false;
      }

      if (!var1) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Expected positive parallelism level, but got ");
         var2.append(var0);
         throw new IllegalArgumentException(var2.toString().toString());
      }
   }
}
