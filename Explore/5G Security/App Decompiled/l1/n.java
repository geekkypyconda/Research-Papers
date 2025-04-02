package l1;

import h1.h1;
import m1.d0;

public final class n {
   public static final void a(final l<?> var0, r0.g var1) {
      if (((Number)var1.y(0, new z0.p<Integer, r0.g.b, Integer>() {
         public final Integer a(int var1, r0.g.b var2) {
            r0.g.c var3 = var2.getKey();
            r0.g.b var4 = var0.i.b(var3);
            if (var3 != h1.b) {
               if (var2 != var4) {
                  var1 = Integer.MIN_VALUE;
               } else {
                  ++var1;
               }

               return var1;
            } else {
               h1 var7 = (h1)var4;
               a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.Job");
               h1 var5 = n.b((h1)var2, var7);
               if (var5 == var7) {
                  if (var7 != null) {
                     ++var1;
                  }

                  return var1;
               } else {
                  StringBuilder var6 = new StringBuilder();
                  var6.append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of ");
                  var6.append(var5);
                  var6.append(", expected child of ");
                  var6.append(var7);
                  var6.append(".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'");
                  throw new IllegalStateException(var6.toString().toString());
               }
            }
         }
      })).intValue() != var0.j) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Flow invariant is violated:\n\t\tFlow was collected in ");
         var2.append(var0.i);
         var2.append(",\n\t\tbut emission happened in ");
         var2.append(var1);
         var2.append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
         throw new IllegalStateException(var2.toString().toString());
      }
   }

   public static final h1 b(h1 var0, h1 var1) {
      while(var0 != null) {
         if (var0 == var1) {
            return var0;
         }

         if (!(var0 instanceof d0)) {
            return var0;
         }

         var0 = var0.getParent();
      }

      return null;
   }
}
