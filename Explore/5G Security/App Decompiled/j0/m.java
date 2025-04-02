package j0;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m {
   private final k0.i a;
   private m.g b;
   private final k0.i.c c;

   public m(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         // $FF: synthetic method
         public static void b(k0.i.d var0, m.c var1) {
            f(var0, var1);
         }

         private void c(k0.h var1, k0.i.d var2) {
            int var3 = (Integer)var1.a();

            try {
               m.this.b.a(var3);
               var2.b((Object)null);
            } catch (IllegalStateException var4) {
               var2.a("error", m.c(var4), (Object)null);
            }

         }

         private void d(k0.h var1, k0.i.d var2) {
            Map var3 = (Map)var1.a();
            boolean var4 = var3.containsKey("hybrid");
            boolean var5 = true;
            boolean var6;
            if (var4 && (Boolean)var3.get("hybrid")) {
               var6 = true;
            } else {
               var6 = false;
            }

            ByteBuffer var27;
            if (var3.containsKey("params")) {
               var27 = ByteBuffer.wrap((byte[])var3.get("params"));
            } else {
               var27 = null;
            }

            IllegalStateException var10000;
            label105: {
               boolean var10001;
               if (var6) {
                  try {
                     m.d var7 = new m.d((Integer)var3.get("id"), (String)var3.get("viewType"), 0.0D, 0.0D, 0.0D, 0.0D, (Integer)var3.get("direction"), m.d.a.g, var27);
                     m.this.b.i(var7);
                  } catch (IllegalStateException var19) {
                     var10000 = var19;
                     var10001 = false;
                     break label105;
                  }
               } else {
                  label102: {
                     label101: {
                        try {
                           if (!var3.containsKey("hybridFallback") || !(Boolean)var3.get("hybridFallback")) {
                              break label101;
                           }
                        } catch (IllegalStateException var26) {
                           var10000 = var26;
                           var10001 = false;
                           break label105;
                        }

                        var6 = var5;
                        break label102;
                     }

                     var6 = false;
                  }

                  m.d.a var31;
                  if (var6) {
                     try {
                        var31 = m.d.a.f;
                     } catch (IllegalStateException var24) {
                        var10000 = var24;
                        var10001 = false;
                        break label105;
                     }
                  } else {
                     try {
                        var31 = m.d.a.e;
                     } catch (IllegalStateException var23) {
                        var10000 = var23;
                        var10001 = false;
                        break label105;
                     }
                  }

                  m.d var8;
                  String var9;
                  int var30;
                  try {
                     var8 = new m.d;
                     var30 = (Integer)var3.get("id");
                     var9 = (String)var3.get("viewType");
                     var4 = var3.containsKey("top");
                  } catch (IllegalStateException var22) {
                     var10000 = var22;
                     var10001 = false;
                     break label105;
                  }

                  double var10 = 0.0D;
                  double var12;
                  if (var4) {
                     try {
                        var12 = (Double)var3.get("top");
                     } catch (IllegalStateException var21) {
                        var10000 = var21;
                        var10001 = false;
                        break label105;
                     }
                  } else {
                     var12 = 0.0D;
                  }

                  try {
                     if (var3.containsKey("left")) {
                        var10 = (Double)var3.get("left");
                     }
                  } catch (IllegalStateException var25) {
                     var10000 = var25;
                     var10001 = false;
                     break label105;
                  }

                  long var14;
                  try {
                     var8.<init>(var30, var9, var12, var10, (Double)var3.get("width"), (Double)var3.get("height"), (Integer)var3.get("direction"), var31, var27);
                     var14 = m.this.b.f(var8);
                  } catch (IllegalStateException var20) {
                     var10000 = var20;
                     var10001 = false;
                     break label105;
                  }

                  if (var14 != -2L) {
                     try {
                        var2.b(var14);
                        return;
                     } catch (IllegalStateException var18) {
                        var10000 = var18;
                        var10001 = false;
                        break label105;
                     }
                  }

                  if (!var6) {
                     try {
                        AssertionError var28 = new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                        throw var28;
                     } catch (IllegalStateException var16) {
                        var10000 = var16;
                        var10001 = false;
                        break label105;
                     }
                  }
               }

               try {
                  var2.b((Object)null);
                  return;
               } catch (IllegalStateException var17) {
                  var10000 = var17;
                  var10001 = false;
               }
            }

            IllegalStateException var29 = var10000;
            var2.a("error", m.c(var29), (Object)null);
         }

         private void e(k0.h var1, k0.i.d var2) {
            int var3 = (Integer)((Map)var1.a()).get("id");

            try {
               m.this.b.g(var3);
               var2.b((Object)null);
            } catch (IllegalStateException var4) {
               var2.a("error", m.c(var4), (Object)null);
            }

         }

         // $FF: synthetic method
         private static void f(k0.i.d var0, m.c var1) {
            if (var1 == null) {
               var0.a("error", "Failed to resize the platform view", (Object)null);
            } else {
               HashMap var2 = new HashMap();
               var2.put("width", (double)var1.a);
               var2.put("height", (double)var1.b);
               var0.b(var2);
            }

         }

         private void g(k0.h var1, k0.i.d var2) {
            Map var4 = (Map)var1.a();

            try {
               m.this.b.c((Integer)var4.get("id"), (Double)var4.get("top"), (Double)var4.get("left"));
               var2.b((Object)null);
            } catch (IllegalStateException var3) {
               var2.a("error", m.c(var3), (Object)null);
            }

         }

         private void h(k0.h var1, k0.i.d var2) {
            Map var6 = (Map)var1.a();
            m.e var7 = new m.e((Integer)var6.get("id"), (Double)var6.get("width"), (Double)var6.get("height"));

            try {
               m.g var3 = m.this.b;
               l var4 = new l(var2);
               var3.e(var7, var4);
            } catch (IllegalStateException var5) {
               var2.a("error", m.c(var5), (Object)null);
            }

         }

         private void i(k0.h var1, k0.i.d var2) {
            Map var6 = (Map)var1.a();
            int var3 = (Integer)var6.get("id");
            int var4 = (Integer)var6.get("direction");

            try {
               m.this.b.d(var3, var4);
               var2.b((Object)null);
            } catch (IllegalStateException var5) {
               var2.a("error", m.c(var5), (Object)null);
            }

         }

         private void j(k0.h var1, k0.i.d var2) {
            boolean var3 = (Boolean)var1.a();

            try {
               m.this.b.b(var3);
               var2.b((Object)null);
            } catch (IllegalStateException var4) {
               var2.a("error", m.c(var4), (Object)null);
            }

         }

         private void k(k0.h var1, k0.i.d var2) {
            List var5 = (List)var1.a();
            m.f var6 = new m.f((Integer)var5.get(0), (Number)var5.get(1), (Number)var5.get(2), (Integer)var5.get(3), (Integer)var5.get(4), var5.get(5), var5.get(6), (Integer)var5.get(7), (Integer)var5.get(8), (float)(Double)var5.get(9), (float)(Double)var5.get(10), (Integer)var5.get(11), (Integer)var5.get(12), (Integer)var5.get(13), (Integer)var5.get(14), ((Number)var5.get(15)).longValue());

            IllegalStateException var7;
            label20: {
               try {
                  m.this.b.h(var6);
               } catch (IllegalStateException var4) {
                  var7 = var4;
                  break label20;
               }

               try {
                  var2.b((Object)null);
                  return;
               } catch (IllegalStateException var3) {
                  var7 = var3;
               }
            }

            var2.a("error", m.c(var7), (Object)null);
         }

         public void a(k0.h var1, k0.i.d var2) {
            if (m.this.b != null) {
               StringBuilder var3 = new StringBuilder();
               var3.append("Received '");
               var3.append(var1.a);
               var3.append("' message.");
               y.b.f("PlatformViewsChannel", var3.toString());
               String var5 = var1.a;
               var5.hashCode();
               byte var4 = -1;
               switch(var5.hashCode()) {
               case -1352294148:
                  if (var5.equals("create")) {
                     var4 = 0;
                  }
                  break;
               case -1019779949:
                  if (var5.equals("offset")) {
                     var4 = 1;
                  }
                  break;
               case -934437708:
                  if (var5.equals("resize")) {
                     var4 = 2;
                  }
                  break;
               case -756050293:
                  if (var5.equals("clearFocus")) {
                     var4 = 3;
                  }
                  break;
               case -308988850:
                  if (var5.equals("synchronizeToNativeViewHierarchy")) {
                     var4 = 4;
                  }
                  break;
               case 110550847:
                  if (var5.equals("touch")) {
                     var4 = 5;
                  }
                  break;
               case 576796989:
                  if (var5.equals("setDirection")) {
                     var4 = 6;
                  }
                  break;
               case 1671767583:
                  if (var5.equals("dispose")) {
                     var4 = 7;
                  }
               }

               switch(var4) {
               case 0:
                  this.d(var1, var2);
                  break;
               case 1:
                  this.g(var1, var2);
                  break;
               case 2:
                  this.h(var1, var2);
                  break;
               case 3:
                  this.c(var1, var2);
                  break;
               case 4:
                  this.j(var1, var2);
                  break;
               case 5:
                  this.k(var1, var2);
                  break;
               case 6:
                  this.i(var1, var2);
                  break;
               case 7:
                  this.e(var1, var2);
                  break;
               default:
                  var2.c();
               }

            }
         }
      };
      this.c = var2;
      k0.i var3 = new k0.i(var1, "flutter/platform_views", k0.p.b);
      this.a = var3;
      var3.e(var2);
   }

   private static String c(Exception var0) {
      return y.b.d(var0);
   }

   public void d(int var1) {
      k0.i var2 = this.a;
      if (var2 != null) {
         var2.c("viewFocused", var1);
      }
   }

   public void e(m.g var1) {
      this.b = var1;
   }

   public interface b {
      void a(m.c var1);
   }

   public static class c {
      public final int a;
      public final int b;

      public c(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   public static class d {
      public final int a;
      public final String b;
      public final double c;
      public final double d;
      public final double e;
      public final double f;
      public final int g;
      public final m.d.a h;
      public final ByteBuffer i;

      public d(int var1, String var2, double var3, double var5, double var7, double var9, int var11, m.d.a var12, ByteBuffer var13) {
         this.a = var1;
         this.b = var2;
         this.e = var3;
         this.f = var5;
         this.c = var7;
         this.d = var9;
         this.g = var11;
         this.h = var12;
         this.i = var13;
      }

      public static enum a {
         e,
         f,
         g;

         // $FF: synthetic method
         private static m.d.a[] a() {
            return new m.d.a[]{e, f, g};
         }
      }
   }

   public static class e {
      public final int a;
      public final double b;
      public final double c;

      public e(int var1, double var2, double var4) {
         this.a = var1;
         this.b = var2;
         this.c = var4;
      }
   }

   public static class f {
      public final int a;
      public final Number b;
      public final Number c;
      public final int d;
      public final int e;
      public final Object f;
      public final Object g;
      public final int h;
      public final int i;
      public final float j;
      public final float k;
      public final int l;
      public final int m;
      public final int n;
      public final int o;
      public final long p;

      public f(int var1, Number var2, Number var3, int var4, int var5, Object var6, Object var7, int var8, int var9, float var10, float var11, int var12, int var13, int var14, int var15, long var16) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.h = var8;
         this.i = var9;
         this.j = var10;
         this.k = var11;
         this.l = var12;
         this.m = var13;
         this.n = var14;
         this.o = var15;
         this.p = var16;
      }
   }

   public interface g {
      void a(int var1);

      void b(boolean var1);

      void c(int var1, double var2, double var4);

      void d(int var1, int var2);

      void e(m.e var1, m.b var2);

      long f(m.d var1);

      void g(int var1);

      void h(m.f var1);

      void i(m.d var1);
   }
}
