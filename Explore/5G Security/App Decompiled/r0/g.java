package r0;

import a1.k;
import z0.p;

public interface g {
   <E extends g.b> E b(g.c<E> var1);

   g n(g var1);

   g x(g.c<?> var1);

   <R> R y(R var1, p<? super R, ? super g.b, ? extends R> var2);

   public static final class a {
      public static g a(g var0, g var1) {
         k.e(var1, "context");
         if (var1 != h.e) {
            var0 = (g)var1.y(var0, null.f);
         }

         return var0;
      }
   }

   public interface b extends g {
      <E extends g.b> E b(g.c<E> var1);

      g.c<?> getKey();

      public static final class a {
         public static <R> R a(g.b var0, R var1, p<? super R, ? super g.b, ? extends R> var2) {
            k.e(var2, "operation");
            return var2.h(var1, var0);
         }

         public static <E extends g.b> E b(g.b var0, g.c<E> var1) {
            k.e(var1, "key");
            if (k.a(var0.getKey(), var1)) {
               k.c(var0, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
            } else {
               var0 = null;
            }

            return var0;
         }

         public static g c(g.b var0, g.c<?> var1) {
            k.e(var1, "key");
            Object var2 = var0;
            if (k.a(var0.getKey(), var1)) {
               var2 = h.e;
            }

            return (g)var2;
         }

         public static g d(g.b var0, g var1) {
            k.e(var1, "context");
            return g.a.a(var0, var1);
         }
      }
   }

   public interface c<E extends g.b> {
   }
}
