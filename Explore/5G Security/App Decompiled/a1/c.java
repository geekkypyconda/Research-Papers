package a1;

import java.io.Serializable;

public abstract class c implements e1.a, Serializable {
   public static final Object k;
   private transient e1.a e;
   protected final Object f;
   private final Class g;
   private final String h;
   private final String i;
   private final boolean j;

   static {
      k = c.a.e;
   }

   public c() {
      this(k);
   }

   protected c(Object var1) {
      this(var1, (Class)null, (String)null, (String)null, false);
   }

   protected c(Object var1, Class var2, String var3, String var4, boolean var5) {
      this.f = var1;
      this.g = var2;
      this.h = var3;
      this.i = var4;
      this.j = var5;
   }

   public e1.a a() {
      e1.a var1 = this.e;
      e1.a var2 = var1;
      if (var1 == null) {
         var2 = this.c();
         this.e = var2;
      }

      return var2;
   }

   protected abstract e1.a c();

   public Object d() {
      return this.f;
   }

   public String f() {
      return this.h;
   }

   public e1.d j() {
      Class var1 = this.g;
      Object var2;
      if (var1 == null) {
         var2 = null;
      } else if (this.j) {
         var2 = r.c(var1);
      } else {
         var2 = r.b(var1);
      }

      return (e1.d)var2;
   }

   public String k() {
      return this.i;
   }

   private static class a implements Serializable {
      private static final c.a e = new c.a();
   }
}
