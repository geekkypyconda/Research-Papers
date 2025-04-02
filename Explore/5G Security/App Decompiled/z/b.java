package z;

import java.nio.ByteBuffer;

// $FF: synthetic class
public final class b implements Runnable {
   // $FF: synthetic field
   public final c e;
   // $FF: synthetic field
   public final String f;
   // $FF: synthetic field
   public final int g;
   // $FF: synthetic field
   public final c.d h;
   // $FF: synthetic field
   public final ByteBuffer i;
   // $FF: synthetic field
   public final long j;

   // $FF: synthetic method
   public b(c var1, String var2, int var3, c.d var4, ByteBuffer var5, long var6) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.i = var5;
      this.j = var6;
   }

   public final void run() {
      c.f(this.e, this.f, this.g, this.h, this.i, this.j);
   }
}
