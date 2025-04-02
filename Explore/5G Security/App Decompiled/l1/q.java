package l1;

import m1.l0;

final class q<T> implements k1.d<T> {
   private final r0.g e;
   private final Object f;
   private final z0.p<T, r0.d<? super p0.q>, Object> g;

   public q(final k1.d<? super T> var1, r0.g var2) {
      this.e = var2;
      this.f = l0.b(var2);
      this.g = new z0.p<T, r0.d<? super p0.q>, Object>((r0.d)null) {
         int i;
         // $FF: synthetic field
         Object j;

         public final r0.d<p0.q> d(Object var1x, r0.d<?> var2) {
            z0.p var3 = new <anonymous constructor>(var2);
            var3.j = var1x;
            return var3;
         }

         public final Object k(Object var1x) {
            Object var2 = s0.b.c();
            int var3 = this.i;
            if (var3 != 0) {
               if (var3 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               p0.l.b(var1x);
            } else {
               p0.l.b(var1x);
               Object var4 = this.j;
               k1.d var5 = var1;
               this.i = 1;
               if (var5.c(var4, this) == var2) {
                  return var2;
               }
            }

            return p0.q.a;
         }

         public final Object p(T var1x, r0.d<? super p0.q> var2) {
            return ((<undefinedtype>)this.d(var1x, var2)).k(p0.q.a);
         }
      };
   }

   public Object c(T var1, r0.d<? super p0.q> var2) {
      var1 = l1.e.b(this.e, var1, this.f, this.g, var2);
      return var1 == s0.b.c() ? var1 : p0.q.a;
   }
}
