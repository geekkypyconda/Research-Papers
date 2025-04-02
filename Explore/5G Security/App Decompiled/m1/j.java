package m1;

import h1.t0;
import h1.y1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class j<T> extends h1.n0<T> implements t0.e, r0.d<T> {
   private static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation");
   private volatile Object _reusableCancellableContinuation;
   public final h1.b0 h;
   public final r0.d<T> i;
   public Object j;
   public final Object k;

   public j(h1.b0 var1, r0.d<? super T> var2) {
      super(-1);
      this.h = var1;
      this.i = var2;
      this.j = m1.k.a();
      this.k = l0.b(this.a());
   }

   private final h1.k<?> k() {
      Object var1 = l.get(this);
      h1.k var2;
      if (var1 instanceof h1.k) {
         var2 = (h1.k)var1;
      } else {
         var2 = null;
      }

      return var2;
   }

   public r0.g a() {
      return this.i.a();
   }

   public void b(Object var1, Throwable var2) {
      if (var1 instanceof h1.v) {
         ((h1.v)var1).b.i(var2);
      }

   }

   public r0.d<T> c() {
      return this;
   }

   public Object h() {
      Object var1 = this.j;
      this.j = m1.k.a();
      return var1;
   }

   public final void i() {
      AtomicReferenceFieldUpdater var1 = l;

      while(var1.get(this) == m1.k.b) {
      }

   }

   public final h1.k<T> j() {
      AtomicReferenceFieldUpdater var1 = l;

      while(true) {
         Object var2 = var1.get(this);
         if (var2 == null) {
            l.set(this, m1.k.b);
            return null;
         }

         if (var2 instanceof h1.k) {
            if (androidx.concurrent.futures.b.a(l, this, var2, m1.k.b)) {
               return (h1.k)var2;
            }
         } else if (var2 != m1.k.b && !(var2 instanceof Throwable)) {
            StringBuilder var3 = new StringBuilder();
            var3.append("Inconsistent state ");
            var3.append(var2);
            throw new IllegalStateException(var3.toString().toString());
         }
      }
   }

   public final boolean m() {
      boolean var1;
      if (l.get(this) != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean n(Throwable var1) {
      AtomicReferenceFieldUpdater var2 = l;

      h0 var4;
      label21:
      do {
         Object var3;
         do {
            var3 = var2.get(this);
            var4 = m1.k.b;
            if (a1.k.a(var3, var4)) {
               continue label21;
            }

            if (var3 instanceof Throwable) {
               return true;
            }
         } while(!androidx.concurrent.futures.b.a(l, this, var3, (Object)null));

         return false;
      } while(!androidx.concurrent.futures.b.a(l, this, var4, var1));

      return true;
   }

   public t0.e o() {
      r0.d var1 = this.i;
      t0.e var2;
      if (var1 instanceof t0.e) {
         var2 = (t0.e)var1;
      } else {
         var2 = null;
      }

      return var2;
   }

   public final void p() {
      this.i();
      h1.k var1 = this.k();
      if (var1 != null) {
         var1.q();
      }

   }

   public final Throwable q(h1.j<?> var1) {
      AtomicReferenceFieldUpdater var2 = l;

      h0 var4;
      do {
         Object var3 = var2.get(this);
         var4 = m1.k.b;
         if (var3 != var4) {
            if (var3 instanceof Throwable) {
               if (androidx.concurrent.futures.b.a(l, this, var3, (Object)null)) {
                  return (Throwable)var3;
               }

               throw new IllegalArgumentException("Failed requirement.".toString());
            }

            StringBuilder var5 = new StringBuilder();
            var5.append("Inconsistent state ");
            var5.append(var3);
            throw new IllegalStateException(var5.toString().toString());
         }
      } while(!androidx.concurrent.futures.b.a(l, this, var4, var1));

      return null;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DispatchedContinuation[");
      var1.append(this.h);
      var1.append(", ");
      var1.append(h1.i0.c(this.i));
      var1.append(']');
      return var1.toString();
   }

   public void u(Object var1) {
      r0.g var2 = this.i.a();
      Object var3 = h1.y.d(var1, (z0.l)null, 1, (Object)null);
      if (this.h.e(var2)) {
         this.j = var3;
         super.g = 0;
         this.h.a(var2, this);
      } else {
         t0 var47 = y1.a.a();
         if (var47.z()) {
            this.j = var3;
            super.g = 0;
            var47.q(this);
         } else {
            var47.u(true);

            Throwable var10000;
            label359: {
               Object var4;
               r0.g var48;
               boolean var10001;
               try {
                  var48 = this.a();
                  var4 = l0.c(var48, this.k);
               } catch (Throwable var44) {
                  var10000 = var44;
                  var10001 = false;
                  break label359;
               }

               try {
                  this.i.u(var1);
                  p0.q var45 = p0.q.a;
               } finally {
                  try {
                     l0.a(var48, var4);
                  } catch (Throwable var41) {
                     var10000 = var41;
                     var10001 = false;
                     break label359;
                  }
               }

               label345:
               try {
                  while(var47.D()) {
                  }

                  return;
               } catch (Throwable var42) {
                  var10000 = var42;
                  var10001 = false;
                  break label345;
               }
            }

            Throwable var46 = var10000;

            try {
               this.g(var46, (Throwable)null);
            } finally {
               var47.o(true);
            }
         }
      }

   }
}
