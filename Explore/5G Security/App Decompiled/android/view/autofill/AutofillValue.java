package android.view.autofill;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcelable;

// $FF: synthetic class
public final class AutofillValue implements Parcelable {
   static {
      throw new NoClassDefFoundError();
   }

   // $FF: synthetic method
   public static native AutofillValue forText(@Nullable CharSequence var0);

   // $FF: synthetic method
   @NonNull
   public native CharSequence getTextValue();
}
