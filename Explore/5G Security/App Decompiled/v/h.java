package v;

import a1.k;
import android.graphics.Point;
import android.view.Display;

public final class h {
   public static final h a = new h();

   private h() {
   }

   public final void a(Display var1, Point var2) {
      k.e(var1, "display");
      k.e(var2, "point");
      var1.getRealSize(var2);
   }
}
