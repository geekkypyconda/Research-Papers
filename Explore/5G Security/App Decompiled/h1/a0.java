package h1;

public final class a0 {
   private static final r0.g a(r0.g var0, r0.g var1, final boolean var2) {
      boolean var3 = c(var0);
      boolean var4 = c(var1);
      if (!var3 && !var4) {
         return var0.n(var1);
      } else {
         final a1.q var5 = new a1.q();
         var5.e = var1;
         r0.h var6 = r0.h.e;
         var0 = (r0.g)var0.y(var6, new z0.p<r0.g, r0.g.b, r0.g>() {
            public final r0.g a(r0.g var1, r0.g.b var2x) {
               if (!(var2x instanceof z)) {
                  return var1.n(var2x);
               } else {
                  r0.g.b var3 = ((r0.g)var5.e).b(var2x.getKey());
                  if (var3 == null) {
                     boolean var4 = var2;
                     z var6 = (z)var2x;
                     z var7 = var6;
                     if (var4) {
                        var7 = var6.t();
                     }

                     return var1.n(var7);
                  } else {
                     a1.q var5x = var5;
                     var5x.e = ((r0.g)var5x.e).x(var2x.getKey());
                     return var1.n(((z)var2x).s(var3));
                  }
               }
            }
         });
         if (var4) {
            var5.e = ((r0.g)var5.e).y(var6, null.f);
         }

         return var0.n((r0.g)var5.e);
      }
   }

   public static final String b(r0.g var0) {
      return null;
   }

   private static final boolean c(r0.g var0) {
      return (Boolean)var0.y(Boolean.FALSE, null.f);
   }

   public static final r0.g d(e0 var0, r0.g var1) {
      var1 = a(var0.r(), var1, true);
      r0.g var2 = var1;
      if (var1 != q0.a()) {
         var2 = var1;
         if (var1.b(r0.e.d) == null) {
            var2 = var1.n(q0.a());
         }
      }

      return var2;
   }

   public static final a2<?> e(t0.e var0) {
      t0.e var1;
      do {
         if (var0 instanceof m0) {
            return null;
         }

         var1 = var0.o();
         if (var1 == null) {
            return null;
         }

         var0 = var1;
      } while(!(var1 instanceof a2));

      return (a2)var1;
   }

   public static final a2<?> f(r0.d<?> var0, r0.g var1, Object var2) {
      if (!(var0 instanceof t0.e)) {
         return null;
      } else {
         boolean var3;
         if (var1.b(b2.e) != null) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (!var3) {
            return null;
         } else {
            a2 var4 = e((t0.e)var0);
            if (var4 != null) {
               var4.L0(var1, var2);
            }

            return var4;
         }
      }
   }
}
