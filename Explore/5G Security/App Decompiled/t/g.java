package t;

import a1.k;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import p0.q;
import r.j;

public final class g implements h.a<WindowLayoutInfo>, Consumer<WindowLayoutInfo> {
   private final Context a;
   private final ReentrantLock b;
   private j c;
   private final Set<h.a<j>> d;

   public g(Context var1) {
      k.e(var1, "context");
      super();
      this.a = var1;
      this.b = new ReentrantLock();
      this.d = new LinkedHashSet();
   }

   public void a(WindowLayoutInfo var1) {
      k.e(var1, "value");
      ReentrantLock var2 = this.b;
      var2.lock();

      label133: {
         Throwable var10000;
         label132: {
            boolean var10001;
            Iterator var15;
            try {
               this.c = f.a.b(this.a, var1);
               var15 = this.d.iterator();
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label132;
            }

            while(true) {
               try {
                  if (var15.hasNext()) {
                     ((h.a)var15.next()).accept(this.c);
                     continue;
                  }
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break;
               }

               try {
                  q var17 = q.a;
                  break label133;
               } catch (Throwable var12) {
                  var10000 = var12;
                  var10001 = false;
                  break;
               }
            }
         }

         Throwable var16 = var10000;
         var2.unlock();
         throw var16;
      }

      var2.unlock();
   }

   public final void b(h.a<j> var1) {
      k.e(var1, "listener");
      ReentrantLock var2 = this.b;
      var2.lock();

      label112: {
         Throwable var10000;
         label116: {
            boolean var10001;
            j var3;
            try {
               var3 = this.c;
            } catch (Throwable var15) {
               var10000 = var15;
               var10001 = false;
               break label116;
            }

            if (var3 != null) {
               try {
                  var1.accept(var3);
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label116;
               }
            }

            label104:
            try {
               this.d.add(var1);
               break label112;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label104;
            }
         }

         Throwable var16 = var10000;
         var2.unlock();
         throw var16;
      }

      var2.unlock();
   }

   public final boolean c() {
      return this.d.isEmpty();
   }

   public final void d(h.a<j> var1) {
      k.e(var1, "listener");
      ReentrantLock var2 = this.b;
      var2.lock();

      try {
         this.d.remove(var1);
      } finally {
         var2.unlock();
      }

   }
}
