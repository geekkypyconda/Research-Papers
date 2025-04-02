package j0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class k {
   public final k0.i a;
   private j0.k.h b;
   final k0.i.c c;

   public k(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h param1, k0.i.d param2) {
            // $FF: Couldn't be decompiled
         }
      };
      this.c = var2;
      k0.i var3 = new k0.i(var1, "flutter/platform", k0.e.a);
      this.a = var3;
      var3.e(var2);
   }

   // $FF: synthetic method
   static j0.k.h a(j0.k var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static int b(j0.k var0, JSONArray var1) {
      return var0.h(var1);
   }

   // $FF: synthetic method
   static j0.k.c c(j0.k var0, JSONObject var1) {
      return var0.g(var1);
   }

   // $FF: synthetic method
   static List d(j0.k var0, JSONArray var1) {
      return var0.k(var1);
   }

   // $FF: synthetic method
   static j0.k.k e(j0.k var0, String var1) {
      return var0.j(var1);
   }

   // $FF: synthetic method
   static j0.k.j f(j0.k var0, JSONObject var1) {
      return var0.i(var1);
   }

   private j0.k.c g(JSONObject var1) {
      int var2 = var1.getInt("primaryColor");
      int var3 = var2;
      if (var2 != 0) {
         var3 = var2 | -16777216;
      }

      return new j0.k.c(var3, var1.getString("label"));
   }

   private int h(JSONArray var1) {
      int var2 = 0;
      int var3 = 0;

      int var4;
      int var6;
      for(var4 = 0; var2 < var1.length(); var4 = var6) {
         j0.k.f var5 = j0.k.f.b(var1.getString(var2));
         var6 = null.a[var5.ordinal()];
         if (var6 != 1) {
            if (var6 != 2) {
               if (var6 != 3) {
                  if (var6 == 4) {
                     var3 |= 8;
                  }
               } else {
                  var3 |= 2;
               }
            } else {
               var3 |= 4;
            }
         } else {
            var3 |= 1;
         }

         var6 = var4;
         if (var4 == 0) {
            var6 = var3;
         }

         ++var2;
      }

      if (var3 == 0) {
         return -1;
      } else {
         byte var7 = 9;
         switch(var3) {
         case 3:
         case 6:
         case 7:
         case 9:
         case 12:
         case 13:
         case 14:
            if (var4 != 2) {
               if (var4 == 4) {
                  return 9;
               }

               if (var4 == 8) {
                  return 8;
               }
               break;
            }
         case 2:
            return 0;
         case 4:
            return var7;
         case 5:
            var7 = 12;
            return var7;
         case 8:
            return 8;
         case 10:
            return 11;
         case 11:
            return 2;
         case 15:
            return 13;
         }

         return 1;
      }
   }

   private j0.k.j i(JSONObject var1) {
      boolean var2 = var1.isNull("statusBarColor");
      Boolean var3 = null;
      Integer var4;
      if (!var2) {
         var4 = var1.getInt("statusBarColor");
      } else {
         var4 = null;
      }

      j0.k.d var5;
      if (!var1.isNull("statusBarIconBrightness")) {
         var5 = j0.k.d.b(var1.getString("statusBarIconBrightness"));
      } else {
         var5 = null;
      }

      Boolean var6;
      if (!var1.isNull("systemStatusBarContrastEnforced")) {
         var6 = var1.getBoolean("systemStatusBarContrastEnforced");
      } else {
         var6 = null;
      }

      Integer var7;
      if (!var1.isNull("systemNavigationBarColor")) {
         var7 = var1.getInt("systemNavigationBarColor");
      } else {
         var7 = null;
      }

      j0.k.d var8;
      if (!var1.isNull("systemNavigationBarIconBrightness")) {
         var8 = j0.k.d.b(var1.getString("systemNavigationBarIconBrightness"));
      } else {
         var8 = null;
      }

      Integer var9;
      if (!var1.isNull("systemNavigationBarDividerColor")) {
         var9 = var1.getInt("systemNavigationBarDividerColor");
      } else {
         var9 = null;
      }

      if (!var1.isNull("systemNavigationBarContrastEnforced")) {
         var3 = var1.getBoolean("systemNavigationBarContrastEnforced");
      }

      return new j0.k.j(var4, var5, var6, var7, var8, var9, var3);
   }

   private j0.k.k j(String var1) {
      j0.k.k var3 = j0.k.k.b(var1);
      int var2 = null.c[var3.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               return var2 != 4 ? j0.k.k.i : j0.k.k.i;
            } else {
               return j0.k.k.h;
            }
         } else {
            return j0.k.k.g;
         }
      } else {
         return j0.k.k.f;
      }
   }

   private List<j0.k.l> k(JSONArray var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         j0.k.l var4 = j0.k.l.b(var1.getString(var3));
         int var5 = null.b[var4.ordinal()];
         if (var5 != 1) {
            if (var5 != 2) {
               continue;
            }

            var4 = j0.k.l.g;
         } else {
            var4 = j0.k.l.f;
         }

         var2.add(var4);
      }

      return var2;
   }

   public void l(j0.k.h var1) {
      this.b = var1;
   }

   public void m(boolean var1) {
      y.b.f("PlatformChannel", "Sending 'systemUIChange' message.");
      this.a.c("SystemChrome.systemUIChange", Arrays.asList(var1));
   }

   public static class c {
      public final int a;
      public final String b;

      public c(int var1, String var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   public static enum d {
      f("Brightness.light"),
      g("Brightness.dark");

      private String e;

      private d(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static j0.k.d[] a() {
         return new j0.k.d[]{f, g};
      }

      static j0.k.d b(String var0) {
         j0.k.d[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            j0.k.d var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such Brightness: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }

   public static enum e {
      f("text/plain");

      private String e;

      private e(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static j0.k.e[] a() {
         return new j0.k.e[]{f};
      }

      static j0.k.e b(String var0) {
         j0.k.e[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            j0.k.e var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such ClipboardContentFormat: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }

   public static enum f {
      f("DeviceOrientation.portraitUp"),
      g("DeviceOrientation.portraitDown"),
      h("DeviceOrientation.landscapeLeft"),
      i("DeviceOrientation.landscapeRight");

      private String e;

      private f(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static j0.k.f[] a() {
         return new j0.k.f[]{f, g, h, i};
      }

      static j0.k.f b(String var0) {
         j0.k.f[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            j0.k.f var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such DeviceOrientation: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }

   public static enum g {
      f((String)null),
      g("HapticFeedbackType.lightImpact"),
      h("HapticFeedbackType.mediumImpact"),
      i("HapticFeedbackType.heavyImpact"),
      j("HapticFeedbackType.selectionClick");

      private final String e;

      private g(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static j0.k.g[] a() {
         return new j0.k.g[]{f, g, h, i, j};
      }

      static j0.k.g b(String var0) {
         j0.k.g[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            j0.k.g var4 = var1[var3];
            String var5 = var4.e;
            if (var5 == null && var0 == null || var5 != null && var5.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var6 = new StringBuilder();
         var6.append("No such HapticFeedbackType: ");
         var6.append(var0);
         throw new NoSuchFieldException(var6.toString());
      }
   }

   public interface h {
      void a();

      void b(j0.k.g var1);

      void c();

      void d(j0.k.j var1);

      void e();

      void f(String var1);

      void g(int var1);

      void h(boolean var1);

      void i(List<j0.k.l> var1);

      void j(String var1);

      void k(j0.k.c var1);

      void l(j0.k.k var1);

      boolean m();

      CharSequence n(j0.k.e var1);

      void o(j0.k.i var1);
   }

   public static enum i {
      f("SystemSoundType.click"),
      g("SystemSoundType.alert");

      private final String e;

      private i(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static j0.k.i[] a() {
         return new j0.k.i[]{f, g};
      }

      static j0.k.i b(String var0) {
         j0.k.i[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            j0.k.i var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such SoundType: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }

   public static class j {
      public final Integer a;
      public final j0.k.d b;
      public final Boolean c;
      public final Integer d;
      public final j0.k.d e;
      public final Integer f;
      public final Boolean g;

      public j(Integer var1, j0.k.d var2, Boolean var3, Integer var4, j0.k.d var5, Integer var6, Boolean var7) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
      }
   }

   public static enum k {
      f("SystemUiMode.leanBack"),
      g("SystemUiMode.immersive"),
      h("SystemUiMode.immersiveSticky"),
      i("SystemUiMode.edgeToEdge");

      private String e;

      private k(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static j0.k.k[] a() {
         return new j0.k.k[]{f, g, h, i};
      }

      static j0.k.k b(String var0) {
         j0.k.k[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            j0.k.k var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such SystemUiMode: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }

   public static enum l {
      f("SystemUiOverlay.top"),
      g("SystemUiOverlay.bottom");

      private String e;

      private l(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static j0.k.l[] a() {
         return new j0.k.l[]{f, g};
      }

      static j0.k.l b(String var0) {
         j0.k.l[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            j0.k.l var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such SystemUiOverlay: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }
}
