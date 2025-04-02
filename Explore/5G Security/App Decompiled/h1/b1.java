package h1;

import java.util.concurrent.Executor;

public final class b1 {
   public static final b0 a(Executor var0) {
      p0 var1;
      if (var0 instanceof p0) {
         var1 = (p0)var0;
      } else {
         var1 = null;
      }

      Object var3;
      if (var1 != null) {
         b0 var2 = var1.e;
         var3 = var2;
         if (var2 != null) {
            return (b0)var3;
         }
      }

      var3 = new a1(var0);
      return (b0)var3;
   }
}
