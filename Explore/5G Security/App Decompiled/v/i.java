package v;

import a1.k;
import android.view.DisplayCutout;

public final class i {
   public static final i a = new i();

   private i() {
   }

   public final int a(DisplayCutout var1) {
      k.e(var1, "displayCutout");
      return var1.getSafeInsetBottom();
   }

   public final int b(DisplayCutout var1) {
      k.e(var1, "displayCutout");
      return var1.getSafeInsetLeft();
   }

   public final int c(DisplayCutout var1) {
      k.e(var1, "displayCutout");
      return var1.getSafeInsetRight();
   }

   public final int d(DisplayCutout var1) {
      k.e(var1, "displayCutout");
      return var1.getSafeInsetTop();
   }
}
