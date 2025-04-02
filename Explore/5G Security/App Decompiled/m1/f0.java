package m1;

public final class f0<S extends e0<S>> {
   public static <S extends e0<S>> Object a(Object var0) {
      return var0;
   }

   public static final S b(Object var0) {
      if (var0 != d.a()) {
         a1.k.c(var0, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
         return (e0)var0;
      } else {
         throw new IllegalStateException("Does not contain segment".toString());
      }
   }

   public static final boolean c(Object var0) {
      boolean var1;
      if (var0 == d.a()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
