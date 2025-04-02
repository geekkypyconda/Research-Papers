package h1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public final class a1 extends z0 implements l0 {
   private final Executor h;

   public a1(Executor var1) {
      this.h = var1;
      m1.c.a(this.p());
   }

   private final void o(r0.g var1, RejectedExecutionException var2) {
      l1.c(var1, y0.a("The task was rejected", var2));
   }

   public void a(r0.g var1, Runnable var2) {
      try {
         Executor var3 = this.p();
         h1.c.a();
         var3.execute(var2);
      } catch (RejectedExecutionException var4) {
         h1.c.a();
         this.o(var1, var4);
         q0.b().a(var1, var2);
      }

   }

   public void close() {
      Executor var1 = this.p();
      ExecutorService var2;
      if (var1 instanceof ExecutorService) {
         var2 = (ExecutorService)var1;
      } else {
         var2 = null;
      }

      if (var2 != null) {
         var2.shutdown();
      }

   }

   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof a1 && ((a1)var1).p() == this.p()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      return System.identityHashCode(this.p());
   }

   public Executor p() {
      return this.h;
   }

   public String toString() {
      return this.p().toString();
   }
}
