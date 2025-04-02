package b1;

import a1.g;
import java.io.Serializable;

public abstract class c {
   public static final c.a e = new c.a((g)null);
   private static final c f;

   static {
      f = u0.b.a.b();
   }

   public abstract int b();

   public static final class a extends c implements Serializable {
      private a() {
      }

      // $FF: synthetic method
      public a(g var1) {
         this();
      }

      public int b() {
         return c.f.b();
      }
   }
}
