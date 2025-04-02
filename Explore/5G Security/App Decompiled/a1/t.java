package a1;

import z0.u;
import z0.v;
import z0.w;

public class t {
   public static Object a(Object var0, int var1) {
      if (var0 != null && !c(var0, var1)) {
         StringBuilder var2 = new StringBuilder();
         var2.append("kotlin.jvm.functions.Function");
         var2.append(var1);
         f(var0, var2.toString());
      }

      return var0;
   }

   public static int b(Object var0) {
      if (var0 instanceof h) {
         return ((h)var0).e();
      } else if (var0 instanceof z0.a) {
         return 0;
      } else if (var0 instanceof z0.l) {
         return 1;
      } else if (var0 instanceof z0.p) {
         return 2;
      } else if (var0 instanceof z0.q) {
         return 3;
      } else if (var0 instanceof z0.r) {
         return 4;
      } else if (var0 instanceof z0.s) {
         return 5;
      } else if (var0 instanceof z0.t) {
         return 6;
      } else if (var0 instanceof u) {
         return 7;
      } else if (var0 instanceof v) {
         return 8;
      } else if (var0 instanceof w) {
         return 9;
      } else if (var0 instanceof z0.b) {
         return 10;
      } else if (var0 instanceof z0.c) {
         return 11;
      } else if (var0 instanceof z0.d) {
         return 12;
      } else if (var0 instanceof z0.e) {
         return 13;
      } else if (var0 instanceof z0.f) {
         return 14;
      } else if (var0 instanceof z0.g) {
         return 15;
      } else if (var0 instanceof z0.h) {
         return 16;
      } else if (var0 instanceof z0.i) {
         return 17;
      } else if (var0 instanceof z0.j) {
         return 18;
      } else if (var0 instanceof z0.k) {
         return 19;
      } else if (var0 instanceof z0.m) {
         return 20;
      } else if (var0 instanceof z0.n) {
         return 21;
      } else {
         return var0 instanceof z0.o ? 22 : -1;
      }
   }

   public static boolean c(Object var0, int var1) {
      boolean var2;
      if (var0 instanceof p0.c && b(var0) == var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private static <T extends Throwable> T d(T var0) {
      return k.i(var0, t.class.getName());
   }

   public static ClassCastException e(ClassCastException var0) {
      throw (ClassCastException)d(var0);
   }

   public static void f(Object var0, String var1) {
      String var3;
      if (var0 == null) {
         var3 = "null";
      } else {
         var3 = var0.getClass().getName();
      }

      StringBuilder var2 = new StringBuilder();
      var2.append(var3);
      var2.append(" cannot be cast to ");
      var2.append(var1);
      g(var2.toString());
   }

   public static void g(String var0) {
      throw e(new ClassCastException(var0));
   }
}
