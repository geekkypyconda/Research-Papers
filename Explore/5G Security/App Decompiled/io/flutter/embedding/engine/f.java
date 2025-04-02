package io.flutter.embedding.engine;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$ImageInfo;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder.Source;

// $FF: synthetic class
public final class f implements ImageDecoder$OnHeaderDecodedListener {
   // $FF: synthetic field
   public final long a;

   // $FF: synthetic method
   public f(long var1) {
      this.a = var1;
   }

   public final void onHeaderDecoded(ImageDecoder var1, ImageDecoder$ImageInfo var2, Source var3) {
      FlutterJNI.a(this.a, var1, var2, var3);
   }
}
