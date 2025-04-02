package h1;

public final class o0 {
   public static final <T> void a(n0<? super T> var0, int var1) {
      r0.d var2 = var0.c();
      boolean var3;
      if (var1 == 4) {
         var3 = true;
      } else {
         var3 = false;
      }

      if (!var3 && var2 instanceof m1.j && b(var1) == b(var0.g)) {
         b0 var4 = ((m1.j)var2).h;
         r0.g var5 = var2.a();
         if (var4.e(var5)) {
            var4.a(var5, var0);
         } else {
            e(var0);
         }
      } else {
         d(var0, var2, var3);
      }

   }

   public static final boolean b(int var0) {
      boolean var1 = true;
      boolean var2 = var1;
      if (var0 != 1) {
         if (var0 == 2) {
            var2 = var1;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   public static final boolean c(int var0) {
      boolean var1;
      if (var0 == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static final <T> void d(n0<? super T> var0, r0.d<? super T> var1, boolean var2) {
      Object var3 = var0.h();
      Throwable var4 = var0.e(var3);
      Object var9;
      if (var4 != null) {
         p0.k.a var8 = p0.k.e;
         var9 = p0.l.a(var4);
      } else {
         p0.k.a var14 = p0.k.e;
         var9 = var0.f(var3);
      }

      var3 = p0.k.a(var9);
      if (var2) {
         a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
         m1.j var5 = (m1.j)var1;
         r0.d var11 = var5.i;
         Object var15 = var5.k;
         r0.g var10 = var11.a();
         var15 = m1.l0.c(var10, var15);
         a2 var12;
         if (var15 != m1.l0.a) {
            var12 = a0.f(var11, var10, var15);
         } else {
            var12 = null;
         }

         try {
            var5.i.u(var3);
            p0.q var13 = p0.q.a;
         } finally {
            if (var12 == null || var12.K0()) {
               m1.l0.a(var10, var15);
            }

         }
      } else {
         var1.u(var3);
      }

   }

   private static final void e(n0<?> var0) {
      t0 var1 = y1.a.a();
      if (var1.z()) {
         var1.q(var0);
      } else {
         var1.u(true);

         Throwable var10000;
         label127: {
            boolean var10001;
            try {
               d(var0, var0.c(), true);
            } catch (Throwable var15) {
               var10000 = var15;
               var10001 = false;
               break label127;
            }

            while(true) {
               boolean var2;
               try {
                  var2 = var1.D();
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break;
               }

               if (!var2) {
                  return;
               }
            }
         }

         Throwable var3 = var10000;

         try {
            var0.g(var3, (Throwable)null);
         } finally {
            var1.o(true);
         }
      }

   }
}
