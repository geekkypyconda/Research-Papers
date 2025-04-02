package v;

import a1.k;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.v;

public final class g {
   public static final g a = new g();

   private g() {
   }

   public final Rect a(Context var1) {
      k.e(var1, "context");
      Rect var2 = e.a((WindowManager)d.a(var1, WindowManager.class)).getBounds();
      k.d(var2, "wm.currentWindowMetrics.bounds");
      return var2;
   }

   public final v b(Context var1) {
      k.e(var1, "context");
      WindowInsets var2 = e.a((WindowManager)d.a(var1, WindowManager.class)).getWindowInsets();
      k.d(var2, "context.getSystemService…indowMetrics.windowInsets");
      v var3 = v.m(var2);
      k.d(var3, "toWindowInsetsCompat(platformInsets)");
      return var3;
   }

   public final r.k c(Context var1) {
      k.e(var1, "context");
      WindowManager var2 = (WindowManager)d.a(var1, WindowManager.class);
      v var3 = v.m(e.a(var2).getWindowInsets());
      k.d(var3, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
      Rect var4 = e.a(var2).getBounds();
      k.d(var4, "wm.currentWindowMetrics.bounds");
      return new r.k(var4, var3);
   }

   public final Rect d(Context var1) {
      k.e(var1, "context");
      Rect var2 = f.a((WindowManager)d.a(var1, WindowManager.class)).getBounds();
      k.d(var2, "wm.maximumWindowMetrics.bounds");
      return var2;
   }
}
