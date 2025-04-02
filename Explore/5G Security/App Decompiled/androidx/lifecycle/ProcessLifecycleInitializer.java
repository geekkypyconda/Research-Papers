package androidx.lifecycle;

import android.content.Context;
import java.util.List;

public final class ProcessLifecycleInitializer implements k.a<l> {
   public List<Class<? extends k.a<?>>> a() {
      return q0.l.e();
   }

   public l c(Context var1) {
      a1.k.e(var1, "context");
      androidx.startup.a var2 = androidx.startup.a.d(var1);
      a1.k.d(var2, "getInstance(context)");
      if (var2.e(ProcessLifecycleInitializer.class)) {
         i.a(var1);
         t.b var3 = t.i;
         var3.b(var1);
         return var3.a();
      } else {
         throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
      }
   }
}
