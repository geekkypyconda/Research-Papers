package o;

import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import p0.q;

public final class d {
   private final ClassLoader a;

   public d(ClassLoader var1) {
      a1.k.e(var1, "loader");
      super();
      this.a = var1;
   }

   private final <T> Object a(e1.b<T> var1, z0.l<? super T, q> var2) {
      d.a var3 = new d.a(var1, var2);
      Object var4 = Proxy.newProxyInstance(this.a, new Class[]{this.d()}, var3);
      a1.k.d(var4, "newProxyInstance(loader,…onsumerClass()), handler)");
      return var4;
   }

   private final Class<?> d() {
      Class var1 = this.a.loadClass("java.util.function.Consumer");
      a1.k.d(var1, "loader.loadClass(\"java.util.function.Consumer\")");
      return var1;
   }

   public final Class<?> b() {
      Class var1;
      try {
         var1 = this.d();
      } catch (ClassNotFoundException var2) {
         var1 = null;
      }

      return var1;
   }

   public final <T> d.b c(final Object var1, e1.b<T> var2, String var3, String var4, Activity var5, z0.l<? super T, q> var6) {
      a1.k.e(var1, "obj");
      a1.k.e(var2, "clazz");
      a1.k.e(var3, "addMethodName");
      a1.k.e(var4, "removeMethodName");
      a1.k.e(var5, "activity");
      a1.k.e(var6, "consumer");
      final Object var7 = this.a(var2, var6);
      var1.getClass().getMethod(var3, Activity.class, this.d()).invoke(var1, var5, var7);
      return new d.b(var1.getClass().getMethod(var4, this.d())) {
         // $FF: synthetic field
         final Method a;

         {
            this.a = var1x;
         }

         public void a() {
            this.a.invoke(var1, var7);
         }
      };
   }

   private static final class a<T> implements InvocationHandler {
      private final e1.b<T> a;
      private final z0.l<T, q> b;

      public a(e1.b<T> var1, z0.l<? super T, q> var2) {
         a1.k.e(var1, "clazz");
         a1.k.e(var2, "consumer");
         super();
         this.a = var1;
         this.b = var2;
      }

      private final boolean b(Method var1, Object[] var2) {
         boolean var3 = a1.k.a(var1.getName(), "accept");
         boolean var4 = true;
         if (var3) {
            boolean var5;
            if (var2 != null && var2.length == 1) {
               var5 = true;
            } else {
               var5 = false;
            }

            if (var5) {
               return var4;
            }
         }

         var4 = false;
         return var4;
      }

      private final boolean c(Method var1, Object[] var2) {
         boolean var3 = a1.k.a(var1.getName(), "equals");
         boolean var4 = true;
         if (var3 && var1.getReturnType().equals(Boolean.TYPE)) {
            boolean var5;
            if (var2 != null && var2.length == 1) {
               var5 = true;
            } else {
               var5 = false;
            }

            if (var5) {
               return var4;
            }
         }

         var4 = false;
         return var4;
      }

      private final boolean d(Method var1, Object[] var2) {
         boolean var3;
         if (a1.k.a(var1.getName(), "hashCode") && var1.getReturnType().equals(Integer.TYPE) && var2 == null) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      private final boolean e(Method var1, Object[] var2) {
         boolean var3;
         if (a1.k.a(var1.getName(), "toString") && var1.getReturnType().equals(String.class) && var2 == null) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      public final void a(T var1) {
         a1.k.e(var1, "parameter");
         this.b.i(var1);
      }

      public Object invoke(Object var1, Method var2, Object[] var3) {
         a1.k.e(var1, "obj");
         a1.k.e(var2, "method");
         boolean var4 = this.b(var2, var3);
         Object var5 = null;
         StringBuilder var6 = null;
         boolean var7 = false;
         if (var4) {
            e1.b var8 = this.a;
            var1 = var6;
            if (var3 != null) {
               var1 = var3[0];
            }

            this.a(e1.c.a(var8, var1));
            var1 = q.a;
         } else if (this.c(var2, var3)) {
            Object var9 = var5;
            if (var3 != null) {
               var9 = var3[0];
            }

            if (var1 == var9) {
               var7 = true;
            }

            var1 = var7;
         } else if (this.d(var2, var3)) {
            var1 = this.b.hashCode();
         } else {
            if (!this.e(var2, var3)) {
               var6 = new StringBuilder();
               var6.append("Unexpected method call object:");
               var6.append(var1);
               var6.append(", method: ");
               var6.append(var2);
               var6.append(", args: ");
               var6.append(var3);
               throw new UnsupportedOperationException(var6.toString());
            }

            var1 = this.b.toString();
         }

         return var1;
      }
   }

   public interface b {
      void a();
   }
}
