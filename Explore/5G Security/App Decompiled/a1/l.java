package a1;

import java.io.Serializable;

public abstract class l<R> implements h<R>, Serializable {
   private final int e;

   public l(int var1) {
      this.e = var1;
   }

   public int e() {
      return this.e;
   }

   public String toString() {
      String var1 = r.f(this);
      k.d(var1, "renderLambdaToString(this)");
      return var1;
   }
}
