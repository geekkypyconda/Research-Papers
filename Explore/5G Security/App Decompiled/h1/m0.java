package h1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class m0<T> extends m1.d0<T> {
   private static final AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(m0.class, "_decision");
   private volatile int _decision;

   private final boolean K0() {
      AtomicIntegerFieldUpdater var1 = i;

      do {
         int var2 = var1.get(this);
         if (var2 != 0) {
            if (var2 == 1) {
               return false;
            } else {
               throw new IllegalStateException("Already resumed".toString());
            }
         }
      } while(!i.compareAndSet(this, 0, 2));

      return true;
   }

   protected void G0(Object var1) {
      if (!this.K0()) {
         m1.k.c(s0.b.b(super.h), y.a(var1, super.h), (z0.l)null, 2, (Object)null);
      }
   }

   protected void H(Object var1) {
      this.G0(var1);
   }
}
