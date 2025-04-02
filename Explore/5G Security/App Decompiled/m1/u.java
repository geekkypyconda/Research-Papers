package m1;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class u<E> {
   public static final u.a e = new u.a((a1.g)null);
   private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_next");
   private static final AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(u.class, "_state");
   public static final h0 h = new h0("REMOVE_FROZEN");
   private volatile Object _next;
   private volatile long _state;
   private final int a;
   private final boolean b;
   private final int c;
   private final AtomicReferenceArray d;

   public u(int var1, boolean var2) {
      this.a = var1;
      this.b = var2;
      int var3 = var1 - 1;
      this.c = var3;
      this.d = new AtomicReferenceArray(var1);
      boolean var4 = false;
      boolean var5;
      if (var3 <= 1073741823) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var5) {
         var5 = var4;
         if ((var1 & var3) == 0) {
            var5 = true;
         }

         if (!var5) {
            throw new IllegalStateException("Check failed.".toString());
         }
      } else {
         throw new IllegalStateException("Check failed.".toString());
      }
   }

   private final u<E> b(long var1) {
      u var3 = new u(this.a * 2, this.b);
      int var4 = (int)((1073741823L & var1) >> 0);
      int var5 = (int)((1152921503533105152L & var1) >> 30);

      while(true) {
         int var6 = this.c;
         if ((var4 & var6) == (var5 & var6)) {
            g.set(var3, e.d(var1, 1152921504606846976L));
            return var3;
         }

         Object var7 = this.d.get(var6 & var4);
         Object var8 = var7;
         if (var7 == null) {
            var8 = new u.b(var4);
         }

         var3.d.set(var3.c & var4, var8);
         ++var4;
      }
   }

   private final u<E> c(long var1) {
      AtomicReferenceFieldUpdater var3 = f;

      while(true) {
         u var4 = (u)var3.get(this);
         if (var4 != null) {
            return var4;
         }

         androidx.concurrent.futures.b.a(f, this, (Object)null, this.b(var1));
      }
   }

   private final u<E> e(int var1, E var2) {
      Object var3 = this.d.get(this.c & var1);
      if (var3 instanceof u.b && ((u.b)var3).a == var1) {
         this.d.set(var1 & this.c, var2);
         return this;
      } else {
         return null;
      }
   }

   private final long h() {
      AtomicLongFieldUpdater var1 = g;

      long var2;
      long var4;
      do {
         var2 = var1.get(this);
         if ((var2 & 1152921504606846976L) != 0L) {
            return var2;
         }

         var4 = var2 | 1152921504606846976L;
      } while(!var1.compareAndSet(this, var2, var4));

      return var4;
   }

   private final u<E> k(int var1, int var2) {
      AtomicLongFieldUpdater var3 = g;

      long var4;
      do {
         var4 = var3.get(this);
         var1 = (int)((1073741823L & var4) >> 0);
         if ((1152921504606846976L & var4) != 0L) {
            return this.i();
         }
      } while(!g.compareAndSet(this, var4, e.b(var4, var2)));

      this.d.set(this.c & var1, (Object)null);
      return null;
   }

   public final int a(E var1) {
      AtomicLongFieldUpdater var2 = g;

      while(true) {
         long var3 = var2.get(this);
         if ((3458764513820540928L & var3) != 0L) {
            return e.a(var3);
         }

         int var5 = (int)((1073741823L & var3) >> 0);
         int var6 = (int)((1152921503533105152L & var3) >> 30);
         int var7 = this.c;
         if ((var6 + 2 & var7) == (var5 & var7)) {
            return 1;
         }

         if (!this.b && this.d.get(var6 & var7) != null) {
            var7 = this.a;
            if (var7 < 1024 || (var6 - var5 & 1073741823) > var7 >> 1) {
               return 1;
            }
         } else if (g.compareAndSet(this, var3, e.c(var3, var6 + 1 & 1073741823))) {
            this.d.set(var6 & var7, var1);
            u var9 = this;

            while((g.get(var9) & 1152921504606846976L) != 0L) {
               u var8 = var9.i().e(var6, var1);
               var9 = var8;
               if (var8 == null) {
                  break;
               }
            }

            return 0;
         }
      }
   }

   public final boolean d() {
      AtomicLongFieldUpdater var1 = g;

      long var2;
      do {
         var2 = var1.get(this);
         if ((var2 & 2305843009213693952L) != 0L) {
            return true;
         }

         if ((1152921504606846976L & var2) != 0L) {
            return false;
         }
      } while(!var1.compareAndSet(this, var2, var2 | 2305843009213693952L));

      return true;
   }

   public final int f() {
      long var1 = g.get(this);
      int var3 = (int)((1073741823L & var1) >> 0);
      return 1073741823 & (int)((var1 & 1152921503533105152L) >> 30) - var3;
   }

   public final boolean g() {
      long var1 = g.get(this);
      boolean var3 = false;
      if ((int)((1073741823L & var1) >> 0) == (int)((var1 & 1152921503533105152L) >> 30)) {
         var3 = true;
      }

      return var3;
   }

   public final u<E> i() {
      return this.c(this.h());
   }

   public final Object j() {
      AtomicLongFieldUpdater var1 = g;

      while(true) {
         long var2 = var1.get(this);
         if ((1152921504606846976L & var2) != 0L) {
            return h;
         }

         int var4 = (int)((1073741823L & var2) >> 0);
         int var5 = (int)((1152921503533105152L & var2) >> 30);
         int var6 = this.c;
         if ((var5 & var6) == (var4 & var6)) {
            return null;
         }

         Object var7 = this.d.get(var6 & var4);
         if (var7 == null) {
            if (this.b) {
               return null;
            }
         } else {
            if (var7 instanceof u.b) {
               return null;
            }

            var5 = var4 + 1 & 1073741823;
            if (g.compareAndSet(this, var2, e.b(var2, var5))) {
               this.d.set(this.c & var4, (Object)null);
               return var7;
            }

            if (this.b) {
               u var9 = this;

               u var8;
               do {
                  var8 = var9.k(var4, var5);
                  var9 = var8;
               } while(var8 != null);

               return var7;
            }
         }
      }
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      public final int a(long var1) {
         byte var3;
         if ((var1 & 2305843009213693952L) != 0L) {
            var3 = 2;
         } else {
            var3 = 1;
         }

         return var3;
      }

      public final long b(long var1, int var3) {
         return this.d(var1, 1073741823L) | (long)var3 << 0;
      }

      public final long c(long var1, int var3) {
         return this.d(var1, 1152921503533105152L) | (long)var3 << 30;
      }

      public final long d(long var1, long var3) {
         return var1 & var3;
      }
   }

   public static final class b {
      public final int a;

      public b(int var1) {
         this.a = var1;
      }
   }
}
