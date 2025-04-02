package n;

import a1.k;
import java.lang.reflect.Method;

public final class a {
   private final ClassLoader a;

   public a(ClassLoader var1) {
      k.e(var1, "loader");
      super();
      this.a = var1;
   }

   private final Class<?> d() {
      Class var1 = this.a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
      k.d(var1, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
      return var1;
   }

   private final boolean e() {
      return w.a.a.a(new z0.a<Class<?>>() {
         public final Class<?> a() {
            Class var1 = a.this.a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
            k.d(var1, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            return var1;
         }
      });
   }

   public final Class<?> c() {
      Class var1 = this.a.loadClass("androidx.window.extensions.WindowExtensions");
      k.d(var1, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
      return var1;
   }

   public final boolean f() {
      boolean var1;
      if (this.e() && w.a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new z0.a<Boolean>() {
         public final Boolean a() {
            Class var1 = a.this.d();
            boolean var2 = false;
            Method var3 = var1.getDeclaredMethod("getWindowExtensions");
            var1 = a.this.c();
            w.a var4 = w.a.a;
            k.d(var3, "getWindowExtensionsMethod");
            boolean var5 = var2;
            if (var4.c(var3, var1)) {
               var5 = var2;
               if (var4.d(var3)) {
                  var5 = true;
               }
            }

            return var5;
         }
      })) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
