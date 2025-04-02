package h1;

import java.util.concurrent.CancellationException;

public interface h1 extends r0.g.b {
   h1.b b = h1.b.e;

   p A(r var1);

   void c(CancellationException var1);

   boolean d();

   h1 getParent();

   r0 i(boolean var1, boolean var2, z0.l<? super Throwable, p0.q> var3);

   CancellationException k();

   boolean start();

   public static final class a {
      // $FF: synthetic method
      public static void a(h1 var0, CancellationException var1, int var2, Object var3) {
         if (var3 == null) {
            if ((var2 & 1) != 0) {
               var1 = null;
            }

            var0.c(var1);
         } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
         }
      }

      public static <R> R b(h1 var0, R var1, z0.p<? super R, ? super r0.g.b, ? extends R> var2) {
         return r0.g.b.a.a(var0, var1, var2);
      }

      public static <E extends r0.g.b> E c(h1 var0, r0.g.c<E> var1) {
         return r0.g.b.a.b(var0, var1);
      }

      // $FF: synthetic method
      public static r0 d(h1 var0, boolean var1, boolean var2, z0.l var3, int var4, Object var5) {
         if (var5 == null) {
            if ((var4 & 1) != 0) {
               var1 = false;
            }

            if ((var4 & 2) != 0) {
               var2 = true;
            }

            return var0.i(var1, var2, var3);
         } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
         }
      }

      public static r0.g e(h1 var0, r0.g.c<?> var1) {
         return r0.g.b.a.c(var0, var1);
      }

      public static r0.g f(h1 var0, r0.g var1) {
         return r0.g.b.a.d(var0, var1);
      }
   }

   public static final class b implements r0.g.c<h1> {
      // $FF: synthetic field
      static final h1.b e = new h1.b();

      private b() {
      }
   }
}
