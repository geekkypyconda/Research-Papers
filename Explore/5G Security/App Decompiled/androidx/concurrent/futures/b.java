package androidx.concurrent.futures;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

// $FF: synthetic class
public final class b {
   // $FF: synthetic method
   public static boolean a(AtomicReferenceFieldUpdater var0, Object var1, Object var2, Object var3) {
      do {
         if (var0.compareAndSet(var1, var2, var3)) {
            return true;
         }
      } while(var0.get(var1) == var2);

      return false;
   }
}
