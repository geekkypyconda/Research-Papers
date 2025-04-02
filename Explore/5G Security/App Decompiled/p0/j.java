package p0;

import java.io.Serializable;

public final class j<A, B> implements Serializable {
   private final A e;
   private final B f;

   public j(A var1, B var2) {
      this.e = var1;
      this.f = var2;
   }

   public final A a() {
      return this.e;
   }

   public final B b() {
      return this.f;
   }

   public final A c() {
      return this.e;
   }

   public final B d() {
      return this.f;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof j)) {
         return false;
      } else {
         j var2 = (j)var1;
         if (!a1.k.a(this.e, var2.e)) {
            return false;
         } else {
            return a1.k.a(this.f, var2.f);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.e;
      int var2 = 0;
      int var3;
      if (var1 == null) {
         var3 = 0;
      } else {
         var3 = var1.hashCode();
      }

      var1 = this.f;
      if (var1 != null) {
         var2 = var1.hashCode();
      }

      return var3 * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append('(');
      var1.append(this.e);
      var1.append(", ");
      var1.append(this.f);
      var1.append(')');
      return var1.toString();
   }
}
