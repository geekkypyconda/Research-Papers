package t0;

public final class c implements r0.d<Object> {
   public static final c e = new c();

   private c() {
   }

   public r0.g a() {
      throw new IllegalStateException("This continuation is already complete".toString());
   }

   public String toString() {
      return "This continuation is already complete";
   }

   public void u(Object var1) {
      throw new IllegalStateException("This continuation is already complete".toString());
   }
}
