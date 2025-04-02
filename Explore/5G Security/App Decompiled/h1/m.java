package h1;

public final class m {
   public static final <T> k<T> a(r0.d<? super T> var0) {
      if (!(var0 instanceof m1.j)) {
         return new k(var0, 1);
      } else {
         k var1 = ((m1.j)var0).j();
         if (var1 != null) {
            if (!var1.J()) {
               var1 = null;
            }

            if (var1 != null) {
               return var1;
            }
         }

         return new k(var0, 2);
      }
   }
}
