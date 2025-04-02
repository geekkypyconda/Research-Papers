package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import java.util.List;

public final class a {
   private final DisplayCutout a;

   private a(DisplayCutout var1) {
      this.a = var1;
   }

   static androidx.core.view.a e(DisplayCutout var0) {
      androidx.core.view.a var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = new androidx.core.view.a(var0);
      }

      return var1;
   }

   public int a() {
      return VERSION.SDK_INT >= 28 ? androidx.core.view.a.a.c(this.a) : 0;
   }

   public int b() {
      return VERSION.SDK_INT >= 28 ? androidx.core.view.a.a.d(this.a) : 0;
   }

   public int c() {
      return VERSION.SDK_INT >= 28 ? androidx.core.view.a.a.e(this.a) : 0;
   }

   public int d() {
      return VERSION.SDK_INT >= 28 ? androidx.core.view.a.a.f(this.a) : 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && androidx.core.view.a.class == var1.getClass()) {
         androidx.core.view.a var2 = (androidx.core.view.a)var1;
         return h.b.a(this.a, var2.a);
      } else {
         return false;
      }
   }

   public int hashCode() {
      DisplayCutout var1 = this.a;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.hashCode();
      }

      return var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DisplayCutoutCompat{");
      var1.append(this.a);
      var1.append("}");
      return var1.toString();
   }

   static class a {
      static DisplayCutout a(Rect var0, List<Rect> var1) {
         return new DisplayCutout(var0, var1);
      }

      static List<Rect> b(DisplayCutout var0) {
         return var0.getBoundingRects();
      }

      static int c(DisplayCutout var0) {
         return var0.getSafeInsetBottom();
      }

      static int d(DisplayCutout var0) {
         return var0.getSafeInsetLeft();
      }

      static int e(DisplayCutout var0) {
         return var0.getSafeInsetRight();
      }

      static int f(DisplayCutout var0) {
         return var0.getSafeInsetTop();
      }
   }
}
