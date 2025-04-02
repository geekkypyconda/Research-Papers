package h1;

public final class d0 {
   public static final void a(r0.g param0, Throwable param1) {
      // $FF: Couldn't be decompiled
   }

   public static final Throwable b(Throwable var0, Throwable var1) {
      if (var0 == var1) {
         return var0;
      } else {
         RuntimeException var2 = new RuntimeException("Exception while trying to handle coroutine exception", var1);
         p0.a.a(var2, var0);
         return var2;
      }
   }
}
