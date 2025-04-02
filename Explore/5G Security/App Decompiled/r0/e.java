package r0;

import a1.k;

public interface e extends g.b {
   e.b d = e.b.e;

   <T> d<T> j(d<? super T> var1);

   void v(d<?> var1);

   public static final class a {
      public static <E extends g.b> E a(e var0, g.c<E> var1) {
         k.e(var1, "key");
         boolean var2 = var1 instanceof r0.b;
         Object var3 = null;
         if (var2) {
            r0.b var4 = (r0.b)var1;
            g.b var6 = (g.b)var3;
            if (var4.a(var0.getKey())) {
               g.b var5 = var4.b(var0);
               var6 = (g.b)var3;
               if (var5 instanceof g.b) {
                  var6 = var5;
               }
            }

            return var6;
         } else {
            if (e.d == var1) {
               k.c(var0, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            } else {
               var0 = null;
            }

            return var0;
         }
      }

      public static g b(e var0, g.c<?> var1) {
         k.e(var1, "key");
         if (var1 instanceof r0.b) {
            r0.b var2 = (r0.b)var1;
            Object var3 = var0;
            if (var2.a(((g.b)var0).getKey())) {
               var3 = var0;
               if (var2.b((g.b)var0) != null) {
                  var3 = h.e;
               }
            }

            return (g)var3;
         } else {
            if (e.d == var1) {
               var0 = h.e;
            }

            return (g)var0;
         }
      }
   }

   public static final class b implements g.c<e> {
      // $FF: synthetic field
      static final e.b e = new e.b();

      private b() {
      }
   }
}
