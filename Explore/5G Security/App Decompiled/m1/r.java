package m1;

public final class r {
   private static final Object a = new h0("CONDITION_FALSE");

   public static final Object a() {
      return a;
   }

   public static final s b(Object var0) {
      b0 var1;
      if (var0 instanceof b0) {
         var1 = (b0)var0;
      } else {
         var1 = null;
      }

      s var3;
      if (var1 != null) {
         s var2 = var1.a;
         var3 = var2;
         if (var2 != null) {
            return var3;
         }
      }

      a1.k.c(var0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
      var3 = (s)var0;
      return var3;
   }
}
