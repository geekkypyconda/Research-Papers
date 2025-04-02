package k0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class p implements j {
   public static final p b;
   private final o a;

   static {
      b = new p(o.a);
   }

   public p(o var1) {
      this.a = var1;
   }

   public ByteBuffer a(Object var1) {
      o.a var2 = new o.a();
      var2.write(0);
      this.a.p(var2, var1);
      ByteBuffer var3 = ByteBuffer.allocateDirect(var2.size());
      var3.put(var2.a(), 0, var2.size());
      return var3;
   }

   public ByteBuffer b(h var1) {
      o.a var2 = new o.a();
      this.a.p(var2, var1.a);
      this.a.p(var2, var1.b);
      ByteBuffer var3 = ByteBuffer.allocateDirect(var2.size());
      var3.put(var2.a(), 0, var2.size());
      return var3;
   }

   public h c(ByteBuffer var1) {
      var1.order(ByteOrder.nativeOrder());
      Object var2 = this.a.f(var1);
      Object var3 = this.a.f(var1);
      if (var2 instanceof String && !var1.hasRemaining()) {
         return new h((String)var2, var3);
      } else {
         throw new IllegalArgumentException("Method call corrupted");
      }
   }

   public Object d(ByteBuffer var1) {
      var1.order(ByteOrder.nativeOrder());
      byte var2 = var1.get();
      Object var3;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalArgumentException("Envelope corrupted");
         }
      } else {
         var3 = this.a.f(var1);
         if (!var1.hasRemaining()) {
            return var3;
         }
      }

      Object var4 = this.a.f(var1);
      var3 = this.a.f(var1);
      Object var5 = this.a.f(var1);
      if (var4 instanceof String && (var3 == null || var3 instanceof String) && !var1.hasRemaining()) {
         throw new c((String)var4, (String)var3, var5);
      } else {
         throw new IllegalArgumentException("Envelope corrupted");
      }
   }

   public ByteBuffer e(String var1, String var2, Object var3, String var4) {
      o.a var5 = new o.a();
      var5.write(1);
      this.a.p(var5, var1);
      this.a.p(var5, var2);
      if (var3 instanceof Throwable) {
         this.a.p(var5, y.b.d((Throwable)var3));
      } else {
         this.a.p(var5, var3);
      }

      this.a.p(var5, var4);
      ByteBuffer var6 = ByteBuffer.allocateDirect(var5.size());
      var6.put(var5.a(), 0, var5.size());
      return var6;
   }

   public ByteBuffer f(String var1, String var2, Object var3) {
      o.a var4 = new o.a();
      var4.write(1);
      this.a.p(var4, var1);
      this.a.p(var4, var2);
      if (var3 instanceof Throwable) {
         this.a.p(var4, y.b.d((Throwable)var3));
      } else {
         this.a.p(var4, var3);
      }

      ByteBuffer var5 = ByteBuffer.allocateDirect(var4.size());
      var5.put(var4.a(), 0, var4.size());
      return var5;
   }
}
