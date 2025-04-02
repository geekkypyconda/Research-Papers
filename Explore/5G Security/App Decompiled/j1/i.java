package j1;

import java.util.concurrent.atomic.AtomicReferenceArray;

// $FF: synthetic class
public final class i {
   // $FF: synthetic method
   public static boolean a(AtomicReferenceArray var0, int var1, Object var2, Object var3) {
      do {
         if (var0.compareAndSet(var1, var2, var3)) {
            return true;
         }
      } while(var0.get(var1) == var2);

      return false;
   }
}
