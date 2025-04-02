package j1;

import h1.a0;
import h1.e0;
import h1.g0;
import h1.h1;

public final class p {
   public static final Object a(r<?> var0, z0.a<p0.q> var1, r0.d<? super p0.q> var2) {
      Object var3;
      int var4;
      label1845: {
         if (var2 instanceof <undefinedtype>) {
            var3 = (<undefinedtype>)var2;
            var4 = ((<undefinedtype>)var3).k;
            if ((var4 & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var3).k = var4 + Integer.MIN_VALUE;
               break label1845;
            }
         }

         var3 = new t0.d(var2) {
            Object h;
            Object i;
            // $FF: synthetic field
            Object j;
            int k;

            public final Object k(Object var1) {
               this.j = var1;
               this.k |= Integer.MIN_VALUE;
               return p.a((r)null, (z0.a)null, this);
            }
         };
      }

      z0.a var190;
      label1840: {
         Object var5 = ((<undefinedtype>)var3).j;
         Object var6 = s0.b.c();
         var4 = ((<undefinedtype>)var3).k;
         z0.a var193;
         Throwable var10000;
         boolean var10001;
         if (var4 != 0) {
            if (var4 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var190 = (z0.a)((<undefinedtype>)var3).i;
            r var192 = (r)((<undefinedtype>)var3).h;
            var193 = var190;

            label1783:
            try {
               p0.l.b(var5);
               break label1840;
            } catch (Throwable var177) {
               var10000 = var177;
               var10001 = false;
               break label1783;
            }
         } else {
            label1849: {
               p0.l.b(var5);
               boolean var194;
               if (((r0.d)var3).a().b(h1.b) == var0) {
                  var194 = true;
               } else {
                  var194 = false;
               }

               if (!var194) {
                  throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
               }

               var193 = var1;

               try {
                  ((<undefinedtype>)var3).h = var0;
               } catch (Throwable var189) {
                  var10000 = var189;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               try {
                  ((<undefinedtype>)var3).i = var1;
               } catch (Throwable var188) {
                  var10000 = var188;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               try {
                  ((<undefinedtype>)var3).k = 1;
               } catch (Throwable var187) {
                  var10000 = var187;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               h1.k var7;
               try {
                  var7 = new h1.k;
               } catch (Throwable var186) {
                  var10000 = var186;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               try {
                  var7.<init>(s0.b.b((r0.d)var3), 1);
               } catch (Throwable var185) {
                  var10000 = var185;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               try {
                  var7.z();
               } catch (Throwable var184) {
                  var10000 = var184;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               z0.l var195;
               try {
                  var195 = new z0.l<Throwable, p0.q>() {
                     public final void a(Throwable var1) {
                        h1.j var3 = p.this;
                        p0.k.a var2 = p0.k.e;
                        var3.u(p0.k.a(p0.q.a));
                     }
                  };
               } catch (Throwable var183) {
                  var10000 = var183;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               try {
                  var195.<init>();
               } catch (Throwable var182) {
                  var10000 = var182;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               try {
                  var0.z(var195);
               } catch (Throwable var181) {
                  var10000 = var181;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               try {
                  var5 = var7.w();
               } catch (Throwable var180) {
                  var10000 = var180;
                  var10001 = false;
                  break label1849;
               }

               var193 = var1;

               label1850: {
                  try {
                     if (var5 != s0.b.c()) {
                        break label1850;
                     }
                  } catch (Throwable var179) {
                     var10000 = var179;
                     var10001 = false;
                     break label1849;
                  }

                  var193 = var1;

                  try {
                     t0.h.c((r0.d)var3);
                  } catch (Throwable var178) {
                     var10000 = var178;
                     var10001 = false;
                     break label1849;
                  }
               }

               var190 = var1;
               if (var5 == var6) {
                  return var6;
               }
               break label1840;
            }
         }

         Throwable var191 = var10000;
         var193.b();
         throw var191;
      }

      var190.b();
      return p0.q.a;
   }

   public static final <E> t<E> b(e0 var0, r0.g var1, int var2, a var3, g0 var4, z0.l<? super Throwable, p0.q> var5, z0.p<? super r<? super E>, ? super r0.d<? super p0.q>, ? extends Object> var6) {
      d var8 = g.b(var2, var3, (z0.l)null, 4, (Object)null);
      q var7 = new q(a0.d(var0, var1), var8);
      if (var5 != null) {
         var7.e0(var5);
      }

      var7.J0(var4, var7, var6);
      return var7;
   }

   // $FF: synthetic method
   public static t c(e0 var0, r0.g var1, int var2, a var3, g0 var4, z0.l var5, z0.p var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = r0.h.e;
      }

      if ((var7 & 2) != 0) {
         var2 = 0;
      }

      if ((var7 & 4) != 0) {
         var3 = a.e;
      }

      if ((var7 & 8) != 0) {
         var4 = g0.e;
      }

      if ((var7 & 16) != 0) {
         var5 = null;
      }

      return b(var0, (r0.g)var1, var2, var3, var4, var5, var6);
   }
}
