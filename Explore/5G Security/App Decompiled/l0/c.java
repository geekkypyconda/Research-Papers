package l0;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import android.os.Build.VERSION;
import j0.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;

public class c {
   private final h a;
   private final Context b;
   final h.b c;

   public c(Context var1, h var2) {
      h.b var3 = new h.b() {
         public String a(String var1, String var2) {
            Context var3 = c.this.b;
            if (var2 != null) {
               Locale var6 = l0.c.b(var2);
               Configuration var5 = new Configuration(c.this.b.getResources().getConfiguration());
               var5.setLocale(var6);
               var3 = c.this.b.createConfigurationContext(var5);
            }

            var2 = c.this.b.getPackageName();
            int var4 = var3.getResources().getIdentifier(var1, "string", var2);
            if (var4 != 0) {
               var1 = var3.getResources().getString(var4);
            } else {
               var1 = null;
            }

            return var1;
         }
      };
      this.c = var3;
      this.b = var1;
      this.a = var2;
      var2.c(var3);
   }

   public static Locale b(String var0) {
      String[] var1 = var0.replace('_', '-').split("-", -1);
      String var2 = var1[0];
      int var3 = var1.length;
      String var4 = "";
      byte var5 = 1;
      if (var3 > 1 && var1[1].length() == 4) {
         var0 = var1[1];
         var5 = 2;
      } else {
         var0 = "";
      }

      String var6 = var4;
      if (var1.length > var5) {
         var6 = var4;
         if (var1[var5].length() >= 2) {
            var6 = var4;
            if (var1[var5].length() <= 3) {
               var6 = var1[var5];
            }
         }
      }

      return new Locale(var2, var6, var0);
   }

   public Locale c(List<Locale> var1) {
      if (var1 != null && !var1.isEmpty()) {
         int var2 = VERSION.SDK_INT;
         Locale var6;
         Locale var15;
         if (var2 >= 26) {
            ArrayList var3 = new ArrayList();
            LocaleList var4 = l0.a.a(this.b.getResources().getConfiguration());
            int var5 = var4.size();

            for(var2 = 0; var2 < var5; ++var2) {
               var6 = var4.get(var2);
               String var7 = var6.getLanguage();
               String var8 = var7;
               StringBuilder var13;
               if (!var6.getScript().isEmpty()) {
                  var13 = new StringBuilder();
                  var13.append(var7);
                  var13.append("-");
                  var13.append(var6.getScript());
                  var8 = var13.toString();
               }

               var7 = var8;
               if (!var6.getCountry().isEmpty()) {
                  StringBuilder var12 = new StringBuilder();
                  var12.append(var8);
                  var12.append("-");
                  var12.append(var6.getCountry());
                  var7 = var12.toString();
               }

               var3.add(new LanguageRange(var7));
               var3.add(new LanguageRange(var6.getLanguage()));
               var13 = new StringBuilder();
               var13.append(var6.getLanguage());
               var13.append("-*");
               var3.add(new LanguageRange(var13.toString()));
            }

            var15 = l0.b.a(var3, var1);
            if (var15 != null) {
               return var15;
            }
         } else {
            Iterator var10;
            Locale var14;
            if (var2 >= 24) {
               LocaleList var16 = l0.a.a(this.b.getResources().getConfiguration());

               for(var2 = 0; var2 < var16.size(); ++var2) {
                  var14 = var16.get(var2);
                  Iterator var11 = var1.iterator();

                  Locale var9;
                  while(var11.hasNext()) {
                     var9 = (Locale)var11.next();
                     if (var14.equals(var9)) {
                        return var9;
                     }
                  }

                  var11 = var1.iterator();

                  while(var11.hasNext()) {
                     var9 = (Locale)var11.next();
                     if (var14.getLanguage().equals(var9.toLanguageTag())) {
                        return var9;
                     }
                  }

                  var10 = var1.iterator();

                  while(var10.hasNext()) {
                     var6 = (Locale)var10.next();
                     if (var14.getLanguage().equals(var6.getLanguage())) {
                        return var6;
                     }
                  }
               }
            } else {
               var15 = this.b.getResources().getConfiguration().locale;
               if (var15 != null) {
                  var10 = var1.iterator();

                  while(var10.hasNext()) {
                     var14 = (Locale)var10.next();
                     if (var15.equals(var14)) {
                        return var14;
                     }
                  }

                  var10 = var1.iterator();

                  while(var10.hasNext()) {
                     var14 = (Locale)var10.next();
                     if (var15.getLanguage().equals(var14.toString())) {
                        return var14;
                     }
                  }
               }
            }
         }

         return (Locale)var1.get(0);
      } else {
         return null;
      }
   }

   public void d(Configuration var1) {
      ArrayList var2 = new ArrayList();
      if (VERSION.SDK_INT >= 24) {
         LocaleList var5 = l0.a.a(var1);
         int var3 = var5.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            var2.add(var5.get(var4));
         }
      } else {
         var2.add(var1.locale);
      }

      this.a.b(var2);
   }
}
