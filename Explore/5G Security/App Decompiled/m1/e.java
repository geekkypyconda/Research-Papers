package m1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class e<N extends e<N>> {
   private static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");
   private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");
   private volatile Object _next;
   private volatile Object _prev;

   public e(N var1) {
      this._prev = var1;
   }

   // $FF: synthetic method
   public static final Object a(e var0) {
      return var0.f();
   }

   private final N c() {
      e var1;
      for(var1 = this.g(); var1 != null && var1.h(); var1 = (e)f.get(var1)) {
      }

      return var1;
   }

   private final N d() {
      e var1 = this.e();
      a1.k.b(var1);

      while(var1.h()) {
         e var2 = var1.e();
         if (var2 == null) {
            return var1;
         }

         var1 = var2;
      }

      return var1;
   }

   private final Object f() {
      return e.get(this);
   }

   public final void b() {
      f.lazySet(this, (Object)null);
   }

   public final N e() {
      Object var1 = a(this);
      return var1 == d.a() ? null : (e)var1;
   }

   public final N g() {
      return (e)f.get(this);
   }

   public abstract boolean h();

   public final boolean i() {
      boolean var1;
      if (this.e() == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean j() {
      return androidx.concurrent.futures.b.a(e, this, (Object)null, d.a());
   }

   public final void k() {
      if (!this.i()) {
         e var1;
         e var2;
         do {
            do {
               var1 = this.c();
               var2 = this.d();
               AtomicReferenceFieldUpdater var3 = f;

               Object var4;
               e var5;
               do {
                  var4 = var3.get(var2);
                  if ((e)var4 == null) {
                     var5 = null;
                  } else {
                     var5 = var1;
                  }
               } while(!androidx.concurrent.futures.b.a(var3, var2, var4, var5));

               if (var1 != null) {
                  e.set(var1, var2);
               }
            } while(var2.h() && !var2.i());
         } while(var1 != null && var1.h());

      }
   }

   public final boolean l(N var1) {
      return androidx.concurrent.futures.b.a(e, this, (Object)null, var1);
   }
}
