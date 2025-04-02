package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

class f {
   static int a(int var0) {
      return (var0 + 8 - 1 & -8) / 8;
   }

   static byte[] b(byte[] var0) {
      Deflater var1 = new Deflater(1);
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();

      label297: {
         Throwable var46;
         Throwable var10000;
         label301: {
            DeflaterOutputStream var3;
            boolean var10001;
            try {
               var3 = new DeflaterOutputStream(var2, var1);
            } catch (Throwable var45) {
               var10000 = var45;
               var10001 = false;
               break label301;
            }

            try {
               var3.write(var0);
            } catch (Throwable var44) {
               var46 = var44;

               try {
                  var3.close();
               } catch (Throwable var42) {
                  Throwable var47 = var42;

                  label283:
                  try {
                     var46.addSuppressed(var47);
                     break label283;
                  } catch (Throwable var41) {
                     var10000 = var41;
                     var10001 = false;
                     break label301;
                  }
               }

               try {
                  throw var46;
               } catch (Throwable var40) {
                  var10000 = var40;
                  var10001 = false;
                  break label301;
               }
            }

            label290:
            try {
               var3.close();
               break label297;
            } catch (Throwable var43) {
               var10000 = var43;
               var10001 = false;
               break label290;
            }
         }

         var46 = var10000;
         var1.end();
         throw var46;
      }

      var1.end();
      return var2.toByteArray();
   }

   static RuntimeException c(String var0) {
      return new IllegalStateException(var0);
   }

   static byte[] d(InputStream var0, int var1) {
      byte[] var2 = new byte[var1];

      int var4;
      for(int var3 = 0; var3 < var1; var3 += var4) {
         var4 = var0.read(var2, var3, var1 - var3);
         if (var4 < 0) {
            StringBuilder var5 = new StringBuilder();
            var5.append("Not enough bytes to read: ");
            var5.append(var1);
            throw c(var5.toString());
         }
      }

      return var2;
   }

   static byte[] e(InputStream param0, int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   static String f(InputStream var0, int var1) {
      return new String(d(var0, var1), StandardCharsets.UTF_8);
   }

   static long g(InputStream var0, int var1) {
      byte[] var5 = d(var0, var1);
      long var2 = 0L;

      for(int var4 = 0; var4 < var1; ++var4) {
         var2 += (long)(var5[var4] & 255) << var4 * 8;
      }

      return var2;
   }

   static int h(InputStream var0) {
      return (int)g(var0, 2);
   }

   static long i(InputStream var0) {
      return g(var0, 4);
   }

   static int j(InputStream var0) {
      return (int)g(var0, 1);
   }

   static int k(String var0) {
      return var0.getBytes(StandardCharsets.UTF_8).length;
   }

   static void l(InputStream var0, OutputStream var1) {
      byte[] var2 = new byte[512];

      while(true) {
         int var3 = var0.read(var2);
         if (var3 <= 0) {
            return;
         }

         var1.write(var2, 0, var3);
      }
   }

   static void m(OutputStream var0, byte[] var1) {
      q(var0, (long)var1.length);
      var1 = b(var1);
      q(var0, (long)var1.length);
      var0.write(var1);
   }

   static void n(OutputStream var0, String var1) {
      var0.write(var1.getBytes(StandardCharsets.UTF_8));
   }

   static void o(OutputStream var0, long var1, int var3) {
      byte[] var4 = new byte[var3];

      for(int var5 = 0; var5 < var3; ++var5) {
         var4[var5] = (byte)((byte)((int)(var1 >> var5 * 8 & 255L)));
      }

      var0.write(var4);
   }

   static void p(OutputStream var0, int var1) {
      o(var0, (long)var1, 2);
   }

   static void q(OutputStream var0, long var1) {
      o(var0, var1, 4);
   }

   static void r(OutputStream var0, int var1) {
      o(var0, (long)var1, 1);
   }
}
