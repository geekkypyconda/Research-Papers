package h1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class o1 implements h1, r, v1 {
   private static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(o1.class, Object.class, "_state");
   private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(o1.class, Object.class, "_parentHandle");
   private volatile Object _parentHandle;
   private volatile Object _state;

   public o1(boolean var1) {
      s0 var2;
      if (var1) {
         var2 = p1.c();
      } else {
         var2 = p1.d();
      }

      this._state = var2;
   }

   private final boolean B0(d1 var1, Object var2) {
      if (!androidx.concurrent.futures.b.a(e, this, var1, p1.g(var2))) {
         return false;
      } else {
         this.p0((Throwable)null);
         this.q0(var2);
         this.P(var1, var2);
         return true;
      }
   }

   private final boolean C0(d1 var1, Throwable var2) {
      s1 var3 = this.Y(var1);
      if (var3 == null) {
         return false;
      } else {
         o1.b var4 = new o1.b(var3, false, var2);
         if (!androidx.concurrent.futures.b.a(e, this, var1, var4)) {
            return false;
         } else {
            this.n0(var3, var2);
            return true;
         }
      }
   }

   // $FF: synthetic method
   public static final String D(o1 var0) {
      return var0.N();
   }

   private final Object D0(Object var1, Object var2) {
      if (!(var1 instanceof d1)) {
         return p1.a();
      } else if ((var1 instanceof s0 || var1 instanceof n1) && !(var1 instanceof q) && !(var2 instanceof u)) {
         return this.B0((d1)var1, var2) ? var2 : p1.b();
      } else {
         return this.E0((d1)var1, var2);
      }
   }

   private final Object E0(d1 var1, Object var2) {
      s1 var3 = this.Y(var1);
      if (var3 == null) {
         return p1.b();
      } else {
         boolean var4 = var1 instanceof o1.b;
         p0.q var5 = null;
         o1.b var6;
         if (var4) {
            var6 = (o1.b)var1;
         } else {
            var6 = null;
         }

         var4 = false;
         o1.b var7 = var6;
         if (var6 == null) {
            var7 = new o1.b(var3, false, (Throwable)null);
         }

         a1.q var8 = new a1.q();
         synchronized(var7){}

         Throwable var10000;
         label993: {
            boolean var10001;
            m1.h0 var85;
            try {
               if (var7.h()) {
                  var85 = p1.a();
                  return var85;
               }
            } catch (Throwable var82) {
               var10000 = var82;
               var10001 = false;
               break label993;
            }

            try {
               var7.k(true);
            } catch (Throwable var81) {
               var10000 = var81;
               var10001 = false;
               break label993;
            }

            if (var7 != var1) {
               try {
                  if (!androidx.concurrent.futures.b.a(e, this, var1, var7)) {
                     var85 = p1.b();
                     return var85;
                  }
               } catch (Throwable var80) {
                  var10000 = var80;
                  var10001 = false;
                  break label993;
               }
            }

            boolean var9;
            u var87;
            label963: {
               try {
                  var9 = var7.g();
                  if (var2 instanceof u) {
                     var87 = (u)var2;
                     break label963;
                  }
               } catch (Throwable var79) {
                  var10000 = var79;
                  var10001 = false;
                  break label993;
               }

               var87 = null;
            }

            if (var87 != null) {
               try {
                  var7.a(var87.a);
               } catch (Throwable var78) {
                  var10000 = var78;
                  var10001 = false;
                  break label993;
               }
            }

            Throwable var10;
            try {
               var10 = var7.e();
            } catch (Throwable var77) {
               var10000 = var77;
               var10001 = false;
               break label993;
            }

            if (!var9) {
               var4 = true;
            }

            Throwable var88 = var5;

            label947: {
               try {
                  if (!Boolean.valueOf(var4)) {
                     break label947;
                  }
               } catch (Throwable var76) {
                  var10000 = var76;
                  var10001 = false;
                  break label993;
               }

               var88 = var10;
            }

            try {
               var8.e = var88;
               var5 = p0.q.a;
            } catch (Throwable var75) {
               var10000 = var75;
               var10001 = false;
               break label993;
            }

            Throwable var86 = (Throwable)var88;
            if (var88 != null) {
               this.n0(var3, var88);
            }

            q var84 = this.T(var1);
            if (var84 != null && this.F0(var7, var84, var2)) {
               return p1.b;
            }

            return this.S(var7, var2);
         }

         Throwable var83 = var10000;
         throw var83;
      }
   }

   private final boolean F(final Object var1, s1 var2, n1 var3) {
      m1.s.a var6 = new m1.s.a(var3) {
         public Object f(m1.s var1x) {
            boolean var2;
            if (o1.this.a0() == var1) {
               var2 = true;
            } else {
               var2 = false;
            }

            Object var3;
            if (var2) {
               var3 = null;
            } else {
               var3 = m1.r.a();
            }

            return var3;
         }
      };

      boolean var5;
      while(true) {
         int var4 = var2.r().w(var3, var2, var6);
         var5 = true;
         if (var4 == 1) {
            break;
         }

         if (var4 == 2) {
            var5 = false;
            break;
         }
      }

      return var5;
   }

   private final boolean F0(o1.b var1, q var2, Object var3) {
      q var4;
      do {
         if (h1.a.d(var2.i, false, false, new o1.a(this, var1, var2, var3), 1, (Object)null) != t1.e) {
            return true;
         }

         var4 = this.m0(var2);
         var2 = var4;
      } while(var4 != null);

      return false;
   }

   private final void G(Throwable var1, List<? extends Throwable> var2) {
      if (var2.size() > 1) {
         Set var3 = Collections.newSetFromMap(new IdentityHashMap(var2.size()));
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            Throwable var4 = (Throwable)var5.next();
            if (var4 != var1 && var4 != var1 && !(var4 instanceof CancellationException) && var3.add(var4)) {
               p0.a.a(var1, var4);
            }
         }

      }
   }

   private final Object L(Object var1) {
      Object var2;
      do {
         var2 = this.a0();
         if (!(var2 instanceof d1) || var2 instanceof o1.b && ((o1.b)var2).h()) {
            return p1.a();
         }

         var2 = this.D0(var2, new u(this.R(var1), false, 2, (a1.g)null));
      } while(var2 == p1.b());

      return var2;
   }

   private final boolean M(Throwable var1) {
      boolean var2 = this.h0();
      boolean var3 = true;
      if (var2) {
         return true;
      } else {
         boolean var4 = var1 instanceof CancellationException;
         p var5 = this.Z();
         if (var5 != null && var5 != t1.e) {
            var2 = var3;
            if (!var5.c(var1)) {
               if (var4) {
                  var2 = var3;
               } else {
                  var2 = false;
               }
            }

            return var2;
         } else {
            return var4;
         }
      }
   }

   private final void P(d1 var1, Object var2) {
      p var3 = this.Z();
      if (var3 != null) {
         var3.a();
         this.v0(t1.e);
      }

      boolean var4 = var2 instanceof u;
      Throwable var9 = null;
      u var8;
      if (var4) {
         var8 = (u)var2;
      } else {
         var8 = null;
      }

      if (var8 != null) {
         var9 = var8.a;
      }

      if (var1 instanceof n1) {
         try {
            ((n1)var1).x(var9);
         } catch (Throwable var6) {
            StringBuilder var10 = new StringBuilder();
            var10.append("Exception in completion handler ");
            var10.append(var1);
            var10.append(" for ");
            var10.append(this);
            this.c0(new x(var10.toString(), var6));
            return;
         }
      } else {
         s1 var7 = var1.f();
         if (var7 != null) {
            this.o0(var7, var9);
         }
      }

   }

   private final void Q(o1.b var1, q var2, Object var3) {
      var2 = this.m0(var2);
      if (var2 == null || !this.F0(var1, var2, var3)) {
         this.H(this.S(var1, var3));
      }
   }

   private final Throwable R(Object var1) {
      boolean var2;
      if (var1 == null) {
         var2 = true;
      } else {
         var2 = var1 instanceof Throwable;
      }

      if (var2) {
         Throwable var3 = (Throwable)var1;
         var1 = var3;
         if (var3 == null) {
            var1 = new i1(D(this), (Throwable)null, this);
         }
      } else {
         a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
         var1 = ((v1)var1).h();
      }

      return (Throwable)var1;
   }

   private final Object S(o1.b var1, Object var2) {
      u var3;
      if (var2 instanceof u) {
         var3 = (u)var2;
      } else {
         var3 = null;
      }

      Throwable var15;
      if (var3 != null) {
         var15 = var3.a;
      } else {
         var15 = null;
      }

      synchronized(var1){}

      boolean var4;
      Throwable var6;
      label174: {
         Throwable var10000;
         label179: {
            List var5;
            boolean var10001;
            try {
               var4 = var1.g();
               var5 = var1.j(var15);
               var6 = this.V(var1, var5);
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label179;
            }

            if (var6 == null) {
               break label174;
            }

            label169:
            try {
               this.G(var6, var5);
               break label174;
            } catch (Throwable var12) {
               var10000 = var12;
               var10001 = false;
               break label169;
            }
         }

         Throwable var14 = var10000;
         throw var14;
      }

      boolean var7 = false;
      if (var6 != null && var6 != var15) {
         var2 = new u(var6, false, 2, (a1.g)null);
      }

      if (var6 != null) {
         if (this.M(var6) || this.b0(var6)) {
            var7 = true;
         }

         if (var7) {
            a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((u)var2).b();
         }
      }

      if (!var4) {
         this.p0(var6);
      }

      this.q0(var2);
      androidx.concurrent.futures.b.a(e, this, var1, p1.g(var2));
      this.P(var1, var2);
      return var2;
   }

   private final q T(d1 var1) {
      boolean var2 = var1 instanceof q;
      Object var3 = null;
      q var4;
      if (var2) {
         var4 = (q)var1;
      } else {
         var4 = null;
      }

      q var6;
      if (var4 == null) {
         s1 var5 = var1.f();
         var6 = (q)var3;
         if (var5 != null) {
            var6 = this.m0(var5);
         }
      } else {
         var6 = var4;
      }

      return var6;
   }

   private final Throwable U(Object var1) {
      boolean var2 = var1 instanceof u;
      Throwable var3 = null;
      u var4;
      if (var2) {
         var4 = (u)var1;
      } else {
         var4 = null;
      }

      if (var4 != null) {
         var3 = var4.a;
      }

      return var3;
   }

   private final Throwable V(o1.b var1, List<? extends Throwable> var2) {
      boolean var3 = var2.isEmpty();
      Object var4 = null;
      if (var3) {
         return var1.g() ? new i1(D(this), (Throwable)null, this) : null;
      } else {
         Iterator var5 = var2.iterator();

         Object var6;
         do {
            var6 = var4;
            if (!var5.hasNext()) {
               break;
            }

            var6 = var5.next();
         } while(!((Throwable)var6 instanceof CancellationException ^ true));

         Throwable var7 = (Throwable)var6;
         return var7 != null ? var7 : (Throwable)var2.get(0);
      }
   }

   private final s1 Y(d1 var1) {
      s1 var2 = var1.f();
      s1 var3 = var2;
      if (var2 == null) {
         if (var1 instanceof s0) {
            var3 = new s1();
         } else {
            if (!(var1 instanceof n1)) {
               StringBuilder var4 = new StringBuilder();
               var4.append("State should have list: ");
               var4.append(var1);
               throw new IllegalStateException(var4.toString().toString());
            }

            this.t0((n1)var1);
            var3 = null;
         }
      }

      return var3;
   }

   private final Object i0(Object var1) {
      Object var2 = null;
      Throwable var3 = null;

      while(true) {
         Object var4 = this.a0();
         Throwable var6;
         if (var4 instanceof o1.b) {
            synchronized(var4){}

            Throwable var40;
            Throwable var10000;
            label533: {
               boolean var10001;
               label518: {
                  m1.h0 var39;
                  try {
                     if (!((o1.b)var4).i()) {
                        break label518;
                     }

                     var39 = p1.f();
                  } catch (Throwable var37) {
                     var10000 = var37;
                     var10001 = false;
                     break label533;
                  }

                  return var39;
               }

               boolean var5;
               try {
                  var5 = ((o1.b)var4).g();
               } catch (Throwable var36) {
                  var10000 = var36;
                  var10001 = false;
                  break label533;
               }

               if (var1 != null || !var5) {
                  var6 = var3;
                  if (var3 == null) {
                     try {
                        var6 = this.R(var1);
                     } catch (Throwable var35) {
                        var10000 = var35;
                        var10001 = false;
                        break label533;
                     }
                  }

                  try {
                     ((o1.b)var4).a(var6);
                  } catch (Throwable var34) {
                     var10000 = var34;
                     var10001 = false;
                     break label533;
                  }
               }

               try {
                  var3 = ((o1.b)var4).e();
               } catch (Throwable var33) {
                  var10000 = var33;
                  var10001 = false;
                  break label533;
               }

               var40 = (Throwable)var2;
               if (var5 ^ true) {
                  var40 = var3;
               }

               if (var40 != null) {
                  this.n0(((o1.b)var4).f(), var40);
               }

               return p1.a();
            }

            var40 = var10000;
            throw var40;
         }

         if (!(var4 instanceof d1)) {
            return p1.f();
         }

         var6 = var3;
         if (var3 == null) {
            var6 = this.R(var1);
         }

         d1 var7 = (d1)var4;
         if (var7.d()) {
            var3 = var6;
            if (this.C0(var7, var6)) {
               return p1.a();
            }
         } else {
            Object var41 = this.D0(var4, new u(var6, false, 2, (a1.g)null));
            if (var41 == p1.a()) {
               StringBuilder var38 = new StringBuilder();
               var38.append("Cannot happen in ");
               var38.append(var4);
               throw new IllegalStateException(var38.toString().toString());
            }

            var3 = var6;
            if (var41 != p1.b()) {
               return var41;
            }
         }
      }
   }

   private final n1 k0(z0.l<? super Throwable, p0.q> var1, boolean var2) {
      Object var3 = null;
      j1 var4 = null;
      if (var2) {
         if (var1 instanceof j1) {
            var4 = (j1)var1;
         }

         var3 = var4;
         if (var4 == null) {
            var3 = new f1(var1);
         }
      } else {
         if (var1 instanceof n1) {
            var3 = (n1)var1;
         }

         if (var3 == null) {
            var3 = new g1(var1);
         }
      }

      ((n1)var3).z(this);
      return (n1)var3;
   }

   private final q m0(m1.s var1) {
      while(true) {
         m1.s var2 = var1;
         if (!var1.s()) {
            do {
               do {
                  var1 = var2.q();
                  var2 = var1;
               } while(var1.s());

               if (var1 instanceof q) {
                  return (q)var1;
               }

               var2 = var1;
            } while(!(var1 instanceof s1));

            return null;
         }

         var1 = var1.r();
      }
   }

   private final void n0(s1 var1, Throwable var2) {
      this.p0(var2);
      Object var3 = var1.p();
      a1.k.c(var3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
      m1.s var9 = (m1.s)var3;

      x var4;
      x var5;
      for(var4 = null; !a1.k.a(var9, var1); var4 = var5) {
         var5 = var4;
         if (var9 instanceof j1) {
            label69: {
               n1 var12 = (n1)var9;

               try {
                  var12.x(var2);
               } catch (Throwable var8) {
                  if (var4 != null) {
                     p0.a.a(var4, var8);
                     var5 = var4;
                     break label69;
                  }

                  StringBuilder var10 = new StringBuilder();
                  var10.append("Exception in completion handler ");
                  var10.append(var12);
                  var10.append(" for ");
                  var10.append(this);
                  var5 = new x(var10.toString(), var8);
                  p0.q var11 = p0.q.a;
                  break label69;
               }

               var5 = var4;
            }
         }

         var9 = var9.q();
      }

      if (var4 != null) {
         this.c0(var4);
      }

      this.M(var2);
   }

   private final void o0(s1 var1, Throwable var2) {
      Object var3 = var1.p();
      a1.k.c(var3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
      m1.s var9 = (m1.s)var3;

      x var4;
      x var5;
      for(var4 = null; !a1.k.a(var9, var1); var4 = var5) {
         var5 = var4;
         if (var9 instanceof n1) {
            label69: {
               n1 var12 = (n1)var9;

               try {
                  var12.x(var2);
               } catch (Throwable var8) {
                  if (var4 != null) {
                     p0.a.a(var4, var8);
                     var5 = var4;
                     break label69;
                  }

                  StringBuilder var10 = new StringBuilder();
                  var10.append("Exception in completion handler ");
                  var10.append(var12);
                  var10.append(" for ");
                  var10.append(this);
                  var5 = new x(var10.toString(), var8);
                  p0.q var11 = p0.q.a;
                  break label69;
               }

               var5 = var4;
            }
         }

         var9 = var9.q();
      }

      if (var4 != null) {
         this.c0(var4);
      }

   }

   private final void s0(s0 var1) {
      Object var2 = new s1();
      if (!var1.d()) {
         var2 = new c1((s1)var2);
      }

      androidx.concurrent.futures.b.a(e, this, var1, var2);
   }

   private final void t0(n1 var1) {
      var1.l(new s1());
      m1.s var2 = var1.q();
      androidx.concurrent.futures.b.a(e, this, var1, var2);
   }

   private final int w0(Object var1) {
      if (var1 instanceof s0) {
         if (((s0)var1).d()) {
            return 0;
         } else if (!androidx.concurrent.futures.b.a(e, this, var1, p1.c())) {
            return -1;
         } else {
            this.r0();
            return 1;
         }
      } else if (var1 instanceof c1) {
         if (!androidx.concurrent.futures.b.a(e, this, var1, ((c1)var1).f())) {
            return -1;
         } else {
            this.r0();
            return 1;
         }
      } else {
         return 0;
      }
   }

   private final String x0(Object var1) {
      boolean var2 = var1 instanceof o1.b;
      String var3 = "Active";
      String var5;
      if (var2) {
         o1.b var4 = (o1.b)var1;
         if (var4.g()) {
            var5 = "Cancelling";
         } else {
            var5 = var3;
            if (var4.h()) {
               var5 = "Completing";
            }
         }
      } else if (var1 instanceof d1) {
         if (((d1)var1).d()) {
            var5 = var3;
         } else {
            var5 = "New";
         }
      } else if (var1 instanceof u) {
         var5 = "Cancelled";
      } else {
         var5 = "Completed";
      }

      return var5;
   }

   // $FF: synthetic method
   public static CancellationException z0(o1 var0, Throwable var1, String var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 1) != 0) {
            var2 = null;
         }

         return var0.y0(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
      }
   }

   public final p A(r var1) {
      r0 var2 = h1.a.d(this, true, false, new q(var1), 2, (Object)null);
      a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
      return (p)var2;
   }

   public final String A0() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.l0());
      var1.append('{');
      var1.append(this.x0(this.a0()));
      var1.append('}');
      return var1.toString();
   }

   protected void H(Object var1) {
   }

   public final boolean I(Throwable var1) {
      return this.J(var1);
   }

   public final boolean J(Object var1) {
      Object var2 = p1.a();
      boolean var3 = this.X();
      boolean var4 = true;
      Object var5;
      if (var3) {
         var5 = this.L(var1);
         var2 = var5;
         if (var5 == p1.b) {
            return true;
         }
      }

      var5 = var2;
      if (var2 == p1.a()) {
         var5 = this.i0(var1);
      }

      if (var5 != p1.a() && var5 != p1.b) {
         if (var5 == p1.f()) {
            var4 = false;
         } else {
            this.H(var5);
         }
      }

      return var4;
   }

   public void K(Throwable var1) {
      this.J(var1);
   }

   protected String N() {
      return "Job was cancelled";
   }

   public boolean O(Throwable var1) {
      boolean var2 = var1 instanceof CancellationException;
      boolean var3 = true;
      if (var2) {
         return true;
      } else {
         if (!this.J(var1) || !this.W()) {
            var3 = false;
         }

         return var3;
      }
   }

   public boolean W() {
      return true;
   }

   public boolean X() {
      return false;
   }

   public final p Z() {
      return (p)f.get(this);
   }

   public final Object a0() {
      AtomicReferenceFieldUpdater var1 = e;

      while(true) {
         Object var2 = var1.get(this);
         if (!(var2 instanceof m1.a0)) {
            return var2;
         }

         ((m1.a0)var2).a(this);
      }
   }

   public <E extends r0.g.b> E b(r0.g.c<E> var1) {
      return h1.a.c(this, var1);
   }

   protected boolean b0(Throwable var1) {
      return false;
   }

   public void c(CancellationException var1) {
      Object var2 = var1;
      if (var1 == null) {
         var2 = new i1(D(this), (Throwable)null, this);
      }

      this.K((Throwable)var2);
   }

   public void c0(Throwable var1) {
      throw var1;
   }

   public boolean d() {
      Object var1 = this.a0();
      boolean var2;
      if (var1 instanceof d1 && ((d1)var1).d()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   protected final void d0(h1 var1) {
      if (var1 == null) {
         this.v0(t1.e);
      } else {
         var1.start();
         p var2 = var1.A(this);
         this.v0(var2);
         if (this.g0()) {
            var2.a();
            this.v0(t1.e);
         }

      }
   }

   public final r0 e0(z0.l<? super Throwable, p0.q> var1) {
      return this.i(false, true, var1);
   }

   public final boolean f0() {
      Object var1 = this.a0();
      boolean var2;
      if (var1 instanceof u || var1 instanceof o1.b && ((o1.b)var1).g()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public final boolean g0() {
      return this.a0() instanceof d1 ^ true;
   }

   public final r0.g.c<?> getKey() {
      return h1.b;
   }

   public h1 getParent() {
      p var1 = this.Z();
      h1 var2;
      if (var1 != null) {
         var2 = var1.getParent();
      } else {
         var2 = null;
      }

      return var2;
   }

   public CancellationException h() {
      Object var1 = this.a0();
      boolean var2 = var1 instanceof o1.b;
      CancellationException var3 = null;
      Throwable var4;
      if (var2) {
         var4 = ((o1.b)var1).e();
      } else if (var1 instanceof u) {
         var4 = ((u)var1).a;
      } else {
         if (var1 instanceof d1) {
            StringBuilder var6 = new StringBuilder();
            var6.append("Cannot be cancelling child in this state: ");
            var6.append(var1);
            throw new IllegalStateException(var6.toString().toString());
         }

         var4 = null;
      }

      if (var4 instanceof CancellationException) {
         var3 = (CancellationException)var4;
      }

      Object var5 = var3;
      if (var3 == null) {
         StringBuilder var7 = new StringBuilder();
         var7.append("Parent job is ");
         var7.append(this.x0(var1));
         var5 = new i1(var7.toString(), var4, this);
      }

      return (CancellationException)var5;
   }

   protected boolean h0() {
      return false;
   }

   public final r0 i(boolean var1, boolean var2, z0.l<? super Throwable, p0.q> var3) {
      n1 var4 = this.k0(var3, var1);

      while(true) {
         while(true) {
            Object var5 = this.a0();
            if (var5 instanceof s0) {
               s0 var46 = (s0)var5;
               if (var46.d()) {
                  if (androidx.concurrent.futures.b.a(e, this, var5, var4)) {
                     return var4;
                  }
               } else {
                  this.s0(var46);
               }
            } else {
               boolean var7 = var5 instanceof d1;
               Throwable var8 = null;
               Object var9 = null;
               if (!var7) {
                  if (var2) {
                     u var43;
                     if (var5 instanceof u) {
                        var43 = (u)var5;
                     } else {
                        var43 = null;
                     }

                     if (var43 != null) {
                        var8 = var43.a;
                     }

                     var3.i(var8);
                  }

                  return t1.e;
               }

               s1 var10 = ((d1)var5).f();
               if (var10 == null) {
                  a1.k.c(var5, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                  this.t0((n1)var5);
               } else {
                  t1 var44 = t1.e;
                  Throwable var11 = (Throwable)var9;
                  Object var6 = var44;
                  if (var1) {
                     var11 = (Throwable)var9;
                     var6 = var44;
                     if (var5 instanceof o1.b) {
                        label683: {
                           synchronized(var5){}

                           Throwable var10000;
                           label676: {
                              boolean var10001;
                              try {
                                 var11 = ((o1.b)var5).e();
                              } catch (Throwable var41) {
                                 var10000 = var41;
                                 var10001 = false;
                                 break label676;
                              }

                              label677: {
                                 if (var11 != null) {
                                    var6 = var44;

                                    try {
                                       if (!(var3 instanceof q)) {
                                          break label677;
                                       }
                                    } catch (Throwable var40) {
                                       var10000 = var40;
                                       var10001 = false;
                                       break label676;
                                    }

                                    var6 = var44;

                                    try {
                                       if (((o1.b)var5).h()) {
                                          break label677;
                                       }
                                    } catch (Throwable var39) {
                                       var10000 = var39;
                                       var10001 = false;
                                       break label676;
                                    }
                                 }

                                 try {
                                    var7 = this.F(var5, var10, var4);
                                 } catch (Throwable var38) {
                                    var10000 = var38;
                                    var10001 = false;
                                    break label676;
                                 }

                                 if (!var7) {
                                    continue;
                                 }

                                 if (var11 == null) {
                                    return var4;
                                 }

                                 var6 = var4;
                              }

                              label645:
                              try {
                                 p0.q var45 = p0.q.a;
                                 break label683;
                              } catch (Throwable var37) {
                                 var10000 = var37;
                                 var10001 = false;
                                 break label645;
                              }
                           }

                           Throwable var42 = var10000;
                           throw var42;
                        }
                     }
                  }

                  if (var11 != null) {
                     if (var2) {
                        var3.i(var11);
                     }

                     return (r0)var6;
                  }

                  if (this.F(var5, var10, var4)) {
                     return var4;
                  }
               }
            }
         }
      }
   }

   public final Object j0(Object var1) {
      while(true) {
         Object var2 = this.D0(this.a0(), var1);
         if (var2 != p1.a()) {
            if (var2 == p1.b()) {
               continue;
            }

            return var2;
         }

         StringBuilder var3 = new StringBuilder();
         var3.append("Job ");
         var3.append(this);
         var3.append(" is already complete or completing, but is being completed with ");
         var3.append(var1);
         throw new IllegalStateException(var3.toString(), this.U(var1));
      }
   }

   public final CancellationException k() {
      StringBuilder var3;
      label23: {
         Object var1 = this.a0();
         if (var1 instanceof o1.b) {
            Throwable var2 = ((o1.b)var1).e();
            if (var2 == null) {
               break label23;
            }

            var3 = new StringBuilder();
            var3.append(i0.a(this));
            var3.append(" is cancelling");
            var1 = this.y0(var2, var3.toString());
            if (var1 == null) {
               break label23;
            }
         } else {
            if (var1 instanceof d1) {
               var3 = new StringBuilder();
               var3.append("Job is still new or active: ");
               var3.append(this);
               throw new IllegalStateException(var3.toString().toString());
            }

            if (var1 instanceof u) {
               var1 = z0(this, ((u)var1).a, (String)null, 1, (Object)null);
            } else {
               var3 = new StringBuilder();
               var3.append(i0.a(this));
               var3.append(" has completed normally");
               var1 = new i1(var3.toString(), (Throwable)null, this);
            }
         }

         return (CancellationException)var1;
      }

      var3 = new StringBuilder();
      var3.append("Job is still new or active: ");
      var3.append(this);
      throw new IllegalStateException(var3.toString().toString());
   }

   public String l0() {
      return i0.a(this);
   }

   public final void m(v1 var1) {
      this.J(var1);
   }

   public r0.g n(r0.g var1) {
      return h1.a.f(this, var1);
   }

   protected void p0(Throwable var1) {
   }

   protected void q0(Object var1) {
   }

   protected void r0() {
   }

   public final boolean start() {
      while(true) {
         int var1 = this.w0(this.a0());
         if (var1 != 0) {
            if (var1 != 1) {
               continue;
            }

            return true;
         }

         return false;
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.A0());
      var1.append('@');
      var1.append(i0.b(this));
      return var1.toString();
   }

   public final void u0(n1 var1) {
      while(true) {
         Object var2 = this.a0();
         if (var2 instanceof n1) {
            if (var2 != var1) {
               return;
            }

            if (!androidx.concurrent.futures.b.a(e, this, var2, p1.c())) {
               continue;
            }

            return;
         }

         if (var2 instanceof d1 && ((d1)var2).f() != null) {
            var1.t();
         }

         return;
      }
   }

   public final void v0(p var1) {
      f.set(this, var1);
   }

   public r0.g x(r0.g.c<?> var1) {
      return h1.a.e(this, var1);
   }

   public <R> R y(R var1, z0.p<? super R, ? super r0.g.b, ? extends R> var2) {
      return h1.a.b(this, var1, var2);
   }

   protected final CancellationException y0(Throwable var1, String var2) {
      CancellationException var3;
      if (var1 instanceof CancellationException) {
         var3 = (CancellationException)var1;
      } else {
         var3 = null;
      }

      Object var4 = var3;
      if (var3 == null) {
         String var5 = var2;
         if (var2 == null) {
            var5 = D(this);
         }

         var4 = new i1(var5, var1, this);
      }

      return (CancellationException)var4;
   }

   private static final class a extends n1 {
      private final o1 i;
      private final o1.b j;
      private final q k;
      private final Object l;

      public a(o1 var1, o1.b var2, q var3, Object var4) {
         this.i = var1;
         this.j = var2;
         this.k = var3;
         this.l = var4;
      }

      public void x(Throwable var1) {
         this.i.Q(this.j, this.k, this.l);
      }
   }

   private static final class b implements d1 {
      private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(o1.b.class, "_isCompleting");
      private static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(o1.b.class, Object.class, "_rootCause");
      private static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(o1.b.class, Object.class, "_exceptionsHolder");
      private volatile Object _exceptionsHolder;
      private volatile int _isCompleting;
      private volatile Object _rootCause;
      private final s1 e;

      public b(s1 var1, boolean var2, Throwable var3) {
         this.e = var1;
         this._isCompleting = var2;
         this._rootCause = var3;
      }

      private final ArrayList<Throwable> b() {
         return new ArrayList(4);
      }

      private final Object c() {
         return h.get(this);
      }

      private final void l(Object var1) {
         h.set(this, var1);
      }

      public final void a(Throwable var1) {
         Throwable var2 = this.e();
         if (var2 == null) {
            this.m(var1);
         } else if (var1 != var2) {
            Object var5 = this.c();
            if (var5 == null) {
               this.l(var1);
            } else if (var5 instanceof Throwable) {
               if (var1 == var5) {
                  return;
               }

               ArrayList var3 = this.b();
               var3.add(var5);
               var3.add(var1);
               this.l(var3);
            } else {
               if (!(var5 instanceof ArrayList)) {
                  StringBuilder var4 = new StringBuilder();
                  var4.append("State is ");
                  var4.append(var5);
                  throw new IllegalStateException(var4.toString().toString());
               }

               ((ArrayList)var5).add(var1);
            }

         }
      }

      public boolean d() {
         boolean var1;
         if (this.e() == null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public final Throwable e() {
         return (Throwable)g.get(this);
      }

      public s1 f() {
         return this.e;
      }

      public final boolean g() {
         boolean var1;
         if (this.e() != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public final boolean h() {
         boolean var1;
         if (f.get(this) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public final boolean i() {
         boolean var1;
         if (this.c() == p1.e()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public final List<Throwable> j(Throwable var1) {
         Object var2 = this.c();
         ArrayList var3;
         if (var2 == null) {
            var3 = this.b();
         } else if (var2 instanceof Throwable) {
            var3 = this.b();
            var3.add(var2);
         } else {
            if (!(var2 instanceof ArrayList)) {
               StringBuilder var4 = new StringBuilder();
               var4.append("State is ");
               var4.append(var2);
               throw new IllegalStateException(var4.toString().toString());
            }

            var3 = (ArrayList)var2;
         }

         Throwable var5 = this.e();
         if (var5 != null) {
            var3.add(0, var5);
         }

         if (var1 != null && !a1.k.a(var1, var5)) {
            var3.add(var1);
         }

         this.l(p1.e());
         return var3;
      }

      public final void k(boolean var1) {
         f.set(this, var1);
      }

      public final void m(Throwable var1) {
         g.set(this, var1);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Finishing[cancelling=");
         var1.append(this.g());
         var1.append(", completing=");
         var1.append(this.h());
         var1.append(", rootCause=");
         var1.append(this.e());
         var1.append(", exceptions=");
         var1.append(this.c());
         var1.append(", list=");
         var1.append(this.f());
         var1.append(']');
         return var1.toString();
      }
   }
}
