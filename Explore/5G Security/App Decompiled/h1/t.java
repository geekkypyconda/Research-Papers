package h1;

final class t {
   public final Object a;
   public final h b;
   public final z0.l<Throwable, p0.q> c;
   public final Object d;
   public final Throwable e;

   public t(Object var1, h var2, z0.l<? super Throwable, p0.q> var3, Object var4, Throwable var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   // $FF: synthetic method
   public t(Object var1, h var2, z0.l var3, Object var4, Throwable var5, int var6, a1.g var7) {
      if ((var6 & 2) != 0) {
         var2 = null;
      }

      if ((var6 & 4) != 0) {
         var3 = null;
      }

      if ((var6 & 8) != 0) {
         var4 = null;
      }

      if ((var6 & 16) != 0) {
         var5 = null;
      }

      this(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static t b(t var0, Object var1, h var2, z0.l var3, Object var4, Throwable var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.a;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.b;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.c;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.d;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.e;
      }

      return var0.a(var1, var2, var3, var4, var5);
   }

   public final t a(Object var1, h var2, z0.l<? super Throwable, p0.q> var3, Object var4, Throwable var5) {
      return new t(var1, var2, var3, var4, var5);
   }

   public final boolean c() {
      boolean var1;
      if (this.e != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final void d(k<?> var1, Throwable var2) {
      h var3 = this.b;
      if (var3 != null) {
         var1.j(var3, var2);
      }

      z0.l var4 = this.c;
      if (var4 != null) {
         var1.k(var4, var2);
      }

   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof t)) {
         return false;
      } else {
         t var2 = (t)var1;
         if (!a1.k.a(this.a, var2.a)) {
            return false;
         } else if (!a1.k.a(this.b, var2.b)) {
            return false;
         } else if (!a1.k.a(this.c, var2.c)) {
            return false;
         } else if (!a1.k.a(this.d, var2.d)) {
            return false;
         } else {
            return a1.k.a(this.e, var2.e);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.a;
      int var2 = 0;
      int var3;
      if (var1 == null) {
         var3 = 0;
      } else {
         var3 = var1.hashCode();
      }

      h var7 = this.b;
      int var4;
      if (var7 == null) {
         var4 = 0;
      } else {
         var4 = var7.hashCode();
      }

      z0.l var8 = this.c;
      int var5;
      if (var8 == null) {
         var5 = 0;
      } else {
         var5 = var8.hashCode();
      }

      var1 = this.d;
      int var6;
      if (var1 == null) {
         var6 = 0;
      } else {
         var6 = var1.hashCode();
      }

      Throwable var9 = this.e;
      if (var9 != null) {
         var2 = var9.hashCode();
      }

      return (((var3 * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("CompletedContinuation(result=");
      var1.append(this.a);
      var1.append(", cancelHandler=");
      var1.append(this.b);
      var1.append(", onCancellation=");
      var1.append(this.c);
      var1.append(", idempotentResume=");
      var1.append(this.d);
      var1.append(", cancelCause=");
      var1.append(this.e);
      var1.append(')');
      return var1.toString();
   }
}
