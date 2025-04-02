package h1;

public final class p1 {
   private static final m1.h0 a = new m1.h0("COMPLETING_ALREADY");
   public static final m1.h0 b = new m1.h0("COMPLETING_WAITING_CHILDREN");
   private static final m1.h0 c = new m1.h0("COMPLETING_RETRY");
   private static final m1.h0 d = new m1.h0("TOO_LATE_TO_CANCEL");
   private static final m1.h0 e = new m1.h0("SEALED");
   private static final s0 f = new s0(false);
   private static final s0 g = new s0(true);

   // $FF: synthetic method
   public static final m1.h0 a() {
      return a;
   }

   // $FF: synthetic method
   public static final m1.h0 b() {
      return c;
   }

   // $FF: synthetic method
   public static final s0 c() {
      return g;
   }

   // $FF: synthetic method
   public static final s0 d() {
      return f;
   }

   // $FF: synthetic method
   public static final m1.h0 e() {
      return e;
   }

   // $FF: synthetic method
   public static final m1.h0 f() {
      return d;
   }

   public static final Object g(Object var0) {
      Object var1 = var0;
      if (var0 instanceof d1) {
         var1 = new e1((d1)var0);
      }

      return var1;
   }

   public static final Object h(Object var0) {
      e1 var1;
      if (var0 instanceof e1) {
         var1 = (e1)var0;
      } else {
         var1 = null;
      }

      Object var2 = var0;
      if (var1 != null) {
         var2 = var1.a;
         if (var2 == null) {
            var2 = var0;
         }
      }

      return var2;
   }
}
