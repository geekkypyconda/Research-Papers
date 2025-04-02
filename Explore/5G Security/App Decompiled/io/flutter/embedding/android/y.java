package io.flutter.embedding.android;

import android.view.KeyEvent;

// $FF: synthetic class
public final class y implements Runnable {
   // $FF: synthetic field
   public final a0 e;
   // $FF: synthetic field
   public final c0.c f;
   // $FF: synthetic field
   public final long g;
   // $FF: synthetic field
   public final KeyEvent h;

   // $FF: synthetic method
   public y(a0 var1, c0.c var2, long var3, KeyEvent var5) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var5;
   }

   public final void run() {
      a0.d(this.e, this.f, this.g, this.h);
   }
}
