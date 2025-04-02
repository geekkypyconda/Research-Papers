package d;

import java.util.HashMap;
import java.util.Map.Entry;

public class a<K, V> extends d.b<K, V> {
   private final HashMap<K, d.b.c<K, V>> i = new HashMap();

   public boolean contains(K var1) {
      return this.i.containsKey(var1);
   }

   public Entry<K, V> e(K var1) {
      return this.contains(var1) ? ((d.b.c)this.i.get(var1)).h : null;
   }

   protected d.b.c<K, V> f(K var1) {
      return (d.b.c)this.i.get(var1);
   }

   public V g(K var1, V var2) {
      d.b.c var3 = this.f(var1);
      if (var3 != null) {
         return var3.f;
      } else {
         this.i.put(var1, this.d(var1, var2));
         return null;
      }
   }
}
