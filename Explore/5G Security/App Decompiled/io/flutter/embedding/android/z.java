package io.flutter.embedding.android;

import android.view.KeyEvent;

// $FF: synthetic class
public final class z implements Runnable {
   // $FF: synthetic field
   public final a0 e;
   // $FF: synthetic field
   public final c0.c f;
   // $FF: synthetic field
   public final KeyEvent g;

   // $FF: synthetic method
   public z(a0 var1, c0.c var2, KeyEvent var3) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
   }

   public final void run() {
      a0.b(this.e, this.f, this.g);
   }
}
