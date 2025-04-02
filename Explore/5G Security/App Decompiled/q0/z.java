package q0;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class z implements Set, Serializable {
   public static final z e = new z();

   private z() {
   }

   public boolean a(Void var1) {
      a1.k.e(var1, "element");
      return false;
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public int b() {
      return 0;
   }

   public void clear() {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean containsAll(Collection var1) {
      a1.k.e(var1, "elements");
      return var1.isEmpty();
   }

   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof Set && ((Set)var1).isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      return 0;
   }

   public boolean isEmpty() {
      return true;
   }

   public Iterator iterator() {
      return w.e;
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public Object[] toArray() {
      return a1.f.a(this);
   }

   public <T> T[] toArray(T[] var1) {
      a1.k.e(var1, "array");
      return a1.f.b(this, var1);
   }

   public String toString() {
      return "[]";
   }
}
