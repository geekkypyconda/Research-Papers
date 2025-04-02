package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.a;

public final class RemoteActionCompatParcelizer extends androidx.core.app.RemoteActionCompatParcelizer {
   public static RemoteActionCompat read(a var0) {
      return androidx.core.app.RemoteActionCompatParcelizer.read(var0);
   }

   public static void write(RemoteActionCompat var0, a var1) {
      androidx.core.app.RemoteActionCompatParcelizer.write(var0, var1);
   }
}
