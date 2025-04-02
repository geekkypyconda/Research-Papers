package io.flutter.plugin.platform;

import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.ViewGroup.LayoutParams;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

abstract class c0 implements WindowManager {
   final WindowManager a;
   x b;

   c0(WindowManager var1, x var2) {
      this.a = var1;
      this.b = var2;
   }

   public void addCrossWindowBlurEnabledListener(Executor var1, Consumer<Boolean> var2) {
      b0.a(this.a, var1, var2);
   }

   public void addCrossWindowBlurEnabledListener(Consumer<Boolean> var1) {
      y.a(this.a, var1);
   }

   public void addView(View var1, LayoutParams var2) {
      x var3 = this.b;
      if (var3 == null) {
         y.b.g("PlatformViewsController", "Embedded view called addView while detached from presentation");
      } else {
         var3.addView(var1, var2);
      }
   }

   public WindowMetrics getCurrentWindowMetrics() {
      return v.e.a(this.a);
   }

   @Deprecated
   public Display getDefaultDisplay() {
      return this.a.getDefaultDisplay();
   }

   public WindowMetrics getMaximumWindowMetrics() {
      return v.f.a(this.a);
   }

   public boolean isCrossWindowBlurEnabled() {
      return z.a(this.a);
   }

   public void removeCrossWindowBlurEnabledListener(Consumer<Boolean> var1) {
      a0.a(this.a, var1);
   }

   public void removeView(View var1) {
      x var2 = this.b;
      if (var2 == null) {
         y.b.g("PlatformViewsController", "Embedded view called removeView while detached from presentation");
      } else {
         var2.removeView(var1);
      }
   }

   public void removeViewImmediate(View var1) {
      if (this.b == null) {
         y.b.g("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
      } else {
         var1.clearAnimation();
         this.b.removeView(var1);
      }
   }

   public void updateViewLayout(View var1, LayoutParams var2) {
      x var3 = this.b;
      if (var3 == null) {
         y.b.g("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
      } else {
         var3.updateViewLayout(var1, var2);
      }
   }
}
