package m1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class t<E> {
   private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_cur");
   private volatile Object _cur;

   public t(boolean var1) {
      this._cur = new u(8, var1);
   }

   public final boolean a(E var1) {
      AtomicReferenceFieldUpdater var2 = a;

      while(true) {
         u var3 = (u)var2.get(this);
         int var4 = var3.a(var1);
         if (var4 == 0) {
            return true;
         }

         if (var4 != 1) {
            if (var4 == 2) {
               return false;
            }
         } else {
            androidx.concurrent.futures.b.a(a, this, var3, var3.i());
         }
      }
   }

   public final void b() {
      AtomicReferenceFieldUpdater var1 = a;

      while(true) {
         u var2 = (u)var1.get(this);
         if (var2.d()) {
            return;
         }

         androidx.concurrent.futures.b.a(a, this, var2, var2.i());
      }
   }

   public final int c() {
      return ((u)a.get(this)).f();
   }

   public final E d() {
      AtomicReferenceFieldUpdater var1 = a;

      while(true) {
         u var2 = (u)var1.get(this);
         Object var3 = var2.j();
         if (var3 != u.h) {
            return var3;
         }

         androidx.concurrent.futures.b.a(a, this, var2, var2.i());
      }
   }
}
