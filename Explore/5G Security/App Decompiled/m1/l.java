package m1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public final class l {
   public static final l a = new l();

   private l() {
   }

   private final <S> S a(String var1, ClassLoader var2, Class<S> var3) {
      Class var4 = Class.forName(var1, false, var2);
      if (var3.isAssignableFrom(var4)) {
         return var3.cast(var4.getDeclaredConstructor().newInstance());
      } else {
         StringBuilder var5 = new StringBuilder();
         var5.append("Expected service of class ");
         var5.append(var3);
         var5.append(", but found ");
         var5.append(var4);
         throw new IllegalArgumentException(var5.toString().toString());
      }
   }

   private final <S> List<S> b(Class<S> var1, ClassLoader var2) {
      boolean var5 = false;

      List var7;
      try {
         var5 = true;
         this.d(var1, var2);
         var5 = false;
      } finally {
         if (var5) {
            var7 = q0.l.u(ServiceLoader.load(var1, var2));
            return var7;
         }
      }

      return var7;
   }

   private final List<String> e(URL var1) {
      String var2 = var1.toString();
      Throwable var3;
      if (g1.d.m(var2, "jar", false, 2, (Object)null)) {
         String var117 = g1.d.U(g1.d.P(var2, "jar:file:", (String)null, 2, (Object)null), '!', (String)null, 2, (Object)null);
         String var122 = g1.d.P(var2, "!/", (String)null, 2, (Object)null);
         JarFile var118 = new JarFile(var117, false);

         List var123;
         label708: {
            Throwable var10000;
            label709: {
               boolean var10001;
               BufferedReader var120;
               try {
                  ZipEntry var5 = new ZipEntry(var122);
                  InputStreamReader var4 = new InputStreamReader(var118.getInputStream(var5), "UTF-8");
                  var120 = new BufferedReader(var4);
               } catch (Throwable var115) {
                  var10000 = var115;
                  var10001 = false;
                  break label709;
               }

               try {
                  var123 = a.f(var120);
               } catch (Throwable var114) {
                  var3 = var114;

                  try {
                     throw var3;
                  } finally {
                     try {
                        x0.a.a(var120, var3);
                     } catch (Throwable var111) {
                        var10000 = var111;
                        var10001 = false;
                        break label709;
                     }
                  }
               }

               label694:
               try {
                  x0.a.a(var120, (Throwable)null);
                  break label708;
               } catch (Throwable var113) {
                  var10000 = var113;
                  var10001 = false;
                  break label694;
               }
            }

            Throwable var121 = var10000;

            try {
               throw var121;
            } finally {
               try {
                  var118.close();
               } catch (Throwable var107) {
                  p0.a.a(var121, var107);
                  throw var121;
               }
            }
         }

         try {
            var118.close();
            return var123;
         } finally {
            ;
         }
      } else {
         BufferedReader var116 = new BufferedReader(new InputStreamReader(var1.openStream()));

         List var119;
         try {
            var119 = a.f(var116);
         } catch (Throwable var110) {
            var3 = var110;

            try {
               throw var3;
            } finally {
               x0.a.a(var116, var110);
            }
         }

         x0.a.a(var116, (Throwable)null);
         return var119;
      }
   }

   private final List<String> f(BufferedReader var1) {
      LinkedHashSet var2 = new LinkedHashSet();

      while(true) {
         String var3 = var1.readLine();
         if (var3 == null) {
            return q0.l.u(var2);
         }

         var3 = g1.d.W(g1.d.V(var3, "#", (String)null, 2, (Object)null)).toString();
         boolean var4 = false;
         int var5 = 0;

         boolean var9;
         while(true) {
            if (var5 >= var3.length()) {
               var9 = true;
               break;
            }

            char var6 = var3.charAt(var5);
            boolean var7;
            if (var6 != '.' && !Character.isJavaIdentifierPart(var6)) {
               var7 = false;
            } else {
               var7 = true;
            }

            if (!var7) {
               var9 = false;
               break;
            }

            ++var5;
         }

         if (!var9) {
            StringBuilder var8 = new StringBuilder();
            var8.append("Illegal service provider class name: ");
            var8.append(var3);
            throw new IllegalArgumentException(var8.toString().toString());
         }

         var9 = var4;
         if (var3.length() > 0) {
            var9 = true;
         }

         if (var9) {
            var2.add(var3);
         }
      }
   }

   public final List<v> c() {
      // $FF: Couldn't be decompiled
   }

   public final <S> List<S> d(Class<S> var1, ClassLoader var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("META-INF/services/");
      var3.append(var1.getName());
      ArrayList var4 = Collections.list(var2.getResources(var3.toString()));
      a1.k.d(var4, "list(this)");
      ArrayList var6 = new ArrayList();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         URL var7 = (URL)var5.next();
         q0.l.k(var6, a.e(var7));
      }

      Set var8 = q0.l.x(var6);
      if (!(var8.isEmpty() ^ true)) {
         throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
      } else {
         var6 = new ArrayList(q0.l.j(var8, 10));
         Iterator var9 = var8.iterator();

         while(var9.hasNext()) {
            String var10 = (String)var9.next();
            var6.add(a.a(var10, var2, var1));
         }

         return var6;
      }
   }
}
