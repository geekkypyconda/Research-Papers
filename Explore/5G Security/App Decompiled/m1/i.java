package m1;

public final class i extends RuntimeException {
   private final transient r0.g e;

   public i(r0.g var1) {
      this.e = var1;
   }

   public Throwable fillInStackTrace() {
      this.setStackTrace(new StackTraceElement[0]);
      return this;
   }

   public String getLocalizedMessage() {
      return this.e.toString();
   }
}
