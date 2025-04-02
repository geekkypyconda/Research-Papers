package e;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class a<K, V> extends d<K, V> implements Map<K, V> {
   c<K, V> l;

   private c<K, V> m() {
      if (this.l == null) {
         this.l = new c<K, V>() {
            protected void a() {
               a.this.clear();
            }

            protected Object b(int var1, int var2) {
               return a.super.f[(var1 << 1) + var2];
            }

            protected Map<K, V> c() {
               return a.this;
            }

            protected int d() {
               return a.super.g;
            }

            protected int e(Object var1) {
               return a.this.f(var1);
            }

            protected int f(Object var1) {
               return a.this.h(var1);
            }

            protected void g(K var1, V var2) {
               a.this.put(var1, var2);
            }

            protected void h(int var1) {
               a.this.j(var1);
            }

            protected V i(int var1, V var2) {
               return a.this.k(var1, var2);
            }
         };
      }

      return this.l;
   }

   public Set<Entry<K, V>> entrySet() {
      return this.m().l();
   }

   public Set<K> keySet() {
      return this.m().m();
   }

   public void putAll(Map<? extends K, ? extends V> var1) {
      this.c(super.g + var1.size());
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   public Collection<V> values() {
      return this.m().n();
   }
}
