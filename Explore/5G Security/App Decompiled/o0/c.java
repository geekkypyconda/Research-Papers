package o0;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;

public final class c {
   public static String a(Context var0) {
      File var1 = var0.getCodeCacheDir();
      File var2 = var1;
      if (var1 == null) {
         var2 = var0.getCacheDir();
      }

      var1 = var2;
      if (var2 == null) {
         var1 = new File(b(var0), "cache");
      }

      return var1.getPath();
   }

   private static String b(Context var0) {
      return VERSION.SDK_INT >= 24 ? b.a(var0).getPath() : var0.getApplicationInfo().dataDir;
   }

   public static String c(Context var0) {
      File var1 = var0.getDir("flutter", 0);
      File var2 = var1;
      if (var1 == null) {
         var2 = new File(b(var0), "app_flutter");
      }

      return var2.getPath();
   }

   public static String d(Context var0) {
      File var1 = var0.getFilesDir();
      File var2 = var1;
      if (var1 == null) {
         var2 = new File(b(var0), "files");
      }

      return var2.getPath();
   }
}
