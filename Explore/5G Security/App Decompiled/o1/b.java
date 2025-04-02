package o1;

import h1.b0;
import h1.z0;
import java.util.concurrent.Executor;
import m1.i0;

public final class b extends z0 implements Executor {
   public static final o1.b h = new o1.b();
   private static final b0 i;

   static {
      i = m.g.l(i0.g("kotlinx.coroutines.io.parallelism", d1.d.a(64, i0.a()), 0, 0, 12, (Object)null));
   }

   private b() {
   }

   public void a(r0.g var1, Runnable var2) {
      i.a(var1, var2);
   }

   public void close() {
      throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
   }

   public void execute(Runnable var1) {
      this.a(r0.h.e, var1);
   }

   public String toString() {
      return "Dispatchers.IO";
   }
}
