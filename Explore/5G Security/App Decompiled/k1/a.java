package k1;

final class a<T> extends b<T> {
   private final z0.p<j1.r<? super T>, r0.d<? super p0.q>, Object> i;

   public a(z0.p<? super j1.r<? super T>, ? super r0.d<? super p0.q>, ? extends Object> var1, r0.g var2, int var3, j1.a var4) {
      super(var1, var2, var3, var4);
      this.i = var1;
   }

   // $FF: synthetic method
   public a(z0.p var1, r0.g var2, int var3, j1.a var4, int var5, a1.g var6) {
      if ((var5 & 2) != 0) {
         var2 = r0.h.e;
      }

      if ((var5 & 4) != 0) {
         var3 = -2;
      }

      if ((var5 & 8) != 0) {
         var4 = j1.a.e;
      }

      this(var1, (r0.g)var2, var3, var4);
   }

   protected Object e(j1.r<? super T> var1, r0.d<? super p0.q> var2) {
      int var4;
      Object var7;
      label27: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var2;
            var4 = var3.k;
            if ((var4 & Integer.MIN_VALUE) != 0) {
               var3.k = var4 + Integer.MIN_VALUE;
               var7 = var3;
               break label27;
            }
         }

         var7 = new t0.d(var2) {
            Object h;
            // $FF: synthetic field
            Object i;
            int k;

            public final Object k(Object var1) {
               this.i = var1;
               this.k |= Integer.MIN_VALUE;
               return a.this.e((j1.r)null, this);
            }
         };
      }

      Object var5 = ((<undefinedtype>)var7).i;
      Object var6 = s0.b.c();
      var4 = ((<undefinedtype>)var7).k;
      j1.r var8;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var8 = (j1.r)((<undefinedtype>)var7).h;
         p0.l.b(var5);
      } else {
         p0.l.b(var5);
         ((<undefinedtype>)var7).h = var1;
         ((<undefinedtype>)var7).k = 1;
         var8 = var1;
         if (super.e(var1, (r0.d)var7) == var6) {
            return var6;
         }
      }

      if (var8.w()) {
         return p0.q.a;
      } else {
         throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
      }
   }

   protected l1.d<T> f(r0.g var1, int var2, j1.a var3) {
      return new k1.a(this.i, var1, var2, var3);
   }
}
