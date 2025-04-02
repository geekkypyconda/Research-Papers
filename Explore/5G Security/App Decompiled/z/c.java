package z;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

class c implements k0.b, z.d {
   private final FlutterJNI a;
   private final Map<String, z.c.d> b;
   private Map<String, List<z.c.a>> c;
   private final Object d;
   private final AtomicBoolean e;
   private final Map<Integer, k0.b.b> f;
   private int g;
   private final z.c.b h;
   private WeakHashMap<k0.b.c, z.c.b> i;
   private z.c.f j;

   c(FlutterJNI var1) {
      this(var1, new z.c.c());
   }

   c(FlutterJNI var1, z.c.f var2) {
      this.b = new HashMap();
      this.c = new HashMap();
      this.d = new Object();
      this.e = new AtomicBoolean(false);
      this.f = new HashMap();
      this.g = 1;
      this.h = new z.e();
      this.i = new WeakHashMap();
      this.a = var1;
      this.j = var2;
   }

   // $FF: synthetic method
   public static void f(z.c var0, String var1, int var2, z.c.d var3, ByteBuffer var4, long var5) {
      var0.j(var1, var2, var3, var4, var5);
   }

   private void g(String var1, z.c.d var2, ByteBuffer var3, int var4, long var5) {
      z.c.b var7;
      if (var2 != null) {
         var7 = var2.b;
      } else {
         var7 = null;
      }

      StringBuilder var8 = new StringBuilder();
      var8.append("PlatformChannel ScheduleHandler on ");
      var8.append(var1);
      o0.f.b(var8.toString(), var4);
      z.b var10 = new z.b(this, var1, var4, var2, var3, var5);
      z.c.b var9 = var7;
      if (var7 == null) {
         var9 = this.h;
      }

      var9.a(var10);
   }

   private static void h(Error var0) {
      Thread var1 = Thread.currentThread();
      if (var1.getUncaughtExceptionHandler() != null) {
         var1.getUncaughtExceptionHandler().uncaughtException(var1, var0);
      } else {
         throw var0;
      }
   }

   private void i(z.c.d var1, ByteBuffer var2, int var3) {
      if (var1 != null) {
         try {
            y.b.f("DartMessenger", "Deferring to registered handler to process message.");
            k0.b.a var4 = var1.a;
            z.c.e var7 = new z.c.e(this.a, var3);
            var4.a(var2, var7);
            return;
         } catch (Exception var5) {
            y.b.c("DartMessenger", "Uncaught exception in binary message listener", var5);
         } catch (Error var6) {
            h(var6);
            return;
         }
      } else {
         y.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
      }

      this.a.invokePlatformMessageEmptyResponseCallback(var3);
   }

   // $FF: synthetic method
   private void j(String var1, int var2, z.c.d var3, ByteBuffer var4, long var5) {
      StringBuilder var7 = new StringBuilder();
      var7.append("PlatformChannel ScheduleHandler on ");
      var7.append(var1);
      o0.f.e(var7.toString(), var2);

      label483: {
         Throwable var65;
         Throwable var10000;
         label487: {
            o0.f var64;
            boolean var10001;
            try {
               var7 = new StringBuilder();
               var7.append("DartMessenger#handleMessageFromDart on ");
               var7.append(var1);
               var64 = o0.f.f(var7.toString());
            } catch (Throwable var63) {
               var10000 = var63;
               var10001 = false;
               break label487;
            }

            label488: {
               label489: {
                  try {
                     this.i(var3, var4, var2);
                  } catch (Throwable var62) {
                     var10000 = var62;
                     var10001 = false;
                     break label489;
                  }

                  if (var4 == null) {
                     break label488;
                  }

                  label473:
                  try {
                     if (var4.isDirect()) {
                        var4.limit(0);
                     }
                     break label488;
                  } catch (Throwable var61) {
                     var10000 = var61;
                     var10001 = false;
                     break label473;
                  }
               }

               Throwable var66 = var10000;
               if (var64 != null) {
                  try {
                     var64.close();
                  } catch (Throwable var59) {
                     var65 = var59;

                     label460:
                     try {
                        var66.addSuppressed(var65);
                        break label460;
                     } catch (Throwable var58) {
                        var10000 = var58;
                        var10001 = false;
                        break label487;
                     }
                  }
               }

               try {
                  throw var66;
               } catch (Throwable var57) {
                  var10000 = var57;
                  var10001 = false;
                  break label487;
               }
            }

            if (var64 == null) {
               break label483;
            }

            label467:
            try {
               var64.close();
               break label483;
            } catch (Throwable var60) {
               var10000 = var60;
               var10001 = false;
               break label467;
            }
         }

         var65 = var10000;
         this.a.cleanupMessageData(var5);
         throw var65;
      }

      this.a.cleanupMessageData(var5);
   }

   public void a(String var1, ByteBuffer var2, k0.b.b var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append("DartMessenger#send on ");
      var4.append(var1);
      o0.f var38 = o0.f.f(var4.toString());

      label283: {
         Throwable var10000;
         label284: {
            int var6;
            boolean var10001;
            try {
               StringBuilder var5 = new StringBuilder();
               var5.append("Sending message with callback over channel '");
               var5.append(var1);
               var5.append("'");
               y.b.f("DartMessenger", var5.toString());
               var6 = this.g++;
            } catch (Throwable var36) {
               var10000 = var36;
               var10001 = false;
               break label284;
            }

            if (var3 != null) {
               try {
                  this.f.put(var6, var3);
               } catch (Throwable var35) {
                  var10000 = var35;
                  var10001 = false;
                  break label284;
               }
            }

            if (var2 == null) {
               label268:
               try {
                  this.a.dispatchEmptyPlatformMessage(var1, var6);
               } catch (Throwable var33) {
                  var10000 = var33;
                  var10001 = false;
                  break label268;
               }
            } else {
               label270:
               try {
                  this.a.dispatchPlatformMessage(var1, var2, var2.position(), var6);
               } catch (Throwable var34) {
                  var10000 = var34;
                  var10001 = false;
                  break label270;
               }
            }
            break label283;
         }

         Throwable var37 = var10000;
         if (var38 != null) {
            try {
               var38.close();
            } catch (Throwable var32) {
               var37.addSuppressed(var32);
               throw var37;
            }
         }

         throw var37;
      }

      if (var38 != null) {
         var38.close();
      }

   }

   public void b(String param1, k0.b.a param2, k0.b.c param3) {
      // $FF: Couldn't be decompiled
   }

   public void c(String var1, k0.b.a var2) {
      this.b(var1, var2, (k0.b.c)null);
   }

   public void d(int var1, ByteBuffer var2) {
      y.b.f("DartMessenger", "Received message reply from Dart.");
      k0.b.b var3 = (k0.b.b)this.f.remove(var1);
      if (var3 != null) {
         Exception var10;
         label45: {
            Error var10000;
            label36: {
               boolean var10001;
               try {
                  y.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                  var3.a(var2);
               } catch (Exception var6) {
                  var10 = var6;
                  var10001 = false;
                  break label45;
               } catch (Error var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label36;
               }

               if (var2 == null) {
                  return;
               }

               try {
                  if (var2.isDirect()) {
                     var2.limit(0);
                  }

                  return;
               } catch (Exception var4) {
                  var10 = var4;
                  var10001 = false;
                  break label45;
               } catch (Error var5) {
                  var10000 = var5;
                  var10001 = false;
               }
            }

            Error var8 = var10000;
            h(var8);
            return;
         }

         Exception var9 = var10;
         y.b.c("DartMessenger", "Uncaught exception in binary message reply handler", var9);
      }

   }

   public void e(String var1, ByteBuffer var2, int var3, long var4) {
      StringBuilder var6 = new StringBuilder();
      var6.append("Received message from Dart over channel '");
      var6.append(var1);
      var6.append("'");
      y.b.f("DartMessenger", var6.toString());
      Object var42 = this.d;
      synchronized(var42){}

      z.c.d var7;
      boolean var8;
      label353: {
         Throwable var10000;
         boolean var10001;
         label354: {
            label347: {
               label346: {
                  try {
                     var7 = (z.c.d)this.b.get(var1);
                     if (!this.e.get()) {
                        break label346;
                     }
                  } catch (Throwable var40) {
                     var10000 = var40;
                     var10001 = false;
                     break label354;
                  }

                  if (var7 == null) {
                     var8 = true;
                     break label347;
                  }
               }

               var8 = false;
            }

            if (var8) {
               try {
                  if (!this.c.containsKey(var1)) {
                     Map var9 = this.c;
                     LinkedList var10 = new LinkedList();
                     var9.put(var1, var10);
                  }
               } catch (Throwable var39) {
                  var10000 = var39;
                  var10001 = false;
                  break label354;
               }

               try {
                  List var44 = (List)this.c.get(var1);
                  z.c.a var43 = new z.c.a(var2, var3, var4);
                  var44.add(var43);
               } catch (Throwable var38) {
                  var10000 = var38;
                  var10001 = false;
                  break label354;
               }
            }

            label330:
            try {
               break label353;
            } catch (Throwable var37) {
               var10000 = var37;
               var10001 = false;
               break label330;
            }
         }

         while(true) {
            Throwable var41 = var10000;

            try {
               throw var41;
            } catch (Throwable var36) {
               var10000 = var36;
               var10001 = false;
               continue;
            }
         }
      }

      if (!var8) {
         this.g(var1, var7, var2, var3, var4);
      }

   }

   private static class a {
      public final ByteBuffer a;
      int b;
      long c;

      a(ByteBuffer var1, int var2, long var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }

   interface b {
      void a(Runnable var1);
   }

   private static class c implements z.c.f {
      ExecutorService a = y.a.e().b();

      c() {
      }
   }

   private static class d {
      public final k0.b.a a;
      public final z.c.b b;

      d(k0.b.a var1, z.c.b var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   static class e implements k0.b.b {
      private final FlutterJNI a;
      private final int b;
      private final AtomicBoolean c = new AtomicBoolean(false);

      e(FlutterJNI var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(ByteBuffer var1) {
         if (!this.c.getAndSet(true)) {
            if (var1 == null) {
               this.a.invokePlatformMessageEmptyResponseCallback(this.b);
            } else {
               this.a.invokePlatformMessageResponseCallback(this.b, var1, var1.position());
            }

         } else {
            throw new IllegalStateException("Reply already submitted");
         }
      }
   }

   interface f {
   }
}
