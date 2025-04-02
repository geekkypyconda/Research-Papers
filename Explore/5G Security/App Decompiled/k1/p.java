package k1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

final class p extends l1.c<n<?>> {
   private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_state");
   private volatile Object _state;

   public p() {
   }

   // $FF: synthetic method
   public static final AtomicReferenceFieldUpdater c() {
      return a;
   }

   public boolean d(n<?> var1) {
      AtomicReferenceFieldUpdater var2 = a;
      if (var2.get(this) != null) {
         return false;
      } else {
         var2.set(this, o.b());
         return true;
      }
   }

   public final Object e(r0.d<? super p0.q> var1) {
      h1.k var2 = new h1.k(s0.b.b(var1), 1);
      var2.z();
      if (!androidx.concurrent.futures.b.a(c(), this, o.b(), var2)) {
         p0.k.a var3 = p0.k.e;
         var2.u(p0.k.a(p0.q.a));
      }

      Object var4 = var2.w();
      if (var4 == s0.b.c()) {
         t0.h.c(var1);
      }

      return var4 == s0.b.c() ? var4 : p0.q.a;
   }

   public r0.d<p0.q>[] f(n<?> var1) {
      a.set(this, (Object)null);
      return l1.b.a;
   }

   public final void g() {
      AtomicReferenceFieldUpdater var1 = a;

      while(true) {
         Object var2 = var1.get(this);
         if (var2 == null) {
            return;
         }

         if (var2 == o.c()) {
            return;
         }

         if (var2 == o.b()) {
            if (androidx.concurrent.futures.b.a(a, this, var2, o.c())) {
               return;
            }
         } else if (androidx.concurrent.futures.b.a(a, this, var2, o.b())) {
            h1.k var3 = (h1.k)var2;
            p0.k.a var4 = p0.k.e;
            var3.u(p0.k.a(p0.q.a));
            return;
         }
      }
   }

   public final boolean h() {
      Object var1 = a.getAndSet(this, o.b());
      a1.k.b(var1);
      boolean var2;
      if (var1 == o.c()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }
}
