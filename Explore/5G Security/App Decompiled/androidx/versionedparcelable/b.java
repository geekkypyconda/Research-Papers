package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

class b extends a {
   private final SparseIntArray d;
   private final Parcel e;
   private final int f;
   private final int g;
   private final String h;
   private int i;
   private int j;
   private int k;

   b(Parcel var1) {
      this(var1, var1.dataPosition(), var1.dataSize(), "", new e.a(), new e.a(), new e.a());
   }

   private b(Parcel var1, int var2, int var3, String var4, e.a<String, Method> var5, e.a<String, Method> var6, e.a<String, Class> var7) {
      super(var5, var6, var7);
      this.d = new SparseIntArray();
      this.i = -1;
      this.k = -1;
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.j = var2;
      this.h = var4;
   }

   public void A(byte[] var1) {
      if (var1 != null) {
         this.e.writeInt(var1.length);
         this.e.writeByteArray(var1);
      } else {
         this.e.writeInt(-1);
      }

   }

   protected void C(CharSequence var1) {
      TextUtils.writeToParcel(var1, this.e, 0);
   }

   public void E(int var1) {
      this.e.writeInt(var1);
   }

   public void G(Parcelable var1) {
      this.e.writeParcelable(var1, 0);
   }

   public void I(String var1) {
      this.e.writeString(var1);
   }

   public void a() {
      int var1 = this.i;
      if (var1 >= 0) {
         var1 = this.d.get(var1);
         int var2 = this.e.dataPosition();
         this.e.setDataPosition(var1);
         this.e.writeInt(var2 - var1);
         this.e.setDataPosition(var2);
      }

   }

   protected a b() {
      Parcel var1 = this.e;
      int var2 = var1.dataPosition();
      int var3 = this.j;
      int var4 = var3;
      if (var3 == this.f) {
         var4 = this.g;
      }

      StringBuilder var5 = new StringBuilder();
      var5.append(this.h);
      var5.append("  ");
      return new b(var1, var2, var4, var5.toString(), super.a, super.b, super.c);
   }

   public boolean g() {
      boolean var1;
      if (this.e.readInt() != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public byte[] i() {
      int var1 = this.e.readInt();
      if (var1 < 0) {
         return null;
      } else {
         byte[] var2 = new byte[var1];
         this.e.readByteArray(var2);
         return var2;
      }
   }

   protected CharSequence k() {
      return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
   }

   public boolean m(int var1) {
      while(true) {
         int var2 = this.j;
         int var3 = this.g;
         boolean var4 = true;
         if (var2 >= var3) {
            if (this.k != var1) {
               var4 = false;
            }

            return var4;
         }

         var3 = this.k;
         if (var3 == var1) {
            return true;
         }

         if (String.valueOf(var3).compareTo(String.valueOf(var1)) > 0) {
            return false;
         }

         this.e.setDataPosition(this.j);
         var3 = this.e.readInt();
         this.k = this.e.readInt();
         this.j += var3;
      }
   }

   public int o() {
      return this.e.readInt();
   }

   public <T extends Parcelable> T q() {
      return this.e.readParcelable(this.getClass().getClassLoader());
   }

   public String s() {
      return this.e.readString();
   }

   public void w(int var1) {
      this.a();
      this.i = var1;
      this.d.put(var1, this.e.dataPosition());
      this.E(0);
      this.E(var1);
   }

   public void y(boolean var1) {
      this.e.writeInt(var1);
   }
}
