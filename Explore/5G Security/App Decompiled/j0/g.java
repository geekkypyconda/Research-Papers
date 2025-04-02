package j0;

import java.util.Locale;

public class g {
   private g.b a;
   private g.b b;
   private boolean c;
   private final k0.a<String> d;

   public g(k0.a<String> var1) {
      this.a = null;
      this.b = null;
      this.c = true;
      this.d = var1;
   }

   public g(z.a var1) {
      this(new k0.a(var1, "flutter/lifecycle", k0.q.b));
   }

   private void g(g.b var1, boolean var2) {
      g.b var3 = this.a;
      if (var3 != var1 || var2 != this.c) {
         if (var1 == null && var3 == null) {
            this.c = var2;
         } else {
            var3 = null;
            int var4 = null.a[var1.ordinal()];
            if (var4 != 1) {
               if (var4 == 2 || var4 == 3 || var4 == 4 || var4 == 5) {
                  var3 = var1;
               }
            } else if (var2) {
               var3 = g.b.f;
            } else {
               var3 = g.b.g;
            }

            this.a = var1;
            this.c = var2;
            if (var3 != this.b) {
               StringBuilder var6 = new StringBuilder();
               var6.append("AppLifecycleState.");
               var6.append(var3.name().toLowerCase(Locale.ROOT));
               String var5 = var6.toString();
               var6 = new StringBuilder();
               var6.append("Sending ");
               var6.append(var5);
               var6.append(" message.");
               y.b.f("LifecycleChannel", var6.toString());
               this.d.c(var5);
               this.b = var3;
            }
         }
      }
   }

   public void a() {
      this.g(this.a, true);
   }

   public void b() {
      this.g(g.b.e, this.c);
   }

   public void c() {
      this.g(g.b.g, this.c);
   }

   public void d() {
      this.g(g.b.i, this.c);
   }

   public void e() {
      this.g(g.b.f, this.c);
   }

   public void f() {
      this.g(this.a, false);
   }

   private static enum b {
      e,
      f,
      g,
      h,
      i;

      // $FF: synthetic method
      private static g.b[] a() {
         return new g.b[]{e, f, g, h, i};
      }
   }
}
