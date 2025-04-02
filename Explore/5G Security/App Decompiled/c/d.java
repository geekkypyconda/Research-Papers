package c;

import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class d extends f {
   private final Object a = new Object();
   private final ExecutorService b = Executors.newFixedThreadPool(4, new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(0);

      public Thread newThread(Runnable var1) {
         Thread var2 = new Thread(var1);
         StringBuilder var3 = new StringBuilder();
         var3.append("arch_disk_io_");
         var3.append(this.a.getAndIncrement());
         var2.setName(var3.toString());
         return var2;
      }
   });
   private volatile Handler c;

   private static Handler d(Looper var0) {
      if (VERSION.SDK_INT >= 28) {
         return d.b.a(var0);
      } else {
         try {
            Handler var1 = (Handler)Handler.class.getDeclaredConstructor(Looper.class, Callback.class, Boolean.TYPE).newInstance(var0, null, Boolean.TRUE);
            return var1;
         } catch (InstantiationException | NoSuchMethodException | IllegalAccessException var2) {
            return new Handler(var0);
         } catch (InvocationTargetException var3) {
            return new Handler(var0);
         }
      }
   }

   public void a(Runnable var1) {
      this.b.execute(var1);
   }

   public boolean b() {
      boolean var1;
      if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void c(Runnable var1) {
      if (this.c == null) {
         label150: {
            Object var2 = this.a;
            synchronized(var2){}

            Throwable var10000;
            boolean var10001;
            label144: {
               try {
                  if (this.c == null) {
                     this.c = d(Looper.getMainLooper());
                  }
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label144;
               }

               label141:
               try {
                  break label150;
               } catch (Throwable var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label141;
               }
            }

            while(true) {
               Throwable var15 = var10000;

               try {
                  throw var15;
               } catch (Throwable var12) {
                  var10000 = var12;
                  var10001 = false;
                  continue;
               }
            }
         }
      }

      this.c.post(var1);
   }

   private static class b {
      public static Handler a(Looper var0) {
         return e.a(var0);
      }
   }
}
