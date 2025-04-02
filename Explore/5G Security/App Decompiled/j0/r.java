package j0;

import java.util.HashMap;

public class r {
   public final k0.a<Object> a;

   public r(z.a var1) {
      this.a = new k0.a(var1, "flutter/system", k0.d.a);
   }

   public void a() {
      y.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
      HashMap var1 = new HashMap(1);
      var1.put("type", "memoryPressure");
      this.a.c(var1);
   }
}
