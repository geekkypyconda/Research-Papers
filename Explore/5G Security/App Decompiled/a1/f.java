package a1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class f {
   private static final Object[] a = new Object[0];

   public static final Object[] a(Collection<?> var0) {
      k.e(var0, "collection");
      int var1 = var0.size();
      Object[] var6;
      if (var1 != 0) {
         Iterator var2 = var0.iterator();
         if (var2.hasNext()) {
            var6 = new Object[var1];
            var1 = 0;

            while(true) {
               int var3 = var1 + 1;
               var6[var1] = var2.next();
               Object[] var5;
               if (var3 >= var6.length) {
                  if (!var2.hasNext()) {
                     return var6;
                  }

                  int var4 = var3 * 3 + 1 >>> 1;
                  var1 = var4;
                  if (var4 <= var3) {
                     if (var3 >= 2147483645) {
                        throw new OutOfMemoryError();
                     }

                     var1 = 2147483645;
                  }

                  var5 = Arrays.copyOf(var6, var1);
                  k.d(var5, "copyOf(result, newSize)");
               } else {
                  var5 = var6;
                  if (!var2.hasNext()) {
                     var6 = Arrays.copyOf(var6, var3);
                     k.d(var6, "copyOf(result, size)");
                     return var6;
                  }
               }

               var1 = var3;
               var6 = var5;
            }
         }
      }

      var6 = a;
      return var6;
   }

   public static final Object[] b(Collection<?> var0, Object[] var1) {
      k.e(var0, "collection");
      var1.getClass();
      int var2 = var0.size();
      int var3 = 0;
      Object[] var7;
      if (var2 == 0) {
         var7 = var1;
         if (var1.length > 0) {
            var1[0] = null;
            var7 = var1;
         }
      } else {
         Iterator var4 = var0.iterator();
         if (!var4.hasNext()) {
            var7 = var1;
            if (var1.length > 0) {
               var1[0] = null;
               var7 = var1;
            }
         } else {
            if (var2 <= var1.length) {
               var7 = var1;
            } else {
               Object var8 = Array.newInstance(var1.getClass().getComponentType(), var2);
               k.c(var8, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
               var7 = (Object[])var8;
            }

            while(true) {
               var2 = var3 + 1;
               var7[var3] = var4.next();
               Object[] var6;
               if (var2 >= var7.length) {
                  if (!var4.hasNext()) {
                     break;
                  }

                  int var5 = var2 * 3 + 1 >>> 1;
                  var3 = var5;
                  if (var5 <= var2) {
                     if (var2 >= 2147483645) {
                        throw new OutOfMemoryError();
                     }

                     var3 = 2147483645;
                  }

                  var6 = Arrays.copyOf(var7, var3);
                  k.d(var6, "copyOf(result, newSize)");
               } else {
                  var6 = var7;
                  if (!var4.hasNext()) {
                     if (var7 == var1) {
                        var1[var2] = null;
                        var7 = var1;
                     } else {
                        var7 = Arrays.copyOf(var7, var2);
                        k.d(var7, "copyOf(result, size)");
                     }
                     break;
                  }
               }

               var3 = var2;
               var7 = var6;
            }
         }
      }

      return var7;
   }
}
