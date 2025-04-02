package j0;

import java.util.HashMap;
import java.util.Map;

public class f {
   public final k0.i a;
   private f.b b;
   public final k0.i.c c;

   public f(k0.b var1) {
      k0.i.c var2 = new k0.i.c() {
         Map<Long, Long> a = new HashMap();

         public void a(k0.h var1, k0.i.d var2) {
            if (f.this.b != null) {
               String var4 = var1.a;
               var4.hashCode();
               if (!var4.equals("getKeyboardState")) {
                  var2.c();
                  return;
               }

               try {
                  this.a = f.this.b.a();
               } catch (IllegalStateException var3) {
                  var2.a("error", var3.getMessage(), (Object)null);
               }
            }

            var2.b(this.a);
         }
      };
      this.c = var2;
      k0.i var3 = new k0.i(var1, "flutter/keyboard", k0.p.b);
      this.a = var3;
      var3.e(var2);
   }

   public void b(f.b var1) {
      this.b = var1;
   }

   public interface b {
      Map<Long, Long> a();
   }
}
