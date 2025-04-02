package p0;

import java.io.Serializable;

final class m<T> implements e<T>, Serializable {
   private z0.a<? extends T> e;
   private volatile Object f;
   private final Object g;

   public m(z0.a<? extends T> var1, Object var2) {
      a1.k.e(var1, "initializer");
      super();
      this.e = var1;
      this.f = o.a;
      Object var3 = var2;
      if (var2 == null) {
         var3 = this;
      }

      this.g = var3;
   }

   // $FF: synthetic method
   public m(z0.a var1, Object var2, int var3, a1.g var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   public boolean a() {
      boolean var1;
      if (this.f != o.a) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public T getValue() {
      Object var1 = this.f;
      o var2 = o.a;
      if (var1 != var2) {
         return var1;
      } else {
         Object var3 = this.g;
         synchronized(var3){}

         Throwable var10000;
         label88: {
            boolean var10001;
            try {
               var1 = this.f;
            } catch (Throwable var9) {
               var10000 = var9;
               var10001 = false;
               break label88;
            }

            if (var1 != var2) {
               return var1;
            }

            label77:
            try {
               z0.a var11 = this.e;
               a1.k.b(var11);
               var1 = var11.b();
               this.f = var1;
               this.e = null;
               return var1;
            } catch (Throwable var8) {
               var10000 = var8;
               var10001 = false;
               break label77;
            }
         }

         Throwable var10 = var10000;
         throw var10;
      }
   }

   public String toString() {
      String var1;
      if (this.a()) {
         var1 = String.valueOf(this.getValue());
      } else {
         var1 = "Lazy value not initialized yet.";
      }

      return var1;
   }
}
