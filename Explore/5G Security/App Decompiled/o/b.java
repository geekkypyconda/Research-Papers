package o;

import android.graphics.Rect;

public final class b {
   private final int a;
   private final int b;
   private final int c;
   private final int d;

   public b(int var1, int var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      boolean var5 = true;
      boolean var6;
      if (var1 <= var3) {
         var6 = true;
      } else {
         var6 = false;
      }

      StringBuilder var7;
      if (var6) {
         boolean var8;
         if (var2 <= var4) {
            var8 = var5;
         } else {
            var8 = false;
         }

         if (!var8) {
            var7 = new StringBuilder();
            var7.append("top must be less than or equal to bottom, top: ");
            var7.append(var2);
            var7.append(", bottom: ");
            var7.append(var4);
            throw new IllegalArgumentException(var7.toString().toString());
         }
      } else {
         var7 = new StringBuilder();
         var7.append("Left must be less than or equal to right, left: ");
         var7.append(var1);
         var7.append(", right: ");
         var7.append(var3);
         throw new IllegalArgumentException(var7.toString().toString());
      }
   }

   public b(Rect var1) {
      a1.k.e(var1, "rect");
      this(var1.left, var1.top, var1.right, var1.bottom);
   }

   public final int a() {
      return this.d - this.b;
   }

   public final int b() {
      return this.a;
   }

   public final int c() {
      return this.b;
   }

   public final int d() {
      return this.c - this.a;
   }

   public final boolean e() {
      boolean var1;
      if (this.a() == 0 && this.d() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         Class var2;
         if (var1 != null) {
            var2 = var1.getClass();
         } else {
            var2 = null;
         }

         if (!a1.k.a(b.class, var2)) {
            return false;
         } else {
            a1.k.c(var1, "null cannot be cast to non-null type androidx.window.core.Bounds");
            b var3 = (b)var1;
            if (this.a != var3.a) {
               return false;
            } else if (this.b != var3.b) {
               return false;
            } else if (this.c != var3.c) {
               return false;
            } else {
               return this.d == var3.d;
            }
         }
      }
   }

   public final Rect f() {
      return new Rect(this.a, this.b, this.c, this.d);
   }

   public int hashCode() {
      return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(b.class.getSimpleName());
      var1.append(" { [");
      var1.append(this.a);
      var1.append(',');
      var1.append(this.b);
      var1.append(',');
      var1.append(this.c);
      var1.append(',');
      var1.append(this.d);
      var1.append("] }");
      return var1.toString();
   }
}
