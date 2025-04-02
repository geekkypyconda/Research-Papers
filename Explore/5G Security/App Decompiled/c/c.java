package c;

import java.util.concurrent.Executor;

public class c extends f {
   private static volatile c c;
   private static final Executor d = new a();
   private static final Executor e = new b();
   private f a;
   private final f b;

   private c() {
      d var1 = new d();
      this.b = var1;
      this.a = var1;
   }

   // $FF: synthetic method
   public static void d(Runnable var0) {
      h(var0);
   }

   // $FF: synthetic method
   public static void e(Runnable var0) {
      g(var0);
   }

   public static c f() {
      if (c != null) {
         return c;
      } else {
         synchronized(c.class){}

         Throwable var10000;
         boolean var10001;
         label145: {
            try {
               if (c == null) {
                  c var0 = new c();
                  c = var0;
               }
            } catch (Throwable var12) {
               var10000 = var12;
               var10001 = false;
               break label145;
            }

            label142:
            try {
               return c;
            } catch (Throwable var11) {
               var10000 = var11;
               var10001 = false;
               break label142;
            }
         }

         while(true) {
            Throwable var13 = var10000;

            try {
               throw var13;
            } catch (Throwable var10) {
               var10000 = var10;
               var10001 = false;
               continue;
            }
         }
      }
   }

   // $FF: synthetic method
   private static void g(Runnable var0) {
      f().c(var0);
   }

   // $FF: synthetic method
   private static void h(Runnable var0) {
      f().a(var0);
   }

   public void a(Runnable var1) {
      this.a.a(var1);
   }

   public boolean b() {
      return this.a.b();
   }

   public void c(Runnable var1) {
      this.a.c(var1);
   }
}
