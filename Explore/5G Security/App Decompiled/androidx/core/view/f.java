package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public class f {
   private static final int[] a;
   private static final androidx.core.view.c b;
   private static final androidx.core.view.f.b c;

   static {
      a = new int[]{f.a.a, f.a.b, f.a.m, f.a.x, f.a.A, f.a.B, f.a.C, f.a.D, f.a.E, f.a.F, f.a.c, f.a.d, f.a.e, f.a.f, f.a.g, f.a.h, f.a.i, f.a.j, f.a.k, f.a.l, f.a.n, f.a.o, f.a.p, f.a.q, f.a.r, f.a.s, f.a.t, f.a.u, f.a.v, f.a.w, f.a.y, f.a.z};
      b = new androidx.core.view.e();
      c = new androidx.core.view.f.b();
   }

   public static CharSequence a(View var0) {
      return (CharSequence)d().c(var0);
   }

   public static v b(View var0) {
      return VERSION.SDK_INT >= 23 ? androidx.core.view.f.f.a(var0) : androidx.core.view.f.e.j(var0);
   }

   static void c(View var0, int var1) {
      AccessibilityManager var2 = (AccessibilityManager)var0.getContext().getSystemService("accessibility");
      if (var2.isEnabled()) {
         boolean var3;
         if (a(var0) != null && var0.isShown() && var0.getWindowVisibility() == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         int var4 = var0.getAccessibilityLiveRegion();
         short var5 = 32;
         AccessibilityEvent var6;
         if (var4 == 0 && !var3) {
            if (var1 == 32) {
               var6 = AccessibilityEvent.obtain();
               var0.onInitializeAccessibilityEvent(var6);
               var6.setEventType(32);
               var6.setContentChangeTypes(var1);
               var6.setSource(var0);
               var0.onPopulateAccessibilityEvent(var6);
               var6.getText().add(a(var0));
               var2.sendAccessibilityEvent(var6);
            } else if (var0.getParent() != null) {
               ViewParent var9 = var0.getParent();

               try {
                  var9.notifySubtreeAccessibilityStateChanged(var0, var0, var1);
               } catch (AbstractMethodError var7) {
                  StringBuilder var8 = new StringBuilder();
                  var8.append(var0.getParent().getClass().getSimpleName());
                  var8.append(" does not fully implement ViewParent");
                  Log.e("ViewCompat", var8.toString(), var7);
               }
            }
         } else {
            var6 = AccessibilityEvent.obtain();
            if (!var3) {
               var5 = 2048;
            }

            var6.setEventType(var5);
            var6.setContentChangeTypes(var1);
            if (var3) {
               var6.getText().add(a(var0));
               f(var0);
            }

            var0.sendAccessibilityEventUnchecked(var6);
         }

      }
   }

   private static androidx.core.view.f.c<CharSequence> d() {
      return new androidx.core.view.f.c<CharSequence>(f.a.G, CharSequence.class, 8, 28) {
         CharSequence d(View var1) {
            return androidx.core.view.f.g.b(var1);
         }
      };
   }

   public static void e(View var0) {
      androidx.core.view.f.d.c(var0);
   }

   private static void f(View var0) {
      if (var0.getImportantForAccessibility() == 0) {
         var0.setImportantForAccessibility(1);
      }

   }

   static class b implements OnGlobalLayoutListener, OnAttachStateChangeListener {
      private final WeakHashMap<View, Boolean> a = new WeakHashMap();

      private void a(Entry<View, Boolean> var1) {
         View var2 = (View)var1.getKey();
         boolean var3 = (Boolean)var1.getValue();
         boolean var4;
         if (var2.isShown() && var2.getWindowVisibility() == 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         if (var3 != var4) {
            byte var5;
            if (var4) {
               var5 = 16;
            } else {
               var5 = 32;
            }

            androidx.core.view.f.c(var2, var5);
            var1.setValue(var4);
         }

      }

      private void b(View var1) {
         var1.getViewTreeObserver().addOnGlobalLayoutListener(this);
      }

      public void onGlobalLayout() {
         if (VERSION.SDK_INT < 28) {
            Iterator var1 = this.a.entrySet().iterator();

            while(var1.hasNext()) {
               this.a((Entry)var1.next());
            }
         }

      }

      public void onViewAttachedToWindow(View var1) {
         this.b(var1);
      }

      public void onViewDetachedFromWindow(View var1) {
      }
   }

   abstract static class c<T> {
      private final int a;
      private final Class<T> b;
      private final int c;
      private final int d;

      c(int var1, Class<T> var2, int var3, int var4) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
         this.c = var4;
      }

      private boolean a() {
         boolean var1;
         if (VERSION.SDK_INT >= this.c) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      abstract T b(View var1);

      T c(View var1) {
         if (this.a()) {
            return this.b(var1);
         } else {
            Object var2 = var1.getTag(this.a);
            return this.b.isInstance(var2) ? var2 : null;
         }
      }
   }

   static class d {
      static WindowInsets a(View var0, WindowInsets var1) {
         return var0.dispatchApplyWindowInsets(var1);
      }

      static WindowInsets b(View var0, WindowInsets var1) {
         return var0.onApplyWindowInsets(var1);
      }

      static void c(View var0) {
         var0.requestApplyInsets();
      }
   }

   private static class e {
      static void a(WindowInsets var0, View var1) {
         OnApplyWindowInsetsListener var2 = (OnApplyWindowInsetsListener)var1.getTag(f.a.J);
         if (var2 != null) {
            var2.onApplyWindowInsets(var1, var0);
         }

      }

      static v b(View var0, v var1, Rect var2) {
         WindowInsets var3 = var1.l();
         if (var3 != null) {
            return v.n(var0.computeSystemWindowInsets(var3, var2), var0);
         } else {
            var2.setEmpty();
            return var1;
         }
      }

      static boolean c(View var0, float var1, float var2, boolean var3) {
         return var0.dispatchNestedFling(var1, var2, var3);
      }

      static boolean d(View var0, float var1, float var2) {
         return var0.dispatchNestedPreFling(var1, var2);
      }

      static boolean e(View var0, int var1, int var2, int[] var3, int[] var4) {
         return var0.dispatchNestedPreScroll(var1, var2, var3, var4);
      }

      static boolean f(View var0, int var1, int var2, int var3, int var4, int[] var5) {
         return var0.dispatchNestedScroll(var1, var2, var3, var4, var5);
      }

      static ColorStateList g(View var0) {
         return var0.getBackgroundTintList();
      }

      static Mode h(View var0) {
         return var0.getBackgroundTintMode();
      }

      static float i(View var0) {
         return var0.getElevation();
      }

      public static v j(View var0) {
         return v.a.a(var0);
      }

      static String k(View var0) {
         return var0.getTransitionName();
      }

      static float l(View var0) {
         return var0.getTranslationZ();
      }

      static float m(View var0) {
         return var0.getZ();
      }

      static boolean n(View var0) {
         return var0.hasNestedScrollingParent();
      }

      static boolean o(View var0) {
         return var0.isImportantForAccessibility();
      }

      static boolean p(View var0) {
         return var0.isNestedScrollingEnabled();
      }

      static void q(View var0, ColorStateList var1) {
         var0.setBackgroundTintList(var1);
      }

      static void r(View var0, Mode var1) {
         var0.setBackgroundTintMode(var1);
      }

      static void s(View var0, float var1) {
         var0.setElevation(var1);
      }

      static void t(View var0, boolean var1) {
         var0.setNestedScrollingEnabled(var1);
      }

      static void u(View var0, androidx.core.view.b var1) {
         if (VERSION.SDK_INT < 30) {
            var0.setTag(f.a.H, var1);
         }

         if (var1 == null) {
            var0.setOnApplyWindowInsetsListener((OnApplyWindowInsetsListener)var0.getTag(f.a.J));
         } else {
            var0.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(var1) {
               v a;
               // $FF: synthetic field
               final View b;
               // $FF: synthetic field
               final androidx.core.view.b c;

               {
                  this.b = var1;
                  this.c = var2;
                  this.a = null;
               }

               public WindowInsets onApplyWindowInsets(View var1, WindowInsets var2) {
                  v var3 = v.n(var2, var1);
                  int var4 = VERSION.SDK_INT;
                  if (var4 < 30) {
                     androidx.core.view.f.e.a(var2, this.b);
                     if (var3.equals(this.a)) {
                        return this.c.a(var1, var3).l();
                     }
                  }

                  this.a = var3;
                  v var5 = this.c.a(var1, var3);
                  if (var4 >= 30) {
                     return var5.l();
                  } else {
                     androidx.core.view.f.e(var1);
                     return var5.l();
                  }
               }
            });
         }
      }

      static void v(View var0, String var1) {
         var0.setTransitionName(var1);
      }

      static void w(View var0, float var1) {
         var0.setTranslationZ(var1);
      }

      static void x(View var0, float var1) {
         var0.setZ(var1);
      }

      static boolean y(View var0, int var1) {
         return var0.startNestedScroll(var1);
      }

      static void z(View var0) {
         var0.stopNestedScroll();
      }
   }

   private static class f {
      public static v a(View var0) {
         WindowInsets var1 = androidx.core.view.h.a(var0);
         if (var1 == null) {
            return null;
         } else {
            v var2 = v.m(var1);
            var2.j(var2);
            var2.d(var0.getRootView());
            return var2;
         }
      }

      static int b(View var0) {
         return j.a(var0);
      }

      static void c(View var0, int var1) {
         androidx.core.view.g.a(var0, var1);
      }

      static void d(View var0, int var1, int var2) {
         i.a(var0, var1, var2);
      }
   }

   static class g {
      static void a(View var0, androidx.core.view.f.h var1) {
         int var2 = f.a.I;
         e.d var3 = (e.d)var0.getTag(var2);
         e.d var4 = var3;
         if (var3 == null) {
            var4 = new e.d();
            var0.setTag(var2, var4);
         }

         Objects.requireNonNull(var1);
         u var5 = new u(var1);
         var4.put(var1, var5);
         m.a(var0, var5);
      }

      static CharSequence b(View var0) {
         return t.a(var0);
      }

      static boolean c(View var0) {
         return n.a(var0);
      }

      static boolean d(View var0) {
         return k.a(var0);
      }

      static void e(View var0, androidx.core.view.f.h var1) {
         e.d var2 = (e.d)var0.getTag(f.a.I);
         if (var2 != null) {
            View$OnUnhandledKeyEventListener var3 = (View$OnUnhandledKeyEventListener)var2.get(var1);
            if (var3 != null) {
               q.a(var0, var3);
            }

         }
      }

      static <T> T f(View var0, int var1) {
         return s.a(var0, var1);
      }

      static void g(View var0, boolean var1) {
         o.a(var0, var1);
      }

      static void h(View var0, CharSequence var1) {
         p.a(var0, var1);
      }

      public static void i(View var0, i.a var1) {
         r.a(var0, (AutofillId)null);
      }

      static void j(View var0, boolean var1) {
         l.a(var0, var1);
      }
   }

   public interface h {
      boolean onUnhandledKeyEvent(View var1, KeyEvent var2);
   }
}
