package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public class f implements ActivityLifecycleCallbacks {
   public void onActivityCreated(Activity var1, Bundle var2) {
      a1.k.e(var1, "activity");
   }

   public void onActivityDestroyed(Activity var1) {
      a1.k.e(var1, "activity");
   }

   public void onActivityPaused(Activity var1) {
      a1.k.e(var1, "activity");
   }

   public void onActivityResumed(Activity var1) {
      a1.k.e(var1, "activity");
   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      a1.k.e(var1, "activity");
      a1.k.e(var2, "outState");
   }

   public void onActivityStarted(Activity var1) {
      a1.k.e(var1, "activity");
   }

   public void onActivityStopped(Activity var1) {
      a1.k.e(var1, "activity");
   }
}
