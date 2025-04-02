package m1;

public final class g0 {
   private static final StackTraceElement a = (new a.a()).a();
   private static final String b;
   private static final String c;

   static {
      p0.k.a var0;
      Object var8;
      label85:
      try {
         var0 = p0.k.e;
         var8 = p0.k.a(Class.forName("t0.a").getCanonicalName());
      } catch (Throwable var7) {
         var0 = p0.k.e;
         var8 = p0.k.a(p0.l.a(var7));
         break label85;
      }

      if (p0.k.b(var8) != null) {
         var8 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
      }

      b = (String)var8;

      label79:
      try {
         var8 = p0.k.a(g0.class.getCanonicalName());
      } catch (Throwable var6) {
         var0 = p0.k.e;
         var8 = p0.k.a(p0.l.a(var6));
         break label79;
      }

      if (p0.k.b(var8) != null) {
         var8 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
      }

      c = (String)var8;
   }

   public static final <E extends Throwable> E a(E var0) {
      return var0;
   }
}
