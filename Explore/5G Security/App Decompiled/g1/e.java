package g1;

class e {
   public static <T> void a(Appendable var0, T var1, z0.l<? super T, ? extends CharSequence> var2) {
      label25: {
         a1.k.e(var0, "<this>");
         if (var2 != null) {
            var1 = var2.i(var1);
         } else {
            boolean var3;
            if (var1 == null) {
               var3 = true;
            } else {
               var3 = var1 instanceof CharSequence;
            }

            if (!var3) {
               if (var1 instanceof Character) {
                  var0.append((Character)var1);
                  return;
               }

               var1 = String.valueOf(var1);
               break label25;
            }
         }

         var1 = (CharSequence)var1;
      }

      var0.append((CharSequence)var1);
   }
}
