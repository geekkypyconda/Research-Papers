package io.flutter.plugin.platform;

import android.content.Context;
import android.view.MotionEvent;

public class c extends io.flutter.embedding.android.l {
   private a g;

   public c(Context var1, int var2, int var3, a var4) {
      super(var1, var2, var3, io.flutter.embedding.android.l.b.f);
      this.g = var4;
   }

   public boolean onHoverEvent(MotionEvent var1) {
      a var2 = this.g;
      return var2 != null && var2.a(var1, true) ? true : super.onHoverEvent(var1);
   }
}
