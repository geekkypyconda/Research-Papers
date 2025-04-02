package h1;

public final class v {
   public final Object a;
   public final z0.l<Throwable, p0.q> b;

   public v(Object var1, z0.l<? super Throwable, p0.q> var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof v)) {
         return false;
      } else {
         v var2 = (v)var1;
         if (!a1.k.a(this.a, var2.a)) {
            return false;
         } else {
            return a1.k.a(this.b, var2.b);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.a;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.hashCode();
      }

      return var2 * 31 + this.b.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("CompletedWithCancellation(result=");
      var1.append(this.a);
      var1.append(", onCancellation=");
      var1.append(this.b);
      var1.append(')');
      return var1.toString();
   }
}
