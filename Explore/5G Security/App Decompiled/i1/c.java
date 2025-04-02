package i1;

import a1.g;
import a1.k;
import android.os.Handler;
import android.os.Looper;
import h1.l1;
import h1.q0;
import java.util.concurrent.CancellationException;

public final class c extends d {
   private volatile i1.c _immediate;
   private final Handler g;
   private final String h;
   private final boolean i;
   private final i1.c j;

   public c(Handler var1, String var2) {
      this(var1, var2, false);
   }

   // $FF: synthetic method
   public c(Handler var1, String var2, int var3, g var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   private c(Handler var1, String var2, boolean var3) {
      i1.c var4 = null;
      super((g)null);
      this.g = var1;
      this.h = var2;
      this.i = var3;
      if (var3) {
         var4 = this;
      }

      this._immediate = var4;
      i1.c var5 = this._immediate;
      var4 = var5;
      if (var5 == null) {
         var4 = new i1.c(var1, var2, true);
         this._immediate = var4;
      }

      this.j = var4;
   }

   private final void q(r0.g var1, Runnable var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("The task was rejected, the handler underlying the dispatcher '");
      var3.append(this);
      var3.append("' was closed");
      l1.c(var1, new CancellationException(var3.toString()));
      q0.b().a(var1, var2);
   }

   public void a(r0.g var1, Runnable var2) {
      if (!this.g.post(var2)) {
         this.q(var1, var2);
      }

   }

   public boolean e(r0.g var1) {
      boolean var2;
      if (this.i && k.a(Looper.myLooper(), this.g.getLooper())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof i1.c && ((i1.c)var1).g == this.g) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      return System.identityHashCode(this.g);
   }

   public i1.c r() {
      return this.j;
   }

   public String toString() {
      String var1 = this.p();
      String var2 = var1;
      if (var1 == null) {
         var2 = this.h;
         var1 = var2;
         if (var2 == null) {
            var1 = this.g.toString();
         }

         var2 = var1;
         if (this.i) {
            StringBuilder var3 = new StringBuilder();
            var3.append(var1);
            var3.append(".immediate");
            var2 = var3.toString();
         }
      }

      return var2;
   }
}
