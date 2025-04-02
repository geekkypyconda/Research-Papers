package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;

// $FF: synthetic class
public final class u implements View$OnUnhandledKeyEventListener {
   // $FF: synthetic field
   public final f.h a;

   // $FF: synthetic method
   public u(f.h var1) {
      this.a = var1;
   }

   public final boolean onUnhandledKeyEvent(View var1, KeyEvent var2) {
      return this.a.onUnhandledKeyEvent(var1, var2);
   }
}
