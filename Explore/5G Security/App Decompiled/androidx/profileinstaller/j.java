package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class j {
   private static final j.c a = new j.c() {
      public void a(int var1, Object var2) {
      }

      public void b(int var1, Object var2) {
      }
   };
   static final j.c b = new j.c() {
      public void a(int var1, Object var2) {
         String var3;
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  if (var1 != 4) {
                     if (var1 != 5) {
                        var3 = "";
                     } else {
                        var3 = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
                     }
                  } else {
                     var3 = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
                  }
               } else {
                  var3 = "DIAGNOSTIC_REF_PROFILE_EXISTS";
               }
            } else {
               var3 = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
            }
         } else {
            var3 = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
         }

         Log.d("ProfileInstaller", var3);
      }

      public void b(int var1, Object var2) {
         String var3;
         switch(var1) {
         case 1:
            var3 = "RESULT_INSTALL_SUCCESS";
            break;
         case 2:
            var3 = "RESULT_ALREADY_INSTALLED";
            break;
         case 3:
            var3 = "RESULT_UNSUPPORTED_ART_VERSION";
            break;
         case 4:
            var3 = "RESULT_NOT_WRITABLE";
            break;
         case 5:
            var3 = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
            break;
         case 6:
            var3 = "RESULT_BASELINE_PROFILE_NOT_FOUND";
            break;
         case 7:
            var3 = "RESULT_IO_EXCEPTION";
            break;
         case 8:
            var3 = "RESULT_PARSE_EXCEPTION";
            break;
         case 9:
         default:
            var3 = "";
            break;
         case 10:
            var3 = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
            break;
         case 11:
            var3 = "RESULT_DELETE_SKIP_FILE_SUCCESS";
         }

         if (var1 != 6 && var1 != 7 && var1 != 8) {
            Log.d("ProfileInstaller", var3);
         } else {
            Log.e("ProfileInstaller", var3, (Throwable)var2);
         }

      }
   };

   // $FF: synthetic method
   public static void a(j.c var0, int var1, Object var2) {
      e(var0, var1, var2);
   }

   static boolean b(File var0) {
      return (new File(var0, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")).delete();
   }

   static void c(Context var0, Executor var1, j.c var2) {
      b(var0.getFilesDir());
      g(var1, var2, 11, (Object)null);
   }

   static boolean d(PackageInfo var0, File var1, j.c var2) {
      File var3 = new File(var1, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
      boolean var4 = var3.exists();
      boolean var5 = false;
      if (!var4) {
         return false;
      } else {
         boolean var10001;
         DataInputStream var28;
         try {
            FileInputStream var6 = new FileInputStream(var3);
            var28 = new DataInputStream(var6);
         } catch (IOException var26) {
            var10001 = false;
            return false;
         }

         long var7;
         try {
            var7 = var28.readLong();
         } catch (Throwable var25) {
            Throwable var27 = var25;

            try {
               var28.close();
            } catch (Throwable var23) {
               Throwable var29 = var23;

               label144:
               try {
                  var27.addSuppressed(var29);
                  break label144;
               } catch (IOException var22) {
                  var10001 = false;
                  return false;
               }
            }

            try {
               throw var27;
            } catch (IOException var21) {
               var10001 = false;
               return false;
            }
         }

         try {
            var28.close();
         } catch (IOException var24) {
            var10001 = false;
            return false;
         }

         if (var7 == var0.lastUpdateTime) {
            var5 = true;
         }

         if (var5) {
            var2.b(2, (Object)null);
         }

         return var5;
      }
   }

   // $FF: synthetic method
   private static void e(j.c var0, int var1, Object var2) {
      var0.b(var1, var2);
   }

   static void f(PackageInfo var0, File var1) {
      File var2 = new File(var1, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");

      boolean var10001;
      DataOutputStream var23;
      try {
         FileOutputStream var3 = new FileOutputStream(var2);
         var23 = new DataOutputStream(var3);
      } catch (IOException var21) {
         var10001 = false;
         return;
      }

      try {
         var23.writeLong(var0.lastUpdateTime);
      } catch (Throwable var20) {
         Throwable var22 = var20;

         try {
            var23.close();
         } catch (Throwable var18) {
            Throwable var24 = var18;

            label116:
            try {
               var22.addSuppressed(var24);
               break label116;
            } catch (IOException var17) {
               var10001 = false;
               return;
            }
         }

         try {
            throw var22;
         } catch (IOException var16) {
            var10001 = false;
            return;
         }
      }

      try {
         var23.close();
      } catch (IOException var19) {
         var10001 = false;
      }

   }

   static void g(Executor var0, j.c var1, int var2, Object var3) {
      var0.execute(new i(var1, var2, var3));
   }

   private static boolean h(AssetManager var0, String var1, PackageInfo var2, File var3, String var4, Executor var5, j.c var6) {
      d var8 = new d(var0, var5, var6, var4, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", var1), "primary.prof"));
      if (!var8.e()) {
         return false;
      } else {
         boolean var7 = var8.i().m().n();
         if (var7) {
            f(var2, var3);
         }

         return var7;
      }
   }

   public static void i(Context var0) {
      j(var0, new h(), a);
   }

   public static void j(Context var0, Executor var1, j.c var2) {
      k(var0, var1, var2, false);
   }

   static void k(Context var0, Executor var1, j.c var2, boolean var3) {
      Context var4 = var0.getApplicationContext();
      String var5 = var4.getPackageName();
      ApplicationInfo var6 = var4.getApplicationInfo();
      AssetManager var14 = var4.getAssets();
      String var15 = (new File(var6.sourceDir)).getName();
      PackageManager var7 = var0.getPackageManager();
      boolean var8 = false;

      PackageInfo var16;
      try {
         var16 = var7.getPackageInfo(var5, 0);
      } catch (NameNotFoundException var12) {
         var2.b(7, var12);
         p.c(var0, false);
         return;
      }

      File var9 = var0.getFilesDir();
      boolean var10;
      if (!var3 && d(var16, var9, var2)) {
         StringBuilder var13 = new StringBuilder();
         var13.append("Skipping profile installation for ");
         var13.append(var0.getPackageName());
         Log.d("ProfileInstaller", var13.toString());
         var10 = var8;
      } else {
         StringBuilder var11 = new StringBuilder();
         var11.append("Installing profile for ");
         var11.append(var0.getPackageName());
         Log.d("ProfileInstaller", var11.toString());
         var10 = var8;
         if (h(var14, var5, var16, var9, var15, var1, var2)) {
            var10 = var8;
            if (var3) {
               var10 = true;
            }
         }
      }

      p.c(var0, var10);
   }

   static void l(Context var0, Executor var1, j.c var2) {
      String var3 = var0.getApplicationContext().getPackageName();
      PackageManager var4 = var0.getPackageManager();

      PackageInfo var6;
      try {
         var6 = var4.getPackageInfo(var3, 0);
      } catch (NameNotFoundException var5) {
         g(var1, var2, 7, var5);
         return;
      }

      f(var6, var0.getFilesDir());
      g(var1, var2, 10, (Object)null);
   }

   public interface c {
      void a(int var1, Object var2);

      void b(int var1, Object var2);
   }
}
