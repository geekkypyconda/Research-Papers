package t0;

public final class g {
   private static final void a(int var0, int var1) {
      if (var1 > var0) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Debug metadata version mismatch. Expected: ");
         var2.append(var0);
         var2.append(", got ");
         var2.append(var1);
         var2.append(". Please update the Kotlin standard library.");
         throw new IllegalStateException(var2.toString().toString());
      }
   }

   private static final f b(a var0) {
      return (f)var0.getClass().getAnnotation(f.class);
   }

   private static final int c(a param0) {
      // $FF: Couldn't be decompiled
   }

   public static final StackTraceElement d(a var0) {
      a1.k.e(var0, "<this>");
      f var1 = b(var0);
      if (var1 == null) {
         return null;
      } else {
         a(1, var1.v());
         int var2 = c(var0);
         if (var2 < 0) {
            var2 = -1;
         } else {
            var2 = var1.l()[var2];
         }

         String var3 = i.a.b(var0);
         String var4;
         if (var3 == null) {
            var4 = var1.c();
         } else {
            StringBuilder var5 = new StringBuilder();
            var5.append(var3);
            var5.append('/');
            var5.append(var1.c());
            var4 = var5.toString();
         }

         return new StackTraceElement(var4, var1.m(), var1.f(), var2);
      }
   }
}
