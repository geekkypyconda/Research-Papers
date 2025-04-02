package m1;

import h1.a2;
import h1.h1;
import h1.t0;
import h1.y1;
import java.util.concurrent.CancellationException;

public final class k {
   private static final h0 a = new h0("UNDEFINED");
   public static final h0 b = new h0("REUSABLE_CLAIMED");

   // $FF: synthetic method
   public static final h0 a() {
      return a;
   }

   public static final <T> void b(r0.d<? super T> var0, Object var1, z0.l<? super Throwable, p0.q> var2) {
      if (var0 instanceof j) {
         j var3 = (j)var0;
         Object var132 = h1.y.c(var1, var2);
         if (var3.h.e(var3.a())) {
            var3.j = var132;
            var3.g = 1;
            var3.h.a(var3.a(), var3);
         } else {
            t0 var136 = y1.a.a();
            if (var136.z()) {
               var3.j = var132;
               var3.g = 1;
               var136.q(var3);
            } else {
               var136.u(true);

               Throwable var10000;
               label1216: {
                  h1 var4;
                  boolean var10001;
                  try {
                     var4 = (h1)var3.a().b(h1.b);
                  } catch (Throwable var131) {
                     var10000 = var131;
                     var10001 = false;
                     break label1216;
                  }

                  boolean var5;
                  label1202: {
                     label1201: {
                        if (var4 != null) {
                           try {
                              if (!var4.d()) {
                                 CancellationException var138 = var4.k();
                                 var3.b(var132, var138);
                                 p0.k.a var133 = p0.k.e;
                                 var3.u(p0.k.a(p0.l.a(var138)));
                                 break label1201;
                              }
                           } catch (Throwable var130) {
                              var10000 = var130;
                              var10001 = false;
                              break label1216;
                           }
                        }

                        var5 = false;
                        break label1202;
                     }

                     var5 = true;
                  }

                  if (!var5) {
                     Object var6;
                     a2 var134;
                     r0.g var139;
                     label1191: {
                        try {
                           var0 = var3.i;
                           var6 = var3.k;
                           var139 = var0.a();
                           var6 = l0.c(var139, var6);
                           if (var6 != l0.a) {
                              var134 = h1.a0.f(var0, var139, var6);
                              break label1191;
                           }
                        } catch (Throwable var129) {
                           var10000 = var129;
                           var10001 = false;
                           break label1216;
                        }

                        var134 = null;
                     }

                     try {
                        var3.i.u(var1);
                        p0.q var135 = p0.q.a;
                     } finally {
                        label1178: {
                           if (var134 != null) {
                              try {
                                 if (!var134.K0()) {
                                    break label1178;
                                 }
                              } catch (Throwable var126) {
                                 var10000 = var126;
                                 var10001 = false;
                                 break label1216;
                              }
                           }

                           try {
                              l0.a(var139, var6);
                           } catch (Throwable var125) {
                              var10000 = var125;
                              var10001 = false;
                              break label1216;
                           }
                        }

                        try {
                           ;
                        } catch (Throwable var124) {
                           var10000 = var124;
                           var10001 = false;
                           break label1216;
                        }
                     }
                  }

                  while(true) {
                     boolean var7;
                     try {
                        var7 = var136.D();
                     } catch (Throwable var127) {
                        var10000 = var127;
                        var10001 = false;
                        break;
                     }

                     if (!var7) {
                        return;
                     }
                  }
               }

               Throwable var137 = var10000;

               try {
                  var3.g(var137, (Throwable)null);
               } finally {
                  var136.o(true);
               }
            }
         }
      } else {
         var0.u(var1);
      }

   }

   // $FF: synthetic method
   public static void c(r0.d var0, Object var1, z0.l var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      b(var0, var1, var2);
   }
}
