package v0;

import a1.k;

public class a extends u0.a {
   private final boolean c(int var1) {
      Integer var2 = v0.a.a.b;
      boolean var3;
      if (var2 != null && var2 < var1) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   public void a(Throwable var1, Throwable var2) {
      k.e(var1, "cause");
      k.e(var2, "exception");
      if (this.c(19)) {
         var1.addSuppressed(var2);
      } else {
         super.a(var1, var2);
      }

   }

   private static final class a {
      public static final v0.a.a a = new v0.a.a();
      public static final Integer b;

      static {
         Object var0 = null;

         Object var1;
         label56: {
            label55:
            try {
               var1 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object)null);
               if (var1 instanceof Integer) {
                  Integer var6 = (Integer)var1;
                  break label56;
               }
            } finally {
               break label55;
            }

            var1 = null;
         }

         Object var2 = var0;
         if (var1 != null) {
            boolean var3;
            if (((Number)var1).intValue() > 0) {
               var3 = true;
            } else {
               var3 = false;
            }

            var2 = var0;
            if (var3) {
               var2 = var1;
            }
         }

         b = (Integer)var2;
      }
   }
}
