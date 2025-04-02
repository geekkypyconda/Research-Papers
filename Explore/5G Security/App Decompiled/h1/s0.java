package h1;

final class s0 implements d1 {
   private final boolean e;

   public s0(boolean var1) {
      this.e = var1;
   }

   public boolean d() {
      return this.e;
   }

   public s1 f() {
      return null;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Empty{");
      String var2;
      if (this.d()) {
         var2 = "Active";
      } else {
         var2 = "New";
      }

      var1.append(var2);
      var1.append('}');
      return var1.toString();
   }
}
