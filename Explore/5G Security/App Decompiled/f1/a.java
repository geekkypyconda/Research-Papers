package f1;

import a1.k;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> implements b<T> {
   private final AtomicReference<b<T>> a;

   public a(b<? extends T> var1) {
      k.e(var1, "sequence");
      super();
      this.a = new AtomicReference(var1);
   }

   public Iterator<T> iterator() {
      b var1 = (b)this.a.getAndSet((Object)null);
      if (var1 != null) {
         return var1.iterator();
      } else {
         throw new IllegalStateException("This sequence can be consumed only once.");
      }
   }
}
