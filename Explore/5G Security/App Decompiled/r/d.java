package r;

import android.graphics.Rect;

public final class d implements c {
   public static final d.a d = new d.a((a1.g)null);
   private final o.b a;
   private final d.b b;
   private final c.b c;

   public d(o.b var1, d.b var2, c.b var3) {
      a1.k.e(var1, "featureBounds");
      a1.k.e(var2, "type");
      a1.k.e(var3, "state");
      super();
      this.a = var1;
      this.b = var2;
      this.c = var3;
      d.a(var1);
   }

   public c.b a() {
      return this.c;
   }

   public c.a b() {
      c.a var1;
      if (this.a.d() != 0 && this.a.a() != 0) {
         var1 = c.a.d;
      } else {
         var1 = c.a.c;
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         Class var2;
         if (var1 != null) {
            var2 = var1.getClass();
         } else {
            var2 = null;
         }

         if (!a1.k.a(d.class, var2)) {
            return false;
         } else {
            a1.k.c(var1, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
            d var3 = (d)var1;
            if (!a1.k.a(this.a, var3.a)) {
               return false;
            } else if (!a1.k.a(this.b, var3.b)) {
               return false;
            } else {
               return a1.k.a(this.a(), var3.a());
            }
         }
      }
   }

   public Rect getBounds() {
      return this.a.f();
   }

   public int hashCode() {
      return (this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.a().hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(d.class.getSimpleName());
      var1.append(" { ");
      var1.append(this.a);
      var1.append(", type=");
      var1.append(this.b);
      var1.append(", state=");
      var1.append(this.a());
      var1.append(" }");
      return var1.toString();
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      public final void a(o.b var1) {
         a1.k.e(var1, "bounds");
         int var2 = var1.d();
         boolean var3 = false;
         boolean var4;
         if (var2 == 0 && var1.a() == 0) {
            var4 = false;
         } else {
            var4 = true;
         }

         if (!var4) {
            throw new IllegalArgumentException("Bounds must be non zero".toString());
         } else {
            label23: {
               if (var1.b() != 0) {
                  var4 = var3;
                  if (var1.c() != 0) {
                     break label23;
                  }
               }

               var4 = true;
            }

            if (!var4) {
               throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
         }
      }
   }

   public static final class b {
      public static final d.b.a b = new d.b.a((a1.g)null);
      private static final d.b c = new d.b("FOLD");
      private static final d.b d = new d.b("HINGE");
      private final String a;

      private b(String var1) {
         this.a = var1;
      }

      public String toString() {
         return this.a;
      }

      public static final class a {
         private a() {
         }

         // $FF: synthetic method
         public a(a1.g var1) {
            this();
         }

         public final d.b a() {
            return d.b.c;
         }

         public final d.b b() {
            return d.b.d;
         }
      }
   }
}
