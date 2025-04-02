package h1;

public abstract class b0 extends r0.a implements r0.e {
   public static final b0.a f = new b0.a((a1.g)null);

   public b0() {
      super(r0.e.d);
   }

   public abstract void a(r0.g var1, Runnable var2);

   public <E extends r0.g.b> E b(r0.g.c<E> var1) {
      return r0.e.a.a(this, var1);
   }

   public boolean e(r0.g var1) {
      return true;
   }

   public final <T> r0.d<T> j(r0.d<? super T> var1) {
      return new m1.j(this, var1);
   }

   public b0 l(int var1) {
      m1.p.a(var1);
      return new m1.o(this, var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(i0.a(this));
      var1.append('@');
      var1.append(i0.b(this));
      return var1.toString();
   }

   public final void v(r0.d<?> var1) {
      a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
      ((m1.j)var1).p();
   }

   public r0.g x(r0.g.c<?> var1) {
      return r0.e.a.b(this, var1);
   }

   public static final class a extends r0.b<r0.e, b0> {
      private a() {
         super(r0.e.d, null.f);
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }
   }
}
