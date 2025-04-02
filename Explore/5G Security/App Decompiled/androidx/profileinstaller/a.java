package androidx.profileinstaller;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;

class a {
   static boolean a(File var0) {
      if (!var0.isDirectory()) {
         var0.delete();
         return true;
      } else {
         File[] var4 = var0.listFiles();
         if (var4 == null) {
            return false;
         } else {
            int var1 = var4.length;
            int var2 = 0;

            boolean var3;
            for(var3 = true; var2 < var1; ++var2) {
               if (a(var4[var2]) && var3) {
                  var3 = true;
               } else {
                  var3 = false;
               }
            }

            return var3;
         }
      }
   }

   static void b(Context var0, ProfileInstallReceiver.a var1) {
      int var2 = VERSION.SDK_INT;
      File var3;
      if (var2 >= 24) {
         var3 = androidx.profileinstaller.a.b.a(var0);
      } else if (var2 >= 23) {
         var3 = androidx.profileinstaller.a.a.a(var0);
      } else {
         var3 = var0.getCacheDir();
      }

      byte var4;
      if (a(var3)) {
         var4 = 14;
      } else {
         var4 = 15;
      }

      var1.b(var4, (Object)null);
   }

   private static class a {
      static File a(Context var0) {
         return var0.getCodeCacheDir();
      }
   }

   private static class b {
      static File a(Context var0) {
         return androidx.profileinstaller.b.a(var0).getCodeCacheDir();
      }
   }
}
