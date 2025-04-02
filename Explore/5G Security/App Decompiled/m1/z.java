package m1;

public final class z {
   public static final <E> z0.l<Throwable, p0.q> a(final z0.l<? super E, p0.q> var0, final E var1, final r0.g var2) {
      return new z0.l<Throwable, p0.q>() {
         public final void a(Throwable var1x) {
            z.b(var0, var1, var2);
         }
      };
   }

   public static final <E> void b(z0.l<? super E, p0.q> var0, E var1, r0.g var2) {
      q0 var3 = c(var0, var1, (q0)null);
      if (var3 != null) {
         h1.d0.a(var2, var3);
      }

   }

   public static final <E> q0 c(z0.l<? super E, p0.q> var0, E var1, q0 var2) {
      try {
         var0.i(var1);
      } catch (Throwable var4) {
         if (var2 == null || var2.getCause() == var4) {
            StringBuilder var5 = new StringBuilder();
            var5.append("Exception in undelivered element handler for ");
            var5.append(var1);
            return new q0(var5.toString(), var4);
         }

         p0.a.a(var2, var4);
         return var2;
      }

      return var2;
   }

   // $FF: synthetic method
   public static q0 d(z0.l var0, Object var1, q0 var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      return c(var0, var1, var2);
   }
}
