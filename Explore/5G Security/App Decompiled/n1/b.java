package n1;

import a1.t;
import h1.p1;
import h1.u;
import m1.d0;
import m1.l0;
import p0.k;
import p0.l;
import r0.d;
import r0.g;
import t0.h;
import z0.p;

public final class b {
   public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> var0, R var1, d<? super T> var2) {
      d var3 = h.a(var2);

      Object var23;
      label180: {
         label179: {
            Throwable var10000;
            label178: {
               Object var4;
               boolean var10001;
               g var26;
               try {
                  var26 = var2.a();
                  var4 = l0.c(var26, (Object)null);
               } catch (Throwable var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label178;
               }

               try {
                  var23 = ((p)t.a(var0, 2)).h(var1, var3);
                  break label179;
               } finally {
                  label172:
                  try {
                     l0.a(var26, var4);
                  } catch (Throwable var20) {
                     var10000 = var20;
                     var10001 = false;
                     break label172;
                  }
               }
            }

            Throwable var24 = var10000;
            k.a var25 = k.e;
            var23 = l.a(var24);
            break label180;
         }

         if (var23 == s0.b.c()) {
            return;
         }
      }

      var3.u(k.a(var23));
   }

   public static final <T, R> Object b(d0<? super T> var0, R var1, p<? super R, ? super d<? super T>, ? extends Object> var2) {
      label48:
      try {
         var1 = ((p)t.a(var2, 2)).h(var1, var0);
      } catch (Throwable var4) {
         var1 = new u(var4, false, 2, (a1.g)null);
         break label48;
      }

      Object var5;
      if (var1 != s0.b.c()) {
         var5 = var0.j0(var1);
         if (var5 != p1.b) {
            if (var5 instanceof u) {
               throw ((u)var5).a;
            }

            var5 = p1.h(var5);
            return var5;
         }
      }

      var5 = s0.b.c();
      return var5;
   }
}
