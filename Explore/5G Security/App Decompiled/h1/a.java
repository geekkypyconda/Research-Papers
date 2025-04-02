package h1;

public abstract class a<T> extends o1 implements r0.d<T>, e0 {
   private final r0.g g;

   public a(r0.g var1, boolean var2, boolean var3) {
      super(var3);
      if (var2) {
         this.d0((h1)var1.b(h1.b));
      }

      this.g = var1.n(this);
   }

   protected void G0(Object var1) {
      this.H(var1);
   }

   protected void H0(Throwable var1, boolean var2) {
   }

   protected void I0(T var1) {
   }

   public final <R> void J0(g0 var1, R var2, z0.p<? super R, ? super r0.d<? super T>, ? extends Object> var3) {
      var1.b(var3, var2, this);
   }

   protected String N() {
      StringBuilder var1 = new StringBuilder();
      var1.append(i0.a(this));
      var1.append(" was cancelled");
      return var1.toString();
   }

   public final r0.g a() {
      return this.g;
   }

   public final void c0(Throwable var1) {
      d0.a(this.g, var1);
   }

   public boolean d() {
      return super.d();
   }

   public String l0() {
      String var1 = a0.b(this.g);
      if (var1 == null) {
         return super.l0();
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append('"');
         var2.append(var1);
         var2.append("\":");
         var2.append(super.l0());
         return var2.toString();
      }
   }

   protected final void q0(Object var1) {
      if (var1 instanceof u) {
         u var2 = (u)var1;
         this.H0(var2.a, var2.a());
      } else {
         this.I0(var1);
      }

   }

   public r0.g r() {
      return this.g;
   }

   public final void u(Object var1) {
      var1 = this.j0(y.d(var1, (z0.l)null, 1, (Object)null));
      if (var1 != p1.b) {
         this.G0(var1);
      }
   }
}
