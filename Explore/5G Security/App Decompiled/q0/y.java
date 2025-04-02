package q0;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

final class y implements Map, Serializable {
   public static final y e = new y();

   private y() {
   }

   public boolean a(Void var1) {
      a1.k.e(var1, "value");
      return false;
   }

   public Void b(Object var1) {
      return null;
   }

   public Set<Entry> c() {
      return z.e;
   }

   public void clear() {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public boolean containsKey(Object var1) {
      return false;
   }

   public Set<Object> d() {
      return z.e;
   }

   public int e() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof Map && ((Map)var1).isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public Collection f() {
      return x.e;
   }

   public Void g(Object var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public int hashCode() {
      return 0;
   }

   public boolean isEmpty() {
      return true;
   }

   public void putAll(Map var1) {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }

   public String toString() {
      return "{}";
   }
}
