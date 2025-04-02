package j1;

import h1.y0;
import java.util.concurrent.CancellationException;

// $FF: synthetic class
final class l {
   public static final void a(t<?> var0, Throwable var1) {
      CancellationException var2 = null;
      CancellationException var3 = null;
      if (var1 != null) {
         if (var1 instanceof CancellationException) {
            var3 = (CancellationException)var1;
         }

         var2 = var3;
         if (var3 == null) {
            var2 = y0.a("Channel was consumed, consumer had failed", var1);
         }
      }

      var0.c(var2);
   }
}
