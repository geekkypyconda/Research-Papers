package j1;

import h1.c2;
import m1.h0;
import m1.q0;
import m1.z;

public class o<E> extends j1.b<E> {
   private final int q;
   private final j1.a r;

   public o(int var1, j1.a var2, z0.l<? super E, p0.q> var3) {
      super(var1, var3);
      this.q = var1;
      this.r = var2;
      j1.a var7 = j1.a.e;
      boolean var4 = false;
      boolean var5;
      if (var2 != var7) {
         var5 = true;
      } else {
         var5 = false;
      }

      StringBuilder var6;
      if (var5) {
         var5 = var4;
         if (var1 >= 1) {
            var5 = true;
         }

         if (!var5) {
            var6 = new StringBuilder();
            var6.append("Buffered channel capacity must be at least 1, but ");
            var6.append(var1);
            var6.append(" was specified");
            throw new IllegalArgumentException(var6.toString().toString());
         }
      } else {
         var6 = new StringBuilder();
         var6.append("This implementation does not support suspension for senders, use ");
         var6.append(a1.r.b(j1.b.class).b());
         var6.append(" instead");
         throw new IllegalArgumentException(var6.toString().toString());
      }
   }

   // $FF: synthetic method
   static <E> Object B0(o<E> var0, E var1, r0.d<? super p0.q> var2) {
      Object var4 = var0.E0(var1, true);
      if (var4 instanceof h.a) {
         j1.h.e(var4);
         z0.l var5 = var0.f;
         if (var5 != null) {
            q0 var3 = z.d(var5, var1, (q0)null, 2, (Object)null);
            if (var3 != null) {
               p0.a.a(var3, var0.K());
               throw var3;
            }
         }

         throw var0.K();
      } else {
         return p0.q.a;
      }
   }

   private final Object C0(E var1, boolean var2) {
      Object var3 = super.q(var1);
      if (!j1.h.h(var3) && !j1.h.g(var3)) {
         if (var2) {
            z0.l var5 = super.f;
            if (var5 != null) {
               q0 var4 = z.d(var5, var1, (q0)null, 2, (Object)null);
               if (var4 != null) {
                  throw var4;
               }
            }
         }

         return j1.h.b.c(p0.q.a);
      } else {
         return var3;
      }
   }

   private final Object D0(E var1) {
      h0 var2 = j1.c.d;
      j var3 = (j)j1.b.h().get(this);

      boolean var8;
      do {
         while(true) {
            long var4 = j1.b.i().getAndIncrement(this);
            long var6 = var4 & 1152921504606846975L;
            var8 = j1.b.j(this, var4);
            int var9 = j1.c.b;
            var4 = var6 / (long)var9;
            int var10 = (int)(var6 % (long)var9);
            if (var3.g != var4) {
               j var11 = j1.b.b(this, var4, var3);
               if (var11 == null) {
                  break;
               }

               var3 = var11;
            }

            int var12 = j1.b.o(this, var3, var10, var1, var6, var2, var8);
            if (var12 == 0) {
               var3.b();
               return j1.h.b.c(p0.q.a);
            }

            if (var12 == 1) {
               return j1.h.b.c(p0.q.a);
            }

            if (var12 == 2) {
               if (var8) {
                  var3.p();
                  return j1.h.b.a(this.K());
               }

               c2 var13;
               if (var2 instanceof c2) {
                  var13 = (c2)var2;
               } else {
                  var13 = null;
               }

               if (var13 != null) {
                  j1.b.m(this, var13, var3, var10);
               }

               this.B(var3.g * (long)var9 + (long)var10);
               return j1.h.b.c(p0.q.a);
            }

            if (var12 == 3) {
               throw new IllegalStateException("unexpected".toString());
            }

            if (var12 == 4) {
               if (var6 < this.J()) {
                  var3.b();
               }

               return j1.h.b.a(this.K());
            }

            if (var12 == 5) {
               var3.b();
            }
         }
      } while(!var8);

      return j1.h.b.a(this.K());
   }

   private final Object E0(E var1, boolean var2) {
      if (this.r == j1.a.g) {
         var1 = this.C0(var1, var2);
      } else {
         var1 = this.D0(var1);
      }

      return var1;
   }

   protected boolean V() {
      boolean var1;
      if (this.r == j1.a.f) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public Object e(E var1, r0.d<? super p0.q> var2) {
      return B0(this, var1, var2);
   }

   public Object q(E var1) {
      return this.E0(var1, false);
   }
}
