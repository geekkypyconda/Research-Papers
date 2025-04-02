package k1;

import j1.t;

// $FF: synthetic class
final class g {
   public static final <T> Object b(d<? super T> var0, t<? extends T> var1, r0.d<? super p0.q> var2) {
      Object var3 = c(var0, var1, true, var2);
      return var3 == s0.b.c() ? var3 : p0.q.a;
   }

   private static final <T> Object c(d<? super T> var0, t<? extends T> var1, boolean var2, r0.d<? super p0.q> var3) {
      Object var4;
      int var5;
      label4726: {
         if (var3 instanceof <undefinedtype>) {
            var4 = (<undefinedtype>)var3;
            var5 = ((<undefinedtype>)var4).m;
            if ((var5 & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var4).m = var5 + Integer.MIN_VALUE;
               break label4726;
            }
         }

         var4 = new t0.d(var3) {
            Object h;
            Object i;
            Object j;
            boolean k;
            // $FF: synthetic field
            Object l;
            int m;

            public final Object k(Object var1) {
               this.l = var1;
               this.m |= Integer.MIN_VALUE;
               return g.c((d)null, (t)null, false, this);
            }
         };
      }

      t var505;
      label4729: {
         boolean var9;
         Throwable var10000;
         t var508;
         label4719: {
            Object var6 = ((<undefinedtype>)var4).l;
            Object var7 = s0.b.c();
            var5 = ((<undefinedtype>)var4).m;
            d var8;
            d var10;
            boolean var10001;
            j1.f var507;
            j1.f var509;
            j1.f var510;
            Object var511;
            if (var5 != 0) {
               if (var5 != 1) {
                  if (var5 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  var2 = ((<undefinedtype>)var4).k;
                  var507 = (j1.f)((<undefinedtype>)var4).j;
                  var505 = (t)((<undefinedtype>)var4).i;
                  var8 = (d)((<undefinedtype>)var4).h;
                  var508 = var505;
                  var9 = var2;

                  try {
                     p0.l.b(var6);
                  } catch (Throwable var496) {
                     var10000 = var496;
                     var10001 = false;
                     break label4719;
                  }

                  var509 = var507;
                  var10 = var8;
                  var1 = var505;
                  var510 = var509;
               } else {
                  var2 = ((<undefinedtype>)var4).k;
                  var507 = (j1.f)((<undefinedtype>)var4).j;
                  var505 = (t)((<undefinedtype>)var4).i;
                  var8 = (d)((<undefinedtype>)var4).h;
                  var508 = var505;
                  var9 = var2;

                  try {
                     p0.l.b(var6);
                  } catch (Throwable var495) {
                     var10000 = var495;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     if (!(Boolean)var6) {
                        break label4729;
                     }
                  } catch (Throwable var487) {
                     var10000 = var487;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     var511 = var507.next();
                  } catch (Throwable var486) {
                     var10000 = var486;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     ((<undefinedtype>)var4).h = var8;
                  } catch (Throwable var485) {
                     var10000 = var485;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     ((<undefinedtype>)var4).i = var505;
                  } catch (Throwable var484) {
                     var10000 = var484;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     ((<undefinedtype>)var4).j = var507;
                  } catch (Throwable var483) {
                     var10000 = var483;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     ((<undefinedtype>)var4).k = var2;
                  } catch (Throwable var482) {
                     var10000 = var482;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     ((<undefinedtype>)var4).m = 2;
                  } catch (Throwable var481) {
                     var10000 = var481;
                     var10001 = false;
                     break label4719;
                  }

                  var508 = var505;
                  var9 = var2;

                  try {
                     var511 = var8.c(var511, (r0.d)var4);
                  } catch (Throwable var480) {
                     var10000 = var480;
                     var10001 = false;
                     break label4719;
                  }

                  if (var511 == var7) {
                     return var7;
                  }

                  var509 = var507;
                  var10 = var8;
                  var1 = var505;
                  var510 = var509;
               }
            } else {
               p0.l.b(var6);
               e.c(var0);
               var508 = var1;
               var9 = var2;

               try {
                  var510 = var1.iterator();
               } catch (Throwable var494) {
                  var10000 = var494;
                  var10001 = false;
                  break label4719;
               }

               var10 = var0;
            }

            while(true) {
               var508 = var1;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).h = var10;
               } catch (Throwable var493) {
                  var10000 = var493;
                  var10001 = false;
                  break;
               }

               var508 = var1;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).i = var1;
               } catch (Throwable var492) {
                  var10000 = var492;
                  var10001 = false;
                  break;
               }

               var508 = var1;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).j = var510;
               } catch (Throwable var491) {
                  var10000 = var491;
                  var10001 = false;
                  break;
               }

               var508 = var1;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).k = var2;
               } catch (Throwable var490) {
                  var10000 = var490;
                  var10001 = false;
                  break;
               }

               var508 = var1;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).m = 1;
               } catch (Throwable var489) {
                  var10000 = var489;
                  var10001 = false;
                  break;
               }

               var508 = var1;
               var9 = var2;

               try {
                  var6 = var510.a((r0.d)var4);
               } catch (Throwable var488) {
                  var10000 = var488;
                  var10001 = false;
                  break;
               }

               if (var6 == var7) {
                  return var7;
               }

               var505 = var1;
               var507 = var510;
               var8 = var10;
               var508 = var505;
               var9 = var2;

               try {
                  if (!(Boolean)var6) {
                     break label4729;
                  }
               } catch (Throwable var497) {
                  var10000 = var497;
                  var10001 = false;
                  break;
               }

               var508 = var505;
               var9 = var2;

               try {
                  var511 = var507.next();
               } catch (Throwable var498) {
                  var10000 = var498;
                  var10001 = false;
                  break;
               }

               var508 = var505;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).h = var8;
               } catch (Throwable var499) {
                  var10000 = var499;
                  var10001 = false;
                  break;
               }

               var508 = var505;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).i = var505;
               } catch (Throwable var500) {
                  var10000 = var500;
                  var10001 = false;
                  break;
               }

               var508 = var505;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).j = var507;
               } catch (Throwable var501) {
                  var10000 = var501;
                  var10001 = false;
                  break;
               }

               var508 = var505;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).k = var2;
               } catch (Throwable var502) {
                  var10000 = var502;
                  var10001 = false;
                  break;
               }

               var508 = var505;
               var9 = var2;

               try {
                  ((<undefinedtype>)var4).m = 2;
               } catch (Throwable var503) {
                  var10000 = var503;
                  var10001 = false;
                  break;
               }

               var508 = var505;
               var9 = var2;

               try {
                  var511 = var8.c(var511, (r0.d)var4);
               } catch (Throwable var504) {
                  var10000 = var504;
                  var10001 = false;
                  break;
               }

               if (var511 == var7) {
                  return var7;
               }

               var509 = var507;
               var10 = var8;
               var1 = var505;
               var510 = var509;
            }
         }

         Throwable var506 = var10000;

         try {
            throw var506;
         } finally {
            if (var9) {
               j1.k.a(var508, var506);
            }

         }
      }

      if (var2) {
         j1.k.a(var505, (Throwable)null);
      }

      return p0.q.a;
   }
}
