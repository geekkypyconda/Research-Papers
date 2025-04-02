package u0;

import a1.k;
import java.lang.reflect.Method;
import q0.f;

public class a {
   public void a(Throwable var1, Throwable var2) {
      k.e(var1, "cause");
      k.e(var2, "exception");
      Method var3 = u0.a.a.b;
      if (var3 != null) {
         var3.invoke(var1, var2);
      }

   }

   public b1.c b() {
      return new b1.b();
   }

   private static final class a {
      public static final u0.a.a a = new u0.a.a();
      public static final Method b;
      public static final Method c;

      static {
         Method[] var0 = Throwable.class.getMethods();
         k.d(var0, "throwableMethods");
         int var1 = var0.length;
         byte var2 = 0;
         int var3 = 0;

         Object var4;
         Method var5;
         while(true) {
            var4 = null;
            if (var3 >= var1) {
               var5 = null;
               break;
            }

            boolean var7;
            label35: {
               var5 = var0[var3];
               if (k.a(var5.getName(), "addSuppressed")) {
                  Class[] var6 = var5.getParameterTypes();
                  k.d(var6, "it.parameterTypes");
                  if (k.a(f.k(var6), Throwable.class)) {
                     var7 = true;
                     break label35;
                  }
               }

               var7 = false;
            }

            if (var7) {
               break;
            }

            ++var3;
         }

         b = var5;
         int var8 = var0.length;
         var3 = var2;

         while(true) {
            var5 = (Method)var4;
            if (var3 >= var8) {
               break;
            }

            var5 = var0[var3];
            if (k.a(var5.getName(), "getSuppressed")) {
               break;
            }

            ++var3;
         }

         c = var5;
      }
   }
}
