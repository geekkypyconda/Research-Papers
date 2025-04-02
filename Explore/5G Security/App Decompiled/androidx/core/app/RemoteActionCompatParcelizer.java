package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class RemoteActionCompatParcelizer {
   public static RemoteActionCompat read(a var0) {
      RemoteActionCompat var1 = new RemoteActionCompat();
      var1.a = (IconCompat)var0.v(var1.a, 1);
      var1.b = var0.l(var1.b, 2);
      var1.c = var0.l(var1.c, 3);
      var1.d = (PendingIntent)var0.r(var1.d, 4);
      var1.e = var0.h(var1.e, 5);
      var1.f = var0.h(var1.f, 6);
      return var1;
   }

   public static void write(RemoteActionCompat var0, a var1) {
      var1.x(false, false);
      var1.M(var0.a, 1);
      var1.D(var0.b, 2);
      var1.D(var0.c, 3);
      var1.H(var0.d, 4);
      var1.z(var0.e, 5);
      var1.z(var0.f, 6);
   }
}
