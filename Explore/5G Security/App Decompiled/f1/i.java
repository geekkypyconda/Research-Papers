package f1;

import a1.k;
import java.util.Iterator;
import z0.l;

public final class i<T, R> implements b<R> {
   private final b<T> a;
   private final l<T, R> b;

   public i(b<? extends T> var1, l<? super T, ? extends R> var2) {
      k.e(var1, "sequence");
      k.e(var2, "transformer");
      super();
      this.a = var1;
      this.b = var2;
   }

   public Iterator<R> iterator() {
      return new Iterator<R>() {
         private final Iterator<T> e;

         {
            this.e = i.this.a.iterator();
         }

         public boolean hasNext() {
            return this.e.hasNext();
         }

         public R next() {
            return i.this.b.i(this.e.next());
         }

         public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
         }
      };
   }
}
