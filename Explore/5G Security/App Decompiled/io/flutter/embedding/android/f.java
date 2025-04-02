package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import java.util.List;

public class f extends Activity implements g.c, androidx.lifecycle.l {
   public static final int e = View.generateViewId();
   private boolean a = false;
   protected g b;
   private androidx.lifecycle.m c;
   private final OnBackInvokedCallback d;

   public f() {
      OnBackInvokedCallback var1;
      if (VERSION.SDK_INT < 33) {
         var1 = null;
      } else {
         var1 = this.K();
      }

      this.d = var1;
      this.c = new androidx.lifecycle.m(this);
   }

   private void H() {
      Window var1 = this.getWindow();
      var1.addFlags(Integer.MIN_VALUE);
      var1.setStatusBarColor(1073741824);
      var1.getDecorView().setSystemUiVisibility(1280);
   }

   private void I() {
      if (this.L() == h.f) {
         this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }

   }

   private View J() {
      g var1 = this.b;
      int var2 = e;
      boolean var3;
      if (this.o() == e0.e) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var1.u((LayoutInflater)null, (ViewGroup)null, (Bundle)null, var2, var3);
   }

   private OnBackInvokedCallback K() {
      return (OnBackInvokedCallback)(VERSION.SDK_INT >= 34 ? new OnBackAnimationCallback() {
         public void onBackCancelled() {
            f.this.F();
         }

         public void onBackInvoked() {
            f.this.G();
         }

         public void onBackProgressed(BackEvent var1) {
            f.this.V(var1);
         }

         public void onBackStarted(BackEvent var1) {
            f.this.R(var1);
         }
      } : new e(this));
   }

   private boolean O() {
      boolean var1;
      if ((this.getApplicationInfo().flags & 2) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean S(String var1) {
      g var2 = this.b;
      StringBuilder var4;
      String var5;
      if (var2 == null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("FlutterActivity ");
         var3.append(this.hashCode());
         var3.append(" ");
         var3.append(var1);
         var5 = " called after release.";
         var4 = var3;
      } else {
         if (var2.o()) {
            return true;
         }

         StringBuilder var6 = new StringBuilder();
         var6.append("FlutterActivity ");
         var6.append(this.hashCode());
         var6.append(" ");
         var6.append(var1);
         String var7 = " called after detach.";
         var4 = var6;
         var5 = var7;
      }

      var4.append(var5);
      y.b.g("FlutterActivity", var4.toString());
      return false;
   }

   private void T() {
      label36: {
         Bundle var1;
         boolean var10001;
         try {
            var1 = this.N();
         } catch (NameNotFoundException var6) {
            var10001 = false;
            break label36;
         }

         if (var1 != null) {
            label39: {
               int var2;
               try {
                  var2 = var1.getInt("io.flutter.embedding.android.NormalTheme", -1);
               } catch (NameNotFoundException var4) {
                  var10001 = false;
                  break label39;
               }

               if (var2 == -1) {
                  return;
               }

               try {
                  this.setTheme(var2);
                  return;
               } catch (NameNotFoundException var3) {
                  var10001 = false;
               }
            }
         } else {
            try {
               y.b.f("FlutterActivity", "Using the launch theme as normal theme.");
               return;
            } catch (NameNotFoundException var5) {
               var10001 = false;
            }
         }
      }

      y.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
   }

   public io.flutter.embedding.engine.a A(Context var1) {
      return null;
   }

   public boolean B() {
      boolean var1 = false;

      boolean var3;
      label27: {
         boolean var10001;
         Bundle var2;
         try {
            var2 = this.N();
         } catch (NameNotFoundException var5) {
            var10001 = false;
            break label27;
         }

         var3 = var1;
         if (var2 == null) {
            return var3;
         }

         try {
            var3 = var2.getBoolean("flutter_deeplinking_enabled");
            return var3;
         } catch (NameNotFoundException var4) {
            var10001 = false;
         }
      }

      var3 = var1;
      return var3;
   }

   public f0 C() {
      f0 var1;
      if (this.L() == h.e) {
         var1 = f0.e;
      } else {
         var1 = f0.f;
      }

      return var1;
   }

   public void D(n var1) {
   }

   public void E(io.flutter.embedding.engine.a var1) {
      if (!this.b.p()) {
         i0.a.a(var1);
      }
   }

   public void F() {
      if (this.S("cancelBackGesture")) {
         this.b.h();
      }

   }

   public void G() {
      if (this.S("commitBackGesture")) {
         this.b.i();
      }

   }

   protected h L() {
      return this.getIntent().hasExtra("background_mode") ? h.valueOf(this.getIntent().getStringExtra("background_mode")) : h.e;
   }

   protected io.flutter.embedding.engine.a M() {
      return this.b.n();
   }

   protected Bundle N() {
      return this.getPackageManager().getActivityInfo(this.getComponentName(), 128).metaData;
   }

   public void P() {
      if (VERSION.SDK_INT >= 33) {
         this.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.d);
         this.a = true;
      }

   }

   public void Q() {
      this.U();
      g var1 = this.b;
      if (var1 != null) {
         var1.J();
         this.b = null;
      }

   }

   public void R(BackEvent var1) {
      if (this.S("startBackGesture")) {
         this.b.L(var1);
      }

   }

   public void U() {
      if (VERSION.SDK_INT >= 33) {
         this.getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.d);
         this.a = false;
      }

   }

   public void V(BackEvent var1) {
      if (this.S("updateBackGestureProgress")) {
         this.b.M(var1);
      }

   }

   public Context a() {
      return this;
   }

   public androidx.lifecycle.h b() {
      return this.c;
   }

   public boolean c() {
      return false;
   }

   public void d() {
   }

   public Activity e() {
      return this;
   }

   public void f() {
      StringBuilder var1 = new StringBuilder();
      var1.append("FlutterActivity ");
      var1.append(this);
      var1.append(" connection to the engine ");
      var1.append(this.M());
      var1.append(" evicted by another attaching activity");
      y.b.g("FlutterActivity", var1.toString());
      g var2 = this.b;
      if (var2 != null) {
         var2.v();
         this.b.w();
      }

   }

   public void g() {
      if (VERSION.SDK_INT >= 29) {
         this.reportFullyDrawn();
      }

   }

   public void h(boolean var1) {
      if (var1 && !this.a) {
         this.P();
      } else if (!var1 && this.a) {
         this.U();
      }

   }

   public String i() {
      return this.getIntent().getStringExtra("cached_engine_group_id");
   }

   public String j() {
      if (this.getIntent().hasExtra("route")) {
         return this.getIntent().getStringExtra("route");
      } else {
         Object var1 = null;

         String var3;
         label31: {
            boolean var10001;
            Bundle var2;
            try {
               var2 = this.N();
            } catch (NameNotFoundException var5) {
               var10001 = false;
               break label31;
            }

            var3 = (String)var1;
            if (var2 == null) {
               return var3;
            }

            try {
               var3 = var2.getString("io.flutter.InitialRoute");
               return var3;
            } catch (NameNotFoundException var4) {
               var10001 = false;
            }
         }

         var3 = (String)var1;
         return var3;
      }
   }

   public io.flutter.embedding.engine.g k() {
      return io.flutter.embedding.engine.g.a(this.getIntent());
   }

   public List<String> m() {
      return (List)this.getIntent().getSerializableExtra("dart_entrypoint_args");
   }

   public boolean n() {
      return true;
   }

   public e0 o() {
      e0 var1;
      if (this.L() == h.e) {
         var1 = e0.e;
      } else {
         var1 = e0.f;
      }

      return var1;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      if (this.S("onActivityResult")) {
         this.b.r(var1, var2, var3);
      }

   }

   public void onBackPressed() {
      if (this.S("onBackPressed")) {
         this.b.t();
      }

   }

   protected void onCreate(Bundle var1) {
      this.T();
      super.onCreate(var1);
      g var2 = new g(this);
      this.b = var2;
      var2.s(this);
      this.b.B(var1);
      this.c.g(androidx.lifecycle.h.a.ON_CREATE);
      this.I();
      this.setContentView(this.J());
      this.H();
   }

   protected void onDestroy() {
      super.onDestroy();
      if (this.S("onDestroy")) {
         this.b.v();
         this.b.w();
      }

      this.Q();
      this.c.g(androidx.lifecycle.h.a.ON_DESTROY);
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      if (this.S("onNewIntent")) {
         this.b.x(var1);
      }

   }

   protected void onPause() {
      super.onPause();
      if (this.S("onPause")) {
         this.b.y();
      }

      this.c.g(androidx.lifecycle.h.a.ON_PAUSE);
   }

   public void onPostResume() {
      super.onPostResume();
      if (this.S("onPostResume")) {
         this.b.z();
      }

   }

   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      if (this.S("onRequestPermissionsResult")) {
         this.b.A(var1, var2, var3);
      }

   }

   protected void onResume() {
      super.onResume();
      this.c.g(androidx.lifecycle.h.a.ON_RESUME);
      if (this.S("onResume")) {
         this.b.C();
      }

   }

   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.S("onSaveInstanceState")) {
         this.b.D(var1);
      }

   }

   protected void onStart() {
      super.onStart();
      this.c.g(androidx.lifecycle.h.a.ON_START);
      if (this.S("onStart")) {
         this.b.E();
      }

   }

   protected void onStop() {
      super.onStop();
      if (this.S("onStop")) {
         this.b.F();
      }

      this.c.g(androidx.lifecycle.h.a.ON_STOP);
   }

   public void onTrimMemory(int var1) {
      super.onTrimMemory(var1);
      if (this.S("onTrimMemory")) {
         this.b.G(var1);
      }

   }

   public void onUserLeaveHint() {
      if (this.S("onUserLeaveHint")) {
         this.b.H();
      }

   }

   public void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      if (this.S("onWindowFocusChanged")) {
         this.b.I(var1);
      }

   }

   public boolean p() {
      boolean var1 = this.getIntent().getBooleanExtra("destroy_engine_with_activity", false);
      boolean var2 = var1;
      if (this.s() == null) {
         if (this.b.p()) {
            var2 = var1;
         } else {
            var2 = this.getIntent().getBooleanExtra("destroy_engine_with_activity", true);
         }
      }

      return var2;
   }

   public boolean q() {
      return true;
   }

   public boolean r() {
      return true;
   }

   public String s() {
      return this.getIntent().getStringExtra("cached_engine_id");
   }

   public boolean t() {
      if (this.getIntent().hasExtra("enable_state_restoration")) {
         return this.getIntent().getBooleanExtra("enable_state_restoration", false);
      } else {
         return this.s() == null;
      }
   }

   public String u() {
      String var1 = "main";
      if (this.getIntent().hasExtra("dart_entrypoint")) {
         return this.getIntent().getStringExtra("dart_entrypoint");
      } else {
         boolean var10001;
         Bundle var2;
         try {
            var2 = this.N();
         } catch (NameNotFoundException var4) {
            var10001 = false;
            return var1;
         }

         String var5;
         if (var2 == null) {
            var5 = null;
         } else {
            try {
               var5 = var2.getString("io.flutter.Entrypoint");
            } catch (NameNotFoundException var3) {
               var10001 = false;
               return var1;
            }
         }

         if (var5 != null) {
            var1 = var5;
         }

         return var1;
      }
   }

   public void v(io.flutter.embedding.engine.a var1) {
   }

   public String w() {
      Object var1 = null;

      String var3;
      label27: {
         boolean var10001;
         Bundle var2;
         try {
            var2 = this.N();
         } catch (NameNotFoundException var5) {
            var10001 = false;
            break label27;
         }

         var3 = (String)var1;
         if (var2 == null) {
            return var3;
         }

         try {
            var3 = var2.getString("io.flutter.EntrypointUri");
            return var3;
         } catch (NameNotFoundException var4) {
            var10001 = false;
         }
      }

      var3 = (String)var1;
      return var3;
   }

   public io.flutter.plugin.platform.g x(Activity var1, io.flutter.embedding.engine.a var2) {
      return new io.flutter.plugin.platform.g(this.e(), var2.p(), this);
   }

   public void y(m var1) {
   }

   public String z() {
      if (this.O() && "android.intent.action.RUN".equals(this.getIntent().getAction())) {
         String var1 = this.getIntent().getDataString();
         if (var1 != null) {
            return var1;
         }
      }

      return null;
   }
}
