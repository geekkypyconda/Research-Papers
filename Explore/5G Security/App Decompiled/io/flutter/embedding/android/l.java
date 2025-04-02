package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.media.Image.Plane;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;

public class l extends View implements io.flutter.embedding.engine.renderer.e {
   private ImageReader a;
   private Image b;
   private Bitmap c;
   private FlutterRenderer d;
   private l.b e;
   private boolean f;

   public l(Context var1, int var2, int var3, l.b var4) {
      this(var1, h(var2, var3), var4);
   }

   l(Context var1, ImageReader var2, l.b var3) {
      super(var1, (AttributeSet)null);
      this.f = false;
      this.a = var2;
      this.e = var3;
      this.i();
   }

   private void f() {
      Image var1 = this.b;
      if (var1 != null) {
         var1.close();
         this.b = null;
      }

   }

   private static ImageReader h(int var0, int var1) {
      if (var0 <= 0) {
         j("ImageReader width must be greater than 0, but given width=%d, set width=1", var0);
         var0 = 1;
      }

      if (var1 <= 0) {
         j("ImageReader height must be greater than 0, but given height=%d, set height=1", var1);
         var1 = 1;
      }

      return VERSION.SDK_INT >= 29 ? i.a(var0, var1, 1, 3, 768L) : ImageReader.newInstance(var0, var1, 1, 3);
   }

   private void i() {
      this.setAlpha(0.0F);
   }

   private static void j(String var0, Object... var1) {
      y.b.g("FlutterImageView", String.format(Locale.US, var0, var1));
   }

   private void l() {
      if (VERSION.SDK_INT >= 29) {
         HardwareBuffer var1 = j.a(this.b);
         this.c = k.a(var1, ColorSpace.get(ColorSpace$Named.SRGB));
         var1.close();
      } else {
         Plane[] var5 = this.b.getPlanes();
         if (var5.length != 1) {
            return;
         }

         Plane var6 = var5[0];
         int var2 = var6.getRowStride() / var6.getPixelStride();
         int var3 = this.b.getHeight();
         Bitmap var4 = this.c;
         if (var4 == null || var4.getWidth() != var2 || this.c.getHeight() != var3) {
            this.c = Bitmap.createBitmap(var2, var3, Config.ARGB_8888);
         }

         ByteBuffer var7 = var6.getBuffer();
         var7.rewind();
         this.c.copyPixelsFromBuffer(var7);
      }

   }

   public void a(FlutterRenderer var1) {
      if (null.a[this.e.ordinal()] == 1) {
         var1.C(this.a.getSurface());
      }

      this.setAlpha(1.0F);
      this.d = var1;
      this.f = true;
   }

   public void b() {
   }

   public void c() {
      if (this.f) {
         this.setAlpha(0.0F);
         this.e();
         this.c = null;
         this.f();
         this.invalidate();
         this.f = false;
      }
   }

   public void d() {
   }

   public boolean e() {
      boolean var1 = this.f;
      boolean var2 = false;
      if (!var1) {
         return false;
      } else {
         Image var3 = this.a.acquireLatestImage();
         if (var3 != null) {
            this.f();
            this.b = var3;
            this.invalidate();
         }

         if (var3 != null) {
            var2 = true;
         }

         return var2;
      }
   }

   public void g() {
      this.a.close();
   }

   public FlutterRenderer getAttachedRenderer() {
      return this.d;
   }

   public ImageReader getImageReader() {
      return this.a;
   }

   public Surface getSurface() {
      return this.a.getSurface();
   }

   public void k(int var1, int var2) {
      if (this.d != null) {
         if (var1 != this.a.getWidth() || var2 != this.a.getHeight()) {
            this.f();
            this.g();
            this.a = h(var1, var2);
         }
      }
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.b != null) {
         this.l();
      }

      Bitmap var2 = this.c;
      if (var2 != null) {
         var1.drawBitmap(var2, 0.0F, 0.0F, (Paint)null);
      }

   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      if (var1 != this.a.getWidth() || var2 != this.a.getHeight()) {
         if (this.e == l.b.e && this.f) {
            this.k(var1, var2);
            this.d.C(this.a.getSurface());
         }

      }
   }

   public static enum b {
      e,
      f;

      // $FF: synthetic method
      private static l.b[] a() {
         return new l.b[]{e, f};
      }
   }
}
