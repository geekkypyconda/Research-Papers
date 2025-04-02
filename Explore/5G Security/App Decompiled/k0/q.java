package k0;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class q implements g<String> {
   private static final Charset a = Charset.forName("UTF8");
   public static final q b = new q();

   private q() {
   }

   public String c(ByteBuffer var1) {
      if (var1 == null) {
         return null;
      } else {
         int var2 = var1.remaining();
         byte[] var3;
         int var4;
         byte[] var5;
         if (var1.hasArray()) {
            var3 = var1.array();
            var4 = var1.arrayOffset();
            var5 = var3;
         } else {
            var3 = new byte[var2];
            var1.get(var3);
            var4 = 0;
            var5 = var3;
         }

         return new String(var5, var4, var2, a);
      }
   }

   public ByteBuffer d(String var1) {
      if (var1 == null) {
         return null;
      } else {
         byte[] var3 = var1.getBytes(a);
         ByteBuffer var2 = ByteBuffer.allocateDirect(var3.length);
         var2.put(var3);
         return var2;
      }
   }
}
