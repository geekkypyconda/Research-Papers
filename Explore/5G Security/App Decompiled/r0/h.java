package r0;

import a1.k;
import java.io.Serializable;
import z0.p;

public final class h implements g, Serializable {
   public static final h e = new h();

   private h() {
   }

   public <E extends g.b> E b(g.c<E> var1) {
      k.e(var1, "key");
      return null;
   }

   public int hashCode() {
      return 0;
   }

   public g n(g var1) {
      k.e(var1, "context");
      return var1;
   }

   public String toString() {
      return "EmptyCoroutineContext";
   }

   public g x(g.c<?> var1) {
      k.e(var1, "key");
      return this;
   }

   public <R> R y(R var1, p<? super R, ? super g.b, ? extends R> var2) {
      k.e(var2, "operation");
      return var1;
   }
}
