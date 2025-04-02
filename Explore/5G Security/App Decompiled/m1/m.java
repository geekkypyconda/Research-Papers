package m1;

public final class m {
   private static final boolean a;

   static {
      p0.k.a var0;
      Object var4;
      label20:
      try {
         var0 = p0.k.e;
         var4 = p0.k.a(Class.forName("android.os.Build"));
      } catch (Throwable var3) {
         var0 = p0.k.e;
         var4 = p0.k.a(p0.l.a(var3));
         break label20;
      }

      a = p0.k.d(var4);
   }

   public static final boolean a() {
      return a;
   }
}
