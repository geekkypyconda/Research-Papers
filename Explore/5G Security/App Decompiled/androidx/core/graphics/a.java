package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

public final class a {
   public static final androidx.core.graphics.a e = new androidx.core.graphics.a(0, 0, 0, 0);
   public final int a;
   public final int b;
   public final int c;
   public final int d;

   private a(int var1, int var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public static androidx.core.graphics.a a(androidx.core.graphics.a var0, androidx.core.graphics.a var1) {
      return b(Math.max(var0.a, var1.a), Math.max(var0.b, var1.b), Math.max(var0.c, var1.c), Math.max(var0.d, var1.d));
   }

   public static androidx.core.graphics.a b(int var0, int var1, int var2, int var3) {
      return var0 == 0 && var1 == 0 && var2 == 0 && var3 == 0 ? e : new androidx.core.graphics.a(var0, var1, var2, var3);
   }

   public static androidx.core.graphics.a c(Rect var0) {
      return b(var0.left, var0.top, var0.right, var0.bottom);
   }

   public static androidx.core.graphics.a d(Insets var0) {
      return b(var0.left, var0.top, var0.right, var0.bottom);
   }

   public Insets e() {
      return androidx.core.graphics.a.a.a(this.a, this.b, this.c, this.d);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && androidx.core.graphics.a.class == var1.getClass()) {
         androidx.core.graphics.a var2 = (androidx.core.graphics.a)var1;
         if (this.d != var2.d) {
            return false;
         } else if (this.a != var2.a) {
            return false;
         } else if (this.c != var2.c) {
            return false;
         } else {
            return this.b == var2.b;
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Insets{left=");
      var1.append(this.a);
      var1.append(", top=");
      var1.append(this.b);
      var1.append(", right=");
      var1.append(this.c);
      var1.append(", bottom=");
      var1.append(this.d);
      var1.append('}');
      return var1.toString();
   }

   static class a {
      static Insets a(int var0, int var1, int var2, int var3) {
         return Insets.of(var0, var1, var2, var3);
      }
   }
}
