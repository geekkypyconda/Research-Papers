package androidx.profileinstaller;

import android.content.Context;

// $FF: synthetic class
public final class k implements Runnable {
   // $FF: synthetic field
   public final ProfileInstallerInitializer e;
   // $FF: synthetic field
   public final Context f;

   // $FF: synthetic method
   public k(ProfileInstallerInitializer var1, Context var2) {
      this.e = var1;
      this.f = var2;
   }

   public final void run() {
      ProfileInstallerInitializer.c(this.e, this.f);
   }
}
