package a;

public final class b {
   private static final String a = "_COROUTINE";

   // $FF: synthetic method
   public static final StackTraceElement a(Throwable var0, String var1) {
      return b(var0, var1);
   }

   private static final StackTraceElement b(Throwable var0, String var1) {
      StackTraceElement var3 = var0.getStackTrace()[0];
      StringBuilder var2 = new StringBuilder();
      var2.append(a);
      var2.append('.');
      var2.append(var1);
      return new StackTraceElement(var2.toString(), "_", var3.getFileName(), var3.getLineNumber());
   }
}
