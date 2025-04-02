package m1;

public class d0<T> extends h1.a<T> implements t0.e {
   public final r0.d<T> h;

   public d0(r0.g var1, r0.d<? super T> var2) {
      super(var1, true, true);
      this.h = var2;
   }

   protected void G0(Object var1) {
      r0.d var2 = this.h;
      var2.u(h1.y.a(var1, var2));
   }

   protected void H(Object var1) {
      k.c(s0.b.b(this.h), h1.y.a(var1, this.h), (z0.l)null, 2, (Object)null);
   }

   protected final boolean h0() {
      return true;
   }

   public final t0.e o() {
      r0.d var1 = this.h;
      t0.e var2;
      if (var1 instanceof t0.e) {
         var2 = (t0.e)var1;
      } else {
         var2 = null;
      }

      return var2;
   }
}
