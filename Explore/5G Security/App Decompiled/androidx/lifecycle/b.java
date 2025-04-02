package androidx.lifecycle;

public final class b implements j {
   private final g[] a;

   public b(g[] var1) {
      a1.k.e(var1, "generatedAdapters");
      super();
      this.a = var1;
   }

   public void d(l var1, h.a var2) {
      a1.k.e(var1, "source");
      a1.k.e(var2, "event");
      p var3 = new p();
      g[] var4 = this.a;
      int var5 = var4.length;
      byte var6 = 0;

      int var7;
      for(var7 = 0; var7 < var5; ++var7) {
         var4[var7].a(var1, var2, false, var3);
      }

      var4 = this.a;
      var5 = var4.length;

      for(var7 = var6; var7 < var5; ++var7) {
         var4[var7].a(var1, var2, true, var3);
      }

   }
}
