package j1;

public final class h<T> {
   public static final h.b b = new h.b((a1.g)null);
   private static final h.c c = new h.c();
   private final Object a;

   // $FF: synthetic method
   private h(Object var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   public static final h b(Object var0) {
      return new h(var0);
   }

   public static <T> Object c(Object var0) {
      return var0;
   }

   public static boolean d(Object var0, Object var1) {
      if (!(var1 instanceof h)) {
         return false;
      } else {
         return a1.k.a(var0, ((h)var1).j());
      }
   }

   public static final Throwable e(Object var0) {
      boolean var1 = var0 instanceof h.a;
      Throwable var2 = null;
      h.a var3;
      if (var1) {
         var3 = (h.a)var0;
      } else {
         var3 = null;
      }

      if (var3 != null) {
         var2 = var3.a;
      }

      return var2;
   }

   public static int f(Object var0) {
      int var1;
      if (var0 == null) {
         var1 = 0;
      } else {
         var1 = var0.hashCode();
      }

      return var1;
   }

   public static final boolean g(Object var0) {
      return var0 instanceof h.a;
   }

   public static final boolean h(Object var0) {
      return var0 instanceof h.c ^ true;
   }

   public static String i(Object var0) {
      String var2;
      if (var0 instanceof h.a) {
         var2 = ((h.a)var0).toString();
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append("Value(");
         var1.append(var0);
         var1.append(')');
         var2 = var1.toString();
      }

      return var2;
   }

   public boolean equals(Object var1) {
      return d(this.a, var1);
   }

   public int hashCode() {
      return f(this.a);
   }

   // $FF: synthetic method
   public final Object j() {
      return this.a;
   }

   public String toString() {
      return i(this.a);
   }

   public static final class a extends h.c {
      public final Throwable a;

      public a(Throwable var1) {
         this.a = var1;
      }

      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof h.a && a1.k.a(this.a, ((h.a)var1).a)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public int hashCode() {
         Throwable var1 = this.a;
         int var2;
         if (var1 != null) {
            var2 = var1.hashCode();
         } else {
            var2 = 0;
         }

         return var2;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Closed(");
         var1.append(this.a);
         var1.append(')');
         return var1.toString();
      }
   }

   public static final class b {
      private b() {
      }

      // $FF: synthetic method
      public b(a1.g var1) {
         this();
      }

      public final <E> Object a(Throwable var1) {
         return h.c(new h.a(var1));
      }

      public final <E> Object b() {
         return h.c(h.c);
      }

      public final <E> Object c(E var1) {
         return h.c(var1);
      }
   }

   public static class c {
      public String toString() {
         return "Failed";
      }
   }
}
