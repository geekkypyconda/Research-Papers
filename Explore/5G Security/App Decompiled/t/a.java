package t;

import a1.k;
import androidx.window.extensions.layout.WindowLayoutComponent;

public final class a implements s.a {
   public static final t.a.a a = new t.a.a((a1.g)null);

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      public final s.a a(WindowLayoutComponent var1, o.d var2) {
         k.e(var1, "component");
         k.e(var2, "adapter");
         int var3 = o.e.a.a();
         Object var4;
         if (var3 >= 2) {
            var4 = new e(var1);
         } else if (var3 == 1) {
            var4 = new d(var1, var2);
         } else {
            var4 = new c();
         }

         return (s.a)var4;
      }
   }
}
