package o;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k implements Comparable<k> {
   public static final k.a j = new k.a((a1.g)null);
   private static final k k = new k(0, 0, 0, "");
   private static final k l = new k(0, 1, 0, "");
   private static final k m;
   private static final k n;
   private final int e;
   private final int f;
   private final int g;
   private final String h;
   private final p0.e i;

   static {
      k var0 = new k(1, 0, 0, "");
      m = var0;
      n = var0;
   }

   private k(int var1, int var2, int var3, String var4) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.i = p0.f.a(new z0.a<BigInteger>() {
         public final BigInteger a() {
            return BigInteger.valueOf((long)k.this.d()).shiftLeft(32).or(BigInteger.valueOf((long)k.this.e())).shiftLeft(32).or(BigInteger.valueOf((long)k.this.f()));
         }
      });
   }

   // $FF: synthetic method
   public k(int var1, int var2, int var3, String var4, a1.g var5) {
      this(var1, var2, var3, var4);
   }

   private final BigInteger c() {
      Object var1 = this.i.getValue();
      a1.k.d(var1, "<get-bigInteger>(...)");
      return (BigInteger)var1;
   }

   public int b(k var1) {
      a1.k.e(var1, "other");
      return this.c().compareTo(var1.c());
   }

   public final int d() {
      return this.e;
   }

   public final int e() {
      return this.f;
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof k;
      boolean var3 = false;
      if (!var2) {
         return false;
      } else {
         int var4 = this.e;
         k var5 = (k)var1;
         var2 = var3;
         if (var4 == var5.e) {
            var2 = var3;
            if (this.f == var5.f) {
               var2 = var3;
               if (this.g == var5.g) {
                  var2 = true;
               }
            }
         }

         return var2;
      }
   }

   public final int f() {
      return this.g;
   }

   public int hashCode() {
      return ((527 + this.e) * 31 + this.f) * 31 + this.g;
   }

   public String toString() {
      String var3;
      if (g1.d.h(this.h) ^ true) {
         StringBuilder var1 = new StringBuilder();
         var1.append('-');
         var1.append(this.h);
         var3 = var1.toString();
      } else {
         var3 = "";
      }

      StringBuilder var2 = new StringBuilder();
      var2.append(this.e);
      var2.append('.');
      var2.append(this.f);
      var2.append('.');
      var2.append(this.g);
      var2.append(var3);
      return var2.toString();
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      public final k a() {
         return o.k.l;
      }

      public final k b(String var1) {
         if (var1 != null && !g1.d.h(var1)) {
            Matcher var6 = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(var1);
            if (!var6.matches()) {
               return null;
            }

            String var2 = var6.group(1);
            if (var2 != null) {
               int var3 = Integer.parseInt(var2);
               var2 = var6.group(2);
               if (var2 != null) {
                  int var4 = Integer.parseInt(var2);
                  var2 = var6.group(3);
                  if (var2 != null) {
                     int var5 = Integer.parseInt(var2);
                     if (var6.group(4) != null) {
                        var1 = var6.group(4);
                     } else {
                        var1 = "";
                     }

                     a1.k.d(var1, "description");
                     return new k(var3, var4, var5, var1, (a1.g)null);
                  }
               }
            }
         }

         return null;
      }
   }
}
