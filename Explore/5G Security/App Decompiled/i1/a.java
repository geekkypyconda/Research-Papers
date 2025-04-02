package i1;

import a1.g;
import android.os.Looper;
import h1.r1;
import java.util.List;
import m1.v;

public final class a implements v {
   public int a() {
      return 1073741823;
   }

   public String b() {
      return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
   }

   public r1 c(List<? extends v> var1) {
      Looper var2 = Looper.getMainLooper();
      if (var2 != null) {
         return new c(e.a(var2, true), (String)null, 2, (g)null);
      } else {
         throw new IllegalStateException("The main looper is not available");
      }
   }
}
