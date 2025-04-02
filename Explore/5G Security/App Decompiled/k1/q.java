package k1;

public final class q<T> implements d<T> {
   private final d<T> e;
   private final z0.p<d<? super T>, r0.d<? super p0.q>, Object> f;

   public final Object a(r0.d<? super p0.q> var1) {
      int var3;
      Object var50;
      label591: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var2 = (<undefinedtype>)var1;
            var3 = var2.l;
            if ((var3 & Integer.MIN_VALUE) != 0) {
               var2.l = var3 + Integer.MIN_VALUE;
               var50 = var2;
               break label591;
            }
         }

         var50 = new t0.d(var1) {
            Object h;
            Object i;
            // $FF: synthetic field
            Object j;
            int l;

            public final Object k(Object var1) {
               this.j = var1;
               this.l |= Integer.MIN_VALUE;
               return q.this.a(this);
            }
         };
      }

      Throwable var10000;
      l1.l var51;
      label603: {
         Object var4 = ((<undefinedtype>)var50).j;
         Object var5 = s0.b.c();
         var3 = ((<undefinedtype>)var50).l;
         l1.l var6;
         boolean var10001;
         q var53;
         if (var3 != 0) {
            if (var3 != 1) {
               if (var3 != 2) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               p0.l.b(var4);
               return p0.q.a;
            }

            var6 = (l1.l)((<undefinedtype>)var50).i;
            q var7 = (q)((<undefinedtype>)var50).h;
            var51 = var6;

            try {
               p0.l.b(var4);
            } catch (Throwable var49) {
               var10000 = var49;
               var10001 = false;
               break label603;
            }

            var53 = var7;
         } else {
            p0.l.b(var4);
            var6 = new l1.l(this.e, ((r0.d)var50).a());
            var51 = var6;

            z0.p var55;
            try {
               var55 = this.f;
            } catch (Throwable var48) {
               var10000 = var48;
               var10001 = false;
               break label603;
            }

            var51 = var6;

            try {
               ((<undefinedtype>)var50).h = this;
            } catch (Throwable var47) {
               var10000 = var47;
               var10001 = false;
               break label603;
            }

            var51 = var6;

            try {
               ((<undefinedtype>)var50).i = var6;
            } catch (Throwable var46) {
               var10000 = var46;
               var10001 = false;
               break label603;
            }

            var51 = var6;

            try {
               ((<undefinedtype>)var50).l = 1;
            } catch (Throwable var45) {
               var10000 = var45;
               var10001 = false;
               break label603;
            }

            var51 = var6;

            Object var56;
            try {
               var56 = var55.h(var6, var50);
            } catch (Throwable var44) {
               var10000 = var44;
               var10001 = false;
               break label603;
            }

            if (var56 == var5) {
               return var5;
            }

            var53 = this;
         }

         var6.m();
         d var54 = var53.e;
         if (!(var54 instanceof q)) {
            return p0.q.a;
         }

         var53 = (q)var54;
         ((<undefinedtype>)var50).h = null;
         ((<undefinedtype>)var50).i = null;
         ((<undefinedtype>)var50).l = 2;
         if (var53.a((r0.d)var50) == var5) {
            return var5;
         }

         return p0.q.a;
      }

      Throwable var52 = var10000;
      var51.m();
      throw var52;
   }

   public Object c(T var1, r0.d<? super p0.q> var2) {
      return this.e.c(var1, var2);
   }
}
