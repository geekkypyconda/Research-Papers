package r;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import androidx.core.view.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class n implements m {
   public static final n b = new n();
   private static final String c;
   private static final ArrayList<Integer> d;

   static {
      String var0 = n.class.getSimpleName();
      a1.k.d(var0, "WindowMetricsCalculatorC…at::class.java.simpleName");
      c = var0;
      d = q0.l.c(v.m.g(), v.m.f(), v.m.a(), v.m.c(), v.m.h(), v.m.e(), v.m.i(), v.m.b());
   }

   private n() {
   }

   private final DisplayCutout j(Display var1) {
      DisplayCutout var13;
      label27: {
         Object var10;
         try {
            Constructor var2 = Class.forName("android.view.DisplayInfo").getConstructor();
            var2.setAccessible(true);
            Object var11 = var2.newInstance();
            Method var3 = var1.getClass().getDeclaredMethod("getDisplayInfo", var11.getClass());
            var3.setAccessible(true);
            var3.invoke(var1, var11);
            Field var12 = var11.getClass().getDeclaredField("displayCutout");
            var12.setAccessible(true);
            var10 = var12.get(var11);
            if (var10 instanceof DisplayCutout) {
               var13 = (DisplayCutout)var10;
               return var13;
            }
            break label27;
         } catch (ClassNotFoundException var4) {
            var10 = var4;
         } catch (NoSuchMethodException var5) {
            var10 = var5;
         } catch (NoSuchFieldException var6) {
            var10 = var6;
         } catch (IllegalAccessException var7) {
            var10 = var7;
         } catch (InvocationTargetException var8) {
            var10 = var8;
         } catch (InstantiationException var9) {
            var10 = var9;
         }

         Log.w(c, (Throwable)var10);
      }

      var13 = null;
      return var13;
   }

   private final int k(Context var1) {
      Resources var3 = var1.getResources();
      int var2 = var3.getIdentifier("navigation_bar_height", "dimen", "android");
      if (var2 > 0) {
         var2 = var3.getDimensionPixelSize(var2);
      } else {
         var2 = 0;
      }

      return var2;
   }

   private final void m(Activity var1, Rect var2) {
      var1.getWindowManager().getDefaultDisplay().getRectSize(var2);
   }

   public k a(Activity var1) {
      a1.k.e(var1, "activity");
      return this.d(var1);
   }

   public k b(Activity var1) {
      a1.k.e(var1, "activity");
      int var2 = VERSION.SDK_INT;
      Rect var3;
      if (var2 >= 30) {
         var3 = v.g.a.a(var1);
      } else if (var2 >= 29) {
         var3 = this.h(var1);
      } else if (var2 >= 28) {
         var3 = this.g(var1);
      } else if (var2 >= 24) {
         var3 = this.f(var1);
      } else {
         var3 = this.e(var1);
      }

      v var4;
      if (var2 >= 30) {
         var4 = this.i(var1);
      } else {
         var4 = (new v.b()).a();
         a1.k.d(var4, "{\n            WindowInse…ilder().build()\n        }");
      }

      return new k(new o.b(var3), var4);
   }

   public k c(Context var1) {
      a1.k.e(var1, "context");
      if (VERSION.SDK_INT >= 30) {
         return v.g.a.c(var1);
      } else {
         Context var2 = v.c.a.a(var1);
         if (var2 instanceof Activity) {
            return this.b((Activity)var1);
         } else if (var2 instanceof InputMethodService) {
            Object var3 = var1.getSystemService("window");
            a1.k.c(var3, "null cannot be cast to non-null type android.view.WindowManager");
            Display var4 = ((WindowManager)var3).getDefaultDisplay();
            a1.k.d(var4, "wm.defaultDisplay");
            Point var5 = this.l(var4);
            return new k(new Rect(0, 0, var5.x, var5.y), (v)null, 2, (a1.g)null);
         } else {
            StringBuilder var6 = new StringBuilder();
            var6.append(var1);
            var6.append(" is not a UiContext");
            throw new IllegalArgumentException(var6.toString());
         }
      }
   }

   public k d(Context var1) {
      a1.k.e(var1, "context");
      int var2 = VERSION.SDK_INT;
      Rect var3;
      if (var2 >= 30) {
         var3 = v.g.a.d(var1);
      } else {
         Object var5 = var1.getSystemService("window");
         a1.k.c(var5, "null cannot be cast to non-null type android.view.WindowManager");
         Display var6 = ((WindowManager)var5).getDefaultDisplay();
         a1.k.d(var6, "display");
         Point var7 = this.l(var6);
         var3 = new Rect(0, 0, var7.x, var7.y);
      }

      v var4;
      if (var2 >= 30) {
         var4 = this.i(var1);
      } else {
         var4 = (new v.b()).a();
         a1.k.d(var4, "{\n            WindowInse…ilder().build()\n        }");
      }

      return new k(new o.b(var3), var4);
   }

   public final Rect e(Activity var1) {
      a1.k.e(var1, "activity");
      Display var6 = var1.getWindowManager().getDefaultDisplay();
      a1.k.d(var6, "defaultDisplay");
      Point var2 = this.l(var6);
      Rect var3 = new Rect();
      int var4 = var2.x;
      if (var4 != 0) {
         int var5 = var2.y;
         if (var5 != 0) {
            var3.right = var4;
            var3.bottom = var5;
            return var3;
         }
      }

      var6.getRectSize(var3);
      return var3;
   }

   public final Rect f(Activity var1) {
      a1.k.e(var1, "activity");
      Rect var2 = new Rect();
      Display var3 = var1.getWindowManager().getDefaultDisplay();
      var3.getRectSize(var2);
      if (!v.b.a.a(var1)) {
         a1.k.d(var3, "defaultDisplay");
         Point var6 = this.l(var3);
         int var4 = this.k(var1);
         int var5 = var2.bottom;
         if (var5 + var4 == var6.y) {
            var2.bottom = var5 + var4;
         } else {
            var5 = var2.right;
            if (var5 + var4 == var6.x) {
               var2.right = var5 + var4;
            }
         }
      }

      return var2;
   }

   public final Rect g(Activity var1) {
      a1.k.e(var1, "activity");
      Rect var2 = new Rect();
      Configuration var3 = var1.getResources().getConfiguration();

      label109: {
         Object var26;
         label108: {
            NoSuchMethodException var33;
            label107: {
               IllegalAccessException var32;
               label106: {
                  InvocationTargetException var10000;
                  label105: {
                     NoSuchFieldException var34;
                     label113: {
                        boolean var5;
                        boolean var10001;
                        try {
                           Field var4 = Configuration.class.getDeclaredField("windowConfiguration");
                           var4.setAccessible(true);
                           var26 = var4.get(var3);
                           var5 = v.b.a.a(var1);
                        } catch (NoSuchFieldException var21) {
                           var34 = var21;
                           var10001 = false;
                           break label113;
                        } catch (NoSuchMethodException var22) {
                           var33 = var22;
                           var10001 = false;
                           break label107;
                        } catch (IllegalAccessException var23) {
                           var32 = var23;
                           var10001 = false;
                           break label106;
                        } catch (InvocationTargetException var24) {
                           var10000 = var24;
                           var10001 = false;
                           break label105;
                        }

                        Rect var27;
                        if (var5) {
                           try {
                              var26 = var26.getClass().getDeclaredMethod("getBounds").invoke(var26);
                              a1.k.c(var26, "null cannot be cast to non-null type android.graphics.Rect");
                              var27 = (Rect)var26;
                           } catch (NoSuchFieldException var17) {
                              var34 = var17;
                              var10001 = false;
                              break label113;
                           } catch (NoSuchMethodException var18) {
                              var33 = var18;
                              var10001 = false;
                              break label107;
                           } catch (IllegalAccessException var19) {
                              var32 = var19;
                              var10001 = false;
                              break label106;
                           } catch (InvocationTargetException var20) {
                              var10000 = var20;
                              var10001 = false;
                              break label105;
                           }
                        } else {
                           try {
                              var26 = var26.getClass().getDeclaredMethod("getAppBounds").invoke(var26);
                              a1.k.c(var26, "null cannot be cast to non-null type android.graphics.Rect");
                              var27 = (Rect)var26;
                           } catch (NoSuchFieldException var13) {
                              var34 = var13;
                              var10001 = false;
                              break label113;
                           } catch (NoSuchMethodException var14) {
                              var33 = var14;
                              var10001 = false;
                              break label107;
                           } catch (IllegalAccessException var15) {
                              var32 = var15;
                              var10001 = false;
                              break label106;
                           } catch (InvocationTargetException var16) {
                              var10000 = var16;
                              var10001 = false;
                              break label105;
                           }
                        }

                        try {
                           var2.set(var27);
                           break label109;
                        } catch (NoSuchFieldException var9) {
                           var34 = var9;
                           var10001 = false;
                        } catch (NoSuchMethodException var10) {
                           var33 = var10;
                           var10001 = false;
                           break label107;
                        } catch (IllegalAccessException var11) {
                           var32 = var11;
                           var10001 = false;
                           break label106;
                        } catch (InvocationTargetException var12) {
                           var10000 = var12;
                           var10001 = false;
                           break label105;
                        }
                     }

                     var26 = var34;
                     break label108;
                  }

                  var26 = var10000;
                  break label108;
               }

               var26 = var32;
               break label108;
            }

            var26 = var33;
         }

         Log.w(c, (Throwable)var26);
         this.m(var1, var2);
      }

      Display var28 = var1.getWindowManager().getDefaultDisplay();
      Point var31 = new Point();
      v.h var6 = v.h.a;
      a1.k.d(var28, "currentDisplay");
      var6.a(var28, var31);
      v.b var30 = v.b.a;
      int var7;
      if (!var30.a(var1)) {
         var7 = this.k(var1);
         int var8 = var2.bottom;
         if (var8 + var7 == var31.y) {
            var2.bottom = var8 + var7;
         } else {
            var8 = var2.right;
            if (var8 + var7 == var31.x) {
               var2.right = var8 + var7;
            } else if (var2.left == var7) {
               var2.left = 0;
            }
         }
      }

      if ((var2.width() < var31.x || var2.height() < var31.y) && !var30.a(var1)) {
         DisplayCutout var29 = this.j(var28);
         if (var29 != null) {
            var7 = var2.left;
            v.i var25 = v.i.a;
            if (var7 == var25.b(var29)) {
               var2.left = 0;
            }

            if (var31.x - var2.right == var25.c(var29)) {
               var2.right += var25.c(var29);
            }

            if (var2.top == var25.d(var29)) {
               var2.top = 0;
            }

            if (var31.y - var2.bottom == var25.a(var29)) {
               var2.bottom += var25.a(var29);
            }
         }
      }

      return var2;
   }

   public final Rect h(Activity var1) {
      a1.k.e(var1, "activity");
      Configuration var2 = var1.getResources().getConfiguration();

      Rect var9;
      Rect var13;
      label30: {
         Object var10;
         try {
            Field var3 = Configuration.class.getDeclaredField("windowConfiguration");
            var3.setAccessible(true);
            Object var4 = var3.get(var2);
            Method var11 = var4.getClass().getDeclaredMethod("getBounds");
            Object var12 = var11.invoke(var4);
            a1.k.c(var12, "null cannot be cast to non-null type android.graphics.Rect");
            var13 = new Rect((Rect)var12);
            break label30;
         } catch (NoSuchFieldException var5) {
            var10 = var5;
         } catch (NoSuchMethodException var6) {
            var10 = var6;
         } catch (IllegalAccessException var7) {
            var10 = var7;
         } catch (InvocationTargetException var8) {
            var10 = var8;
         }

         Log.w(c, (Throwable)var10);
         var9 = this.g(var1);
         return var9;
      }

      var9 = var13;
      return var9;
   }

   public final v i(Context var1) {
      a1.k.e(var1, "context");
      if (VERSION.SDK_INT >= 30) {
         return v.g.a.b(var1);
      } else {
         throw new Exception("Incompatible SDK version");
      }
   }

   public final Point l(Display var1) {
      a1.k.e(var1, "display");
      Point var2 = new Point();
      v.h.a.a(var1, var2);
      return var2;
   }
}
