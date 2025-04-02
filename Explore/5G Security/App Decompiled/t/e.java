package t;

import a1.k;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import p0.q;
import r.j;

public final class e implements s.a {
   private final WindowLayoutComponent a;
   private final ReentrantLock b;
   private final Map<Context, g> c;
   private final Map<h.a<j>, Context> d;

   public e(WindowLayoutComponent var1) {
      k.e(var1, "component");
      super();
      this.a = var1;
      this.b = new ReentrantLock();
      this.c = new LinkedHashMap();
      this.d = new LinkedHashMap();
   }

   public void a(Context var1, Executor var2, h.a<j> var3) {
      k.e(var1, "context");
      k.e(var2, "executor");
      k.e(var3, "callback");
      ReentrantLock var4 = this.b;
      var4.lock();

      label182: {
         Throwable var10000;
         label186: {
            boolean var10001;
            g var27;
            try {
               var27 = (g)this.c.get(var1);
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label186;
            }

            q var28;
            if (var27 != null) {
               try {
                  var27.b(var3);
                  this.d.put(var3, var1);
                  var28 = q.a;
               } catch (Throwable var23) {
                  var10000 = var23;
                  var10001 = false;
                  break label186;
               }
            } else {
               var28 = null;
            }

            if (var28 == null) {
               try {
                  var27 = new g(var1);
                  this.c.put(var1, var27);
                  this.d.put(var3, var1);
                  var27.b(var3);
                  this.a.addWindowLayoutInfoListener(var1, var27);
               } catch (Throwable var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label186;
               }
            }

            label170:
            try {
               q var26 = q.a;
               break label182;
            } catch (Throwable var21) {
               var10000 = var21;
               var10001 = false;
               break label170;
            }
         }

         Throwable var25 = var10000;
         var4.unlock();
         throw var25;
      }

      var4.unlock();
   }

   public void b(h.a<j> var1) {
      k.e(var1, "callback");
      ReentrantLock var2 = this.b;
      var2.lock();

      Throwable var10000;
      label220: {
         Context var3;
         boolean var10001;
         try {
            var3 = (Context)this.d.get(var1);
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label220;
         }

         if (var3 == null) {
            var2.unlock();
            return;
         }

         g var4;
         try {
            var4 = (g)this.c.get(var3);
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            break label220;
         }

         if (var4 == null) {
            var2.unlock();
            return;
         }

         try {
            var4.d(var1);
            this.d.remove(var1);
            if (var4.c()) {
               this.c.remove(var3);
               this.a.removeWindowLayoutInfoListener(var4);
            }
         } catch (Throwable var22) {
            var10000 = var22;
            var10001 = false;
            break label220;
         }

         try {
            q var26 = q.a;
         } catch (Throwable var21) {
            var10000 = var21;
            var10001 = false;
            break label220;
         }

         var2.unlock();
         return;
      }

      Throwable var25 = var10000;
      var2.unlock();
      throw var25;
   }
}
