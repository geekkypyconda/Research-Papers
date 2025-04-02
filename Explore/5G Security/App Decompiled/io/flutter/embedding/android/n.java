package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

public class n extends TextureView implements io.flutter.embedding.engine.renderer.e {
   private boolean a;
   private boolean b;
   private FlutterRenderer c;
   private Surface d;
   private final SurfaceTextureListener e;

   public n(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public n(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a = false;
      this.b = false;
      this.e = new SurfaceTextureListener() {
         public void onSurfaceTextureAvailable(SurfaceTexture var1, int var2, int var3) {
            y.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            n.this.a = true;
            if (n.this.q()) {
               n.this.m();
            }

         }

         public boolean onSurfaceTextureDestroyed(SurfaceTexture var1) {
            y.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            n.this.a = false;
            if (n.this.q()) {
               n.this.n();
            }

            if (n.this.d != null) {
               n.this.d.release();
               n.this.d = null;
            }

            return true;
         }

         public void onSurfaceTextureSizeChanged(SurfaceTexture var1, int var2, int var3) {
            y.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (n.this.q()) {
               n.this.l(var2, var3);
            }

         }

         public void onSurfaceTextureUpdated(SurfaceTexture var1) {
         }
      };
      this.o();
   }

   private void l(int var1, int var2) {
      if (this.c != null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("Notifying FlutterRenderer that Android surface size has changed to ");
         var3.append(var1);
         var3.append(" x ");
         var3.append(var2);
         y.b.f("FlutterTextureView", var3.toString());
         this.c.B(var1, var2);
      } else {
         throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
      }
   }

   private void m() {
      if (this.c != null && this.getSurfaceTexture() != null) {
         Surface var1 = this.d;
         if (var1 != null) {
            var1.release();
            this.d = null;
         }

         var1 = new Surface(this.getSurfaceTexture());
         this.d = var1;
         this.c.z(var1, this.b);
      } else {
         throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      }
   }

   private void n() {
      FlutterRenderer var1 = this.c;
      if (var1 != null) {
         var1.A();
         Surface var2 = this.d;
         if (var2 != null) {
            var2.release();
            this.d = null;
         }

      } else {
         throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      }
   }

   private void o() {
      this.setSurfaceTextureListener(this.e);
   }

   private boolean q() {
      boolean var1;
      if (this.c != null && !this.b) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void a(FlutterRenderer var1) {
      y.b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
      if (this.c != null) {
         y.b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
         this.c.A();
      }

      this.c = var1;
      this.d();
   }

   public void b() {
      if (this.c == null) {
         y.b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
      } else {
         this.b = true;
      }
   }

   public void c() {
      if (this.c != null) {
         if (this.getWindowToken() != null) {
            y.b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            this.n();
         }

         this.c = null;
      } else {
         y.b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
      }

   }

   public void d() {
      if (this.c == null) {
         y.b.g("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
      } else {
         if (this.p()) {
            y.b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            this.m();
         }

         this.b = false;
      }
   }

   public FlutterRenderer getAttachedRenderer() {
      return this.c;
   }

   boolean p() {
      return this.a;
   }

   public void setRenderSurface(Surface var1) {
      this.d = var1;
   }
}
