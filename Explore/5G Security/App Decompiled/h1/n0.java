package h1;

import java.util.concurrent.CancellationException;

public abstract class n0<T> extends o1.h {
   public int g;

   public n0(int var1) {
      this.g = var1;
   }

   public void b(Object var1, Throwable var2) {
   }

   public abstract r0.d<T> c();

   public Throwable e(Object var1) {
      boolean var2 = var1 instanceof u;
      Throwable var3 = null;
      u var4;
      if (var2) {
         var4 = (u)var1;
      } else {
         var4 = null;
      }

      if (var4 != null) {
         var3 = var4.a;
      }

      return var3;
   }

   public <T> T f(Object var1) {
      return var1;
   }

   public final void g(Throwable var1, Throwable var2) {
      if (var1 != null || var2 != null) {
         if (var1 != null && var2 != null) {
            p0.a.a(var1, var2);
         }

         Throwable var3 = var1;
         if (var1 == null) {
            var3 = var2;
         }

         StringBuilder var4 = new StringBuilder();
         var4.append("Fatal exception in coroutines machinery for ");
         var4.append(this);
         var4.append(". Please read KDoc to 'handleFatalException' method and report this incident to maintainers");
         String var5 = var4.toString();
         a1.k.b(var3);
         h0 var6 = new h0(var5, var3);
         d0.a(this.c().a(), var6);
      }
   }

   public abstract Object h();

   public final void run() {
      o1.i var1 = super.f;

      Object var250;
      label2057: {
         Throwable var10000;
         p0.k.a var253;
         label2050: {
            r0.d var3;
            r0.g var4;
            Object var5;
            a2 var6;
            boolean var10001;
            label2041: {
               try {
                  r0.d var2 = this.c();
                  a1.k.c(var2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
                  m1.j var249 = (m1.j)var2;
                  var3 = var249.i;
                  var250 = var249.k;
                  var4 = var3.a();
                  var5 = m1.l0.c(var4, var250);
                  if (var5 != m1.l0.a) {
                     var6 = a0.f(var3, var4, var5);
                     break label2041;
                  }
               } catch (Throwable var248) {
                  var10000 = var248;
                  var10001 = false;
                  break label2050;
               }

               var6 = null;
            }

            label2051: {
               label2052: {
                  Object var7;
                  Throwable var8;
                  r0.g var251;
                  try {
                     var251 = var3.a();
                     var7 = this.h();
                     var8 = this.e(var7);
                  } catch (Throwable var247) {
                     var10000 = var247;
                     var10001 = false;
                     break label2052;
                  }

                  h1 var252;
                  label2028: {
                     if (var8 == null) {
                        try {
                           if (o0.b(this.g)) {
                              var252 = (h1)var251.b(h1.b);
                              break label2028;
                           }
                        } catch (Throwable var246) {
                           var10000 = var246;
                           var10001 = false;
                           break label2052;
                        }
                     }

                     var252 = null;
                  }

                  label2021: {
                     if (var252 != null) {
                        try {
                           if (!var252.d()) {
                              CancellationException var254 = var252.k();
                              this.b(var7, var254);
                              p0.k.a var258 = p0.k.e;
                              var250 = p0.k.a(p0.l.a(var254));
                              break label2021;
                           }
                        } catch (Throwable var245) {
                           var10000 = var245;
                           var10001 = false;
                           break label2052;
                        }
                     }

                     if (var8 != null) {
                        try {
                           var253 = p0.k.e;
                           var250 = p0.k.a(p0.l.a(var8));
                        } catch (Throwable var244) {
                           var10000 = var244;
                           var10001 = false;
                           break label2052;
                        }
                     } else {
                        try {
                           var253 = p0.k.e;
                           var250 = p0.k.a(this.f(var7));
                        } catch (Throwable var243) {
                           var10000 = var243;
                           var10001 = false;
                           break label2052;
                        }
                     }
                  }

                  try {
                     var3.u(var250);
                  } catch (Throwable var242) {
                     var10000 = var242;
                     var10001 = false;
                     break label2052;
                  }

                  label2006:
                  try {
                     p0.q var256 = p0.q.a;
                     break label2051;
                  } catch (Throwable var241) {
                     var10000 = var241;
                     var10001 = false;
                     break label2006;
                  }
               }

               Throwable var255;
               label1995: {
                  var255 = var10000;
                  if (var6 != null) {
                     try {
                        if (!var6.K0()) {
                           break label1995;
                        }
                     } catch (Throwable var238) {
                        var10000 = var238;
                        var10001 = false;
                        break label2050;
                     }
                  }

                  try {
                     m1.l0.a(var4, var5);
                  } catch (Throwable var237) {
                     var10000 = var237;
                     var10001 = false;
                     break label2050;
                  }
               }

               try {
                  throw var255;
               } catch (Throwable var236) {
                  var10000 = var236;
                  var10001 = false;
                  break label2050;
               }
            }

            if (var6 != null) {
               try {
                  if (!var6.K0()) {
                     break label2057;
                  }
               } catch (Throwable var240) {
                  var10000 = var240;
                  var10001 = false;
                  break label2050;
               }
            }

            label1998:
            try {
               m1.l0.a(var4, var5);
               break label2057;
            } catch (Throwable var239) {
               var10000 = var239;
               var10001 = false;
               break label1998;
            }
         }

         Throwable var257 = var10000;

         label1978:
         try {
            var253 = p0.k.e;
            var1.b();
            var250 = p0.k.a(p0.q.a);
         } catch (Throwable var234) {
            var253 = p0.k.e;
            var250 = p0.k.a(p0.l.a(var234));
            break label1978;
         }

         this.g(var257, p0.k.b(var250));
         return;
      }

      label1982:
      try {
         var1.b();
         var250 = p0.k.a(p0.q.a);
      } catch (Throwable var235) {
         p0.k.a var259 = p0.k.e;
         var250 = p0.k.a(p0.l.a(var235));
         break label1982;
      }

      this.g((Throwable)null, p0.k.b(var250));
   }
}
