package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;

final class f implements TextureRegistry.SurfaceProducer, TextureRegistry.GLTextureConsumer {
   private final long a;
   private int b;
   private int c;
   private boolean d;
   private Surface e;
   private final TextureRegistry.SurfaceTextureEntry f;
   private final Handler g;
   private final FlutterJNI h;

   f(long var1, Handler var3, FlutterJNI var4, TextureRegistry.SurfaceTextureEntry var5) {
      this.a = var1;
      this.g = var3;
      this.h = var4;
      this.f = var5;
   }

   protected void finalize() {
      // $FF: Couldn't be decompiled
   }

   public int getHeight() {
      return this.c;
   }

   public Surface getSurface() {
      if (this.e == null) {
         this.e = new Surface(this.f.surfaceTexture());
      }

      return this.e;
   }

   public SurfaceTexture getSurfaceTexture() {
      return this.f.surfaceTexture();
   }

   public int getWidth() {
      return this.b;
   }

   public long id() {
      return this.a;
   }

   public void release() {
      this.f.release();
      this.d = true;
   }

   public void scheduleFrame() {
      this.h.markTextureFrameAvailable(this.a);
   }

   public void setCallback(TextureRegistry.SurfaceProducer.a var1) {
   }

   public void setSize(int var1, int var2) {
      this.b = var1;
      this.c = var2;
      this.getSurfaceTexture().setDefaultBufferSize(var1, var2);
   }
}
