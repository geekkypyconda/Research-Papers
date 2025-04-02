package p1;

import h1.j;
import m1.h0;
import z0.l;
import z0.q;

public final class c {
   private static final q<Object, Object, Object, Object> a;
   private static final h0 b;
   private static final h0 c;
   private static final h0 d;
   private static final h0 e;
   private static final h0 f;

   static {
      a = null.f;
      b = new h0("STATE_REG");
      c = new h0("STATE_COMPLETED");
      d = new h0("STATE_CANCELLED");
      e = new h0("NO_RESULT");
      f = new h0("PARAM_CLAUSE_0");
   }

   private static final d a(int var0) {
      d var1;
      if (var0 != 0) {
         if (var0 != 1) {
            if (var0 != 2) {
               if (var0 != 3) {
                  StringBuilder var2 = new StringBuilder();
                  var2.append("Unexpected internal result: ");
                  var2.append(var0);
                  throw new IllegalStateException(var2.toString().toString());
               }

               var1 = p1.d.h;
            } else {
               var1 = p1.d.g;
            }
         } else {
            var1 = p1.d.f;
         }
      } else {
         var1 = p1.d.e;
      }

      return var1;
   }

   // $FF: synthetic method
   public static final d b(int var0) {
      return a(var0);
   }

   // $FF: synthetic method
   public static final h0 c() {
      return e;
   }

   // $FF: synthetic method
   public static final h0 d() {
      return d;
   }

   // $FF: synthetic method
   public static final h0 e() {
      return c;
   }

   // $FF: synthetic method
   public static final h0 f() {
      return b;
   }

   // $FF: synthetic method
   public static final boolean g(j var0, l var1) {
      return h(var0, var1);
   }

   private static final boolean h(j<? super p0.q> var0, l<? super Throwable, p0.q> var1) {
      Object var2 = var0.l(p0.q.a, (Object)null, var1);
      if (var2 == null) {
         return false;
      } else {
         var0.C(var2);
         return true;
      }
   }
}
