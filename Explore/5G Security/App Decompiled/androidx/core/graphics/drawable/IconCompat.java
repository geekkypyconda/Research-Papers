package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
   static final Mode k;
   public int a = -1;
   Object b;
   public byte[] c = null;
   public Parcelable d = null;
   public int e = 0;
   public int f = 0;
   public ColorStateList g = null;
   Mode h;
   public String i;
   public String j;

   static {
      k = Mode.SRC_IN;
   }

   public IconCompat() {
      this.h = k;
      this.i = null;
   }

   static Bitmap a(Bitmap var0, boolean var1) {
      int var2 = (int)((float)Math.min(var0.getWidth(), var0.getHeight()) * 0.6666667F);
      Bitmap var3 = Bitmap.createBitmap(var2, var2, Config.ARGB_8888);
      Canvas var4 = new Canvas(var3);
      Paint var5 = new Paint(3);
      float var6 = (float)var2;
      float var7 = 0.5F * var6;
      float var8 = 0.9166667F * var7;
      if (var1) {
         float var9 = 0.010416667F * var6;
         var5.setColor(0);
         var5.setShadowLayer(var9, 0.0F, var6 * 0.020833334F, 1023410176);
         var4.drawCircle(var7, var7, var8, var5);
         var5.setShadowLayer(var9, 0.0F, 0.0F, 503316480);
         var4.drawCircle(var7, var7, var8, var5);
         var5.clearShadowLayer();
      }

      var5.setColor(-16777216);
      TileMode var10 = TileMode.CLAMP;
      BitmapShader var12 = new BitmapShader(var0, var10, var10);
      Matrix var11 = new Matrix();
      var11.setTranslate((float)(-(var0.getWidth() - var2)) / 2.0F, (float)(-(var0.getHeight() - var2)) / 2.0F);
      var12.setLocalMatrix(var11);
      var5.setShader(var12);
      var4.drawCircle(var7, var7, var8, var5);
      var4.setBitmap((Bitmap)null);
      return var3;
   }

   private static String h(int var0) {
      switch(var0) {
      case 1:
         return "BITMAP";
      case 2:
         return "RESOURCE";
      case 3:
         return "DATA";
      case 4:
         return "URI";
      case 5:
         return "BITMAP_MASKABLE";
      case 6:
         return "URI_MASKABLE";
      default:
         return "UNKNOWN";
      }
   }

   public int b() {
      int var1 = this.a;
      if (var1 == -1 && VERSION.SDK_INT >= 23) {
         return IconCompat.a.a(this.b);
      } else if (var1 == 2) {
         return this.e;
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("called getResId() on ");
         var2.append(this);
         throw new IllegalStateException(var2.toString());
      }
   }

   public String c() {
      int var1 = this.a;
      if (var1 == -1 && VERSION.SDK_INT >= 23) {
         return IconCompat.a.b(this.b);
      } else if (var1 == 2) {
         String var3 = this.j;
         return var3 != null && !TextUtils.isEmpty(var3) ? this.j : ((String)this.b).split(":", -1)[0];
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("called getResPackage() on ");
         var2.append(this);
         throw new IllegalStateException(var2.toString());
      }
   }

   public Uri d() {
      int var1 = this.a;
      if (var1 == -1 && VERSION.SDK_INT >= 23) {
         return IconCompat.a.c(this.b);
      } else if (var1 != 4 && var1 != 6) {
         StringBuilder var2 = new StringBuilder();
         var2.append("called getUri() on ");
         var2.append(this);
         throw new IllegalStateException(var2.toString());
      } else {
         return Uri.parse((String)this.b);
      }
   }

   public InputStream e(Context var1) {
      Uri var2 = this.d();
      String var3 = var2.getScheme();
      StringBuilder var4;
      String var7;
      Object var11;
      if (!"content".equals(var3) && !"file".equals(var3)) {
         try {
            File var9 = new File((String)this.b);
            FileInputStream var10 = new FileInputStream(var9);
            return var10;
         } catch (FileNotFoundException var5) {
            var11 = var5;
            var4 = new StringBuilder();
            var7 = "Unable to load image from path: ";
         }
      } else {
         try {
            InputStream var8 = var1.getContentResolver().openInputStream(var2);
            return var8;
         } catch (Exception var6) {
            var11 = var6;
            var4 = new StringBuilder();
            var7 = "Unable to load image from URI: ";
         }
      }

      var4.append(var7);
      var4.append(var2);
      Log.w("IconCompat", var4.toString(), (Throwable)var11);
      return null;
   }

   public void f() {
      this.h = Mode.valueOf(this.i);
      Parcelable var2;
      switch(this.a) {
      case -1:
         var2 = this.d;
         if (var2 == null) {
            throw new IllegalArgumentException("Invalid icon");
         }
         break;
      case 0:
      default:
         return;
      case 1:
      case 5:
         var2 = this.d;
         if (var2 == null) {
            byte[] var3 = this.c;
            this.b = var3;
            this.a = 3;
            this.e = 0;
            this.f = var3.length;
            return;
         }
         break;
      case 2:
      case 4:
      case 6:
         String var1 = new String(this.c, Charset.forName("UTF-16"));
         this.b = var1;
         if (this.a == 2 && this.j == null) {
            this.j = var1.split(":", -1)[0];
         }

         return;
      case 3:
         this.b = this.c;
         return;
      }

      this.b = var2;
   }

   public void g(boolean var1) {
      this.i = this.h.name();
      switch(this.a) {
      case -1:
         if (var1) {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
         }
         break;
      case 0:
      default:
         return;
      case 1:
      case 5:
         if (var1) {
            Bitmap var2 = (Bitmap)this.b;
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            var2.compress(CompressFormat.PNG, 90, var3);
            this.c = var3.toByteArray();
            return;
         }
         break;
      case 2:
         this.c = ((String)this.b).getBytes(Charset.forName("UTF-16"));
         return;
      case 3:
         this.c = (byte[])this.b;
         return;
      case 4:
      case 6:
         this.c = this.b.toString().getBytes(Charset.forName("UTF-16"));
         return;
      }

      this.d = (Parcelable)this.b;
   }

   public String toString() {
      if (this.a == -1) {
         return String.valueOf(this.b);
      } else {
         StringBuilder var1;
         label30: {
            var1 = new StringBuilder("Icon(typ=");
            var1.append(h(this.a));
            int var2;
            switch(this.a) {
            case 1:
            case 5:
               var1.append(" size=");
               var1.append(((Bitmap)this.b).getWidth());
               var1.append("x");
               var2 = ((Bitmap)this.b).getHeight();
               break;
            case 2:
               var1.append(" pkg=");
               var1.append(this.j);
               var1.append(" id=");
               var1.append(String.format("0x%08x", this.b()));
               break label30;
            case 3:
               var1.append(" len=");
               var1.append(this.e);
               if (this.f == 0) {
                  break label30;
               }

               var1.append(" off=");
               var2 = this.f;
               break;
            case 4:
            case 6:
               var1.append(" uri=");
               var1.append(this.b);
            default:
               break label30;
            }

            var1.append(var2);
         }

         if (this.g != null) {
            var1.append(" tint=");
            var1.append(this.g);
         }

         if (this.h != k) {
            var1.append(" mode=");
            var1.append(this.h);
         }

         var1.append(")");
         return var1.toString();
      }
   }

   static class a {
      static int a(Object var0) {
         if (VERSION.SDK_INT >= 28) {
            return IconCompat.c.a(var0);
         } else {
            try {
               int var1 = (Integer)var0.getClass().getMethod("getResId").invoke(var0);
               return var1;
            } catch (IllegalAccessException var2) {
               Log.e("IconCompat", "Unable to get icon resource", var2);
               return 0;
            } catch (InvocationTargetException var3) {
               Log.e("IconCompat", "Unable to get icon resource", var3);
               return 0;
            } catch (NoSuchMethodException var4) {
               Log.e("IconCompat", "Unable to get icon resource", var4);
               return 0;
            }
         }
      }

      static String b(Object var0) {
         if (VERSION.SDK_INT >= 28) {
            return IconCompat.c.b(var0);
         } else {
            try {
               String var4 = (String)var0.getClass().getMethod("getResPackage").invoke(var0);
               return var4;
            } catch (IllegalAccessException var1) {
               Log.e("IconCompat", "Unable to get icon package", var1);
               return null;
            } catch (InvocationTargetException var2) {
               Log.e("IconCompat", "Unable to get icon package", var2);
               return null;
            } catch (NoSuchMethodException var3) {
               Log.e("IconCompat", "Unable to get icon package", var3);
               return null;
            }
         }
      }

      static Uri c(Object var0) {
         if (VERSION.SDK_INT >= 28) {
            return IconCompat.c.d(var0);
         } else {
            try {
               Uri var4 = (Uri)var0.getClass().getMethod("getUri").invoke(var0);
               return var4;
            } catch (IllegalAccessException var1) {
               Log.e("IconCompat", "Unable to get icon uri", var1);
               return null;
            } catch (InvocationTargetException var2) {
               Log.e("IconCompat", "Unable to get icon uri", var2);
               return null;
            } catch (NoSuchMethodException var3) {
               Log.e("IconCompat", "Unable to get icon uri", var3);
               return null;
            }
         }
      }

      static Drawable d(Icon var0, Context var1) {
         return var0.loadDrawable(var1);
      }

      static Icon e(IconCompat var0, Context var1) {
         Icon var8;
         label65: {
            Bitmap var6;
            label64: {
               label63: {
                  Bitmap var3;
                  switch(var0.a) {
                  case -1:
                     return (Icon)var0.b;
                  case 0:
                  default:
                     throw new IllegalArgumentException("Unknown type");
                  case 1:
                     var6 = (Bitmap)var0.b;
                     break label64;
                  case 2:
                     var8 = Icon.createWithResource(var0.c(), var0.e);
                     break label65;
                  case 3:
                     var8 = Icon.createWithData((byte[])var0.b, var0.e, var0.f);
                     break label65;
                  case 4:
                     var8 = Icon.createWithContentUri((String)var0.b);
                     break label65;
                  case 5:
                     if (VERSION.SDK_INT >= 26) {
                        var6 = (Bitmap)var0.b;
                        break label63;
                     }

                     var3 = (Bitmap)var0.b;
                     break;
                  case 6:
                     int var2 = VERSION.SDK_INT;
                     if (var2 >= 30) {
                        var8 = IconCompat.d.a(var0.d());
                        break label65;
                     }

                     StringBuilder var7;
                     if (var1 == null) {
                        var7 = new StringBuilder();
                        var7.append("Context is required to resolve the file uri of the icon: ");
                        var7.append(var0.d());
                        throw new IllegalArgumentException(var7.toString());
                     }

                     InputStream var5 = var0.e(var1);
                     if (var5 == null) {
                        var7 = new StringBuilder();
                        var7.append("Cannot load adaptive icon from uri: ");
                        var7.append(var0.d());
                        throw new IllegalStateException(var7.toString());
                     }

                     var6 = BitmapFactory.decodeStream(var5);
                     var3 = var6;
                     if (var2 >= 26) {
                        break label63;
                     }
                  }

                  var6 = IconCompat.a(var3, false);
                  break label64;
               }

               var8 = IconCompat.b.b(var6);
               break label65;
            }

            var8 = Icon.createWithBitmap(var6);
         }

         ColorStateList var9 = var0.g;
         if (var9 != null) {
            var8.setTintList(var9);
         }

         Mode var4 = var0.h;
         if (var4 != IconCompat.k) {
            var8.setTintMode(var4);
         }

         return var8;
      }
   }

   static class b {
      static Drawable a(Drawable var0, Drawable var1) {
         return new AdaptiveIconDrawable(var0, var1);
      }

      static Icon b(Bitmap var0) {
         return androidx.core.graphics.drawable.a.a(var0);
      }
   }

   static class c {
      static int a(Object var0) {
         return androidx.core.graphics.drawable.b.a((Icon)var0);
      }

      static String b(Object var0) {
         return androidx.core.graphics.drawable.e.a((Icon)var0);
      }

      static int c(Object var0) {
         return androidx.core.graphics.drawable.d.a((Icon)var0);
      }

      static Uri d(Object var0) {
         return androidx.core.graphics.drawable.c.a((Icon)var0);
      }
   }

   static class d {
      static Icon a(Uri var0) {
         return androidx.core.graphics.drawable.f.a(var0);
      }
   }
}
