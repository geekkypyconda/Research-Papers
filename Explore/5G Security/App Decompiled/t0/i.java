package t0;

import java.lang.reflect.Method;

final class i {
   public static final i a = new i();
   private static final i.a b = new i.a((Method)null, (Method)null, (Method)null);
   private static i.a c;

   private i() {
   }

   private final i.a a(t0.a var1) {
      try {
         Method var2 = Class.class.getDeclaredMethod("getModule");
         Method var3 = var1.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor");
         Method var7 = var1.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name");
         i.a var4 = new i.a(var2, var3, var7);
         c = var4;
         return var4;
      } catch (Exception var5) {
         i.a var6 = b;
         c = var6;
         return var6;
      }
   }

   public final String b(t0.a var1) {
      a1.k.e(var1, "continuation");
      i.a var2 = c;
      i.a var3 = var2;
      if (var2 == null) {
         var3 = this.a(var1);
      }

      i.a var4 = b;
      var2 = null;
      if (var3 == var4) {
         return null;
      } else {
         Method var7 = var3.a;
         Object var5;
         if (var7 != null) {
            var5 = var7.invoke(var1.getClass());
         } else {
            var5 = null;
         }

         if (var5 == null) {
            return null;
         } else {
            var7 = var3.b;
            if (var7 != null) {
               var5 = var7.invoke(var5);
            } else {
               var5 = null;
            }

            if (var5 == null) {
               return null;
            } else {
               Method var6 = var3.c;
               if (var6 != null) {
                  var5 = var6.invoke(var5);
               } else {
                  var5 = null;
               }

               String var8 = var2;
               if (var5 instanceof String) {
                  var8 = (String)var5;
               }

               return var8;
            }
         }
      }
   }

   private static final class a {
      public final Method a;
      public final Method b;
      public final Method c;

      public a(Method var1, Method var2, Method var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
