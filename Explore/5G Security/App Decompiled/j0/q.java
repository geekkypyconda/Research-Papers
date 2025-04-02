package j0;

import java.util.ArrayList;

public class q {
   public final k0.i a;
   private q.b b;
   public final k0.i.c c;

   public q(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            if (q.this.b == null) {
               y.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
            } else {
               String var3 = var1.a;
               Object var6 = var1.b;
               StringBuilder var4 = new StringBuilder();
               var4.append("Received '");
               var4.append(var3);
               var4.append("' message.");
               y.b.f("SpellCheckChannel", var4.toString());
               var3.hashCode();
               if (!var3.equals("SpellCheck.initiateSpellCheck")) {
                  var2.c();
               } else {
                  try {
                     ArrayList var8 = (ArrayList)var6;
                     String var7 = (String)var8.get(0);
                     var3 = (String)var8.get(1);
                     q.this.b.a(var7, var3, var2);
                  } catch (IllegalStateException var5) {
                     var2.a("error", var5.getMessage(), (Object)null);
                  }
               }

            }
         }
      };
      this.c = var2;
      k0.i var3 = new k0.i(var1, "flutter/spellcheck", k0.p.b);
      this.a = var3;
      var3.e(var2);
   }

   public void b(q.b var1) {
      this.b = var1;
   }

   public interface b {
      void a(String var1, String var2, k0.i.d var3);
   }
}
