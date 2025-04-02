package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.WindowManager.LayoutParams;

class x extends ViewGroup {
   private final Rect a = new Rect();
   private final Rect b = new Rect();

   public x(Context var1) {
      super(var1);
   }

   private static int a(int var0) {
      return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(var0), Integer.MIN_VALUE);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      for(int var6 = 0; var6 < this.getChildCount(); ++var6) {
         View var7 = this.getChildAt(var6);
         LayoutParams var8 = (LayoutParams)var7.getLayoutParams();
         this.a.set(var2, var3, var4, var5);
         Gravity.apply(var8.gravity, var7.getMeasuredWidth(), var7.getMeasuredHeight(), this.a, var8.x, var8.y, this.b);
         Rect var9 = this.b;
         var7.layout(var9.left, var9.top, var9.right, var9.bottom);
      }

   }

   protected void onMeasure(int var1, int var2) {
      for(int var3 = 0; var3 < this.getChildCount(); ++var3) {
         this.getChildAt(var3).measure(a(var1), a(var2));
      }

      super.onMeasure(var1, var2);
   }
}
