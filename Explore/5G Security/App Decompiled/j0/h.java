package j0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
   public final k0.i a;
   private h.b b;
   public final k0.i.c c;

   public h(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            if (h.this.b != null) {
               String var3 = var1.a;
               var3.hashCode();
               if (!var3.equals("Localization.getStringResource")) {
                  var2.c();
               } else {
                  JSONObject var6 = (JSONObject)var1.a();

                  JSONException var10000;
                  label43: {
                     boolean var10001;
                     String var7;
                     label33: {
                        try {
                           var3 = var6.getString("key");
                           if (var6.has("locale")) {
                              var7 = var6.getString("locale");
                              break label33;
                           }
                        } catch (JSONException var5) {
                           var10000 = var5;
                           var10001 = false;
                           break label43;
                        }

                        var7 = null;
                     }

                     try {
                        var2.b(h.this.b.a(var3, var7));
                        return;
                     } catch (JSONException var4) {
                        var10000 = var4;
                        var10001 = false;
                     }
                  }

                  JSONException var8 = var10000;
                  var2.a("error", var8.getMessage(), (Object)null);
               }

            }
         }
      };
      this.c = var2;
      k0.i var3 = new k0.i(var1, "flutter/localization", k0.e.a);
      this.a = var3;
      var3.e(var2);
   }

   public void b(List<Locale> var1) {
      y.b.f("LocalizationChannel", "Sending Locales to Flutter.");
      ArrayList var2 = new ArrayList();
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Locale var3 = (Locale)var5.next();
         StringBuilder var4 = new StringBuilder();
         var4.append("Locale (Language: ");
         var4.append(var3.getLanguage());
         var4.append(", Country: ");
         var4.append(var3.getCountry());
         var4.append(", Variant: ");
         var4.append(var3.getVariant());
         var4.append(")");
         y.b.f("LocalizationChannel", var4.toString());
         var2.add(var3.getLanguage());
         var2.add(var3.getCountry());
         var2.add(var3.getScript());
         var2.add(var3.getVariant());
      }

      this.a.c("setLocale", var2);
   }

   public void c(h.b var1) {
      this.b = var1;
   }

   public interface b {
      String a(String var1, String var2);
   }
}
