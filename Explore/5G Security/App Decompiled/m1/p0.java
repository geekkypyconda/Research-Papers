package m1;

import h1.x1;

final class p0 {
   public final r0.g a;
   private final Object[] b;
   private final x1<Object>[] c;
   private int d;

   public p0(r0.g var1, int var2) {
      this.a = var1;
      this.b = new Object[var2];
      this.c = new x1[var2];
   }

   public final void a(x1<?> var1, Object var2) {
      Object[] var3 = this.b;
      int var4 = this.d;
      var3[var4] = var2;
      x1[] var5 = this.c;
      this.d = var4 + 1;
      a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
      var5[var4] = var1;
   }

   public final void b(r0.g var1) {
      int var2 = this.c.length - 1;
      if (var2 >= 0) {
         while(true) {
            int var3 = var2 - 1;
            x1 var4 = this.c[var2];
            a1.k.b(var4);
            var4.g(var1, this.b[var2]);
            if (var3 < 0) {
               break;
            }

            var2 = var3;
         }
      }

   }
}
