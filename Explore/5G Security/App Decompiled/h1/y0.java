package h1;

import java.util.concurrent.CancellationException;

public final class y0 {
   public static final CancellationException a(String var0, Throwable var1) {
      CancellationException var2 = new CancellationException(var0);
      var2.initCause(var1);
      return var2;
   }
}
