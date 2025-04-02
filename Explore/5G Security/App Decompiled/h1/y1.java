package h1;

public final class y1 {
   public static final y1 a = new y1();
   private static final ThreadLocal<t0> b = m1.m0.a(new m1.h0("ThreadLocalEventLoop"));

   private y1() {
   }

   public final t0 a() {
      ThreadLocal var1 = b;
      t0 var2 = (t0)var1.get();
      t0 var3 = var2;
      if (var2 == null) {
         var3 = w0.a();
         var1.set(var3);
      }

      return var3;
   }

   public final void b() {
      b.set((Object)null);
   }

   public final void c(t0 var1) {
      b.set(var1);
   }
}
