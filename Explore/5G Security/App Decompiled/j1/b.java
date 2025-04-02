package j1;

import h1.c2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m1.e0;
import m1.f0;
import m1.g0;
import m1.h0;
import m1.q0;
import m1.z;

public class b<E> implements d<E> {
   private static final AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(j1.b.class, "sendersAndCloseStatus");
   private static final AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(j1.b.class, "receivers");
   private static final AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(j1.b.class, "bufferEnd");
   private static final AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(j1.b.class, "completedExpandBuffersAndPauseFlag");
   private static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(j1.b.class, Object.class, "sendSegment");
   private static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(j1.b.class, Object.class, "receiveSegment");
   private static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(j1.b.class, Object.class, "bufferEndSegment");
   private static final AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(j1.b.class, Object.class, "_closeCause");
   private static final AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(j1.b.class, Object.class, "closeHandler");
   private volatile Object _closeCause;
   private volatile long bufferEnd;
   private volatile Object bufferEndSegment;
   private volatile Object closeHandler;
   private volatile long completedExpandBuffersAndPauseFlag;
   private final int e;
   public final z0.l<E, p0.q> f;
   private final z0.q<p1.b<?>, Object, Object, z0.l<Throwable, p0.q>> g;
   private volatile Object receiveSegment;
   private volatile long receivers;
   private volatile Object sendSegment;
   private volatile long sendersAndCloseStatus;

   public b(int var1, z0.l<? super E, p0.q> var2) {
      this.e = var1;
      this.f = var2;
      boolean var3;
      if (var1 >= 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      if (var3) {
         this.bufferEnd = j1.c.t(var1);
         this.completedExpandBuffersAndPauseFlag = this.G();
         j var4 = new j(0L, (j)null, this, 3);
         this.sendSegment = var4;
         this.receiveSegment = var4;
         if (this.W()) {
            var4 = j1.c.n();
            a1.k.c(var4, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
         }

         this.bufferEndSegment = var4;
         z0.q var6;
         if (var2 != null) {
            var6 = new z0.q<p1.b<?>, Object, Object, z0.l<? super Throwable, ? extends p0.q>>() {
               public final z0.l<Throwable, p0.q> a(p1.b<?> var1, Object var2, Object var3) {
                  return new z0.l<Throwable, p0.q>(b.this, var1) {
                     // $FF: synthetic field
                     final Object f;
                     // $FF: synthetic field
                     final j1.b<E> g;
                     // $FF: synthetic field
                     final p1.b<?> h;

                     {
                        super(1);
                        this.f = var1;
                        this.g = var2;
                        this.h = var3;
                     }

                     public final void a(Throwable var1) {
                        if (this.f != j1.c.z()) {
                           z.b(this.g.f, this.f, this.h.a());
                        }

                     }
                  };
               }
            };
         } else {
            var6 = null;
         }

         this.g = var6;
         this._closeCause = j1.c.l();
      } else {
         StringBuilder var5 = new StringBuilder();
         var5.append("Invalid channel capacity: ");
         var5.append(var1);
         var5.append(", should be >=0");
         throw new IllegalArgumentException(var5.toString().toString());
      }
   }

   private final void A() {
      this.w();
   }

   private final void C() {
      if (!this.W()) {
         j var1 = (j)n.get(this);

         boolean var12;
         do {
            long var2;
            int var4;
            j var11;
            do {
               var2 = j.getAndIncrement(this);
               var4 = j1.c.b;
               long var5 = var2 / (long)var4;
               long var7 = this.L();
               long var9 = var1.g;
               if (var7 <= var2) {
                  if (var9 < var5 && var1.e() != null) {
                     this.b0(var5, var1);
                  }

                  O(this, 0L, 1, (Object)null);
                  return;
               }

               var11 = var1;
               if (var9 == var5) {
                  break;
               }

               var11 = this.D(var5, var1, var2);
            } while(var11 == null);

            var12 = this.s0(var11, (int)(var2 % (long)var4), var2);
            O(this, 0L, 1, (Object)null);
            var1 = var11;
         } while(!var12);

      }
   }

   private final j<E> D(long var1, j<E> var3, long var4) {
      AtomicReferenceFieldUpdater var6 = n;
      z0.p var7 = (z0.p)j1.c.y();

      Object var8;
      boolean var11;
      do {
         var8 = m1.d.c(var3, var1, var7);
         if (f0.c(var8)) {
            break;
         }

         e0 var9 = f0.b(var8);

         while(true) {
            e0 var10 = (e0)var6.get(this);
            if (var10.g < var9.g) {
               if (!var9.q()) {
                  var11 = false;
                  break;
               }

               if (!androidx.concurrent.futures.b.a(var6, this, var10, var9)) {
                  if (var9.m()) {
                     var9.k();
                  }
                  continue;
               }

               if (var10.m()) {
                  var10.k();
               }
            }

            var11 = true;
            break;
         }
      } while(!var11);

      boolean var12 = f0.c(var8);
      var6 = null;
      if (var12) {
         this.A();
         this.b0(var1, var3);
      } else {
         var3 = (j)f0.b(var8);
         long var13 = var3.g;
         if (var13 <= var1) {
            return var3;
         }

         AtomicLongFieldUpdater var15 = j;
         int var16 = j1.c.b;
         if (var15.compareAndSet(this, var4 + 1L, (long)var16 * var13)) {
            this.N(var3.g * (long)var16 - var4);
            var3 = var6;
            return var3;
         }
      }

      O(this, 0L, 1, (Object)null);
      var3 = var6;
      return var3;
   }

   private final j<E> E(long var1, j<E> var3) {
      AtomicReferenceFieldUpdater var4 = m;
      z0.p var5 = (z0.p)j1.c.y();

      Object var6;
      e0 var8;
      long var11;
      boolean var14;
      do {
         var6 = m1.d.c(var3, var1, var5);
         if (f0.c(var6)) {
            break;
         }

         e0 var7 = f0.b(var6);

         while(true) {
            var8 = (e0)var4.get(this);
            long var9 = var8.g;
            var11 = var7.g;
            boolean var13 = true;
            if (var9 >= var11) {
               var14 = var13;
               break;
            }

            if (!var7.q()) {
               var14 = false;
               break;
            }

            if (androidx.concurrent.futures.b.a(var4, this, var8, var7)) {
               var14 = var13;
               if (var8.m()) {
                  var8.k();
                  var14 = var13;
               }
               break;
            }

            if (var7.m()) {
               var7.k();
            }
         }
      } while(!var14);

      boolean var15 = f0.c(var6);
      var8 = null;
      j var17;
      if (var15) {
         this.A();
         var17 = var8;
         if (var3.g * (long)j1.c.b >= this.L()) {
            return var17;
         }
      } else {
         var3 = (j)f0.b(var6);
         if (!this.W() && var1 <= this.G() / (long)j1.c.b) {
            AtomicReferenceFieldUpdater var18 = n;

            while(true) {
               e0 var16 = (e0)var18.get(this);
               if (var16.g >= var3.g || !var3.q()) {
                  break;
               }

               if (androidx.concurrent.futures.b.a(var18, this, var16, var3)) {
                  if (var16.m()) {
                     var16.k();
                  }
                  break;
               }

               if (var3.m()) {
                  var3.k();
               }
            }
         }

         var11 = var3.g;
         if (var11 <= var1) {
            var17 = var3;
            return var17;
         }

         int var19 = j1.c.b;
         this.y0(var11 * (long)var19);
         var17 = var8;
         if (var3.g * (long)var19 >= this.L()) {
            return var17;
         }
      }

      var3.b();
      var17 = var8;
      return var17;
   }

   private final j<E> F(long var1, j<E> var3) {
      AtomicReferenceFieldUpdater var4 = l;
      z0.p var5 = (z0.p)j1.c.y();

      Object var6;
      long var9;
      boolean var14;
      do {
         var6 = m1.d.c(var3, var1, var5);
         if (f0.c(var6)) {
            break;
         }

         e0 var7 = f0.b(var6);

         while(true) {
            e0 var8 = (e0)var4.get(this);
            var9 = var8.g;
            long var11 = var7.g;
            boolean var13 = true;
            if (var9 >= var11) {
               var14 = var13;
               break;
            }

            if (!var7.q()) {
               var14 = false;
               break;
            }

            if (androidx.concurrent.futures.b.a(var4, this, var8, var7)) {
               var14 = var13;
               if (var8.m()) {
                  var8.k();
                  var14 = var13;
               }
               break;
            }

            if (var7.m()) {
               var7.k();
            }
         }
      } while(!var14);

      boolean var15 = f0.c(var6);
      var4 = null;
      j var16;
      if (var15) {
         this.A();
         var16 = var4;
         if (var3.g * (long)j1.c.b >= this.J()) {
            return var16;
         }
      } else {
         var3 = (j)f0.b(var6);
         var9 = var3.g;
         if (var9 <= var1) {
            var16 = var3;
            return var16;
         }

         int var17 = j1.c.b;
         this.z0(var9 * (long)var17);
         var16 = var4;
         if (var3.g * (long)var17 >= this.J()) {
            return var16;
         }
      }

      var3.b();
      var16 = var4;
      return var16;
   }

   private final long G() {
      return j.get(this);
   }

   private final Throwable I() {
      Throwable var1 = this.H();
      Object var2 = var1;
      if (var1 == null) {
         var2 = new m("Channel was closed");
      }

      return (Throwable)var2;
   }

   private final void N(long var1) {
      boolean var3;
      if ((k.addAndGet(this, var1) & 4611686018427387904L) != 0L) {
         var3 = true;
      } else {
         var3 = false;
      }

      if (var3) {
         do {
            if ((k.get(this) & 4611686018427387904L) != 0L) {
               var3 = true;
            } else {
               var3 = false;
            }
         } while(var3);
      }

   }

   // $FF: synthetic method
   static void O(j1.b var0, long var1, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 1) != 0) {
            var1 = 1L;
         }

         var0.N(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
      }
   }

   private final void P() {
      AtomicReferenceFieldUpdater var1 = p;

      Object var2;
      h0 var3;
      do {
         var2 = var1.get(this);
         if (var2 == null) {
            var3 = j1.c.d();
         } else {
            var3 = j1.c.e();
         }
      } while(!androidx.concurrent.futures.b.a(var1, this, var2, var3));

      if (var2 != null) {
         z0.l var4 = (z0.l)a1.t.a(var2, 1);
         ((z0.l)var2).i(this.H());
      }
   }

   private final boolean Q(j<E> var1, int var2, long var3) {
      Object var5;
      do {
         var5 = var1.w(var2);
         boolean var6 = false;
         if (var5 != null && var5 != j1.c.k()) {
            if (var5 == j1.c.d) {
               return true;
            }

            if (var5 == j1.c.j()) {
               return false;
            }

            if (var5 == j1.c.z()) {
               return false;
            }

            if (var5 == j1.c.f()) {
               return false;
            }

            if (var5 == j1.c.o()) {
               return false;
            }

            if (var5 == j1.c.p()) {
               return true;
            }

            if (var5 == j1.c.q()) {
               return false;
            }

            if (var3 == this.J()) {
               var6 = true;
            }

            return var6;
         }
      } while(!var1.r(var2, var5, j1.c.o()));

      this.C();
      return false;
   }

   private final boolean R(long var1, boolean var3) {
      int var4 = (int)(var1 >> 60);
      boolean var5 = false;
      boolean var6 = var5;
      if (var4 != 0) {
         var6 = var5;
         if (var4 != 1) {
            if (var4 != 2) {
               if (var4 != 3) {
                  StringBuilder var7 = new StringBuilder();
                  var7.append("unexpected close status: ");
                  var7.append(var4);
                  throw new IllegalStateException(var7.toString().toString());
               }

               this.x(var1 & 1152921504606846975L);
            } else {
               this.y(var1 & 1152921504606846975L);
               if (var3) {
                  var6 = var5;
                  if (this.M()) {
                     return var6;
                  }
               }
            }

            var6 = true;
         }
      }

      return var6;
   }

   private final boolean T(long var1) {
      return this.R(var1, true);
   }

   private final boolean U(long var1) {
      return this.R(var1, false);
   }

   private final boolean W() {
      long var1 = this.G();
      boolean var3;
      if (var1 != 0L && var1 != Long.MAX_VALUE) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private final long X(j<E> var1) {
      j var6;
      do {
         label34:
         for(int var2 = j1.c.b - 1; -1 < var2; --var2) {
            long var3 = var1.g * (long)j1.c.b + (long)var2;
            if (var3 < this.J()) {
               return -1L;
            }

            Object var5;
            do {
               var5 = var1.w(var2);
               if (var5 != null && var5 != j1.c.k()) {
                  if (var5 == j1.c.d) {
                     return var3;
                  }
                  continue label34;
               }
            } while(!var1.r(var2, var5, j1.c.z()));

            var1.p();
         }

         var6 = (j)var1.g();
         var1 = var6;
      } while(var6 != null);

      return -1L;
   }

   private final void Y() {
      AtomicLongFieldUpdater var1 = h;

      long var2;
      do {
         var2 = var1.get(this);
      } while((int)(var2 >> 60) == 0 && !var1.compareAndSet(this, var2, j1.c.b(1152921504606846975L & var2, 1)));

   }

   private final void Z() {
      AtomicLongFieldUpdater var1 = h;

      long var2;
      do {
         var2 = var1.get(this);
      } while(!var1.compareAndSet(this, var2, j1.c.b(1152921504606846975L & var2, 3)));

   }

   private final void a0() {
      AtomicLongFieldUpdater var1 = h;

      long var2;
      long var5;
      byte var7;
      do {
         var2 = var1.get(this);
         int var4 = (int)(var2 >> 60);
         if (var4 != 0) {
            if (var4 != 1) {
               return;
            }

            var5 = var2 & 1152921504606846975L;
            var7 = 3;
         } else {
            var5 = var2 & 1152921504606846975L;
            var7 = 2;
         }
      } while(!var1.compareAndSet(this, var2, j1.c.b(var5, var7)));

   }

   // $FF: synthetic method
   public static final j b(j1.b var0, long var1, j var3) {
      return var0.F(var1, var3);
   }

   private final void b0(long var1, j<E> var3) {
      while(true) {
         j var4 = var3;
         if (var3.g < var1) {
            var4 = (j)var3.e();
            if (var4 != null) {
               var3 = var4;
               continue;
            }

            var4 = var3;
         }

         while(true) {
            while(true) {
               if (var4.h()) {
                  var3 = (j)var4.e();
                  if (var3 != null) {
                     var4 = var3;
                     continue;
                  }
               }

               AtomicReferenceFieldUpdater var10 = n;

               boolean var9;
               while(true) {
                  e0 var5 = (e0)var10.get(this);
                  var1 = var5.g;
                  long var6 = var4.g;
                  boolean var8 = true;
                  if (var1 >= var6) {
                     var9 = var8;
                     break;
                  }

                  if (!var4.q()) {
                     var9 = false;
                     break;
                  }

                  if (androidx.concurrent.futures.b.a(var10, this, var5, var4)) {
                     var9 = var8;
                     if (var5.m()) {
                        var5.k();
                        var9 = var8;
                     }
                     break;
                  }

                  if (var4.m()) {
                     var4.k();
                  }
               }

               if (var9) {
                  return;
               }
            }
         }
      }
   }

   private final Object d0(E var1, r0.d<? super p0.q> var2) {
      h1.k var3;
      label20: {
         var3 = new h1.k(s0.b.b(var2), 1);
         var3.z();
         z0.l var4 = this.f;
         if (var4 != null) {
            var1 = z.d(var4, var1, (q0)null, 2, (Object)null);
            if (var1 != null) {
               p0.a.a((Throwable)var1, this.K());
               break label20;
            }
         }

         var1 = this.K();
      }

      p0.k.a var5 = p0.k.e;
      var3.u(p0.k.a(p0.l.a((Throwable)var1)));
      var1 = var3.w();
      if (var1 == s0.b.c()) {
         t0.h.c(var2);
      }

      return var1 == s0.b.c() ? var1 : p0.q.a;
   }

   private final void e0(E var1, h1.j<? super p0.q> var2) {
      z0.l var3 = this.f;
      if (var3 != null) {
         z.b(var3, var1, var2.a());
      }

      Throwable var4 = this.K();
      p0.k.a var5 = p0.k.e;
      var2.u(p0.k.a(p0.l.a(var4)));
   }

   // $FF: synthetic method
   public static final AtomicReferenceFieldUpdater h() {
      return l;
   }

   private final void h0(c2 var1, j<E> var2, int var3) {
      this.g0();
      var1.d(var2, var3);
   }

   // $FF: synthetic method
   public static final AtomicLongFieldUpdater i() {
      return h;
   }

   private final void i0(c2 var1, j<E> var2, int var3) {
      var1.d(var2, var3 + j1.c.b);
   }

   // $FF: synthetic method
   public static final boolean j(j1.b var0, long var1) {
      return var0.U(var1);
   }

   private final void j0(j<E> var1) {
      z0.l var2 = this.f;
      q0 var3 = null;
      Object var4 = m1.n.b((Object)null, 1, (a1.g)null);
      j var5 = var1;

      int var6;
      Object var7;
      j var10;
      q0 var11;
      label103:
      do {
         var6 = j1.c.b - 1;
         var7 = var4;

         label101:
         for(var11 = var3; -1 < var6; --var6) {
            long var8 = var5.g * (long)j1.c.b + (long)var6;

            while(true) {
               var4 = var5.w(var6);
               if (var4 == j1.c.f()) {
                  break label103;
               }

               Object var12;
               q0 var14;
               if (var4 == j1.c.d) {
                  if (var8 < this.J()) {
                     break label103;
                  }

                  if (!var5.r(var6, var4, j1.c.z())) {
                     continue;
                  }

                  var14 = var11;
                  var12 = var7;
                  if (var2 != null) {
                     var14 = z.c(var2, var5.v(var6), var11);
                     var12 = var7;
                  }
               } else {
                  if (var4 == j1.c.k() || var4 == null) {
                     if (var5.r(var6, var4, j1.c.z())) {
                        break;
                     }
                     continue;
                  }

                  if (!(var4 instanceof c2) && !(var4 instanceof v)) {
                     if (var4 == j1.c.p() || var4 == j1.c.q()) {
                        break label103;
                     }

                     if (var4 != j1.c.p()) {
                        continue label101;
                     }
                     continue;
                  }

                  if (var8 < this.J()) {
                     break label103;
                  }

                  c2 var13;
                  if (var4 instanceof v) {
                     var13 = ((v)var4).a;
                  } else {
                     var13 = (c2)var4;
                  }

                  if (!var5.r(var6, var4, j1.c.z())) {
                     continue;
                  }

                  var14 = var11;
                  if (var2 != null) {
                     var14 = z.c(var2, var5.v(var6), var11);
                  }

                  var12 = m1.n.c(var7, var13);
               }

               var5.s(var6);
               var7 = var12;
               var11 = var14;
               break;
            }

            var5.p();
         }

         var10 = (j)var5.g();
         var3 = var11;
         var4 = var7;
         var5 = var10;
      } while(var10 != null);

      if (var7 != null) {
         if (!(var7 instanceof ArrayList)) {
            this.l0((c2)var7);
         } else {
            a1.k.c(var7, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList var15 = (ArrayList)var7;

            for(var6 = var15.size() - 1; -1 < var6; --var6) {
               this.l0((c2)var15.get(var6));
            }
         }
      }

      if (var11 != null) {
         throw var11;
      }
   }

   // $FF: synthetic method
   public static final void k(j1.b var0, Object var1, h1.j var2) {
      var0.e0(var1, var2);
   }

   private final void k0(c2 var1) {
      this.m0(var1, true);
   }

   private final void l0(c2 var1) {
      this.m0(var1, false);
   }

   // $FF: synthetic method
   public static final void m(j1.b var0, c2 var1, j var2, int var3) {
      var0.i0(var1, var2, var3);
   }

   private final void m0(c2 var1, boolean var2) {
      p0.k.a var3;
      Object var5;
      Object var8;
      if (var1 instanceof j1.b.b) {
         var5 = ((j1.b.b)var1).a();
         var3 = p0.k.e;
         var8 = Boolean.FALSE;
      } else if (var1 instanceof h1.j) {
         r0.d var9 = (r0.d)var1;
         p0.k.a var6 = p0.k.e;
         Throwable var7;
         if (var2) {
            var7 = this.I();
         } else {
            var7 = this.K();
         }

         Object var4 = p0.l.a(var7);
         var5 = var9;
         var8 = var4;
      } else {
         if (!(var1 instanceof s)) {
            if (var1 instanceof j1.b.a) {
               ((j1.b.a)var1).j();
            } else {
               if (!(var1 instanceof p1.b)) {
                  StringBuilder var10 = new StringBuilder();
                  var10.append("Unexpected waiter: ");
                  var10.append(var1);
                  throw new IllegalStateException(var10.toString().toString());
               }

               ((p1.b)var1).c(this, j1.c.z());
            }

            return;
         }

         var5 = ((s)var1).e;
         var3 = p0.k.e;
         var8 = j1.h.b(j1.h.b.a(this.H()));
      }

      ((r0.d)var5).u(p0.k.a(var8));
   }

   // $FF: synthetic method
   static <E> Object n0(j1.b<E> var0, E var1, r0.d<? super p0.q> var2) {
      j var3 = (j)h().get(var0);

      while(true) {
         long var4 = i().getAndIncrement(var0);
         long var6 = 1152921504606846975L & var4;
         boolean var8 = j(var0, var4);
         int var9 = j1.c.b;
         var4 = var6 / (long)var9;
         int var10 = (int)(var6 % (long)var9);
         j var11 = var3;
         Object var12;
         if (var3.g != var4) {
            var11 = b(var0, var4, var3);
            if (var11 == null) {
               if (!var8) {
                  continue;
               }

               var12 = var0.d0(var1, var2);
               if (var12 == s0.b.c()) {
                  return var12;
               }
               break;
            }
         }

         var9 = o(var0, var11, var10, var1, var6, (Object)null, var8);
         if (var9 != 0) {
            if (var9 == 1) {
               break;
            }

            if (var9 != 2) {
               if (var9 != 3) {
                  if (var9 != 4) {
                     if (var9 != 5) {
                        var3 = var11;
                     } else {
                        var11.b();
                        var3 = var11;
                     }
                     continue;
                  }

                  if (var6 < var0.J()) {
                     var11.b();
                  }

                  var12 = var0.d0(var1, var2);
                  if (var12 == s0.b.c()) {
                     return var12;
                  }
                  break;
               }

               var12 = var0.o0(var11, var10, var1, var6, var2);
               if (var12 == s0.b.c()) {
                  return var12;
               }
               break;
            }

            if (var8) {
               var11.p();
               var12 = var0.d0(var1, var2);
               if (var12 == s0.b.c()) {
                  return var12;
               }
            }
            break;
         }

         var11.b();
         break;
      }

      return p0.q.a;
   }

   // $FF: synthetic method
   public static final int o(j1.b var0, j var1, int var2, Object var3, long var4, Object var6, boolean var7) {
      return var0.w0(var1, var2, var3, var4, var6, var7);
   }

   private final Object o0(j<E> var1, int var2, E var3, long var4, r0.d<? super p0.q> var6) {
      h1.k var7 = h1.m.a(s0.b.b(var6));

      Object var477;
      label4163: {
         Throwable var10000;
         label4167: {
            int var8;
            boolean var10001;
            try {
               var8 = o(this, var1, var2, var3, var4, var7, false);
            } catch (Throwable var474) {
               var10000 = var474;
               var10001 = false;
               break label4167;
            }

            label4175: {
               p0.k.a var476;
               if (var8 == 0) {
                  try {
                     var1.b();
                     var476 = p0.k.e;
                     var477 = p0.k.a(p0.q.a);
                  } catch (Throwable var462) {
                     var10000 = var462;
                     var10001 = false;
                     break label4167;
                  }
               } else if (var8 == 1) {
                  try {
                     var476 = p0.k.e;
                     var477 = p0.k.a(p0.q.a);
                  } catch (Throwable var463) {
                     var10000 = var463;
                     var10001 = false;
                     break label4167;
                  }
               } else {
                  if (var8 == 2) {
                     try {
                        m(this, var7, var1, var2);
                        break label4163;
                     } catch (Throwable var459) {
                        var10000 = var459;
                        var10001 = false;
                        break label4167;
                     }
                  }

                  if (var8 == 4) {
                     try {
                        if (var4 < this.J()) {
                           var1.b();
                        }
                        break label4175;
                     } catch (Throwable var471) {
                        var10000 = var471;
                        var10001 = false;
                        break label4167;
                     }
                  }

                  IllegalStateException var475;
                  if (var8 != 5) {
                     try {
                        var475 = new IllegalStateException("unexpected".toString());
                        throw var475;
                     } catch (Throwable var455) {
                        var10000 = var455;
                        var10001 = false;
                        break label4167;
                     }
                  }

                  try {
                     var1.b();
                     var1 = (j)h().get(this);
                  } catch (Throwable var470) {
                     var10000 = var470;
                     var10001 = false;
                     break label4167;
                  }

                  while(true) {
                     boolean var11;
                     while(true) {
                        long var9;
                        try {
                           var9 = i().getAndIncrement(this);
                        } catch (Throwable var468) {
                           var10000 = var468;
                           var10001 = false;
                           break label4167;
                        }

                        var4 = var9 & 1152921504606846975L;

                        try {
                           var11 = j(this, var9);
                           var2 = j1.c.b;
                           var9 = var4 / (long)var2;
                        } catch (Throwable var467) {
                           var10000 = var467;
                           var10001 = false;
                           break label4167;
                        }

                        var8 = (int)(var4 % (long)var2);

                        j var12;
                        try {
                           if (var1.g == var9) {
                              break;
                           }

                           var12 = b(this, var9, var1);
                        } catch (Throwable var473) {
                           var10000 = var473;
                           var10001 = false;
                           break label4167;
                        }

                        if (var12 != null) {
                           var1 = var12;
                           break;
                        }

                        if (var11) {
                           break label4175;
                        }
                     }

                     try {
                        var2 = o(this, var1, var8, var3, var4, var7, var11);
                     } catch (Throwable var466) {
                        var10000 = var466;
                        var10001 = false;
                        break label4167;
                     }

                     if (var2 == 0) {
                        try {
                           var1.b();
                           var476 = p0.k.e;
                           var477 = p0.k.a(p0.q.a);
                           break;
                        } catch (Throwable var464) {
                           var10000 = var464;
                           var10001 = false;
                           break label4167;
                        }
                     }

                     if (var2 == 1) {
                        try {
                           var476 = p0.k.e;
                           var477 = p0.k.a(p0.q.a);
                           break;
                        } catch (Throwable var465) {
                           var10000 = var465;
                           var10001 = false;
                           break label4167;
                        }
                     }

                     if (var2 == 2) {
                        if (!var11) {
                           h1.k var478;
                           label4083: {
                              label4082: {
                                 try {
                                    if (var7 instanceof c2) {
                                       break label4082;
                                    }
                                 } catch (Throwable var457) {
                                    var10000 = var457;
                                    var10001 = false;
                                    break label4167;
                                 }

                                 var478 = null;
                                 break label4083;
                              }

                              var478 = var7;
                           }

                           if (var478 == null) {
                              break label4163;
                           }

                           try {
                              m(this, var478, var1, var8);
                              break label4163;
                           } catch (Throwable var456) {
                              var10000 = var456;
                              var10001 = false;
                              break label4167;
                           }
                        }

                        try {
                           var1.p();
                           break label4175;
                        } catch (Throwable var461) {
                           var10000 = var461;
                           var10001 = false;
                           break label4167;
                        }
                     }

                     if (var2 == 3) {
                        try {
                           var475 = new IllegalStateException("unexpected".toString());
                           throw var475;
                        } catch (Throwable var454) {
                           var10000 = var454;
                           var10001 = false;
                           break label4167;
                        }
                     }

                     if (var2 == 4) {
                        try {
                           if (var4 < this.J()) {
                              var1.b();
                           }
                           break label4175;
                        } catch (Throwable var472) {
                           var10000 = var472;
                           var10001 = false;
                           break label4167;
                        }
                     }

                     if (var2 == 5) {
                        try {
                           var1.b();
                        } catch (Throwable var469) {
                           var10000 = var469;
                           var10001 = false;
                           break label4167;
                        }
                     }
                  }
               }

               try {
                  var7.u(var477);
                  break label4163;
               } catch (Throwable var460) {
                  var10000 = var460;
                  var10001 = false;
                  break label4167;
               }
            }

            label4086:
            try {
               k(this, var3, var7);
               break label4163;
            } catch (Throwable var458) {
               var10000 = var458;
               var10001 = false;
               break label4086;
            }
         }

         Throwable var479 = var10000;
         var7.I();
         throw var479;
      }

      var477 = var7.w();
      if (var477 == s0.b.c()) {
         t0.h.c(var6);
      }

      return var477 == s0.b.c() ? var477 : p0.q.a;
   }

   private final boolean p0(long var1) {
      return this.U(var1) ? false : this.r(var1 & 1152921504606846975L) ^ true;
   }

   private final boolean q0(Object var1, E var2) {
      boolean var3;
      if (var1 instanceof p1.b) {
         var3 = ((p1.b)var1).c(this, var2);
      } else {
         var3 = var1 instanceof s;
         h1.k var4 = null;
         h1.j var5 = null;
         z0.l var9;
         if (var3) {
            a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            s var6 = (s)var1;
            var4 = var6.e;
            h var7 = j1.h.b(j1.h.b.c(var2));
            z0.l var8 = this.f;
            var9 = var5;
            if (var8 != null) {
               var9 = z.a(var8, var2, var6.e.a());
            }

            var3 = j1.c.u(var4, var7, var9);
         } else if (var1 instanceof j1.b.a) {
            a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            var3 = ((j1.b.a)var1).i(var2);
         } else {
            if (!(var1 instanceof h1.j)) {
               StringBuilder var10 = new StringBuilder();
               var10.append("Unexpected receiver type: ");
               var10.append(var1);
               throw new IllegalStateException(var10.toString().toString());
            }

            a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            var5 = (h1.j)var1;
            z0.l var11 = this.f;
            var9 = var4;
            if (var11 != null) {
               var9 = z.a(var11, var2, var5.a());
            }

            var3 = j1.c.u(var5, var2, var9);
         }
      }

      return var3;
   }

   private final boolean r(long var1) {
      boolean var3;
      if (var1 >= this.G() && var1 >= this.J() + (long)this.e) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private final boolean r0(Object var1, j<E> var2, int var3) {
      boolean var4;
      h1.j var5;
      if (var1 instanceof h1.j) {
         a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
         var5 = (h1.j)var1;
         var1 = p0.q.a;
      } else {
         if (var1 instanceof p1.b) {
            a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            p1.d var6 = ((p1.a)var1).k(this, p0.q.a);
            if (var6 == p1.d.f) {
               var2.s(var3);
            }

            if (var6 == p1.d.e) {
               var4 = true;
            } else {
               var4 = false;
            }

            return var4;
         }

         if (!(var1 instanceof j1.b.b)) {
            StringBuilder var7 = new StringBuilder();
            var7.append("Unexpected waiter: ");
            var7.append(var1);
            throw new IllegalStateException(var7.toString().toString());
         }

         var5 = ((j1.b.b)var1).a();
         var1 = Boolean.TRUE;
      }

      var4 = j1.c.C(var5, var1, (z0.l)null, 2, (Object)null);
      return var4;
   }

   private final boolean s0(j<E> var1, int var2, long var3) {
      Object var5 = var1.w(var2);
      if (var5 instanceof c2 && var3 >= i.get(this) && var1.r(var2, var5, j1.c.p())) {
         boolean var6 = this.r0(var5, var1, var2);
         boolean var7 = false;
         if (var6) {
            var1.A(var2, j1.c.d);
            var7 = true;
         } else {
            var1.A(var2, j1.c.j());
            var1.x(var2, false);
         }

         return var7;
      } else {
         return this.t0(var1, var2, var3);
      }
   }

   private final void t(j<E> var1, long var2) {
      Object var4 = m1.n.b((Object)null, 1, (a1.g)null);
      j var5 = var1;
      Object var8 = var4;

      int var6;
      label67:
      while(true) {
         var4 = var8;
         if (var5 == null) {
            break;
         }

         for(var6 = j1.c.b - 1; -1 < var6; var8 = var4) {
            var4 = var8;
            if (var5.g * (long)j1.c.b + (long)var6 < var2) {
               break label67;
            }

            label62: {
               label61:
               while(true) {
                  while(true) {
                     Object var7 = var5.w(var6);
                     if (var7 != null && var7 != j1.c.k()) {
                        if (var7 instanceof v) {
                           if (var5.r(var6, var7, j1.c.z())) {
                              var4 = ((v)var7).a;
                              break label61;
                           }
                        } else {
                           var4 = var8;
                           if (!(var7 instanceof c2)) {
                              break label62;
                           }

                           if (var5.r(var6, var7, j1.c.z())) {
                              var4 = var7;
                              break label61;
                           }
                        }
                     } else if (var5.r(var6, var7, j1.c.z())) {
                        var5.p();
                        var4 = var8;
                        break label62;
                     }
                  }
               }

               var4 = m1.n.c(var8, var4);
               var5.x(var6, true);
            }

            --var6;
         }

         var5 = (j)var5.g();
      }

      if (var4 != null) {
         if (!(var4 instanceof ArrayList)) {
            this.k0((c2)var4);
         } else {
            a1.k.c(var4, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList var9 = (ArrayList)var4;

            for(var6 = var9.size() - 1; -1 < var6; --var6) {
               this.k0((c2)var9.get(var6));
            }
         }
      }

   }

   private final boolean t0(j<E> var1, int var2, long var3) {
      while(true) {
         Object var5 = var1.w(var2);
         boolean var6 = var5 instanceof c2;
         boolean var7 = false;
         if (var6) {
            if (var3 < i.get(this)) {
               if (var1.r(var2, var5, new v((c2)var5))) {
                  return true;
               }
            } else if (var1.r(var2, var5, j1.c.p())) {
               if (this.r0(var5, var1, var2)) {
                  var1.A(var2, j1.c.d);
                  var7 = true;
               } else {
                  var1.A(var2, j1.c.j());
                  var1.x(var2, false);
               }

               return var7;
            }
         } else {
            if (var5 == j1.c.j()) {
               return false;
            }

            if (var5 == null) {
               if (var1.r(var2, var5, j1.c.k())) {
                  return true;
               }
            } else {
               if (var5 == j1.c.d) {
                  return true;
               }

               if (var5 != j1.c.o() && var5 != j1.c.f() && var5 != j1.c.i()) {
                  if (var5 == j1.c.z()) {
                     return true;
                  }

                  if (var5 == j1.c.q()) {
                     continue;
                  }

                  StringBuilder var8 = new StringBuilder();
                  var8.append("Unexpected cell state: ");
                  var8.append(var5);
                  throw new IllegalStateException(var8.toString().toString());
               }

               return true;
            }
         }
      }
   }

   private final j<E> u() {
      Object var1 = n.get(this);
      j var2 = (j)l.get(this);
      Object var3 = var1;
      if (var2.g > ((j)var1).g) {
         var3 = var2;
      }

      j var4 = (j)m.get(this);
      Object var5 = var3;
      if (var4.g > ((j)var3).g) {
         var5 = var4;
      }

      return (j)m1.d.b((m1.e)var5);
   }

   private final Object u0(j<E> var1, int var2, long var3, Object var5) {
      Object var6 = var1.w(var2);
      if (var6 == null) {
         if (var3 >= (h.get(this) & 1152921504606846975L)) {
            if (var5 == null) {
               return j1.c.s();
            }

            if (var1.r(var2, var6, var5)) {
               this.C();
               return j1.c.r();
            }
         }
      } else if (var6 == j1.c.d && var1.r(var2, var6, j1.c.f())) {
         this.C();
         return var1.y(var2);
      }

      return this.v0(var1, var2, var3, var5);
   }

   private final Object v0(j<E> var1, int var2, long var3, Object var5) {
      while(true) {
         Object var6 = var1.w(var2);
         if (var6 != null && var6 != j1.c.k()) {
            if (var6 == j1.c.d) {
               if (var1.r(var2, var6, j1.c.f())) {
                  this.C();
                  return var1.y(var2);
               }
            } else {
               if (var6 == j1.c.j()) {
                  return j1.c.h();
               }

               if (var6 == j1.c.o()) {
                  return j1.c.h();
               }

               if (var6 == j1.c.z()) {
                  this.C();
                  return j1.c.h();
               }

               if (var6 != j1.c.p() && var1.r(var2, var6, j1.c.q())) {
                  boolean var7 = var6 instanceof v;
                  var5 = var6;
                  if (var7) {
                     var5 = ((v)var6).a;
                  }

                  Object var8;
                  if (this.r0(var5, var1, var2)) {
                     var1.A(var2, j1.c.f());
                     this.C();
                     var8 = var1.y(var2);
                  } else {
                     var1.A(var2, j1.c.j());
                     var1.x(var2, false);
                     if (var7) {
                        this.C();
                     }

                     var8 = j1.c.h();
                  }

                  return var8;
               }
            }
         } else if (var3 < (h.get(this) & 1152921504606846975L)) {
            if (var1.r(var2, var6, j1.c.o())) {
               this.C();
               return j1.c.h();
            }
         } else {
            if (var5 == null) {
               return j1.c.s();
            }

            if (var1.r(var2, var6, var5)) {
               this.C();
               return j1.c.r();
            }
         }
      }
   }

   private final int w0(j<E> var1, int var2, E var3, long var4, Object var6, boolean var7) {
      var1.B(var2, var3);
      if (var7) {
         return this.x0(var1, var2, var3, var4, var6, var7);
      } else {
         Object var8 = var1.w(var2);
         if (var8 == null) {
            if (this.r(var4)) {
               if (var1.r(var2, (Object)null, j1.c.d)) {
                  return 1;
               }
            } else {
               if (var6 == null) {
                  return 3;
               }

               if (var1.r(var2, (Object)null, var6)) {
                  return 2;
               }
            }
         } else if (var8 instanceof c2) {
            var1.s(var2);
            byte var9;
            if (this.q0(var8, var3)) {
               var1.A(var2, j1.c.f());
               this.f0();
               var9 = 0;
            } else {
               if (var1.t(var2, j1.c.i()) != j1.c.i()) {
                  var1.x(var2, true);
               }

               var9 = 5;
            }

            return var9;
         }

         return this.x0(var1, var2, var3, var4, var6, var7);
      }
   }

   private final void x(long var1) {
      this.j0(this.y(var1));
   }

   private final int x0(j<E> var1, int var2, E var3, long var4, Object var6, boolean var7) {
      while(true) {
         Object var8 = var1.w(var2);
         byte var9 = 0;
         if (var8 == null) {
            if (this.r(var4) && !var7) {
               if (var1.r(var2, (Object)null, j1.c.d)) {
                  return 1;
               }
            } else if (var7) {
               if (var1.r(var2, (Object)null, j1.c.j())) {
                  var1.x(var2, false);
                  return 4;
               }
            } else {
               if (var6 == null) {
                  return 3;
               }

               if (var1.r(var2, (Object)null, var6)) {
                  return 2;
               }
            }
         } else {
            if (var8 == j1.c.k()) {
               if (!var1.r(var2, var8, j1.c.d)) {
                  continue;
               }

               return 1;
            }

            if (var8 == j1.c.i()) {
               var1.s(var2);
               return 5;
            }

            if (var8 == j1.c.o()) {
               var1.s(var2);
               return 5;
            }

            h0 var11 = j1.c.z();
            var1.s(var2);
            if (var8 == var11) {
               this.A();
               return 4;
            }

            var6 = var8;
            if (var8 instanceof v) {
               var6 = ((v)var8).a;
            }

            byte var10;
            if (this.q0(var6, var3)) {
               var1.A(var2, j1.c.f());
               this.f0();
               var10 = var9;
            } else {
               if (var1.t(var2, j1.c.i()) != j1.c.i()) {
                  var1.x(var2, true);
               }

               var10 = 5;
            }

            return var10;
         }
      }
   }

   private final j<E> y(long var1) {
      j var3 = this.u();
      if (this.V()) {
         long var4 = this.X(var3);
         if (var4 != -1L) {
            this.B(var4);
         }
      }

      this.t(var3, var1);
      return var3;
   }

   private final void y0(long var1) {
      AtomicLongFieldUpdater var3 = i;

      long var4;
      do {
         var4 = var3.get(this);
         if (var4 >= var1) {
            return;
         }
      } while(!i.compareAndSet(this, var4, var1));

   }

   private final void z0(long var1) {
      AtomicLongFieldUpdater var3 = h;

      long var4;
      long var6;
      do {
         var4 = var3.get(this);
         var6 = 1152921504606846975L & var4;
         if (var6 >= var1) {
            return;
         }

         var6 = j1.c.b(var6, (int)(var4 >> 60));
      } while(!h.compareAndSet(this, var4, var6));

   }

   public final void A0(long var1) {
      if (!this.W()) {
         while(this.G() <= var1) {
         }

         int var3 = j1.c.g();

         for(int var4 = 0; var4 < var3; ++var4) {
            var1 = this.G();
            if (var1 == (k.get(this) & 4611686018427387903L) && var1 == this.G()) {
               return;
            }
         }

         AtomicLongFieldUpdater var5 = k;

         do {
            var1 = var5.get(this);
         } while(!var5.compareAndSet(this, var1, j1.c.a(var1 & 4611686018427387903L, true)));

         while(true) {
            long var6 = this.G();
            var5 = k;
            var1 = var5.get(this);
            long var8 = var1 & 4611686018427387903L;
            boolean var10;
            if ((4611686018427387904L & var1) != 0L) {
               var10 = true;
            } else {
               var10 = false;
            }

            if (var6 == var8 && var6 == this.G()) {
               do {
                  var1 = var5.get(this);
               } while(!var5.compareAndSet(this, var1, j1.c.a(var1 & 4611686018427387903L, false)));

               return;
            }

            if (!var10) {
               var5.compareAndSet(this, var1, j1.c.a(var8, true));
            }
         }
      }
   }

   protected final void B(long var1) {
      j var3 = (j)m.get(this);

      while(true) {
         long var5;
         int var7;
         j var12;
         do {
            AtomicLongFieldUpdater var4;
            do {
               var4 = i;
               var5 = var4.get(this);
               if (var1 < Math.max((long)this.e + var5, this.G())) {
                  return;
               }
            } while(!var4.compareAndSet(this, var5, var5 + 1L));

            var7 = j1.c.b;
            long var8 = var5 / (long)var7;
            var7 = (int)(var5 % (long)var7);
            var12 = var3;
            if (var3.g == var8) {
               break;
            }

            var12 = this.E(var8, var3);
         } while(var12 == null);

         Object var10 = this.u0(var12, var7, var5, (Object)null);
         if (var10 == j1.c.h()) {
            var3 = var12;
            if (var5 < this.L()) {
               var12.b();
               var3 = var12;
            }
         } else {
            var12.b();
            z0.l var11 = this.f;
            var3 = var12;
            if (var11 != null) {
               q0 var13 = z.d(var11, var10, (q0)null, 2, (Object)null);
               if (var13 != null) {
                  throw var13;
               }

               var3 = var12;
            }
         }
      }
   }

   protected final Throwable H() {
      return (Throwable)o.get(this);
   }

   public final long J() {
      return i.get(this);
   }

   protected final Throwable K() {
      Throwable var1 = this.H();
      Object var2 = var1;
      if (var1 == null) {
         var2 = new n("Channel was closed");
      }

      return (Throwable)var2;
   }

   public final long L() {
      return h.get(this) & 1152921504606846975L;
   }

   public final boolean M() {
      while(true) {
         AtomicReferenceFieldUpdater var1 = m;
         j var2 = (j)var1.get(this);
         long var3 = this.J();
         if (this.L() <= var3) {
            return false;
         }

         int var5 = j1.c.b;
         long var6 = var3 / (long)var5;
         j var8 = var2;
         if (var2.g != var6) {
            var2 = this.E(var6, var2);
            var8 = var2;
            if (var2 == null) {
               if (((j)var1.get(this)).g >= var6) {
                  continue;
               }

               return false;
            }
         }

         var8.b();
         if (this.Q(var8, (int)(var3 % (long)var5), var3)) {
            return true;
         }

         i.compareAndSet(this, var3, var3 + 1L);
      }
   }

   public boolean S() {
      return this.T(h.get(this));
   }

   protected boolean V() {
      return false;
   }

   public final void c(CancellationException var1) {
      this.s(var1);
   }

   protected void c0() {
   }

   public Object e(E var1, r0.d<? super p0.q> var2) {
      return n0(this, var1, var2);
   }

   protected void f0() {
   }

   protected void g0() {
   }

   public f<E> iterator() {
      return new j1.b.a();
   }

   public boolean p(Throwable var1) {
      return this.v(var1, false);
   }

   public Object q(E var1) {
      if (this.p0(h.get(this))) {
         return j1.h.b.b();
      } else {
         h0 var2 = j1.c.j();
         j var3 = (j)h().get(this);

         while(true) {
            long var4 = i().getAndIncrement(this);
            long var6 = var4 & 1152921504606846975L;
            boolean var8 = j(this, var4);
            int var9 = j1.c.b;
            var4 = var6 / (long)var9;
            int var10 = (int)(var6 % (long)var9);
            if (var3.g != var4) {
               j var11 = b(this, var4, var3);
               if (var11 == null) {
                  if (!var8) {
                     continue;
                  }
                  break;
               }

               var3 = var11;
            }

            var9 = o(this, var3, var10, var1, var6, var2, var8);
            if (var9 != 0) {
               if (var9 != 1) {
                  if (var9 != 2) {
                     if (var9 == 3) {
                        throw new IllegalStateException("unexpected".toString());
                     }

                     if (var9 != 4) {
                        if (var9 == 5) {
                           var3.b();
                        }
                        continue;
                     }

                     if (var6 < this.J()) {
                        var3.b();
                     }
                  } else {
                     if (!var8) {
                        c2 var12;
                        if (var2 instanceof c2) {
                           var12 = (c2)var2;
                        } else {
                           var12 = null;
                        }

                        if (var12 != null) {
                           m(this, var12, var3, var10);
                        }

                        var3.p();
                        var1 = j1.h.b.b();
                        return var1;
                     }

                     var3.p();
                  }
                  break;
               }
            } else {
               var3.b();
            }

            var1 = j1.h.b.c(p0.q.a);
            return var1;
         }

         var1 = j1.h.b.a(this.K());
         return var1;
      }
   }

   public boolean s(Throwable var1) {
      Object var2 = var1;
      if (var1 == null) {
         var2 = new CancellationException("Channel was cancelled");
      }

      return this.v((Throwable)var2, true);
   }

   public String toString() {
      StringBuilder var1;
      int var2;
      String var3;
      label167: {
         var1 = new StringBuilder();
         var2 = (int)(h.get(this) >> 60);
         if (var2 != 2) {
            if (var2 != 3) {
               break label167;
            }

            var3 = "cancelled,";
         } else {
            var3 = "closed,";
         }

         var1.append(var3);
      }

      StringBuilder var18 = new StringBuilder();
      var18.append("capacity=");
      var18.append(this.e);
      var18.append(',');
      var1.append(var18.toString());
      var1.append("data=[");
      List var4 = q0.l.g((j)m.get(this), (j)l.get(this), (j)n.get(this));
      ArrayList var19 = new ArrayList();
      Iterator var20 = var4.iterator();

      Object var5;
      while(var20.hasNext()) {
         var5 = var20.next();
         boolean var17;
         if ((j)var5 != j1.c.n()) {
            var17 = true;
         } else {
            var17 = false;
         }

         if (var17) {
            var19.add(var5);
         }
      }

      Iterator var6 = var19.iterator();
      if (!var6.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Object var21 = var6.next();
         long var7;
         long var9;
         long var11;
         Object var22;
         if (!var6.hasNext()) {
            var22 = var21;
         } else {
            var7 = ((j)var21).g;

            do {
               var5 = var6.next();
               var9 = ((j)var5).g;
               var22 = var21;
               var11 = var7;
               if (var7 > var9) {
                  var22 = var5;
                  var11 = var9;
               }

               var21 = var22;
               var7 = var11;
            } while(var6.hasNext());
         }

         j var23 = (j)var22;
         var7 = this.J();
         var9 = this.L();

         label146:
         do {
            int var13 = j1.c.b;

            for(var2 = 0; var2 < var13; ++var2) {
               var11 = var23.g * (long)j1.c.b + (long)var2;
               long var27;
               int var14 = (var27 = var11 - var9) == 0L ? 0 : (var27 < 0L ? -1 : 1);
               if (var14 >= 0 && var11 >= var7) {
                  break label146;
               }

               Object var25 = var23.w(var2);
               var5 = var23.v(var2);
               int var15;
               if (var25 instanceof h1.j) {
                  long var28;
                  var15 = (var28 = var11 - var7) == 0L ? 0 : (var28 < 0L ? -1 : 1);
                  if (var15 < 0 && var14 >= 0) {
                     var3 = "receive";
                  } else if (var14 < 0 && var15 >= 0) {
                     var3 = "send";
                  } else {
                     var3 = "cont";
                  }
               } else if (var25 instanceof p1.b) {
                  long var29;
                  var15 = (var29 = var11 - var7) == 0L ? 0 : (var29 < 0L ? -1 : 1);
                  if (var15 < 0 && var14 >= 0) {
                     var3 = "onReceive";
                  } else if (var14 < 0 && var15 >= 0) {
                     var3 = "onSend";
                  } else {
                     var3 = "select";
                  }
               } else if (var25 instanceof s) {
                  var3 = "receiveCatching";
               } else if (var25 instanceof j1.b.b) {
                  var3 = "sendBroadcast";
               } else if (var25 instanceof v) {
                  var18 = new StringBuilder();
                  var18.append("EB(");
                  var18.append(var25);
                  var18.append(')');
                  var3 = var18.toString();
               } else {
                  boolean var16;
                  if (a1.k.a(var25, j1.c.q())) {
                     var16 = true;
                  } else {
                     var16 = a1.k.a(var25, j1.c.p());
                  }

                  if (var16) {
                     var3 = "resuming_sender";
                  } else {
                     if (var25 == null) {
                        var16 = true;
                     } else {
                        var16 = a1.k.a(var25, j1.c.k());
                     }

                     if (var16) {
                        var16 = true;
                     } else {
                        var16 = a1.k.a(var25, j1.c.f());
                     }

                     if (var16) {
                        var16 = true;
                     } else {
                        var16 = a1.k.a(var25, j1.c.o());
                     }

                     if (var16) {
                        var16 = true;
                     } else {
                        var16 = a1.k.a(var25, j1.c.i());
                     }

                     if (var16) {
                        var16 = true;
                     } else {
                        var16 = a1.k.a(var25, j1.c.j());
                     }

                     if (var16) {
                        var16 = true;
                     } else {
                        var16 = a1.k.a(var25, j1.c.z());
                     }

                     if (var16) {
                        continue;
                     }

                     var3 = var25.toString();
                  }
               }

               if (var5 != null) {
                  StringBuilder var26 = new StringBuilder();
                  var26.append('(');
                  var26.append(var3);
                  var26.append(',');
                  var26.append(var5);
                  var26.append("),");
                  var3 = var26.toString();
               } else {
                  StringBuilder var24 = new StringBuilder();
                  var24.append(var3);
                  var24.append(',');
                  var3 = var24.toString();
               }

               var1.append(var3);
            }

            var23 = (j)var23.e();
         } while(var23 != null);

         if (g1.d.Y(var1) == ',') {
            a1.k.d(var1.deleteCharAt(var1.length() - 1), "this.deleteCharAt(index)");
         }

         var1.append("]");
         return var1.toString();
      }
   }

   protected boolean v(Throwable var1, boolean var2) {
      if (var2) {
         this.Y();
      }

      boolean var3 = androidx.concurrent.futures.b.a(o, this, j1.c.l(), var1);
      if (var2) {
         this.Z();
      } else {
         this.a0();
      }

      this.A();
      this.c0();
      if (var3) {
         this.P();
      }

      return var3;
   }

   public boolean w() {
      return this.U(h.get(this));
   }

   public void z(z0.l<? super Throwable, p0.q> var1) {
      AtomicReferenceFieldUpdater var2 = p;
      if (!androidx.concurrent.futures.b.a(var2, this, (Object)null, var1)) {
         do {
            Object var3 = var2.get(this);
            if (var3 != j1.c.d()) {
               if (var3 == j1.c.e()) {
                  throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
               }

               StringBuilder var4 = new StringBuilder();
               var4.append("Another handler is already registered: ");
               var4.append(var3);
               throw new IllegalStateException(var4.toString().toString());
            }
         } while(!androidx.concurrent.futures.b.a(p, this, j1.c.d(), j1.c.e()));

         var1.i(this.H());
      }
   }

   private final class a implements f<E>, c2 {
      private Object e = j1.c.m();
      private h1.k<? super Boolean> f;

      public a() {
      }

      // $FF: synthetic method
      public static final void b(j1.b.a var0) {
         var0.h();
      }

      // $FF: synthetic method
      public static final void c(j1.b.a var0, h1.k var1) {
         var0.f = var1;
      }

      // $FF: synthetic method
      public static final void e(j1.b.a var0, Object var1) {
         var0.e = var1;
      }

      private final Object f(j<E> var1, int var2, long var3, r0.d<? super Boolean> var5) {
         j1.b var6 = b.this;
         h1.k var7 = h1.m.a(s0.b.b(var5));

         label2354: {
            Throwable var10000;
            label2363: {
               Object var8;
               boolean var10001;
               try {
                  c(this, var7);
                  var8 = var6.u0(var1, var2, var3, this);
                  if (var8 == j1.c.r()) {
                     var6.h0(this, var1, var2);
                     break label2354;
                  }
               } catch (Throwable var279) {
                  var10000 = var279;
                  var10001 = false;
                  break label2363;
               }

               h0 var9;
               try {
                  var9 = j1.c.h();
               } catch (Throwable var278) {
                  var10000 = var278;
                  var10001 = false;
                  break label2363;
               }

               Object var10 = null;
               Boolean var13;
               z0.l var286;
               z0.l var290;
               Boolean var292;
               if (var8 != var9) {
                  try {
                     var1.b();
                     e(this, var8);
                     c(this, (h1.k)null);
                     var13 = t0.b.a(true);
                     var290 = var6.f;
                  } catch (Throwable var273) {
                     var10000 = var273;
                     var10001 = false;
                     break label2363;
                  }

                  var286 = (z0.l)var10;
                  var292 = var13;
                  if (var290 != null) {
                     try {
                        var286 = z.a(var290, var8, var7.a());
                     } catch (Throwable var272) {
                        var10000 = var272;
                        var10001 = false;
                        break label2363;
                     }

                     var292 = var13;
                  }
               } else {
                  try {
                     if (var3 < var6.L()) {
                        var1.b();
                     }
                  } catch (Throwable var285) {
                     var10000 = var285;
                     var10001 = false;
                     break label2363;
                  }

                  try {
                     var1 = (j)j1.b.m.get(var6);
                  } catch (Throwable var277) {
                     var10000 = var277;
                     var10001 = false;
                     break label2363;
                  }

                  while(true) {
                     try {
                        if (var6.S()) {
                           b(this);
                           break label2354;
                        }
                     } catch (Throwable var284) {
                        var10000 = var284;
                        var10001 = false;
                        break label2363;
                     }

                     long var11;
                     try {
                        var3 = j1.b.i.getAndIncrement(var6);
                        var2 = j1.c.b;
                        var11 = var3 / (long)var2;
                     } catch (Throwable var276) {
                        var10000 = var276;
                        var10001 = false;
                        break label2363;
                     }

                     var2 = (int)(var3 % (long)var2);
                     j var291 = var1;

                     label2336: {
                        try {
                           if (var1.g == var11) {
                              break label2336;
                           }

                           var291 = var6.E(var11, var1);
                        } catch (Throwable var283) {
                           var10000 = var283;
                           var10001 = false;
                           break label2363;
                        }

                        if (var291 == null) {
                           continue;
                        }
                     }

                     try {
                        var8 = var6.u0(var291, var2, var3, this);
                        if (var8 == j1.c.r()) {
                           var6.h0(this, var291, var2);
                           break label2354;
                        }
                     } catch (Throwable var275) {
                        var10000 = var275;
                        var10001 = false;
                        break label2363;
                     }

                     label2361: {
                        try {
                           if (var8 == j1.c.h()) {
                              break label2361;
                           }
                        } catch (Throwable var282) {
                           var10000 = var282;
                           var10001 = false;
                           break label2363;
                        }

                        label2316: {
                           try {
                              if (var8 == j1.c.s()) {
                                 break label2316;
                              }

                              var291.b();
                              e(this, var8);
                              c(this, (h1.k)null);
                              var13 = t0.b.a(true);
                              var290 = var6.f;
                           } catch (Throwable var280) {
                              var10000 = var280;
                              var10001 = false;
                              break label2363;
                           }

                           var286 = (z0.l)var10;
                           var292 = var13;
                           if (var290 != null) {
                              try {
                                 var286 = z.a(var290, var8, var7.a());
                              } catch (Throwable var274) {
                                 var10000 = var274;
                                 var10001 = false;
                                 break label2363;
                              }

                              var292 = var13;
                           }
                           break;
                        }

                        try {
                           IllegalStateException var287 = new IllegalStateException("unexpected".toString());
                           throw var287;
                        } catch (Throwable var270) {
                           var10000 = var270;
                           var10001 = false;
                           break label2363;
                        }
                     }

                     var1 = var291;

                     try {
                        if (var3 >= var6.L()) {
                           continue;
                        }

                        var291.b();
                     } catch (Throwable var281) {
                        var10000 = var281;
                        var10001 = false;
                        break label2363;
                     }

                     var1 = var291;
                  }
               }

               label2288:
               try {
                  var7.K(var292, var286);
                  break label2354;
               } catch (Throwable var271) {
                  var10000 = var271;
                  var10001 = false;
                  break label2288;
               }
            }

            Throwable var288 = var10000;
            var7.I();
            throw var288;
         }

         Object var289 = var7.w();
         if (var289 == s0.b.c()) {
            t0.h.c(var5);
         }

         return var289;
      }

      private final boolean g() {
         this.e = j1.c.z();
         Throwable var1 = b.this.H();
         if (var1 == null) {
            return false;
         } else {
            throw g0.a(var1);
         }
      }

      private final void h() {
         h1.k var1 = this.f;
         a1.k.b(var1);
         this.f = null;
         this.e = j1.c.z();
         Throwable var2 = b.this.H();
         p0.k.a var3;
         Object var4;
         if (var2 == null) {
            var3 = p0.k.e;
            var4 = Boolean.FALSE;
         } else {
            var3 = p0.k.e;
            var4 = p0.l.a(var2);
         }

         var1.u(p0.k.a(var4));
      }

      public Object a(r0.d<? super Boolean> var1) {
         j1.b var2 = b.this;
         j var3 = (j)j1.b.m.get(var2);

         boolean var4;
         while(true) {
            if (var2.S()) {
               var4 = this.g();
               break;
            }

            long var5 = j1.b.i.getAndIncrement(var2);
            int var7 = j1.c.b;
            long var8 = var5 / (long)var7;
            var7 = (int)(var5 % (long)var7);
            if (var3.g != var8) {
               j var10 = var2.E(var8, var3);
               if (var10 == null) {
                  continue;
               }

               var3 = var10;
            }

            Object var11 = var2.u0(var3, var7, var5, (Object)null);
            if (var11 == j1.c.r()) {
               throw new IllegalStateException("unreachable".toString());
            }

            if (var11 != j1.c.h()) {
               if (var11 == j1.c.s()) {
                  return this.f(var3, var7, var5, var1);
               }

               var3.b();
               this.e = var11;
               var4 = true;
               break;
            }

            if (var5 < var2.L()) {
               var3.b();
            }
         }

         Boolean var12 = t0.b.a(var4);
         return var12;
      }

      public void d(e0<?> var1, int var2) {
         h1.k var3 = this.f;
         if (var3 != null) {
            var3.d(var1, var2);
         }

      }

      public final boolean i(E var1) {
         h1.k var2 = this.f;
         a1.k.b(var2);
         z0.l var3 = null;
         this.f = null;
         this.e = var1;
         Boolean var4 = Boolean.TRUE;
         z0.l var5 = b.this.f;
         if (var5 != null) {
            var3 = z.a(var5, var1, var2.a());
         }

         return j1.c.u(var2, var4, var3);
      }

      public final void j() {
         h1.k var1 = this.f;
         a1.k.b(var1);
         this.f = null;
         this.e = j1.c.z();
         Throwable var2 = b.this.H();
         p0.k.a var3;
         Object var4;
         if (var2 == null) {
            var3 = p0.k.e;
            var4 = Boolean.FALSE;
         } else {
            var3 = p0.k.e;
            var4 = p0.l.a(var2);
         }

         var1.u(p0.k.a(var4));
      }

      public E next() {
         Object var1 = this.e;
         boolean var2;
         if (var1 != j1.c.m()) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var2) {
            this.e = j1.c.m();
            if (var1 != j1.c.z()) {
               return var1;
            } else {
               throw g0.a(b.this.I());
            }
         } else {
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
         }
      }
   }

   private static final class b implements c2 {
      private final h1.j<Boolean> e;
      // $FF: synthetic field
      private final h1.k<Boolean> f;

      public final h1.j<Boolean> a() {
         return this.e;
      }

      public void d(e0<?> var1, int var2) {
         this.f.d(var1, var2);
      }
   }
}
