package z;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import k0.q;
import o0.f;

public class a implements k0.b {
   private final FlutterJNI a;
   private final AssetManager b;
   private final z.c c;
   private final k0.b d;
   private boolean e = false;
   private String f;
   private z.a.d g;
   private final k0.b.a h;

   public a(FlutterJNI var1, AssetManager var2) {
      k0.b.a var3 = new k0.b.a() {
         public void a(ByteBuffer var1, k0.b.b var2) {
            a.this.f = q.b.c(var1);
            if (a.this.g != null) {
               a.this.g.a(a.this.f);
            }

         }
      };
      this.h = var3;
      this.a = var1;
      this.b = var2;
      z.c var4 = new z.c(var1);
      this.c = var4;
      var4.c("flutter/isolate", var3);
      this.d = new z.a.c(var4);
      if (var1.isAttached()) {
         this.e = true;
      }

   }

   @Deprecated
   public void a(String var1, ByteBuffer var2, k0.b.b var3) {
      this.d.a(var1, var2, var3);
   }

   @Deprecated
   public void b(String var1, k0.b.a var2, k0.b.c var3) {
      this.d.b(var1, var2, var3);
   }

   @Deprecated
   public void c(String var1, k0.b.a var2) {
      this.d.c(var1, var2);
   }

   public void g(z.a.b var1, List<String> var2) {
      if (this.e) {
         y.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
      } else {
         f var3 = o0.f.f("DartExecutor#executeDartEntrypoint");

         try {
            StringBuilder var4 = new StringBuilder();
            var4.append("Executing Dart entrypoint: ");
            var4.append(var1);
            y.b.f("DartExecutor", var4.toString());
            this.a.runBundleAndSnapshotFromLibrary(var1.a, var1.c, var1.b, this.b, var2);
            this.e = true;
         } catch (Throwable var10) {
            if (var3 != null) {
               try {
                  var3.close();
               } catch (Throwable var9) {
                  var10.addSuppressed(var9);
                  throw var10;
               }
            }

            throw var10;
         }

         if (var3 != null) {
            var3.close();
         }

      }
   }

   public boolean h() {
      return this.e;
   }

   public void i() {
      if (this.a.isAttached()) {
         this.a.notifyLowMemoryWarning();
      }

   }

   public void j() {
      y.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
      this.a.setPlatformMessageHandler(this.c);
   }

   public void k() {
      y.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
      this.a.setPlatformMessageHandler((z.d)null);
   }

   public static class b {
      public final String a;
      public final String b;
      public final String c;

      public b(String var1, String var2) {
         this.a = var1;
         this.b = null;
         this.c = var2;
      }

      public b(String var1, String var2, String var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public static z.a.b a() {
         b0.d var0 = y.a.e().c();
         if (var0.i()) {
            return new z.a.b(var0.g(), "main");
         } else {
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
         }
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (var1 != null && this.getClass() == var1.getClass()) {
            z.a.b var2 = (z.a.b)var1;
            return !this.a.equals(var2.a) ? false : this.c.equals(var2.c);
         } else {
            return false;
         }
      }

      public int hashCode() {
         return this.a.hashCode() * 31 + this.c.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("DartEntrypoint( bundle path: ");
         var1.append(this.a);
         var1.append(", function: ");
         var1.append(this.c);
         var1.append(" )");
         return var1.toString();
      }
   }

   private static class c implements k0.b {
      private final z.c a;

      private c(z.c var1) {
         this.a = var1;
      }

      // $FF: synthetic method
      c(z.c var1, Object var2) {
         this(var1);
      }

      public void a(String var1, ByteBuffer var2, k0.b.b var3) {
         this.a.a(var1, var2, var3);
      }

      public void b(String var1, k0.b.a var2, k0.b.c var3) {
         this.a.b(var1, var2, var3);
      }

      public void c(String var1, k0.b.a var2) {
         this.a.c(var1, var2);
      }
   }

   public interface d {
      void a(String var1);
   }
}
