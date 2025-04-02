package j1;

import h1.c2;
import java.util.concurrent.atomic.AtomicReferenceArray;
import m1.e0;
import m1.h0;
import m1.z;

public final class j<E> extends e0<j<E>> {
   private final b<E> i;
   private final AtomicReferenceArray j;

   public j(long var1, j<E> var3, b<E> var4, int var5) {
      super(var1, var3, var5);
      this.i = var4;
      this.j = new AtomicReferenceArray(c.b * 2);
   }

   private final void z(int var1, Object var2) {
      this.j.lazySet(var1 * 2, var2);
   }

   public final void A(int var1, Object var2) {
      this.j.set(var1 * 2 + 1, var2);
   }

   public final void B(int var1, E var2) {
      this.z(var1, var2);
   }

   public int n() {
      return c.b;
   }

   public void o(int var1, Throwable var2, r0.g var3) {
      int var4 = c.b;
      boolean var5;
      if (var1 >= var4) {
         var5 = true;
      } else {
         var5 = false;
      }

      int var6 = var1;
      if (var5) {
         var6 = var1 - var4;
      }

      Object var7 = this.v(var6);

      while(true) {
         while(true) {
            Object var8 = this.w(var6);
            z0.l var10;
            if (!(var8 instanceof c2) && !(var8 instanceof v)) {
               if (var8 == c.j() || var8 == c.i()) {
                  this.s(var6);
                  if (var5) {
                     var10 = this.u().f;
                     if (var10 != null) {
                        z.b(var10, var7, var3);
                     }
                  }

                  return;
               }

               if (var8 != c.p() && var8 != c.q()) {
                  if (var8 != c.f() && var8 != c.d) {
                     if (var8 == c.z()) {
                        return;
                     }

                     StringBuilder var11 = new StringBuilder();
                     var11.append("unexpected state: ");
                     var11.append(var8);
                     throw new IllegalStateException(var11.toString().toString());
                  }

                  return;
               }
            } else {
               h0 var9;
               if (var5) {
                  var9 = c.j();
               } else {
                  var9 = c.i();
               }

               if (this.r(var6, var8, var9)) {
                  this.s(var6);
                  this.x(var6, var5 ^ true);
                  if (var5) {
                     var10 = this.u().f;
                     if (var10 != null) {
                        z.b(var10, var7, var3);
                     }
                  }

                  return;
               }
            }
         }
      }
   }

   public final boolean r(int var1, Object var2, Object var3) {
      return j1.i.a(this.j, var1 * 2 + 1, var2, var3);
   }

   public final void s(int var1) {
      this.z(var1, (Object)null);
   }

   public final Object t(int var1, Object var2) {
      return this.j.getAndSet(var1 * 2 + 1, var2);
   }

   public final b<E> u() {
      b var1 = this.i;
      a1.k.b(var1);
      return var1;
   }

   public final E v(int var1) {
      return this.j.get(var1 * 2);
   }

   public final Object w(int var1) {
      return this.j.get(var1 * 2 + 1);
   }

   public final void x(int var1, boolean var2) {
      if (var2) {
         this.u().A0(super.g * (long)c.b + (long)var1);
      }

      this.p();
   }

   public final E y(int var1) {
      Object var2 = this.v(var1);
      this.s(var1);
      return var2;
   }
}
