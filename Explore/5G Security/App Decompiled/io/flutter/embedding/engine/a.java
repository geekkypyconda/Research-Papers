package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.w;
import j0.h;
import j0.j;
import j0.k;
import j0.n;
import j0.o;
import j0.p;
import j0.q;
import j0.r;
import j0.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import o0.i;

public class a implements i.a {
   private final FlutterJNI a;
   private final FlutterRenderer b;
   private final z.a c;
   private final c d;
   private final l0.c e;
   private final j0.a f;
   private final j0.c g;
   private final j0.g h;
   private final h i;
   private final j0.i j;
   private final j k;
   private final j0.b l;
   private final o m;
   private final k n;
   private final n o;
   private final p p;
   private final q q;
   private final r r;
   private final s s;
   private final w t;
   private final Set<a.b> u;
   private final a.b v;

   public a(Context var1, b0.d var2, FlutterJNI var3, w var4, String[] var5, boolean var6, boolean var7) {
      this(var1, var2, var3, var4, var5, var6, var7, (d)null);
   }

   public a(Context var1, b0.d var2, FlutterJNI var3, w var4, String[] var5, boolean var6, boolean var7, d var8) {
      this.u = new HashSet();
      this.v = new a.b() {
         public void a() {
            y.b.f("FlutterEngine", "onPreEngineRestart()");
            Iterator var1 = a.this.u.iterator();

            while(var1.hasNext()) {
               ((a.b)var1.next()).a();
            }

            a.this.t.m0();
            a.this.m.g();
         }

         public void b() {
         }
      };

      AssetManager var9;
      try {
         var9 = var1.createPackageContext(var1.getPackageName(), 0).getAssets();
      } catch (NameNotFoundException var14) {
         var9 = var1.getAssets();
      }

      y.a var11 = y.a.e();
      FlutterJNI var10 = var3;
      if (var3 == null) {
         var10 = var11.d().a();
      }

      this.a = var10;
      z.a var12 = new z.a(var10, var9);
      this.c = var12;
      var12.j();
      a0.a var18 = y.a.e().a();
      this.f = new j0.a(var12, var10);
      j0.c var13 = new j0.c(var12);
      this.g = var13;
      this.h = new j0.g(var12);
      h var16 = new h(var12);
      this.i = var16;
      this.j = new j0.i(var12);
      this.k = new j(var12);
      this.l = new j0.b(var12);
      this.n = new k(var12);
      this.o = new n(var12, var1.getPackageManager());
      this.m = new o(var12, var7);
      this.p = new p(var12);
      this.q = new q(var12);
      this.r = new r(var12);
      this.s = new s(var12);
      if (var18 != null) {
         var18.c(var13);
      }

      l0.c var19 = new l0.c(var1, var16);
      this.e = var19;
      b0.d var17 = var2;
      if (var2 == null) {
         var17 = var11.c();
      }

      if (!var10.isAttached()) {
         var17.k(var1.getApplicationContext());
         var17.f(var1, var5);
      }

      var10.addEngineLifecycleListener(this.v);
      var10.setPlatformViewsController(var4);
      var10.setLocalizationPlugin(var19);
      var10.setDeferredComponentManager(var11.a());
      if (!var10.isAttached()) {
         this.f();
      }

      this.b = new FlutterRenderer(var10);
      this.t = var4;
      var4.g0();
      c var15 = new c(var1.getApplicationContext(), this, var17, var8);
      this.d = var15;
      var19.d(var1.getResources().getConfiguration());
      if (var6 && var17.e()) {
         i0.a.a(this);
      }

      o0.i.c(var1, this);
      var15.j(new n0.a(this.r()));
   }

   private void f() {
      y.b.f("FlutterEngine", "Attaching to JNI.");
      this.a.attachToNative();
      if (!this.y()) {
         throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
      }
   }

   private boolean y() {
      return this.a.isAttached();
   }

   public void a(float var1, float var2, float var3) {
      this.a.updateDisplayMetrics(0, var1, var2, var3);
   }

   public void e(a.b var1) {
      this.u.add(var1);
   }

   public void g() {
      y.b.f("FlutterEngine", "Destroying.");
      Iterator var1 = this.u.iterator();

      while(var1.hasNext()) {
         ((a.b)var1.next()).b();
      }

      this.d.l();
      this.t.i0();
      this.c.k();
      this.a.removeEngineLifecycleListener(this.v);
      this.a.setDeferredComponentManager((a0.a)null);
      this.a.detachFromNativeAndReleaseResources();
      if (y.a.e().a() != null) {
         y.a.e().a().b();
         this.g.c((a0.a)null);
      }

   }

   public j0.a h() {
      return this.f;
   }

   public e0.b i() {
      return this.d;
   }

   public j0.b j() {
      return this.l;
   }

   public z.a k() {
      return this.c;
   }

   public j0.g l() {
      return this.h;
   }

   public l0.c m() {
      return this.e;
   }

   public j0.i n() {
      return this.j;
   }

   public j o() {
      return this.k;
   }

   public k p() {
      return this.n;
   }

   public w q() {
      return this.t;
   }

   public n r() {
      return this.o;
   }

   public FlutterRenderer s() {
      return this.b;
   }

   public o t() {
      return this.m;
   }

   public p u() {
      return this.p;
   }

   public q v() {
      return this.q;
   }

   public r w() {
      return this.r;
   }

   public s x() {
      return this.s;
   }

   a z(Context var1, z.a.b var2, String var3, List<String> var4, w var5, boolean var6, boolean var7) {
      if (this.y()) {
         return new a(var1, (b0.d)null, this.a.spawn(var2.c, var2.b, var3, var4), var5, (String[])null, var6, var7);
      } else {
         throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
      }
   }

   public interface b {
      void a();

      void b();
   }
}
