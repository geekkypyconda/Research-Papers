package a1;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T> implements Iterator<T> {
   private final T[] e;
   private int f;

   public a(T[] var1) {
      k.e(var1, "array");
      super();
      this.e = var1;
   }

   public boolean hasNext() {
      boolean var1;
      if (this.f < this.e.length) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public T next() {
      Object[] var1;
      int var2;
      try {
         var1 = this.e;
         var2 = this.f++;
      } catch (ArrayIndexOutOfBoundsException var3) {
         --this.f;
         throw new NoSuchElementException(var3.getMessage());
      }

      Object var4 = var1[var2];
      return var4;
   }

   public void remove() {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }
}
