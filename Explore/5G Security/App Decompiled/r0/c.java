package r0;

import a1.k;
import java.io.Serializable;
import z0.p;

public final class c implements g, Serializable {
   private final g e;
   private final g.b f;

   public c(g var1, g.b var2) {
      k.e(var1, "left");
      k.e(var2, "element");
      super();
      this.e = var1;
      this.f = var2;
   }

   private final boolean a(g.b var1) {
      return k.a(this.b(var1.getKey()), var1);
   }

   private final boolean e(r0.c var1) {
      while(this.a(var1.f)) {
         g var2 = var1.e;
         if (!(var2 instanceof r0.c)) {
            k.c(var2, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            return this.a((g.b)var2);
         }

         var1 = (r0.c)var2;
      }

      return false;
   }

   private final int l() {
      int var1 = 2;
      r0.c var2 = this;

      while(true) {
         g var3 = var2.e;
         if (var3 instanceof r0.c) {
            var2 = (r0.c)var3;
         } else {
            var2 = null;
         }

         if (var2 == null) {
            return var1;
         }

         ++var1;
      }
   }

   public <E extends g.b> E b(g.c<E> var1) {
      k.e(var1, "key");
      r0.c var2 = this;

      while(true) {
         g.b var3 = var2.f.b(var1);
         if (var3 != null) {
            return var3;
         }

         g var4 = var2.e;
         if (!(var4 instanceof r0.c)) {
            return var4.b(var1);
         }

         var2 = (r0.c)var4;
      }
   }

   public boolean equals(Object var1) {
      boolean var2;
      label28: {
         if (this != var1) {
            if (!(var1 instanceof r0.c)) {
               break label28;
            }

            r0.c var3 = (r0.c)var1;
            if (var3.l() != this.l() || !var3.e(this)) {
               break label28;
            }
         }

         var2 = true;
         return var2;
      }

      var2 = false;
      return var2;
   }

   public int hashCode() {
      return this.e.hashCode() + this.f.hashCode();
   }

   public g n(g var1) {
      return g.a.a(this, var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append('[');
      var1.append((String)this.y("", null.f));
      var1.append(']');
      return var1.toString();
   }

   public g x(g.c<?> var1) {
      k.e(var1, "key");
      if (this.f.b(var1) != null) {
         return this.e;
      } else {
         g var2 = this.e.x(var1);
         Object var3;
         if (var2 == this.e) {
            var3 = this;
         } else if (var2 == h.e) {
            var3 = this.f;
         } else {
            var3 = new r0.c(var2, this.f);
         }

         return (g)var3;
      }
   }

   public <R> R y(R var1, p<? super R, ? super g.b, ? extends R> var2) {
      k.e(var2, "operation");
      return var2.h(this.e.y(var1, var2), this.f);
   }
}
