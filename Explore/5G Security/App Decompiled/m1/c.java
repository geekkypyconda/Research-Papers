package m1;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class c {
   private static final Method a;

   static {
      Method var0;
      try {
         var0 = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
      } finally {
         ;
      }

      a = var0;
   }

   public static final boolean a(Executor var0) {
      boolean var10001;
      ScheduledThreadPoolExecutor var14;
      label143: {
         try {
            if (var0 instanceof ScheduledThreadPoolExecutor) {
               var14 = (ScheduledThreadPoolExecutor)var0;
               break label143;
            }
         } catch (Throwable var13) {
            var10001 = false;
            return false;
         }

         var14 = null;
      }

      if (var14 == null) {
         return false;
      } else {
         Method var1;
         try {
            var1 = a;
         } catch (Throwable var12) {
            var10001 = false;
            return false;
         }

         if (var1 == null) {
            return false;
         } else {
            try {
               var1.invoke(var14, Boolean.TRUE);
               return true;
            } catch (Throwable var11) {
               var10001 = false;
               return false;
            }
         }
      }
   }
}
