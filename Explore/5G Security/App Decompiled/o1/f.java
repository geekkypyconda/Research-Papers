package o1;

import h1.z0;

public class f extends z0 {
   private final int h;
   private final int i;
   private final long j;
   private final String k;
   private o1.a l;

   public f(int var1, int var2, long var3, String var5) {
      this.h = var1;
      this.i = var2;
      this.j = var3;
      this.k = var5;
      this.l = this.o();
   }

   private final o1.a o() {
      return new o1.a(this.h, this.i, this.j, this.k);
   }

   public void a(r0.g var1, Runnable var2) {
      o1.a.g(this.l, var2, (i)null, false, 6, (Object)null);
   }

   public final void p(Runnable var1, i var2, boolean var3) {
      this.l.f(var1, var2, var3);
   }
}
