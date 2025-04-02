package android.graphics;

import android.annotation.NonNull;
import android.graphics.ImageDecoder.Source;
import java.io.IOException;
import java.nio.ByteBuffer;

// $FF: synthetic class
public final class ImageDecoder implements AutoCloseable {
   static {
      throw new NoClassDefFoundError();
   }

   // $FF: synthetic method
   @NonNull
   public static native Source createSource(@NonNull ByteBuffer var0);

   // $FF: synthetic method
   @NonNull
   public static native Bitmap decodeBitmap(@NonNull Source var0, @NonNull ImageDecoder$OnHeaderDecodedListener var1) throws IOException;

   // $FF: synthetic method
   public native void setAllocator(int var1);

   // $FF: synthetic method
   public native void setTargetColorSpace(ColorSpace var1);
}
