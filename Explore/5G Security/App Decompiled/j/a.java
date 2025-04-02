package j;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.inputmethod.EditorInfo;

public final class a {
   private static final String[] a = new String[0];

   public static void a(EditorInfo var0, String[] var1) {
      if (VERSION.SDK_INT >= 25) {
         var0.contentMimeTypes = var1;
      } else {
         if (var0.extras == null) {
            var0.extras = new Bundle();
         }

         var0.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", var1);
         var0.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", var1);
      }

   }
}
