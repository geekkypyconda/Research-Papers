package android.view.autofill;

import android.annotation.NonNull;
import android.graphics.Rect;
import android.view.View;

// $FF: synthetic class
public final class AutofillManager {
   static {
      throw new NoClassDefFoundError();
   }

   // $FF: synthetic method
   public native void cancel();

   // $FF: synthetic method
   public native void commit();

   // $FF: synthetic method
   public native void notifyValueChanged(View var1, int var2, AutofillValue var3);

   // $FF: synthetic method
   public native void notifyViewEntered(@NonNull View var1, int var2, @NonNull Rect var3);

   // $FF: synthetic method
   public native void notifyViewExited(@NonNull View var1, int var2);
}
