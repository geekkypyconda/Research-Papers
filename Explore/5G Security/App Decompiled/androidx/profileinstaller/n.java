package androidx.profileinstaller;

import android.view.Choreographer.FrameCallback;

// $FF: synthetic class
public final class n implements FrameCallback {
   // $FF: synthetic field
   public final Runnable a;

   // $FF: synthetic method
   public n(Runnable var1) {
      this.a = var1;
   }

   public final void doFrame(long var1) {
      ProfileInstallerInitializer.a.a(this.a, var1);
   }
}
