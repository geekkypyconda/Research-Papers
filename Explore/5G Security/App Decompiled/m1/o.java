package m1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class o extends h1.b0 implements h1.l0 {
   private static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(o.class, "runningWorkers");
   private final h1.b0 g;
   private final int h;
   // $FF: synthetic field
   private final h1.l0 i;
   private final t<Runnable> j;
   private final Object k;
   private volatile int runningWorkers;

   public o(h1.b0 var1, int var2) {
      this.g = var1;
      this.h = var2;
      h1.l0 var4;
      if (var1 instanceof h1.l0) {
         var4 = (h1.l0)var1;
      } else {
         var4 = null;
      }

      h1.l0 var3 = var4;
      if (var4 == null) {
         var3 = h1.k0.a();
      }

      this.i = var3;
      this.j = new t(false);
      this.k = new Object();
   }

   private final Runnable q() {
      while(true) {
         Runnable var1 = (Runnable)this.j.d();
         if (var1 == null) {
            Object var10 = this.k;
            synchronized(var10){}

            Throwable var10000;
            label93: {
               boolean var10001;
               AtomicIntegerFieldUpdater var2;
               int var3;
               try {
                  var2 = l;
                  var2.decrementAndGet(this);
                  var3 = this.j.c();
               } catch (Throwable var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label93;
               }

               if (var3 == 0) {
                  return null;
               }

               label80:
               try {
                  var2.incrementAndGet(this);
                  continue;
               } catch (Throwable var8) {
                  var10000 = var8;
                  var10001 = false;
                  break label80;
               }
            }

            Throwable var11 = var10000;
            throw var11;
         }

         return var1;
      }
   }

   private final boolean r() {
      Object var1 = this.k;
      synchronized(var1){}

      Throwable var10000;
      label91: {
         boolean var10001;
         AtomicIntegerFieldUpdater var2;
         int var3;
         int var4;
         try {
            var2 = l;
            var3 = var2.get(this);
            var4 = this.h;
         } catch (Throwable var11) {
            var10000 = var11;
            var10001 = false;
            break label91;
         }

         boolean var5;
         if (var3 >= var4) {
            var5 = false;
            return var5;
         }

         try {
            var2.incrementAndGet(this);
         } catch (Throwable var10) {
            var10000 = var10;
            var10001 = false;
            break label91;
         }

         var5 = true;
         return var5;
      }

      Throwable var12 = var10000;
      throw var12;
   }

   public void a(r0.g var1, Runnable var2) {
      this.j.a(var2);
      if (l.get(this) < this.h && this.r()) {
         Runnable var3 = this.q();
         if (var3 != null) {
            o.a var4 = new o.a(var3);
            this.g.a(this, var4);
         }
      }

   }

   private final class a implements Runnable {
      private Runnable e;

      public a(Runnable var2) {
         this.e = var2;
      }

      public void run() {
         int var1 = 0;

         while(true) {
            label41:
            try {
               this.e.run();
            } catch (Throwable var5) {
               h1.d0.a(r0.h.e, var5);
               break label41;
            }

            Runnable var2 = o.this.q();
            if (var2 == null) {
               return;
            }

            this.e = var2;
            int var3 = var1 + 1;
            var1 = var3;
            if (var3 >= 16) {
               var1 = var3;
               if (o.this.g.e(o.this)) {
                  o.this.g.a(o.this, this);
                  return;
               }
            }
         }
      }
   }
}
