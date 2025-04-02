package m1;

import h1.u1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class e0<S extends e0<S>> extends e<S> implements u1 {
   private static final AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(e0.class, "cleanedAndPointers");
   private volatile int cleanedAndPointers;
   public final long g;

   public e0(long var1, S var3, int var4) {
      super(var3);
      this.g = var1;
      this.cleanedAndPointers = var4 << 16;
   }

   public boolean h() {
      boolean var1;
      if (h.get(this) == this.n() && !this.i()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean m() {
      boolean var1;
      if (h.addAndGet(this, -65536) == this.n() && !this.i()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public abstract int n();

   public abstract void o(int var1, Throwable var2, r0.g var3);

   public final void p() {
      if (h.incrementAndGet(this) == this.n()) {
         this.k();
      }

   }

   public final boolean q() {
      AtomicIntegerFieldUpdater var1 = h;

      boolean var4;
      while(true) {
         int var2 = var1.get(this);
         int var3 = this.n();
         var4 = false;
         boolean var5;
         if (var2 == var3 && !this.i()) {
            var5 = false;
         } else {
            var5 = true;
         }

         if (!var5) {
            break;
         }

         if (var1.compareAndSet(this, var2, 65536 + var2)) {
            var4 = true;
            break;
         }
      }

      return var4;
   }
}
