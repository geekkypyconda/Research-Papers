package p;

import a1.k;
import h1.b1;
import h1.e0;
import h1.f;
import h1.f0;
import h1.g0;
import h1.h1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import k1.c;
import p0.l;
import p0.q;
import r0.d;
import r0.g;
import s0.b;
import z0.p;

public final class a {
   private final ReentrantLock a = new ReentrantLock();
   private final Map<h.a<?>, h1> b = new LinkedHashMap();

   public final <T> void a(Executor var1, final h.a<T> var2, final c<? extends T> var3) {
      k.e(var1, "executor");
      k.e(var2, "consumer");
      k.e(var3, "flow");
      ReentrantLock var4 = this.a;
      var4.lock();

      try {
         if (this.b.get(var2) == null) {
            e0 var5 = f0.a(b1.a(var1));
            Map var9 = this.b;
            p var6 = new p<e0, d<? super q>, Object>((d)null) {
               int i;

               public final d<q> d(Object var1, d<?> var2x) {
                  return new <anonymous constructor>(var2x);
               }

               public final Object k(Object var1) {
                  Object var2x = s0.b.c();
                  int var3x = this.i;
                  if (var3x != 0) {
                     if (var3x != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     l.b(var1);
                  } else {
                     l.b(var1);
                     c var5 = var3;
                     k1.d var4 = new k1.d() {
                        // $FF: synthetic field
                        final h.a<T> e;

                        {
                           this.e = var1;
                        }

                        public final Object c(T var1, d<? super q> var2) {
                           this.e.accept(var1);
                           return q.a;
                        }
                     };
                     this.i = 1;
                     if (var5.a(var4, this) == var2x) {
                        return var2x;
                     }
                  }

                  return q.a;
               }

               public final Object p(e0 var1, d<? super q> var2x) {
                  return ((<undefinedtype>)this.d(var1, var2x)).k(q.a);
               }
            };
            var9.put(var2, f.b(var5, (g)null, (g0)null, var6, 3, (Object)null));
         }

         q var10 = q.a;
      } finally {
         var4.unlock();
      }

   }

   public final void b(h.a<?> var1) {
      k.e(var1, "consumer");
      ReentrantLock var2 = this.a;
      var2.lock();

      label112: {
         Throwable var10000;
         label116: {
            boolean var10001;
            h1 var3;
            try {
               var3 = (h1)this.b.get(var1);
            } catch (Throwable var15) {
               var10000 = var15;
               var10001 = false;
               break label116;
            }

            if (var3 != null) {
               try {
                  h1.a.a(var3, (CancellationException)null, 1, (Object)null);
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label116;
               }
            }

            label104:
            try {
               h1 var17 = (h1)this.b.remove(var1);
               break label112;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label104;
            }
         }

         Throwable var16 = var10000;
         var2.unlock();
         throw var16;
      }

      var2.unlock();
   }
}
