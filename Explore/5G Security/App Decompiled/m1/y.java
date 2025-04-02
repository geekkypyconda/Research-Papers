package m1;

import h1.r1;

final class y extends r1 implements h1.l0 {
   private final Throwable g;
   private final String h;

   public y(Throwable var1, String var2) {
      this.g = var1;
      this.h = var2;
   }

   private final Void r() {
      if (this.g == null) {
         x.d();
         throw new p0.d();
      } else {
         StringBuilder var1;
         String var2;
         label14: {
            var1 = new StringBuilder();
            var1.append("Module with the Main dispatcher had failed to initialize");
            var2 = this.h;
            if (var2 != null) {
               StringBuilder var3 = new StringBuilder();
               var3.append(". ");
               var3.append(var2);
               String var4 = var3.toString();
               var2 = var4;
               if (var4 != null) {
                  break label14;
               }
            }

            var2 = "";
         }

         var1.append(var2);
         throw new IllegalStateException(var1.toString(), this.g);
      }
   }

   public boolean e(r0.g var1) {
      this.r();
      throw new p0.d();
   }

   public r1 o() {
      return this;
   }

   public Void q(r0.g var1, Runnable var2) {
      this.r();
      throw new p0.d();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Dispatchers.Main[missing");
      String var3;
      if (this.g != null) {
         StringBuilder var2 = new StringBuilder();
         var2.append(", cause=");
         var2.append(this.g);
         var3 = var2.toString();
      } else {
         var3 = "";
      }

      var1.append(var3);
      var1.append(']');
      return var1.toString();
   }
}
