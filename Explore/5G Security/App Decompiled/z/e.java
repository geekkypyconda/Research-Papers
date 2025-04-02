package z;

import android.os.Handler;
import android.os.Looper;

public class e implements c.b {
   private final Handler a = o0.a.a(Looper.getMainLooper());

   public void a(Runnable var1) {
      this.a.post(var1);
   }
}
