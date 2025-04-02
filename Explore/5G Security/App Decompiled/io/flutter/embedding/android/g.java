package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.window.BackEvent;
import java.util.Arrays;
import java.util.List;

class g implements d<Activity> {
   private g.c a;
   private io.flutter.embedding.engine.a b;
   t c;
   private io.flutter.plugin.platform.g d;
   OnPreDrawListener e;
   private boolean f;
   private boolean g;
   private boolean h;
   private boolean i;
   private Integer j;
   private io.flutter.embedding.engine.d k;
   private final io.flutter.embedding.engine.renderer.d l;

   g(g.c var1) {
      this(var1, (io.flutter.embedding.engine.d)null);
   }

   g(g.c var1, io.flutter.embedding.engine.d var2) {
      this.l = new io.flutter.embedding.engine.renderer.d() {
         public void d() {
            g.this.a.d();
            g.this.g = false;
         }

         public void g() {
            g.this.a.g();
            g.this.g = true;
            g.this.h = true;
         }
      };
      this.a = var1;
      this.h = false;
      this.k = var2;
   }

   private io.flutter.embedding.engine.d.b e(io.flutter.embedding.engine.d.b var1) {
      String var2;
      String var3;
      label17: {
         var2 = this.a.z();
         if (var2 != null) {
            var3 = var2;
            if (!var2.isEmpty()) {
               break label17;
            }
         }

         var3 = y.a.e().c().g();
      }

      z.a.b var4 = new z.a.b(var3, this.a.u());
      var2 = this.a.j();
      var3 = var2;
      if (var2 == null) {
         var2 = this.q(this.a.e().getIntent());
         var3 = var2;
         if (var2 == null) {
            var3 = "/";
         }
      }

      return var1.i(var4).k(var3).j(this.a.m());
   }

   private void j(final t var1) {
      if (this.a.o() == e0.e) {
         if (this.e != null) {
            var1.getViewTreeObserver().removeOnPreDrawListener(this.e);
         }

         this.e = new OnPreDrawListener() {
            public boolean onPreDraw() {
               if (g.this.g && g.this.e != null) {
                  var1.getViewTreeObserver().removeOnPreDrawListener(this);
                  g.this.e = null;
               }

               return g.this.g;
            }
         };
         var1.getViewTreeObserver().addOnPreDrawListener(this.e);
      } else {
         throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
      }
   }

   private void k() {
      if (this.a.s() == null) {
         if (!this.b.k().h()) {
            String var1 = this.a.j();
            String var2 = var1;
            if (var1 == null) {
               var1 = this.q(this.a.e().getIntent());
               var2 = var1;
               if (var1 == null) {
                  var2 = "/";
               }
            }

            String var3 = this.a.w();
            StringBuilder var4 = new StringBuilder();
            var4.append("Executing Dart entrypoint: ");
            var4.append(this.a.u());
            var4.append(", library uri: ");
            var4.append(var3);
            if (var4.toString() == null) {
               var1 = "\"\"";
            } else {
               var4 = new StringBuilder();
               var4.append(var3);
               var4.append(", and sending initial route: ");
               var4.append(var2);
               var1 = var4.toString();
            }

            label29: {
               y.b.f("FlutterActivityAndFragmentDelegate", var1);
               this.b.o().c(var2);
               var1 = this.a.z();
               if (var1 != null) {
                  var2 = var1;
                  if (!var1.isEmpty()) {
                     break label29;
                  }
               }

               var2 = y.a.e().c().g();
            }

            z.a.b var5;
            if (var3 == null) {
               var5 = new z.a.b(var2, this.a.u());
            } else {
               var5 = new z.a.b(var2, var3, this.a.u());
            }

            this.b.k().g(var5, this.a.m());
         }
      }
   }

   private void l() {
      if (this.a == null) {
         throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      }
   }

   private String q(Intent var1) {
      if (this.a.B()) {
         Uri var2 = var1.getData();
         if (var2 != null) {
            return var2.toString();
         }
      }

      return null;
   }

   void A(int var1, String[] var2, int[] var3) {
      this.l();
      if (this.b != null) {
         StringBuilder var4 = new StringBuilder();
         var4.append("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ");
         var4.append(var1);
         var4.append("\npermissions: ");
         var4.append(Arrays.toString(var2));
         var4.append("\ngrantResults: ");
         var4.append(Arrays.toString(var3));
         y.b.f("FlutterActivityAndFragmentDelegate", var4.toString());
         this.b.i().d(var1, var2, var3);
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
      }

   }

   void B(Bundle var1) {
      y.b.f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
      this.l();
      Object var2 = null;
      Bundle var3;
      byte[] var4;
      if (var1 != null) {
         var3 = var1.getBundle("plugins");
         var4 = var1.getByteArray("framework");
      } else {
         var3 = null;
         var4 = (byte[])var2;
      }

      if (this.a.t()) {
         this.b.t().j(var4);
      }

      if (this.a.n()) {
         this.b.i().c(var3);
      }

   }

   void C() {
      y.b.f("FlutterActivityAndFragmentDelegate", "onResume()");
      this.l();
      if (this.a.r()) {
         io.flutter.embedding.engine.a var1 = this.b;
         if (var1 != null) {
            var1.l().e();
         }
      }

   }

   void D(Bundle var1) {
      y.b.f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
      this.l();
      if (this.a.t()) {
         var1.putByteArray("framework", this.b.t().h());
      }

      if (this.a.n()) {
         Bundle var2 = new Bundle();
         this.b.i().e(var2);
         var1.putBundle("plugins", var2);
      }

   }

   void E() {
      y.b.f("FlutterActivityAndFragmentDelegate", "onStart()");
      this.l();
      this.k();
      Integer var1 = this.j;
      if (var1 != null) {
         this.c.setVisibility(var1);
      }

   }

   void F() {
      y.b.f("FlutterActivityAndFragmentDelegate", "onStop()");
      this.l();
      io.flutter.embedding.engine.a var1;
      if (this.a.r()) {
         var1 = this.b;
         if (var1 != null) {
            var1.l().d();
         }
      }

      this.j = this.c.getVisibility();
      this.c.setVisibility(8);
      var1 = this.b;
      if (var1 != null) {
         var1.s().p(40);
      }

   }

   void G(int var1) {
      this.l();
      io.flutter.embedding.engine.a var2 = this.b;
      if (var2 != null) {
         boolean var3;
         if (this.h && var1 >= 10) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var3) {
            var2.k().i();
            this.b.w().a();
         }

         this.b.s().p(var1);
         this.b.q().o0(var1);
      }

   }

   void H() {
      this.l();
      if (this.b != null) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
         this.b.i().f();
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
      }

   }

   void I(boolean var1) {
      this.l();
      StringBuilder var2 = new StringBuilder();
      var2.append("Received onWindowFocusChanged: ");
      String var3;
      if (var1) {
         var3 = "true";
      } else {
         var3 = "false";
      }

      var2.append(var3);
      y.b.f("FlutterActivityAndFragmentDelegate", var2.toString());
      if (this.a.r()) {
         io.flutter.embedding.engine.a var4 = this.b;
         if (var4 != null) {
            if (var1) {
               var4.l().a();
            } else {
               var4.l().f();
            }
         }
      }

   }

   void J() {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
   }

   void K() {
      y.b.f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
      String var1 = this.a.s();
      StringBuilder var7;
      if (var1 != null) {
         io.flutter.embedding.engine.a var9 = io.flutter.embedding.engine.b.b().a(var1);
         this.b = var9;
         this.f = true;
         if (var9 == null) {
            var7 = new StringBuilder();
            var7.append("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '");
            var7.append(var1);
            var7.append("'");
            throw new IllegalStateException(var7.toString());
         }
      } else {
         g.c var4 = this.a;
         io.flutter.embedding.engine.a var5 = var4.A(var4.a());
         this.b = var5;
         if (var5 != null) {
            this.f = true;
         } else {
            var1 = this.a.i();
            io.flutter.embedding.engine.d var2;
            io.flutter.embedding.engine.d.b var6;
            if (var1 != null) {
               var2 = io.flutter.embedding.engine.e.b().a(var1);
               if (var2 == null) {
                  var7 = new StringBuilder();
                  var7.append("The requested cached FlutterEngineGroup did not exist in the FlutterEngineGroupCache: '");
                  var7.append(var1);
                  var7.append("'");
                  throw new IllegalStateException(var7.toString());
               }

               var6 = new io.flutter.embedding.engine.d.b(this.a.a());
            } else {
               y.b.f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
               var2 = this.k;
               io.flutter.embedding.engine.d var8 = var2;
               if (var2 == null) {
                  var8 = new io.flutter.embedding.engine.d(this.a.a(), this.a.k().b());
               }

               io.flutter.embedding.engine.d.b var3 = (new io.flutter.embedding.engine.d.b(this.a.a())).h(false).l(this.a.t());
               var2 = var8;
               var6 = var3;
            }

            this.b = var2.a(this.e(var6));
            this.f = false;
         }
      }
   }

   void L(BackEvent var1) {
      this.l();
      if (this.b != null) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Forwarding startBackGesture() to FlutterEngine.");
         this.b.j().d(var1);
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "Invoked startBackGesture() before FlutterFragment was attached to an Activity.");
      }

   }

   void M(BackEvent var1) {
      this.l();
      if (this.b != null) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Forwarding updateBackGestureProgress() to FlutterEngine.");
         this.b.j().e(var1);
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "Invoked updateBackGestureProgress() before FlutterFragment was attached to an Activity.");
      }

   }

   void N() {
      io.flutter.plugin.platform.g var1 = this.d;
      if (var1 != null) {
         var1.E();
      }

   }

   public void f() {
      if (!this.a.p()) {
         this.a.f();
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append("The internal FlutterEngine created by ");
         var1.append(this.a);
         var1.append(" has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
         throw new AssertionError(var1.toString());
      }
   }

   void h() {
      this.l();
      if (this.b != null) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Forwarding cancelBackGesture() to FlutterEngine.");
         this.b.j().b();
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "Invoked cancelBackGesture() before FlutterFragment was attached to an Activity.");
      }

   }

   void i() {
      this.l();
      if (this.b != null) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Forwarding commitBackGesture() to FlutterEngine.");
         this.b.j().c();
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "Invoked commitBackGesture() before FlutterFragment was attached to an Activity.");
      }

   }

   public Activity m() {
      Activity var1 = this.a.e();
      if (var1 != null) {
         return var1;
      } else {
         throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
      }
   }

   io.flutter.embedding.engine.a n() {
      return this.b;
   }

   boolean o() {
      return this.i;
   }

   boolean p() {
      return this.f;
   }

   void r(int var1, int var2, Intent var3) {
      this.l();
      if (this.b != null) {
         StringBuilder var4 = new StringBuilder();
         var4.append("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ");
         var4.append(var1);
         var4.append("\nresultCode: ");
         var4.append(var2);
         var4.append("\ndata: ");
         var4.append(var3);
         y.b.f("FlutterActivityAndFragmentDelegate", var4.toString());
         this.b.i().a(var1, var2, var3);
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
      }

   }

   void s(Context var1) {
      this.l();
      if (this.b == null) {
         this.K();
      }

      if (this.a.n()) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
         this.b.i().g(this, this.a.b());
      }

      g.c var2 = this.a;
      this.d = var2.x(var2.e(), this.b);
      this.a.E(this.b);
      this.i = true;
   }

   void t() {
      this.l();
      if (this.b != null) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
         this.b.o().a();
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
      }

   }

   View u(LayoutInflater var1, ViewGroup var2, Bundle var3, int var4, boolean var5) {
      y.b.f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
      this.l();
      e0 var11 = this.a.o();
      e0 var8 = e0.e;
      boolean var6 = true;
      boolean var7 = true;
      t var12;
      if (var11 == var8) {
         Context var9 = this.a.a();
         if (this.a.C() != f0.f) {
            var7 = false;
         }

         m var10 = new m(var9, var7);
         this.a.y(var10);
         var12 = new t(this.a.a(), var10);
      } else {
         n var13 = new n(this.a.a());
         if (this.a.C() == f0.e) {
            var7 = var6;
         } else {
            var7 = false;
         }

         var13.setOpaque(var7);
         this.a.D(var13);
         var12 = new t(this.a.a(), var13);
      }

      this.c = var12;
      this.c.l(this.l);
      if (this.a.q()) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
         this.c.n(this.b);
      }

      this.c.setId(var4);
      if (var5) {
         this.j(this.c);
      }

      return this.c;
   }

   void v() {
      y.b.f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
      this.l();
      if (this.e != null) {
         this.c.getViewTreeObserver().removeOnPreDrawListener(this.e);
         this.e = null;
      }

      t var1 = this.c;
      if (var1 != null) {
         var1.s();
         this.c.y(this.l);
      }

   }

   void w() {
      if (this.i) {
         y.b.f("FlutterActivityAndFragmentDelegate", "onDetach()");
         this.l();
         this.a.v(this.b);
         if (this.a.n()) {
            y.b.f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.a.e().isChangingConfigurations()) {
               this.b.i().i();
            } else {
               this.b.i().h();
            }
         }

         io.flutter.plugin.platform.g var1 = this.d;
         if (var1 != null) {
            var1.q();
            this.d = null;
         }

         if (this.a.r()) {
            io.flutter.embedding.engine.a var2 = this.b;
            if (var2 != null) {
               var2.l().b();
            }
         }

         if (this.a.p()) {
            this.b.g();
            if (this.a.s() != null) {
               io.flutter.embedding.engine.b.b().d(this.a.s());
            }

            this.b = null;
         }

         this.i = false;
      }
   }

   void x(Intent var1) {
      this.l();
      if (this.b != null) {
         y.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRouteInformation message.");
         this.b.i().b(var1);
         String var2 = this.q(var1);
         if (var2 != null && !var2.isEmpty()) {
            this.b.o().b(var2);
         }
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
      }

   }

   void y() {
      y.b.f("FlutterActivityAndFragmentDelegate", "onPause()");
      this.l();
      if (this.a.r()) {
         io.flutter.embedding.engine.a var1 = this.b;
         if (var1 != null) {
            var1.l().c();
         }
      }

   }

   void z() {
      y.b.f("FlutterActivityAndFragmentDelegate", "onPostResume()");
      this.l();
      if (this.b != null) {
         this.N();
         this.b.q().n0();
      } else {
         y.b.g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
      }

   }

   interface c extends io.flutter.plugin.platform.g.d {
      io.flutter.embedding.engine.a A(Context var1);

      boolean B();

      f0 C();

      void D(n var1);

      void E(io.flutter.embedding.engine.a var1);

      Context a();

      androidx.lifecycle.h b();

      void d();

      Activity e();

      void f();

      void g();

      String i();

      String j();

      io.flutter.embedding.engine.g k();

      List<String> m();

      boolean n();

      e0 o();

      boolean p();

      boolean q();

      boolean r();

      String s();

      boolean t();

      String u();

      void v(io.flutter.embedding.engine.a var1);

      String w();

      io.flutter.plugin.platform.g x(Activity var1, io.flutter.embedding.engine.a var2);

      void y(m var1);

      String z();
   }
}
