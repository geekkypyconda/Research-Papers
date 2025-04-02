package t0;

import java.io.Serializable;
import p0.l;
import p0.q;

public abstract class a implements r0.d<Object>, e, Serializable {
   private final r0.d<Object> e;

   public a(r0.d<Object> var1) {
      this.e = var1;
   }

   public r0.d<q> d(Object var1, r0.d<?> var2) {
      a1.k.e(var2, "completion");
      throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
   }

   public final r0.d<Object> f() {
      return this.e;
   }

   public StackTraceElement j() {
      return g.d(this);
   }

   protected abstract Object k(Object var1);

   protected void m() {
   }

   public e o() {
      r0.d var1 = this.e;
      e var2;
      if (var1 instanceof e) {
         var2 = (e)var1;
      } else {
         var2 = null;
      }

      return var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Continuation at ");
      Object var2 = this.j();
      if (var2 == null) {
         var2 = this.getClass().getName();
      }

      var1.append(var2);
      return var1.toString();
   }

   public final void u(Object var1) {
      Object var2 = this;

      do {
         h.b((r0.d)var2);
         a var3 = (a)var2;
         var2 = var3.e;
         a1.k.b(var2);

         label44:
         try {
            var1 = var3.k(var1);
            if (var1 == s0.b.c()) {
               return;
            }

            var1 = p0.k.a(var1);
         } catch (Throwable var6) {
            p0.k.a var4 = p0.k.e;
            var1 = p0.k.a(l.a(var6));
            break label44;
         }

         var3.m();
      } while(var2 instanceof a);

      ((r0.d)var2).u(var1);
   }
}
