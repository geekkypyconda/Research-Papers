package o0;

import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;

public final class a {
   public static Handler a(Looper var0) {
      return VERSION.SDK_INT >= 28 ? c.e.a(var0) : new Handler(var0);
   }
}
