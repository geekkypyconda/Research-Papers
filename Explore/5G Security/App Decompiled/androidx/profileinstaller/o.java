package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

class o {
   static final byte[] a = new byte[]{112, 114, 111, 0};
   static final byte[] b = new byte[]{112, 114, 109, 0};

   private static void A(InputStream var0) {
      f.h(var0);
      int var1 = f.j(var0);
      if (var1 != 6) {
         int var2 = var1;
         if (var1 != 7) {
            while(var2 > 0) {
               f.j(var0);

               for(var1 = f.j(var0); var1 > 0; --var1) {
                  f.h(var0);
               }

               --var2;
            }

         }
      }
   }

   static boolean B(OutputStream var0, byte[] var1, e[] var2) {
      if (Arrays.equals(var1, q.a)) {
         N(var0, var2);
         return true;
      } else if (Arrays.equals(var1, q.b)) {
         M(var0, var2);
         return true;
      } else if (Arrays.equals(var1, q.d)) {
         K(var0, var2);
         return true;
      } else if (Arrays.equals(var1, q.c)) {
         L(var0, var2);
         return true;
      } else if (Arrays.equals(var1, q.e)) {
         J(var0, var2);
         return true;
      } else {
         return false;
      }
   }

   private static void C(OutputStream var0, e var1) {
      int[] var6 = var1.h;
      int var2 = var6.length;
      int var3 = 0;

      for(int var4 = 0; var3 < var2; ++var3) {
         Integer var5 = var6[var3];
         f.p(var0, var5 - var4);
         var4 = var5;
      }

   }

   private static r D(e[] var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();

      Throwable var10000;
      label503: {
         boolean var10001;
         try {
            f.p(var1, var0.length);
         } catch (Throwable var59) {
            var10000 = var59;
            var10001 = false;
            break label503;
         }

         int var2 = 0;
         int var3 = 2;

         while(true) {
            try {
               if (var2 >= var0.length) {
                  break;
               }
            } catch (Throwable var61) {
               var10000 = var61;
               var10001 = false;
               break label503;
            }

            e var4 = var0[var2];

            String var65;
            int var5;
            try {
               f.q(var1, var4.c);
               f.q(var1, var4.d);
               f.q(var1, (long)var4.g);
               var65 = j(var4.a, var4.b, q.a);
               var5 = f.k(var65);
               f.p(var1, var5);
            } catch (Throwable var58) {
               var10000 = var58;
               var10001 = false;
               break label503;
            }

            var3 = var3 + 4 + 4 + 4 + 2 + var5 * 1;

            try {
               f.n(var1, var65);
            } catch (Throwable var57) {
               var10000 = var57;
               var10001 = false;
               break label503;
            }

            ++var2;
         }

         byte[] var62;
         label491: {
            r var63;
            try {
               var62 = var1.toByteArray();
               if (var3 != var62.length) {
                  break label491;
               }

               var63 = new r(g.f, var3, var62, false);
            } catch (Throwable var60) {
               var10000 = var60;
               var10001 = false;
               break label503;
            }

            var1.close();
            return var63;
         }

         label476:
         try {
            StringBuilder var66 = new StringBuilder();
            var66.append("Expected size ");
            var66.append(var3);
            var66.append(", does not match actual size ");
            var66.append(var62.length);
            throw f.c(var66.toString());
         } catch (Throwable var56) {
            var10000 = var56;
            var10001 = false;
            break label476;
         }
      }

      Throwable var64 = var10000;

      try {
         var1.close();
      } catch (Throwable var55) {
         var64.addSuppressed(var55);
         throw var64;
      }

      throw var64;
   }

   static void E(OutputStream var0, byte[] var1) {
      var0.write(a);
      var0.write(var1);
   }

   private static void F(OutputStream var0, e var1) {
      I(var0, var1);
      C(var0, var1);
      H(var0, var1);
   }

   private static void G(OutputStream var0, e var1, String var2) {
      f.p(var0, f.k(var2));
      f.p(var0, var1.e);
      f.q(var0, (long)var1.f);
      f.q(var0, var1.c);
      f.q(var0, (long)var1.g);
      f.n(var0, var2);
   }

   private static void H(OutputStream var0, e var1) {
      byte[] var2 = new byte[k(var1.g)];
      Iterator var3 = var1.i.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         int var5 = (Integer)var4.getKey();
         int var6 = (Integer)var4.getValue();
         if ((var6 & 2) != 0) {
            z(var2, 2, var5, var1);
         }

         if ((var6 & 4) != 0) {
            z(var2, 4, var5, var1);
         }
      }

      var0.write(var2);
   }

   private static void I(OutputStream var0, e var1) {
      Iterator var2 = var1.i.entrySet().iterator();
      int var3 = 0;

      while(var2.hasNext()) {
         Entry var5 = (Entry)var2.next();
         int var4 = (Integer)var5.getKey();
         if (((Integer)var5.getValue() & 1) != 0) {
            f.p(var0, var4 - var3);
            f.p(var0, 0);
            var3 = var4;
         }
      }

   }

   private static void J(OutputStream var0, e[] var1) {
      f.p(var0, var1.length);
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         e var4 = var1[var3];
         String var5 = j(var4.a, var4.b, q.e);
         f.p(var0, f.k(var5));
         f.p(var0, var4.i.size());
         f.p(var0, var4.h.length);
         f.q(var0, var4.c);
         f.n(var0, var5);
         Iterator var9 = var4.i.keySet().iterator();

         while(var9.hasNext()) {
            f.p(var0, (Integer)var9.next());
         }

         int[] var8 = var4.h;
         int var6 = var8.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            f.p(var0, var8[var7]);
         }
      }

   }

   private static void K(OutputStream var0, e[] var1) {
      f.r(var0, var1.length);
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         e var4 = var1[var3];
         int var5 = var4.i.size();
         String var6 = j(var4.a, var4.b, q.d);
         f.p(var0, f.k(var6));
         f.p(var0, var4.h.length);
         f.q(var0, (long)(var5 * 4));
         f.q(var0, var4.c);
         f.n(var0, var6);
         Iterator var9 = var4.i.keySet().iterator();

         while(var9.hasNext()) {
            f.p(var0, (Integer)var9.next());
            f.p(var0, 0);
         }

         int[] var8 = var4.h;
         int var7 = var8.length;

         for(var5 = 0; var5 < var7; ++var5) {
            f.p(var0, var8[var5]);
         }
      }

   }

   private static void L(OutputStream var0, e[] var1) {
      byte[] var2 = b(var1, q.c);
      f.r(var0, var1.length);
      f.m(var0, var2);
   }

   private static void M(OutputStream var0, e[] var1) {
      byte[] var2 = b(var1, q.b);
      f.r(var0, var1.length);
      f.m(var0, var2);
   }

   private static void N(OutputStream var0, e[] var1) {
      O(var0, var1);
   }

   private static void O(OutputStream var0, e[] var1) {
      ArrayList var2 = new ArrayList(3);
      ArrayList var3 = new ArrayList(3);
      var2.add(D(var1));
      var2.add(c(var1));
      var2.add(d(var1));
      long var4 = (long)q.a.length + (long)a.length + 4L + (long)(var2.size() * 16);
      f.q(var0, (long)var2.size());
      byte var6 = 0;
      int var7 = 0;

      while(true) {
         int var8 = var6;
         if (var7 >= var2.size()) {
            while(var8 < var3.size()) {
               var0.write((byte[])var3.get(var8));
               ++var8;
            }

            return;
         }

         r var11 = (r)var2.get(var7);
         f.q(var0, var11.a.b());
         f.q(var0, var4);
         if (var11.d) {
            byte[] var12 = var11.c;
            long var9 = (long)var12.length;
            var12 = f.b(var12);
            var3.add(var12);
            f.q(var0, (long)var12.length);
            f.q(var0, var9);
            var8 = var12.length;
         } else {
            var3.add(var11.c);
            f.q(var0, (long)var11.c.length);
            f.q(var0, 0L);
            var8 = var11.c.length;
         }

         var4 += (long)var8;
         ++var7;
      }
   }

   private static int a(e var0) {
      Iterator var2 = var0.i.entrySet().iterator();

      int var1;
      for(var1 = 0; var2.hasNext(); var1 |= (Integer)((Entry)var2.next()).getValue()) {
      }

      return var1;
   }

   private static byte[] b(e[] var0, byte[] var1) {
      int var2 = var0.length;
      byte var3 = 0;
      byte var4 = 0;
      int var5 = 0;

      int var6;
      for(var6 = 0; var5 < var2; ++var5) {
         e var7 = var0[var5];
         var6 += f.k(j(var7.a, var7.b, var1)) + 16 + var7.e * 2 + var7.f + k(var7.g);
      }

      ByteArrayOutputStream var12 = new ByteArrayOutputStream(var6);
      e var8;
      if (Arrays.equals(var1, q.c)) {
         int var10 = var0.length;

         for(var5 = var4; var5 < var10; ++var5) {
            var8 = var0[var5];
            G(var12, var8, j(var8.a, var8.b, var1));
            F(var12, var8);
         }
      } else {
         int var11 = var0.length;

         for(var5 = 0; var5 < var11; ++var5) {
            var8 = var0[var5];
            G(var12, var8, j(var8.a, var8.b, var1));
         }

         var11 = var0.length;

         for(var5 = var3; var5 < var11; ++var5) {
            F(var12, var0[var5]);
         }
      }

      if (var12.size() == var6) {
         return var12.toByteArray();
      } else {
         StringBuilder var9 = new StringBuilder();
         var9.append("The bytes saved do not match expectation. actual=");
         var9.append(var12.size());
         var9.append(" expected=");
         var9.append(var6);
         throw f.c(var9.toString());
      }
   }

   private static r c(e[] var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      int var2 = 0;
      int var3 = 0;

      Throwable var10000;
      label315: {
         boolean var10001;
         while(true) {
            try {
               if (var2 >= var0.length) {
                  break;
               }
            } catch (Throwable var34) {
               var10000 = var34;
               var10001 = false;
               break label315;
            }

            e var4 = var0[var2];

            try {
               f.p(var1, var2);
               f.p(var1, var4.e);
               var3 = var3 + 2 + 2 + var4.e * 2;
               C(var1, var4);
            } catch (Throwable var31) {
               var10000 = var31;
               var10001 = false;
               break label315;
            }

            ++var2;
         }

         r var37;
         label304: {
            byte[] var38;
            try {
               var38 = var1.toByteArray();
               if (var3 == var38.length) {
                  var37 = new r(g.h, var3, var38, true);
                  break label304;
               }
            } catch (Throwable var33) {
               var10000 = var33;
               var10001 = false;
               break label315;
            }

            try {
               StringBuilder var36 = new StringBuilder();
               var36.append("Expected size ");
               var36.append(var3);
               var36.append(", does not match actual size ");
               var36.append(var38.length);
               throw f.c(var36.toString());
            } catch (Throwable var32) {
               var10000 = var32;
               var10001 = false;
               break label315;
            }
         }

         var1.close();
         return var37;
      }

      Throwable var35 = var10000;

      try {
         var1.close();
      } catch (Throwable var30) {
         var35.addSuppressed(var30);
         throw var35;
      }

      throw var35;
   }

   private static r d(e[] var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      int var2 = 0;
      int var3 = 0;

      Throwable var10000;
      label315: {
         boolean var10001;
         while(true) {
            try {
               if (var2 >= var0.length) {
                  break;
               }
            } catch (Throwable var37) {
               var10000 = var37;
               var10001 = false;
               break label315;
            }

            e var4 = var0[var2];

            int var7;
            try {
               int var5 = a(var4);
               byte[] var6 = e(var4);
               byte[] var41 = f(var4);
               f.p(var1, var2);
               var7 = var6.length + 2 + var41.length;
               f.q(var1, (long)var7);
               f.p(var1, var5);
               var1.write(var6);
               var1.write(var41);
            } catch (Throwable var34) {
               var10000 = var34;
               var10001 = false;
               break label315;
            }

            var3 = var3 + 2 + 4 + var7;
            ++var2;
         }

         r var40;
         label304: {
            byte[] var38;
            try {
               var38 = var1.toByteArray();
               if (var3 == var38.length) {
                  var40 = new r(g.i, var3, var38, true);
                  break label304;
               }
            } catch (Throwable var36) {
               var10000 = var36;
               var10001 = false;
               break label315;
            }

            try {
               StringBuilder var42 = new StringBuilder();
               var42.append("Expected size ");
               var42.append(var3);
               var42.append(", does not match actual size ");
               var42.append(var38.length);
               throw f.c(var42.toString());
            } catch (Throwable var35) {
               var10000 = var35;
               var10001 = false;
               break label315;
            }
         }

         var1.close();
         return var40;
      }

      Throwable var39 = var10000;

      try {
         var1.close();
      } catch (Throwable var33) {
         var39.addSuppressed(var33);
         throw var39;
      }

      throw var39;
   }

   private static byte[] e(e var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();

      byte[] var8;
      try {
         H(var1, var0);
         var8 = var1.toByteArray();
      } catch (Throwable var7) {
         try {
            var1.close();
         } catch (Throwable var6) {
            var7.addSuppressed(var6);
            throw var7;
         }

         throw var7;
      }

      var1.close();
      return var8;
   }

   private static byte[] f(e var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();

      byte[] var8;
      try {
         I(var1, var0);
         var8 = var1.toByteArray();
      } catch (Throwable var7) {
         try {
            var1.close();
         } catch (Throwable var6) {
            var7.addSuppressed(var6);
            throw var7;
         }

         throw var7;
      }

      var1.close();
      return var8;
   }

   private static String g(String var0, String var1) {
      if ("!".equals(var1)) {
         return var0.replace(":", "!");
      } else {
         String var2 = var0;
         if (":".equals(var1)) {
            var2 = var0.replace("!", ":");
         }

         return var2;
      }
   }

   private static String h(String var0) {
      int var1 = var0.indexOf("!");
      int var2 = var1;
      if (var1 < 0) {
         var2 = var0.indexOf(":");
      }

      String var3 = var0;
      if (var2 > 0) {
         var3 = var0.substring(var2 + 1);
      }

      return var3;
   }

   private static e i(e[] var0, String var1) {
      if (var0.length <= 0) {
         return null;
      } else {
         var1 = h(var1);

         for(int var2 = 0; var2 < var0.length; ++var2) {
            if (var0[var2].b.equals(var1)) {
               return var0[var2];
            }
         }

         return null;
      }
   }

   private static String j(String var0, String var1, byte[] var2) {
      String var3 = q.a(var2);
      if (var0.length() <= 0) {
         return g(var1, var3);
      } else if (var1.equals("classes.dex")) {
         return var0;
      } else if (!var1.contains("!") && !var1.contains(":")) {
         if (var1.endsWith(".apk")) {
            return var1;
         } else {
            StringBuilder var4 = new StringBuilder();
            var4.append(var0);
            var4.append(q.a(var2));
            var4.append(var1);
            return var4.toString();
         }
      } else {
         return g(var1, var3);
      }
   }

   private static int k(int var0) {
      return y(var0 * 2) / 8;
   }

   private static int l(int var0, int var1, int var2) {
      if (var0 != 1) {
         if (var0 != 2) {
            if (var0 == 4) {
               return var1 + var2;
            } else {
               StringBuilder var3 = new StringBuilder();
               var3.append("Unexpected flag: ");
               var3.append(var0);
               throw f.c(var3.toString());
            }
         } else {
            return var1;
         }
      } else {
         throw f.c("HOT methods are not stored in the bitmap");
      }
   }

   private static int[] m(InputStream var0, int var1) {
      int[] var2 = new int[var1];
      int var3 = 0;

      for(int var4 = 0; var3 < var1; ++var3) {
         var4 += f.h(var0);
         var2[var3] = var4;
      }

      return var2;
   }

   private static int n(BitSet var0, int var1, int var2) {
      byte var3 = 2;
      if (!var0.get(l(2, var1, var2))) {
         var3 = 0;
      }

      int var4 = var3;
      if (var0.get(l(4, var1, var2))) {
         var4 = var3 | 4;
      }

      return var4;
   }

   static byte[] o(InputStream var0, byte[] var1) {
      if (Arrays.equals(var1, f.d(var0, var1.length))) {
         return f.d(var0, q.b.length);
      } else {
         throw f.c("Invalid magic");
      }
   }

   private static void p(InputStream var0, e var1) {
      int var2 = var0.available() - var1.f;
      int var3 = 0;

      while(var0.available() > var2) {
         int var4 = var3 + f.h(var0);
         var1.i.put(var4, 1);
         int var5 = f.h(var0);

         while(true) {
            var3 = var4;
            if (var5 <= 0) {
               break;
            }

            A(var0);
            --var5;
         }
      }

      if (var0.available() != var2) {
         throw f.c("Read too much data during profile line parse");
      }
   }

   static e[] q(InputStream var0, byte[] var1, byte[] var2, e[] var3) {
      if (Arrays.equals(var1, q.f)) {
         if (!Arrays.equals(q.a, var2)) {
            return r(var0, var1, var3);
         } else {
            throw f.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
         }
      } else if (Arrays.equals(var1, q.g)) {
         return t(var0, var2, var3);
      } else {
         throw f.c("Unsupported meta version");
      }
   }

   static e[] r(InputStream var0, byte[] var1, e[] var2) {
      if (!Arrays.equals(var1, q.f)) {
         throw f.c("Unsupported meta version");
      } else {
         int var3 = f.j(var0);
         long var4 = f.i(var0);
         var1 = f.e(var0, (int)f.i(var0), (int)var4);
         if (var0.read() <= 0) {
            ByteArrayInputStream var12 = new ByteArrayInputStream(var1);

            e[] var13;
            try {
               var13 = s(var12, var3, var2);
            } catch (Throwable var11) {
               try {
                  var12.close();
               } catch (Throwable var10) {
                  var11.addSuppressed(var10);
                  throw var11;
               }

               throw var11;
            }

            var12.close();
            return var13;
         } else {
            throw f.c("Content found after the end of file");
         }
      }
   }

   private static e[] s(InputStream var0, int var1, e[] var2) {
      int var3 = var0.available();
      byte var4 = 0;
      if (var3 == 0) {
         return new e[0];
      } else if (var1 != var2.length) {
         throw f.c("Mismatched number of dex files found in metadata");
      } else {
         String[] var5 = new String[var1];
         int[] var6 = new int[var1];
         var3 = 0;

         while(true) {
            int var7 = var4;
            if (var3 >= var1) {
               while(var7 < var1) {
                  e var8 = var2[var7];
                  if (!var8.b.equals(var5[var7])) {
                     throw f.c("Order of dexfiles in metadata did not match baseline");
                  }

                  var3 = var6[var7];
                  var8.e = var3;
                  var8.h = m(var0, var3);
                  ++var7;
               }

               return var2;
            }

            var7 = f.h(var0);
            var6[var3] = f.h(var0);
            var5[var3] = f.f(var0, var7);
            ++var3;
         }
      }
   }

   static e[] t(InputStream var0, byte[] var1, e[] var2) {
      int var3 = f.h(var0);
      long var4 = f.i(var0);
      byte[] var6 = f.e(var0, (int)f.i(var0), (int)var4);
      if (var0.read() <= 0) {
         ByteArrayInputStream var13 = new ByteArrayInputStream(var6);

         e[] var14;
         try {
            var14 = u(var13, var1, var3, var2);
         } catch (Throwable var12) {
            try {
               var13.close();
            } catch (Throwable var11) {
               var12.addSuppressed(var11);
               throw var12;
            }

            throw var12;
         }

         var13.close();
         return var14;
      } else {
         throw f.c("Content found after the end of file");
      }
   }

   private static e[] u(InputStream var0, byte[] var1, int var2, e[] var3) {
      int var4 = var0.available();
      int var5 = 0;
      if (var4 == 0) {
         return new e[0];
      } else if (var2 == var3.length) {
         for(; var5 < var2; ++var5) {
            f.h(var0);
            String var6 = f.f(var0, f.h(var0));
            long var7 = f.i(var0);
            var4 = f.h(var0);
            e var9 = i(var3, var6);
            if (var9 == null) {
               StringBuilder var10 = new StringBuilder();
               var10.append("Missing profile key: ");
               var10.append(var6);
               throw f.c(var10.toString());
            }

            var9.d = var7;
            int[] var11 = m(var0, var4);
            if (Arrays.equals(var1, q.e)) {
               var9.e = var4;
               var9.h = var11;
            }
         }

         return var3;
      } else {
         throw f.c("Mismatched number of dex files found in metadata");
      }
   }

   private static void v(InputStream var0, e var1) {
      BitSet var2 = BitSet.valueOf(f.d(var0, f.a(var1.g * 2)));
      int var3 = 0;

      while(true) {
         int var4 = var1.g;
         if (var3 >= var4) {
            return;
         }

         var4 = n(var2, var3, var4);
         if (var4 != 0) {
            Integer var5 = (Integer)var1.i.get(var3);
            Integer var6 = var5;
            if (var5 == null) {
               var6 = 0;
            }

            var1.i.put(var3, var4 | var6);
         }

         ++var3;
      }
   }

   static e[] w(InputStream var0, byte[] var1, String var2) {
      if (!Arrays.equals(var1, q.b)) {
         throw f.c("Unsupported version");
      } else {
         int var3 = f.j(var0);
         long var4 = f.i(var0);
         var1 = f.e(var0, (int)f.i(var0), (int)var4);
         if (var0.read() <= 0) {
            ByteArrayInputStream var12 = new ByteArrayInputStream(var1);

            e[] var13;
            try {
               var13 = x(var12, var2, var3);
            } catch (Throwable var11) {
               try {
                  var12.close();
               } catch (Throwable var10) {
                  var11.addSuppressed(var10);
                  throw var11;
               }

               throw var11;
            }

            var12.close();
            return var13;
         } else {
            throw f.c("Content found after the end of file");
         }
      }
   }

   private static e[] x(InputStream var0, String var1, int var2) {
      int var3 = var0.available();
      byte var4 = 0;
      if (var3 == 0) {
         return new e[0];
      } else {
         e[] var5 = new e[var2];
         var3 = 0;

         while(true) {
            int var6 = var4;
            if (var3 >= var2) {
               while(var6 < var2) {
                  e var14 = var5[var6];
                  p(var0, var14);
                  var14.h = m(var0, var14.e);
                  v(var0, var14);
                  ++var6;
               }

               return var5;
            }

            var6 = f.h(var0);
            int var7 = f.h(var0);
            long var8 = f.i(var0);
            long var10 = f.i(var0);
            long var12 = f.i(var0);
            var5[var3] = new e(var1, f.f(var0, var6), var10, 0L, var7, (int)var8, (int)var12, new int[var7], new TreeMap());
            ++var3;
         }
      }
   }

   private static int y(int var0) {
      return var0 + 8 - 1 & -8;
   }

   private static void z(byte[] var0, int var1, int var2, e var3) {
      var2 = l(var1, var2, var3.g);
      var1 = var2 / 8;
      var0[var1] = (byte)((byte)(1 << var2 % 8 | var0[var1]));
   }
}
