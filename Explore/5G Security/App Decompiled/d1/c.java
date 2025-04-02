package d1;

import a1.g;

public final class c extends d1.a {
   public static final c.a i = new c.a((g)null);
   private static final c j = new c(1, 0);

   public c(int var1, int var2) {
      super(var1, var2, 1);
   }

   public boolean equals(Object var1) {
      boolean var3;
      label27: {
         if (var1 instanceof c) {
            if (this.isEmpty() && ((c)var1).isEmpty()) {
               break label27;
            }

            int var2 = this.a();
            c var4 = (c)var1;
            if (var2 == var4.a() && this.b() == var4.b()) {
               break label27;
            }
         }

         var3 = false;
         return var3;
      }

      var3 = true;
      return var3;
   }

   public boolean f(int var1) {
      boolean var2;
      if (this.a() <= var1 && var1 <= this.b()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public Integer g() {
      return this.b();
   }

   public Integer h() {
      return this.a();
   }

   public int hashCode() {
      int var1;
      if (this.isEmpty()) {
         var1 = -1;
      } else {
         var1 = this.a() * 31 + this.b();
      }

      return var1;
   }

   public boolean isEmpty() {
      boolean var1;
      if (this.a() > this.b()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.a());
      var1.append("..");
      var1.append(this.b());
      return var1.toString();
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(g var1) {
         this();
      }

      public final c a() {
         return c.j;
      }
   }
}
