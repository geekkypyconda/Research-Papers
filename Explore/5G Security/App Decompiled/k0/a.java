package k0;

import java.nio.ByteBuffer;

public final class a<T> {
   private final k0.b a;
   private final String b;
   private final g<T> c;
   private final k0.b.c d;

   public a(k0.b var1, String var2, g<T> var3) {
      this(var1, var2, var3, (k0.b.c)null);
   }

   public a(k0.b var1, String var2, g<T> var3, k0.b.c var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void c(T var1) {
      this.d(var1, (a.e)null);
   }

   public void d(T var1, a.e<T> var2) {
      k0.b var3 = this.a;
      String var4 = this.b;
      ByteBuffer var5 = this.c.b(var1);
      a.c var6 = null;
      if (var2 != null) {
         var6 = new a.c(var2);
      }

      var3.a(var4, var5, var6);
   }

   public void e(a.d<T> var1) {
      k0.b.c var2 = this.d;
      String var3 = null;
      k0.b var4 = null;
      a.b var5;
      if (var2 != null) {
         k0.b var6 = this.a;
         var3 = this.b;
         if (var1 == null) {
            var5 = var4;
         } else {
            var5 = new a.b(var1);
         }

         var6.b(var3, var5, this.d);
      } else {
         var4 = this.a;
         String var7 = this.b;
         if (var1 == null) {
            var5 = var3;
         } else {
            var5 = new a.b(var1);
         }

         var4.c(var7, var5);
      }

   }

   private final class b implements k0.b.a {
      private final a.d<T> a;

      private b(a.d<T> var2) {
         this.a = var2;
      }

      // $FF: synthetic method
      b(a.d var2, Object var3) {
         this(var2);
      }

      public void a(ByteBuffer var1, k0.b.b var2) {
         try {
            a.d var7 = this.a;
            Object var4 = a.this.c.a(var1);
            a.e var6 = new a.e<T>(var2) {
               // $FF: synthetic field
               final k0.b.b a;
               // $FF: synthetic field
               final a.b b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void a(T var1) {
                  this.a.a(k0.a.a(this.b.b).b(var1));
               }
            };
            var7.a(var4, var6);
         } catch (RuntimeException var5) {
            StringBuilder var3 = new StringBuilder();
            var3.append("BasicMessageChannel#");
            var3.append(a.this.b);
            y.b.c(var3.toString(), "Failed to handle message", var5);
            var2.a((ByteBuffer)null);
         }

      }
   }

   private final class c implements k0.b.b {
      private final a.e<T> a;

      private c(a.e<T> var2) {
         this.a = var2;
      }

      // $FF: synthetic method
      c(a.e var2, Object var3) {
         this(var2);
      }

      public void a(ByteBuffer var1) {
         try {
            this.a.a(a.this.c.a(var1));
         } catch (RuntimeException var3) {
            StringBuilder var4 = new StringBuilder();
            var4.append("BasicMessageChannel#");
            var4.append(a.this.b);
            y.b.c(var4.toString(), "Failed to handle message reply", var3);
         }

      }
   }

   public interface d<T> {
      void a(T var1, a.e<T> var2);
   }

   public interface e<T> {
      void a(T var1);
   }
}
