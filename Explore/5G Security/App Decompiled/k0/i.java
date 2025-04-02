package k0;

import java.nio.ByteBuffer;

public class i {
   private final k0.b a;
   private final String b;
   private final j c;
   private final k0.b.c d;

   public i(k0.b var1, String var2, j var3) {
      this(var1, var2, var3, (k0.b.c)null);
   }

   public i(k0.b var1, String var2, j var3, k0.b.c var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void c(String var1, Object var2) {
      this.d(var1, var2, (i.d)null);
   }

   public void d(String var1, Object var2, i.d var3) {
      k0.b var4 = this.a;
      String var5 = this.b;
      ByteBuffer var7 = this.c.b(new h(var1, var2));
      i.b var6;
      if (var3 == null) {
         var6 = null;
      } else {
         var6 = new i.b(var3);
      }

      var4.a(var5, var7, var6);
   }

   public void e(i.c var1) {
      k0.b.c var2 = this.d;
      k0.b var3 = null;
      k0.b var4 = null;
      i.a var5;
      String var6;
      if (var2 != null) {
         var3 = this.a;
         var6 = this.b;
         if (var1 == null) {
            var5 = var4;
         } else {
            var5 = new i.a(var1);
         }

         var3.b(var6, var5, this.d);
      } else {
         var4 = this.a;
         var6 = this.b;
         if (var1 == null) {
            var5 = var3;
         } else {
            var5 = new i.a(var1);
         }

         var4.c(var6, var5);
      }

   }

   private final class a implements k0.b.a {
      private final i.c a;

      a(i.c var2) {
         this.a = var2;
      }

      public void a(ByteBuffer var1, k0.b.b var2) {
         h var3 = i.this.c.c(var1);

         try {
            i.c var6 = this.a;
            i.d var7 = new i.d(var2) {
               // $FF: synthetic field
               final k0.b.b a;
               // $FF: synthetic field
               final i.a b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void a(String var1, String var2, Object var3) {
                  this.a.a(i.a(this.b.b).f(var1, var2, var3));
               }

               public void b(Object var1) {
                  this.a.a(i.a(this.b.b).a(var1));
               }

               public void c() {
                  this.a.a((ByteBuffer)null);
               }
            };
            var6.a(var3, var7);
         } catch (RuntimeException var5) {
            StringBuilder var4 = new StringBuilder();
            var4.append("MethodChannel#");
            var4.append(i.this.b);
            y.b.c(var4.toString(), "Failed to handle method call", var5);
            var2.a(i.this.c.e("error", var5.getMessage(), (Object)null, y.b.d(var5)));
         }

      }
   }

   private final class b implements k0.b.b {
      private final i.d a;

      b(i.d var2) {
         this.a = var2;
      }

      public void a(ByteBuffer param1) {
         // $FF: Couldn't be decompiled
      }
   }

   public interface c {
      void a(h var1, i.d var2);
   }

   public interface d {
      void a(String var1, String var2, Object var3);

      void b(Object var1);

      void c();
   }
}
