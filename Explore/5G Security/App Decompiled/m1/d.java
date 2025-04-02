package m1;

public final class d {
   private static final h0 a = new h0("CLOSED");

   // $FF: synthetic method
   public static final h0 a() {
      return a;
   }

   public static final <N extends e<N>> N b(N var0) {
      while(true) {
         Object var1 = e.a(var0);
         if (var1 == a()) {
            return var0;
         }

         e var2 = (e)var1;
         if (var2 == null) {
            if (var0.j()) {
               return var0;
            }
         } else {
            var0 = var2;
         }
      }
   }

   public static final <S extends e0<S>> Object c(S var0, long var1, z0.p<? super Long, ? super S, ? extends S> var3) {
      e0 var4 = var0;

      while(true) {
         while(true) {
            if (var4.g >= var1 && !var4.h()) {
               return f0.a(var4);
            }

            Object var6 = e.a(var4);
            if (var6 == a()) {
               return f0.a(a);
            }

            var0 = (e0)((e)var6);
            if (var0 != null) {
               break;
            }

            e0 var5 = (e0)var3.h(var4.g + 1L, var4);
            if (var4.l(var5)) {
               var0 = var5;
               if (var4.h()) {
                  var4.k();
                  var0 = var5;
               }
               break;
            }
         }

         var4 = var0;
      }
   }
}
