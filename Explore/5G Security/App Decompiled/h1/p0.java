package h1;

import java.util.concurrent.Executor;

final class p0 implements Executor {
   public final b0 e;

   public void execute(Runnable var1) {
      b0 var2 = this.e;
      r0.h var3 = r0.h.e;
      if (var2.e(var3)) {
         this.e.a(var3, var1);
      } else {
         var1.run();
      }

   }

   public String toString() {
      return this.e.toString();
   }
}
