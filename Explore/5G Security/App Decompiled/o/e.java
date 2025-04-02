package o;

import a1.r;
import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;

public final class e {
   public static final e a = new e();
   private static final String b = r.b(e.class).b();

   private e() {
   }

   public final int a() {
      byte var1 = 0;

      int var2;
      String var3;
      String var4;
      try {
         var2 = WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
         return var2;
      } catch (NoClassDefFoundError var5) {
         var2 = var1;
         if (c.a.a() != j.f) {
            return var2;
         }

         var4 = b;
         var3 = "Embedding extension version not found";
      } catch (UnsupportedOperationException var6) {
         var2 = var1;
         if (c.a.a() != j.f) {
            return var2;
         }

         var4 = b;
         var3 = "Stub Extension";
      }

      Log.d(var4, var3);
      var2 = var1;
      return var2;
   }
}
