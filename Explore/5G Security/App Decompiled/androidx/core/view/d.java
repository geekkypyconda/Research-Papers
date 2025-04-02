package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;

public final class d {
   private final d.c a;

   public d(View var1) {
      Object var2;
      if (VERSION.SDK_INT >= 30) {
         var2 = new d.b(var1);
      } else {
         var2 = new d.a(var1);
      }

      this.a = (d.c)var2;
   }

   private static class a extends d.c {
      private final View a;

      a(View var1) {
         this.a = var1;
      }
   }

   private static class b extends d.a {
      private View b;

      b(View var1) {
         super(var1);
         this.b = var1;
      }
   }

   private static class c {
      c() {
      }
   }
}
