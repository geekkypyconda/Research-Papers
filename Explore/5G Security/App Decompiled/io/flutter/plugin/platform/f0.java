package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

public class f0 implements n {
   private final TextureRegistry.SurfaceTextureEntry a;
   private SurfaceTexture b;
   private Surface c;
   private int d = 0;
   private int e = 0;
   private boolean f = false;
   private final TextureRegistry.b g;

   public f0(TextureRegistry.SurfaceTextureEntry var1) {
      TextureRegistry.b var2 = new TextureRegistry.b() {
         public void onTrimMemory(int var1) {
            if (var1 == 80 && VERSION.SDK_INT >= 29) {
               f0.this.f = true;
            }

         }
      };
      this.g = var2;
      if (VERSION.SDK_INT >= 23) {
         this.a = var1;
         this.b = var1.surfaceTexture();
         var1.setOnTrimMemoryListener(var2);
      } else {
         throw new UnsupportedOperationException("Platform views cannot be displayed below API level 23You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
      }
   }

   private void d() {
      Surface var1 = this.c;
      if (var1 == null || this.f) {
         if (var1 != null) {
            var1.release();
            this.c = null;
         }

         this.c = this.c();
         this.f = false;
      }
   }

   public void a(int var1, int var2) {
      this.d = var1;
      this.e = var2;
      SurfaceTexture var3 = this.b;
      if (var3 != null) {
         var3.setDefaultBufferSize(var1, var2);
      }

   }

   protected Surface c() {
      return new Surface(this.b);
   }

   public int getHeight() {
      return this.e;
   }

   public long getId() {
      return this.a.id();
   }

   public Surface getSurface() {
      this.d();
      SurfaceTexture var1 = this.b;
      return var1 != null && !e0.a(var1) ? this.c : null;
   }

   public int getWidth() {
      return this.d;
   }

   public void release() {
      this.b = null;
      Surface var1 = this.c;
      if (var1 != null) {
         var1.release();
         this.c = null;
      }

   }

   // $FF: synthetic method
   public void scheduleFrame() {
      m.a(this);
   }
}
