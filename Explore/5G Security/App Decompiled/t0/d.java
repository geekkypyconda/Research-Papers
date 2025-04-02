package t0;

public abstract class d extends a {
   private final r0.g f;
   private transient r0.d<Object> g;

   public d(r0.d<Object> var1) {
      r0.g var2;
      if (var1 != null) {
         var2 = var1.a();
      } else {
         var2 = null;
      }

      this(var1, var2);
   }

   public d(r0.d<Object> var1, r0.g var2) {
      super(var1);
      this.f = var2;
   }

   public r0.g a() {
      r0.g var1 = this.f;
      a1.k.b(var1);
      return var1;
   }

   protected void m() {
      r0.d var1 = this.g;
      if (var1 != null && var1 != this) {
         r0.g.b var2 = this.a().b(r0.e.d);
         a1.k.b(var2);
         ((r0.e)var2).v(var1);
      }

      this.g = c.e;
   }

   public final r0.d<Object> n() {
      r0.d var1 = this.g;
      Object var2 = var1;
      if (var1 == null) {
         label13: {
            r0.e var3 = (r0.e)this.a().b(r0.e.d);
            if (var3 != null) {
               var1 = var3.j(this);
               var2 = var1;
               if (var1 != null) {
                  break label13;
               }
            }

            var2 = this;
         }

         this.g = (r0.d)var2;
      }

      return (r0.d)var2;
   }
}
