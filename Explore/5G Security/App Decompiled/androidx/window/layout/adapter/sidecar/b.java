package androidx.window.layout.adapter.sidecar;

import a1.g;
import a1.k;
import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import p0.q;
import q0.l;
import r.j;

public final class b implements s.a {
   public static final androidx.window.layout.adapter.sidecar.b.a c = new androidx.window.layout.adapter.sidecar.b.a((g)null);
   private static volatile androidx.window.layout.adapter.sidecar.b d;
   private static final ReentrantLock e = new ReentrantLock();
   private androidx.window.layout.adapter.sidecar.a a;
   private final CopyOnWriteArrayList<androidx.window.layout.adapter.sidecar.b.c> b;

   public b(androidx.window.layout.adapter.sidecar.a var1) {
      this.a = var1;
      this.b = new CopyOnWriteArrayList();
      var1 = this.a;
      if (var1 != null) {
         var1.a(new androidx.window.layout.adapter.sidecar.b.b());
      }

   }

   private final void f(Activity var1) {
      CopyOnWriteArrayList var2 = this.b;
      boolean var3 = var2 instanceof Collection;
      boolean var4 = false;
      boolean var5;
      if (var3 && var2.isEmpty()) {
         var5 = var4;
      } else {
         Iterator var6 = var2.iterator();

         while(true) {
            var5 = var4;
            if (!var6.hasNext()) {
               break;
            }

            if (k.a(((androidx.window.layout.adapter.sidecar.b.c)var6.next()).d(), var1)) {
               var5 = true;
               break;
            }
         }
      }

      if (!var5) {
         androidx.window.layout.adapter.sidecar.a var7 = this.a;
         if (var7 != null) {
            var7.b(var1);
         }

      }
   }

   private final boolean h(Activity var1) {
      CopyOnWriteArrayList var2 = this.b;
      boolean var3 = var2 instanceof Collection;
      boolean var4 = false;
      if (var3 && var2.isEmpty()) {
         var3 = var4;
      } else {
         Iterator var5 = var2.iterator();

         while(true) {
            var3 = var4;
            if (!var5.hasNext()) {
               break;
            }

            if (k.a(((androidx.window.layout.adapter.sidecar.b.c)var5.next()).d(), var1)) {
               var3 = true;
               break;
            }
         }
      }

      return var3;
   }

   public void a(Context var1, Executor var2, h.a<j> var3) {
      k.e(var1, "context");
      k.e(var2, "executor");
      k.e(var3, "callback");
      boolean var4 = var1 instanceof Activity;
      q var5 = null;
      Object var6 = null;
      Activity var119;
      if (var4) {
         var119 = (Activity)var1;
      } else {
         var119 = null;
      }

      if (var119 != null) {
         label1069: {
            ReentrantLock var126 = e;
            var126.lock();

            Throwable var10000;
            label1060: {
               androidx.window.layout.adapter.sidecar.a var7;
               boolean var10001;
               try {
                  var7 = this.a;
               } catch (Throwable var118) {
                  var10000 = var118;
                  var10001 = false;
                  break label1060;
               }

               j var120;
               if (var7 == null) {
                  label1020: {
                     try {
                        var120 = new j(l.e());
                        var3.accept(var120);
                     } catch (Throwable var109) {
                        var10000 = var109;
                        var10001 = false;
                        break label1020;
                     }

                     var126.unlock();
                     return;
                  }
               } else {
                  label1067: {
                     androidx.window.layout.adapter.sidecar.b.c var8;
                     try {
                        var4 = this.h(var119);
                        var8 = new androidx.window.layout.adapter.sidecar.b.c(var119, var2, var3);
                        this.b.add(var8);
                     } catch (Throwable var117) {
                        var10000 = var117;
                        var10001 = false;
                        break label1067;
                     }

                     if (!var4) {
                        try {
                           var7.c(var119);
                        } catch (Throwable var115) {
                           var10000 = var115;
                           var10001 = false;
                           break label1067;
                        }
                     } else {
                        Iterator var127;
                        try {
                           var127 = this.b.iterator();
                        } catch (Throwable var114) {
                           var10000 = var114;
                           var10001 = false;
                           break label1067;
                        }

                        Object var122;
                        label1049: {
                           Object var121;
                           label1048: {
                              try {
                                 while(var127.hasNext()) {
                                    var121 = var127.next();
                                    if (k.a(var119, ((androidx.window.layout.adapter.sidecar.b.c)var121).d())) {
                                       break label1048;
                                    }
                                 }
                              } catch (Throwable var116) {
                                 var10000 = var116;
                                 var10001 = false;
                                 break label1067;
                              }

                              var122 = null;
                              break label1049;
                           }

                           var122 = var121;
                        }

                        androidx.window.layout.adapter.sidecar.b.c var123;
                        try {
                           var123 = (androidx.window.layout.adapter.sidecar.b.c)var122;
                        } catch (Throwable var113) {
                           var10000 = var113;
                           var10001 = false;
                           break label1067;
                        }

                        var120 = (j)var6;
                        if (var123 != null) {
                           try {
                              var120 = var123.f();
                           } catch (Throwable var112) {
                              var10000 = var112;
                              var10001 = false;
                              break label1067;
                           }
                        }

                        if (var120 != null) {
                           try {
                              var8.b(var120);
                           } catch (Throwable var111) {
                              var10000 = var111;
                              var10001 = false;
                              break label1067;
                           }
                        }
                     }

                     try {
                        q var125 = q.a;
                     } catch (Throwable var110) {
                        var10000 = var110;
                        var10001 = false;
                        break label1067;
                     }

                     var126.unlock();
                     var5 = q.a;
                     break label1069;
                  }
               }
            }

            Throwable var124 = var10000;
            var126.unlock();
            throw var124;
         }
      }

      if (var5 == null) {
         var3.accept(new j(l.e()));
      }

   }

   public void b(h.a<j> var1) {
      k.e(var1, "callback");
      ReentrantLock var2 = e;
      synchronized(var2){}

      Throwable var10000;
      label433: {
         androidx.window.layout.adapter.sidecar.a var3;
         boolean var10001;
         try {
            var3 = this.a;
         } catch (Throwable var47) {
            var10000 = var47;
            var10001 = false;
            break label433;
         }

         if (var3 == null) {
            return;
         }

         ArrayList var4;
         Iterator var5;
         try {
            var4 = new ArrayList();
            var5 = this.b.iterator();
         } catch (Throwable var45) {
            var10000 = var45;
            var10001 = false;
            break label433;
         }

         while(true) {
            try {
               if (!var5.hasNext()) {
                  break;
               }

               androidx.window.layout.adapter.sidecar.b.c var51 = (androidx.window.layout.adapter.sidecar.b.c)var5.next();
               if (var51.e() == var1) {
                  k.d(var51, "callbackWrapper");
                  var4.add(var51);
               }
            } catch (Throwable var46) {
               var10000 = var46;
               var10001 = false;
               break label433;
            }
         }

         Iterator var48;
         try {
            this.b.removeAll(var4);
            var48 = var4.iterator();
         } catch (Throwable var43) {
            var10000 = var43;
            var10001 = false;
            break label433;
         }

         while(true) {
            try {
               if (!var48.hasNext()) {
                  break;
               }

               this.f(((androidx.window.layout.adapter.sidecar.b.c)var48.next()).d());
            } catch (Throwable var44) {
               var10000 = var44;
               var10001 = false;
               break label433;
            }
         }

         try {
            q var50 = q.a;
         } catch (Throwable var42) {
            var10000 = var42;
            var10001 = false;
            break label433;
         }

         return;
      }

      Throwable var49 = var10000;
      throw var49;
   }

   public final CopyOnWriteArrayList<androidx.window.layout.adapter.sidecar.b.c> g() {
      return this.b;
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(g var1) {
         this();
      }

      public final androidx.window.layout.adapter.sidecar.b a(Context var1) {
         k.e(var1, "context");
         androidx.window.layout.adapter.sidecar.b var6;
         if (androidx.window.layout.adapter.sidecar.b.d == null) {
            ReentrantLock var2 = androidx.window.layout.adapter.sidecar.b.e;
            var2.lock();

            try {
               if (androidx.window.layout.adapter.sidecar.b.d == null) {
                  androidx.window.layout.adapter.sidecar.a var3 = androidx.window.layout.adapter.sidecar.b.c.b(var1);
                  var6 = new androidx.window.layout.adapter.sidecar.b(var3);
                  androidx.window.layout.adapter.sidecar.b.d = var6;
               }

               q var7 = q.a;
            } finally {
               var2.unlock();
            }
         }

         var6 = androidx.window.layout.adapter.sidecar.b.d;
         k.b(var6);
         return var6;
      }

      public final androidx.window.layout.adapter.sidecar.a b(Context var1) {
         k.e(var1, "context");
         Object var2 = null;
         SidecarCompat var3 = (SidecarCompat)var2;

         boolean var4;
         try {
            if (!this.c(SidecarCompat.f.c())) {
               return var3;
            }

            var3 = new SidecarCompat(var1);
            var4 = var3.n();
         } finally {
            ;
         }

         if (!var4) {
            var3 = (SidecarCompat)var2;
         }

         return var3;
      }

      public final boolean c(o.k var1) {
         boolean var2 = false;
         if (var1 == null) {
            return false;
         } else {
            if (var1.b(o.k.j.a()) >= 0) {
               var2 = true;
            }

            return var2;
         }
      }
   }

   public final class b implements androidx.window.layout.adapter.sidecar.a.a {
      public void a(Activity var1, j var2) {
         k.e(var1, "activity");
         k.e(var2, "newLayout");
         Iterator var3 = b.this.g().iterator();

         while(var3.hasNext()) {
            androidx.window.layout.adapter.sidecar.b.c var4 = (androidx.window.layout.adapter.sidecar.b.c)var3.next();
            if (k.a(var4.d(), var1)) {
               var4.b(var2);
            }
         }

      }
   }

   public static final class c {
      private final Activity a;
      private final Executor b;
      private final h.a<j> c;
      private j d;

      public c(Activity var1, Executor var2, h.a<j> var3) {
         k.e(var1, "activity");
         k.e(var2, "executor");
         k.e(var3, "callback");
         super();
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      public static void a(androidx.window.layout.adapter.sidecar.b.c var0, j var1) {
         c(var0, var1);
      }

      private static final void c(androidx.window.layout.adapter.sidecar.b.c var0, j var1) {
         k.e(var0, "this$0");
         k.e(var1, "$newLayoutInfo");
         var0.c.accept(var1);
      }

      public final void b(j var1) {
         k.e(var1, "newLayoutInfo");
         this.d = var1;
         this.b.execute(new u.c(this, var1));
      }

      public final Activity d() {
         return this.a;
      }

      public final h.a<j> e() {
         return this.c;
      }

      public final j f() {
         return this.d;
      }
   }
}
