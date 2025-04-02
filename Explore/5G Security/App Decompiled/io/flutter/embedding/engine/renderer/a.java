package io.flutter.embedding.engine.renderer;

import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;

// $FF: synthetic class
public final class a implements OnImageAvailableListener {
   // $FF: synthetic field
   public final FlutterRenderer.ImageReaderSurfaceProducer.b a;

   // $FF: synthetic method
   public a(FlutterRenderer.ImageReaderSurfaceProducer.b var1) {
      this.a = var1;
   }

   public final void onImageAvailable(ImageReader var1) {
      FlutterRenderer.ImageReaderSurfaceProducer.b.a(this.a, var1);
   }
}
