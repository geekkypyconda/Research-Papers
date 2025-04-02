package q0;

import java.util.Collection;
import java.util.Iterator;

final class d<T> implements Collection<T> {
   private final T[] e;
   private final boolean f;

   public d(T[] var1, boolean var2) {
      a1.k.e(var1, "values");
      super();
      this.e = var1;
      this.f = var2;
   }

   public int a() {
      return this.e.length;
   }

   public boolean add(T var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean addAll(Collection<? extends T> var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public void clear() {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean contains(Object var1) {
      return j.f(this.e, var1);
   }

   public boolean containsAll(Collection<? extends Object> var1) {
      a1.k.e(var1, "elements");
      boolean var2 = var1.isEmpty();
      boolean var3 = true;
      if (var2) {
         var2 = var3;
      } else {
         Iterator var4 = var1.iterator();

         while(true) {
            var2 = var3;
            if (!var4.hasNext()) {
               break;
            }

            if (!this.contains(var4.next())) {
               var2 = false;
               break;
            }
         }
      }

      return var2;
   }

   public boolean isEmpty() {
      boolean var1;
      if (this.e.length == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public Iterator<T> iterator() {
      return a1.b.a(this.e);
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean removeAll(Collection<? extends Object> var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean retainAll(Collection<? extends Object> var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public final Object[] toArray() {
      return m.a(this.e, this.f);
   }

   public <T> T[] toArray(T[] var1) {
      a1.k.e(var1, "array");
      return a1.f.b(this, var1);
   }
}
