package k1;

import h1.h1;

// $FF: synthetic class
final class h {
   private static final void a(r0.g var0) {
      boolean var1;
      if (var0.b(h1.b) == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (!var1) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Flow context cannot contain job in it. Had ");
         var2.append(var0);
         throw new IllegalArgumentException(var2.toString().toString());
      }
   }

   public static final <T> c<T> b(c<? extends T> var0, r0.g var1) {
      a(var1);
      if (!a1.k.a(var1, r0.h.e)) {
         if (var0 instanceof l1.i) {
            var0 = l1.i.a.a((l1.i)var0, var1, 0, (j1.a)null, 6, (Object)null);
         } else {
            var0 = new l1.g((c)var0, var1, 0, (j1.a)null, 12, (a1.g)null);
         }
      }

      return (c)var0;
   }
}
