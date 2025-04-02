package h1;

public final class z1 extends b0 {
   public static final z1 g = new z1();

   private z1() {
   }

   public void a(r0.g var1, Runnable var2) {
      d2 var3 = (d2)var1.b(d2.g);
      if (var3 != null) {
         var3.f = true;
      } else {
         throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
      }
   }

   public boolean e(r0.g var1) {
      return false;
   }

   public String toString() {
      return "Dispatchers.Unconfined";
   }
}
