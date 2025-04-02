package io.flutter.plugin.platform;

import android.view.View;
import android.view.View.OnFocusChangeListener;

// $FF: synthetic class
public final class r implements OnFocusChangeListener {
   // $FF: synthetic field
   public final w a;
   // $FF: synthetic field
   public final int b;

   // $FF: synthetic method
   public r(w var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void onFocusChange(View var1, boolean var2) {
      w.h(this.a, this.b, var1, var2);
   }
}
