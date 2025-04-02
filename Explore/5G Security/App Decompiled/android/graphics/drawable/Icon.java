package android.graphics.drawable;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.os.Parcelable;

// $FF: synthetic class
public final class Icon implements Parcelable {
   static {
      throw new NoClassDefFoundError();
   }

   // $FF: synthetic method
   @NonNull
   public static native Icon createWithBitmap(Bitmap var0);

   // $FF: synthetic method
   @NonNull
   public static native Icon createWithContentUri(String var0);

   // $FF: synthetic method
   @NonNull
   public static native Icon createWithData(byte[] var0, int var1, int var2);

   // $FF: synthetic method
   @NonNull
   public static native Icon createWithResource(String var0, int var1);

   // $FF: synthetic method
   @Nullable
   public native Drawable loadDrawable(Context var1);

   // $FF: synthetic method
   @NonNull
   public native Icon setTintList(ColorStateList var1);

   // $FF: synthetic method
   @NonNull
   public native Icon setTintMode(@NonNull Mode var1);
}
