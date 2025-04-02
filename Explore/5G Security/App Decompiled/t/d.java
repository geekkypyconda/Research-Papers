package t;

import a1.k;
import a1.r;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import p0.q;
import r.j;
import z0.l;

public final class d implements s.a {
   private final WindowLayoutComponent a;
   private final o.d b;
   private final ReentrantLock c;
   private final Map<Context, g> d;
   private final Map<h.a<j>, Context> e;
   private final Map<g, o.d.b> f;

   public d(WindowLayoutComponent var1, o.d var2) {
      k.e(var1, "component");
      k.e(var2, "consumerAdapter");
      super();
      this.a = var1;
      this.b = var2;
      this.c = new ReentrantLock();
      this.d = new LinkedHashMap();
      this.e = new LinkedHashMap();
      this.f = new LinkedHashMap();
   }

   public void a(Context var1, Executor var2, h.a<j> var3) {
      k.e(var1, "context");
      k.e(var2, "executor");
      k.e(var3, "callback");
      ReentrantLock var4 = this.c;
      var4.lock();

      Throwable var10000;
      label306: {
         g var41;
         boolean var10001;
         try {
            var41 = (g)this.d.get(var1);
         } catch (Throwable var37) {
            var10000 = var37;
            var10001 = false;
            break label306;
         }

         q var43;
         if (var41 != null) {
            try {
               var41.b(var3);
               this.e.put(var3, var1);
               var43 = q.a;
            } catch (Throwable var36) {
               var10000 = var36;
               var10001 = false;
               break label306;
            }
         } else {
            var43 = null;
         }

         label307: {
            if (var43 == null) {
               try {
                  var41 = new g(var1);
                  this.d.put(var1, var41);
                  this.e.put(var3, var1);
                  var41.b(var3);
                  if (!(var1 instanceof Activity)) {
                     break label307;
                  }

                  o.d var5 = this.b;
                  WindowLayoutComponent var45 = this.a;
                  e1.b var6 = r.b(WindowLayoutInfo.class);
                  Activity var7 = (Activity)var1;
                  l var38 = new l<WindowLayoutInfo, q>(var41) {
                     public final void l(WindowLayoutInfo var1) {
                        k.e(var1, "p0");
                        ((g)super.f).a(var1);
                     }
                  };
                  o.d.b var39 = var5.c(var45, var6, "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", var7, var38);
                  this.f.put(var41, var39);
               } catch (Throwable var35) {
                  var10000 = var35;
                  var10001 = false;
                  break label306;
               }
            }

            try {
               q var40 = q.a;
            } catch (Throwable var34) {
               var10000 = var34;
               var10001 = false;
               break label306;
            }

            var4.unlock();
            return;
         }

         try {
            WindowLayoutInfo var44 = new WindowLayoutInfo(q0.l.e());
            var41.a(var44);
         } catch (Throwable var33) {
            var10000 = var33;
            var10001 = false;
            break label306;
         }

         var4.unlock();
         return;
      }

      Throwable var42 = var10000;
      var4.unlock();
      throw var42;
   }

   public void b(h.a<j> var1) {
      k.e(var1, "callback");
      ReentrantLock var2 = this.c;
      var2.lock();

      Throwable var10000;
      label300: {
         Context var3;
         boolean var10001;
         try {
            var3 = (Context)this.e.get(var1);
         } catch (Throwable var34) {
            var10000 = var34;
            var10001 = false;
            break label300;
         }

         if (var3 == null) {
            var2.unlock();
            return;
         }

         g var4;
         try {
            var4 = (g)this.d.get(var3);
         } catch (Throwable var33) {
            var10000 = var33;
            var10001 = false;
            break label300;
         }

         if (var4 == null) {
            var2.unlock();
            return;
         }

         label286: {
            o.d.b var35;
            try {
               var4.d(var1);
               this.e.remove(var1);
               if (!var4.c()) {
                  break label286;
               }

               this.d.remove(var3);
               var35 = (o.d.b)this.f.remove(var4);
            } catch (Throwable var32) {
               var10000 = var32;
               var10001 = false;
               break label300;
            }

            if (var35 != null) {
               try {
                  var35.a();
               } catch (Throwable var31) {
                  var10000 = var31;
                  var10001 = false;
                  break label300;
               }
            }
         }

         try {
            q var37 = q.a;
         } catch (Throwable var30) {
            var10000 = var30;
            var10001 = false;
            break label300;
         }

         var2.unlock();
         return;
      }

      Throwable var36 = var10000;
      var2.unlock();
      throw var36;
   }
}
