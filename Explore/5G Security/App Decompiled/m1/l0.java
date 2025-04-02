package m1;

import h1.x1;

public final class l0 {
   public static final h0 a = new h0("NO_THREAD_ELEMENTS");
   private static final z0.p<Object, r0.g.b, Object> b;
   private static final z0.p<x1<?>, r0.g.b, x1<?>> c;
   private static final z0.p<p0, r0.g.b, p0> d;

   static {
      b = null.f;
      c = null.f;
      d = null.f;
   }

   public static final void a(r0.g var0, Object var1) {
      if (var1 != a) {
         if (var1 instanceof p0) {
            ((p0)var1).b(var0);
         } else {
            Object var2 = var0.y((Object)null, c);
            a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((x1)var2).g(var0, var1);
         }

      }
   }

   public static final Object b(r0.g var0) {
      Object var1 = var0.y(0, b);
      a1.k.b(var1);
      return var1;
   }

   public static final Object c(r0.g var0, Object var1) {
      Object var2 = var1;
      if (var1 == null) {
         var2 = b(var0);
      }

      Object var3;
      if (var2 == 0) {
         var3 = a;
      } else if (var2 instanceof Integer) {
         var3 = var0.y(new p0(var0, ((Number)var2).intValue()), d);
      } else {
         a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
         var3 = ((x1)var2).B(var0);
      }

      return var3;
   }
}
