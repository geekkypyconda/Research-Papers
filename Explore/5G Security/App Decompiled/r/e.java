package r;

import a1.r;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;

public final class e {
   private final ClassLoader a;
   private final o.d b;
   private final n.a c;

   public e(ClassLoader var1, o.d var2) {
      a1.k.e(var1, "loader");
      a1.k.e(var2, "consumerAdapter");
      super();
      this.a = var1;
      this.b = var2;
      this.c = new n.a(var1);
   }

   private final boolean e() {
      boolean var1 = this.n();
      boolean var2 = false;
      if (!var1) {
         return false;
      } else {
         int var3 = o.e.a.a();
         boolean var4 = true;
         if (var3 == 1) {
            var2 = this.i();
         } else {
            if (2 > var3 || var3 > Integer.MAX_VALUE) {
               var4 = false;
            }

            if (var4) {
               var2 = this.j();
            }
         }

         return var2;
      }
   }

   private final Class<?> f() {
      Class var1 = this.a.loadClass("androidx.window.extensions.layout.FoldingFeature");
      a1.k.d(var1, "loader.loadClass(FOLDING_FEATURE_CLASS)");
      return var1;
   }

   private final Class<?> h() {
      Class var1 = this.a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
      a1.k.d(var1, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
      return var1;
   }

   private final boolean k() {
      return w.a.e("FoldingFeature class is not valid", new z0.a<Boolean>() {
         public final Boolean a() {
            Class var1 = e.this.f();
            boolean var2 = false;
            Method var3 = var1.getMethod("getBounds");
            Method var4 = var1.getMethod("getType");
            Method var7 = var1.getMethod("getState");
            w.a var5 = w.a.a;
            a1.k.d(var3, "getBoundsMethod");
            boolean var6 = var2;
            if (var5.b(var3, r.b(Rect.class))) {
               var6 = var2;
               if (var5.d(var3)) {
                  a1.k.d(var4, "getTypeMethod");
                  Class var8 = Integer.TYPE;
                  var6 = var2;
                  if (var5.b(var4, r.b(var8))) {
                     var6 = var2;
                     if (var5.d(var4)) {
                        a1.k.d(var7, "getStateMethod");
                        var6 = var2;
                        if (var5.b(var7, r.b(var8))) {
                           var6 = var2;
                           if (var5.d(var7)) {
                              var6 = true;
                           }
                        }
                     }
                  }
               }
            }

            return var6;
         }
      });
   }

   private final boolean l() {
      StringBuilder var1 = new StringBuilder();
      var1.append("WindowLayoutComponent#addWindowLayoutInfoListener(");
      var1.append(Activity.class.getName());
      var1.append(", java.util.function.Consumer) is not valid");
      return w.a.e(var1.toString(), new z0.a<Boolean>() {
         public final Boolean a() {
            Class var1 = e.this.b.b();
            if (var1 == null) {
               return Boolean.FALSE;
            } else {
               Class var2 = e.this.h();
               boolean var3 = false;
               Method var4 = var2.getMethod("addWindowLayoutInfoListener", Activity.class, var1);
               Method var7 = var2.getMethod("removeWindowLayoutInfoListener", var1);
               w.a var6 = w.a.a;
               a1.k.d(var4, "addListenerMethod");
               boolean var5 = var3;
               if (var6.d(var4)) {
                  a1.k.d(var7, "removeListenerMethod");
                  var5 = var3;
                  if (var6.d(var7)) {
                     var5 = true;
                  }
               }

               return var5;
            }
         }
      });
   }

   private final boolean m() {
      StringBuilder var1 = new StringBuilder();
      var1.append("WindowLayoutComponent#addWindowLayoutInfoListener(");
      var1.append(Context.class.getName());
      var1.append(", androidx.window.extensions.core.util.function.Consumer) is not valid");
      return w.a.e(var1.toString(), new z0.a<Boolean>() {
         public final Boolean a() {
            Class var1 = e.this.h();
            boolean var2 = false;
            Method var3 = var1.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
            Method var6 = var1.getMethod("removeWindowLayoutInfoListener", Consumer.class);
            w.a var4 = w.a.a;
            a1.k.d(var3, "addListenerMethod");
            boolean var5 = var2;
            if (var4.d(var3)) {
               a1.k.d(var6, "removeListenerMethod");
               var5 = var2;
               if (var4.d(var6)) {
                  var5 = true;
               }
            }

            return var5;
         }
      });
   }

   private final boolean o() {
      return w.a.e("WindowExtensions#getWindowLayoutComponent is not valid", new z0.a<Boolean>() {
         public final Boolean a() {
            Class var1 = e.this.c.c();
            boolean var2 = false;
            Method var6 = var1.getMethod("getWindowLayoutComponent");
            Class var3 = e.this.h();
            w.a var4 = w.a.a;
            a1.k.d(var6, "getWindowLayoutComponentMethod");
            boolean var5 = var2;
            if (var4.d(var6)) {
               var5 = var2;
               if (var4.c(var6, var3)) {
                  var5 = true;
               }
            }

            return var5;
         }
      });
   }

   public final WindowLayoutComponent g() {
      boolean var1 = this.e();
      Object var2 = null;
      WindowLayoutComponent var3 = (WindowLayoutComponent)var2;
      if (var1) {
         try {
            var3 = WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
         } catch (UnsupportedOperationException var4) {
            var3 = (WindowLayoutComponent)var2;
         }
      }

      return var3;
   }

   public final boolean i() {
      return this.l();
   }

   public final boolean j() {
      boolean var1;
      if (this.i() && this.m()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean n() {
      boolean var1;
      if (this.c.f() && this.o() && this.k()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
