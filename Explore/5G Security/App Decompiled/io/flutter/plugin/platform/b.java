package io.flutter.plugin.platform;

import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.Builder;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.Build.VERSION;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

public class b implements n {
   private TextureRegistry.ImageTextureEntry a;
   private ImageReader b;
   private int c = 0;
   private int d = 0;
   private final Handler e = new Handler();
   private final OnImageAvailableListener f = new OnImageAvailableListener() {
      public void onImageAvailable(ImageReader var1) {
         Image var4;
         try {
            var4 = var1.acquireLatestImage();
         } catch (IllegalStateException var3) {
            StringBuilder var2 = new StringBuilder();
            var2.append("onImageAvailable acquireLatestImage failed: ");
            var2.append(var3.toString());
            y.b.b("ImageReaderPlatformViewRenderTarget", var2.toString());
            var4 = null;
         }

         if (var4 != null) {
            b.this.a.pushImage(var4);
         }
      }
   };

   public b(TextureRegistry.ImageTextureEntry var1) {
      if (VERSION.SDK_INT >= 29) {
         this.a = var1;
      } else {
         throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
      }
   }

   private void c() {
      if (this.b != null) {
         this.a.pushImage((Image)null);
         this.b.close();
         this.b = null;
      }

   }

   public void a(int var1, int var2) {
      if (this.b == null || this.c != var1 || this.d != var2) {
         this.c();
         this.c = var1;
         this.d = var2;
         this.b = this.d();
      }
   }

   protected ImageReader d() {
      int var1 = VERSION.SDK_INT;
      if (var1 >= 33) {
         return this.f();
      } else if (var1 >= 29) {
         return this.e();
      } else {
         throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
      }
   }

   protected ImageReader e() {
      ImageReader var1 = io.flutter.embedding.android.i.a(this.c, this.d, 34, 4, 256L);
      var1.setOnImageAvailableListener(this.f, this.e);
      return var1;
   }

   protected ImageReader f() {
      Builder var1 = new Builder(this.c, this.d);
      var1.setMaxImages(4);
      var1.setImageFormat(34);
      var1.setUsage(256L);
      ImageReader var2 = var1.build();
      var2.setOnImageAvailableListener(this.f, this.e);
      return var2;
   }

   public int getHeight() {
      return this.d;
   }

   public long getId() {
      return this.a.id();
   }

   public Surface getSurface() {
      return this.b.getSurface();
   }

   public int getWidth() {
      return this.c;
   }

   public void release() {
      this.c();
      this.a = null;
   }

   // $FF: synthetic method
   public void scheduleFrame() {
      m.a(this);
   }
}
