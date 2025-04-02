package b0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
   public static final String a;
   public static final String b;
   public static final String c;
   public static final String d;

   static {
      StringBuilder var0 = new StringBuilder();
      var0.append(d.class.getName());
      var0.append('.');
      var0.append("aot-shared-library-name");
      a = var0.toString();
      var0 = new StringBuilder();
      var0.append(d.class.getName());
      var0.append('.');
      var0.append("vm-snapshot-data");
      b = var0.toString();
      var0 = new StringBuilder();
      var0.append(d.class.getName());
      var0.append('.');
      var0.append("isolate-snapshot-data");
      c = var0.toString();
      var0 = new StringBuilder();
      var0.append(d.class.getName());
      var0.append('.');
      var0.append("flutter-assets-dir");
      d = var0.toString();
   }

   private static ApplicationInfo a(Context var0) {
      try {
         ApplicationInfo var2 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
         return var2;
      } catch (NameNotFoundException var1) {
         throw new RuntimeException(var1);
      }
   }

   private static boolean b(Bundle var0, String var1, boolean var2) {
      return var0 == null ? var2 : var0.getBoolean(var1, var2);
   }

   private static String c(ApplicationInfo var0, Context var1) {
      Bundle var6 = var0.metaData;
      if (var6 == null) {
         return null;
      } else {
         int var2 = var6.getInt("io.flutter.network-policy", 0);
         if (var2 <= 0) {
            return null;
         } else {
            JSONArray var7 = new JSONArray();

            boolean var10001;
            XmlResourceParser var8;
            try {
               var8 = var1.getResources().getXml(var2);
               var8.next();
               var2 = var8.getEventType();
            } catch (XmlPullParserException | IOException var5) {
               var10001 = false;
               return null;
            }

            while(true) {
               if (var2 == 1) {
                  return var7.toString();
               }

               if (var2 == 2) {
                  try {
                     if (var8.getName().equals("domain-config")) {
                        g(var8, var7, false);
                     }
                  } catch (XmlPullParserException | IOException var4) {
                     var10001 = false;
                     break;
                  }
               }

               try {
                  var2 = var8.next();
               } catch (XmlPullParserException | IOException var3) {
                  var10001 = false;
                  break;
               }
            }

            return null;
         }
      }
   }

   private static String d(Bundle var0, String var1) {
      return var0 == null ? null : var0.getString(var1, (String)null);
   }

   public static b e(Context var0) {
      ApplicationInfo var1 = a(var0);
      return new b(d(var1.metaData, a), d(var1.metaData, b), d(var1.metaData, c), d(var1.metaData, d), c(var1, var0), var1.nativeLibraryDir, b(var1.metaData, "io.flutter.automatically-register-plugins", true));
   }

   private static void f(XmlResourceParser var0, JSONArray var1, boolean var2) {
      boolean var3 = var0.getAttributeBooleanValue((String)null, "includeSubdomains", false);
      var0.next();
      if (var0.getEventType() == 4) {
         String var4 = var0.getText().trim();
         JSONArray var5 = new JSONArray();
         var5.put(var4);
         var5.put(var3);
         var5.put(var2);
         var1.put(var5);
         var0.next();
         if (var0.getEventType() != 3) {
            throw new IllegalStateException("Expected end of domain tag");
         }
      } else {
         throw new IllegalStateException("Expected text");
      }
   }

   private static void g(XmlResourceParser var0, JSONArray var1, boolean var2) {
      var2 = var0.getAttributeBooleanValue((String)null, "cleartextTrafficPermitted", var2);

      while(true) {
         while(true) {
            int var3 = var0.next();
            if (var3 == 2) {
               if (var0.getName().equals("domain")) {
                  f(var0, var1, var2);
               } else if (var0.getName().equals("domain-config")) {
                  g(var0, var1, var2);
               } else {
                  h(var0);
               }
            } else if (var3 == 3) {
               return;
            }
         }
      }
   }

   private static void h(XmlResourceParser var0) {
      String var1 = var0.getName();

      for(int var2 = var0.getEventType(); var2 != 3 || var0.getName() != var1; var2 = var0.next()) {
      }

   }
}
