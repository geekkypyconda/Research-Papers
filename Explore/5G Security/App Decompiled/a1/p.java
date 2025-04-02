package a1;

public abstract class p extends c implements e1.g {
   private final boolean l;

   public p() {
      this.l = false;
   }

   public p(Object var1, Class var2, String var3, String var4, int var5) {
      boolean var6 = false;
      boolean var7;
      if ((var5 & 1) == 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      super(var1, var2, var3, var4, var7);
      var7 = var6;
      if ((var5 & 2) == 2) {
         var7 = true;
      }

      this.l = var7;
   }

   public e1.a a() {
      Object var1;
      if (this.l) {
         var1 = this;
      } else {
         var1 = super.a();
      }

      return (e1.a)var1;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof p)) {
         return var1 instanceof e1.g ? var1.equals(this.a()) : false;
      } else {
         p var3 = (p)var1;
         if (!this.j().equals(var3.j()) || !this.f().equals(var3.f()) || !this.k().equals(var3.k()) || !a1.k.a(this.d(), var3.d())) {
            var2 = false;
         }

         return var2;
      }
   }

   public int hashCode() {
      return (this.j().hashCode() * 31 + this.f().hashCode()) * 31 + this.k().hashCode();
   }

   public String toString() {
      e1.a var1 = this.a();
      if (var1 != this) {
         return var1.toString();
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("property ");
         var2.append(this.f());
         var2.append(" (Kotlin reflection is not available)");
         return var2.toString();
      }
   }
}
