package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
   public static IconCompat read(a var0) {
      return androidx.core.graphics.drawable.IconCompatParcelizer.read(var0);
   }

   public static void write(IconCompat var0, a var1) {
      androidx.core.graphics.drawable.IconCompatParcelizer.write(var0, var1);
   }
}
