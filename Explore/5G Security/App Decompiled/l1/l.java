package l1;

import h1.l1;

public final class l<T> extends t0.d implements k1.d<T> {
   public final k1.d<T> h;
   public final r0.g i;
   public final int j;
   private r0.g k;
   private r0.d<? super p0.q> l;

   public l(k1.d<? super T> var1, r0.g var2) {
      super(l1.j.e, r0.h.e);
      this.h = var1;
      this.i = var2;
      this.j = ((Number)var2.y(0, null.f)).intValue();
   }

   private final void p(r0.g var1, r0.g var2, T var3) {
      if (var2 instanceof h) {
         this.r((h)var2, var3);
      }

      n.a(this, var1);
   }

   private final Object q(r0.d<? super p0.q> var1, T var2) {
      r0.g var3 = var1.a();
      l1.e(var3);
      r0.g var4 = this.k;
      if (var4 != var3) {
         this.p(var3, var4, var2);
         this.k = var3;
      }

      this.l = var1;
      z0.q var5 = m.a();
      k1.d var7 = this.h;
      a1.k.c(var7, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
      a1.k.c(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
      Object var6 = var5.g(var7, var2, this);
      if (!a1.k.a(var6, s0.b.c())) {
         this.l = null;
      }

      return var6;
   }

   private final void r(h var1, Object var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
      var3.append(var1.e);
      var3.append(", but then emission attempt of value '");
      var3.append(var2);
      var3.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
      throw new IllegalStateException(g1.d.e(var3.toString()).toString());
   }

   public r0.g a() {
      r0.g var1 = this.k;
      Object var2 = var1;
      if (var1 == null) {
         var2 = r0.h.e;
      }

      return (r0.g)var2;
   }

   public Object c(T var1, r0.d<? super p0.q> var2) {
      try {
         var1 = this.q(var2, var1);
      } catch (Throwable var4) {
         this.k = new h(var4, var2.a());
         throw var4;
      }

      if (var1 == s0.b.c()) {
         t0.h.c(var2);
      }

      return var1 == s0.b.c() ? var1 : p0.q.a;
   }

   public StackTraceElement j() {
      return null;
   }

   public Object k(Object var1) {
      Throwable var2 = p0.k.b(var1);
      if (var2 != null) {
         this.k = new h(var2, this.a());
      }

      r0.d var3 = this.l;
      if (var3 != null) {
         var3.u(var1);
      }

      return s0.b.c();
   }

   public void m() {
      super.m();
   }

   public t0.e o() {
      r0.d var1 = this.l;
      t0.e var2;
      if (var1 instanceof t0.e) {
         var2 = (t0.e)var1;
      } else {
         var2 = null;
      }

      return var2;
   }
}
