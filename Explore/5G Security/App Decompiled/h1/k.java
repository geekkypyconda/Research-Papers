package h1;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class k<T> extends n0<T> implements j<T>, t0.e, c2 {
   private static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(k.class, "_decisionAndIndex");
   private static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_state");
   private static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_parentHandle");
   private volatile int _decisionAndIndex;
   private volatile Object _parentHandle;
   private volatile Object _state;
   private final r0.d<T> h;
   private final r0.g i;

   public k(r0.d<? super T> var1, int var2) {
      super(var2);
      this.h = var1;
      this.i = var1.a();
      this._decisionAndIndex = 536870911;
      this._state = d.e;
   }

   private final r0 A() {
      h1 var1 = (h1)this.a().b(h1.b);
      if (var1 == null) {
         return null;
      } else {
         r0 var2 = h1.a.d(var1, true, false, new o(this), 2, (Object)null);
         androidx.concurrent.futures.b.a(l, this, (Object)null, var2);
         return var2;
      }
   }

   private final void B(Object var1) {
      AtomicReferenceFieldUpdater var2 = k;

      Object var3;
      do {
         while(true) {
            var3 = var2.get(this);
            if (var3 instanceof d) {
               break;
            }

            boolean var4;
            if (var3 instanceof h) {
               var4 = true;
            } else {
               var4 = var3 instanceof m1.e0;
            }

            if (var4) {
               this.F(var1, var3);
            } else {
               var4 = var3 instanceof u;
               if (var4) {
                  u var7 = (u)var3;
                  if (!var7.b()) {
                     this.F(var1, var3);
                  }

                  if (var3 instanceof n) {
                     Throwable var8 = null;
                     if (!var4) {
                        var7 = null;
                     }

                     if (var7 != null) {
                        var8 = var7.a;
                     }

                     if (var1 instanceof h) {
                        this.j((h)var1, var8);
                     } else {
                        a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        this.m((m1.e0)var1, var8);
                     }
                  }

                  return;
               }

               t var9;
               if (var3 instanceof t) {
                  t var5 = (t)var3;
                  if (var5.b != null) {
                     this.F(var1, var3);
                  }

                  if (var1 instanceof m1.e0) {
                     return;
                  }

                  a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                  h var6 = (h)var1;
                  if (var5.c()) {
                     this.j(var6, var5.e);
                     return;
                  }

                  var9 = t.b(var5, (Object)null, var6, (z0.l)null, (Object)null, (Throwable)null, 29, (Object)null);
                  if (androidx.concurrent.futures.b.a(k, this, var3, var9)) {
                     return;
                  }
               } else {
                  if (var1 instanceof m1.e0) {
                     return;
                  }

                  a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                  var9 = new t(var3, (h)var1, (z0.l)null, (Object)null, (Throwable)null, 28, (a1.g)null);
                  if (androidx.concurrent.futures.b.a(k, this, var3, var9)) {
                     return;
                  }
               }
            }
         }
      } while(!androidx.concurrent.futures.b.a(k, this, var3, var1));

   }

   private final boolean E() {
      boolean var2;
      if (o0.c(super.g)) {
         r0.d var1 = this.h;
         a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
         if (((m1.j)var1).m()) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   private final void F(Object var1, Object var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("It's prohibited to register multiple handlers, tried to register ");
      var3.append(var1);
      var3.append(", already has ");
      var3.append(var2);
      throw new IllegalStateException(var3.toString().toString());
   }

   private final void L(Object var1, int var2, z0.l<? super Throwable, p0.q> var3) {
      AtomicReferenceFieldUpdater var4 = k;

      Object var5;
      Object var6;
      do {
         var5 = var4.get(this);
         if (!(var5 instanceof u1)) {
            if (var5 instanceof n) {
               n var7 = (n)var5;
               if (var7.c()) {
                  if (var3 != null) {
                     this.k(var3, var7.a);
                  }

                  return;
               }
            }

            this.i(var1);
            throw new p0.d();
         }

         var6 = this.N((u1)var5, var1, var2, var3, (Object)null);
      } while(!androidx.concurrent.futures.b.a(k, this, var5, var6));

      this.r();
      this.s(var2);
   }

   // $FF: synthetic method
   static void M(k var0, Object var1, int var2, z0.l var3, int var4, Object var5) {
      if (var5 == null) {
         if ((var4 & 4) != 0) {
            var3 = null;
         }

         var0.L(var1, var2, var3);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
      }
   }

   private final Object N(u1 var1, Object var2, int var3, z0.l<? super Throwable, p0.q> var4, Object var5) {
      Object var6;
      if (var2 instanceof u) {
         var6 = var2;
      } else if (!o0.b(var3) && var5 == null) {
         var6 = var2;
      } else {
         if (var4 == null && !(var1 instanceof h)) {
            var6 = var2;
            if (var5 == null) {
               return var6;
            }
         }

         h var7;
         if (var1 instanceof h) {
            var7 = (h)var1;
         } else {
            var7 = null;
         }

         var6 = new t(var2, var7, var4, var5, (Throwable)null, 16, (a1.g)null);
      }

      return var6;
   }

   private final boolean O() {
      AtomicIntegerFieldUpdater var1 = j;

      int var2;
      do {
         var2 = var1.get(this);
         int var3 = var2 >> 29;
         if (var3 != 0) {
            if (var3 == 1) {
               return false;
            } else {
               throw new IllegalStateException("Already resumed".toString());
            }
         }
      } while(!j.compareAndSet(this, var2, 1073741824 + (536870911 & var2)));

      return true;
   }

   private final m1.h0 P(Object var1, Object var2, z0.l<? super Throwable, p0.q> var3) {
      AtomicReferenceFieldUpdater var4 = k;

      Object var5;
      Object var6;
      do {
         var5 = var4.get(this);
         if (!(var5 instanceof u1)) {
            boolean var7 = var5 instanceof t;
            var3 = null;
            m1.h0 var8 = var3;
            if (var7) {
               var8 = var3;
               if (var2 != null) {
                  var8 = var3;
                  if (((t)var5).d == var2) {
                     var8 = h1.l.a;
                  }
               }
            }

            return var8;
         }

         var6 = this.N((u1)var5, var1, super.g, var3, var2);
      } while(!androidx.concurrent.futures.b.a(k, this, var5, var6));

      this.r();
      return h1.l.a;
   }

   private final boolean Q() {
      AtomicIntegerFieldUpdater var1 = j;

      int var2;
      do {
         var2 = var1.get(this);
         int var3 = var2 >> 29;
         if (var3 != 0) {
            if (var3 == 2) {
               return false;
            } else {
               throw new IllegalStateException("Already suspended".toString());
            }
         }
      } while(!j.compareAndSet(this, var2, 536870912 + (536870911 & var2)));

      return true;
   }

   private final Void i(Object var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Already resumed, but proposed with update ");
      var2.append(var1);
      throw new IllegalStateException(var2.toString().toString());
   }

   private final void m(m1.e0<?> var1, Throwable var2) {
      int var3 = j.get(this) & 536870911;
      boolean var4;
      if (var3 != 536870911) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var4) {
         try {
            var1.o(var3, var2, this.a());
         } catch (Throwable var7) {
            r0.g var8 = this.a();
            StringBuilder var9 = new StringBuilder();
            var9.append("Exception in invokeOnCancellation handler for ");
            var9.append(this);
            d0.a(var8, new x(var9.toString(), var7));
            return;
         }

      } else {
         throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
      }
   }

   private final boolean p(Throwable var1) {
      if (!this.E()) {
         return false;
      } else {
         r0.d var2 = this.h;
         a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
         return ((m1.j)var2).n(var1);
      }
   }

   private final void r() {
      if (!this.E()) {
         this.q();
      }

   }

   private final void s(int var1) {
      if (!this.O()) {
         o0.a(this, var1);
      }
   }

   private final r0 v() {
      return (r0)l.get(this);
   }

   private final String y() {
      Object var1 = this.x();
      String var2;
      if (var1 instanceof u1) {
         var2 = "Active";
      } else if (var1 instanceof n) {
         var2 = "Cancelled";
      } else {
         var2 = "Completed";
      }

      return var2;
   }

   public void C(Object var1) {
      this.s(super.g);
   }

   public boolean D() {
      return this.x() instanceof u1 ^ true;
   }

   protected String G() {
      return "CancellableContinuation";
   }

   public final void H(Throwable var1) {
      if (!this.p(var1)) {
         this.n(var1);
         this.r();
      }
   }

   public final void I() {
      r0.d var1 = this.h;
      m1.j var2;
      if (var1 instanceof m1.j) {
         var2 = (m1.j)var1;
      } else {
         var2 = null;
      }

      if (var2 != null) {
         Throwable var3 = var2.q(this);
         if (var3 != null) {
            this.q();
            this.n(var3);
         }
      }

   }

   public final boolean J() {
      AtomicReferenceFieldUpdater var1 = k;
      Object var2 = var1.get(this);
      if (var2 instanceof t && ((t)var2).d != null) {
         this.q();
         return false;
      } else {
         j.set(this, 536870911);
         var1.set(this, d.e);
         return true;
      }
   }

   public void K(T var1, z0.l<? super Throwable, p0.q> var2) {
      this.L(var1, super.g, var2);
   }

   public r0.g a() {
      return this.i;
   }

   public void b(Object var1, Throwable var2) {
      AtomicReferenceFieldUpdater var3 = k;

      while(true) {
         Object var4 = var3.get(this);
         if (var4 instanceof u1) {
            throw new IllegalStateException("Not completed".toString());
         }

         if (var4 instanceof u) {
            return;
         }

         if (var4 instanceof t) {
            t var5 = (t)var4;
            if (!(var5.c() ^ true)) {
               throw new IllegalStateException("Must be called at most once".toString());
            }

            t var6 = t.b(var5, (Object)null, (h)null, (z0.l)null, (Object)null, var2, 15, (Object)null);
            if (androidx.concurrent.futures.b.a(k, this, var4, var6)) {
               var5.d(this, var2);
               return;
            }
         } else if (androidx.concurrent.futures.b.a(k, this, var4, new t(var4, (h)null, (z0.l)null, (Object)null, var2, 14, (a1.g)null))) {
            return;
         }
      }
   }

   public final r0.d<T> c() {
      return this.h;
   }

   public void d(m1.e0<?> var1, int var2) {
      AtomicIntegerFieldUpdater var3 = j;

      int var4;
      do {
         var4 = var3.get(this);
         boolean var5;
         if ((var4 & 536870911) == 536870911) {
            var5 = true;
         } else {
            var5 = false;
         }

         if (!var5) {
            throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
         }
      } while(!var3.compareAndSet(this, var4, (var4 >> 29 << 29) + var2));

      this.B(var1);
   }

   public Throwable e(Object var1) {
      Throwable var2 = super.e(var1);
      if (var2 == null) {
         var2 = null;
      }

      return var2;
   }

   public <T> T f(Object var1) {
      Object var2 = var1;
      if (var1 instanceof t) {
         var2 = ((t)var1).a;
      }

      return var2;
   }

   public Object h() {
      return this.x();
   }

   public final void j(h var1, Throwable var2) {
      try {
         var1.f(var2);
      } catch (Throwable var5) {
         r0.g var3 = this.a();
         StringBuilder var6 = new StringBuilder();
         var6.append("Exception in invokeOnCancellation handler for ");
         var6.append(this);
         d0.a(var3, new x(var6.toString(), var5));
         return;
      }

   }

   public final void k(z0.l<? super Throwable, p0.q> var1, Throwable var2) {
      try {
         var1.i(var2);
      } catch (Throwable var5) {
         r0.g var6 = this.a();
         StringBuilder var3 = new StringBuilder();
         var3.append("Exception in resume onCancellation handler for ");
         var3.append(this);
         d0.a(var6, new x(var3.toString(), var5));
         return;
      }

   }

   public Object l(T var1, Object var2, z0.l<? super Throwable, p0.q> var3) {
      return this.P(var1, var2, var3);
   }

   public boolean n(Throwable var1) {
      AtomicReferenceFieldUpdater var2 = k;

      Object var3;
      n var6;
      do {
         var3 = var2.get(this);
         boolean var4 = var3 instanceof u1;
         boolean var5 = false;
         if (!var4) {
            return false;
         }

         if (var3 instanceof h || var3 instanceof m1.e0) {
            var5 = true;
         }

         var6 = new n(this, var1, var5);
      } while(!androidx.concurrent.futures.b.a(k, this, var3, var6));

      u1 var7 = (u1)var3;
      if (var7 instanceof h) {
         this.j((h)var3, var1);
      } else if (var7 instanceof m1.e0) {
         this.m((m1.e0)var3, var1);
      }

      this.r();
      this.s(super.g);
      return true;
   }

   public t0.e o() {
      r0.d var1 = this.h;
      t0.e var2;
      if (var1 instanceof t0.e) {
         var2 = (t0.e)var1;
      } else {
         var2 = null;
      }

      return var2;
   }

   public final void q() {
      r0 var1 = this.v();
      if (var1 != null) {
         var1.a();
         l.set(this, t1.e);
      }
   }

   public Throwable t(h1 var1) {
      return var1.k();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.G());
      var1.append('(');
      var1.append(i0.c(this.h));
      var1.append("){");
      var1.append(this.y());
      var1.append("}@");
      var1.append(i0.b(this));
      return var1.toString();
   }

   public void u(Object var1) {
      M(this, y.b(var1, this), super.g, (z0.l)null, 4, (Object)null);
   }

   public final Object w() {
      boolean var1 = this.E();
      if (this.Q()) {
         if (this.v() == null) {
            this.A();
         }

         if (var1) {
            this.I();
         }

         return s0.b.c();
      } else {
         if (var1) {
            this.I();
         }

         Object var2 = this.x();
         if (!(var2 instanceof u)) {
            if (o0.b(super.g)) {
               h1 var3 = (h1)this.a().b(h1.b);
               if (var3 != null && !var3.d()) {
                  CancellationException var4 = var3.k();
                  this.b(var2, var4);
                  throw var4;
               }
            }

            return this.f(var2);
         } else {
            throw ((u)var2).a;
         }
      }
   }

   public final Object x() {
      return k.get(this);
   }

   public void z() {
      r0 var1 = this.A();
      if (var1 != null) {
         if (this.D()) {
            var1.a();
            l.set(this, t1.e);
         }

      }
   }
}
