package h1;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class n extends u {
   private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(n.class, "_resumed");
   private volatile int _resumed;

   public n(r0.d<?> var1, Throwable var2, boolean var3) {
      Object var4 = var2;
      if (var2 == null) {
         StringBuilder var5 = new StringBuilder();
         var5.append("Continuation ");
         var5.append(var1);
         var5.append(" was cancelled normally");
         var4 = new CancellationException(var5.toString());
      }

      super((Throwable)var4, var3);
      this._resumed = 0;
   }

   public final boolean c() {
      return c.compareAndSet(this, 0, 1);
   }
}
