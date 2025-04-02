package androidx.profileinstaller;

import android.content.Context;

// $FF: synthetic class
public final class m implements Runnable {
   // $FF: synthetic field
   public final Context e;

   // $FF: synthetic method
   public m(Context var1) {
      this.e = var1;
   }

   public final void run() {
      ProfileInstallerInitializer.e(this.e);
   }
}
