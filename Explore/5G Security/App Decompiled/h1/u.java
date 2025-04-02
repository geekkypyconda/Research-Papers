package h1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class u {
   private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(u.class, "_handled");
   private volatile int _handled;
   public final Throwable a;

   public u(Throwable var1, boolean var2) {
      this.a = var1;
      this._handled = var2;
   }

   // $FF: synthetic method
   public u(Throwable var1, boolean var2, int var3, a1.g var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      this(var1, var2);
   }

   public final boolean a() {
      boolean var1;
      if (b.get(this) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean b() {
      return b.compareAndSet(this, 0, 1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(i0.a(this));
      var1.append('[');
      var1.append(this.a);
      var1.append(']');
      return var1.toString();
   }
}
