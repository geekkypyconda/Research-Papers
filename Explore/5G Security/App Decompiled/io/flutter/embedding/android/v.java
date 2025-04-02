package io.flutter.embedding.android;

import android.view.KeyEvent;

public class v implements b0.d {
   private final j0.e a;
   private final b0.b b = new b0.b();

   public v(j0.e var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   public static void b(b0.d.a var0, boolean var1) {
      c(var0, var1);
   }

   // $FF: synthetic method
   private static void c(b0.d.a var0, boolean var1) {
      var0.a(var1);
   }

   public void a(KeyEvent var1, b0.d.a var2) {
      int var3 = var1.getAction();
      boolean var4 = false;
      if (var3 != 0 && var3 != 1) {
         var2.a(false);
      } else {
         j0.e.b var5 = new j0.e.b(var1, this.b.a(var1.getUnicodeChar()));
         if (var3 != 0) {
            var4 = true;
         }

         this.a.e(var5, var4, new u(var2));
      }
   }
}
