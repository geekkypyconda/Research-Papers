package o;

final class f<T> extends h<T> {
   private final T b;
   private final String c;
   private final String d;
   private final g e;
   private final j f;
   private final l g;

   public f(T var1, String var2, String var3, g var4, j var5) {
      a1.k.e(var1, "value");
      a1.k.e(var2, "tag");
      a1.k.e(var3, "message");
      a1.k.e(var4, "logger");
      a1.k.e(var5, "verificationMode");
      super();
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      l var6 = new l(this.b(var1, var3));
      StackTraceElement[] var7 = var6.getStackTrace();
      a1.k.d(var7, "stackTrace");
      var6.setStackTrace((StackTraceElement[])q0.f.g(var7, 2).toArray(new StackTraceElement[0]));
      this.g = var6;
   }

   public T a() {
      j var1 = this.f;
      int var2 = f.a.a[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               throw new p0.i();
            }
         } else {
            this.e.a(this.c, this.b(this.b, this.d));
         }

         return null;
      } else {
         throw this.g;
      }
   }

   public h<T> c(String var1, z0.l<? super T, Boolean> var2) {
      a1.k.e(var1, "message");
      a1.k.e(var2, "condition");
      return this;
   }

   // $FF: synthetic class
   public final class a {
      // $FF: synthetic field
      public static final int[] a;

      static {
         int[] var0 = new int[j.values().length];

         try {
            var0[j.e.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[j.f.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[j.g.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         a = var0;
      }
   }
}
