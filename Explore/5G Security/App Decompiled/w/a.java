package w;

import a1.k;
import android.util.Log;
import e1.b;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class a {
   public static final a a = new a();

   private a() {
   }

   public static final boolean e(String var0, z0.a<Boolean> var1) {
      k.e(var1, "block");
      boolean var2 = false;

      boolean var3;
      String var5;
      StringBuilder var10;
      label45: {
         label50: {
            StringBuilder var4;
            label51: {
               label52: {
                  boolean var10001;
                  try {
                     var3 = (Boolean)var1.b();
                  } catch (ClassNotFoundException var8) {
                     var10001 = false;
                     break label51;
                  } catch (NoSuchMethodException var9) {
                     var10001 = false;
                     break label52;
                  }

                  if (var3 || var0 == null) {
                     return var3;
                  }

                  try {
                     Log.e("ReflectionGuard", var0);
                     return var3;
                  } catch (ClassNotFoundException var6) {
                     var10001 = false;
                     break label51;
                  } catch (NoSuchMethodException var7) {
                     var10001 = false;
                  }
               }

               var4 = new StringBuilder();
               var4.append("NoSuchMethod: ");
               var5 = var0;
               var10 = var4;
               if (var0 != null) {
                  break label45;
               }

               var10 = var4;
               break label50;
            }

            var4 = new StringBuilder();
            var4.append("ClassNotFound: ");
            var5 = var0;
            var10 = var4;
            if (var0 != null) {
               break label45;
            }

            var10 = var4;
         }

         var5 = "";
      }

      var10.append(var5);
      Log.e("ReflectionGuard", var10.toString());
      var3 = var2;
      return var3;
   }

   public final boolean a(z0.a<? extends Class<?>> var1) {
      k.e(var1, "classLoader");
      boolean var2 = false;

      try {
         var1.b();
      } catch (NoClassDefFoundError | ClassNotFoundException var3) {
         return var2;
      }

      var2 = true;
      return var2;
   }

   public final boolean b(Method var1, b<?> var2) {
      k.e(var1, "<this>");
      k.e(var2, "clazz");
      return this.c(var1, y0.a.a(var2));
   }

   public final boolean c(Method var1, Class<?> var2) {
      k.e(var1, "<this>");
      k.e(var2, "clazz");
      return var1.getReturnType().equals(var2);
   }

   public final boolean d(Method var1) {
      k.e(var1, "<this>");
      return Modifier.isPublic(var1.getModifiers());
   }
}
