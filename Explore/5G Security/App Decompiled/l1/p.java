package l1;

final class p<T> implements r0.d<T>, t0.e {
   private final r0.d<T> e;
   private final r0.g f;

   public p(r0.d<? super T> var1, r0.g var2) {
      this.e = var1;
      this.f = var2;
   }

   public r0.g a() {
      return this.f;
   }

   public t0.e o() {
      r0.d var1 = this.e;
      t0.e var2;
      if (var1 instanceof t0.e) {
         var2 = (t0.e)var1;
      } else {
         var2 = null;
      }

      return var2;
   }

   public void u(Object var1) {
      this.e.u(var1);
   }
}
