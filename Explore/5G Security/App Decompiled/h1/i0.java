package h1;

public final class i0 {
   public static final String a(Object var0) {
      return var0.getClass().getSimpleName();
   }

   public static final String b(Object var0) {
      return Integer.toHexString(System.identityHashCode(var0));
   }

   public static final String c(r0.d<?> var0) {
      String var5;
      if (var0 instanceof m1.j) {
         var5 = var0.toString();
      } else {
         Object var1;
         StringBuilder var7;
         label38:
         try {
            p0.k.a var6 = p0.k.e;
            var7 = new StringBuilder();
            var7.append(var0);
            var7.append('@');
            var7.append(b(var0));
            var1 = p0.k.a(var7.toString());
         } catch (Throwable var4) {
            p0.k.a var2 = p0.k.e;
            var1 = p0.k.a(p0.l.a(var4));
            break label38;
         }

         if (p0.k.b(var1) != null) {
            var7 = new StringBuilder();
            var7.append(var0.getClass().getName());
            var7.append('@');
            var7.append(b(var0));
            var1 = var7.toString();
         }

         var5 = (String)var1;
      }

      return var5;
   }
}
