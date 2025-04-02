package m1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class s {
   private static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");
   private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_prev");
   private static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_removedRef");
   private volatile Object _next = this;
   private volatile Object _prev = this;
   private volatile Object _removedRef;

   private final s m(a0 var1) {
      label49:
      while(true) {
         s var2 = (s)f.get(this);
         s var3 = var2;

         while(true) {
            s var4 = null;

            while(true) {
               AtomicReferenceFieldUpdater var5 = e;
               Object var6 = var5.get(var3);
               if (var6 == this) {
                  if (var2 == var3) {
                     return var3;
                  }

                  if (!androidx.concurrent.futures.b.a(f, this, var2, var3)) {
                     continue label49;
                  }

                  return var3;
               }

               if (this.s()) {
                  return null;
               }

               if (var6 == var1) {
                  return var3;
               }

               if (var6 instanceof a0) {
                  ((a0)var6).a(var3);
                  continue label49;
               }

               if (var6 instanceof b0) {
                  if (var4 != null) {
                     if (!androidx.concurrent.futures.b.a(var5, var4, var3, ((b0)var6).a)) {
                        continue label49;
                     }

                     var3 = var4;
                     break;
                  }

                  var3 = (s)f.get(var3);
               } else {
                  a1.k.c(var6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                  s var7 = (s)var6;
                  var4 = var3;
                  var3 = var7;
               }
            }
         }
      }
   }

   private final s n(s var1) {
      while(var1.s()) {
         var1 = (s)f.get(var1);
      }

      return var1;
   }

   private final void o(s var1) {
      AtomicReferenceFieldUpdater var2 = f;

      s var3;
      do {
         var3 = (s)var2.get(var1);
         if (this.p() != var1) {
            return;
         }
      } while(!androidx.concurrent.futures.b.a(f, var1, var3, this));

      if (this.s()) {
         var1.m((a0)null);
      }

   }

   private final b0 v() {
      AtomicReferenceFieldUpdater var1 = g;
      b0 var2 = (b0)var1.get(this);
      b0 var3 = var2;
      if (var2 == null) {
         var3 = new b0(this);
         var1.lazySet(this, var3);
      }

      return var3;
   }

   public final boolean l(s var1) {
      f.lazySet(var1, this);
      e.lazySet(var1, this);

      while(this.p() == this) {
         if (androidx.concurrent.futures.b.a(e, this, this, var1)) {
            var1.o(this);
            return true;
         }
      }

      return false;
   }

   public final Object p() {
      AtomicReferenceFieldUpdater var1 = e;

      while(true) {
         Object var2 = var1.get(this);
         if (!(var2 instanceof a0)) {
            return var2;
         }

         ((a0)var2).a(this);
      }
   }

   public final s q() {
      return r.b(this.p());
   }

   public final s r() {
      s var1 = this.m((a0)null);
      s var2 = var1;
      if (var1 == null) {
         var2 = this.n((s)f.get(this));
      }

      return var2;
   }

   public boolean s() {
      return this.p() instanceof b0;
   }

   public boolean t() {
      boolean var1;
      if (this.u() == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(new a1.o(this) {
         public Object get() {
            return h1.i0.a(super.f);
         }
      });
      var1.append('@');
      var1.append(h1.i0.b(this));
      return var1.toString();
   }

   public final s u() {
      Object var1;
      s var2;
      b0 var3;
      do {
         var1 = this.p();
         if (var1 instanceof b0) {
            return ((b0)var1).a;
         }

         if (var1 == this) {
            return (s)var1;
         }

         a1.k.c(var1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
         var2 = (s)var1;
         var3 = var2.v();
      } while(!androidx.concurrent.futures.b.a(e, this, var1, var3));

      var2.m((a0)null);
      return null;
   }

   public final int w(s var1, s var2, s.a var3) {
      f.lazySet(var1, this);
      AtomicReferenceFieldUpdater var4 = e;
      var4.lazySet(var1, var2);
      var3.c = var2;
      if (!androidx.concurrent.futures.b.a(var4, this, var2, var3)) {
         return 0;
      } else {
         byte var5;
         if (var3.a(this) == null) {
            var5 = 1;
         } else {
            var5 = 2;
         }

         return var5;
      }
   }

   public abstract static class a extends b<s> {
      public final s b;
      public s c;

      public a(s var1) {
         this.b = var1;
      }

      public void e(s var1, Object var2) {
         boolean var3;
         if (var2 == null) {
            var3 = true;
         } else {
            var3 = false;
         }

         s var4;
         if (var3) {
            var4 = this.b;
         } else {
            var4 = this.c;
         }

         if (var4 != null && androidx.concurrent.futures.b.a(s.e, var1, this, var4) && var3) {
            var4 = this.b;
            var1 = this.c;
            a1.k.b(var1);
            var4.o(var1);
         }

      }
   }
}
