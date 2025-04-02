package h1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class u0 extends v0 implements l0 {
   private static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(u0.class, Object.class, "_queue");
   private static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(u0.class, Object.class, "_delayed");
   private static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(u0.class, "_isCompleted");
   private volatile Object _delayed;
   private volatile int _isCompleted = 0;
   private volatile Object _queue;

   // $FF: synthetic method
   public static final boolean H(u0 var0) {
      return var0.M();
   }

   private final void I() {
      AtomicReferenceFieldUpdater var1 = j;

      label25:
      do {
         Object var2;
         m1.u var3;
         do {
            var2 = var1.get(this);
            if (var2 == null) {
               continue label25;
            }

            if (var2 instanceof m1.u) {
               ((m1.u)var2).d();
               return;
            }

            if (var2 == x0.a()) {
               return;
            }

            var3 = new m1.u(8, true);
            a1.k.c(var2, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            var3.a((Runnable)var2);
         } while(!androidx.concurrent.futures.b.a(j, this, var2, var3));

         return;
      } while(!androidx.concurrent.futures.b.a(j, this, (Object)null, x0.a()));

   }

   private final Runnable J() {
      AtomicReferenceFieldUpdater var1 = j;

      while(true) {
         Object var2 = var1.get(this);
         if (var2 == null) {
            return null;
         }

         if (var2 instanceof m1.u) {
            a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
            m1.u var3 = (m1.u)var2;
            Object var4 = var3.j();
            if (var4 != m1.u.h) {
               return (Runnable)var4;
            }

            androidx.concurrent.futures.b.a(j, this, var2, var3.i());
         } else {
            if (var2 == x0.a()) {
               return null;
            }

            if (androidx.concurrent.futures.b.a(j, this, var2, (Object)null)) {
               a1.k.c(var2, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
               return (Runnable)var2;
            }
         }
      }
   }

   private final boolean L(Runnable var1) {
      AtomicReferenceFieldUpdater var2 = j;

      while(true) {
         Object var3 = var2.get(this);
         if (this.M()) {
            return false;
         }

         if (var3 == null) {
            if (androidx.concurrent.futures.b.a(j, this, (Object)null, var1)) {
               return true;
            }
         } else {
            m1.u var4;
            if (var3 instanceof m1.u) {
               a1.k.c(var3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
               var4 = (m1.u)var3;
               int var5 = var4.a(var1);
               if (var5 == 0) {
                  return true;
               }

               if (var5 != 1) {
                  if (var5 == 2) {
                     return false;
                  }
               } else {
                  androidx.concurrent.futures.b.a(j, this, var3, var4.i());
               }
            } else {
               if (var3 == x0.a()) {
                  return false;
               }

               var4 = new m1.u(8, true);
               a1.k.c(var3, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
               var4.a((Runnable)var3);
               var4.a(var1);
               if (androidx.concurrent.futures.b.a(j, this, var3, var4)) {
                  return true;
               }
            }
         }
      }
   }

   private final boolean M() {
      boolean var1;
      if (l.get(this) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private final void P() {
      h1.c.a();
      long var1 = System.nanoTime();

      while(true) {
         u0.b var3 = (u0.b)k.get(this);
         if (var3 == null) {
            break;
         }

         u0.a var4 = (u0.a)var3.i();
         if (var4 == null) {
            break;
         }

         this.F(var1, var4);
      }

   }

   private final int S(long var1, u0.a var3) {
      if (this.M()) {
         return 1;
      } else {
         AtomicReferenceFieldUpdater var4 = k;
         u0.b var5 = (u0.b)var4.get(this);
         u0.b var6 = var5;
         if (var5 == null) {
            androidx.concurrent.futures.b.a(var4, this, (Object)null, new u0.b(var1));
            Object var7 = var4.get(this);
            a1.k.b(var7);
            var6 = (u0.b)var7;
         }

         return var3.h(var1, var6, this);
      }
   }

   private final void T(boolean var1) {
      l.set(this, var1);
   }

   private final boolean U(u0.a var1) {
      u0.b var2 = (u0.b)k.get(this);
      u0.a var4;
      if (var2 != null) {
         var4 = (u0.a)var2.e();
      } else {
         var4 = null;
      }

      boolean var3;
      if (var4 == var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public void K(Runnable var1) {
      if (this.L(var1)) {
         this.G();
      } else {
         j0.m.K(var1);
      }

   }

   protected boolean N() {
      boolean var1 = this.C();
      boolean var2 = false;
      if (!var1) {
         return false;
      } else {
         u0.b var3 = (u0.b)k.get(this);
         if (var3 != null && !var3.d()) {
            return false;
         } else {
            Object var4 = j.get(this);
            if (var4 != null) {
               if (var4 instanceof m1.u) {
                  var2 = ((m1.u)var4).g();
                  return var2;
               }

               if (var4 != x0.a()) {
                  return var2;
               }
            }

            var2 = true;
            return var2;
         }
      }
   }

   public long O() {
      if (this.D()) {
         return 0L;
      } else {
         u0.b var1 = (u0.b)k.get(this);
         if (var1 != null && !var1.d()) {
            h1.c.a();
            long var2 = System.nanoTime();

            m1.o0 var5;
            do {
               synchronized(var1){}

               Throwable var10000;
               label260: {
                  m1.o0 var4;
                  boolean var10001;
                  try {
                     var4 = var1.b();
                  } catch (Throwable var18) {
                     var10000 = var18;
                     var10001 = false;
                     break label260;
                  }

                  var5 = null;
                  if (var4 == null) {
                     continue;
                  }

                  boolean var6;
                  label244: {
                     try {
                        u0.a var19 = (u0.a)var4;
                        if (var19.i(var2)) {
                           var6 = this.L(var19);
                           break label244;
                        }
                     } catch (Throwable var17) {
                        var10000 = var17;
                        var10001 = false;
                        break label260;
                     }

                     var6 = false;
                  }

                  if (!var6) {
                     continue;
                  }

                  label236:
                  try {
                     var5 = var1.h(0);
                     continue;
                  } catch (Throwable var16) {
                     var10000 = var16;
                     var10001 = false;
                     break label236;
                  }
               }

               Throwable var20 = var10000;
               throw var20;
            } while((u0.a)var5 != null);
         }

         Runnable var21 = this.J();
         if (var21 != null) {
            var21.run();
            return 0L;
         } else {
            return this.r();
         }
      }
   }

   protected final void Q() {
      j.set(this, (Object)null);
      k.set(this, (Object)null);
   }

   public final void R(long var1, u0.a var3) {
      int var4 = this.S(var1, var3);
      if (var4 != 0) {
         if (var4 != 1) {
            if (var4 != 2) {
               throw new IllegalStateException("unexpected result".toString());
            }
         } else {
            this.F(var1, var3);
         }
      } else if (this.U(var3)) {
         this.G();
      }

   }

   public final void a(r0.g var1, Runnable var2) {
      this.K(var2);
   }

   protected long r() {
      if (super.r() == 0L) {
         return 0L;
      } else {
         Object var1 = j.get(this);
         if (var1 != null) {
            if (!(var1 instanceof m1.u)) {
               if (var1 == x0.a()) {
                  return Long.MAX_VALUE;
               }

               return 0L;
            }

            if (!((m1.u)var1).g()) {
               return 0L;
            }
         }

         u0.b var4 = (u0.b)k.get(this);
         if (var4 != null) {
            u0.a var5 = (u0.a)var4.e();
            if (var5 != null) {
               long var2 = var5.e;
               h1.c.a();
               return d1.d.b(var2 - System.nanoTime(), 0L);
            }
         }

         return Long.MAX_VALUE;
      }
   }

   public void shutdown() {
      y1.a.b();
      this.T(true);
      this.I();

      while(this.O() <= 0L) {
      }

      this.P();
   }

   public abstract static class a implements Runnable, Comparable<u0.a>, r0, m1.o0 {
      private volatile Object _heap;
      public long e;
      private int f;

      public final void a() {
         synchronized(this){}

         Throwable var10000;
         label226: {
            Object var1;
            boolean var10001;
            m1.h0 var2;
            try {
               var1 = this._heap;
               var2 = x0.b();
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label226;
            }

            if (var1 == var2) {
               return;
            }

            u0.b var23;
            label216: {
               try {
                  if (var1 instanceof u0.b) {
                     var23 = (u0.b)var1;
                     break label216;
                  }
               } catch (Throwable var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label226;
               }

               var23 = null;
            }

            if (var23 != null) {
               try {
                  var23.g(this);
               } catch (Throwable var20) {
                  var10000 = var20;
                  var10001 = false;
                  break label226;
               }
            }

            label205:
            try {
               this._heap = x0.b();
               p0.q var25 = p0.q.a;
               return;
            } catch (Throwable var19) {
               var10000 = var19;
               var10001 = false;
               break label205;
            }
         }

         Throwable var24 = var10000;
         throw var24;
      }

      public void b(int var1) {
         this.f = var1;
      }

      public m1.n0<?> d() {
         Object var1 = this._heap;
         m1.n0 var2;
         if (var1 instanceof m1.n0) {
            var2 = (m1.n0)var1;
         } else {
            var2 = null;
         }

         return var2;
      }

      public int e() {
         return this.f;
      }

      public void f(m1.n0<?> var1) {
         boolean var2;
         if (this._heap != x0.b()) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var2) {
            this._heap = var1;
         } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }
      }

      public int g(u0.a var1) {
         long var4;
         int var2 = (var4 = this.e - var1.e - 0L) == 0L ? 0 : (var4 < 0L ? -1 : 1);
         byte var3;
         if (var2 > 0) {
            var3 = 1;
         } else if (var2 < 0) {
            var3 = -1;
         } else {
            var3 = 0;
         }

         return var3;
      }

      public final int h(long param1, u0.b param3, u0 param4) {
         // $FF: Couldn't be decompiled
      }

      public final boolean i(long var1) {
         boolean var3;
         if (var1 - this.e >= 0L) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Delayed[nanos=");
         var1.append(this.e);
         var1.append(']');
         return var1.toString();
      }
   }

   public static final class b extends m1.n0<u0.a> {
      public long c;

      public b(long var1) {
         this.c = var1;
      }
   }
}
