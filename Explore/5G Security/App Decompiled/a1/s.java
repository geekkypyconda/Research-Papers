package a1;

public class s {
   public e1.e a(i var1) {
      return var1;
   }

   public e1.b b(Class var1) {
      return new e(var1);
   }

   public e1.d c(Class var1, String var2) {
      return new m(var1, var2);
   }

   public e1.f d(n var1) {
      return var1;
   }

   public String e(h var1) {
      String var2 = var1.getClass().getGenericInterfaces()[0].toString();
      String var3 = var2;
      if (var2.startsWith("kotlin.jvm.functions.")) {
         var3 = var2.substring(21);
      }

      return var3;
   }

   public String f(l var1) {
      return this.e(var1);
   }
}
