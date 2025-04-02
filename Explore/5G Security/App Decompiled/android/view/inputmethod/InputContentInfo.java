package android.view.inputmethod;

import android.annotation.NonNull;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Parcelable;

// $FF: synthetic class
public final class InputContentInfo implements Parcelable {
   static {
      throw new NoClassDefFoundError();
   }

   // $FF: synthetic method
   @NonNull
   public native Uri getContentUri();

   // $FF: synthetic method
   @NonNull
   public native ClipDescription getDescription();

   // $FF: synthetic method
   public native void releasePermission();

   // $FF: synthetic method
   public native void requestPermission();
}
