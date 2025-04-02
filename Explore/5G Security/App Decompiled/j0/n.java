package j0;

import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Map;

public class n {
   public final k0.i a;
   public final PackageManager b;
   private n.b c;
   public final k0.i.c d;

   public n(z.a var1, PackageManager var2) {
      k0.i.c var3 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            if (n.this.c != null) {
               String var3 = var1.a;
               Object var8 = var1.b;
               var3.hashCode();
               IllegalStateException var10000;
               boolean var10001;
               if (!var3.equals("ProcessText.processTextAction")) {
                  if (!var3.equals("ProcessText.queryTextActions")) {
                     var2.c();
                     return;
                  }

                  try {
                     var2.b(n.this.c.c());
                     return;
                  } catch (IllegalStateException var6) {
                     var10000 = var6;
                     var10001 = false;
                  }
               } else {
                  try {
                     ArrayList var4 = (ArrayList)var8;
                     String var10 = (String)var4.get(0);
                     var3 = (String)var4.get(1);
                     boolean var5 = (Boolean)var4.get(2);
                     n.this.c.b(var10, var3, var5, var2);
                     return;
                  } catch (IllegalStateException var7) {
                     var10000 = var7;
                     var10001 = false;
                  }
               }

               IllegalStateException var9 = var10000;
               var2.a("error", var9.getMessage(), (Object)null);
            }
         }
      };
      this.d = var3;
      this.b = var2;
      k0.i var4 = new k0.i(var1, "flutter/processtext", k0.p.b);
      this.a = var4;
      var4.e(var3);
   }

   public void b(n.b var1) {
      this.c = var1;
   }

   public interface b {
      void b(String var1, String var2, boolean var3, k0.i.d var4);

      Map<String, String> c();
   }
}
