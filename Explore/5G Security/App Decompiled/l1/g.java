package l1;

public final class g<T> extends f<T, T> {
   public g(k1.c<? extends T> var1, r0.g var2, int var3, j1.a var4) {
      super(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public g(k1.c var1, r0.g var2, int var3, j1.a var4, int var5, a1.g var6) {
      if ((var5 & 2) != 0) {
         var2 = r0.h.e;
      }

      if ((var5 & 4) != 0) {
         var3 = -3;
      }

      if ((var5 & 8) != 0) {
         var4 = j1.a.e;
      }

      this(var1, (r0.g)var2, var3, var4);
   }

   protected d<T> f(r0.g var1, int var2, j1.a var3) {
      return new g(super.h, var1, var2, var3);
   }

   protected Object m(k1.d<? super T> var1, r0.d<? super p0.q> var2) {
      Object var3 = super.h.a(var1, var2);
      return var3 == s0.b.c() ? var3 : p0.q.a;
   }
}
