package androidx.core.content;

import android.content.Context;
import android.os.Handler;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;

public class b {
   private static final Object a = new Object();

   public static Executor a(Context var0) {
      return VERSION.SDK_INT >= 28 ? b.a.a(var0) : g.a.a(new Handler(var0.getMainLooper()));
   }

   static class a {
      static Executor a(Context var0) {
         return androidx.core.content.a.a(var0);
      }
   }
}
