package o;

final class i<T> extends h<T> {
   private final T b;
   private final String c;
   private final j d;
   private final g e;

   public i(T var1, String var2, j var3, g var4) {
      a1.k.e(var1, "value");
      a1.k.e(var2, "tag");
      a1.k.e(var3, "verificationMode");
      a1.k.e(var4, "logger");
      super();
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   public T a() {
      return this.b;
   }

   public h<T> c(String var1, z0.l<? super T, Boolean> var2) {
      a1.k.e(var1, "message");
      a1.k.e(var2, "condition");
      Object var3;
      if ((Boolean)var2.i(this.b)) {
         var3 = this;
      } else {
         var3 = new f(this.b, this.c, var1, this.e, this.d);
      }

      return (h)var3;
   }
}
