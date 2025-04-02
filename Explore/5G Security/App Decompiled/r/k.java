package r;

import android.graphics.Rect;
import androidx.core.view.v;

public final class k {
   private final o.b a;
   private final v b;

   public k(Rect var1, v var2) {
      a1.k.e(var1, "bounds");
      a1.k.e(var2, "insets");
      this(new o.b(var1), var2);
   }

   // $FF: synthetic method
   public k(Rect var1, v var2, int var3, a1.g var4) {
      if ((var3 & 2) != 0) {
         var2 = (new v.b()).a();
         a1.k.d(var2, "Builder().build()");
      }

      this(var1, var2);
   }

   public k(o.b var1, v var2) {
      a1.k.e(var1, "_bounds");
      a1.k.e(var2, "_windowInsetsCompat");
      super();
      this.a = var1;
      this.b = var2;
   }

   public final Rect a() {
      return this.a.f();
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

         if (!a1.k.a(k.class, var2)) {
            return false;
         } else {
            a1.k.c(var1, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
            k var3 = (k)var1;
            if (!a1.k.a(this.a, var3.a)) {
               return false;
            } else {
               return a1.k.a(this.b, var3.b);
            }
         }
      }
   }

   public int hashCode() {
      return this.a.hashCode() * 31 + this.b.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("WindowMetrics( bounds=");
      var1.append(this.a);
      var1.append(", windowInsetsCompat=");
      var1.append(this.b);
      var1.append(')');
      return var1.toString();
   }
}
