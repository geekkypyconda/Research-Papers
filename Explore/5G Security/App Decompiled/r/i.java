package r;

import android.app.Activity;
import h1.q0;
import j1.r;
import p0.q;
import z0.p;

public final class i implements f {
   private final m b;
   private final s.a c;

   public i(m var1, s.a var2) {
      a1.k.e(var1, "windowMetricsCalculator");
      a1.k.e(var2, "windowBackend");
      super();
      this.b = var1;
      this.c = var2;
   }

   public k1.c<j> a(final Activity var1) {
      a1.k.e(var1, "activity");
      return k1.e.d(k1.e.a(new p<r<? super j>, r0.d<? super q>, Object>((r0.d)null) {
         int i;
         // $FF: synthetic field
         private Object j;

         // $FF: synthetic method
         public static void p(r var0, j var1x) {
            r(var0, var1x);
         }

         private static final void r(r var0, j var1x) {
            var0.q(var1x);
         }

         public final r0.d<q> d(Object var1x, r0.d<?> var2) {
            p var3 = new <anonymous constructor>(var2);
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
               r var5 = (r)this.j;
               h var4 = new h(var5);
               i.this.c.a(var1, new androidx.profileinstaller.h(), var4);
               z0.a var6 = new z0.a<q>(var4) {
                  // $FF: synthetic field
                  final i f;
                  // $FF: synthetic field
                  final h.a<j> g;

                  {
                     super(0);
                     this.f = var1;
                     this.g = var2;
                  }

                  public final void a() {
                     i.b(this.f).b(this.g);
                  }
               };
               this.i = 1;
               if (j1.p.a(var5, var6, this) == var2) {
                  return var2;
               }
            }

            return q.a;
         }

         public final Object q(r<? super j> var1x, r0.d<? super q> var2) {
            return ((<undefinedtype>)this.d(var1x, var2)).k(q.a);
         }
      }), q0.c());
   }
}
