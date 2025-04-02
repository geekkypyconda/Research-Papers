package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.h;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k0.k;
import k0.l;
import k0.m;
import k0.n;

class c implements e0.b {
   private final Map<Class<? extends d0.a>, d0.a> a = new HashMap();
   private final a b;
   private final d0.a.b c;
   private final Map<Class<? extends d0.a>, e0.a> d = new HashMap();
   private io.flutter.embedding.android.d<Activity> e;
   private io.flutter.embedding.engine.c.c f;
   private boolean g = false;
   private final Map<Class<? extends d0.a>, h0.a> h = new HashMap();
   private Service i;
   private final Map<Class<? extends d0.a>, f0.a> j = new HashMap();
   private BroadcastReceiver k;
   private final Map<Class<? extends d0.a>, g0.a> l = new HashMap();
   private ContentProvider m;

   c(Context var1, a var2, b0.d var3, d var4) {
      this.b = var2;
      this.c = new d0.a.b(var1, var2, var2.k(), var2.s(), var2.q().W(), new io.flutter.embedding.engine.c.b(var3), var4);
   }

   private void k(Activity var1, h var2) {
      this.f = new io.flutter.embedding.engine.c.c(var1, var2);
      boolean var3;
      if (var1.getIntent() != null) {
         var3 = var1.getIntent().getBooleanExtra("enable-software-rendering", false);
      } else {
         var3 = false;
      }

      this.b.q().u0(var3);
      this.b.q().C(var1, this.b.s(), this.b.k());
      Iterator var4 = this.d.values().iterator();

      while(var4.hasNext()) {
         e0.a var5 = (e0.a)var4.next();
         if (this.g) {
            var5.e(this.f);
         } else {
            var5.h(this.f);
         }
      }

      this.g = false;
   }

   private void m() {
      this.b.q().O();
      this.e = null;
      this.f = null;
   }

   private void n() {
      if (this.s()) {
         this.h();
      } else if (this.v()) {
         this.q();
      } else if (this.t()) {
         this.o();
      } else if (this.u()) {
         this.p();
      }

   }

   private boolean s() {
      boolean var1;
      if (this.e != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean t() {
      boolean var1;
      if (this.k != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean u() {
      boolean var1;
      if (this.m != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean v() {
      boolean var1;
      if (this.i != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean a(int var1, int var2, Intent var3) {
      if (this.s()) {
         o0.f var4 = o0.f.f("FlutterEngineConnectionRegistry#onActivityResult");

         boolean var5;
         try {
            var5 = this.f.a(var1, var2, var3);
         } catch (Throwable var11) {
            if (var4 != null) {
               try {
                  var4.close();
               } catch (Throwable var10) {
                  var11.addSuppressed(var10);
                  throw var11;
               }
            }

            throw var11;
         }

         if (var4 != null) {
            var4.close();
         }

         return var5;
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
         return false;
      }
   }

   public void b(Intent var1) {
      if (this.s()) {
         o0.f var2 = o0.f.f("FlutterEngineConnectionRegistry#onNewIntent");

         try {
            this.f.b(var1);
         } catch (Throwable var8) {
            if (var2 != null) {
               try {
                  var2.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
                  throw var8;
               }
            }

            throw var8;
         }

         if (var2 != null) {
            var2.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
      }

   }

   public void c(Bundle var1) {
      if (this.s()) {
         o0.f var2 = o0.f.f("FlutterEngineConnectionRegistry#onRestoreInstanceState");

         try {
            this.f.d(var1);
         } catch (Throwable var8) {
            if (var2 != null) {
               try {
                  var2.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
                  throw var8;
               }
            }

            throw var8;
         }

         if (var2 != null) {
            var2.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
      }

   }

   public boolean d(int var1, String[] var2, int[] var3) {
      if (this.s()) {
         o0.f var4 = o0.f.f("FlutterEngineConnectionRegistry#onRequestPermissionsResult");

         boolean var5;
         try {
            var5 = this.f.c(var1, var2, var3);
         } catch (Throwable var11) {
            if (var4 != null) {
               try {
                  var4.close();
               } catch (Throwable var10) {
                  var11.addSuppressed(var10);
                  throw var11;
               }
            }

            throw var11;
         }

         if (var4 != null) {
            var4.close();
         }

         return var5;
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
         return false;
      }
   }

   public void e(Bundle var1) {
      if (this.s()) {
         o0.f var2 = o0.f.f("FlutterEngineConnectionRegistry#onSaveInstanceState");

         try {
            this.f.h(var1);
         } catch (Throwable var8) {
            if (var2 != null) {
               try {
                  var2.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
                  throw var8;
               }
            }

            throw var8;
         }

         if (var2 != null) {
            var2.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
      }

   }

   public void f() {
      if (this.s()) {
         o0.f var1 = o0.f.f("FlutterEngineConnectionRegistry#onUserLeaveHint");

         try {
            this.f.i();
         } catch (Throwable var8) {
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
                  throw var8;
               }
            }

            throw var8;
         }

         if (var1 != null) {
            var1.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
      }

   }

   public void g(io.flutter.embedding.android.d<Activity> var1, h var2) {
      o0.f var3 = o0.f.f("FlutterEngineConnectionRegistry#attachToActivity");

      label205: {
         Throwable var10000;
         label206: {
            boolean var10001;
            io.flutter.embedding.android.d var4;
            try {
               var4 = this.e;
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label206;
            }

            if (var4 != null) {
               try {
                  var4.f();
               } catch (Throwable var23) {
                  var10000 = var23;
                  var10001 = false;
                  break label206;
               }
            }

            label193:
            try {
               this.n();
               this.e = var1;
               this.k((Activity)var1.g(), var2);
               break label205;
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label193;
            }
         }

         Throwable var25 = var10000;
         if (var3 != null) {
            try {
               var3.close();
            } catch (Throwable var21) {
               var25.addSuppressed(var21);
               throw var25;
            }
         }

         throw var25;
      }

      if (var3 != null) {
         var3.close();
      }

   }

   public void h() {
      if (this.s()) {
         o0.f var1 = o0.f.f("FlutterEngineConnectionRegistry#detachFromActivity");

         label260: {
            Throwable var10000;
            label261: {
               boolean var10001;
               Iterator var2;
               try {
                  var2 = this.d.values().iterator();
               } catch (Throwable var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label261;
               }

               while(true) {
                  try {
                     if (!var2.hasNext()) {
                        break;
                     }

                     ((e0.a)var2.next()).f();
                  } catch (Throwable var22) {
                     var10000 = var22;
                     var10001 = false;
                     break label261;
                  }
               }

               label241:
               try {
                  this.m();
                  break label260;
               } catch (Throwable var20) {
                  var10000 = var20;
                  var10001 = false;
                  break label241;
               }
            }

            Throwable var23 = var10000;
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var19) {
                  var23.addSuppressed(var19);
                  throw var23;
               }
            }

            throw var23;
         }

         if (var1 != null) {
            var1.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
      }

   }

   public void i() {
      if (this.s()) {
         o0.f var1 = o0.f.f("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");

         label260: {
            Throwable var10000;
            label261: {
               boolean var10001;
               Iterator var2;
               try {
                  this.g = true;
                  var2 = this.d.values().iterator();
               } catch (Throwable var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label261;
               }

               while(true) {
                  try {
                     if (!var2.hasNext()) {
                        break;
                     }

                     ((e0.a)var2.next()).i();
                  } catch (Throwable var22) {
                     var10000 = var22;
                     var10001 = false;
                     break label261;
                  }
               }

               label241:
               try {
                  this.m();
                  break label260;
               } catch (Throwable var20) {
                  var10000 = var20;
                  var10001 = false;
                  break label241;
               }
            }

            Throwable var23 = var10000;
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var19) {
                  var23.addSuppressed(var19);
                  throw var23;
               }
            }

            throw var23;
         }

         if (var1 != null) {
            var1.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
      }

   }

   public void j(d0.a var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("FlutterEngineConnectionRegistry#add ");
      var2.append(var1.getClass().getSimpleName());
      o0.f var62 = o0.f.f(var2.toString());

      Throwable var10000;
      label644: {
         boolean var3;
         boolean var10001;
         try {
            var3 = this.r(var1.getClass());
         } catch (Throwable var60) {
            var10000 = var60;
            var10001 = false;
            break label644;
         }

         StringBuilder var4;
         if (var3) {
            label648: {
               try {
                  var4 = new StringBuilder();
                  var4.append("Attempted to register plugin (");
                  var4.append(var1);
                  var4.append(") but it was already registered with this FlutterEngine (");
                  var4.append(this.b);
                  var4.append(").");
                  y.b.g("FlutterEngineCxnRegstry", var4.toString());
               } catch (Throwable var55) {
                  var10000 = var55;
                  var10001 = false;
                  break label648;
               }

               if (var62 != null) {
                  var62.close();
               }

               return;
            }
         } else {
            label649: {
               try {
                  var4 = new StringBuilder();
                  var4.append("Adding plugin: ");
                  var4.append(var1);
                  y.b.f("FlutterEngineCxnRegstry", var4.toString());
                  this.a.put(var1.getClass(), var1);
                  var1.d(this.c);
                  if (var1 instanceof e0.a) {
                     e0.a var63 = (e0.a)var1;
                     this.d.put(var1.getClass(), var63);
                     if (this.s()) {
                        var63.h(this.f);
                     }
                  }
               } catch (Throwable var59) {
                  var10000 = var59;
                  var10001 = false;
                  break label649;
               }

               try {
                  if (var1 instanceof h0.a) {
                     h0.a var64 = (h0.a)var1;
                     this.h.put(var1.getClass(), var64);
                     if (this.v()) {
                        var64.a((h0.b)null);
                     }
                  }
               } catch (Throwable var58) {
                  var10000 = var58;
                  var10001 = false;
                  break label649;
               }

               try {
                  if (var1 instanceof f0.a) {
                     f0.a var65 = (f0.a)var1;
                     this.j.put(var1.getClass(), var65);
                     if (this.t()) {
                        var65.a((f0.b)null);
                     }
                  }
               } catch (Throwable var57) {
                  var10000 = var57;
                  var10001 = false;
                  break label649;
               }

               try {
                  if (var1 instanceof g0.a) {
                     g0.a var66 = (g0.a)var1;
                     this.l.put(var1.getClass(), var66);
                     if (this.u()) {
                        var66.b((g0.b)null);
                     }
                  }
               } catch (Throwable var56) {
                  var10000 = var56;
                  var10001 = false;
                  break label649;
               }

               if (var62 != null) {
                  var62.close();
               }

               return;
            }
         }
      }

      Throwable var61 = var10000;
      if (var62 != null) {
         try {
            var62.close();
         } catch (Throwable var54) {
            var61.addSuppressed(var54);
            throw var61;
         }
      }

      throw var61;
   }

   public void l() {
      y.b.f("FlutterEngineCxnRegstry", "Destroying.");
      this.n();
      this.y();
   }

   public void o() {
      if (this.t()) {
         o0.f var1 = o0.f.f("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");

         label181: {
            Throwable var10000;
            label173: {
               boolean var10001;
               Iterator var2;
               try {
                  var2 = this.j.values().iterator();
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label173;
               }

               while(true) {
                  try {
                     if (!var2.hasNext()) {
                        break label181;
                     }

                     ((f0.a)var2.next()).b();
                  } catch (Throwable var13) {
                     var10000 = var13;
                     var10001 = false;
                     break;
                  }
               }
            }

            Throwable var15 = var10000;
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var12) {
                  var15.addSuppressed(var12);
                  throw var15;
               }
            }

            throw var15;
         }

         if (var1 != null) {
            var1.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
      }

   }

   public void p() {
      if (this.u()) {
         o0.f var1 = o0.f.f("FlutterEngineConnectionRegistry#detachFromContentProvider");

         label181: {
            Throwable var10000;
            label173: {
               boolean var10001;
               Iterator var2;
               try {
                  var2 = this.l.values().iterator();
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label173;
               }

               while(true) {
                  try {
                     if (!var2.hasNext()) {
                        break label181;
                     }

                     ((g0.a)var2.next()).a();
                  } catch (Throwable var13) {
                     var10000 = var13;
                     var10001 = false;
                     break;
                  }
               }
            }

            Throwable var15 = var10000;
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var12) {
                  var15.addSuppressed(var12);
                  throw var15;
               }
            }

            throw var15;
         }

         if (var1 != null) {
            var1.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
      }

   }

   public void q() {
      if (this.v()) {
         o0.f var1 = o0.f.f("FlutterEngineConnectionRegistry#detachFromService");

         label260: {
            Throwable var10000;
            label261: {
               boolean var10001;
               Iterator var2;
               try {
                  var2 = this.h.values().iterator();
               } catch (Throwable var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label261;
               }

               while(true) {
                  try {
                     if (!var2.hasNext()) {
                        break;
                     }

                     ((h0.a)var2.next()).b();
                  } catch (Throwable var22) {
                     var10000 = var22;
                     var10001 = false;
                     break label261;
                  }
               }

               label241:
               try {
                  this.i = null;
                  break label260;
               } catch (Throwable var20) {
                  var10000 = var20;
                  var10001 = false;
                  break label241;
               }
            }

            Throwable var23 = var10000;
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var19) {
                  var23.addSuppressed(var19);
                  throw var23;
               }
            }

            throw var23;
         }

         if (var1 != null) {
            var1.close();
         }
      } else {
         y.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
      }

   }

   public boolean r(Class<? extends d0.a> var1) {
      return this.a.containsKey(var1);
   }

   public void w(Class<? extends d0.a> var1) {
      d0.a var2 = (d0.a)this.a.get(var1);
      if (var2 != null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("FlutterEngineConnectionRegistry#remove ");
         var3.append(var1.getSimpleName());
         o0.f var10 = o0.f.f(var3.toString());

         try {
            if (var2 instanceof e0.a) {
               if (this.s()) {
                  ((e0.a)var2).f();
               }

               this.d.remove(var1);
            }

            if (var2 instanceof h0.a) {
               if (this.v()) {
                  ((h0.a)var2).b();
               }

               this.h.remove(var1);
            }

            if (var2 instanceof f0.a) {
               if (this.t()) {
                  ((f0.a)var2).b();
               }

               this.j.remove(var1);
            }

            if (var2 instanceof g0.a) {
               if (this.u()) {
                  ((g0.a)var2).a();
               }

               this.l.remove(var1);
            }

            var2.g(this.c);
            this.a.remove(var1);
         } catch (Throwable var9) {
            if (var10 != null) {
               try {
                  var10.close();
               } catch (Throwable var8) {
                  var9.addSuppressed(var8);
                  throw var9;
               }
            }

            throw var9;
         }

         if (var10 != null) {
            var10.close();
         }

      }
   }

   public void x(Set<Class<? extends d0.a>> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.w((Class)var2.next());
      }

   }

   public void y() {
      this.x(new HashSet(this.a.keySet()));
      this.a.clear();
   }

   private static class b implements d0.a.a {
      final b0.d a;

      private b(b0.d var1) {
         this.a = var1;
      }

      // $FF: synthetic method
      b(b0.d var1, Object var2) {
         this(var1);
      }
   }

   private static class c implements e0.c {
      private final Activity a;
      private final HiddenLifecycleReference b;
      private final Set<m> c = new HashSet();
      private final Set<k> d = new HashSet();
      private final Set<l> e = new HashSet();
      private final Set<n> f = new HashSet();
      private final Set<Object> g = new HashSet();
      private final Set<e0.c.a> h = new HashSet();

      public c(Activity var1, h var2) {
         this.a = var1;
         this.b = new HiddenLifecycleReference(var2);
      }

      boolean a(int var1, int var2, Intent var3) {
         Iterator var4 = (new HashSet(this.d)).iterator();

         label19:
         while(true) {
            boolean var5;
            for(var5 = false; var4.hasNext(); var5 = true) {
               if (!((k)var4.next()).a(var1, var2, var3) && !var5) {
                  continue label19;
               }
            }

            return var5;
         }
      }

      void b(Intent var1) {
         Iterator var2 = this.e.iterator();

         while(var2.hasNext()) {
            ((l)var2.next()).b(var1);
         }

      }

      boolean c(int var1, String[] var2, int[] var3) {
         Iterator var4 = this.c.iterator();

         label19:
         while(true) {
            boolean var5;
            for(var5 = false; var4.hasNext(); var5 = true) {
               if (!((m)var4.next()).d(var1, var2, var3) && !var5) {
                  continue label19;
               }
            }

            return var5;
         }
      }

      void d(Bundle var1) {
         Iterator var2 = this.h.iterator();

         while(var2.hasNext()) {
            ((e0.c.a)var2.next()).c(var1);
         }

      }

      public Activity e() {
         return this.a;
      }

      public void f(k var1) {
         this.d.add(var1);
      }

      public void g(k var1) {
         this.d.remove(var1);
      }

      void h(Bundle var1) {
         Iterator var2 = this.h.iterator();

         while(var2.hasNext()) {
            ((e0.c.a)var2.next()).e(var1);
         }

      }

      void i() {
         Iterator var1 = this.f.iterator();

         while(var1.hasNext()) {
            ((n)var1.next()).f();
         }

      }
   }
}
