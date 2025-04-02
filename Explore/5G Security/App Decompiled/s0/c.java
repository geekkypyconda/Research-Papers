package s0;

import a1.k;
import a1.t;
import p0.l;
import p0.q;
import r0.g;
import t0.h;
import t0.j;
import z0.p;

class c {
   public static <R, T> r0.d<q> a(final p<? super R, ? super r0.d<? super T>, ? extends Object> var0, final R var1, r0.d<? super T> var2) {
      k.e(var0, "<this>");
      k.e(var2, "completion");
      var2 = h.a(var2);
      Object var4;
      if (var0 instanceof t0.a) {
         var4 = ((t0.a)var0).d(var1, var2);
      } else {
         g var3 = var2.a();
         if (var3 == r0.h.e) {
            var4 = new j(var2) {
               private int f;

               public {
                  k.c(var1x, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
               }

               protected Object k(Object var1x) {
                  int var2 = this.f;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                     }

                     this.f = 2;
                     l.b(var1x);
                  } else {
                     this.f = 1;
                     l.b(var1x);
                     k.c(var0, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                     var1x = ((p)t.a(var0, 2)).h(var1, this);
                  }

                  return var1x;
               }
            };
         } else {
            var4 = new t0.d(var2, var3) {
               private int h;

               public {
                  k.c(var1x, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
               }

               protected Object k(Object var1x) {
                  int var2 = this.h;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                     }

                     this.h = 2;
                     l.b(var1x);
                  } else {
                     this.h = 1;
                     l.b(var1x);
                     k.c(var0, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                     var1x = ((p)t.a(var0, 2)).h(var1, this);
                  }

                  return var1x;
               }
            };
         }
      }

      return (r0.d)var4;
   }

   public static <T> r0.d<T> b(r0.d<? super T> var0) {
      k.e(var0, "<this>");
      t0.d var1;
      if (var0 instanceof t0.d) {
         var1 = (t0.d)var0;
      } else {
         var1 = null;
      }

      r0.d var2 = var0;
      if (var1 != null) {
         var2 = var1.n();
         if (var2 == null) {
            var2 = var0;
         }
      }

      return var2;
   }
}
