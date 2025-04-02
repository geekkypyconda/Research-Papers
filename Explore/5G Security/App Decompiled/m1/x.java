package m1;

import h1.r1;
import java.util.List;

public final class x {
   private static final boolean a = true;

   private static final y a(Throwable var0, String var1) {
      if (a) {
         return new y(var0, var1);
      } else if (var0 != null) {
         throw var0;
      } else {
         d();
         throw new p0.d();
      }
   }

   // $FF: synthetic method
   static y b(Throwable var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var0 = null;
      }

      if ((var2 & 2) != 0) {
         var1 = null;
      }

      return a(var0, var1);
   }

   public static final boolean c(r1 var0) {
      return var0.o() instanceof y;
   }

   public static final Void d() {
      throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
   }

   public static final r1 e(v var0, List<? extends v> var1) {
      Object var4;
      r1 var5;
      try {
         var5 = var0.c(var1);
      } catch (Throwable var3) {
         var4 = a(var3, var0.b());
         return (r1)var4;
      }

      var4 = var5;
      return (r1)var4;
   }
}
