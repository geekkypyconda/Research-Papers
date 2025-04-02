package l1;

import h1.e0;
import h1.f0;
import h1.g0;
import h1.i0;
import j1.r;
import j1.t;
import java.util.ArrayList;

public abstract class d<T> implements i<T> {
   public final r0.g e;
   public final int f;
   public final j1.a g;

   public d(r0.g var1, int var2, j1.a var3) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
   }

   // $FF: synthetic method
   static <T> Object d(final d<T> var0, final k1.d<? super T> var1, r0.d<? super p0.q> var2) {
      Object var3 = f0.b(new z0.p<e0, r0.d<? super p0.q>, Object>((r0.d)null) {
         int i;
         // $FF: synthetic field
         private Object j;

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
               e0 var4 = (e0)this.j;
               k1.d var5 = var1;
               t var6 = var0.i(var4);
               this.i = 1;
               if (k1.e.b(var5, var6, this) == var2) {
                  return var2;
               }
            }

            return p0.q.a;
         }

         public final Object p(e0 var1x, r0.d<? super p0.q> var2) {
            return ((<undefinedtype>)this.d(var1x, var2)).k(p0.q.a);
         }
      }, var2);
      return var3 == s0.b.c() ? var3 : p0.q.a;
   }

   public Object a(k1.d<? super T> var1, r0.d<? super p0.q> var2) {
      return d(this, var1, var2);
   }

   public k1.c<T> b(r0.g var1, int var2, j1.a var3) {
      var1 = var1.n(this.e);
      if (var3 == j1.a.e) {
         int var4 = this.f;
         if (var4 != -3) {
            if (var2 == -3) {
               var2 = var4;
            } else if (var4 != -2) {
               if (var2 == -2) {
                  var2 = var4;
               } else {
                  var2 += var4;
                  if (var2 < 0) {
                     var2 = Integer.MAX_VALUE;
                  }
               }
            }
         }

         var3 = this.g;
      }

      return a1.k.a(var1, this.e) && var2 == this.f && var3 == this.g ? this : this.f(var1, var2, var3);
   }

   protected String c() {
      return null;
   }

   protected abstract Object e(r<? super T> var1, r0.d<? super p0.q> var2);

   protected abstract d<T> f(r0.g var1, int var2, j1.a var3);

   public final z0.p<r<? super T>, r0.d<? super p0.q>, Object> g() {
      return new z0.p<r<? super T>, r0.d<? super p0.q>, Object>((r0.d)null) {
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
               r var4 = (r)this.j;
               d var5 = d.this;
               this.i = 1;
               if (var5.e(var4, this) == var2) {
                  return var2;
               }
            }

            return p0.q.a;
         }

         public final Object p(r<? super T> var1, r0.d<? super p0.q> var2) {
            return ((<undefinedtype>)this.d(var1, var2)).k(p0.q.a);
         }
      };
   }

   public final int h() {
      int var1 = this.f;
      int var2 = var1;
      if (var1 == -3) {
         var2 = -2;
      }

      return var2;
   }

   public t<T> i(e0 var1) {
      return j1.p.c(var1, this.e, this.h(), this.g, g0.g, (z0.l)null, this.g(), 16, (Object)null);
   }

   public String toString() {
      ArrayList var1 = new ArrayList(4);
      String var2 = this.c();
      if (var2 != null) {
         var1.add(var2);
      }

      StringBuilder var3;
      if (this.e != r0.h.e) {
         var3 = new StringBuilder();
         var3.append("context=");
         var3.append(this.e);
         var1.add(var3.toString());
      }

      if (this.f != -3) {
         var3 = new StringBuilder();
         var3.append("capacity=");
         var3.append(this.f);
         var1.add(var3.toString());
      }

      if (this.g != j1.a.e) {
         var3 = new StringBuilder();
         var3.append("onBufferOverflow=");
         var3.append(this.g);
         var1.add(var3.toString());
      }

      var3 = new StringBuilder();
      var3.append(i0.a(this));
      var3.append('[');
      var3.append(q0.l.o(var1, ", ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (z0.l)null, 62, (Object)null));
      var3.append(']');
      return var3.toString();
   }
}
