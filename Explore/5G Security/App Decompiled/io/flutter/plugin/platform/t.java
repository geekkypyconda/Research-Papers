package io.flutter.plugin.platform;

import android.view.View;
import android.view.View.OnFocusChangeListener;

// $FF: synthetic class
public final class t implements OnFocusChangeListener {
   // $FF: synthetic field
   public final w a;
   // $FF: synthetic field
   public final j0.m.d b;

   // $FF: synthetic method
   public t(w var1, j0.m.d var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void onFocusChange(View var1, boolean var2) {
      w.g(this.a, this.b, var1, var2);
   }
}
