package n1;

import p0.k;
import p0.l;
import p0.q;
import r0.d;
import z0.p;

public final class a {
   private static final void a(d<?> var0, Throwable var1) {
      k.a var2 = k.e;
      var0.u(k.a(l.a(var1)));
      throw var1;
   }

   public static final void b(d<? super q> var0, d<?> var1) {
      try {
         var0 = s0.b.b(var0);
         k.a var2 = k.e;
         m1.k.c(var0, k.a(q.a), (z0.l)null, 2, (Object)null);
      } catch (Throwable var4) {
         a(var1, var4);
         return;
      }

   }

   public static final <R, T> void c(p<? super R, ? super d<? super T>, ? extends Object> var0, R var1, d<? super T> var2, z0.l<? super Throwable, q> var3) {
      try {
         d var6 = s0.b.b(s0.b.a(var0, var1, var2));
         k.a var7 = k.e;
         m1.k.b(var6, k.a(q.a), var3);
      } catch (Throwable var5) {
         a(var2, var5);
         return;
      }

   }

   // $FF: synthetic method
   public static void d(p var0, Object var1, d var2, z0.l var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = null;
      }

      c(var0, var1, var2, var3);
   }
}
