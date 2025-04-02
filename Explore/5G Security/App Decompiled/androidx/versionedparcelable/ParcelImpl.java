package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelImpl implements Parcelable {
   public static final Creator<ParcelImpl> CREATOR = new Creator<ParcelImpl>() {
      public ParcelImpl a(Parcel var1) {
         return new ParcelImpl(var1);
      }

      public ParcelImpl[] b(int var1) {
         return new ParcelImpl[var1];
      }
   };
   private final m.a e;

   protected ParcelImpl(Parcel var1) {
      this.e = (new b(var1)).u();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      (new b(var1)).L(this.e);
   }
}
