package io.flutter.embedding.android;

import android.window.OnBackInvokedCallback;

// $FF: synthetic class
public final class e implements OnBackInvokedCallback {
   // $FF: synthetic field
   public final f a;

   // $FF: synthetic method
   public e(f var1) {
      this.a = var1;
   }

   public final void onBackInvoked() {
      this.a.onBackPressed();
   }
}
