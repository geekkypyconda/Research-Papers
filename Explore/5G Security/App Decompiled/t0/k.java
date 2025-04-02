package t0;

import a1.r;

public abstract class k extends d implements a1.h<Object> {
   private final int h;

   public k(int var1, r0.d<Object> var2) {
      super(var2);
      this.h = var1;
   }

   public int e() {
      return this.h;
   }

   public String toString() {
      String var1;
      if (this.f() == null) {
         var1 = r.e(this);
         a1.k.d(var1, "renderLambdaToString(this)");
      } else {
         var1 = super.toString();
      }

      return var1;
   }
}
