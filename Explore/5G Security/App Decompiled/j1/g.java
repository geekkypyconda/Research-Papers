package j1;

public final class g {
   public static final <E> d<E> a(int var0, a var1, z0.l<? super E, p0.q> var2) {
      Object var5;
      if (var0 != -2) {
         boolean var3 = false;
         if (var0 != -1) {
            if (var0 != 0) {
               if (var0 != Integer.MAX_VALUE) {
                  if (var1 == a.e) {
                     var5 = new b(var0, var2);
                  } else {
                     var5 = new o(var0, var1, var2);
                  }
               } else {
                  var5 = new b(Integer.MAX_VALUE, var2);
               }
            } else if (var1 == a.e) {
               var5 = new b(0, var2);
            } else {
               var5 = new o(1, var1, var2);
            }
         } else {
            boolean var4 = var3;
            if (var1 == a.e) {
               var4 = true;
            }

            if (!var4) {
               throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }

            var5 = new o(1, a.f, var2);
         }
      } else if (var1 == a.e) {
         var5 = new b(d.c.a(), var2);
      } else {
         var5 = new o(1, var1, var2);
      }

      return (d)var5;
   }

   // $FF: synthetic method
   public static d b(int var0, a var1, z0.l var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var0 = 0;
      }

      if ((var3 & 2) != 0) {
         var1 = a.e;
      }

      if ((var3 & 4) != 0) {
         var2 = null;
      }

      return a(var0, var1, var2);
   }
}
