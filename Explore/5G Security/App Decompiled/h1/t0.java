package h1;

public abstract class t0 extends b0 {
   private long g;
   private boolean h;
   private q0.e<n0<?>> i;

   private final long p(boolean var1) {
      long var2;
      if (var1) {
         var2 = 4294967296L;
      } else {
         var2 = 1L;
      }

      return var2;
   }

   // $FF: synthetic method
   public static void w(t0 var0, boolean var1, int var2, Object var3) {
      if (var3 == null) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         var0.u(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
      }
   }

   public final boolean C() {
      q0.e var1 = this.i;
      boolean var2;
      if (var1 != null) {
         var2 = var1.isEmpty();
      } else {
         var2 = true;
      }

      return var2;
   }

   public final boolean D() {
      q0.e var1 = this.i;
      if (var1 == null) {
         return false;
      } else {
         n0 var2 = (n0)var1.j();
         if (var2 == null) {
            return false;
         } else {
            var2.run();
            return true;
         }
      }
   }

   public final void o(boolean var1) {
      long var2 = this.g - this.p(var1);
      this.g = var2;
      if (var2 <= 0L) {
         if (this.h) {
            this.shutdown();
         }

      }
   }

   public final void q(n0<?> var1) {
      q0.e var2 = this.i;
      q0.e var3 = var2;
      if (var2 == null) {
         var3 = new q0.e();
         this.i = var3;
      }

      var3.addLast(var1);
   }

   protected long r() {
      q0.e var1 = this.i;
      long var2 = Long.MAX_VALUE;
      if (var1 == null) {
         return Long.MAX_VALUE;
      } else {
         if (!var1.isEmpty()) {
            var2 = 0L;
         }

         return var2;
      }
   }

   public void shutdown() {
   }

   public final void u(boolean var1) {
      this.g += this.p(var1);
      if (!var1) {
         this.h = true;
      }

   }

   public final boolean z() {
      long var1 = this.g;
      boolean var3 = true;
      if (var1 < this.p(true)) {
         var3 = false;
      }

      return var3;
   }
}
