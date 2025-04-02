package p0;

import java.io.Serializable;

public final class k<T> implements Serializable {
   public static final k.a e = new k.a((a1.g)null);

   public static <T> Object a(Object var0) {
      return var0;
   }

   public static final Throwable b(Object var0) {
      Throwable var1;
      if (var0 instanceof k.b) {
         var1 = ((k.b)var0).e;
      } else {
         var1 = null;
      }

      return var1;
   }

   public static final boolean c(Object var0) {
      return var0 instanceof k.b;
   }

   public static final boolean d(Object var0) {
      return var0 instanceof k.b ^ true;
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }
   }

   public static final class b implements Serializable {
      public final Throwable e;

      public b(Throwable var1) {
         a1.k.e(var1, "exception");
         super();
         this.e = var1;
      }

      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof k.b && a1.k.a(this.e, ((k.b)var1).e)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public int hashCode() {
         return this.e.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Failure(");
         var1.append(this.e);
         var1.append(')');
         return var1.toString();
      }
   }
}
