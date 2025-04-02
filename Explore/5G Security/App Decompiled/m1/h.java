package m1;

import java.util.Iterator;

public final class h {
   public static final void a(r0.g var0, Throwable var1) {
      Iterator var2 = g.a().iterator();

      while(var2.hasNext()) {
         h1.c0 var3 = (h1.c0)var2.next();

         try {
            var3.f(var0, var1);
         } catch (Throwable var9) {
            g.b(h1.d0.b(var1, var9));
            continue;
         }
      }

      label65:
      try {
         i var10 = new i(var0);
         p0.a.a(var1, var10);
      } finally {
         break label65;
      }

      g.b(var1);
   }
}
