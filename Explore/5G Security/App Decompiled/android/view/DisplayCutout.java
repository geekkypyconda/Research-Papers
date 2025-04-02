package android.view;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.graphics.Rect;
import java.util.List;

// $FF: synthetic class
public final class DisplayCutout {
   static {
      throw new NoClassDefFoundError();
   }

   // $FF: synthetic method
   @Deprecated
   public DisplayCutout(@Nullable Rect var1, @Nullable List<Rect> var2) {
   }

   // $FF: synthetic method
   @NonNull
   public native List<Rect> getBoundingRects();

   // $FF: synthetic method
   public native int getSafeInsetBottom();

   // $FF: synthetic method
   public native int getSafeInsetLeft();

   // $FF: synthetic method
   public native int getSafeInsetRight();

   // $FF: synthetic method
   public native int getSafeInsetTop();

   // $FF: synthetic method
   public native int hashCode();
}
