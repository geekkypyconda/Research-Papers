package y0;

import a1.d;
import a1.k;
import a1.r;
import e1.b;

public final class a {
   public static final <T> Class<T> a(b<T> var0) {
      k.e(var0, "<this>");
      Class var1 = ((d)var0).c();
      k.c(var1, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
      return var1;
   }

   public static final <T> Class<T> b(b<T> var0) {
      k.e(var0, "<this>");
      Class var2 = ((d)var0).c();
      if (!var2.isPrimitive()) {
         k.c(var2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
         return var2;
      } else {
         String var1 = var2.getName();
         switch(var1.hashCode()) {
         case -1325958191:
            if (var1.equals("double")) {
               var2 = Double.class;
            }
            break;
         case 104431:
            if (var1.equals("int")) {
               var2 = Integer.class;
            }
            break;
         case 3039496:
            if (var1.equals("byte")) {
               var2 = Byte.class;
            }
            break;
         case 3052374:
            if (var1.equals("char")) {
               var2 = Character.class;
            }
            break;
         case 3327612:
            if (var1.equals("long")) {
               var2 = Long.class;
            }
            break;
         case 3625364:
            if (var1.equals("void")) {
               var2 = Void.class;
            }
            break;
         case 64711720:
            if (var1.equals("boolean")) {
               var2 = Boolean.class;
            }
            break;
         case 97526364:
            if (var1.equals("float")) {
               var2 = Float.class;
            }
            break;
         case 109413500:
            if (var1.equals("short")) {
               var2 = Short.class;
            }
         }

         k.c(var2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
         return var2;
      }
   }

   public static final <T> b<T> c(Class<T> var0) {
      k.e(var0, "<this>");
      return r.b(var0);
   }
}
