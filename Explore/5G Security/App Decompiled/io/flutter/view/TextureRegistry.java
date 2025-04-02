package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;

public interface TextureRegistry {
   TextureRegistry.SurfaceProducer a();

   TextureRegistry.ImageTextureEntry b();

   TextureRegistry.SurfaceTextureEntry c();

   public interface GLTextureConsumer {
      SurfaceTexture getSurfaceTexture();
   }

   public interface ImageConsumer {
      Image acquireLatestImage();
   }

   public interface ImageTextureEntry {
      // $FF: synthetic method
      long id();

      void pushImage(Image var1);

      // $FF: synthetic method
      void release();
   }

   public interface SurfaceProducer {
      int getHeight();

      Surface getSurface();

      int getWidth();

      // $FF: synthetic method
      long id();

      // $FF: synthetic method
      void release();

      void scheduleFrame();

      void setCallback(TextureRegistry.SurfaceProducer.a var1);

      void setSize(int var1, int var2);

      public interface a {
         void a();

         void b();
      }
   }

   public interface SurfaceTextureEntry {
      // $FF: synthetic method
      long id();

      // $FF: synthetic method
      void release();

      void setOnFrameConsumedListener(TextureRegistry.a var1);

      void setOnTrimMemoryListener(TextureRegistry.b var1);

      SurfaceTexture surfaceTexture();
   }

   public interface a {
      void a();
   }

   public interface b {
      void onTrimMemory(int var1);
   }
}
