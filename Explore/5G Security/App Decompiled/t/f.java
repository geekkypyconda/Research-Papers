package t;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.window.extensions.layout.DisplayFeature;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r.j;
import r.k;
import r.n;

public final class f {
   public static final f a = new f();

   private f() {
   }

   private final boolean d(k var1, o.b var2) {
      Rect var3 = var1.a();
      if (var2.e()) {
         return false;
      } else if (var2.d() != var3.width() && var2.a() != var3.height()) {
         return false;
      } else if (var2.d() < var3.width() && var2.a() < var3.height()) {
         return false;
      } else {
         return var2.d() != var3.width() || var2.a() != var3.height();
      }
   }

   public final r.c a(k var1, FoldingFeature var2) {
      a1.k.e(var1, "windowMetrics");
      a1.k.e(var2, "oemFeature");
      int var3 = var2.getType();
      r.d var4 = null;
      r.d.b var5;
      if (var3 != 1) {
         if (var3 != 2) {
            return null;
         }

         var5 = r.d.b.b.b();
      } else {
         var5 = r.d.b.b.a();
      }

      var3 = var2.getState();
      r.c.b var6;
      if (var3 != 1) {
         if (var3 != 2) {
            return null;
         }

         var6 = r.c.b.d;
      } else {
         var6 = r.c.b.c;
      }

      Rect var7 = var2.getBounds();
      a1.k.d(var7, "oemFeature.bounds");
      if (this.d(var1, new o.b(var7))) {
         Rect var8 = var2.getBounds();
         a1.k.d(var8, "oemFeature.bounds");
         var4 = new r.d(new o.b(var8), var5, var6);
      }

      return var4;
   }

   public final j b(Context var1, WindowLayoutInfo var2) {
      a1.k.e(var1, "context");
      a1.k.e(var2, "info");
      int var3 = VERSION.SDK_INT;
      k var4;
      if (var3 >= 30) {
         var4 = n.b.c(var1);
      } else {
         if (var3 < 29 || !(var1 instanceof Activity)) {
            throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
         }

         var4 = n.b.b((Activity)var1);
      }

      j var5 = this.c(var4, var2);
      return var5;
   }

   public final j c(k var1, WindowLayoutInfo var2) {
      a1.k.e(var1, "windowMetrics");
      a1.k.e(var2, "info");
      List var6 = var2.getDisplayFeatures();
      a1.k.d(var6, "info.displayFeatures");
      ArrayList var3 = new ArrayList();
      Iterator var4 = var6.iterator();

      while(var4.hasNext()) {
         DisplayFeature var5 = (DisplayFeature)var4.next();
         r.c var8;
         if (var5 instanceof FoldingFeature) {
            f var7 = a;
            a1.k.d(var5, "feature");
            var8 = var7.a(var1, (FoldingFeature)var5);
         } else {
            var8 = null;
         }

         if (var8 != null) {
            var3.add(var8);
         }
      }

      return new j(var3);
   }
}
