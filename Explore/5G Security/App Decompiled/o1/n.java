package o1;

import a1.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class n {
   private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
   private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
   private static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
   private static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
   private final AtomicReferenceArray<h> a = new AtomicReferenceArray(128);
   private volatile int blockingTasksInBuffer;
   private volatile int consumerIndex;
   private volatile Object lastScheduledTask;
   private volatile int producerIndex;

   private final h b(h var1) {
      if (this.d() == 127) {
         return var1;
      } else {
         int var2 = var1.f.a();
         boolean var3 = true;
         if (var2 != 1) {
            var3 = false;
         }

         if (var3) {
            e.incrementAndGet(this);
         }

         int var4 = c.get(this) & 127;

         while(this.a.get(var4) != null) {
            Thread.yield();
         }

         this.a.lazySet(var4, var1);
         c.incrementAndGet(this);
         return null;
      }
   }

   private final void c(h var1) {
      if (var1 != null) {
         int var2 = var1.f.a();
         boolean var3 = true;
         if (var2 != 1) {
            var3 = false;
         }

         if (var3) {
            e.decrementAndGet(this);
         }
      }

   }

   private final int d() {
      return c.get(this) - d.get(this);
   }

   private final h i() {
      while(true) {
         AtomicIntegerFieldUpdater var1 = d;
         int var2 = var1.get(this);
         if (var2 - c.get(this) == 0) {
            return null;
         }

         if (var1.compareAndSet(this, var2, var2 + 1)) {
            h var3 = (h)this.a.getAndSet(var2 & 127, (Object)null);
            if (var3 != null) {
               this.c(var3);
               return var3;
            }
         }
      }
   }

   private final boolean j(d var1) {
      h var2 = this.i();
      if (var2 == null) {
         return false;
      } else {
         var1.a(var2);
         return true;
      }
   }

   private final h k(boolean var1) {
      while(true) {
         AtomicReferenceFieldUpdater var2 = b;
         h var3 = (h)var2.get(this);
         int var4;
         if (var3 != null) {
            var4 = var3.f.a();
            boolean var5 = true;
            if (var4 != 1) {
               var5 = false;
            }

            if (var5 == var1) {
               if (!androidx.concurrent.futures.b.a(var2, this, var3, (Object)null)) {
                  continue;
               }

               return var3;
            }
         }

         int var6 = d.get(this);
         var4 = c.get(this);

         do {
            if (var6 == var4) {
               return null;
            }

            if (var1 && e.get(this) == 0) {
               return null;
            }

            --var4;
            var3 = this.m(var4, var1);
         } while(var3 == null);

         return var3;
      }
   }

   private final h l(int var1) {
      int var2 = d.get(this);
      int var3 = c.get(this);
      boolean var4 = true;
      if (var1 == 1) {
         var1 = var2;
      } else {
         var4 = false;
         var1 = var2;
      }

      while(var1 != var3) {
         if (var4 && e.get(this) == 0) {
            return null;
         }

         h var5 = this.m(var1, var4);
         if (var5 != null) {
            return var5;
         }

         ++var1;
      }

      return null;
   }

   private final h m(int var1, boolean var2) {
      var1 &= 127;
      h var3 = (h)this.a.get(var1);
      if (var3 != null) {
         int var4 = var3.f.a();
         boolean var5 = true;
         if (var4 != 1) {
            var5 = false;
         }

         if (var5 == var2 && j1.i.a(this.a, var1, var3, (Object)null)) {
            if (var2) {
               e.decrementAndGet(this);
            }

            return var3;
         }
      }

      return null;
   }

   private final long o(int var1, q<h> var2) {
      AtomicReferenceFieldUpdater var3;
      h var4;
      do {
         var3 = b;
         var4 = (h)var3.get(this);
         if (var4 == null) {
            return -2L;
         }

         int var5 = var4.f.a();
         byte var6 = 1;
         boolean var11;
         if (var5 == 1) {
            var11 = true;
         } else {
            var11 = false;
         }

         byte var12;
         if (var11) {
            var12 = var6;
         } else {
            var12 = 2;
         }

         if ((var12 & var1) == 0) {
            return -2L;
         }

         long var7 = l.f.a() - var4.e;
         long var9 = l.b;
         if (var7 < var9) {
            return var9 - var7;
         }
      } while(!androidx.concurrent.futures.b.a(var3, this, var4, (Object)null));

      var2.e = var4;
      return -1L;
   }

   public final h a(h var1, boolean var2) {
      if (var2) {
         return this.b(var1);
      } else {
         var1 = (h)b.getAndSet(this, var1);
         return var1 == null ? null : this.b(var1);
      }
   }

   public final int e() {
      int var1;
      if (b.get(this) != null) {
         var1 = this.d() + 1;
      } else {
         var1 = this.d();
      }

      return var1;
   }

   public final void f(d var1) {
      h var2 = (h)b.getAndSet(this, (Object)null);
      if (var2 != null) {
         var1.a(var2);
      }

      while(this.j(var1)) {
      }

   }

   public final h g() {
      h var1 = (h)b.getAndSet(this, (Object)null);
      h var2 = var1;
      if (var1 == null) {
         var2 = this.i();
      }

      return var2;
   }

   public final h h() {
      return this.k(true);
   }

   public final long n(int var1, q<h> var2) {
      h var3;
      if (var1 == 3) {
         var3 = this.i();
      } else {
         var3 = this.l(var1);
      }

      if (var3 != null) {
         var2.e = var3;
         return -1L;
      } else {
         return this.o(var1, var2);
      }
   }
}
