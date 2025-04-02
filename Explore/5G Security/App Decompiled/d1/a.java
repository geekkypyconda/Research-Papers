package d1;

import a1.g;
import q0.a0;

public class a implements Iterable<Integer> {
   public static final d1.a.a h = new d1.a.a((g)null);
   private final int e;
   private final int f;
   private final int g;

   public a(int var1, int var2, int var3) {
      if (var3 != 0) {
         if (var3 != Integer.MIN_VALUE) {
            this.e = var1;
            this.f = u0.c.b(var1, var2, var3);
            this.g = var3;
         } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
         }
      } else {
         throw new IllegalArgumentException("Step must be non-zero.");
      }
   }

   public final int a() {
      return this.e;
   }

   public final int b() {
      return this.f;
   }

   public final int c() {
      return this.g;
   }

   public a0 d() {
      return new b(this.e, this.f, this.g);
   }

   public boolean equals(Object var1) {
      boolean var3;
      label29: {
         if (var1 instanceof d1.a) {
            if (this.isEmpty() && ((d1.a)var1).isEmpty()) {
               break label29;
            }

            int var2 = this.e;
            d1.a var4 = (d1.a)var1;
            if (var2 == var4.e && this.f == var4.f && this.g == var4.g) {
               break label29;
            }
         }

         var3 = false;
         return var3;
      }

      var3 = true;
      return var3;
   }

   public int hashCode() {
      int var1;
      if (this.isEmpty()) {
         var1 = -1;
      } else {
         var1 = (this.e * 31 + this.f) * 31 + this.g;
      }

      return var1;
   }

   public boolean isEmpty() {
      int var1 = this.g;
      boolean var2 = true;
      if (var1 > 0) {
         if (this.e > this.f) {
            return var2;
         }
      } else if (this.e < this.f) {
         return var2;
      }

      var2 = false;
      return var2;
   }

   public String toString() {
      StringBuilder var1;
      int var2;
      if (this.g > 0) {
         var1 = new StringBuilder();
         var1.append(this.e);
         var1.append("..");
         var1.append(this.f);
         var1.append(" step ");
         var2 = this.g;
      } else {
         var1 = new StringBuilder();
         var1.append(this.e);
         var1.append(" downTo ");
         var1.append(this.f);
         var1.append(" step ");
         var2 = -this.g;
      }

      var1.append(var2);
      return var1.toString();
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(g var1) {
         this();
      }

      public final d1.a a(int var1, int var2, int var3) {
         return new d1.a(var1, var2, var3);
      }
   }
}
