package h1;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public final class j0 extends u0 implements Runnable {
   private static volatile Thread _thread;
   private static volatile int debugStatus;
   public static final j0 m;
   private static final long n;

   static {
      j0 var0 = new j0();
      m = var0;
      t0.w(var0, false, 1, (Object)null);
      TimeUnit var1 = TimeUnit.MILLISECONDS;

      Long var3;
      try {
         var3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
      } catch (SecurityException var2) {
         var3 = 1000L;
      }

      n = var1.toNanos(var3);
   }

   private j0() {
   }

   private final void V() {
      synchronized(this){}

      Throwable var10000;
      label78: {
         boolean var1;
         boolean var10001;
         try {
            var1 = this.Y();
         } catch (Throwable var8) {
            var10000 = var8;
            var10001 = false;
            break label78;
         }

         if (!var1) {
            return;
         }

         try {
            debugStatus = 3;
            this.Q();
            a1.k.c(this, "null cannot be cast to non-null type java.lang.Object");
            this.notifyAll();
         } catch (Throwable var7) {
            var10000 = var7;
            var10001 = false;
            break label78;
         }

         return;
      }

      Throwable var2 = var10000;
      throw var2;
   }

   private final Thread W() {
      synchronized(this){}

      Throwable var10000;
      label75: {
         Thread var1;
         boolean var10001;
         try {
            var1 = _thread;
         } catch (Throwable var8) {
            var10000 = var8;
            var10001 = false;
            break label75;
         }

         Thread var2 = var1;
         if (var1 != null) {
            return var2;
         }

         label66:
         try {
            var2 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = var2;
            var2.setDaemon(true);
            var2.start();
            return var2;
         } catch (Throwable var7) {
            var10000 = var7;
            var10001 = false;
            break label66;
         }
      }

      Throwable var9 = var10000;
      throw var9;
   }

   private final boolean X() {
      boolean var1;
      if (debugStatus == 4) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private final boolean Y() {
      int var1 = debugStatus;
      boolean var2;
      if (var1 != 2 && var1 != 3) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private final boolean Z() {
      synchronized(this){}

      Throwable var10000;
      label78: {
         boolean var1;
         boolean var10001;
         try {
            var1 = this.Y();
         } catch (Throwable var8) {
            var10000 = var8;
            var10001 = false;
            break label78;
         }

         if (var1) {
            return false;
         }

         try {
            debugStatus = 1;
            a1.k.c(this, "null cannot be cast to non-null type java.lang.Object");
            this.notifyAll();
         } catch (Throwable var7) {
            var10000 = var7;
            var10001 = false;
            break label78;
         }

         return true;
      }

      Throwable var2 = var10000;
      throw var2;
   }

   private final void a0() {
      throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
   }

   protected Thread E() {
      Thread var1 = _thread;
      Thread var2 = var1;
      if (var1 == null) {
         var2 = this.W();
      }

      return var2;
   }

   protected void F(long var1, u0.a var3) {
      this.a0();
   }

   public void K(Runnable var1) {
      if (this.X()) {
         this.a0();
      }

      super.K(var1);
   }

   public void run() {
      y1.a.c(this);
      h1.c.a();

      Throwable var10000;
      label679: {
         boolean var1;
         boolean var10001;
         try {
            var1 = this.Z();
         } catch (Throwable var66) {
            var10000 = var66;
            var10001 = false;
            break label679;
         }

         if (!var1) {
            _thread = null;
            this.V();
            h1.c.a();
            if (!this.N()) {
               this.E();
            }

            return;
         }

         long var2 = Long.MAX_VALUE;

         while(true) {
            long var4;
            try {
               Thread.interrupted();
               var4 = this.O();
            } catch (Throwable var65) {
               var10000 = var65;
               var10001 = false;
               break;
            }

            long var8;
            if (var4 == Long.MAX_VALUE) {
               long var6;
               try {
                  h1.c.a();
                  var6 = System.nanoTime();
               } catch (Throwable var64) {
                  var10000 = var64;
                  var10001 = false;
                  break;
               }

               var8 = var2;
               if (var2 == Long.MAX_VALUE) {
                  try {
                     var2 = n;
                  } catch (Throwable var63) {
                     var10000 = var63;
                     var10001 = false;
                     break;
                  }

                  var8 = var2 + var6;
               }

               var2 = var8 - var6;
               if (var2 <= 0L) {
                  _thread = null;
                  this.V();
                  h1.c.a();
                  if (!this.N()) {
                     this.E();
                  }

                  return;
               }

               try {
                  var4 = d1.d.d(var4, var2);
               } catch (Throwable var62) {
                  var10000 = var62;
                  var10001 = false;
                  break;
               }
            } else {
               var8 = Long.MAX_VALUE;
            }

            var2 = var8;
            if (var4 > 0L) {
               try {
                  var1 = this.Y();
               } catch (Throwable var61) {
                  var10000 = var61;
                  var10001 = false;
                  break;
               }

               if (var1) {
                  _thread = null;
                  this.V();
                  h1.c.a();
                  if (!this.N()) {
                     this.E();
                  }

                  return;
               }

               try {
                  h1.c.a();
                  LockSupport.parkNanos(this, var4);
               } catch (Throwable var60) {
                  var10000 = var60;
                  var10001 = false;
                  break;
               }

               var2 = var8;
            }
         }
      }

      Throwable var10 = var10000;
      _thread = null;
      this.V();
      h1.c.a();
      if (!this.N()) {
         this.E();
      }

      throw var10;
   }

   public void shutdown() {
      debugStatus = 4;
      super.shutdown();
   }
}
