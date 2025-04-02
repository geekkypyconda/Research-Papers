package h1;

public class k1 extends o1 implements s {
   private final boolean g;

   public k1(h1 var1) {
      super(true);
      this.d0(var1);
      this.g = this.G0();
   }

   private final boolean G0() {
      p var1 = this.Z();
      q var3;
      if (var1 instanceof q) {
         var3 = (q)var1;
      } else {
         var3 = null;
      }

      if (var3 != null) {
         o1 var2 = var3.y();
         o1 var4 = var2;
         if (var2 != null) {
            do {
               if (var4.W()) {
                  return true;
               }

               var1 = var4.Z();
               if (var1 instanceof q) {
                  var3 = (q)var1;
               } else {
                  var3 = null;
               }

               if (var3 == null) {
                  break;
               }

               var2 = var3.y();
               var4 = var2;
            } while(var2 != null);
         }
      }

      return false;
   }

   public boolean W() {
      return this.g;
   }

   public boolean X() {
      return true;
   }
}
