package j0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {
   private final k0.i a;
   private a0.a b;
   private Map<String, List<k0.i.d>> c;
   final k0.i.c d;

   public c(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            if (c.this.b != null) {
               String var3 = var1.a;
               Map var4 = (Map)var1.a();
               StringBuilder var7 = new StringBuilder();
               var7.append("Received '");
               var7.append(var3);
               var7.append("' message.");
               y.b.f("DeferredComponentChannel", var7.toString());
               int var5 = (Integer)var4.get("loadingUnitId");
               String var8 = (String)var4.get("componentName");
               var3.hashCode();
               byte var6 = -1;
               switch(var3.hashCode()) {
               case -1004447972:
                  if (var3.equals("uninstallDeferredComponent")) {
                     var6 = 0;
                  }
                  break;
               case 399701758:
                  if (var3.equals("getDeferredComponentInstallState")) {
                     var6 = 1;
                  }
                  break;
               case 520962947:
                  if (var3.equals("installDeferredComponent")) {
                     var6 = 2;
                  }
               }

               switch(var6) {
               case 0:
                  c.this.b.e(var5, var8);
                  var8 = null;
                  break;
               case 1:
                  var8 = c.this.b.a(var5, var8);
                  break;
               case 2:
                  c.this.b.d(var5, var8);
                  if (!c.this.c.containsKey(var8)) {
                     c.this.c.put(var8, new ArrayList());
                  }

                  ((List)c.this.c.get(var8)).add(var2);
                  return;
               default:
                  var2.c();
                  return;
               }

               var2.b(var8);
            }
         }
      };
      this.d = var2;
      k0.i var3 = new k0.i(var1, "flutter/deferredcomponent", k0.p.b);
      this.a = var3;
      var3.e(var2);
      this.b = y.a.e().a();
      this.c = new HashMap();
   }

   public void c(a0.a var1) {
      this.b = var1;
   }
}
