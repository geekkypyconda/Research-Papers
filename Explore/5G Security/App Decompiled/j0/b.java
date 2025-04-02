package j0;

import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {
   public final k0.i a;
   private final k0.i.c b;

   public b(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            var2.b((Object)null);
         }
      };
      this.b = var2;
      k0.i var3 = new k0.i(var1, "flutter/backgesture", k0.p.b);
      this.a = var3;
      var3.e(var2);
   }

   private Map<String, Object> a(BackEvent var1) {
      HashMap var2 = new HashMap(3);
      float var3 = var1.getTouchX();
      float var4 = var1.getTouchY();
      List var5;
      if (!Float.isNaN(var3) && !Float.isNaN(var4)) {
         var5 = Arrays.asList(var3, var4);
      } else {
         var5 = null;
      }

      var2.put("touchOffset", var5);
      var2.put("progress", var1.getProgress());
      var2.put("swipeEdge", var1.getSwipeEdge());
      return var2;
   }

   public void b() {
      y.b.f("BackGestureChannel", "Sending message to cancel back gesture");
      this.a.c("cancelBackGesture", (Object)null);
   }

   public void c() {
      y.b.f("BackGestureChannel", "Sending message to commit back gesture");
      this.a.c("commitBackGesture", (Object)null);
   }

   public void d(BackEvent var1) {
      y.b.f("BackGestureChannel", "Sending message to start back gesture");
      this.a.c("startBackGesture", this.a(var1));
   }

   public void e(BackEvent var1) {
      y.b.f("BackGestureChannel", "Sending message to update back gesture progress");
      this.a.c("updateBackGestureProgress", this.a(var1));
   }
}
