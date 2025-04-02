package h1;

public abstract class r1 extends b0 {
   public abstract r1 o();

   protected final String p() {
      r1 var1 = q0.c();
      if (this == var1) {
         return "Dispatchers.Main";
      } else {
         try {
            var1 = var1.o();
         } catch (UnsupportedOperationException var2) {
            var1 = null;
         }

         return this == var1 ? "Dispatchers.Main.immediate" : null;
      }
   }

   public String toString() {
      String var1 = this.p();
      String var2 = var1;
      if (var1 == null) {
         StringBuilder var3 = new StringBuilder();
         var3.append(i0.a(this));
         var3.append('@');
         var3.append(i0.b(this));
         var2 = var3.toString();
      }

      return var2;
   }
}
