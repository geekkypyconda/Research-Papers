package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class a {
   private io.flutter.view.h a;

   public boolean a(MotionEvent var1, boolean var2) {
      io.flutter.view.h var3 = this.a;
      return var3 == null ? false : var3.M(var1, var2);
   }

   public boolean b(View var1, View var2, AccessibilityEvent var3) {
      io.flutter.view.h var4 = this.a;
      return var4 == null ? false : var4.w(var1, var2, var3);
   }

   void c(io.flutter.view.h var1) {
      this.a = var1;
   }
}
