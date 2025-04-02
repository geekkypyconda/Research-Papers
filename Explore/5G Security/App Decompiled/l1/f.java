package l1;

import j1.r;

public abstract class f<S, T> extends d<T> {
   protected final k1.c<S> h;

   public f(k1.c<? extends S> var1, r0.g var2, int var3, j1.a var4) {
      super(var2, var3, var4);
      this.h = var1;
   }

   // $FF: synthetic method
   static <S, T> Object j(f<S, T> var0, k1.d<? super T> var1, r0.d<? super p0.q> var2) {
      Object var6;
      if (var0.f == -3) {
         r0.g var3 = var2.a();
         r0.g var4 = var3.n(var0.e);
         if (a1.k.a(var4, var3)) {
            var6 = var0.m(var1, var2);
            if (var6 == s0.b.c()) {
               return var6;
            }

            return p0.q.a;
         }

         r0.e.b var5 = r0.e.d;
         if (a1.k.a(var4.b(var5), var3.b(var5))) {
            var6 = var0.l(var1, var4, var2);
            if (var6 == s0.b.c()) {
               return var6;
            }

            return p0.q.a;
         }
      }

      var6 = var0.a(var1, var2);
      return var6 == s0.b.c() ? var6 : p0.q.a;
   }

   // $FF: synthetic method
   static <S, T> Object k(f<S, T> var0, r<? super T> var1, r0.d<? super p0.q> var2) {
      Object var3 = var0.m(new o(var1), var2);
      return var3 == s0.b.c() ? var3 : p0.q.a;
   }

   private final Object l(k1.d<? super T> var1, r0.g var2, r0.d<? super p0.q> var3) {
      Object var4 = l1.e.c(var2, l1.e.a(var1, var3.a()), (Object)null, new z0.p<k1.d<? super T>, r0.d<? super p0.q>, Object>((r0.d)null) {
         int i;
         // $FF: synthetic field
         Object j;

         public final r0.d<p0.q> d(Object var1, r0.d<?> var2) {
            z0.p var3 = new <anonymous constructor>(var2);
            var3.j = var1;
            return var3;
         }

         public final Object k(Object var1) {
            Object var2 = s0.b.c();
            int var3 = this.i;
            if (var3 != 0) {
               if (var3 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               p0.l.b(var1);
            } else {
               p0.l.b(var1);
               k1.d var4 = (k1.d)this.j;
               f var5 = f.this;
               this.i = 1;
               if (var5.m(var4, this) == var2) {
                  return var2;
               }
            }

            return p0.q.a;
         }

         public final Object p(k1.d<? super T> var1, r0.d<? super p0.q> var2) {
            return ((<undefinedtype>)this.d(var1, var2)).k(p0.q.a);
         }
      }, var3, 4, (Object)null);
      return var4 == s0.b.c() ? var4 : p0.q.a;
   }

   public Object a(k1.d<? super T> var1, r0.d<? super p0.q> var2) {
      return j(this, var1, var2);
   }

   protected Object e(r<? super T> var1, r0.d<? super p0.q> var2) {
      return k(this, var1, var2);
   }

   protected abstract Object m(k1.d<? super T> var1, r0.d<? super p0.q> var2);

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.h);
      var1.append(" -> ");
      var1.append(super.toString());
      return var1.toString();
   }
}
