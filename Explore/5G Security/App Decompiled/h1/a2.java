package h1;

public final class a2<T> extends m1.d0<T> {
   private final ThreadLocal<p0.j<r0.g, Object>> i;
   private volatile boolean threadLocalIsSet;

   protected void G0(Object var1) {
      if (this.threadLocalIsSet) {
         p0.j var2 = (p0.j)this.i.get();
         if (var2 != null) {
            m1.l0.a((r0.g)var2.a(), var2.b());
         }

         this.i.remove();
      }

      Object var3 = y.a(var1, super.h);
      r0.d var4 = super.h;
      r0.g var9 = var4.a();
      a2 var8 = null;
      Object var5 = m1.l0.c(var9, (Object)null);
      if (var5 != m1.l0.a) {
         var8 = a0.f(var4, var9, var5);
      }

      try {
         super.h.u(var3);
         p0.q var10 = p0.q.a;
      } finally {
         if (var8 == null || var8.K0()) {
            m1.l0.a(var9, var5);
         }

      }

   }

   public final boolean K0() {
      boolean var1;
      if (this.threadLocalIsSet && this.i.get() == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.i.remove();
      return var1 ^ true;
   }

   public final void L0(r0.g var1, Object var2) {
      this.threadLocalIsSet = true;
      this.i.set(p0.n.a(var1, var2));
   }
}
