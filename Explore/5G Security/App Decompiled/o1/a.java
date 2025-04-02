package o1;

import a1.q;
import h1.i0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import m1.c0;
import m1.h0;

public final class a implements Executor, Closeable {
   public static final o1.a.a l = new o1.a.a((a1.g)null);
   private static final AtomicLongFieldUpdater m = AtomicLongFieldUpdater.newUpdater(o1.a.class, "parkedWorkersStack");
   private static final AtomicLongFieldUpdater n = AtomicLongFieldUpdater.newUpdater(o1.a.class, "controlState");
   private static final AtomicIntegerFieldUpdater o = AtomicIntegerFieldUpdater.newUpdater(o1.a.class, "_isTerminated");
   public static final h0 p = new h0("NOT_IN_STACK");
   private volatile int _isTerminated;
   private volatile long controlState;
   public final int e;
   public final int f;
   public final long g;
   public final String h;
   public final o1.d i;
   public final o1.d j;
   public final c0<o1.a.c> k;
   private volatile long parkedWorkersStack;

   public a(int var1, int var2, long var3, String var5) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var5;
      boolean var6 = true;
      boolean var7;
      if (var1 >= 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      StringBuilder var9;
      if (var7) {
         if (var2 >= var1) {
            var7 = true;
         } else {
            var7 = false;
         }

         if (var7) {
            if (var2 <= 2097150) {
               var7 = true;
            } else {
               var7 = false;
            }

            if (var7) {
               boolean var8;
               if (var3 > 0L) {
                  var8 = var6;
               } else {
                  var8 = false;
               }

               if (var8) {
                  this.i = new o1.d();
                  this.j = new o1.d();
                  this.k = new c0((var1 + 1) * 2);
                  this.controlState = (long)var1 << 42;
                  this._isTerminated = 0;
               } else {
                  var9 = new StringBuilder();
                  var9.append("Idle worker keep alive time ");
                  var9.append(var3);
                  var9.append(" must be positive");
                  throw new IllegalArgumentException(var9.toString().toString());
               }
            } else {
               var9 = new StringBuilder();
               var9.append("Max pool size ");
               var9.append(var2);
               var9.append(" should not exceed maximal supported number of threads 2097150");
               throw new IllegalArgumentException(var9.toString().toString());
            }
         } else {
            var9 = new StringBuilder();
            var9.append("Max pool size ");
            var9.append(var2);
            var9.append(" should be greater than or equals to core pool size ");
            var9.append(var1);
            throw new IllegalArgumentException(var9.toString().toString());
         }
      } else {
         var9 = new StringBuilder();
         var9.append("Core pool size ");
         var9.append(var1);
         var9.append(" should be at least 1");
         throw new IllegalArgumentException(var9.toString().toString());
      }
   }

   private final boolean b(h var1) {
      int var2 = var1.f.a();
      boolean var3 = true;
      if (var2 != 1) {
         var3 = false;
      }

      o1.d var4;
      if (var3) {
         var4 = this.j;
      } else {
         var4 = this.i;
      }

      return var4.a(var1);
   }

   private final int c() {
      c0 var1 = this.k;
      synchronized(var1){}

      Throwable var10000;
      label879: {
         boolean var2;
         boolean var10001;
         try {
            var2 = this.isTerminated();
         } catch (Throwable var100) {
            var10000 = var100;
            var10001 = false;
            break label879;
         }

         if (var2) {
            return -1;
         }

         AtomicLongFieldUpdater var3;
         long var4;
         try {
            var3 = n;
            var4 = var3.get(this);
         } catch (Throwable var99) {
            var10000 = var99;
            var10001 = false;
            break label879;
         }

         int var6 = (int)(var4 & 2097151L);
         int var7 = (int)((var4 & 4398044413952L) >> 21);
         boolean var8 = false;

         int var9;
         try {
            var7 = d1.d.a(var6 - var7, 0);
            var9 = this.e;
         } catch (Throwable var98) {
            var10000 = var98;
            var10001 = false;
            break label879;
         }

         if (var7 >= var9) {
            return 0;
         }

         try {
            var9 = this.f;
         } catch (Throwable var97) {
            var10000 = var97;
            var10001 = false;
            break label879;
         }

         if (var6 >= var9) {
            return 0;
         }

         try {
            var9 = (int)(a().get(this) & 2097151L) + 1;
         } catch (Throwable var96) {
            var10000 = var96;
            var10001 = false;
            break label879;
         }

         boolean var103;
         label852: {
            label851: {
               if (var9 > 0) {
                  try {
                     if (this.k.b(var9) == null) {
                        break label851;
                     }
                  } catch (Throwable var95) {
                     var10000 = var95;
                     var10001 = false;
                     break label879;
                  }
               }

               var103 = false;
               break label852;
            }

            var103 = true;
         }

         IllegalArgumentException var101;
         if (var103) {
            label880: {
               o1.a.c var10;
               try {
                  var10 = new o1.a.c(var9);
                  this.k.c(var9, var10);
                  var4 = var3.incrementAndGet(this);
               } catch (Throwable var93) {
                  var10000 = var93;
                  var10001 = false;
                  break label880;
               }

               var103 = var8;
               if (var9 == (int)(2097151L & var4)) {
                  var103 = true;
               }

               if (var103) {
                  var10.start();
                  return var7 + 1;
               }

               label835:
               try {
                  var101 = new IllegalArgumentException("Failed requirement.".toString());
                  throw var101;
               } catch (Throwable var92) {
                  var10000 = var92;
                  var10001 = false;
                  break label835;
               }
            }
         } else {
            label843:
            try {
               var101 = new IllegalArgumentException("Failed requirement.".toString());
               throw var101;
            } catch (Throwable var94) {
               var10000 = var94;
               var10001 = false;
               break label843;
            }
         }
      }

      Throwable var102 = var10000;
      throw var102;
   }

   private final o1.a.c e() {
      Thread var1 = Thread.currentThread();
      boolean var2 = var1 instanceof o1.a.c;
      Object var3 = null;
      o1.a.c var5;
      if (var2) {
         var5 = (o1.a.c)var1;
      } else {
         var5 = null;
      }

      o1.a.c var4 = (o1.a.c)var3;
      if (var5 != null) {
         var4 = (o1.a.c)var3;
         if (a1.k.a(a.this, this)) {
            var4 = var5;
         }
      }

      return var4;
   }

   // $FF: synthetic method
   public static void g(o1.a var0, Runnable var1, i var2, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = o1.l.g;
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      var0.f(var1, var2, var3);
   }

   private final int h(o1.a.c var1) {
      int var2;
      do {
         Object var3 = var1.i();
         if (var3 == p) {
            return -1;
         }

         if (var3 == null) {
            return 0;
         }

         var1 = (o1.a.c)var3;
         var2 = var1.h();
      } while(var2 == 0);

      return var2;
   }

   private final o1.a.c i() {
      AtomicLongFieldUpdater var1 = m;

      long var2;
      int var4;
      o1.a.c var5;
      do {
         var2 = var1.get(this);
         var4 = (int)(2097151L & var2);
         var5 = (o1.a.c)this.k.b(var4);
         if (var5 == null) {
            return null;
         }

         var4 = this.h(var5);
      } while(var4 < 0 || !m.compareAndSet(this, var2, (long)var4 | 2097152L + var2 & -2097152L));

      var5.r(p);
      return var5;
   }

   private final void n(long var1, boolean var3) {
      if (!var3) {
         if (!this.s()) {
            if (!this.q(var1)) {
               this.s();
            }
         }
      }
   }

   private final h p(o1.a.c var1, h var2, boolean var3) {
      if (var1 == null) {
         return var2;
      } else if (var1.g == o1.a.d.i) {
         return var2;
      } else if (var2.f.a() == 0 && var1.g == o1.a.d.f) {
         return var2;
      } else {
         var1.k = true;
         return var1.e.a(var2, var3);
      }
   }

   private final boolean q(long var1) {
      if (d1.d.a((int)(2097151L & var1) - (int)((var1 & 4398044413952L) >> 21), 0) < this.e) {
         int var3 = this.c();
         if (var3 == 1 && this.e > 1) {
            this.c();
         }

         if (var3 > 0) {
            return true;
         }
      }

      return false;
   }

   // $FF: synthetic method
   static boolean r(o1.a var0, long var1, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = n.get(var0);
      }

      return var0.q(var1);
   }

   private final boolean s() {
      o1.a.c var1;
      do {
         var1 = this.i();
         if (var1 == null) {
            return false;
         }
      } while(!o1.a.c.j().compareAndSet(var1, -1, 0));

      LockSupport.unpark(var1);
      return true;
   }

   public void close() {
      this.m(10000L);
   }

   public final h d(Runnable var1, i var2) {
      long var3 = o1.l.f.a();
      if (var1 instanceof h) {
         h var5 = (h)var1;
         var5.e = var3;
         var5.f = var2;
         return var5;
      } else {
         return new k(var1, var3, var2);
      }
   }

   public void execute(Runnable var1) {
      g(this, var1, (i)null, false, 6, (Object)null);
   }

   public final void f(Runnable var1, i var2, boolean var3) {
      h1.c.a();
      h var11 = this.d(var1, var2);
      int var4 = var11.f.a();
      boolean var5 = false;
      boolean var12;
      if (var4 == 1) {
         var12 = true;
      } else {
         var12 = false;
      }

      long var6;
      if (var12) {
         var6 = n.addAndGet(this, 2097152L);
      } else {
         var6 = 0L;
      }

      o1.a.c var9 = this.e();
      var11 = this.p(var9, var11, var3);
      if (var11 != null && !this.b(var11)) {
         StringBuilder var10 = new StringBuilder();
         var10.append(this.h);
         var10.append(" was terminated");
         throw new RejectedExecutionException(var10.toString());
      } else {
         boolean var8 = var5;
         if (var3) {
            var8 = var5;
            if (var9 != null) {
               var8 = true;
            }
         }

         if (var12) {
            this.n(var6, var8);
         } else {
            if (var8) {
               return;
            }

            this.o();
         }

      }
   }

   public final boolean isTerminated() {
      boolean var1;
      if (o.get(this) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean j(o1.a.c var1) {
      if (var1.i() != p) {
         return false;
      } else {
         AtomicLongFieldUpdater var2 = m;

         long var3;
         int var6;
         do {
            var3 = var2.get(this);
            int var5 = (int)(2097151L & var3);
            var6 = var1.h();
            var1.r(this.k.b(var5));
         } while(!m.compareAndSet(this, var3, 2097152L + var3 & -2097152L | (long)var6));

         return true;
      }
   }

   public final void k(o1.a.c var1, int var2, int var3) {
      AtomicLongFieldUpdater var4 = m;

      long var5;
      int var8;
      do {
         var5 = var4.get(this);
         int var7 = (int)(2097151L & var5);
         var8 = var7;
         if (var7 == var2) {
            if (var3 == 0) {
               var8 = this.h(var1);
            } else {
               var8 = var3;
            }
         }
      } while(var8 < 0 || !m.compareAndSet(this, var5, 2097152L + var5 & -2097152L | (long)var8));

   }

   public final void l(h var1) {
      try {
         var1.run();
      } catch (Throwable var8) {
         Throwable var9 = var8;

         try {
            Thread var2 = Thread.currentThread();
            var2.getUncaughtExceptionHandler().uncaughtException(var2, var9);
            return;
         } finally {
            h1.c.a();
         }
      }

   }

   public final void m(long var1) {
      if (o.compareAndSet(this, 0, 1)) {
         o1.a.c var3 = this.e();
         c0 var4 = this.k;
         synchronized(var4){}
         boolean var11 = false;

         long var5;
         try {
            var11 = true;
            var5 = a().get(this);
            var11 = false;
         } finally {
            if (var11) {
               ;
            }
         }

         int var7 = (int)(var5 & 2097151L);
         if (1 <= var7) {
            int var8 = 1;

            while(true) {
               Object var13 = this.k.b(var8);
               a1.k.b(var13);
               o1.a.c var14 = (o1.a.c)var13;
               if (var14 != var3) {
                  while(var14.isAlive()) {
                     LockSupport.unpark(var14);
                     var14.join(var1);
                  }

                  var14.e.f(this.j);
               }

               if (var8 == var7) {
                  break;
               }

               ++var8;
            }
         }

         this.j.b();
         this.i.b();

         while(true) {
            h var15;
            label97: {
               h var9;
               if (var3 != null) {
                  var9 = var3.g(true);
                  var15 = var9;
                  if (var9 != null) {
                     break label97;
                  }
               }

               var9 = (h)this.i.d();
               var15 = var9;
               if (var9 == null) {
                  var9 = (h)this.j.d();
                  var15 = var9;
                  if (var9 == null) {
                     if (var3 != null) {
                        var3.u(o1.a.d.i);
                     }

                     m.set(this, 0L);
                     n.set(this, 0L);
                     return;
                  }
               }
            }

            this.l(var15);
         }
      }
   }

   public final void o() {
      if (!this.s()) {
         if (!r(this, 0L, 1, (Object)null)) {
            this.s();
         }
      }
   }

   public String toString() {
      ArrayList var1 = new ArrayList();
      int var2 = this.k.a();
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;

      int var13;
      StringBuilder var20;
      for(int var8 = 1; var8 < var2; var7 = var13) {
         o1.a.c var9 = (o1.a.c)this.k.b(var8);
         int var10;
         int var11;
         int var12;
         if (var9 == null) {
            var10 = var3;
            var11 = var4;
            var12 = var5;
            var13 = var7;
         } else {
            int var14 = var9.e.e();
            o1.a.d var19 = var9.g;
            var10 = o1.a.b.a[var19.ordinal()];
            if (var10 != 1) {
               label32: {
                  char var16;
                  byte var21;
                  if (var10 != 2) {
                     if (var10 != 3) {
                        if (var10 != 4) {
                           if (var10 != 5) {
                              var10 = var3;
                              var11 = var4;
                              var12 = var5;
                              var13 = var7;
                           } else {
                              var13 = var7 + 1;
                              var10 = var3;
                              var11 = var4;
                              var12 = var5;
                           }
                           break label32;
                        }

                        int var15 = var6 + 1;
                        var10 = var3;
                        var11 = var4;
                        var12 = var5;
                        var6 = var15;
                        var13 = var7;
                        if (var14 <= 0) {
                           break label32;
                        }

                        var20 = new StringBuilder();
                        var20.append(var14);
                        var21 = 100;
                        var6 = var15;
                        var16 = (char)var21;
                     } else {
                        ++var3;
                        var20 = new StringBuilder();
                        var20.append(var14);
                        var21 = 99;
                        var16 = (char)var21;
                     }
                  } else {
                     ++var4;
                     var20 = new StringBuilder();
                     var20.append(var14);
                     var21 = 98;
                     var16 = (char)var21;
                  }

                  var20.append(var16);
                  var1.add(var20.toString());
                  var10 = var3;
                  var11 = var4;
                  var12 = var5;
                  var13 = var7;
               }
            } else {
               var12 = var5 + 1;
               var13 = var7;
               var11 = var4;
               var10 = var3;
            }
         }

         ++var8;
         var3 = var10;
         var4 = var11;
         var5 = var12;
      }

      long var17 = n.get(this);
      var20 = new StringBuilder();
      var20.append(this.h);
      var20.append('@');
      var20.append(i0.b(this));
      var20.append("[Pool Size {core = ");
      var20.append(this.e);
      var20.append(", max = ");
      var20.append(this.f);
      var20.append("}, Worker States {CPU = ");
      var20.append(var3);
      var20.append(", blocking = ");
      var20.append(var4);
      var20.append(", parked = ");
      var20.append(var5);
      var20.append(", dormant = ");
      var20.append(var6);
      var20.append(", terminated = ");
      var20.append(var7);
      var20.append("}, running workers queues = ");
      var20.append(var1);
      var20.append(", global CPU queue size = ");
      var20.append(this.i.c());
      var20.append(", global blocking queue size = ");
      var20.append(this.j.c());
      var20.append(", Control State {created workers= ");
      var20.append((int)(2097151L & var17));
      var20.append(", blocking tasks = ");
      var20.append((int)((4398044413952L & var17) >> 21));
      var20.append(", CPUs acquired = ");
      var20.append(this.e - (int)((9223367638808264704L & var17) >> 42));
      var20.append("}]");
      return var20.toString();
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }
   }

   // $FF: synthetic class
   public final class b {
      // $FF: synthetic field
      public static final int[] a;

      static {
         int[] var0 = new int[o1.a.d.values().length];

         try {
            var0[o1.a.d.g.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[o1.a.d.f.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[o1.a.d.e.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[o1.a.d.h.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[o1.a.d.i.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         a = var0;
      }
   }

   public final class c extends Thread {
      private static final AtomicIntegerFieldUpdater m = AtomicIntegerFieldUpdater.newUpdater(o1.a.c.class, "workerCtl");
      public final n e;
      private final q<h> f;
      public o1.a.d g;
      private long h;
      private long i;
      private volatile int indexInArray;
      private int j;
      public boolean k;
      private volatile Object nextParkedWorker;
      private volatile int workerCtl;

      private c() {
         this.setDaemon(true);
         this.e = new n();
         this.f = new q();
         this.g = o1.a.d.h;
         this.nextParkedWorker = o1.a.p;
         this.j = b1.c.e.b();
      }

      public c(int var2) {
         this();
         this.q(var2);
      }

      private final void b(int var1) {
         if (var1 != 0) {
            o1.a var2 = a.this;
            o1.a.n.addAndGet(var2, -2097152L);
            if (this.g != o1.a.d.i) {
               this.g = o1.a.d.h;
            }

         }
      }

      private final void c(int var1) {
         if (var1 != 0) {
            if (this.u(o1.a.d.f)) {
               a.this.o();
            }

         }
      }

      private final void d(h var1) {
         int var2 = var1.f.a();
         this.k(var2);
         this.c(var2);
         a.this.l(var1);
         this.b(var2);
      }

      private final h e(boolean var1) {
         h var3;
         if (var1) {
            boolean var2;
            if (this.m(a.this.e * 2) == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            if (var2) {
               var3 = this.o();
               if (var3 != null) {
                  return var3;
               }
            }

            var3 = this.e.g();
            if (var3 != null) {
               return var3;
            }

            if (!var2) {
               var3 = this.o();
               if (var3 != null) {
                  return var3;
               }
            }
         } else {
            var3 = this.o();
            if (var3 != null) {
               return var3;
            }
         }

         return this.v(3);
      }

      private final h f() {
         h var1 = this.e.h();
         h var2 = var1;
         if (var1 == null) {
            var1 = (h)a.this.j.d();
            var2 = var1;
            if (var1 == null) {
               var2 = this.v(1);
            }
         }

         return var2;
      }

      public static final AtomicIntegerFieldUpdater j() {
         return m;
      }

      private final void k(int var1) {
         this.h = 0L;
         if (this.g == o1.a.d.g) {
            this.g = o1.a.d.f;
         }

      }

      private final boolean l() {
         boolean var1;
         if (this.nextParkedWorker != o1.a.p) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      private final void n() {
         if (this.h == 0L) {
            this.h = System.nanoTime() + a.this.g;
         }

         LockSupport.parkNanos(a.this.g);
         if (System.nanoTime() - this.h >= 0L) {
            this.h = 0L;
            this.w();
         }

      }

      private final h o() {
         h var1;
         o1.d var2;
         if (this.m(2) == 0) {
            var1 = (h)a.this.i.d();
            if (var1 != null) {
               return var1;
            }

            var2 = a.this.j;
         } else {
            var1 = (h)a.this.j.d();
            if (var1 != null) {
               return var1;
            }

            var2 = a.this.i;
         }

         return (h)var2.d();
      }

      private final void p() {
         label28:
         while(true) {
            boolean var1 = false;

            while(!a.this.isTerminated() && this.g != o1.a.d.i) {
               h var2 = this.g(this.k);
               if (var2 != null) {
                  this.i = 0L;
                  this.d(var2);
                  continue label28;
               }

               this.k = false;
               if (this.i != 0L) {
                  if (var1) {
                     this.u(o1.a.d.g);
                     Thread.interrupted();
                     LockSupport.parkNanos(this.i);
                     this.i = 0L;
                     continue label28;
                  }

                  var1 = true;
               } else {
                  this.t();
               }
            }

            this.u(o1.a.d.i);
            return;
         }
      }

      private final boolean s() {
         o1.a.d var1 = this.g;
         o1.a.d var2 = o1.a.d.e;
         boolean var3 = false;
         if (var1 != var2) {
            o1.a var8 = a.this;
            AtomicLongFieldUpdater var7 = o1.a.n;

            boolean var6;
            while(true) {
               long var4 = var7.get(var8);
               if ((int)((9223367638808264704L & var4) >> 42) == 0) {
                  var6 = false;
                  break;
               }

               if (o1.a.n.compareAndSet(var8, var4, var4 - 4398046511104L)) {
                  var6 = true;
                  break;
               }
            }

            if (!var6) {
               return var3;
            }

            this.g = o1.a.d.e;
         }

         var3 = true;
         return var3;
      }

      private final void t() {
         if (!this.l()) {
            a.this.j(this);
         } else {
            m.set(this, -1);

            while(this.l() && m.get(this) == -1 && !a.this.isTerminated() && this.g != o1.a.d.i) {
               this.u(o1.a.d.g);
               Thread.interrupted();
               this.n();
            }

         }
      }

      private final h v(int var1) {
         o1.a var2 = a.this;
         int var3 = (int)(o1.a.n.get(var2) & 2097151L);
         if (var3 < 2) {
            return null;
         } else {
            int var4 = this.m(var3);
            o1.a var5 = a.this;
            int var6 = 0;

            long var7;
            long var12;
            for(var7 = Long.MAX_VALUE; var6 < var3; var7 = var12) {
               int var9 = var4 + 1;
               var4 = var9;
               if (var9 > var3) {
                  var4 = 1;
               }

               o1.a.c var14 = (o1.a.c)var5.k.b(var4);
               if (var14 != null && var14 != this) {
                  long var10 = var14.e.n(var1, this.f);
                  if (var10 == -1L) {
                     q var16 = this.f;
                     h var15 = (h)var16.e;
                     var16.e = null;
                     return var15;
                  }

                  var12 = var7;
                  if (var10 > 0L) {
                     var12 = Math.min(var7, var10);
                  }
               } else {
                  var12 = var7;
               }

               ++var6;
            }

            if (var7 == Long.MAX_VALUE) {
               var7 = 0L;
            }

            this.i = var7;
            return null;
         }
      }

      private final void w() {
         o1.a var1 = a.this;
         c0 var2 = var1.k;
         synchronized(var2){}

         Throwable var10000;
         label392: {
            boolean var3;
            boolean var10001;
            try {
               var3 = var1.isTerminated();
            } catch (Throwable var48) {
               var10000 = var48;
               var10001 = false;
               break label392;
            }

            if (var3) {
               return;
            }

            int var4;
            int var5;
            try {
               var4 = (int)(o1.a.n.get(var1) & 2097151L);
               var5 = var1.e;
            } catch (Throwable var47) {
               var10000 = var47;
               var10001 = false;
               break label392;
            }

            if (var4 <= var5) {
               return;
            }

            try {
               var3 = m.compareAndSet(this, -1, 1);
            } catch (Throwable var46) {
               var10000 = var46;
               var10001 = false;
               break label392;
            }

            if (!var3) {
               return;
            }

            try {
               var4 = this.indexInArray;
               this.q(0);
               var1.k(this, var4, 0);
               var5 = (int)(o1.a.n.getAndDecrement(var1) & 2097151L);
            } catch (Throwable var45) {
               var10000 = var45;
               var10001 = false;
               break label392;
            }

            if (var5 != var4) {
               try {
                  Object var6 = var1.k.b(var5);
                  a1.k.b(var6);
                  o1.a.c var51 = (o1.a.c)var6;
                  var1.k.c(var4, var51);
                  var51.q(var4);
                  var1.k(var51, var5, var4);
               } catch (Throwable var44) {
                  var10000 = var44;
                  var10001 = false;
                  break label392;
               }
            }

            try {
               var1.k.c(var5, (Object)null);
               p0.q var50 = p0.q.a;
            } catch (Throwable var43) {
               var10000 = var43;
               var10001 = false;
               break label392;
            }

            this.g = o1.a.d.i;
            return;
         }

         Throwable var49 = var10000;
         throw var49;
      }

      public final h g(boolean var1) {
         return this.s() ? this.e(var1) : this.f();
      }

      public final int h() {
         return this.indexInArray;
      }

      public final Object i() {
         return this.nextParkedWorker;
      }

      public final int m(int var1) {
         int var2 = this.j;
         var2 ^= var2 << 13;
         var2 ^= var2 >> 17;
         int var3 = var2 ^ var2 << 5;
         this.j = var3;
         var2 = var1 - 1;
         return (var2 & var1) == 0 ? var3 & var2 : (var3 & Integer.MAX_VALUE) % var1;
      }

      public final void q(int var1) {
         StringBuilder var2 = new StringBuilder();
         var2.append(a.this.h);
         var2.append("-worker-");
         String var3;
         if (var1 == 0) {
            var3 = "TERMINATED";
         } else {
            var3 = String.valueOf(var1);
         }

         var2.append(var3);
         this.setName(var2.toString());
         this.indexInArray = var1;
      }

      public final void r(Object var1) {
         this.nextParkedWorker = var1;
      }

      public void run() {
         this.p();
      }

      public final boolean u(o1.a.d var1) {
         o1.a.d var2 = this.g;
         boolean var3;
         if (var2 == o1.a.d.e) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var3) {
            o1.a var4 = a.this;
            o1.a.n.addAndGet(var4, 4398046511104L);
         }

         if (var2 != var1) {
            this.g = var1;
         }

         return var3;
      }
   }

   public static enum d {
      e,
      f,
      g,
      h,
      i;

      // $FF: synthetic method
      private static final o1.a.d[] a() {
         return new o1.a.d[]{e, f, g, h, i};
      }
   }
}
