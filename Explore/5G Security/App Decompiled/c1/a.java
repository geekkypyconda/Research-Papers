package c1;

import a1.k;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class a extends b1.a {
   public Random c() {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();
      k.d(var1, "current()");
      return var1;
   }
}
