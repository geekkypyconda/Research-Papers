package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.PackageInfoFlags;
import android.os.Build.VERSION;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

public final class p {
   private static final androidx.concurrent.futures.c<p.c> a = androidx.concurrent.futures.c.q();
   private static final Object b = new Object();
   private static p.c c = null;

   private static long a(Context var0) {
      PackageManager var1 = var0.getApplicationContext().getPackageManager();
      PackageInfo var2;
      if (VERSION.SDK_INT >= 33) {
         var2 = p.a.a(var1, var0);
      } else {
         var2 = var1.getPackageInfo(var0.getPackageName(), 0);
      }

      return var2.lastUpdateTime;
   }

   private static p.c b(int var0, boolean var1, boolean var2) {
      p.c var3 = new p.c(var0, var1, var2);
      c = var3;
      a.o(var3);
      return c;
   }

   static p.c c(Context param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   private static class a {
      static PackageInfo a(PackageManager var0, Context var1) {
         return var0.getPackageInfo(var1.getPackageName(), PackageInfoFlags.of(0L));
      }
   }

   static class b {
      final int a;
      final int b;
      final long c;
      final long d;

      b(int var1, int var2, long var3, long var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var5;
      }

      static p.b a(File var0) {
         DataInputStream var8 = new DataInputStream(new FileInputStream(var0));

         p.b var1;
         try {
            var1 = new p.b(var8.readInt(), var8.readInt(), var8.readLong(), var8.readLong());
         } catch (Throwable var7) {
            try {
               var8.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
               throw var7;
            }

            throw var7;
         }

         var8.close();
         return var1;
      }

      void b(File var1) {
         var1.delete();
         DataOutputStream var2 = new DataOutputStream(new FileOutputStream(var1));

         try {
            var2.writeInt(this.a);
            var2.writeInt(this.b);
            var2.writeLong(this.c);
            var2.writeLong(this.d);
         } catch (Throwable var8) {
            try {
               var2.close();
            } catch (Throwable var7) {
               var8.addSuppressed(var7);
               throw var8;
            }

            throw var8;
         }

         var2.close();
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this == var1) {
            return true;
         } else if (var1 != null && var1 instanceof p.b) {
            p.b var3 = (p.b)var1;
            if (this.b != var3.b || this.c != var3.c || this.a != var3.a || this.d != var3.d) {
               var2 = false;
            }

            return var2;
         } else {
            return false;
         }
      }

      public int hashCode() {
         return Objects.hash(new Object[]{this.b, this.c, this.a, this.d});
      }
   }

   public static class c {
      final int a;
      private final boolean b;
      private final boolean c;

      c(int var1, boolean var2, boolean var3) {
         this.a = var1;
         this.c = var3;
         this.b = var2;
      }
   }
}
