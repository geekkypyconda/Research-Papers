package d;

import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public class b<K, V> implements Iterable<Entry<K, V>> {
   d.b.c<K, V> e;
   private d.b.c<K, V> f;
   private final WeakHashMap<d.b.f<K, V>, Boolean> g = new WeakHashMap();
   private int h = 0;

   public Entry<K, V> a() {
      return this.e;
   }

   public d.b<K, V>.d b() {
      d.b.d var1 = new d.b.d();
      this.g.put(var1, Boolean.FALSE);
      return var1;
   }

   public Entry<K, V> c() {
      return this.f;
   }

   d.b.c<K, V> d(K var1, V var2) {
      d.b.c var3 = new d.b.c(var1, var2);
      ++this.h;
      d.b.c var4 = this.f;
      if (var4 == null) {
         this.e = var3;
      } else {
         var4.g = var3;
         var3.h = var4;
      }

      this.f = var3;
      return var3;
   }

   public Iterator<Entry<K, V>> descendingIterator() {
      d.b.b var1 = new d.b.b(this.f, this.e);
      this.g.put(var1, Boolean.FALSE);
      return var1;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof d.b)) {
         return false;
      } else {
         d.b var3 = (d.b)var1;
         if (this.size() != var3.size()) {
            return false;
         } else {
            Iterator var6 = this.iterator();
            Iterator var4 = var3.iterator();

            while(true) {
               if (var6.hasNext() && var4.hasNext()) {
                  Entry var7 = (Entry)var6.next();
                  Object var5 = var4.next();
                  if ((var7 != null || var5 == null) && (var7 == null || var7.equals(var5))) {
                     continue;
                  }

                  return false;
               }

               if (var6.hasNext() || var4.hasNext()) {
                  var2 = false;
               }

               return var2;
            }
         }
      }
   }

   public int hashCode() {
      Iterator var1 = this.iterator();

      int var2;
      for(var2 = 0; var1.hasNext(); var2 += ((Entry)var1.next()).hashCode()) {
      }

      return var2;
   }

   public Iterator<Entry<K, V>> iterator() {
      d.b.a var1 = new d.b.a(this.e, this.f);
      this.g.put(var1, Boolean.FALSE);
      return var1;
   }

   public int size() {
      return this.h;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[");
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         var1.append(((Entry)var2.next()).toString());
         if (var2.hasNext()) {
            var1.append(", ");
         }
      }

      var1.append("]");
      return var1.toString();
   }

   static class a<K, V> extends d.b.e<K, V> {
      a(d.b.c<K, V> var1, d.b.c<K, V> var2) {
         super(var1, var2);
      }

      d.b.c<K, V> a(d.b.c<K, V> var1) {
         return var1.g;
      }
   }

   private static class b<K, V> extends d.b.e<K, V> {
      b(d.b.c<K, V> var1, d.b.c<K, V> var2) {
         super(var1, var2);
      }

      d.b.c<K, V> a(d.b.c<K, V> var1) {
         return var1.h;
      }
   }

   static class c<K, V> implements Entry<K, V> {
      final K e;
      final V f;
      d.b.c<K, V> g;
      d.b.c<K, V> h;

      c(K var1, V var2) {
         this.e = var1;
         this.f = var2;
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof d.b.c)) {
            return false;
         } else {
            d.b.c var3 = (d.b.c)var1;
            if (!this.e.equals(var3.e) || !this.f.equals(var3.f)) {
               var2 = false;
            }

            return var2;
         }
      }

      public K getKey() {
         return this.e;
      }

      public V getValue() {
         return this.f;
      }

      public int hashCode() {
         return this.e.hashCode() ^ this.f.hashCode();
      }

      public V setValue(V var1) {
         throw new UnsupportedOperationException("An entry modification is not supported");
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append(this.e);
         var1.append("=");
         var1.append(this.f);
         return var1.toString();
      }
   }

   public class d extends d.b.f<K, V> implements Iterator<Entry<K, V>> {
      private d.b.c<K, V> e;
      private boolean f = true;

      d() {
      }

      public Entry<K, V> a() {
         d.b.c var1;
         if (this.f) {
            this.f = false;
            var1 = b.this.e;
         } else {
            var1 = this.e;
            if (var1 != null) {
               var1 = var1.g;
            } else {
               var1 = null;
            }
         }

         this.e = var1;
         return this.e;
      }

      public boolean hasNext() {
         boolean var1 = this.f;
         boolean var2 = true;
         boolean var3 = true;
         if (var1) {
            if (b.this.e == null) {
               var3 = false;
            }

            return var3;
         } else {
            d.b.c var4 = this.e;
            if (var4 != null && var4.g != null) {
               var3 = var2;
            } else {
               var3 = false;
            }

            return var3;
         }
      }
   }

   private abstract static class e<K, V> extends d.b.f<K, V> implements Iterator<Entry<K, V>> {
      d.b.c<K, V> e;
      d.b.c<K, V> f;

      e(d.b.c<K, V> var1, d.b.c<K, V> var2) {
         this.e = var2;
         this.f = var1;
      }

      private d.b.c<K, V> c() {
         d.b.c var1 = this.f;
         d.b.c var2 = this.e;
         return var1 != var2 && var2 != null ? this.a(var1) : null;
      }

      abstract d.b.c<K, V> a(d.b.c<K, V> var1);

      public Entry<K, V> b() {
         d.b.c var1 = this.f;
         this.f = this.c();
         return var1;
      }

      public boolean hasNext() {
         boolean var1;
         if (this.f != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   public abstract static class f<K, V> {
   }
}
