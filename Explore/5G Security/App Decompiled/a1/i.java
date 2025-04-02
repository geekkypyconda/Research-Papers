package a1;

public class i extends c implements h, e1.e {
   private final int l;
   private final int m;

   public i(int var1, Object var2, Class var3, String var4, String var5, int var6) {
      boolean var7;
      if ((var6 & 1) == 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      super(var2, var3, var4, var5, var7);
      this.l = var1;
      this.m = var6 >> 1;
   }

   protected e1.a c() {
      return r.a(this);
   }

   public int e() {
      return this.l;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof i)) {
         return var1 instanceof e1.e ? var1.equals(this.a()) : false;
      } else {
         i var3 = (i)var1;
         if (!this.f().equals(var3.f()) || !this.k().equals(var3.k()) || this.m != var3.m || this.l != var3.l || !a1.k.a(this.d(), var3.d()) || !a1.k.a(this.j(), var3.j())) {
            var2 = false;
         }

         return var2;
      }
   }

   public int hashCode() {
      int var1;
      if (this.j() == null) {
         var1 = 0;
      } else {
         var1 = this.j().hashCode() * 31;
      }

      return (var1 + this.f().hashCode()) * 31 + this.k().hashCode();
   }

   public String toString() {
      e1.a var1 = this.a();
      if (var1 != this) {
         return var1.toString();
      } else {
         String var2;
         if ("<init>".equals(this.f())) {
            var2 = "constructor (Kotlin reflection is not available)";
         } else {
            StringBuilder var3 = new StringBuilder();
            var3.append("function ");
            var3.append(this.f());
            var3.append(" (Kotlin reflection is not available)");
            var2 = var3.toString();
         }

         return var2;
      }
   }
}
