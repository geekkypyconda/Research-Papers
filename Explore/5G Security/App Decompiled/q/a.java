package q;

import a1.k;
import android.app.Activity;
import java.util.concurrent.Executor;
import k1.c;
import r.f;
import r.j;

public final class a implements f {
   private final f b;
   private final p.a c;

   public a(f var1) {
      k.e(var1, "tracker");
      this(var1, new p.a());
   }

   private a(f var1, p.a var2) {
      this.b = var1;
      this.c = var2;
   }

   public c<j> a(Activity var1) {
      k.e(var1, "activity");
      return this.b.a(var1);
   }

   public final void b(Activity var1, Executor var2, h.a<j> var3) {
      k.e(var1, "activity");
      k.e(var2, "executor");
      k.e(var3, "consumer");
      this.c.a(var2, var3, this.b.a(var1));
   }

   public final void c(h.a<j> var1) {
      k.e(var1, "consumer");
      this.c.b(var1);
   }
}
