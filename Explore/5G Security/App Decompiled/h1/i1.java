package h1;

import java.util.concurrent.CancellationException;

public final class i1 extends CancellationException {
   public final transient h1 e;

   public i1(String var1, Throwable var2, h1 var3) {
      super(var1);
      this.e = var3;
      if (var2 != null) {
         this.initCause(var2);
      }

   }

   public boolean equals(Object var1) {
      boolean var2;
      label31: {
         if (var1 != this) {
            if (!(var1 instanceof i1)) {
               break label31;
            }

            i1 var3 = (i1)var1;
            if (!a1.k.a(var3.getMessage(), this.getMessage()) || !a1.k.a(var3.e, this.e) || !a1.k.a(var3.getCause(), this.getCause())) {
               break label31;
            }
         }

         var2 = true;
         return var2;
      }

      var2 = false;
      return var2;
   }

   public Throwable fillInStackTrace() {
      this.setStackTrace(new StackTraceElement[0]);
      return this;
   }

   public int hashCode() {
      String var1 = this.getMessage();
      a1.k.b(var1);
      int var2 = var1.hashCode();
      int var3 = this.e.hashCode();
      Throwable var5 = this.getCause();
      int var4;
      if (var5 != null) {
         var4 = var5.hashCode();
      } else {
         var4 = 0;
      }

      return (var2 * 31 + var3) * 31 + var4;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(super.toString());
      var1.append("; job=");
      var1.append(this.e);
      return var1.toString();
   }
}
