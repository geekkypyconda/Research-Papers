package p1;

import a1.k;
import h1.c2;
import h1.h;
import h1.j;
import h1.r0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m1.e0;
import r0.g;
import z0.l;
import z0.q;

public class a<R> extends h implements b, c2 {
   private static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(p1.a.class, Object.class, "state");
   private final g e;
   private List<p1.a<R>.a> f;
   private Object g;
   private int h;
   private Object i;
   private volatile Object state;

   private final p1.a<R>.a j(Object var1) {
      List var2 = this.f;
      Object var3 = null;
      if (var2 == null) {
         return null;
      } else {
         Iterator var4 = var2.iterator();

         boolean var5;
         Object var6;
         do {
            var6 = var3;
            if (!var4.hasNext()) {
               break;
            }

            var6 = var4.next();
            if (((p1.a.a)var6).a == var1) {
               var5 = true;
            } else {
               var5 = false;
            }
         } while(!var5);

         p1.a.a var7 = (p1.a.a)var6;
         if (var7 != null) {
            return var7;
         } else {
            StringBuilder var8 = new StringBuilder();
            var8.append("Clause with object ");
            var8.append(var1);
            var8.append(" is not found");
            throw new IllegalStateException(var8.toString().toString());
         }
      }
   }

   private final int l(Object var1, Object var2) {
      while(true) {
         AtomicReferenceFieldUpdater var3 = j;
         Object var4 = var3.get(this);
         if (var4 instanceof j) {
            p1.a.a var5 = this.j(var1);
            if (var5 != null) {
               l var6 = var5.a(this, var2);
               if (androidx.concurrent.futures.b.a(var3, this, var4, var5)) {
                  j var9 = (j)var4;
                  this.i = var2;
                  if (c.g(var9, var6)) {
                     return 0;
                  }

                  this.i = null;
                  return 2;
               }
            }
         } else {
            boolean var7;
            if (k.a(var4, c.e())) {
               var7 = true;
            } else {
               var7 = var4 instanceof p1.a.a;
            }

            if (var7) {
               return 3;
            }

            if (k.a(var4, c.d())) {
               return 2;
            }

            if (k.a(var4, c.f())) {
               if (androidx.concurrent.futures.b.a(var3, this, var4, q0.l.b(var1))) {
                  return 1;
               }
            } else {
               if (var4 instanceof List) {
                  if (!androidx.concurrent.futures.b.a(var3, this, var4, q0.l.q((Collection)var4, var1))) {
                     continue;
                  }

                  return 1;
               }

               StringBuilder var8 = new StringBuilder();
               var8.append("Unexpected state: ");
               var8.append(var4);
               throw new IllegalStateException(var8.toString().toString());
            }
         }
      }
   }

   public g a() {
      return this.e;
   }

   public boolean c(Object var1, Object var2) {
      boolean var3;
      if (this.l(var1, var2) == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public void d(e0<?> var1, int var2) {
      this.g = var1;
      this.h = var2;
   }

   public void f(Throwable var1) {
      AtomicReferenceFieldUpdater var3 = j;

      Object var2;
      do {
         var2 = var3.get(this);
         if (var2 == c.e()) {
            return;
         }
      } while(!androidx.concurrent.futures.b.a(var3, this, var2, c.d()));

      List var4 = this.f;
      if (var4 != null) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            ((p1.a.a)var5.next()).b();
         }

         this.i = c.c();
         this.f = null;
      }
   }

   public final d k(Object var1, Object var2) {
      return c.b(this.l(var1, var2));
   }

   public final class a {
      public final Object a;
      private final Object b;
      public final q<b<?>, Object, Object, l<Throwable, p0.q>> c;
      public Object d;
      public int e;
      // $FF: synthetic field
      final p1.a<R> f;

      public final l<Throwable, p0.q> a(b<?> var1, Object var2) {
         q var3 = this.c;
         l var4;
         if (var3 != null) {
            var4 = (l)var3.g(var1, this.b, var2);
         } else {
            var4 = null;
         }

         return var4;
      }

      public final void b() {
         Object var1 = this.d;
         p1.a var2 = this.f;
         boolean var3 = var1 instanceof e0;
         r0 var4 = null;
         if (var3) {
            ((e0)var1).o(this.e, (Throwable)null, var2.a());
         } else {
            if (var1 instanceof r0) {
               var4 = (r0)var1;
            }

            if (var4 != null) {
               var4.a();
            }
         }

      }
   }
}
