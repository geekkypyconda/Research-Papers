package r0;

import a1.k;
import z0.p;

public abstract class a implements g.b {
   private final g.c<?> e;

   public a(g.c<?> var1) {
      k.e(var1, "key");
      super();
      this.e = var1;
   }

   public <E extends g.b> E b(g.c<E> var1) {
      return g.b.a.b(this, var1);
   }

   public g.c<?> getKey() {
      return this.e;
   }

   public g n(g var1) {
      return g.b.a.d(this, var1);
   }

   public g x(g.c<?> var1) {
      return g.b.a.c(this, var1);
   }

   public <R> R y(R var1, p<? super R, ? super g.b, ? extends R> var2) {
      return g.b.a.a(this, var1, var2);
   }
}
