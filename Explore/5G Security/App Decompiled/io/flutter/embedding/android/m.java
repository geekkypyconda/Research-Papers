package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

public class m extends SurfaceView implements io.flutter.embedding.engine.renderer.e {
   private final boolean a;
   private boolean b;
   private boolean c;
   private FlutterRenderer d;
   private final Callback e;
   private final io.flutter.embedding.engine.renderer.d f;

   private m(Context var1, AttributeSet var2, boolean var3) {
      super(var1, var2);
      this.b = false;
      this.c = false;
      this.e = new Callback() {
         public void surfaceChanged(SurfaceHolder var1, int var2, int var3, int var4) {
            y.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (m.this.p()) {
               m.this.k(var3, var4);
            }

         }

         public void surfaceCreated(SurfaceHolder var1) {
            y.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            m.this.b = true;
            if (m.this.p()) {
               m.this.l();
            }

         }

         public void surfaceDestroyed(SurfaceHolder var1) {
            y.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            m.this.b = false;
            if (m.this.p()) {
               m.this.m();
            }

         }
      };
      this.f = new io.flutter.embedding.engine.renderer.d() {
         public void d() {
         }

         public void g() {
            y.b.f("FlutterSurfaceView", "onFlutterUiDisplayed()");
            m.this.setAlpha(1.0F);
            if (m.this.d != null) {
               m.this.d.u(this);
            }

         }
      };
      this.a = var3;
      this.n();
   }

   public m(Context var1, boolean var2) {
      this(var1, (AttributeSet)null, var2);
   }

   private void k(int var1, int var2) {
      if (this.d != null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("Notifying FlutterRenderer that Android surface size has changed to ");
         var3.append(var1);
         var3.append(" x ");
         var3.append(var2);
         y.b.f("FlutterSurfaceView", var3.toString());
         this.d.B(var1, var2);
      } else {
         throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
      }
   }

   private void l() {
      if (this.d != null && this.getHolder() != null) {
         this.d.z(this.getHolder().getSurface(), this.c);
      } else {
         throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      }
   }

   private void m() {
      FlutterRenderer var1 = this.d;
      if (var1 != null) {
         var1.A();
      } else {
         throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      }
   }

   private void n() {
      if (this.a) {
         this.getHolder().setFormat(-2);
         this.setZOrderOnTop(true);
      }

      this.getHolder().addCallback(this.e);
      this.setAlpha(0.0F);
   }

   private boolean p() {
      boolean var1;
      if (this.d != null && !this.c) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void a(FlutterRenderer var1) {
      y.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
      if (this.d != null) {
         y.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
         this.d.A();
         this.d.u(this.f);
      }

      this.d = var1;
      this.d();
   }

   public void b() {
      if (this.d == null) {
         y.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
      } else {
         this.c = true;
      }
   }

   public void c() {
      if (this.d != null) {
         if (this.getWindowToken() != null) {
            y.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            this.m();
         }

         this.setAlpha(0.0F);
         this.d.u(this.f);
         this.d = null;
      } else {
         y.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
      }

   }

   public void d() {
      FlutterRenderer var1 = this.d;
      if (var1 == null) {
         y.b.g("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
      } else {
         var1.j(this.f);
         if (this.o()) {
            y.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            this.l();
         }

         this.c = false;
      }
   }

   public boolean gatherTransparentRegion(Region var1) {
      if (this.getAlpha() < 1.0F) {
         return false;
      } else {
         int[] var2 = new int[2];
         this.getLocationInWindow(var2);
         int var3 = var2[0];
         var1.op(var3, var2[1], this.getRight() + var3 - this.getLeft(), var2[1] + this.getBottom() - this.getTop(), Op.DIFFERENCE);
         return true;
      }
   }

   public FlutterRenderer getAttachedRenderer() {
      return this.d;
   }

   boolean o() {
      return this.b;
   }
}
