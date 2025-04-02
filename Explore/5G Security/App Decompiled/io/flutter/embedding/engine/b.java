package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

public class b {
   private static b b;
   private final Map<String, a> a = new HashMap();

   b() {
   }

   public static b b() {
      if (b == null) {
         b = new b();
      }

      return b;
   }

   public a a(String var1) {
      return (a)this.a.get(var1);
   }

   public void c(String var1, a var2) {
      if (var2 != null) {
         this.a.put(var1, var2);
      } else {
         this.a.remove(var1);
      }

   }

   public void d(String var1) {
      this.c(var1, (a)null);
   }
}
