package j0;

import java.util.HashMap;
import java.util.Map;

public class o {
   public final boolean a;
   private byte[] b;
   private k0.i c;
   private k0.i.d d;
   private boolean e;
   private boolean f;
   private final k0.i.c g;

   o(k0.i var1, boolean var2) {
      this.e = false;
      this.f = false;
      k0.i.c var3 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            String var3 = var1.a;
            Object var4 = var1.b;
            var3.hashCode();
            Map var5;
            if (!var3.equals("get")) {
               if (!var3.equals("put")) {
                  var2.c();
                  return;
               }

               o.this.b = (byte[])var4;
               var5 = null;
            } else {
               o.this.f = true;
               o var6;
               if (!o.this.e) {
                  var6 = o.this;
                  if (var6.a) {
                     var6.d = var2;
                     return;
                  }
               }

               var6 = o.this;
               var5 = var6.i(var6.b);
            }

            var2.b(var5);
         }
      };
      this.g = var3;
      this.c = var1;
      this.a = var2;
      var1.e(var3);
   }

   public o(z.a var1, boolean var2) {
      this(new k0.i(var1, "flutter/restoration", k0.p.b), var2);
   }

   private Map<String, Object> i(byte[] var1) {
      HashMap var2 = new HashMap();
      var2.put("enabled", Boolean.TRUE);
      var2.put("data", var1);
      return var2;
   }

   public void g() {
      this.b = null;
   }

   public byte[] h() {
      return this.b;
   }

   public void j(final byte[] var1) {
      this.e = true;
      k0.i.d var2 = this.d;
      if (var2 != null) {
         var2.b(this.i(var1));
         this.d = null;
      } else if (this.f) {
         this.c.d("push", this.i(var1), new k0.i.d() {
            public void a(String var1x, String var2, Object var3) {
               StringBuilder var4 = new StringBuilder();
               var4.append("Error ");
               var4.append(var1x);
               var4.append(" while sending restoration data to framework: ");
               var4.append(var2);
               y.b.b("RestorationChannel", var4.toString());
            }

            public void b(Object var1x) {
               o.this.b = var1;
            }

            public void c() {
            }
         });
         return;
      }

      this.b = var1;
   }
}
