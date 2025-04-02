package b1;

import a1.k;
import java.util.Random;

public final class b extends b1.a {
   private final <undefinedtype> g = new ThreadLocal<Random>() {
      protected Random a() {
         return new Random();
      }
   };

   public Random c() {
      Object var1 = this.g.get();
      k.d(var1, "implStorage.get()");
      return (Random)var1;
   }
}
