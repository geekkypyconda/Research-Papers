package io.flutter.plugin.platform;

import android.view.Surface;
import io.flutter.view.TextureRegistry;

public class d0 implements n {
   private TextureRegistry.SurfaceProducer a;

   public d0(TextureRegistry.SurfaceProducer var1) {
      this.a = var1;
   }

   public void a(int var1, int var2) {
      this.a.setSize(var1, var2);
   }

   public int getHeight() {
      return this.a.getHeight();
   }

   public long getId() {
      return this.a.id();
   }

   public Surface getSurface() {
      return this.a.getSurface();
   }

   public int getWidth() {
      return this.a.getWidth();
   }

   public void release() {
      this.a.release();
      this.a = null;
   }

   public void scheduleFrame() {
      this.a.scheduleFrame();
   }
}
