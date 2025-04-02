package h1;

import java.util.concurrent.locks.LockSupport;

public abstract class v0 extends t0 {
   protected abstract Thread E();

   protected void F(long var1, u0.a var3) {
      j0.m.R(var1, var3);
   }

   protected final void G() {
      Thread var1 = this.E();
      if (Thread.currentThread() != var1) {
         h1.c.a();
         LockSupport.unpark(var1);
      }

   }
}
