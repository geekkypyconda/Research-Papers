package r0;

import a1.k;
import z0.l;

public abstract class b<B extends g.b, E extends B> implements g.c<E> {
   private final l<g.b, E> e;
   private final g.c<?> f;

   public b(g.c<B> var1, l<? super g.b, ? extends E> var2) {
      k.e(var1, "baseKey");
      k.e(var2, "safeCast");
      super();
      this.e = var2;
      g.c var3 = var1;
      if (var1 instanceof b) {
         var3 = ((b)var1).f;
      }

      this.f = var3;
   }

   public final boolean a(g.c<?> var1) {
      k.e(var1, "key");
      boolean var2;
      if (var1 != this && this.f != var1) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public final E b(g.b var1) {
      k.e(var1, "element");
      return (g.b)this.e.i(var1);
   }
}
