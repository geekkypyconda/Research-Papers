package a1;

public class r {
   private static final s a;
   private static final e1.b[] b;

   static {
      s var0 = null;

      label18: {
         s var1;
         try {
            var1 = (s)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException var2) {
            break label18;
         }

         var0 = var1;
      }

      if (var0 == null) {
         var0 = new s();
      }

      a = var0;
      b = new e1.b[0];
   }

   public static e1.e a(i var0) {
      return a.a(var0);
   }

   public static e1.b b(Class var0) {
      return a.b(var0);
   }

   public static e1.d c(Class var0) {
      return a.c(var0, "");
   }

   public static e1.f d(n var0) {
      return a.d(var0);
   }

   public static String e(h var0) {
      return a.e(var0);
   }

   public static String f(l var0) {
      return a.f(var0);
   }
}
