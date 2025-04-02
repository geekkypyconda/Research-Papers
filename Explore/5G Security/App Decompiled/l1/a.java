package l1;

import java.util.Arrays;

public abstract class a<S extends c<?>> {
   private S[] e;
   private int f;
   private int g;

   protected final S d() {
      synchronized(this){}

      Throwable var10000;
      label638: {
         c[] var1;
         boolean var10001;
         try {
            var1 = this.e;
         } catch (Throwable var77) {
            var10000 = var77;
            var10001 = false;
            break label638;
         }

         c[] var2;
         if (var1 == null) {
            try {
               var2 = this.f(2);
               this.e = var2;
            } catch (Throwable var76) {
               var10000 = var76;
               var10001 = false;
               break label638;
            }
         } else {
            var2 = var1;

            try {
               if (this.f >= var1.length) {
                  Object[] var79 = Arrays.copyOf(var1, var1.length * 2);
                  a1.k.d(var79, "copyOf(this, newSize)");
                  this.e = (c[])var79;
                  var2 = (c[])var79;
               }
            } catch (Throwable var75) {
               var10000 = var75;
               var10001 = false;
               break label638;
            }
         }

         int var3;
         try {
            var3 = this.g;
         } catch (Throwable var74) {
            var10000 = var74;
            var10001 = false;
            break label638;
         }

         while(true) {
            c var4 = var2[var3];
            c var78 = var4;
            if (var4 == null) {
               try {
                  var78 = this.e();
               } catch (Throwable var72) {
                  var10000 = var72;
                  var10001 = false;
                  break;
               }

               var2[var3] = var78;
            }

            ++var3;
            int var5 = var3;

            label615: {
               try {
                  if (var3 < var2.length) {
                     break label615;
                  }
               } catch (Throwable var73) {
                  var10000 = var73;
                  var10001 = false;
                  break;
               }

               var5 = 0;
            }

            try {
               a1.k.c(var78, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } catch (Throwable var71) {
               var10000 = var71;
               var10001 = false;
               break;
            }

            var3 = var5;

            try {
               if (var78.a(this)) {
                  this.g = var5;
                  ++this.f;
                  return var78;
               }
            } catch (Throwable var70) {
               var10000 = var70;
               var10001 = false;
               break;
            }
         }
      }

      Throwable var80 = var10000;
      throw var80;
   }

   protected abstract S e();

   protected abstract S[] f(int var1);

   protected final void g(S var1) {
      synchronized(this){}

      int var2;
      int var3;
      r0.d[] var4;
      label159: {
         Throwable var10000;
         label163: {
            boolean var10001;
            try {
               var2 = this.f - 1;
               this.f = var2;
            } catch (Throwable var17) {
               var10000 = var17;
               var10001 = false;
               break label163;
            }

            var3 = 0;
            if (var2 == 0) {
               try {
                  this.g = 0;
               } catch (Throwable var16) {
                  var10000 = var16;
                  var10001 = false;
                  break label163;
               }
            }

            label151:
            try {
               a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
               var4 = var1.b(this);
               break label159;
            } catch (Throwable var15) {
               var10000 = var15;
               var10001 = false;
               break label151;
            }
         }

         Throwable var18 = var10000;
         throw var18;
      }

      for(var2 = var4.length; var3 < var2; ++var3) {
         r0.d var5 = var4[var3];
         if (var5 != null) {
            p0.k.a var19 = p0.k.e;
            var5.u(p0.k.a(p0.q.a));
         }
      }

   }

   protected final S[] h() {
      return this.e;
   }
}
