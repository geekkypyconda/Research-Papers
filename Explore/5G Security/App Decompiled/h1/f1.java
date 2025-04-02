package h1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

final class f1 extends j1 {
   private static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(f1.class, "_invoked");
   private volatile int _invoked;
   private final z0.l<Throwable, p0.q> i;

   public f1(z0.l<? super Throwable, p0.q> var1) {
      this.i = var1;
   }

   public void x(Throwable var1) {
      if (j.compareAndSet(this, 0, 1)) {
         this.i.i(var1);
      }

   }
}
