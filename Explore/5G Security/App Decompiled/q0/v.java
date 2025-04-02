package q0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

class v extends u {
   public static final <T, A extends Appendable> A l(Iterable<? extends T> var0, A var1, CharSequence var2, CharSequence var3, CharSequence var4, int var5, CharSequence var6, z0.l<? super T, ? extends CharSequence> var7) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "buffer");
      a1.k.e(var2, "separator");
      a1.k.e(var3, "prefix");
      a1.k.e(var4, "postfix");
      a1.k.e(var6, "truncated");
      var1.append(var3);
      Iterator var11 = var0.iterator();
      int var8 = 0;

      int var9;
      while(true) {
         var9 = var8;
         if (!var11.hasNext()) {
            break;
         }

         Object var10 = var11.next();
         ++var8;
         if (var8 > 1) {
            var1.append(var2);
         }

         if (var5 >= 0) {
            var9 = var8;
            if (var8 > var5) {
               break;
            }
         }

         g1.d.a(var1, var10, var7);
      }

      if (var5 >= 0 && var9 > var5) {
         var1.append(var6);
      }

      var1.append(var4);
      return var1;
   }

   // $FF: synthetic method
   public static Appendable m(Iterable var0, Appendable var1, CharSequence var2, CharSequence var3, CharSequence var4, int var5, CharSequence var6, z0.l var7, int var8, Object var9) {
      if ((var8 & 2) != 0) {
         var2 = ", ";
      }

      String var10 = "";
      if ((var8 & 4) != 0) {
         var3 = "";
      }

      if ((var8 & 8) != 0) {
         var4 = var10;
      }

      if ((var8 & 16) != 0) {
         var5 = -1;
      }

      if ((var8 & 32) != 0) {
         var6 = "...";
      }

      if ((var8 & 64) != 0) {
         var7 = null;
      }

      return l(var0, var1, (CharSequence)var2, (CharSequence)var3, (CharSequence)var4, var5, (CharSequence)var6, var7);
   }

   public static final <T> String n(Iterable<? extends T> var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, CharSequence var5, z0.l<? super T, ? extends CharSequence> var6) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "separator");
      a1.k.e(var2, "prefix");
      a1.k.e(var3, "postfix");
      a1.k.e(var5, "truncated");
      String var7 = ((StringBuilder)l(var0, new StringBuilder(), var1, var2, var3, var4, var5, var6)).toString();
      a1.k.d(var7, "joinTo(StringBuilder(), …ed, transform).toString()");
      return var7;
   }

   // $FF: synthetic method
   public static String o(Iterable var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, CharSequence var5, z0.l var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = ", ";
      }

      String var9 = "";
      if ((var7 & 2) != 0) {
         var2 = "";
      }

      if ((var7 & 4) != 0) {
         var3 = var9;
      }

      if ((var7 & 8) != 0) {
         var4 = -1;
      }

      if ((var7 & 16) != 0) {
         var5 = "...";
      }

      if ((var7 & 32) != 0) {
         var6 = null;
      }

      return n(var0, (CharSequence)var1, (CharSequence)var2, (CharSequence)var3, var4, (CharSequence)var5, var6);
   }

   public static <T extends Comparable<? super T>> T p(Iterable<? extends T> var0) {
      a1.k.e(var0, "<this>");
      Iterator var1 = var0.iterator();
      if (!var1.hasNext()) {
         return null;
      } else {
         Comparable var3 = (Comparable)var1.next();

         while(var1.hasNext()) {
            Comparable var2 = (Comparable)var1.next();
            if (var3.compareTo(var2) > 0) {
               var3 = var2;
            }
         }

         return var3;
      }
   }

   public static <T> List<T> q(Collection<? extends T> var0, T var1) {
      a1.k.e(var0, "<this>");
      ArrayList var2 = new ArrayList(var0.size() + 1);
      var2.addAll(var0);
      var2.add(var1);
      return var2;
   }

   public static <T> T r(Iterable<? extends T> var0) {
      a1.k.e(var0, "<this>");
      if (var0 instanceof List) {
         return s((List)var0);
      } else {
         Iterator var1 = var0.iterator();
         if (var1.hasNext()) {
            Object var2 = var1.next();
            if (!var1.hasNext()) {
               return var2;
            } else {
               throw new IllegalArgumentException("Collection has more than one element.");
            }
         } else {
            throw new NoSuchElementException("Collection is empty.");
         }
      }
   }

   public static final <T> T s(List<? extends T> var0) {
      a1.k.e(var0, "<this>");
      int var1 = var0.size();
      if (var1 != 0) {
         if (var1 == 1) {
            return var0.get(0);
         } else {
            throw new IllegalArgumentException("List has more than one element.");
         }
      } else {
         throw new NoSuchElementException("List is empty.");
      }
   }

   public static final <T, C extends Collection<? super T>> C t(Iterable<? extends T> var0, C var1) {
      a1.k.e(var0, "<this>");
      a1.k.e(var1, "destination");
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(var2.next());
      }

      return var1;
   }

   public static <T> List<T> u(Iterable<? extends T> var0) {
      a1.k.e(var0, "<this>");
      if (var0 instanceof Collection) {
         Collection var1 = (Collection)var0;
         int var2 = var1.size();
         List var3;
         if (var2 != 0) {
            if (var2 != 1) {
               var3 = w(var1);
            } else {
               Object var4;
               if (var0 instanceof List) {
                  var4 = ((List)var0).get(0);
               } else {
                  var4 = var0.iterator().next();
               }

               var3 = l.b(var4);
            }
         } else {
            var3 = l.e();
         }

         return var3;
      } else {
         return l.h(v(var0));
      }
   }

   public static final <T> List<T> v(Iterable<? extends T> var0) {
      a1.k.e(var0, "<this>");
      return var0 instanceof Collection ? w((Collection)var0) : (List)t(var0, new ArrayList());
   }

   public static final <T> List<T> w(Collection<? extends T> var0) {
      a1.k.e(var0, "<this>");
      return new ArrayList(var0);
   }

   public static <T> Set<T> x(Iterable<? extends T> var0) {
      a1.k.e(var0, "<this>");
      if (var0 instanceof Collection) {
         Collection var1 = (Collection)var0;
         int var2 = var1.size();
         Set var3;
         if (var2 != 0) {
            if (var2 != 1) {
               var3 = (Set)t(var0, new LinkedHashSet(b0.a(var1.size())));
            } else {
               Object var4;
               if (var0 instanceof List) {
                  var4 = ((List)var0).get(0);
               } else {
                  var4 = var0.iterator().next();
               }

               var3 = h0.a(var4);
            }
         } else {
            var3 = i0.b();
         }

         return var3;
      } else {
         return i0.c((Set)t(var0, new LinkedHashSet()));
      }
   }
}
