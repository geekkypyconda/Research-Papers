package g1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class f extends e {
   private static final z0.l<String, String> b(final String var0) {
      boolean var1;
      if (var0.length() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Object var2;
      if (var1) {
         var2 = null.f;
      } else {
         var2 = new z0.l<String, String>() {
            public final String a(String var1) {
               a1.k.e(var1, "line");
               StringBuilder var2 = new StringBuilder();
               var2.append(var0);
               var2.append(var1);
               return var2.toString();
            }
         };
      }

      return (z0.l)var2;
   }

   private static final int c(String var0) {
      int var1 = var0.length();
      int var2 = 0;

      while(true) {
         if (var2 >= var1) {
            var2 = -1;
            break;
         }

         if (a.c(var0.charAt(var2)) ^ true) {
            break;
         }

         ++var2;
      }

      var1 = var2;
      if (var2 == -1) {
         var1 = var0.length();
      }

      return var1;
   }

   public static final String d(String var0, String var1) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "newIndent");
      List var2 = n.E(var0);
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if (d.h((String)var5) ^ true) {
            var3.add(var5);
         }
      }

      ArrayList var17 = new ArrayList(q0.l.j(var3, 10));
      Iterator var14 = var3.iterator();

      while(var14.hasNext()) {
         var17.add(c((String)var14.next()));
      }

      Integer var15 = (Integer)q0.l.p(var17);
      int var6 = 0;
      int var7;
      if (var15 != null) {
         var7 = var15;
      } else {
         var7 = 0;
      }

      int var8 = var0.length();
      int var9 = var1.length();
      int var10 = var2.size();
      z0.l var16 = b(var1);
      int var11 = q0.l.f(var2);
      var17 = new ArrayList();

      for(Iterator var13 = var2.iterator(); var13.hasNext(); ++var6) {
         Object var12 = var13.next();
         if (var6 < 0) {
            q0.l.i();
         }

         var1 = (String)var12;
         if ((var6 == 0 || var6 == var11) && d.h(var1)) {
            var0 = null;
         } else {
            String var18 = p.X(var1, var7);
            var0 = var1;
            if (var18 != null) {
               var0 = (String)var16.i(var18);
               if (var0 == null) {
                  var0 = var1;
               }
            }
         }

         if (var0 != null) {
            var17.add(var0);
         }
      }

      var0 = ((StringBuilder)q0.l.m(var17, new StringBuilder(var8 + var9 * var10), "\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (z0.l)null, 124, (Object)null)).toString();
      a1.k.d(var0, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
      return var0;
   }

   public static String e(String var0) {
      a1.k.e(var0, "<this>");
      return d(var0, "");
   }
}
