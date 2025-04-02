package g;

import android.os.Handler;
import h.c;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class a {
   public static Executor a(Handler var0) {
      return new g.a.a(var0);
   }

   private static class a implements Executor {
      private final Handler e;

      a(Handler var1) {
         this.e = (Handler)c.a(var1);
      }

      public void execute(Runnable var1) {
         if (!this.e.post((Runnable)c.a(var1))) {
            StringBuilder var2 = new StringBuilder();
            var2.append(this.e);
            var2.append(" is shutting down");
            throw new RejectedExecutionException(var2.toString());
         }
      }
   }
}
