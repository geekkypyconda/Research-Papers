package g1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import q0.a0;

class n extends m {
   // $FF: synthetic method
   public static int A(CharSequence var0, char var1, int var2, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = q(var0);
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      return y(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static int B(CharSequence var0, String var1, int var2, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = q(var0);
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      return z(var0, var1, var2, var3);
   }

   public static final int C(CharSequence var0, char[] var1, int var2, boolean var3) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "chars");
      if (!var3 && var1.length == 1 && var0 instanceof String) {
         char var9 = q0.f.j(var1);
         return ((String)var0).lastIndexOf(var9, var2);
      } else {
         for(var2 = d1.d.c(var2, q(var0)); -1 < var2; --var2) {
            char var5 = var0.charAt(var2);
            int var6 = var1.length;
            boolean var7 = false;
            int var8 = 0;

            boolean var4;
            while(true) {
               var4 = var7;
               if (var8 >= var6) {
                  break;
               }

               if (b.d(var1[var8], var5, var3)) {
                  var4 = true;
                  break;
               }

               ++var8;
            }

            if (var4) {
               return var2;
            }
         }

         return -1;
      }
   }

   public static final f1.b<String> D(CharSequence var0) {
      a1.k.e(var0, "<this>");
      return K(var0, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object)null);
   }

   public static final List<String> E(CharSequence var0) {
      a1.k.e(var0, "<this>");
      return f1.c.e(D(var0));
   }

   private static final f1.b<d1.c> F(CharSequence var0, String[] var1, int var2, final boolean var3, int var4) {
      I(var4);
      return new c(var0, var2, var4, new z0.p<CharSequence, Integer, p0.j<? extends Integer, ? extends Integer>>(q0.f.b(var1)) {
         // $FF: synthetic field
         final List<String> f;

         {
            this.f = var1;
         }

         public final p0.j<Integer, Integer> a(CharSequence var1, int var2) {
            a1.k.e(var1, "$this$$receiver");
            p0.j var3x = n.o(var1, this.f, var2, var3, false);
            if (var3x != null) {
               var3x = p0.n.a(var3x.c(), ((String)var3x.d()).length());
            } else {
               var3x = null;
            }

            return var3x;
         }
      });
   }

   // $FF: synthetic method
   static f1.b G(CharSequence var0, String[] var1, int var2, boolean var3, int var4, int var5, Object var6) {
      if ((var5 & 2) != 0) {
         var2 = 0;
      }

      if ((var5 & 4) != 0) {
         var3 = false;
      }

      if ((var5 & 8) != 0) {
         var4 = 0;
      }

      return F(var0, var1, var2, var3, var4);
   }

   public static final boolean H(CharSequence var0, int var1, CharSequence var2, int var3, int var4, boolean var5) {
      a1.k.e(var0, "<this>");
      a1.k.e(var2, "other");
      if (var3 >= 0 && var1 >= 0 && var1 <= var0.length() - var4 && var3 <= var2.length() - var4) {
         for(int var6 = 0; var6 < var4; ++var6) {
            if (!b.d(var0.charAt(var1 + var6), var2.charAt(var3 + var6), var5)) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static final void I(int var0) {
      boolean var1;
      if (var0 >= 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (!var1) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Limit must be non-negative, but was ");
         var2.append(var0);
         throw new IllegalArgumentException(var2.toString().toString());
      }
   }

   public static final f1.b<String> J(final CharSequence var0, String[] var1, boolean var2, int var3) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "delimiters");
      return f1.c.c(G(var0, var1, 0, var2, var3, 2, (Object)null), new z0.l<d1.c, String>() {
         public final String a(d1.c var1) {
            a1.k.e(var1, "it");
            return n.L(var0, var1);
         }
      });
   }

   // $FF: synthetic method
   public static f1.b K(CharSequence var0, String[] var1, boolean var2, int var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      return J(var0, var1, var2, var3);
   }

   public static final String L(CharSequence var0, d1.c var1) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "range");
      return var0.subSequence(var1.h(), var1.g() + 1).toString();
   }

   public static final String M(String var0, char var1, String var2) {
      a1.k.e(var0, "<this>");
      a1.k.e(var2, "missingDelimiterValue");
      int var3 = v(var0, var1, 0, false, 6, (Object)null);
      if (var3 != -1) {
         var2 = var0.substring(var3 + 1, var0.length());
         a1.k.d(var2, "this as java.lang.String…ing(startIndex, endIndex)");
      }

      return var2;
   }

   public static final String N(String var0, String var1, String var2) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "delimiter");
      a1.k.e(var2, "missingDelimiterValue");
      int var3 = w(var0, var1, 0, false, 6, (Object)null);
      if (var3 != -1) {
         var2 = var0.substring(var3 + var1.length(), var0.length());
         a1.k.d(var2, "this as java.lang.String…ing(startIndex, endIndex)");
      }

      return var2;
   }

   // $FF: synthetic method
   public static String O(String var0, char var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = var0;
      }

      return M(var0, var1, var2);
   }

   // $FF: synthetic method
   public static String P(String var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = var0;
      }

      return N(var0, var1, var2);
   }

   public static final String Q(String var0, char var1, String var2) {
      a1.k.e(var0, "<this>");
      a1.k.e(var2, "missingDelimiterValue");
      int var3 = A(var0, var1, 0, false, 6, (Object)null);
      if (var3 != -1) {
         var2 = var0.substring(var3 + 1, var0.length());
         a1.k.d(var2, "this as java.lang.String…ing(startIndex, endIndex)");
      }

      return var2;
   }

   // $FF: synthetic method
   public static String R(String var0, char var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = var0;
      }

      return Q(var0, var1, var2);
   }

   public static final String S(String var0, char var1, String var2) {
      a1.k.e(var0, "<this>");
      a1.k.e(var2, "missingDelimiterValue");
      int var3 = v(var0, var1, 0, false, 6, (Object)null);
      if (var3 != -1) {
         var2 = var0.substring(0, var3);
         a1.k.d(var2, "this as java.lang.String…ing(startIndex, endIndex)");
      }

      return var2;
   }

   public static final String T(String var0, String var1, String var2) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "delimiter");
      a1.k.e(var2, "missingDelimiterValue");
      int var3 = w(var0, var1, 0, false, 6, (Object)null);
      if (var3 != -1) {
         var2 = var0.substring(0, var3);
         a1.k.d(var2, "this as java.lang.String…ing(startIndex, endIndex)");
      }

      return var2;
   }

   // $FF: synthetic method
   public static String U(String var0, char var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = var0;
      }

      return S(var0, var1, var2);
   }

   // $FF: synthetic method
   public static String V(String var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = var0;
      }

      return T(var0, var1, var2);
   }

   public static CharSequence W(CharSequence var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.length() - 1;
      int var2 = 0;
      boolean var3 = false;

      while(var2 <= var1) {
         int var4;
         if (!var3) {
            var4 = var2;
         } else {
            var4 = var1;
         }

         boolean var5 = a.c(var0.charAt(var4));
         if (!var3) {
            if (!var5) {
               var3 = true;
            } else {
               ++var2;
            }
         } else {
            if (!var5) {
               break;
            }

            --var1;
         }
      }

      return var0.subSequence(var2, var1 + 1);
   }

   private static final p0.j<Integer, String> o(CharSequence var0, Collection<String> var1, int var2, boolean var3, boolean var4) {
      Object var5 = null;
      if (!var3 && var1.size() == 1) {
         String var12 = (String)q0.l.r(var1);
         if (!var4) {
            var2 = w(var0, var12, var2, false, 4, (Object)null);
         } else {
            var2 = d.B(var0, var12, var2, false, 4, (Object)null);
         }

         p0.j var13;
         if (var2 < 0) {
            var13 = (p0.j)var5;
         } else {
            var13 = p0.n.a(var2, var12);
         }

         return var13;
      } else {
         if (!var4) {
            var5 = new d1.c(d1.d.a(var2, 0), var0.length());
         } else {
            var5 = d1.d.f(d1.d.c(var2, q(var0)), 0);
         }

         int var6;
         int var7;
         int var8;
         String var11;
         String var14;
         if (var0 instanceof String) {
            label108: {
               var6 = ((d1.a)var5).a();
               var7 = ((d1.a)var5).b();
               var8 = ((d1.a)var5).c();
               if (var8 > 0) {
                  var2 = var6;
                  if (var6 <= var7) {
                     break label108;
                  }
               }

               if (var8 >= 0 || var7 > var6) {
                  return null;
               }

               var2 = var6;
            }

            while(true) {
               Iterator var15 = var1.iterator();

               String var16;
               do {
                  if (!var15.hasNext()) {
                     var5 = null;
                     break;
                  }

                  var5 = var15.next();
                  var16 = (String)var5;
               } while(!m.i(var16, 0, (String)var0, var2, var16.length(), var3));

               var14 = (String)var5;
               if (var14 != null) {
                  var11 = var14;
                  return p0.n.a(var2, var11);
               }

               if (var2 == var7) {
                  break;
               }

               var2 += var8;
            }
         } else {
            label110: {
               var6 = ((d1.a)var5).a();
               var7 = ((d1.a)var5).b();
               var8 = ((d1.a)var5).c();
               if (var8 > 0) {
                  var2 = var6;
                  if (var6 <= var7) {
                     break label110;
                  }
               }

               if (var8 >= 0 || var7 > var6) {
                  return null;
               }

               var2 = var6;
            }

            while(true) {
               Iterator var10 = var1.iterator();

               String var9;
               do {
                  if (!var10.hasNext()) {
                     var5 = null;
                     break;
                  }

                  var5 = var10.next();
                  var9 = (String)var5;
               } while(!H(var9, 0, var0, var2, var9.length(), var3));

               var14 = (String)var5;
               if (var14 != null) {
                  var11 = var14;
                  return p0.n.a(var2, var11);
               }

               if (var2 == var7) {
                  break;
               }

               var2 += var8;
            }
         }

         return null;
      }
   }

   public static final d1.c p(CharSequence var0) {
      a1.k.e(var0, "<this>");
      return new d1.c(0, var0.length() - 1);
   }

   public static final int q(CharSequence var0) {
      a1.k.e(var0, "<this>");
      return var0.length() - 1;
   }

   public static final int r(CharSequence var0, char var1, int var2, boolean var3) {
      a1.k.e(var0, "<this>");
      if (!var3 && var0 instanceof String) {
         var2 = ((String)var0).indexOf(var1, var2);
      } else {
         var2 = x(var0, new char[]{var1}, var2, var3);
      }

      return var2;
   }

   public static final int s(CharSequence var0, String var1, int var2, boolean var3) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "string");
      if (!var3 && var0 instanceof String) {
         var2 = ((String)var0).indexOf(var1, var2);
      } else {
         var2 = u(var0, var1, var2, var0.length(), var3, false, 16, (Object)null);
      }

      return var2;
   }

   private static final int t(CharSequence var0, CharSequence var1, int var2, int var3, boolean var4, boolean var5) {
      Object var6;
      if (!var5) {
         var6 = new d1.c(d1.d.a(var2, 0), d1.d.c(var3, var0.length()));
      } else {
         var6 = d1.d.f(d1.d.c(var2, q(var0)), d1.d.a(var3, 0));
      }

      int var7;
      int var8;
      if (var0 instanceof String && var1 instanceof String) {
         label67: {
            var3 = ((d1.a)var6).a();
            var7 = ((d1.a)var6).b();
            var8 = ((d1.a)var6).c();
            if (var8 > 0) {
               var2 = var3;
               if (var3 <= var7) {
                  break label67;
               }
            }

            if (var8 >= 0 || var7 > var3) {
               return -1;
            }

            var2 = var3;
         }

         while(true) {
            if (m.i((String)var1, 0, (String)var0, var2, var1.length(), var4)) {
               return var2;
            }

            if (var2 == var7) {
               break;
            }

            var2 += var8;
         }
      } else {
         label69: {
            var3 = ((d1.a)var6).a();
            var7 = ((d1.a)var6).b();
            var8 = ((d1.a)var6).c();
            if (var8 > 0) {
               var2 = var3;
               if (var3 <= var7) {
                  break label69;
               }
            }

            if (var8 >= 0 || var7 > var3) {
               return -1;
            }

            var2 = var3;
         }

         while(true) {
            if (H(var1, 0, var0, var2, var1.length(), var4)) {
               return var2;
            }

            if (var2 == var7) {
               break;
            }

            var2 += var8;
         }
      }

      return -1;
   }

   // $FF: synthetic method
   static int u(CharSequence var0, CharSequence var1, int var2, int var3, boolean var4, boolean var5, int var6, Object var7) {
      if ((var6 & 16) != 0) {
         var5 = false;
      }

      return t(var0, var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static int v(CharSequence var0, char var1, int var2, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = 0;
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      return r(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static int w(CharSequence var0, String var1, int var2, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = 0;
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      return s(var0, var1, var2, var3);
   }

   public static final int x(CharSequence var0, char[] var1, int var2, boolean var3) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "chars");
      if (!var3 && var1.length == 1 && var0 instanceof String) {
         char var9 = q0.f.j(var1);
         return ((String)var0).indexOf(var9, var2);
      } else {
         a0 var5 = (new d1.c(d1.d.a(var2, 0), q(var0))).d();

         int var4;
         boolean var8;
         label34:
         do {
            if (!var5.hasNext()) {
               return -1;
            }

            var4 = var5.nextInt();
            char var6 = var0.charAt(var4);
            int var7 = var1.length;

            for(var2 = 0; var2 < var7; ++var2) {
               if (b.d(var1[var2], var6, var3)) {
                  var8 = true;
                  continue label34;
               }
            }

            var8 = false;
         } while(!var8);

         return var4;
      }
   }

   public static final int y(CharSequence var0, char var1, int var2, boolean var3) {
      a1.k.e(var0, "<this>");
      if (!var3 && var0 instanceof String) {
         var2 = ((String)var0).lastIndexOf(var1, var2);
      } else {
         var2 = C(var0, new char[]{var1}, var2, var3);
      }

      return var2;
   }

   public static final int z(CharSequence var0, String var1, int var2, boolean var3) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "string");
      if (!var3 && var0 instanceof String) {
         var2 = ((String)var0).lastIndexOf(var1, var2);
      } else {
         var2 = t(var0, var1, var2, 0, var3, true);
      }

      return var2;
   }
}
