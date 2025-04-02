package h1;

public enum g0 {
   e,
   f,
   g,
   h;

   // $FF: synthetic method
   private static final g0[] a() {
      return new g0[]{e, f, g, h};
   }

   public final <R, T> void b(z0.p<? super R, ? super r0.d<? super T>, ? extends Object> var1, R var2, r0.d<? super T> var3) {
      int var4 = g0.a.a[this.ordinal()];
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 != 3) {
               if (var4 != 4) {
                  throw new p0.i();
               }
            } else {
               n1.b.a(var1, var2, var3);
            }
         } else {
            r0.f.a(var1, var2, var3);
         }
      } else {
         n1.a.d(var1, var2, var3, (z0.l)null, 4, (Object)null);
      }

   }

   public final boolean c() {
      boolean var1;
      if (this == f) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   // $FF: synthetic class
   public final class a {
      // $FF: synthetic field
      public static final int[] a;

      static {
         int[] var0 = new int[g0.values().length];

         try {
            var0[g0.e.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[g0.g.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[g0.h.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[g0.f.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         a = var0;
      }
   }
}
