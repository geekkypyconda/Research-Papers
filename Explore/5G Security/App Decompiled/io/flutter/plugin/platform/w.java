package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.widget.FrameLayout.LayoutParams;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class w implements q {
   private static Class[] w = new Class[]{SurfaceView.class};
   private static boolean x = true;
   private static boolean y = true;
   private final l a = new l();
   private io.flutter.embedding.android.c b;
   private Context c;
   private io.flutter.embedding.android.t d;
   private TextureRegistry e;
   private io.flutter.plugin.editing.m f;
   private j0.m g;
   private final a h = new a();
   final HashMap<Integer, g0> i = new HashMap();
   final HashMap<Context, View> j = new HashMap();
   private final SparseArray<i> k = new SparseArray();
   private final SparseArray<c0.a> l = new SparseArray();
   private final SparseArray<c> m = new SparseArray();
   private final SparseArray<p> n = new SparseArray();
   private int o = 0;
   private boolean p = false;
   private boolean q = true;
   private final HashSet<Integer> r = new HashSet();
   private final HashSet<Integer> s = new HashSet();
   private final io.flutter.embedding.android.d0 t = io.flutter.embedding.android.d0.a();
   private boolean u = false;
   private final j0.m.g v = new j0.m.g() {
      // $FF: synthetic method
      public static void j(Object var0, g0 var1, float var2, j0.m.b var3) {
         var0.k(var1, var2, var3);
      }

      // $FF: synthetic method
      private void k(g0 var1, float var2, j0.m.b var3) {
         w.this.A0(var1);
         if (w.this.c != null) {
            var2 = w.this.V();
         }

         var3.a(new j0.m.c(w.this.w0((double)var1.f(), var2), w.this.w0((double)var1.e(), var2)));
      }

      public void a(int var1) {
         StringBuilder var3;
         String var5;
         label21: {
            View var2;
            if (w.this.c(var1)) {
               var2 = ((g0)w.this.i.get(var1)).g();
            } else {
               i var4 = (i)w.this.k.get(var1);
               if (var4 == null) {
                  var3 = new StringBuilder();
                  var5 = "Clearing focus on an unknown view with id: ";
                  break label21;
               }

               var2 = var4.f();
            }

            if (var2 != null) {
               var2.clearFocus();
               return;
            }

            var3 = new StringBuilder();
            var5 = "Clearing focus on a null view with id: ";
         }

         var3.append(var5);
         var3.append(var1);
         y.b.b("PlatformViewsController", var3.toString());
      }

      public void b(boolean var1) {
         w.this.q = var1;
      }

      public void c(int var1, double var2, double var4) {
         if (!w.this.c(var1)) {
            p var6 = (p)w.this.n.get(var1);
            if (var6 == null) {
               StringBuilder var9 = new StringBuilder();
               var9.append("Setting offset for unknown platform view with id: ");
               var9.append(var1);
               y.b.b("PlatformViewsController", var9.toString());
            } else {
               var1 = w.this.y0(var2);
               int var7 = w.this.y0(var4);
               LayoutParams var8 = (LayoutParams)var6.getLayoutParams();
               var8.topMargin = var1;
               var8.leftMargin = var7;
               var6.setLayoutParams(var8);
            }
         }
      }

      public void d(int var1, int var2) {
         if (!io.flutter.plugin.platform.w.B0(var2)) {
            StringBuilder var5 = new StringBuilder();
            var5.append("Trying to set unknown direction value: ");
            var5.append(var2);
            var5.append("(view id: ");
            var5.append(var1);
            var5.append(")");
            throw new IllegalStateException(var5.toString());
         } else {
            StringBuilder var4;
            String var7;
            label26: {
               View var3;
               if (w.this.c(var1)) {
                  var3 = ((g0)w.this.i.get(var1)).g();
               } else {
                  i var6 = (i)w.this.k.get(var1);
                  if (var6 == null) {
                     var4 = new StringBuilder();
                     var7 = "Setting direction to an unknown view with id: ";
                     break label26;
                  }

                  var3 = var6.f();
               }

               if (var3 != null) {
                  var3.setLayoutDirection(var2);
                  return;
               }

               var4 = new StringBuilder();
               var7 = "Setting direction to a null view with id: ";
            }

            var4.append(var7);
            var4.append(var1);
            y.b.b("PlatformViewsController", var4.toString());
         }
      }

      public void e(j0.m.e var1, j0.m.b var2) {
         int var3 = w.this.y0(var1.b);
         int var4 = w.this.y0(var1.c);
         int var5 = var1.a;
         if (w.this.c(var5)) {
            float var6 = w.this.V();
            g0 var11 = (g0)w.this.i.get(var5);
            w.this.d0(var11);
            var11.k(var3, var4, new v(this, var11, var6, var2));
         } else {
            i var7 = (i)w.this.k.get(var5);
            p var9 = (p)w.this.n.get(var5);
            if (var7 != null && var9 != null) {
               if (var3 > var9.getRenderTargetWidth() || var4 > var9.getRenderTargetHeight()) {
                  var9.b(var3, var4);
               }

               android.view.ViewGroup.LayoutParams var8 = var9.getLayoutParams();
               var8.width = var3;
               var8.height = var4;
               var9.setLayoutParams(var8);
               View var12 = var7.f();
               if (var12 != null) {
                  var8 = var12.getLayoutParams();
                  var8.width = var3;
                  var8.height = var4;
                  var12.setLayoutParams(var8);
               }

               var2.a(new j0.m.c(w.this.v0((double)var9.getRenderTargetWidth()), w.this.v0((double)var9.getRenderTargetHeight())));
            } else {
               StringBuilder var10 = new StringBuilder();
               var10.append("Resizing unknown platform view with id: ");
               var10.append(var5);
               y.b.b("PlatformViewsController", var10.toString());
            }
         }
      }

      public long f(j0.m.d var1) {
         w.this.T(var1);
         int var2 = var1.a;
         StringBuilder var5;
         if (w.this.n.get(var2) == null) {
            if (w.this.e == null) {
               var5 = new StringBuilder();
               var5.append("Texture registry is null. This means that platform views controller was detached, view id: ");
               var5.append(var2);
               throw new IllegalStateException(var5.toString());
            } else if (w.this.d != null) {
               w var3 = w.this;
               boolean var6 = true;
               i var4 = var3.M(var1, true);
               View var7 = var4.f();
               if (var7.getParent() != null) {
                  throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
               } else {
                  if (VERSION.SDK_INT < 23 || o0.i.f(var7, io.flutter.plugin.platform.w.w)) {
                     var6 = false;
                  }

                  if (!var6) {
                     if (var1.h == j0.m.d.a.f) {
                        w.this.H(var4, var1);
                        return -2L;
                     }

                     if (!w.this.u) {
                        return w.this.J(var4, var1);
                     }
                  }

                  return w.this.I(var4, var1);
               }
            } else {
               var5 = new StringBuilder();
               var5.append("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: ");
               var5.append(var2);
               throw new IllegalStateException(var5.toString());
            }
         } else {
            var5 = new StringBuilder();
            var5.append("Trying to create an already created platform view, view id: ");
            var5.append(var2);
            throw new IllegalStateException(var5.toString());
         }
      }

      public void g(int var1) {
         i var2 = (i)w.this.k.get(var1);
         if (var2 == null) {
            StringBuilder var9 = new StringBuilder();
            var9.append("Disposing unknown platform view with id: ");
            var9.append(var1);
            y.b.b("PlatformViewsController", var9.toString());
         } else {
            ViewGroup var4;
            if (var2.f() != null) {
               View var3 = var2.f();
               var4 = (ViewGroup)var3.getParent();
               if (var4 != null) {
                  var4.removeView(var3);
               }
            }

            w.this.k.remove(var1);

            try {
               var2.a();
            } catch (RuntimeException var5) {
               y.b.c("PlatformViewsController", "Disposing platform view threw an exception", var5);
            }

            if (w.this.c(var1)) {
               g0 var8 = (g0)w.this.i.get(var1);
               View var10 = var8.g();
               if (var10 != null) {
                  w.this.j.remove(var10.getContext());
               }

               var8.d();
               w.this.i.remove(var1);
            } else {
               p var6 = (p)w.this.n.get(var1);
               if (var6 != null) {
                  var6.removeAllViews();
                  var6.a();
                  var6.c();
                  var4 = (ViewGroup)var6.getParent();
                  if (var4 != null) {
                     var4.removeView(var6);
                  }

                  w.this.n.remove(var1);
               } else {
                  c0.a var7 = (c0.a)w.this.l.get(var1);
                  if (var7 != null) {
                     var7.removeAllViews();
                     var7.b();
                     var4 = (ViewGroup)var7.getParent();
                     if (var4 != null) {
                        var4.removeView(var7);
                     }

                     w.this.l.remove(var1);
                  }

               }
            }
         }
      }

      public void h(j0.m.f var1) {
         int var2 = var1.a;
         float var3 = w.this.c.getResources().getDisplayMetrics().density;
         if (w.this.c(var2)) {
            ((g0)w.this.i.get(var2)).c(w.this.x0(var3, var1, true));
         } else {
            i var4 = (i)w.this.k.get(var2);
            StringBuilder var5;
            if (var4 == null) {
               var5 = new StringBuilder();
               var5.append("Sending touch to an unknown view with id: ");
               var5.append(var2);
               y.b.b("PlatformViewsController", var5.toString());
            } else {
               View var6 = var4.f();
               if (var6 == null) {
                  var5 = new StringBuilder();
                  var5.append("Sending touch to a null view with id: ");
                  var5.append(var2);
                  y.b.b("PlatformViewsController", var5.toString());
               } else {
                  var6.dispatchTouchEvent(w.this.x0(var3, var1, false));
               }
            }
         }
      }

      public void i(j0.m.d var1) {
         w.this.S(19);
         w.this.T(var1);
         i var2 = w.this.M(var1, false);
         w.this.H(var2, var1);
      }
   };

   private void A0(g0 var1) {
      io.flutter.plugin.editing.m var2 = this.f;
      if (var2 != null) {
         var2.F();
         var1.i();
      }
   }

   private static boolean B0(int var0) {
      boolean var1 = true;
      boolean var2 = var1;
      if (var0 != 0) {
         if (var0 == 1) {
            var2 = var1;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   private void H(i var1, j0.m.d var2) {
      this.S(19);
      StringBuilder var3 = new StringBuilder();
      var3.append("Using hybrid composition for platform view: ");
      var3.append(var2.a);
      y.b.e("PlatformViewsController", var3.toString());
   }

   private long J(i var1, j0.m.d var2) {
      this.S(20);
      StringBuilder var3 = new StringBuilder();
      var3.append("Hosting view in a virtual display for platform view: ");
      var3.append(var2.a);
      y.b.e("PlatformViewsController", var3.toString());
      n var9 = e0(this.e);
      int var4 = this.y0(var2.c);
      int var5 = this.y0(var2.d);
      g0 var6 = g0.b(this.c, this.h, var1, var9, var4, var5, var2.a, (Object)null, new u(this, var2));
      if (var6 != null) {
         this.i.put(var2.a, var6);
         View var8 = var1.f();
         this.j.put(var8.getContext(), var8);
         return var9.getId();
      } else {
         StringBuilder var7 = new StringBuilder();
         var7.append("Failed creating virtual display for a ");
         var7.append(var2.b);
         var7.append(" with id: ");
         var7.append(var2.a);
         throw new IllegalStateException(var7.toString());
      }
   }

   private void R() {
      while(this.k.size() > 0) {
         int var1 = this.k.keyAt(0);
         this.v.g(var1);
      }

   }

   private void S(int var1) {
      int var2 = VERSION.SDK_INT;
      if (var2 < var1) {
         StringBuilder var3 = new StringBuilder();
         var3.append("Trying to use platform views with API ");
         var3.append(var2);
         var3.append(", required API level is: ");
         var3.append(var1);
         throw new IllegalStateException(var3.toString());
      }
   }

   private void T(j0.m.d var1) {
      if (!B0(var1.g)) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Trying to create a view with unknown direction value: ");
         var2.append(var1.g);
         var2.append("(view id: ");
         var2.append(var1.a);
         var2.append(")");
         throw new IllegalStateException(var2.toString());
      }
   }

   private void U(boolean var1) {
      int var2;
      int var3;
      for(var2 = 0; var2 < this.m.size(); ++var2) {
         var3 = this.m.keyAt(var2);
         c var4 = (c)this.m.valueAt(var2);
         if (this.r.contains(var3)) {
            this.d.m(var4);
            var1 &= var4.e();
         } else {
            if (!this.p) {
               var4.c();
            }

            var4.setVisibility(8);
            this.d.removeView(var4);
         }
      }

      for(var2 = 0; var2 < this.l.size(); ++var2) {
         var3 = this.l.keyAt(var2);
         View var5 = (View)this.l.get(var3);
         if (!this.s.contains(var3) || !var1 && this.q) {
            var5.setVisibility(8);
         } else {
            var5.setVisibility(0);
         }
      }

   }

   private float V() {
      return this.c.getResources().getDisplayMetrics().density;
   }

   private void Y() {
      if (this.q && !this.p) {
         this.d.p();
         this.p = true;
      }

   }

   // $FF: synthetic method
   private void Z(j0.m.d var1, View var2, boolean var3) {
      if (var3) {
         this.g.d(var1.a);
      } else {
         io.flutter.plugin.editing.m var4 = this.f;
         if (var4 != null) {
            var4.k(var1.a);
         }
      }

   }

   // $FF: synthetic method
   private void a0(j0.m.d var1, View var2, boolean var3) {
      if (var3) {
         this.g.d(var1.a);
      }

   }

   // $FF: synthetic method
   private void b0(int var1, View var2, boolean var3) {
      if (var3) {
         this.g.d(var1);
      } else {
         io.flutter.plugin.editing.m var4 = this.f;
         if (var4 != null) {
            var4.k(var1);
         }
      }

   }

   // $FF: synthetic method
   private void c0() {
      this.U(false);
   }

   private void d0(g0 var1) {
      io.flutter.plugin.editing.m var2 = this.f;
      if (var2 != null) {
         var2.t();
         var1.h();
      }
   }

   // $FF: synthetic method
   public static void e(w var0) {
      var0.c0();
   }

   private static n e0(TextureRegistry var0) {
      if (y && VERSION.SDK_INT >= 29) {
         TextureRegistry.SurfaceProducer var3 = var0.a();
         y.b.e("PlatformViewsController", "PlatformView is using SurfaceProducer backend");
         return new d0(var3);
      } else if (x && VERSION.SDK_INT >= 29) {
         TextureRegistry.ImageTextureEntry var2 = var0.b();
         y.b.e("PlatformViewsController", "PlatformView is using ImageReader backend");
         return new b(var2);
      } else {
         TextureRegistry.SurfaceTextureEntry var1 = var0.c();
         y.b.e("PlatformViewsController", "PlatformView is using SurfaceTexture backend");
         return new f0(var1);
      }
   }

   // $FF: synthetic method
   public static void f(w var0, j0.m.d var1, View var2, boolean var3) {
      var0.a0(var1, var2, var3);
   }

   private void f0(i var1) {
      io.flutter.embedding.android.t var2 = this.d;
      if (var2 == null) {
         y.b.e("PlatformViewsController", "null flutterView");
      } else {
         var1.b(var2);
      }
   }

   // $FF: synthetic method
   public static void g(w var0, j0.m.d var1, View var2, boolean var3) {
      var0.Z(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void h(w var0, int var1, View var2, boolean var3) {
      var0.b0(var1, var2, var3);
   }

   private static PointerCoords p0(Object var0, float var1) {
      List var2 = (List)var0;
      PointerCoords var7 = new PointerCoords();
      var7.orientation = (float)(Double)var2.get(0);
      var7.pressure = (float)(Double)var2.get(1);
      var7.size = (float)(Double)var2.get(2);
      double var3 = (Double)var2.get(3);
      double var5 = (double)var1;
      var7.toolMajor = (float)(var3 * var5);
      var7.toolMinor = (float)((Double)var2.get(4) * var5);
      var7.touchMajor = (float)((Double)var2.get(5) * var5);
      var7.touchMinor = (float)((Double)var2.get(6) * var5);
      var7.x = (float)((Double)var2.get(7) * var5);
      var7.y = (float)((Double)var2.get(8) * var5);
      return var7;
   }

   private static List<PointerCoords> q0(Object var0, float var1) {
      List var2 = (List)var0;
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         var3.add(p0(var4.next(), var1));
      }

      return var3;
   }

   private static PointerProperties r0(Object var0) {
      List var1 = (List)var0;
      PointerProperties var2 = new PointerProperties();
      var2.id = (Integer)var1.get(0);
      var2.toolType = (Integer)var1.get(1);
      return var2;
   }

   private static List<PointerProperties> s0(Object var0) {
      List var1 = (List)var0;
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.add(r0(var3.next()));
      }

      return var2;
   }

   private void t0() {
      if (this.d == null) {
         y.b.b("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
      } else {
         for(int var1 = 0; var1 < this.m.size(); ++var1) {
            this.d.removeView((View)this.m.valueAt(var1));
         }

         this.m.clear();
      }
   }

   private int v0(double var1) {
      return this.w0(var1, this.V());
   }

   private int w0(double var1, float var3) {
      return (int)Math.round(var1 / (double)var3);
   }

   private int y0(double var1) {
      return (int)Math.round(var1 * (double)this.V());
   }

   private static void z0(MotionEvent var0, PointerCoords[] var1) {
      if (var1.length >= 1) {
         var0.offsetLocation(var1[0].x - var0.getX(), var1[0].y - var0.getY());
      }
   }

   public void C(Context var1, TextureRegistry var2, z.a var3) {
      if (this.c == null) {
         this.c = var1;
         this.e = var2;
         j0.m var4 = new j0.m(var3);
         this.g = var4;
         var4.e(this.v);
      } else {
         throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
      }
   }

   public void D(io.flutter.plugin.editing.m var1) {
      this.f = var1;
   }

   public void E(FlutterRenderer var1) {
      this.b = new io.flutter.embedding.android.c(var1, true);
   }

   public void F(io.flutter.embedding.android.t var1) {
      this.d = var1;
      byte var2 = 0;

      int var3;
      for(var3 = 0; var3 < this.n.size(); ++var3) {
         p var5 = (p)this.n.valueAt(var3);
         this.d.addView(var5);
      }

      int var4 = 0;

      while(true) {
         var3 = var2;
         if (var4 >= this.l.size()) {
            while(var3 < this.k.size()) {
               ((i)this.k.valueAt(var3)).b(this.d);
               ++var3;
            }

            return;
         }

         c0.a var6 = (c0.a)this.l.valueAt(var4);
         this.d.addView(var6);
         ++var4;
      }
   }

   public boolean G(View var1) {
      if (var1 == null) {
         return false;
      } else if (!this.j.containsKey(var1.getContext())) {
         return false;
      } else {
         View var2 = (View)this.j.get(var1.getContext());
         return var2 == var1 ? true : var2.checkInputConnectionProxy(var1);
      }
   }

   public long I(i var1, j0.m.d var2) {
      this.S(23);
      StringBuilder var3 = new StringBuilder();
      var3.append("Hosting view in view hierarchy for platform view: ");
      var3.append(var2.a);
      y.b.e("PlatformViewsController", var3.toString());
      int var4 = this.y0(var2.c);
      int var5 = this.y0(var2.d);
      long var6;
      p var11;
      if (this.u) {
         var11 = new p(this.c);
         var6 = -1L;
      } else {
         n var8 = e0(this.e);
         var11 = new p(this.c, var8);
         var6 = var8.getId();
      }

      var11.setTouchProcessor(this.b);
      var11.b(var4, var5);
      LayoutParams var12 = new LayoutParams(var4, var5);
      int var9 = this.y0(var2.e);
      int var10 = this.y0(var2.f);
      var12.topMargin = var9;
      var12.leftMargin = var10;
      var11.setLayoutParams(var12);
      View var13 = var1.f();
      var13.setLayoutParams(new LayoutParams(var4, var5));
      var13.setImportantForAccessibility(4);
      var11.addView(var13);
      var11.setOnDescendantFocusChangeListener(new t(this, var2));
      this.d.addView(var11);
      this.n.append(var2.a, var11);
      this.f0(var1);
      return var6;
   }

   public FlutterOverlaySurface K() {
      return this.L(new c(this.d.getContext(), this.d.getWidth(), this.d.getHeight(), this.h));
   }

   public FlutterOverlaySurface L(c var1) {
      int var2 = this.o++;
      this.m.put(var2, var1);
      return new FlutterOverlaySurface(var2, var1.getSurface());
   }

   public i M(j0.m.d var1, boolean var2) {
      j var3 = this.a.a(var1.b);
      if (var3 != null) {
         Object var8 = null;
         if (var1.i != null) {
            var8 = var3.b().a(var1.i);
         }

         Object var5;
         if (var2) {
            var5 = new MutableContextWrapper(this.c);
         } else {
            var5 = this.c;
         }

         i var6 = var3.a((Context)var5, var1.a, var8);
         View var7 = var6.f();
         if (var7 != null) {
            var7.setLayoutDirection(var1.g);
            this.k.put(var1.a, var6);
            this.f0(var6);
            return var6;
         } else {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
         }
      } else {
         StringBuilder var4 = new StringBuilder();
         var4.append("Trying to create a platform view of unregistered type: ");
         var4.append(var1.b);
         throw new IllegalStateException(var4.toString());
      }
   }

   public void N() {
      for(int var1 = 0; var1 < this.m.size(); ++var1) {
         c var2 = (c)this.m.valueAt(var1);
         var2.c();
         var2.g();
      }

   }

   public void O() {
      j0.m var1 = this.g;
      if (var1 != null) {
         var1.e((j0.m.g)null);
      }

      this.N();
      this.g = null;
      this.c = null;
      this.e = null;
   }

   public void P() {
      byte var1 = 0;

      int var2;
      for(var2 = 0; var2 < this.n.size(); ++var2) {
         p var3 = (p)this.n.valueAt(var2);
         this.d.removeView(var3);
      }

      for(var2 = 0; var2 < this.l.size(); ++var2) {
         c0.a var4 = (c0.a)this.l.valueAt(var2);
         this.d.removeView(var4);
      }

      this.N();
      this.t0();
      this.d = null;
      this.p = false;

      for(var2 = var1; var2 < this.k.size(); ++var2) {
         ((i)this.k.valueAt(var2)).c();
      }

   }

   public void Q() {
      this.f = null;
   }

   public k W() {
      return this.a;
   }

   void X(int var1) {
      i var2 = (i)this.k.get(var1);
      if (var2 != null) {
         if (this.l.get(var1) == null) {
            View var4 = var2.f();
            if (var4 != null) {
               if (var4.getParent() == null) {
                  Context var3 = this.c;
                  c0.a var5 = new c0.a(var3, var3.getResources().getDisplayMetrics().density, this.b);
                  var5.setOnDescendantFocusChangeListener(new r(this, var1));
                  this.l.put(var1, var5);
                  var4.setImportantForAccessibility(4);
                  var5.addView(var4);
                  this.d.addView(var5);
               } else {
                  throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
               }
            } else {
               throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
         }
      } else {
         throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
      }
   }

   public void a() {
      this.h.c((io.flutter.view.h)null);
   }

   public void b(io.flutter.view.h var1) {
      this.h.c(var1);
   }

   public boolean c(int var1) {
      return this.i.containsKey(var1);
   }

   public View d(int var1) {
      if (this.c(var1)) {
         return ((g0)this.i.get(var1)).g();
      } else {
         i var2 = (i)this.k.get(var1);
         return var2 == null ? null : var2.f();
      }
   }

   public void g0() {
   }

   public void h0() {
      this.r.clear();
      this.s.clear();
   }

   public void i0() {
      this.R();
   }

   public void j0(int var1, int var2, int var3, int var4, int var5) {
      if (this.m.get(var1) != null) {
         this.Y();
         c var6 = (c)this.m.get(var1);
         if (var6.getParent() == null) {
            this.d.addView(var6);
         }

         LayoutParams var8 = new LayoutParams(var4, var5);
         var8.leftMargin = var2;
         var8.topMargin = var3;
         var6.setLayoutParams(var8);
         var6.setVisibility(0);
         var6.bringToFront();
         this.r.add(var1);
      } else {
         StringBuilder var7 = new StringBuilder();
         var7.append("The overlay surface (id:");
         var7.append(var1);
         var7.append(") doesn't exist");
         throw new IllegalStateException(var7.toString());
      }
   }

   public void k0(int var1, int var2, int var3, int var4, int var5, int var6, int var7, FlutterMutatorsStack var8) {
      this.Y();
      this.X(var1);
      c0.a var9 = (c0.a)this.l.get(var1);
      var9.a(var8, var2, var3, var4, var5);
      var9.setVisibility(0);
      var9.bringToFront();
      LayoutParams var11 = new LayoutParams(var6, var7);
      View var10 = ((i)this.k.get(var1)).f();
      if (var10 != null) {
         var10.setLayoutParams(var11);
         var10.bringToFront();
      }

      this.s.add(var1);
   }

   public void l0() {
      boolean var1 = this.p;
      boolean var2 = false;
      if (var1 && this.s.isEmpty()) {
         this.p = false;
         this.d.A(new s(this));
      } else {
         var1 = var2;
         if (this.p) {
            var1 = var2;
            if (this.d.k()) {
               var1 = true;
            }
         }

         this.U(var1);
      }
   }

   public void m0() {
      this.R();
   }

   public void n0() {
      Iterator var1 = this.i.values().iterator();

      while(var1.hasNext()) {
         ((g0)var1.next()).j();
      }

   }

   public void o0(int var1) {
      if (var1 >= 40) {
         Iterator var2 = this.i.values().iterator();

         while(var2.hasNext()) {
            ((g0)var2.next()).a();
         }

      }
   }

   public void u0(boolean var1) {
      this.u = var1;
   }

   public MotionEvent x0(float var1, j0.m.f var2, boolean var3) {
      io.flutter.embedding.android.d0.a var4 = io.flutter.embedding.android.d0.a.c(var2.p);
      MotionEvent var5 = this.t.b(var4);
      PointerCoords[] var7 = (PointerCoords[])q0(var2.g, var1).toArray(new PointerCoords[var2.e]);
      if (!var3 && var5 != null) {
         z0(var5, var7);
         return var5;
      } else {
         PointerProperties[] var6 = (PointerProperties[])s0(var2.f).toArray(new PointerProperties[var2.e]);
         return MotionEvent.obtain(var2.b.longValue(), var2.c.longValue(), var2.d, var2.e, var6, var7, var2.h, var2.i, var2.j, var2.k, var2.l, var2.m, var2.n, var2.o);
      }
   }
}
