package e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;

abstract class c<K, V> {
   e.c<K, V>.b a;
   e.c<K, V>.c b;
   e.c<K, V>.e c;

   public static <K, V> boolean j(Map<K, V> var0, Collection<?> var1) {
      Iterator var2 = var1.iterator();

      do {
         if (!var2.hasNext()) {
            return true;
         }
      } while(var0.containsKey(var2.next()));

      return false;
   }

   public static <T> boolean k(Set<T> var0, Object var1) {
      boolean var2 = true;
      if (var0 == var1) {
         return true;
      } else if (var1 instanceof Set) {
         Set var5 = (Set)var1;

         label27: {
            boolean var3;
            try {
               if (var0.size() != var5.size()) {
                  break label27;
               }

               var3 = var0.containsAll(var5);
            } catch (ClassCastException | NullPointerException var4) {
               return false;
            }

            if (var3) {
               return var2;
            }
         }

         var2 = false;
         return var2;
      } else {
         return false;
      }
   }

   public static <K, V> boolean o(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         var0.remove(var4.next());
      }

      boolean var3;
      if (var2 != var0.size()) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public static <K, V> boolean p(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         if (!var1.contains(var3.next())) {
            var3.remove();
         }
      }

      boolean var4;
      if (var2 != var0.size()) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   protected abstract void a();

   protected abstract Object b(int var1, int var2);

   protected abstract Map<K, V> c();

   protected abstract int d();

   protected abstract int e(Object var1);

   protected abstract int f(Object var1);

   protected abstract void g(K var1, V var2);

   protected abstract void h(int var1);

   protected abstract V i(int var1, V var2);

   public Set<Entry<K, V>> l() {
      if (this.a == null) {
         this.a = new e.c.b();
      }

      return this.a;
   }

   public Set<K> m() {
      if (this.b == null) {
         this.b = new e.c.c();
      }

      return this.b;
   }

   public Collection<V> n() {
      if (this.c == null) {
         this.c = new e.c.e();
      }

      return this.c;
   }

   public Object[] q(int var1) {
      int var2 = this.d();
      Object[] var3 = new Object[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = this.b(var4, var1);
      }

      return var3;
   }

   public <T> T[] r(T[] var1, int var2) {
      int var3 = this.d();
      Object[] var4 = var1;
      if (var1.length < var3) {
         var4 = (Object[])Array.newInstance(var1.getClass().getComponentType(), var3);
      }

      for(int var5 = 0; var5 < var3; ++var5) {
         var4[var5] = this.b(var5, var2);
      }

      if (var4.length > var3) {
         var4[var3] = null;
      }

      return var4;
   }

   final class a<T> implements Iterator<T> {
      final int e;
      int f;
      int g;
      boolean h = false;

      a(int var2) {
         this.e = var2;
         this.f = c.this.d();
      }

      public boolean hasNext() {
         boolean var1;
         if (this.g < this.f) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public T next() {
         if (this.hasNext()) {
            Object var1 = c.this.b(this.g, this.e);
            ++this.g;
            this.h = true;
            return var1;
         } else {
            throw new NoSuchElementException();
         }
      }

      public void remove() {
         if (this.h) {
            int var1 = this.g - 1;
            this.g = var1;
            --this.f;
            this.h = false;
            c.this.h(var1);
         } else {
            throw new IllegalStateException();
         }
      }
   }

   final class b implements Set<Entry<K, V>> {
      public boolean a(Entry<K, V> var1) {
         throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends Entry<K, V>> var1) {
         int var2 = c.this.d();
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            Entry var3 = (Entry)var5.next();
            c.this.g(var3.getKey(), var3.getValue());
         }

         boolean var4;
         if (var2 != c.this.d()) {
            var4 = true;
         } else {
            var4 = false;
         }

         return var4;
      }

      public void clear() {
         c.this.a();
      }

      public boolean contains(Object var1) {
         if (!(var1 instanceof Entry)) {
            return false;
         } else {
            Entry var3 = (Entry)var1;
            int var2 = c.this.e(var3.getKey());
            return var2 < 0 ? false : e.b.b(c.this.b(var2, 1), var3.getValue());
         }
      }

      public boolean containsAll(Collection<?> var1) {
         Iterator var2 = var1.iterator();

         do {
            if (!var2.hasNext()) {
               return true;
            }
         } while(this.contains(var2.next()));

         return false;
      }

      public boolean equals(Object var1) {
         return e.c.k(this, var1);
      }

      public int hashCode() {
         int var1 = c.this.d() - 1;

         int var2;
         for(var2 = 0; var1 >= 0; --var1) {
            Object var3 = c.this.b(var1, 0);
            Object var4 = c.this.b(var1, 1);
            int var5;
            if (var3 == null) {
               var5 = 0;
            } else {
               var5 = var3.hashCode();
            }

            int var6;
            if (var4 == null) {
               var6 = 0;
            } else {
               var6 = var4.hashCode();
            }

            var2 += var5 ^ var6;
         }

         return var2;
      }

      public boolean isEmpty() {
         boolean var1;
         if (c.this.d() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public Iterator<Entry<K, V>> iterator() {
         return c.this.new d();
      }

      public boolean remove(Object var1) {
         throw new UnsupportedOperationException();
      }

      public boolean removeAll(Collection<?> var1) {
         throw new UnsupportedOperationException();
      }

      public boolean retainAll(Collection<?> var1) {
         throw new UnsupportedOperationException();
      }

      public int size() {
         return c.this.d();
      }

      public Object[] toArray() {
         throw new UnsupportedOperationException();
      }

      public <T> T[] toArray(T[] var1) {
         throw new UnsupportedOperationException();
      }
   }

   final class c implements Set<K> {
      public boolean add(K var1) {
         throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends K> var1) {
         throw new UnsupportedOperationException();
      }

      public void clear() {
         c.this.a();
      }

      public boolean contains(Object var1) {
         boolean var2;
         if (c.this.e(var1) >= 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public boolean containsAll(Collection<?> var1) {
         return e.c.j(c.this.c(), var1);
      }

      public boolean equals(Object var1) {
         return e.c.k(this, var1);
      }

      public int hashCode() {
         int var1 = c.this.d() - 1;

         int var2;
         for(var2 = 0; var1 >= 0; --var1) {
            Object var3 = c.this.b(var1, 0);
            int var4;
            if (var3 == null) {
               var4 = 0;
            } else {
               var4 = var3.hashCode();
            }

            var2 += var4;
         }

         return var2;
      }

      public boolean isEmpty() {
         boolean var1;
         if (c.this.d() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public Iterator<K> iterator() {
         return c.this.new a(0);
      }

      public boolean remove(Object var1) {
         int var2 = c.this.e(var1);
         if (var2 >= 0) {
            c.this.h(var2);
            return true;
         } else {
            return false;
         }
      }

      public boolean removeAll(Collection<?> var1) {
         return e.c.o(c.this.c(), var1);
      }

      public boolean retainAll(Collection<?> var1) {
         return e.c.p(c.this.c(), var1);
      }

      public int size() {
         return c.this.d();
      }

      public Object[] toArray() {
         return c.this.q(0);
      }

      public <T> T[] toArray(T[] var1) {
         return c.this.r(var1, 0);
      }
   }

   final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
      int e = c.this.d() - 1;
      int f = -1;
      boolean g = false;

      public Entry<K, V> a() {
         if (this.hasNext()) {
            ++this.f;
            this.g = true;
            return this;
         } else {
            throw new NoSuchElementException();
         }
      }

      public boolean equals(Object var1) {
         if (this.g) {
            boolean var2 = var1 instanceof Entry;
            boolean var3 = false;
            if (!var2) {
               return false;
            } else {
               Entry var4 = (Entry)var1;
               var2 = var3;
               if (e.b.b(var4.getKey(), c.this.b(this.f, 0))) {
                  var2 = var3;
                  if (e.b.b(var4.getValue(), c.this.b(this.f, 1))) {
                     var2 = true;
                  }
               }

               return var2;
            }
         } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         }
      }

      public K getKey() {
         if (this.g) {
            return c.this.b(this.f, 0);
         } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         }
      }

      public V getValue() {
         if (this.g) {
            return c.this.b(this.f, 1);
         } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         }
      }

      public boolean hasNext() {
         boolean var1;
         if (this.f < this.e) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public int hashCode() {
         if (this.g) {
            e.c var1 = c.this;
            int var2 = this.f;
            int var3 = 0;
            Object var5 = var1.b(var2, 0);
            Object var4 = c.this.b(this.f, 1);
            if (var5 == null) {
               var2 = 0;
            } else {
               var2 = var5.hashCode();
            }

            if (var4 != null) {
               var3 = var4.hashCode();
            }

            return var2 ^ var3;
         } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         }
      }

      public void remove() {
         if (this.g) {
            c.this.h(this.f);
            --this.f;
            --this.e;
            this.g = false;
         } else {
            throw new IllegalStateException();
         }
      }

      public V setValue(V var1) {
         if (this.g) {
            return c.this.i(this.f, var1);
         } else {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         }
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append(this.getKey());
         var1.append("=");
         var1.append(this.getValue());
         return var1.toString();
      }
   }

   final class e implements Collection<V> {
      public boolean add(V var1) {
         throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends V> var1) {
         throw new UnsupportedOperationException();
      }

      public void clear() {
         c.this.a();
      }

      public boolean contains(Object var1) {
         boolean var2;
         if (c.this.f(var1) >= 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public boolean containsAll(Collection<?> var1) {
         Iterator var2 = var1.iterator();

         do {
            if (!var2.hasNext()) {
               return true;
            }
         } while(this.contains(var2.next()));

         return false;
      }

      public boolean isEmpty() {
         boolean var1;
         if (c.this.d() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public Iterator<V> iterator() {
         return c.this.new a(1);
      }

      public boolean remove(Object var1) {
         int var2 = c.this.f(var1);
         if (var2 >= 0) {
            c.this.h(var2);
            return true;
         } else {
            return false;
         }
      }

      public boolean removeAll(Collection<?> var1) {
         int var2 = c.this.d();
         int var3 = 0;

         boolean var4;
         int var5;
         for(var4 = false; var3 < var2; var2 = var5) {
            var5 = var2;
            int var6 = var3;
            if (var1.contains(c.this.b(var3, 1))) {
               c.this.h(var3);
               var6 = var3 - 1;
               var5 = var2 - 1;
               var4 = true;
            }

            var3 = var6 + 1;
         }

         return var4;
      }

      public boolean retainAll(Collection<?> var1) {
         int var2 = c.this.d();
         int var3 = 0;

         boolean var4;
         int var5;
         for(var4 = false; var3 < var2; var2 = var5) {
            var5 = var2;
            int var6 = var3;
            if (!var1.contains(c.this.b(var3, 1))) {
               c.this.h(var3);
               var6 = var3 - 1;
               var5 = var2 - 1;
               var4 = true;
            }

            var3 = var6 + 1;
         }

         return var4;
      }

      public int size() {
         return c.this.d();
      }

      public Object[] toArray() {
         return c.this.q(1);
      }

      public <T> T[] toArray(T[] var1) {
         return c.this.r(var1, 1);
      }
   }
}
