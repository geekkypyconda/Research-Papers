package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a<V> implements x.a<V> {
   static final boolean h;
   private static final Logger i;
   static final a.b j;
   private static final Object k;
   volatile Object e;
   volatile a.e f;
   volatile a.i g;

   static {
      // $FF: Couldn't be decompiled
   }

   protected a() {
   }

   private void a(StringBuilder var1) {
      String var2 = "]";

      try {
         Object var3 = j(this);
         var1.append("SUCCESS, result=[");
         var1.append(this.p(var3));
         var1.append("]");
         return;
      } catch (ExecutionException var4) {
         var1.append("FAILURE, cause=[");
         var1.append(var4.getCause());
      } catch (CancellationException var5) {
         var2 = "CANCELLED";
      } catch (RuntimeException var6) {
         var1.append("UNKNOWN, cause=[");
         var1.append(var6.getClass());
         var2 = " thrown from get()]";
      }

      var1.append(var2);
   }

   private static CancellationException c(String var0, Throwable var1) {
      CancellationException var2 = new CancellationException(var0);
      var2.initCause(var1);
      return var2;
   }

   static <T> T d(T var0) {
      var0.getClass();
      return var0;
   }

   private a.e e(a.e var1) {
      a.e var2;
      do {
         var2 = this.f;
      } while(!j.a(this, var2, a.e.d));

      a.e var3 = var1;

      for(var1 = var2; var1 != null; var1 = var2) {
         var2 = var1.c;
         var1.c = var3;
         var3 = var1;
      }

      return var3;
   }

   static void f(a<?> var0) {
      a.e var1 = null;

      label24:
      while(true) {
         var0.m();
         var0.b();

         a.e var4;
         for(var1 = var0.e(var1); var1 != null; var1 = var4) {
            var4 = var1.c;
            Runnable var2 = var1.a;
            if (var2 instanceof a.g) {
               a.g var3 = (a.g)var2;
               a var6 = var3.e;
               if (var6.e == var3) {
                  Object var5 = i(var3.f);
                  if (j.b(var6, var3, var5)) {
                     var1 = var4;
                     var0 = var6;
                     continue label24;
                  }
               }
            } else {
               g(var2, var1.b);
            }
         }

         return;
      }
   }

   private static void g(Runnable var0, Executor var1) {
      try {
         var1.execute(var0);
      } catch (RuntimeException var6) {
         Logger var3 = i;
         Level var4 = Level.SEVERE;
         StringBuilder var5 = new StringBuilder();
         var5.append("RuntimeException while executing runnable ");
         var5.append(var0);
         var5.append(" with executor ");
         var5.append(var1);
         var3.log(var4, var5.toString(), var6);
      }

   }

   private V h(Object var1) {
      if (!(var1 instanceof a.c)) {
         if (!(var1 instanceof a.d)) {
            Object var2 = var1;
            if (var1 == k) {
               var2 = null;
            }

            return var2;
         } else {
            throw new ExecutionException(((a.d)var1).a);
         }
      } else {
         throw c("Task was cancelled.", ((a.c)var1).b);
      }
   }

   static Object i(x.a<?> param0) {
      // $FF: Couldn't be decompiled
   }

   static <V> V j(Future<V> var0) {
      boolean var1 = false;

      Object var2;
      while(true) {
         boolean var5 = false;

         try {
            var5 = true;
            var2 = var0.get();
            var5 = false;
            break;
         } catch (InterruptedException var6) {
            var5 = false;
         } finally {
            if (var5) {
               if (var1) {
                  Thread.currentThread().interrupt();
               }

            }
         }

         var1 = true;
      }

      if (var1) {
         Thread.currentThread().interrupt();
      }

      return var2;
   }

   private void m() {
      a.i var1;
      do {
         var1 = this.g;
      } while(!j.c(this, var1, a.i.c));

      while(var1 != null) {
         var1.b();
         var1 = var1.b;
      }

   }

   private void n(a.i var1) {
      var1.a = null;

      label30:
      while(true) {
         var1 = this.g;
         if (var1 == a.i.c) {
            return;
         }

         a.i var4;
         for(a.i var2 = null; var1 != null; var2 = var4) {
            a.i var3 = var1.b;
            if (var1.a != null) {
               var4 = var1;
            } else if (var2 != null) {
               var2.b = var3;
               var4 = var2;
               if (var2.a == null) {
                  continue label30;
               }
            } else {
               var4 = var2;
               if (!j.c(this, var1, var3)) {
                  continue label30;
               }
            }

            var1 = var3;
         }

         return;
      }
   }

   private String p(Object var1) {
      return var1 == this ? "this future" : String.valueOf(var1);
   }

   protected void b() {
   }

   public final boolean cancel(boolean var1) {
      Object var2 = this.e;
      boolean var3 = true;
      boolean var4;
      if (var2 == null) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var6;
      if (var4 | var2 instanceof a.g) {
         a.c var5;
         if (h) {
            var5 = new a.c(var1, new CancellationException("Future.cancel() was called."));
         } else if (var1) {
            var5 = a.c.c;
         } else {
            var5 = a.c.d;
         }

         var6 = false;
         a var7 = this;

         while(true) {
            while(!j.b(var7, var2, var5)) {
               Object var8 = var7.e;
               var2 = var8;
               if (!(var8 instanceof a.g)) {
                  return var6;
               }
            }

            if (var1) {
               var7.k();
            }

            f(var7);
            var6 = var3;
            if (!(var2 instanceof a.g)) {
               break;
            }

            x.a var9 = ((a.g)var2).f;
            if (!(var9 instanceof a)) {
               var9.cancel(var1);
               var6 = var3;
               break;
            }

            var7 = (a)var9;
            var2 = var7.e;
            if (var2 == null) {
               var4 = true;
            } else {
               var4 = false;
            }

            var6 = var3;
            if (!(var4 | var2 instanceof a.g)) {
               break;
            }

            var6 = true;
         }
      } else {
         var6 = false;
      }

      return var6;
   }

   public final V get() {
      if (!Thread.interrupted()) {
         Object var1 = this.e;
         boolean var2;
         if (var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var2 & (var1 instanceof a.g ^ true)) {
            return this.h(var1);
         } else {
            a.i var5 = this.g;
            if (var5 != a.i.c) {
               a.i var3 = new a.i();

               a.i var4;
               do {
                  var3.a(var5);
                  if (j.c(this, var5, var3)) {
                     do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                           this.n(var3);
                           throw new InterruptedException();
                        }

                        var1 = this.e;
                        if (var1 != null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }
                     } while(!(var2 & (var1 instanceof a.g ^ true)));

                     return this.h(var1);
                  }

                  var4 = this.g;
                  var5 = var4;
               } while(var4 != a.i.c);
            }

            return this.h(this.e);
         }
      } else {
         throw new InterruptedException();
      }
   }

   public final V get(long var1, TimeUnit var3) {
      long var4 = var3.toNanos(var1);
      if (!Thread.interrupted()) {
         Object var6 = this.e;
         boolean var7;
         if (var6 != null) {
            var7 = true;
         } else {
            var7 = false;
         }

         if (var7 & (var6 instanceof a.g ^ true)) {
            return this.h(var6);
         } else {
            long var8;
            if (var4 > 0L) {
               var8 = System.nanoTime() + var4;
            } else {
               var8 = 0L;
            }

            long var10 = var4;
            if (var4 >= 1000L) {
               label116: {
                  a.i var18 = this.g;
                  if (var18 != a.i.c) {
                     a.i var12 = new a.i();

                     a.i var13;
                     do {
                        var12.a(var18);
                        if (j.c(this, var18, var12)) {
                           do {
                              LockSupport.parkNanos(this, var4);
                              if (Thread.interrupted()) {
                                 this.n(var12);
                                 throw new InterruptedException();
                              }

                              var6 = this.e;
                              if (var6 != null) {
                                 var7 = true;
                              } else {
                                 var7 = false;
                              }

                              if (var7 & (var6 instanceof a.g ^ true)) {
                                 return this.h(var6);
                              }

                              var10 = var8 - System.nanoTime();
                              var4 = var10;
                           } while(var10 >= 1000L);

                           this.n(var12);
                           break label116;
                        }

                        var13 = this.g;
                        var18 = var13;
                     } while(var13 != a.i.c);
                  }

                  return this.h(this.e);
               }
            }

            while(var10 > 0L) {
               var6 = this.e;
               if (var6 != null) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               if (var7 & (var6 instanceof a.g ^ true)) {
                  return this.h(var6);
               }

               if (Thread.interrupted()) {
                  throw new InterruptedException();
               }

               var10 = var8 - System.nanoTime();
            }

            String var22 = this.toString();
            String var23 = var3.toString();
            Locale var19 = Locale.ROOT;
            String var14 = var23.toLowerCase(var19);
            StringBuilder var24 = new StringBuilder();
            var24.append("Waited ");
            var24.append(var1);
            var24.append(" ");
            var24.append(var3.toString().toLowerCase(var19));
            var23 = var24.toString();
            String var20 = var23;
            StringBuilder var17;
            if (var10 + 1000L < 0L) {
               StringBuilder var21 = new StringBuilder();
               var21.append(var23);
               var21.append(" (plus ");
               var20 = var21.toString();
               var10 = -var10;
               var1 = var3.convert(var10, TimeUnit.NANOSECONDS);
               var10 -= var3.toNanos(var1);
               long var25;
               int var15 = (var25 = var1 - 0L) == 0L ? 0 : (var25 < 0L ? -1 : 1);
               if (var15 != 0 && var10 <= 1000L) {
                  var7 = false;
               } else {
                  var7 = true;
               }

               String var16 = var20;
               if (var15 > 0) {
                  var17 = new StringBuilder();
                  var17.append(var20);
                  var17.append(var1);
                  var17.append(" ");
                  var17.append(var14);
                  var20 = var17.toString();
                  var16 = var20;
                  if (var7) {
                     var17 = new StringBuilder();
                     var17.append(var20);
                     var17.append(",");
                     var16 = var17.toString();
                  }

                  var21 = new StringBuilder();
                  var21.append(var16);
                  var21.append(" ");
                  var16 = var21.toString();
               }

               var20 = var16;
               if (var7) {
                  var21 = new StringBuilder();
                  var21.append(var16);
                  var21.append(var10);
                  var21.append(" nanoseconds ");
                  var20 = var21.toString();
               }

               var17 = new StringBuilder();
               var17.append(var20);
               var17.append("delay)");
               var20 = var17.toString();
            }

            if (this.isDone()) {
               var17 = new StringBuilder();
               var17.append(var20);
               var17.append(" but future completed as timeout expired");
               throw new TimeoutException(var17.toString());
            } else {
               var17 = new StringBuilder();
               var17.append(var20);
               var17.append(" for ");
               var17.append(var22);
               throw new TimeoutException(var17.toString());
            }
         }
      } else {
         throw new InterruptedException();
      }
   }

   public final boolean isCancelled() {
      return this.e instanceof a.c;
   }

   public final boolean isDone() {
      Object var1 = this.e;
      boolean var2;
      if (var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return (var1 instanceof a.g ^ true) & var2;
   }

   protected void k() {
   }

   protected String l() {
      Object var1 = this.e;
      StringBuilder var2;
      if (var1 instanceof a.g) {
         var2 = new StringBuilder();
         var2.append("setFuture=[");
         var2.append(this.p(((a.g)var1).f));
         var2.append("]");
         return var2.toString();
      } else if (this instanceof ScheduledFuture) {
         var2 = new StringBuilder();
         var2.append("remaining delay=[");
         var2.append(((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS));
         var2.append(" ms]");
         return var2.toString();
      } else {
         return null;
      }
   }

   protected boolean o(V var1) {
      Object var2 = var1;
      if (var1 == null) {
         var2 = k;
      }

      if (j.b(this, (Object)null, var2)) {
         f(this);
         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      StringBuilder var1;
      label38: {
         var1 = new StringBuilder();
         var1.append(super.toString());
         var1.append("[status=");
         String var2;
         if (this.isCancelled()) {
            var2 = "CANCELLED";
         } else {
            label37: {
               if (!this.isDone()) {
                  try {
                     var2 = this.l();
                  } catch (RuntimeException var4) {
                     StringBuilder var3 = new StringBuilder();
                     var3.append("Exception thrown from implementation: ");
                     var3.append(var4.getClass());
                     var2 = var3.toString();
                  }

                  if (var2 != null && !var2.isEmpty()) {
                     var1.append("PENDING, info=[");
                     var1.append(var2);
                     var1.append("]");
                     break label38;
                  }

                  if (!this.isDone()) {
                     var2 = "PENDING";
                     break label37;
                  }
               }

               this.a(var1);
               break label38;
            }
         }

         var1.append(var2);
      }

      var1.append("]");
      return var1.toString();
   }

   private abstract static class b {
      private b() {
      }

      // $FF: synthetic method
      b(Object var1) {
         this();
      }

      abstract boolean a(a<?> var1, a.e var2, a.e var3);

      abstract boolean b(a<?> var1, Object var2, Object var3);

      abstract boolean c(a<?> var1, a.i var2, a.i var3);

      abstract void d(a.i var1, a.i var2);

      abstract void e(a.i var1, Thread var2);
   }

   private static final class c {
      static final a.c c;
      static final a.c d;
      final boolean a;
      final Throwable b;

      static {
         if (a.h) {
            d = null;
            c = null;
         } else {
            d = new a.c(false, (Throwable)null);
            c = new a.c(true, (Throwable)null);
         }

      }

      c(boolean var1, Throwable var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   private static final class d {
      static final a.d b = new a.d(new Throwable("Failure occurred while trying to finish a future.") {
         {
            super(var1);
         }

         public Throwable fillInStackTrace() {
            synchronized(this){}
            return this;
         }
      });
      final Throwable a;

      d(Throwable var1) {
         this.a = (Throwable)a.d(var1);
      }
   }

   private static final class e {
      static final a.e d = new a.e((Runnable)null, (Executor)null);
      final Runnable a;
      final Executor b;
      a.e c;

      e(Runnable var1, Executor var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   private static final class f extends a.b {
      final AtomicReferenceFieldUpdater<a.i, Thread> a;
      final AtomicReferenceFieldUpdater<a.i, a.i> b;
      final AtomicReferenceFieldUpdater<a, a.i> c;
      final AtomicReferenceFieldUpdater<a, a.e> d;
      final AtomicReferenceFieldUpdater<a, Object> e;

      f(AtomicReferenceFieldUpdater<a.i, Thread> var1, AtomicReferenceFieldUpdater<a.i, a.i> var2, AtomicReferenceFieldUpdater<a, a.i> var3, AtomicReferenceFieldUpdater<a, a.e> var4, AtomicReferenceFieldUpdater<a, Object> var5) {
         super(null);
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }

      boolean a(a<?> var1, a.e var2, a.e var3) {
         return androidx.concurrent.futures.b.a(this.d, var1, var2, var3);
      }

      boolean b(a<?> var1, Object var2, Object var3) {
         return androidx.concurrent.futures.b.a(this.e, var1, var2, var3);
      }

      boolean c(a<?> var1, a.i var2, a.i var3) {
         return androidx.concurrent.futures.b.a(this.c, var1, var2, var3);
      }

      void d(a.i var1, a.i var2) {
         this.b.lazySet(var1, var2);
      }

      void e(a.i var1, Thread var2) {
         this.a.lazySet(var1, var2);
      }
   }

   private static final class g<V> implements Runnable {
      final a<V> e;
      final x.a<? extends V> f;

      public void run() {
         if (this.e.e == this) {
            Object var1 = a.i(this.f);
            if (a.j.b(this.e, this, var1)) {
               a.f(this.e);
            }

         }
      }
   }

   private static final class h extends a.b {
      h() {
         super(null);
      }

      boolean a(a<?> var1, a.e var2, a.e var3) {
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label123: {
            try {
               if (var1.f == var2) {
                  var1.f = var3;
                  return true;
               }
            } catch (Throwable var15) {
               var10000 = var15;
               var10001 = false;
               break label123;
            }

            label117:
            try {
               return false;
            } catch (Throwable var14) {
               var10000 = var14;
               var10001 = false;
               break label117;
            }
         }

         while(true) {
            Throwable var16 = var10000;

            try {
               throw var16;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               continue;
            }
         }
      }

      boolean b(a<?> var1, Object var2, Object var3) {
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label123: {
            try {
               if (var1.e == var2) {
                  var1.e = var3;
                  return true;
               }
            } catch (Throwable var15) {
               var10000 = var15;
               var10001 = false;
               break label123;
            }

            label117:
            try {
               return false;
            } catch (Throwable var14) {
               var10000 = var14;
               var10001 = false;
               break label117;
            }
         }

         while(true) {
            Throwable var16 = var10000;

            try {
               throw var16;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               continue;
            }
         }
      }

      boolean c(a<?> var1, a.i var2, a.i var3) {
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label123: {
            try {
               if (var1.g == var2) {
                  var1.g = var3;
                  return true;
               }
            } catch (Throwable var15) {
               var10000 = var15;
               var10001 = false;
               break label123;
            }

            label117:
            try {
               return false;
            } catch (Throwable var14) {
               var10000 = var14;
               var10001 = false;
               break label117;
            }
         }

         while(true) {
            Throwable var16 = var10000;

            try {
               throw var16;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               continue;
            }
         }
      }

      void d(a.i var1, a.i var2) {
         var1.b = var2;
      }

      void e(a.i var1, Thread var2) {
         var1.a = var2;
      }
   }

   private static final class i {
      static final a.i c = new a.i(false);
      volatile Thread a;
      volatile a.i b;

      i() {
         a.j.e(this, Thread.currentThread());
      }

      i(boolean var1) {
      }

      void a(a.i var1) {
         a.j.d(this, var1);
      }

      void b() {
         Thread var1 = this.a;
         if (var1 != null) {
            this.a = null;
            LockSupport.unpark(var1);
         }

      }
   }
}
