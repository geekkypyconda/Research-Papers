package i1;

import android.os.Build.VERSION;
import h1.c0;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import r0.g;

public final class b extends r0.a implements c0 {
   private volatile Object _preHandler = this;

   public b() {
      super(c0.a);
   }

   private final Method a() {
      Object var1 = this._preHandler;
      if (var1 != this) {
         return (Method)var1;
      } else {
         Method var12 = null;
         boolean var2 = false;

         label114: {
            Method var3;
            boolean var4;
            label122: {
               boolean var10001;
               try {
                  var3 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler");
               } catch (Throwable var11) {
                  var10001 = false;
                  break label114;
               }

               var4 = var2;

               boolean var5;
               try {
                  if (!Modifier.isPublic(var3.getModifiers())) {
                     break label122;
                  }

                  var5 = Modifier.isStatic(var3.getModifiers());
               } catch (Throwable var10) {
                  var10001 = false;
                  break label114;
               }

               var4 = var2;
               if (var5) {
                  var4 = true;
               }
            }

            if (var4) {
               var12 = var3;
            }
         }

         this._preHandler = var12;
         return var12;
      }
   }

   public void f(g var1, Throwable var2) {
      int var3 = VERSION.SDK_INT;
      boolean var7;
      if (26 <= var3 && var3 < 28) {
         var7 = true;
      } else {
         var7 = false;
      }

      if (var7) {
         Method var5 = this.a();
         UncaughtExceptionHandler var4 = null;
         Object var6;
         if (var5 != null) {
            var6 = var5.invoke((Object)null);
         } else {
            var6 = null;
         }

         if (var6 instanceof UncaughtExceptionHandler) {
            var4 = (UncaughtExceptionHandler)var6;
         }

         if (var4 != null) {
            var4.uncaughtException(Thread.currentThread(), var2);
         }
      }

   }
}
