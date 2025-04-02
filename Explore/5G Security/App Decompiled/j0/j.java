package j0;

import java.util.HashMap;

public class j {
   public final k0.i a;
   private final k0.i.c b;

   public j(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            var2.b((Object)null);
         }
      };
      this.b = var2;
      k0.i var3 = new k0.i(var1, "flutter/navigation", k0.e.a);
      this.a = var3;
      var3.e(var2);
   }

   public void a() {
      y.b.f("NavigationChannel", "Sending message to pop route.");
      this.a.c("popRoute", (Object)null);
   }

   public void b(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Sending message to push route information '");
      var2.append(var1);
      var2.append("'");
      y.b.f("NavigationChannel", var2.toString());
      HashMap var3 = new HashMap();
      var3.put("location", var1);
      this.a.c("pushRouteInformation", var3);
   }

   public void c(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Sending message to set initial route to '");
      var2.append(var1);
      var2.append("'");
      y.b.f("NavigationChannel", var2.toString());
      this.a.c("setInitialRoute", var1);
   }
}
