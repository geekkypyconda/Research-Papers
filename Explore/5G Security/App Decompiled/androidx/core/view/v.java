package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class v {
   public static final v b;
   private final v.l a;

   static {
      v var0;
      if (VERSION.SDK_INT >= 30) {
         var0 = v.k.q;
      } else {
         var0 = v.l.b;
      }

      b = var0;
   }

   private v(WindowInsets var1) {
      int var2 = VERSION.SDK_INT;
      Object var3;
      if (var2 >= 30) {
         var3 = new v.k(this, var1);
      } else if (var2 >= 29) {
         var3 = new v.j(this, var1);
      } else if (var2 >= 28) {
         var3 = new v.i(this, var1);
      } else {
         var3 = new v.h(this, var1);
      }

      this.a = (v.l)var3;
   }

   public v(v var1) {
      if (var1 != null) {
         v.l var2 = var1.a;
         int var3 = VERSION.SDK_INT;
         Object var4;
         if (var3 >= 30 && var2 instanceof v.k) {
            var4 = new v.k(this, (v.k)var2);
         } else if (var3 >= 29 && var2 instanceof v.j) {
            var4 = new v.j(this, (v.j)var2);
         } else if (var3 >= 28 && var2 instanceof v.i) {
            var4 = new v.i(this, (v.i)var2);
         } else if (var2 instanceof v.h) {
            var4 = new v.h(this, (v.h)var2);
         } else if (var2 instanceof v.g) {
            var4 = new v.g(this, (v.g)var2);
         } else {
            var4 = new v.l(this);
         }

         this.a = (v.l)var4;
         var2.e(this);
      } else {
         this.a = new v.l(this);
      }

   }

   public static v m(WindowInsets var0) {
      return n(var0, (View)null);
   }

   public static v n(WindowInsets var0, View var1) {
      v var2 = new v((WindowInsets)h.c.a(var0));
      if (var1 != null && var1.isAttachedToWindow()) {
         var2.j(androidx.core.view.f.b(var1));
         var2.d(var1.getRootView());
      }

      return var2;
   }

   @Deprecated
   public v a() {
      return this.a.a();
   }

   @Deprecated
   public v b() {
      return this.a.b();
   }

   @Deprecated
   public v c() {
      return this.a.c();
   }

   void d(View var1) {
      this.a.d(var1);
   }

   public androidx.core.view.a e() {
      return this.a.f();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof v)) {
         return false;
      } else {
         v var2 = (v)var1;
         return h.b.a(this.a, var2.a);
      }
   }

   public androidx.core.graphics.a f(int var1) {
      return this.a.g(var1);
   }

   @Deprecated
   public androidx.core.graphics.a g() {
      return this.a.i();
   }

   void h(androidx.core.graphics.a[] var1) {
      this.a.o(var1);
   }

   public int hashCode() {
      v.l var1 = this.a;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.hashCode();
      }

      return var2;
   }

   void i(androidx.core.graphics.a var1) {
      this.a.p(var1);
   }

   void j(v var1) {
      this.a.q(var1);
   }

   void k(androidx.core.graphics.a var1) {
      this.a.r(var1);
   }

   public WindowInsets l() {
      v.l var1 = this.a;
      WindowInsets var2;
      if (var1 instanceof v.g) {
         var2 = ((v.g)var1).c;
      } else {
         var2 = null;
      }

      return var2;
   }

   static class a {
      private static Field a;
      private static Field b;
      private static Field c;
      private static boolean d;

      static {
         try {
            Field var3 = View.class.getDeclaredField("mAttachInfo");
            a = var3;
            var3.setAccessible(true);
            Class var1 = Class.forName("android.view.View$AttachInfo");
            var3 = var1.getDeclaredField("mStableInsets");
            b = var3;
            var3.setAccessible(true);
            var3 = var1.getDeclaredField("mContentInsets");
            c = var3;
            var3.setAccessible(true);
            d = true;
         } catch (ReflectiveOperationException var2) {
            StringBuilder var0 = new StringBuilder();
            var0.append("Failed to get visible insets from AttachInfo ");
            var0.append(var2.getMessage());
            Log.w("WindowInsetsCompat", var0.toString(), var2);
         }

      }

      public static v a(View var0) {
         if (d && var0.isAttachedToWindow()) {
            View var1 = var0.getRootView();

            IllegalAccessException var10000;
            label45: {
               Object var2;
               boolean var10001;
               try {
                  var2 = a.get(var1);
               } catch (IllegalAccessException var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label45;
               }

               if (var2 == null) {
                  return null;
               }

               Rect var3;
               Rect var8;
               try {
                  var8 = (Rect)b.get(var2);
                  var3 = (Rect)c.get(var2);
               } catch (IllegalAccessException var5) {
                  var10000 = var5;
                  var10001 = false;
                  break label45;
               }

               if (var8 == null || var3 == null) {
                  return null;
               }

               try {
                  v.b var11 = new v.b();
                  v var10 = var11.b(androidx.core.graphics.a.c(var8)).c(androidx.core.graphics.a.c(var3)).a();
                  var10.j(var10);
                  var10.d(var0.getRootView());
                  return var10;
               } catch (IllegalAccessException var4) {
                  var10000 = var4;
                  var10001 = false;
               }
            }

            IllegalAccessException var9 = var10000;
            StringBuilder var7 = new StringBuilder();
            var7.append("Failed to get insets from AttachInfo. ");
            var7.append(var9.getMessage());
            Log.w("WindowInsetsCompat", var7.toString(), var9);
         }

         return null;
      }
   }

   public static final class b {
      private final v.f a;

      public b() {
         int var1 = VERSION.SDK_INT;
         Object var2;
         if (var1 >= 30) {
            var2 = new v.e();
         } else if (var1 >= 29) {
            var2 = new v.d();
         } else {
            var2 = new v.c();
         }

         this.a = (v.f)var2;
      }

      public v a() {
         return this.a.b();
      }

      @Deprecated
      public v.b b(androidx.core.graphics.a var1) {
         this.a.d(var1);
         return this;
      }

      @Deprecated
      public v.b c(androidx.core.graphics.a var1) {
         this.a.f(var1);
         return this;
      }
   }

   private static class c extends v.f {
      private static Field e;
      private static boolean f;
      private static Constructor<WindowInsets> g;
      private static boolean h;
      private WindowInsets c = h();
      private androidx.core.graphics.a d;

      c() {
      }

      private static WindowInsets h() {
         if (!f) {
            try {
               e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException var3) {
               Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", var3);
            }

            f = true;
         }

         Field var0 = e;
         WindowInsets var7;
         if (var0 != null) {
            label54: {
               ReflectiveOperationException var10000;
               label59: {
                  boolean var10001;
                  try {
                     var7 = (WindowInsets)var0.get((Object)null);
                  } catch (ReflectiveOperationException var6) {
                     var10000 = var6;
                     var10001 = false;
                     break label59;
                  }

                  if (var7 == null) {
                     break label54;
                  }

                  try {
                     var7 = new WindowInsets(var7);
                     return var7;
                  } catch (ReflectiveOperationException var5) {
                     var10000 = var5;
                     var10001 = false;
                  }
               }

               ReflectiveOperationException var8 = var10000;
               Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", var8);
            }
         }

         if (!h) {
            try {
               g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException var2) {
               Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", var2);
            }

            h = true;
         }

         Constructor var1 = g;
         if (var1 != null) {
            try {
               Rect var9 = new Rect();
               var7 = (WindowInsets)var1.newInstance(var9);
               return var7;
            } catch (ReflectiveOperationException var4) {
               Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", var4);
            }
         }

         return null;
      }

      v b() {
         this.a();
         v var1 = v.m(this.c);
         var1.h(super.b);
         var1.k(this.d);
         return var1;
      }

      void d(androidx.core.graphics.a var1) {
         this.d = var1;
      }

      void f(androidx.core.graphics.a var1) {
         WindowInsets var2 = this.c;
         if (var2 != null) {
            this.c = var2.replaceSystemWindowInsets(var1.a, var1.b, var1.c, var1.d);
         }

      }
   }

   private static class d extends v.f {
      final WindowInsets$Builder c = new WindowInsets$Builder();

      d() {
      }

      v b() {
         this.a();
         v var1 = v.m(this.c.build());
         var1.h(super.b);
         return var1;
      }

      void c(androidx.core.graphics.a var1) {
         this.c.setMandatorySystemGestureInsets(var1.e());
      }

      void d(androidx.core.graphics.a var1) {
         this.c.setStableInsets(var1.e());
      }

      void e(androidx.core.graphics.a var1) {
         this.c.setSystemGestureInsets(var1.e());
      }

      void f(androidx.core.graphics.a var1) {
         this.c.setSystemWindowInsets(var1.e());
      }

      void g(androidx.core.graphics.a var1) {
         this.c.setTappableElementInsets(var1.e());
      }
   }

   private static class e extends v.d {
      e() {
      }
   }

   private static class f {
      private final v a;
      androidx.core.graphics.a[] b;

      f() {
         this(new v((v)null));
      }

      f(v var1) {
         this.a = var1;
      }

      protected final void a() {
         androidx.core.graphics.a[] var1 = this.b;
         if (var1 != null) {
            androidx.core.graphics.a var2 = var1[v.m.d(1)];
            androidx.core.graphics.a var3 = this.b[v.m.d(2)];
            androidx.core.graphics.a var4 = var3;
            if (var3 == null) {
               var4 = this.a.f(2);
            }

            var3 = var2;
            if (var2 == null) {
               var3 = this.a.f(1);
            }

            this.f(androidx.core.graphics.a.a(var3, var4));
            var4 = this.b[v.m.d(16)];
            if (var4 != null) {
               this.e(var4);
            }

            var4 = this.b[v.m.d(32)];
            if (var4 != null) {
               this.c(var4);
            }

            var4 = this.b[v.m.d(64)];
            if (var4 != null) {
               this.g(var4);
            }
         }

      }

      v b() {
         throw null;
      }

      void c(androidx.core.graphics.a var1) {
      }

      void d(androidx.core.graphics.a var1) {
         throw null;
      }

      void e(androidx.core.graphics.a var1) {
      }

      void f(androidx.core.graphics.a var1) {
         throw null;
      }

      void g(androidx.core.graphics.a var1) {
      }
   }

   private static class g extends v.l {
      private static boolean h;
      private static Method i;
      private static Class<?> j;
      private static Field k;
      private static Field l;
      final WindowInsets c;
      private androidx.core.graphics.a[] d;
      private androidx.core.graphics.a e;
      private v f;
      androidx.core.graphics.a g;

      g(v var1, WindowInsets var2) {
         super(var1);
         this.e = null;
         this.c = var2;
      }

      g(v var1, v.g var2) {
         this(var1, new WindowInsets(var2.c));
      }

      private androidx.core.graphics.a s(int var1, boolean var2) {
         androidx.core.graphics.a var3 = androidx.core.graphics.a.e;

         for(int var4 = 1; var4 <= 256; var4 <<= 1) {
            if ((var1 & var4) != 0) {
               var3 = androidx.core.graphics.a.a(var3, this.t(var4, var2));
            }
         }

         return var3;
      }

      private androidx.core.graphics.a u() {
         v var1 = this.f;
         return var1 != null ? var1.g() : androidx.core.graphics.a.e;
      }

      private androidx.core.graphics.a v(View var1) {
         if (VERSION.SDK_INT < 30) {
            if (!h) {
               w();
            }

            Method var2 = i;
            ReflectiveOperationException var3 = null;
            if (var2 != null && j != null && k != null) {
               ReflectiveOperationException var10000;
               label46: {
                  Object var8;
                  boolean var10001;
                  try {
                     var8 = var2.invoke(var1);
                  } catch (ReflectiveOperationException var7) {
                     var10000 = var7;
                     var10001 = false;
                     break label46;
                  }

                  if (var8 == null) {
                     try {
                        NullPointerException var9 = new NullPointerException();
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", var9);
                        return null;
                     } catch (ReflectiveOperationException var4) {
                        var10000 = var4;
                        var10001 = false;
                     }
                  } else {
                     label56: {
                        Rect var10;
                        try {
                           var8 = l.get(var8);
                           var10 = (Rect)k.get(var8);
                        } catch (ReflectiveOperationException var6) {
                           var10000 = var6;
                           var10001 = false;
                           break label56;
                        }

                        androidx.core.graphics.a var11 = var3;
                        if (var10 != null) {
                           try {
                              var11 = androidx.core.graphics.a.c(var10);
                           } catch (ReflectiveOperationException var5) {
                              var10000 = var5;
                              var10001 = false;
                              break label56;
                           }
                        }

                        return var11;
                     }
                  }
               }

               var3 = var10000;
               StringBuilder var12 = new StringBuilder();
               var12.append("Failed to get visible insets. (Reflection error). ");
               var12.append(var3.getMessage());
               Log.e("WindowInsetsCompat", var12.toString(), var3);
            }

            return null;
         } else {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
         }
      }

      private static void w() {
         try {
            i = View.class.getDeclaredMethod("getViewRootImpl");
            Class var3 = Class.forName("android.view.View$AttachInfo");
            j = var3;
            k = var3.getDeclaredField("mVisibleInsets");
            l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            k.setAccessible(true);
            l.setAccessible(true);
         } catch (ReflectiveOperationException var2) {
            StringBuilder var0 = new StringBuilder();
            var0.append("Failed to get visible insets. (Reflection error). ");
            var0.append(var2.getMessage());
            Log.e("WindowInsetsCompat", var0.toString(), var2);
         }

         h = true;
      }

      void d(View var1) {
         androidx.core.graphics.a var2 = this.v(var1);
         androidx.core.graphics.a var3 = var2;
         if (var2 == null) {
            var3 = androidx.core.graphics.a.e;
         }

         this.p(var3);
      }

      void e(v var1) {
         var1.j(this.f);
         var1.i(this.g);
      }

      public boolean equals(Object var1) {
         if (!super.equals(var1)) {
            return false;
         } else {
            v.g var2 = (v.g)var1;
            return Objects.equals(this.g, var2.g);
         }
      }

      public androidx.core.graphics.a g(int var1) {
         return this.s(var1, false);
      }

      final androidx.core.graphics.a k() {
         if (this.e == null) {
            this.e = androidx.core.graphics.a.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
         }

         return this.e;
      }

      boolean n() {
         return this.c.isRound();
      }

      public void o(androidx.core.graphics.a[] var1) {
         this.d = var1;
      }

      void p(androidx.core.graphics.a var1) {
         this.g = var1;
      }

      void q(v var1) {
         this.f = var1;
      }

      protected androidx.core.graphics.a t(int var1, boolean var2) {
         if (var1 != 1) {
            androidx.core.graphics.a var3 = null;
            androidx.core.graphics.a var4 = null;
            if (var1 != 2) {
               if (var1 != 8) {
                  if (var1 != 16) {
                     if (var1 != 32) {
                        if (var1 != 64) {
                           if (var1 != 128) {
                              return androidx.core.graphics.a.e;
                           } else {
                              v var8 = this.f;
                              androidx.core.view.a var9;
                              if (var8 != null) {
                                 var9 = var8.e();
                              } else {
                                 var9 = this.f();
                              }

                              return var9 != null ? androidx.core.graphics.a.b(var9.b(), var9.d(), var9.c(), var9.a()) : androidx.core.graphics.a.e;
                           }
                        } else {
                           return this.l();
                        }
                     } else {
                        return this.h();
                     }
                  } else {
                     return this.j();
                  }
               } else {
                  androidx.core.graphics.a[] var7 = this.d;
                  var3 = var4;
                  if (var7 != null) {
                     var3 = var7[v.m.d(8)];
                  }

                  if (var3 != null) {
                     return var3;
                  } else {
                     var4 = this.k();
                     var3 = this.u();
                     var1 = var4.d;
                     if (var1 > var3.d) {
                        return androidx.core.graphics.a.b(0, 0, 0, var1);
                     } else {
                        var4 = this.g;
                        if (var4 != null && !var4.equals(androidx.core.graphics.a.e)) {
                           var1 = this.g.d;
                           if (var1 > var3.d) {
                              return androidx.core.graphics.a.b(0, 0, 0, var1);
                           }
                        }

                        return androidx.core.graphics.a.e;
                     }
                  }
               }
            } else if (var2) {
               var4 = this.u();
               var3 = this.i();
               return androidx.core.graphics.a.b(Math.max(var4.a, var3.a), 0, Math.max(var4.c, var3.c), Math.max(var4.d, var3.d));
            } else {
               var4 = this.k();
               v var5 = this.f;
               if (var5 != null) {
                  var3 = var5.g();
               }

               int var6 = var4.d;
               var1 = var6;
               if (var3 != null) {
                  var1 = Math.min(var6, var3.d);
               }

               return androidx.core.graphics.a.b(var4.a, 0, var4.c, var1);
            }
         } else {
            return var2 ? androidx.core.graphics.a.b(0, Math.max(this.u().b, this.k().b), 0, 0) : androidx.core.graphics.a.b(0, this.k().b, 0, 0);
         }
      }
   }

   private static class h extends v.g {
      private androidx.core.graphics.a m = null;

      h(v var1, WindowInsets var2) {
         super(var1, var2);
      }

      h(v var1, v.h var2) {
         super(var1, (v.g)var2);
         this.m = var2.m;
      }

      v b() {
         return v.m(super.c.consumeStableInsets());
      }

      v c() {
         return v.m(super.c.consumeSystemWindowInsets());
      }

      final androidx.core.graphics.a i() {
         if (this.m == null) {
            this.m = androidx.core.graphics.a.b(super.c.getStableInsetLeft(), super.c.getStableInsetTop(), super.c.getStableInsetRight(), super.c.getStableInsetBottom());
         }

         return this.m;
      }

      boolean m() {
         return super.c.isConsumed();
      }

      public void r(androidx.core.graphics.a var1) {
         this.m = var1;
      }
   }

   private static class i extends v.h {
      i(v var1, WindowInsets var2) {
         super(var1, var2);
      }

      i(v var1, v.i var2) {
         super(var1, (v.h)var2);
      }

      v a() {
         return v.m(x.a(super.c));
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof v.i)) {
            return false;
         } else {
            v.i var3 = (v.i)var1;
            if (!Objects.equals(super.c, var3.c) || !Objects.equals(super.g, var3.g)) {
               var2 = false;
            }

            return var2;
         }
      }

      androidx.core.view.a f() {
         return androidx.core.view.a.e(w.a(super.c));
      }

      public int hashCode() {
         return super.c.hashCode();
      }
   }

   private static class j extends v.i {
      private androidx.core.graphics.a n = null;
      private androidx.core.graphics.a o = null;
      private androidx.core.graphics.a p = null;

      j(v var1, WindowInsets var2) {
         super(var1, var2);
      }

      j(v var1, v.j var2) {
         super(var1, (v.i)var2);
      }

      androidx.core.graphics.a h() {
         if (this.o == null) {
            this.o = androidx.core.graphics.a.d(a0.a(super.c));
         }

         return this.o;
      }

      androidx.core.graphics.a j() {
         if (this.n == null) {
            this.n = androidx.core.graphics.a.d(y.a(super.c));
         }

         return this.n;
      }

      androidx.core.graphics.a l() {
         if (this.p == null) {
            this.p = androidx.core.graphics.a.d(z.a(super.c));
         }

         return this.p;
      }

      public void r(androidx.core.graphics.a var1) {
      }
   }

   private static class k extends v.j {
      static final v q;

      static {
         q = v.m(WindowInsets.CONSUMED);
      }

      k(v var1, WindowInsets var2) {
         super(var1, var2);
      }

      k(v var1, v.k var2) {
         super(var1, (v.j)var2);
      }

      final void d(View var1) {
      }

      public androidx.core.graphics.a g(int var1) {
         return androidx.core.graphics.a.d(b0.a(super.c, v.n.a(var1)));
      }
   }

   private static class l {
      static final v b = (new v.b()).a().a().b().c();
      final v a;

      l(v var1) {
         this.a = var1;
      }

      v a() {
         return this.a;
      }

      v b() {
         return this.a;
      }

      v c() {
         return this.a;
      }

      void d(View var1) {
      }

      void e(v var1) {
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof v.l)) {
            return false;
         } else {
            v.l var3 = (v.l)var1;
            if (this.n() != var3.n() || this.m() != var3.m() || !h.b.a(this.k(), var3.k()) || !h.b.a(this.i(), var3.i()) || !h.b.a(this.f(), var3.f())) {
               var2 = false;
            }

            return var2;
         }
      }

      androidx.core.view.a f() {
         return null;
      }

      androidx.core.graphics.a g(int var1) {
         return androidx.core.graphics.a.e;
      }

      androidx.core.graphics.a h() {
         return this.k();
      }

      public int hashCode() {
         return h.b.b(this.n(), this.m(), this.k(), this.i(), this.f());
      }

      androidx.core.graphics.a i() {
         return androidx.core.graphics.a.e;
      }

      androidx.core.graphics.a j() {
         return this.k();
      }

      androidx.core.graphics.a k() {
         return androidx.core.graphics.a.e;
      }

      androidx.core.graphics.a l() {
         return this.k();
      }

      boolean m() {
         return false;
      }

      boolean n() {
         return false;
      }

      public void o(androidx.core.graphics.a[] var1) {
      }

      void p(androidx.core.graphics.a var1) {
      }

      void q(v var1) {
      }

      public void r(androidx.core.graphics.a var1) {
      }
   }

   public static final class m {
      public static int a() {
         return 4;
      }

      public static int b() {
         return 128;
      }

      public static int c() {
         return 8;
      }

      static int d(int var0) {
         if (var0 != 1) {
            if (var0 != 2) {
               if (var0 != 4) {
                  if (var0 != 8) {
                     if (var0 != 16) {
                        if (var0 != 32) {
                           if (var0 != 64) {
                              if (var0 != 128) {
                                 if (var0 == 256) {
                                    return 8;
                                 } else {
                                    StringBuilder var1 = new StringBuilder();
                                    var1.append("type needs to be >= FIRST and <= LAST, type=");
                                    var1.append(var0);
                                    throw new IllegalArgumentException(var1.toString());
                                 }
                              } else {
                                 return 7;
                              }
                           } else {
                              return 6;
                           }
                        } else {
                           return 5;
                        }
                     } else {
                        return 4;
                     }
                  } else {
                     return 3;
                  }
               } else {
                  return 2;
               }
            } else {
               return 1;
            }
         } else {
            return 0;
         }
      }

      public static int e() {
         return 32;
      }

      public static int f() {
         return 2;
      }

      public static int g() {
         return 1;
      }

      public static int h() {
         return 16;
      }

      public static int i() {
         return 64;
      }
   }

   private static final class n {
      static int a(int var0) {
         int var1 = 0;

         int var3;
         for(int var2 = 1; var2 <= 256; var1 = var3) {
            var3 = var1;
            if ((var0 & var2) != 0) {
               label47: {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        if (var2 != 4) {
                           if (var2 != 8) {
                              if (var2 != 16) {
                                 if (var2 != 32) {
                                    if (var2 != 64) {
                                       if (var2 != 128) {
                                          var3 = var1;
                                          break label47;
                                       }

                                       var3 = WindowInsets$Type.displayCutout();
                                    } else {
                                       var3 = WindowInsets$Type.tappableElement();
                                    }
                                 } else {
                                    var3 = WindowInsets$Type.mandatorySystemGestures();
                                 }
                              } else {
                                 var3 = WindowInsets$Type.systemGestures();
                              }
                           } else {
                              var3 = WindowInsets$Type.ime();
                           }
                        } else {
                           var3 = WindowInsets$Type.captionBar();
                        }
                     } else {
                        var3 = WindowInsets$Type.navigationBars();
                     }
                  } else {
                     var3 = WindowInsets$Type.statusBars();
                  }

                  var3 |= var1;
               }
            }

            var2 <<= 1;
         }

         return var1;
      }
   }
}
