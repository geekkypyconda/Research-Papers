package a1;

public final class m implements d {
   private final Class<?> a;
   private final String b;

   public m(Class<?> var1, String var2) {
      k.e(var1, "jClass");
      k.e(var2, "moduleName");
      super();
      this.a = var1;
      this.b = var2;
   }

   public Class<?> c() {
      return this.a;
   }

   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof m && k.a(this.c(), ((m)var1).c())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      return this.c().hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.c().toString());
      var1.append(" (Kotlin reflection is not available)");
      return var1.toString();
   }
}
