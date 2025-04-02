package t;

import a1.k;
import android.content.Context;
import java.util.concurrent.Executor;
import q0.l;
import r.j;

public final class c implements s.a {
   // $FF: synthetic method
   public static void c(h.a var0) {
      d(var0);
   }

   private static final void d(h.a var0) {
      k.e(var0, "$callback");
      var0.accept(new j(l.e()));
   }

   public void a(Context var1, Executor var2, h.a<j> var3) {
      k.e(var1, "context");
      k.e(var2, "executor");
      k.e(var3, "callback");
      var2.execute(new b(var3));
   }

   public void b(h.a<j> var1) {
      k.e(var1, "callback");
   }
}
