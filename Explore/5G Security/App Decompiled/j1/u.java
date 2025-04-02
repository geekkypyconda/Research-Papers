package j1;

public interface u<E> {
   Object e(E var1, r0.d<? super p0.q> var2);

   boolean p(Throwable var1);

   Object q(E var1);

   boolean w();

   void z(z0.l<? super Throwable, p0.q> var1);

   public static final class a {
      // $FF: synthetic method
      public static boolean a(u var0, Throwable var1, int var2, Object var3) {
         if (var3 == null) {
            if ((var2 & 1) != 0) {
               var1 = null;
            }

            return var0.p(var1);
         } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
         }
      }
   }
}
