package k1;

class b<T> extends l1.d<T> {
   private final z0.p<j1.r<? super T>, r0.d<? super p0.q>, Object> h;

   public b(z0.p<? super j1.r<? super T>, ? super r0.d<? super p0.q>, ? extends Object> var1, r0.g var2, int var3, j1.a var4) {
      super(var2, var3, var4);
      this.h = var1;
   }

   // $FF: synthetic method
   static <T> Object j(b<T> var0, j1.r<? super T> var1, r0.d<? super p0.q> var2) {
      Object var3 = var0.h.h(var1, var2);
      return var3 == s0.b.c() ? var3 : p0.q.a;
   }

   protected Object e(j1.r<? super T> var1, r0.d<? super p0.q> var2) {
      return j(this, var1, var2);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("block[");
      var1.append(this.h);
      var1.append("] -> ");
      var1.append(super.toString());
      return var1.toString();
   }
}
