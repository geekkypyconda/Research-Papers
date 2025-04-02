package o;

public abstract class h<T> {
   public static final h.a a = new h.a((a1.g)null);

   public abstract T a();

   protected final String b(Object var1, String var2) {
      a1.k.e(var1, "value");
      a1.k.e(var2, "message");
      StringBuilder var3 = new StringBuilder();
      var3.append(var2);
      var3.append(" value: ");
      var3.append(var1);
      return var3.toString();
   }

   public abstract h<T> c(String var1, z0.l<? super T, Boolean> var2);

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      // $FF: synthetic method
      public static h b(h.a var0, Object var1, String var2, j var3, g var4, int var5, Object var6) {
         if ((var5 & 2) != 0) {
            var3 = c.a.a();
         }

         if ((var5 & 4) != 0) {
            var4 = o.a.a;
         }

         return var0.a(var1, var2, var3, (g)var4);
      }

      public final <T> h<T> a(T var1, String var2, j var3, g var4) {
         a1.k.e(var1, "<this>");
         a1.k.e(var2, "tag");
         a1.k.e(var3, "verificationMode");
         a1.k.e(var4, "logger");
         return new i(var1, var2, var3, var4);
      }
   }
}
