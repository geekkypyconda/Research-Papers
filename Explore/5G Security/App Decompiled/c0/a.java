package c0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import io.flutter.embedding.android.c;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;
import o0.i;

public class a extends FrameLayout {
   private FlutterMutatorsStack a;
   private float b;
   private int c;
   private int d;
   private int e;
   private int f;
   private final c g;
   OnGlobalFocusChangeListener h;

   public a(Context var1, float var2, c var3) {
      super(var1, (AttributeSet)null);
      this.b = var2;
      this.g = var3;
   }

   private Matrix getPlatformViewMatrix() {
      Matrix var1 = new Matrix(this.a.getFinalMatrix());
      float var2 = this.b;
      var1.preScale(1.0F / var2, 1.0F / var2);
      var1.postTranslate((float)(-this.c), (float)(-this.d));
      return var1;
   }

   public void a(FlutterMutatorsStack var1, int var2, int var3, int var4, int var5) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
      LayoutParams var6 = new LayoutParams(var4, var5);
      var6.leftMargin = var2;
      var6.topMargin = var3;
      this.setLayoutParams(var6);
      this.setWillNotDraw(false);
   }

   public void b() {
      ViewTreeObserver var1 = this.getViewTreeObserver();
      if (var1.isAlive()) {
         OnGlobalFocusChangeListener var2 = this.h;
         if (var2 != null) {
            this.h = null;
            var1.removeOnGlobalFocusChangeListener(var2);
         }
      }

   }

   public void dispatchDraw(Canvas var1) {
      var1.save();
      var1.concat(this.getPlatformViewMatrix());
      super.dispatchDraw(var1);
      var1.restore();
   }

   public void draw(Canvas var1) {
      var1.save();
      Iterator var2 = this.a.getFinalClippingPaths().iterator();

      while(var2.hasNext()) {
         Path var3 = new Path((Path)var2.next());
         var3.offset((float)(-this.c), (float)(-this.d));
         var1.clipPath(var3);
      }

      super.draw(var1);
      var1.restore();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      return true;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if (this.g == null) {
         return super.onTouchEvent(var1);
      } else {
         Matrix var2 = new Matrix();
         int var3 = var1.getAction();
         float var4;
         if (var3 != 0) {
            if (var3 == 2) {
               var2.postTranslate((float)this.e, (float)this.f);
               this.e = this.c;
               this.f = this.d;
               return this.g.l(var1, var2);
            }

            var4 = (float)this.c;
            var3 = this.d;
         } else {
            int var5 = this.c;
            this.e = var5;
            var3 = this.d;
            this.f = var3;
            var4 = (float)var5;
         }

         var2.postTranslate(var4, (float)var3);
         return this.g.l(var1, var2);
      }
   }

   public boolean requestSendAccessibilityEvent(View var1, AccessibilityEvent var2) {
      View var3 = this.getChildAt(0);
      return var3 != null && var3.getImportantForAccessibility() == 4 ? false : super.requestSendAccessibilityEvent(var1, var2);
   }

   public void setOnDescendantFocusChangeListener(final OnFocusChangeListener var1) {
      this.b();
      ViewTreeObserver var2 = this.getViewTreeObserver();
      if (var2.isAlive() && this.h == null) {
         OnGlobalFocusChangeListener var3 = new OnGlobalFocusChangeListener() {
            public void onGlobalFocusChanged(View var1x, View var2) {
               OnFocusChangeListener var3 = var1;
               var1x = a.this;
               var3.onFocusChange(var1x, i.d(var1x));
            }
         };
         this.h = var3;
         var2.addOnGlobalFocusChangeListener(var3);
      }

   }
}
