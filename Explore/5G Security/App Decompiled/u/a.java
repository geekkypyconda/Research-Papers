package u;

import a1.g;
import a1.k;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.h;
import o.j;
import q0.l;
import r.d;

public final class a {
   public static final u.a.a b = new u.a.a((g)null);
   private static final String c = u.a.class.getSimpleName();
   private final j a;

   public a() {
      this((j)null, 1, (g)null);
   }

   public a(j var1) {
      k.e(var1, "verificationMode");
      super();
      this.a = var1;
   }

   // $FF: synthetic method
   public a(j var1, int var2, g var3) {
      if ((var2 & 1) != 0) {
         var1 = j.g;
      }

      this(var1);
   }

   private final boolean b(SidecarDisplayFeature var1, SidecarDisplayFeature var2) {
      if (k.a(var1, var2)) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (var2 == null) {
         return false;
      } else {
         return var1.getType() != var2.getType() ? false : k.a(var1.getRect(), var2.getRect());
      }
   }

   private final boolean c(List<SidecarDisplayFeature> var1, List<SidecarDisplayFeature> var2) {
      if (var1 == var2) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (var2 == null) {
         return false;
      } else if (var1.size() != var2.size()) {
         return false;
      } else {
         int var3 = var1.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            if (!this.b((SidecarDisplayFeature)var1.get(var4), (SidecarDisplayFeature)var2.get(var4))) {
               return false;
            }
         }

         return true;
      }
   }

   public final boolean a(SidecarDeviceState var1, SidecarDeviceState var2) {
      boolean var3 = k.a(var1, var2);
      boolean var4 = true;
      if (var3) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (var2 == null) {
         return false;
      } else {
         u.a.a var5 = b;
         if (var5.b(var1) != var5.b(var2)) {
            var4 = false;
         }

         return var4;
      }
   }

   public final boolean d(SidecarWindowLayoutInfo var1, SidecarWindowLayoutInfo var2) {
      if (k.a(var1, var2)) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (var2 == null) {
         return false;
      } else {
         u.a.a var3 = b;
         return this.c(var3.c(var1), var3.c(var2));
      }
   }

   public final List<r.a> e(List<SidecarDisplayFeature> var1, SidecarDeviceState var2) {
      k.e(var1, "sidecarDisplayFeatures");
      k.e(var2, "deviceState");
      ArrayList var3 = new ArrayList();
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         r.a var4 = this.g((SidecarDisplayFeature)var5.next(), var2);
         if (var4 != null) {
            var3.add(var4);
         }
      }

      return var3;
   }

   public final r.j f(SidecarWindowLayoutInfo var1, SidecarDeviceState var2) {
      k.e(var2, "state");
      if (var1 == null) {
         return new r.j(l.e());
      } else {
         SidecarDeviceState var3 = new SidecarDeviceState();
         u.a.a var4 = b;
         var4.d(var3, var4.b(var2));
         return new r.j(this.e(var4.c(var1), var3));
      }
   }

   public final r.a g(SidecarDisplayFeature var1, SidecarDeviceState var2) {
      k.e(var1, "feature");
      k.e(var2, "deviceState");
      h.a var3 = h.a;
      String var4 = c;
      k.d(var4, "TAG");
      SidecarDisplayFeature var8 = (SidecarDisplayFeature)h.a.b(var3, var1, var4, this.a, (o.g)null, 4, (Object)null).c("Type must be either TYPE_FOLD or TYPE_HINGE", null.f).c("Feature bounds must not be 0", null.f).c("TYPE_FOLD must have 0 area", null.f).c("Feature be pinned to either left or top", null.f).a();
      var4 = null;
      if (var8 == null) {
         return null;
      } else {
         int var5 = var8.getType();
         d.b var10;
         if (var5 != 1) {
            if (var5 != 2) {
               return null;
            }

            var10 = d.b.b.b();
         } else {
            var10 = d.b.b.a();
         }

         var5 = b.b(var2);
         d var7 = var4;
         if (var5 != 0) {
            var7 = var4;
            if (var5 != 1) {
               r.c.b var9;
               if (var5 != 2) {
                  if (var5 != 3) {
                     var7 = var4;
                     if (var5 == 4) {
                        return var7;
                     }
                  }

                  var9 = r.c.b.c;
               } else {
                  var9 = r.c.b.d;
               }

               Rect var6 = var1.getRect();
               k.d(var6, "feature.rect");
               var7 = new d(new o.b(var6), var10, var9);
            }
         }

         return var7;
      }
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(g var1) {
         this();
      }

      public final int a(SidecarDeviceState var1) {
         k.e(var1, "sidecarDeviceState");

         int var2;
         try {
            var2 = var1.posture;
            return var2;
         } catch (NoSuchFieldError var5) {
            try {
               Object var6 = SidecarDeviceState.class.getMethod("getPosture").invoke(var1);
               k.c(var6, "null cannot be cast to non-null type kotlin.Int");
               var2 = (Integer)var6;
               return var2;
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var4) {
               return 0;
            }
         }
      }

      public final int b(SidecarDeviceState var1) {
         k.e(var1, "sidecarDeviceState");
         int var2 = this.a(var1);
         int var3;
         if (var2 >= 0) {
            var3 = var2;
            if (var2 <= 4) {
               return var3;
            }
         }

         var3 = 0;
         return var3;
      }

      public final List<SidecarDisplayFeature> c(SidecarWindowLayoutInfo var1) {
         k.e(var1, "info");

         label34: {
            boolean var10001;
            List var2;
            try {
               var2 = var1.displayFeatures;
            } catch (NoSuchFieldError var6) {
               var10001 = false;
               break label34;
            }

            List var3 = var2;
            if (var2 != null) {
               return var3;
            }

            try {
               var3 = l.e();
               return var3;
            } catch (NoSuchFieldError var5) {
               var10001 = false;
            }
         }

         try {
            Object var7 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures").invoke(var1);
            k.c(var7, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
            List var8 = (List)var7;
            return var8;
         } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var4) {
            return l.e();
         }
      }

      public final void d(SidecarDeviceState var1, int var2) {
         k.e(var1, "sidecarDeviceState");

         try {
            var1.posture = var2;
         } catch (NoSuchFieldError var5) {
            try {
               SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(var1, var2);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var4) {
            }
         }

      }
   }
}
