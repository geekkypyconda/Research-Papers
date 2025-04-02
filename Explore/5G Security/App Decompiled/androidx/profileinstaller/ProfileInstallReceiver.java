package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.os.Build.VERSION;

public class ProfileInstallReceiver extends BroadcastReceiver {
   static void a(j.c var0) {
      byte var1;
      if (VERSION.SDK_INT >= 24) {
         Process.sendSignal(Process.myPid(), 10);
         var1 = 12;
      } else {
         var1 = 13;
      }

      var0.b(var1, (Object)null);
   }

   public void onReceive(Context var1, Intent var2) {
      if (var2 != null) {
         String var3 = var2.getAction();
         if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(var3)) {
            j.k(var1, new h(), new ProfileInstallReceiver.a(), true);
         } else {
            Bundle var4;
            if ("androidx.profileinstaller.action.SKIP_FILE".equals(var3)) {
               var4 = var2.getExtras();
               if (var4 != null) {
                  String var5 = var4.getString("EXTRA_SKIP_FILE_OPERATION");
                  if ("WRITE_SKIP_FILE".equals(var5)) {
                     j.l(var1, new h(), new ProfileInstallReceiver.a());
                  } else if ("DELETE_SKIP_FILE".equals(var5)) {
                     j.c(var1, new h(), new ProfileInstallReceiver.a());
                  }
               }
            } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(var3)) {
               a(new ProfileInstallReceiver.a());
            } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(var3)) {
               var4 = var2.getExtras();
               if (var4 != null) {
                  var3 = var4.getString("EXTRA_BENCHMARK_OPERATION");
                  ProfileInstallReceiver.a var6 = new ProfileInstallReceiver.a();
                  if ("DROP_SHADER_CACHE".equals(var3)) {
                     androidx.profileinstaller.a.b(var1, var6);
                  } else {
                     var6.b(16, (Object)null);
                  }
               }
            }
         }

      }
   }

   class a implements j.c {
      public void a(int var1, Object var2) {
         j.b.a(var1, var2);
      }

      public void b(int var1, Object var2) {
         j.b.b(var1, var2);
         ProfileInstallReceiver.this.setResultCode(var1);
      }
   }
}
