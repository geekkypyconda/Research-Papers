package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

// $FF: synthetic class
public final class c implements OnFrameAvailableListener {
   // $FF: synthetic field
   public final FlutterRenderer.f a;

   // $FF: synthetic method
   public c(FlutterRenderer.f var1) {
      this.a = var1;
   }

   public final void onFrameAvailable(SurfaceTexture var1) {
      FlutterRenderer.f.a(this.a, var1);
   }
}
