package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

public final class i {
   public static final i a = new i();
   private static final AtomicBoolean b = new AtomicBoolean(false);

   private i() {
   }

   public static final void a(Context var0) {
      a1.k.e(var0, "context");
      if (!b.getAndSet(true)) {
         var0 = var0.getApplicationContext();
         a1.k.c(var0, "null cannot be cast to non-null type android.app.Application");
         ((Application)var0).registerActivityLifecycleCallbacks(new i.a());
      }
   }

   public static final class a extends f {
      public void onActivityCreated(Activity var1, Bundle var2) {
         a1.k.e(var1, "activity");
         v.b.c(var1);
      }
   }
}
