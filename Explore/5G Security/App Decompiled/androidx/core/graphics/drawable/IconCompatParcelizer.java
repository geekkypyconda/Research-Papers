package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

public class IconCompatParcelizer {
   public static IconCompat read(androidx.versionedparcelable.a var0) {
      IconCompat var1 = new IconCompat();
      var1.a = var0.p(var1.a, 1);
      var1.c = var0.j(var1.c, 2);
      var1.d = var0.r(var1.d, 3);
      var1.e = var0.p(var1.e, 4);
      var1.f = var0.p(var1.f, 5);
      var1.g = (ColorStateList)var0.r(var1.g, 6);
      var1.i = var0.t(var1.i, 7);
      var1.j = var0.t(var1.j, 8);
      var1.f();
      return var1;
   }

   public static void write(IconCompat var0, androidx.versionedparcelable.a var1) {
      var1.x(true, true);
      var0.g(var1.f());
      int var2 = var0.a;
      if (-1 != var2) {
         var1.F(var2, 1);
      }

      byte[] var3 = var0.c;
      if (var3 != null) {
         var1.B(var3, 2);
      }

      Parcelable var5 = var0.d;
      if (var5 != null) {
         var1.H(var5, 3);
      }

      var2 = var0.e;
      if (var2 != 0) {
         var1.F(var2, 4);
      }

      var2 = var0.f;
      if (var2 != 0) {
         var1.F(var2, 5);
      }

      ColorStateList var6 = var0.g;
      if (var6 != null) {
         var1.H(var6, 6);
      }

      String var7 = var0.i;
      if (var7 != null) {
         var1.J(var7, 7);
      }

      String var4 = var0.j;
      if (var4 != null) {
         var1.J(var4, 8);
      }

   }
}
