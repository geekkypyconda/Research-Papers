package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

public class p extends FrameLayout {
   private int a;
   private int b;
   private int c;
   private int d;
   private io.flutter.embedding.android.c e;
   private n f;
   private OnGlobalFocusChangeListener g;

   public p(Context var1) {
      super(var1);
      this.setWillNotDraw(false);
   }

   public p(Context var1, n var2) {
      this(var1);
      this.f = var2;
      Surface var3 = var2.getSurface();
      if (var3 != null && !FlutterRenderer.j) {
         Canvas var6 = o.a(var3);

         try {
            var6.drawColor(0, Mode.CLEAR);
         } finally {
            var3.unlockCanvasAndPost(var6);
         }
      }

   }

   public void a() {
      n var1 = this.f;
      if (var1 != null) {
         var1.release();
         this.f = null;
      }

   }

   public void b(int var1, int var2) {
      n var3 = this.f;
      if (var3 != null) {
         var3.a(var1, var2);
      }

   }

   public void c() {
      ViewTreeObserver var1 = this.getViewTreeObserver();
      if (var1.isAlive()) {
         OnGlobalFocusChangeListener var2 = this.g;
         if (var2 != null) {
            this.g = null;
            var1.removeOnGlobalFocusChangeListener(var2);
         }
      }

   }

   public void draw(Canvas var1) {
      n var2 = this.f;
      if (var2 == null) {
         super.draw(var1);
         y.b.b("PlatformViewWrapper", "Platform view cannot be composed without a RenderTarget.");
      } else {
         Surface var6 = var2.getSurface();
         Canvas var3 = o.a(var6);
         if (var3 == null) {
            this.invalidate();
         } else {
            try {
               var3.drawColor(0, Mode.CLEAR);
               super.draw(var3);
            } finally {
               this.f.scheduleFrame();
               var6.unlockCanvasAndPost(var3);
            }

         }
      }
   }

   public OnGlobalFocusChangeListener getActiveFocusListener() {
      return this.g;
   }

   public int getRenderTargetHeight() {
      n var1 = this.f;
      return var1 != null ? var1.getHeight() : 0;
   }

   public int getRenderTargetWidth() {
      n var1 = this.f;
      return var1 != null ? var1.getWidth() : 0;
   }

   public ViewParent invalidateChildInParent(int[] var1, Rect var2) {
      this.invalidate();
      return super.invalidateChildInParent(var1, var2);
   }

   public void onDescendantInvalidated(View var1, View var2) {
      super.onDescendantInvalidated(var1, var2);
      this.invalidate();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      return true;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if (this.e == null) {
         return super.onTouchEvent(var1);
      } else {
         Matrix var2 = new Matrix();
         int var3 = var1.getAction();
         float var4;
         if (var3 != 0) {
            if (var3 == 2) {
               var2.postTranslate((float)this.a, (float)this.b);
               this.a = this.c;
               this.b = this.d;
               return this.e.l(var1, var2);
            }

            var4 = (float)this.c;
            var3 = this.d;
         } else {
            int var5 = this.c;
            this.a = var5;
            var3 = this.d;
            this.b = var3;
            var4 = (float)var5;
         }

         var2.postTranslate(var4, (float)var3);
         return this.e.l(var1, var2);
      }
   }

   public boolean requestSendAccessibilityEvent(View var1, AccessibilityEvent var2) {
      View var3 = this.getChildAt(0);
      return var3 != null && var3.getImportantForAccessibility() == 4 ? false : super.requestSendAccessibilityEvent(var1, var2);
   }

   public void setLayoutParams(LayoutParams var1) {
      super.setLayoutParams(var1);
      this.c = var1.leftMargin;
      this.d = var1.topMargin;
   }

   public void setOnDescendantFocusChangeListener(final OnFocusChangeListener var1) {
      this.c();
      ViewTreeObserver var2 = this.getViewTreeObserver();
      if (var2.isAlive() && this.g == null) {
         OnGlobalFocusChangeListener var3 = new OnGlobalFocusChangeListener() {
            public void onGlobalFocusChanged(View var1x, View var2) {
               OnFocusChangeListener var3 = var1;
               p var4 = p.this;
               var3.onFocusChange(var4, o0.i.d(var4));
            }
         };
         this.g = var3;
         var2.addOnGlobalFocusChangeListener(var3);
      }

   }

   public void setTouchProcessor(io.flutter.embedding.android.c var1) {
      this.e = var1;
   }
}
