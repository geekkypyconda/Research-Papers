package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowInsets$Type;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class t extends FrameLayout implements m0.b.c, b0.e {
   private m a;
   private n b;
   private l c;
   io.flutter.embedding.engine.renderer.e d;
   private io.flutter.embedding.engine.renderer.e e;
   private final Set<io.flutter.embedding.engine.renderer.d> f;
   private boolean g;
   private io.flutter.embedding.engine.a h;
   private final Set<t.f> i;
   private m0.b j;
   private io.flutter.plugin.editing.m k;
   private io.flutter.plugin.editing.f l;
   private l0.c m;
   private b0 n;
   private c o;
   private io.flutter.view.h p;
   private TextServicesManager q;
   private g0 r;
   private final FlutterRenderer.h s;
   private final io.flutter.view.h.k t;
   private final ContentObserver u;
   private final io.flutter.embedding.engine.renderer.d v;
   private final h.a<r.j> w;

   private t(Context var1, AttributeSet var2, m var3) {
      super(var1, var2);
      this.f = new HashSet();
      this.i = new HashSet();
      this.s = new FlutterRenderer.h();
      this.t = new io.flutter.view.h.k() {
         public void a(boolean var1, boolean var2) {
            t.this.z(var1, var2);
         }
      };
      this.u = new ContentObserver(new Handler(Looper.getMainLooper())) {
         public boolean deliverSelfNotifications() {
            return true;
         }

         public void onChange(boolean var1) {
            super.onChange(var1);
            if (t.this.h != null) {
               y.b.f("FlutterView", "System settings changed. Sending user settings to Flutter.");
               t.this.B();
            }
         }
      };
      this.v = new io.flutter.embedding.engine.renderer.d() {
         public void d() {
            t.this.g = false;
            Iterator var1 = t.this.f.iterator();

            while(var1.hasNext()) {
               ((io.flutter.embedding.engine.renderer.d)var1.next()).d();
            }

         }

         public void g() {
            t.this.g = true;
            Iterator var1 = t.this.f.iterator();

            while(var1.hasNext()) {
               ((io.flutter.embedding.engine.renderer.d)var1.next()).g();
            }

         }
      };
      this.w = new h.a<r.j>() {
         public void a(r.j var1) {
            t.this.setWindowInfoListenerDisplayFeatures(var1);
         }
      };
      this.a = var3;
      this.d = var3;
      this.u();
   }

   private t(Context var1, AttributeSet var2, n var3) {
      super(var1, var2);
      this.f = new HashSet();
      this.i = new HashSet();
      this.s = new FlutterRenderer.h();
      this.t = new io.flutter.view.h.k() {
         public void a(boolean var1, boolean var2) {
            t.this.z(var1, var2);
         }
      };
      this.u = new ContentObserver(new Handler(Looper.getMainLooper())) {
         public boolean deliverSelfNotifications() {
            return true;
         }

         public void onChange(boolean var1) {
            super.onChange(var1);
            if (t.this.h != null) {
               y.b.f("FlutterView", "System settings changed. Sending user settings to Flutter.");
               t.this.B();
            }
         }
      };
      this.v = new io.flutter.embedding.engine.renderer.d() {
         public void d() {
            t.this.g = false;
            Iterator var1 = t.this.f.iterator();

            while(var1.hasNext()) {
               ((io.flutter.embedding.engine.renderer.d)var1.next()).d();
            }

         }

         public void g() {
            t.this.g = true;
            Iterator var1 = t.this.f.iterator();

            while(var1.hasNext()) {
               ((io.flutter.embedding.engine.renderer.d)var1.next()).g();
            }

         }
      };
      this.w = new h.a<r.j>() {
         public void a(r.j var1) {
            t.this.setWindowInfoListenerDisplayFeatures(var1);
         }
      };
      this.b = var3;
      this.d = var3;
      this.u();
   }

   public t(Context var1, m var2) {
      this(var1, (AttributeSet)null, (m)var2);
   }

   public t(Context var1, n var2) {
      this(var1, (AttributeSet)null, (n)var2);
   }

   private void C() {
      if (!this.v()) {
         y.b.g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
      } else {
         this.s.a = this.getResources().getDisplayMetrics().density;
         this.s.p = ViewConfiguration.get(this.getContext()).getScaledTouchSlop();
         this.h.s().y(this.s);
      }
   }

   // $FF: synthetic method
   public static boolean d(SpellCheckerInfo var0) {
      return w(var0);
   }

   private t.g o() {
      Context var1 = this.getContext();
      int var2 = var1.getResources().getConfiguration().orientation;
      int var3 = ((WindowManager)var1.getSystemService("window")).getDefaultDisplay().getRotation();
      if (var2 == 2) {
         if (var3 == 1) {
            return t.g.g;
         }

         if (var3 == 3) {
            t.g var4;
            if (VERSION.SDK_INT >= 23) {
               var4 = t.g.f;
            } else {
               var4 = t.g.g;
            }

            return var4;
         }

         if (var3 == 0 || var3 == 2) {
            return t.g.h;
         }
      }

      return t.g.e;
   }

   private int t(WindowInsets var1) {
      int var2 = this.getRootView().getHeight();
      return (double)var1.getSystemWindowInsetBottom() < (double)var2 * 0.18D ? 0 : var1.getSystemWindowInsetBottom();
   }

   private void u() {
      y.b.f("FlutterView", "Initializing FlutterView");
      Object var1;
      if (this.a != null) {
         y.b.f("FlutterView", "Internally using a FlutterSurfaceView.");
         var1 = this.a;
      } else if (this.b != null) {
         y.b.f("FlutterView", "Internally using a FlutterTextureView.");
         var1 = this.b;
      } else {
         y.b.f("FlutterView", "Internally using a FlutterImageView.");
         var1 = this.c;
      }

      this.addView((View)var1);
      this.setFocusable(true);
      this.setFocusableInTouchMode(true);
      if (VERSION.SDK_INT >= 26) {
         this.setImportantForAutofill(1);
      }

   }

   // $FF: synthetic method
   private static boolean w(SpellCheckerInfo var0) {
      return var0.getPackageName().equals("com.google.android.inputmethod.latin");
   }

   private void x() {
      l var1 = this.c;
      if (var1 != null) {
         var1.g();
         this.removeView(this.c);
         this.c = null;
      }

   }

   private void z(boolean var1, boolean var2) {
      boolean var3 = this.h.s().o();
      boolean var4 = false;
      boolean var5 = var4;
      if (!var3) {
         var5 = var4;
         if (!var1) {
            var5 = var4;
            if (!var2) {
               var5 = true;
            }
         }
      }

      this.setWillNotDraw(var5);
   }

   public void A(final Runnable var1) {
      if (this.c == null) {
         y.b.f("FlutterView", "Tried to revert the image view, but no image view is used.");
      } else {
         io.flutter.embedding.engine.renderer.e var2 = this.e;
         if (var2 == null) {
            y.b.f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
         } else {
            this.d = var2;
            this.e = null;
            final FlutterRenderer var3 = this.h.s();
            if (this.h != null && var3 != null) {
               this.d.d();
               var3.j(new io.flutter.embedding.engine.renderer.d() {
                  public void d() {
                  }

                  public void g() {
                     var3.u(this);
                     var1.run();
                     t var1x = t.this;
                     if (!(var1x.d instanceof l) && var1x.c != null) {
                        t.this.c.c();
                        t.this.x();
                     }

                  }
               });
            } else {
               this.c.c();
               this.x();
               var1.run();
            }
         }
      }
   }

   void B() {
      int var1 = this.getResources().getConfiguration().uiMode;
      boolean var2 = false;
      boolean var6;
      if ((var1 & 48) == 32) {
         var6 = true;
      } else {
         var6 = false;
      }

      j0.p.c var3;
      if (var6) {
         var3 = j0.p.c.g;
      } else {
         var3 = j0.p.c.f;
      }

      boolean var5;
      label32: {
         label31: {
            TextServicesManager var4 = this.q;
            if (var4 != null) {
               if (VERSION.SDK_INT < 31) {
                  break label31;
               }

               var5 = io.flutter.embedding.android.q.a(io.flutter.embedding.android.p.a(var4)).anyMatch(new s());
               if (io.flutter.embedding.android.r.a(this.q) && var5) {
                  break label31;
               }
            }

            var5 = false;
            break label32;
         }

         var5 = true;
      }

      j0.p.b var7 = this.h.u().d().f(this.getResources().getConfiguration().fontScale).c(this.getResources().getDisplayMetrics()).d(var5);
      var5 = var2;
      if (System.getInt(this.getContext().getContentResolver(), "show_password", 1) == 1) {
         var5 = true;
      }

      var7.b(var5).g(DateFormat.is24HourFormat(this.getContext())).e(var3).a();
   }

   public void a(KeyEvent var1) {
      this.getRootView().dispatchKeyEvent(var1);
   }

   public void autofill(SparseArray<AutofillValue> var1) {
      this.k.j(var1);
   }

   public boolean b(KeyEvent var1) {
      return this.k.q(var1);
   }

   public PointerIcon c(int var1) {
      return PointerIcon.getSystemIcon(this.getContext(), var1);
   }

   public boolean checkInputConnectionProxy(View var1) {
      io.flutter.embedding.engine.a var2 = this.h;
      boolean var3;
      if (var2 != null) {
         var3 = var2.q().G(var1);
      } else {
         var3 = super.checkInputConnectionProxy(var1);
      }

      return var3;
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      int var2 = var1.getAction();
      boolean var3 = true;
      if (var2 == 0 && var1.getRepeatCount() == 0) {
         this.getKeyDispatcherState().startTracking(var1, this);
      } else if (var1.getAction() == 1) {
         this.getKeyDispatcherState().handleUpEvent(var1);
      }

      boolean var4;
      if (this.v()) {
         var4 = var3;
         if (this.n.b(var1)) {
            return var4;
         }
      }

      if (super.dispatchKeyEvent(var1)) {
         var4 = var3;
      } else {
         var4 = false;
      }

      return var4;
   }

   public AccessibilityNodeProvider getAccessibilityNodeProvider() {
      io.flutter.view.h var1 = this.p;
      return var1 != null && var1.C() ? this.p : null;
   }

   public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
      return this.h;
   }

   public k0.b getBinaryMessenger() {
      return this.h.k();
   }

   public l getCurrentImageSurface() {
      return this.c;
   }

   public boolean k() {
      l var1 = this.c;
      return var1 != null ? var1.e() : false;
   }

   public void l(io.flutter.embedding.engine.renderer.d var1) {
      this.f.add(var1);
   }

   public void m(l var1) {
      io.flutter.embedding.engine.a var2 = this.h;
      if (var2 != null) {
         var1.a(var2.s());
      }

   }

   public void n(io.flutter.embedding.engine.a var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Attaching to a FlutterEngine: ");
      var2.append(var1);
      y.b.f("FlutterView", var2.toString());
      if (this.v()) {
         if (var1 == this.h) {
            y.b.f("FlutterView", "Already attached to this engine. Doing nothing.");
            return;
         }

         y.b.f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
         this.s();
      }

      this.h = var1;
      FlutterRenderer var5 = var1.s();
      this.g = var5.n();
      this.d.a(var5);
      var5.j(this.v);
      if (VERSION.SDK_INT >= 24) {
         this.j = new m0.b(this, this.h.n());
      }

      this.k = new io.flutter.plugin.editing.m(this, this.h.x(), this.h.q());

      try {
         TextServicesManager var3 = (TextServicesManager)this.getContext().getSystemService("textservices");
         this.q = var3;
         io.flutter.plugin.editing.f var6 = new io.flutter.plugin.editing.f(var3, this.h.v());
         this.l = var6;
      } catch (Exception var4) {
         y.b.b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
      }

      this.m = this.h.m();
      this.n = new b0(this);
      this.o = new c(this.h.s(), false);
      io.flutter.view.h var7 = new io.flutter.view.h(this, var1.h(), (AccessibilityManager)this.getContext().getSystemService("accessibility"), this.getContext().getContentResolver(), this.h.q());
      this.p = var7;
      var7.a0(this.t);
      this.z(this.p.C(), this.p.E());
      this.h.q().b(this.p);
      this.h.q().E(this.h.s());
      this.k.p().restartInput(this);
      this.B();
      this.getContext().getContentResolver().registerContentObserver(System.getUriFor("show_password"), false, this.u);
      this.C();
      var1.q().F(this);
      Iterator var8 = this.i.iterator();

      while(var8.hasNext()) {
         ((t.f)var8.next()).a(var1);
      }

      if (this.g) {
         this.v.g();
      }

   }

   public final WindowInsets onApplyWindowInsets(WindowInsets var1) {
      WindowInsets var2 = super.onApplyWindowInsets(var1);
      int var3 = VERSION.SDK_INT;
      Insets var4;
      FlutterRenderer.h var5;
      if (var3 == 29) {
         var4 = androidx.core.view.y.a(var1);
         var5 = this.s;
         var5.l = var4.top;
         var5.m = var4.right;
         var5.n = var4.bottom;
         var5.o = var4.left;
      }

      int var6 = this.getWindowSystemUiVisibility();
      boolean var7 = true;
      int var8 = 0;
      boolean var13;
      if ((var6 & 4) == 0) {
         var13 = true;
      } else {
         var13 = false;
      }

      if ((this.getWindowSystemUiVisibility() & 2) != 0) {
         var7 = false;
      }

      FlutterRenderer.h var11;
      if (var3 >= 30) {
         if (var7) {
            var8 = 0 | WindowInsets$Type.navigationBars();
         }

         int var15 = var8;
         if (var13) {
            var15 = var8 | WindowInsets$Type.statusBars();
         }

         Insets var12 = androidx.core.view.b0.a(var1, var15);
         var11 = this.s;
         var11.d = var12.top;
         var11.e = var12.right;
         var11.f = var12.bottom;
         var11.g = var12.left;
         var4 = androidx.core.view.b0.a(var1, WindowInsets$Type.ime());
         var5 = this.s;
         var5.h = var4.top;
         var5.i = var4.right;
         var5.j = var4.bottom;
         var5.k = var4.left;
         var12 = androidx.core.view.b0.a(var1, WindowInsets$Type.systemGestures());
         var11 = this.s;
         var11.l = var12.top;
         var11.m = var12.right;
         var11.n = var12.bottom;
         var11.o = var12.left;
         DisplayCutout var9 = androidx.core.view.w.a(var1);
         if (var9 != null) {
            var12 = io.flutter.embedding.android.o.a(var9);
            var11 = this.s;
            var11.d = Math.max(Math.max(var11.d, var12.top), var9.getSafeInsetTop());
            var11 = this.s;
            var11.e = Math.max(Math.max(var11.e, var12.right), var9.getSafeInsetRight());
            var11 = this.s;
            var11.f = Math.max(Math.max(var11.f, var12.bottom), var9.getSafeInsetBottom());
            var11 = this.s;
            var11.g = Math.max(Math.max(var11.g, var12.left), var9.getSafeInsetLeft());
         }
      } else {
         t.g var14 = t.g.e;
         if (!var7) {
            var14 = this.o();
         }

         var11 = this.s;
         if (var13) {
            var8 = var1.getSystemWindowInsetTop();
         } else {
            var8 = 0;
         }

         var11.d = var8;
         var11 = this.s;
         if (var14 != t.g.g && var14 != t.g.h) {
            var8 = var1.getSystemWindowInsetRight();
         } else {
            var8 = 0;
         }

         var11.e = var8;
         var11 = this.s;
         if (var7 && this.t(var1) == 0) {
            var8 = var1.getSystemWindowInsetBottom();
         } else {
            var8 = 0;
         }

         var11.f = var8;
         var11 = this.s;
         if (var14 != t.g.f && var14 != t.g.h) {
            var8 = var1.getSystemWindowInsetLeft();
         } else {
            var8 = 0;
         }

         var11.g = var8;
         var5 = this.s;
         var5.h = 0;
         var5.i = 0;
         var5.j = this.t(var1);
         this.s.k = 0;
      }

      StringBuilder var10 = new StringBuilder();
      var10.append("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ");
      var10.append(this.s.d);
      var10.append(", Left: ");
      var10.append(this.s.g);
      var10.append(", Right: ");
      var10.append(this.s.e);
      var10.append("\nKeyboard insets: Bottom: ");
      var10.append(this.s.j);
      var10.append(", Left: ");
      var10.append(this.s.k);
      var10.append(", Right: ");
      var10.append(this.s.i);
      var10.append("System Gesture Insets - Left: ");
      var10.append(this.s.o);
      var10.append(", Top: ");
      var10.append(this.s.l);
      var10.append(", Right: ");
      var10.append(this.s.m);
      var10.append(", Bottom: ");
      var10.append(this.s.j);
      y.b.f("FlutterView", var10.toString());
      this.C();
      return var2;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.r = this.r();
      Activity var1 = o0.i.e(this.getContext());
      g0 var2 = this.r;
      if (var2 != null && var1 != null) {
         var2.a(var1, androidx.core.content.b.a(this.getContext()), this.w);
      }

   }

   protected void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      if (this.h != null) {
         y.b.f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
         this.m.d(var1);
         this.B();
         o0.i.c(this.getContext(), this.h);
      }

   }

   public InputConnection onCreateInputConnection(EditorInfo var1) {
      return !this.v() ? super.onCreateInputConnection(var1) : this.k.n(this, this.n, var1);
   }

   protected void onDetachedFromWindow() {
      g0 var1 = this.r;
      if (var1 != null) {
         var1.b(this.w);
      }

      this.r = null;
      super.onDetachedFromWindow();
   }

   public boolean onGenericMotionEvent(MotionEvent var1) {
      boolean var2 = this.v();
      boolean var3 = true;
      boolean var4;
      if (var2 && this.o.j(var1, this.getContext())) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (!var4) {
         var3 = super.onGenericMotionEvent(var1);
      }

      return var3;
   }

   public boolean onHoverEvent(MotionEvent var1) {
      return !this.v() ? super.onHoverEvent(var1) : this.p.L(var1);
   }

   public void onProvideAutofillVirtualStructure(ViewStructure var1, int var2) {
      super.onProvideAutofillVirtualStructure(var1, var2);
      this.k.y(var1, var2);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      StringBuilder var5 = new StringBuilder();
      var5.append("Size changed. Sending Flutter new viewport metrics. FlutterView was ");
      var5.append(var3);
      var5.append(" x ");
      var5.append(var4);
      var5.append(", it is now ");
      var5.append(var1);
      var5.append(" x ");
      var5.append(var2);
      y.b.f("FlutterView", var5.toString());
      FlutterRenderer.h var6 = this.s;
      var6.b = var1;
      var6.c = var2;
      this.C();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if (!this.v()) {
         return super.onTouchEvent(var1);
      } else {
         this.requestUnbufferedDispatch(var1);
         return this.o.k(var1);
      }
   }

   public void p() {
      this.d.b();
      l var1 = this.c;
      if (var1 == null) {
         var1 = this.q();
         this.c = var1;
         this.addView(var1);
      } else {
         var1.k(this.getWidth(), this.getHeight());
      }

      this.e = this.d;
      var1 = this.c;
      this.d = var1;
      io.flutter.embedding.engine.a var2 = this.h;
      if (var2 != null) {
         var1.a(var2.s());
      }

   }

   public l q() {
      return new l(this.getContext(), this.getWidth(), this.getHeight(), l.b.e);
   }

   protected g0 r() {
      try {
         q.a var1 = new q.a(r.f.a.d(this.getContext()));
         g0 var3 = new g0(var1);
         return var3;
      } catch (NoClassDefFoundError var2) {
         return null;
      }
   }

   public void s() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Detaching from a FlutterEngine: ");
      var1.append(this.h);
      y.b.f("FlutterView", var1.toString());
      if (!this.v()) {
         y.b.f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
      } else {
         Iterator var2 = this.i.iterator();

         while(var2.hasNext()) {
            ((t.f)var2.next()).b();
         }

         this.getContext().getContentResolver().unregisterContentObserver(this.u);
         this.h.q().P();
         this.h.q().a();
         this.p.S();
         this.p = null;
         this.k.p().restartInput(this);
         this.k.o();
         this.n.d();
         io.flutter.plugin.editing.f var3 = this.l;
         if (var3 != null) {
            var3.b();
         }

         m0.b var4 = this.j;
         if (var4 != null) {
            var4.c();
         }

         FlutterRenderer var5 = this.h.s();
         this.g = false;
         var5.u(this.v);
         var5.A();
         var5.x(false);
         io.flutter.embedding.engine.renderer.e var6 = this.e;
         if (var6 != null && this.d == this.c) {
            this.d = var6;
         }

         this.d.c();
         this.x();
         this.e = null;
         this.h = null;
      }
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      io.flutter.embedding.engine.renderer.e var2 = this.d;
      if (var2 instanceof m) {
         ((m)var2).setVisibility(var1);
      }

   }

   protected void setWindowInfoListenerDisplayFeatures(r.j var1) {
      List var6 = var1.a();
      ArrayList var2 = new ArrayList();
      Iterator var3 = var6.iterator();

      StringBuilder var7;
      while(var3.hasNext()) {
         r.a var4 = (r.a)var3.next();
         var7 = new StringBuilder();
         var7.append("WindowInfoTracker Display Feature reported with bounds = ");
         var7.append(var4.getBounds().toString());
         var7.append(" and type = ");
         var7.append(var4.getClass().getSimpleName());
         y.b.f("FlutterView", var7.toString());
         if (var4 instanceof r.c) {
            r.c var8 = (r.c)var4;
            FlutterRenderer.e var5;
            if (var8.b() == r.c.a.d) {
               var5 = FlutterRenderer.e.h;
            } else {
               var5 = FlutterRenderer.e.g;
            }

            FlutterRenderer.d var9;
            if (var8.a() == r.c.b.c) {
               var9 = FlutterRenderer.d.g;
            } else if (var8.a() == r.c.b.d) {
               var9 = FlutterRenderer.d.h;
            } else {
               var9 = FlutterRenderer.d.f;
            }

            var2.add(new FlutterRenderer.c(var4.getBounds(), var5, var9));
         } else {
            var2.add(new FlutterRenderer.c(var4.getBounds(), FlutterRenderer.e.f, FlutterRenderer.d.f));
         }
      }

      if (VERSION.SDK_INT >= 28) {
         WindowInsets var11 = this.getRootWindowInsets();
         if (var11 != null) {
            DisplayCutout var12 = androidx.core.view.w.a(var11);
            if (var12 != null) {
               Iterator var13 = var12.getBoundingRects().iterator();

               while(var13.hasNext()) {
                  Rect var10 = (Rect)var13.next();
                  var7 = new StringBuilder();
                  var7.append("DisplayCutout area reported with bounds = ");
                  var7.append(var10.toString());
                  y.b.f("FlutterView", var7.toString());
                  var2.add(new FlutterRenderer.c(var10, FlutterRenderer.e.i));
               }
            }
         }
      }

      this.s.q = var2;
      this.C();
   }

   public boolean v() {
      io.flutter.embedding.engine.a var1 = this.h;
      boolean var2;
      if (var1 != null && var1.s() == this.d.getAttachedRenderer()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void y(io.flutter.embedding.engine.renderer.d var1) {
      this.f.remove(var1);
   }

   public interface f {
      void a(io.flutter.embedding.engine.a var1);

      void b();
   }

   private static enum g {
      e,
      f,
      g,
      h;

      // $FF: synthetic method
      private static t.g[] a() {
         return new t.g[]{e, f, g, h};
      }
   }
}
