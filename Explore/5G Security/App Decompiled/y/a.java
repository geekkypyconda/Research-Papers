package y;

import b0.d;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class a {
   private static y.a e;
   private static boolean f;
   private d a;
   private a0.a b;
   private FlutterJNI.c c;
   private ExecutorService d;

   private a(d var1, a0.a var2, FlutterJNI.c var3, ExecutorService var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   // $FF: synthetic method
   a(d var1, a0.a var2, FlutterJNI.c var3, ExecutorService var4, Object var5) {
      this(var1, var2, var3, var4);
   }

   public static y.a e() {
      f = true;
      if (e == null) {
         e = (new y.a.b()).a();
      }

      return e;
   }

   public a0.a a() {
      return this.b;
   }

   public ExecutorService b() {
      return this.d;
   }

   public d c() {
      return this.a;
   }

   public FlutterJNI.c d() {
      return this.c;
   }

   public static final class b {
      private d a;
      private a0.a b;
      private FlutterJNI.c c;
      private ExecutorService d;

      private void b() {
         if (this.c == null) {
            this.c = new FlutterJNI.c();
         }

         if (this.d == null) {
            this.d = Executors.newCachedThreadPool(new y.a.b.a());
         }

         if (this.a == null) {
            this.a = new d(this.c.a(), this.d);
         }

      }

      public y.a a() {
         this.b();
         return new y.a(this.a, this.b, this.c, this.d);
      }

      private class a implements ThreadFactory {
         private int a;

         private a() {
            this.a = 0;
         }

         // $FF: synthetic method
         a(Object var2) {
            this();
         }

         public Thread newThread(Runnable var1) {
            Thread var2 = new Thread(var1);
            StringBuilder var4 = new StringBuilder();
            var4.append("flutter-worker-");
            int var3 = this.a++;
            var4.append(var3);
            var2.setName(var4.toString());
            return var2;
         }
      }
   }
}
