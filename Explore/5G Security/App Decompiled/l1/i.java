package l1;

public interface i<T> extends k1.c<T> {
   k1.c<T> b(r0.g var1, int var2, j1.a var3);

   public static final class a {
      // $FF: synthetic method
      public static k1.c a(i var0, r0.g var1, int var2, j1.a var3, int var4, Object var5) {
         if (var5 == null) {
            if ((var4 & 1) != 0) {
               var1 = r0.h.e;
            }

            if ((var4 & 2) != 0) {
               var2 = -3;
            }

            if ((var4 & 4) != 0) {
               var3 = j1.a.e;
            }

            return var0.b((r0.g)var1, var2, var3);
         } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
         }
      }
   }
}
