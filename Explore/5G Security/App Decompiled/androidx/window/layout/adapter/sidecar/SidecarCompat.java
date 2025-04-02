package androidx.window.layout.adapter.sidecar;

import a1.g;
import a1.k;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnAttachStateChangeListener;
import android.view.WindowManager.LayoutParams;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import androidx.window.sidecar.SidecarInterface.SidecarCallback;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import o.j;
import p0.q;
import q0.l;

public final class SidecarCompat implements androidx.window.layout.adapter.sidecar.a {
   public static final SidecarCompat.a f = new SidecarCompat.a((g)null);
   private final SidecarInterface a;
   private final u.a b;
   private final Map<IBinder, Activity> c;
   private final Map<Activity, h.a<Configuration>> d;
   private SidecarCompat.b e;

   public SidecarCompat(Context var1) {
      k.e(var1, "context");
      this(f.b(var1), new u.a((j)null, 1, (g)null));
   }

   public SidecarCompat(SidecarInterface var1, u.a var2) {
      k.e(var2, "sidecarAdapter");
      super();
      this.a = var1;
      this.b = var2;
      this.c = new LinkedHashMap();
      this.d = new LinkedHashMap();
   }

   // $FF: synthetic method
   public static void d(SidecarCompat var0, Activity var1, Configuration var2) {
      l(var0, var1, var2);
   }

   private final void k(Activity var1) {
      if (this.d.get(var1) == null && var1 instanceof androidx.core.content.c) {
         u.b var2 = new u.b(this, var1);
         this.d.put(var1, var2);
         ((androidx.core.content.c)var1).b(var2);
      }

   }

   private static final void l(SidecarCompat var0, Activity var1, Configuration var2) {
      k.e(var0, "this$0");
      k.e(var1, "$activity");
      SidecarCompat.b var3 = var0.e;
      if (var3 != null) {
         var3.a(var1, var0.i(var1));
      }

   }

   private final void m(Activity var1) {
      h.a var2 = (h.a)this.d.get(var1);
      if (var2 != null) {
         if (var1 instanceof androidx.core.content.c) {
            ((androidx.core.content.c)var1).a(var2);
         }

         this.d.remove(var1);
      }
   }

   public void a(androidx.window.layout.adapter.sidecar.a.a var1) {
      k.e(var1, "extensionCallback");
      this.e = new SidecarCompat.b(var1);
      SidecarInterface var2 = this.a;
      if (var2 != null) {
         var2.setSidecarCallback((SidecarCallback)(new DistinctElementSidecarCallback(this.b, (SidecarCallback)(new SidecarCompat.TranslatingCallback()))));
      }

   }

   public void b(Activity var1) {
      k.e(var1, "activity");
      IBinder var2 = f.a(var1);
      if (var2 != null) {
         SidecarInterface var3 = this.a;
         if (var3 != null) {
            var3.onWindowLayoutChangeListenerRemoved(var2);
         }

         this.m(var1);
         SidecarCompat.b var6 = this.e;
         if (var6 != null) {
            var6.b(var1);
         }

         boolean var4;
         if (this.c.size() == 1) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.c.remove(var2);
         if (var4) {
            SidecarInterface var5 = this.a;
            if (var5 != null) {
               var5.onDeviceStateListenersChanged(true);
            }
         }

      }
   }

   public void c(Activity var1) {
      k.e(var1, "activity");
      IBinder var2 = f.a(var1);
      if (var2 != null) {
         this.j(var2, var1);
      } else {
         SidecarCompat.c var3 = new SidecarCompat.c(this, var1);
         var1.getWindow().getDecorView().addOnAttachStateChangeListener(var3);
      }

   }

   public final SidecarInterface h() {
      return this.a;
   }

   public final r.j i(Activity var1) {
      k.e(var1, "activity");
      IBinder var5 = f.a(var1);
      if (var5 == null) {
         return new r.j(l.e());
      } else {
         SidecarInterface var2 = this.a;
         SidecarWindowLayoutInfo var6;
         if (var2 != null) {
            var6 = var2.getWindowLayoutInfo(var5);
         } else {
            var6 = null;
         }

         u.a var3 = this.b;
         var2 = this.a;
         SidecarDeviceState var7;
         if (var2 != null) {
            SidecarDeviceState var4 = var2.getDeviceState();
            var7 = var4;
            if (var4 != null) {
               return var3.f(var6, var7);
            }
         }

         var7 = new SidecarDeviceState();
         return var3.f(var6, var7);
      }
   }

   public final void j(IBinder var1, Activity var2) {
      k.e(var1, "windowToken");
      k.e(var2, "activity");
      this.c.put(var1, var2);
      SidecarInterface var3 = this.a;
      if (var3 != null) {
         var3.onWindowLayoutChangeListenerAdded(var1);
      }

      if (this.c.size() == 1) {
         SidecarInterface var4 = this.a;
         if (var4 != null) {
            var4.onDeviceStateListenersChanged(false);
         }
      }

      SidecarCompat.b var5 = this.e;
      if (var5 != null) {
         var5.a(var2, this.i(var2));
      }

      this.k(var2);
   }

   public boolean n() {
      // $FF: Couldn't be decompiled
   }

   public final class TranslatingCallback implements SidecarCallback {
      public void onDeviceStateChanged(SidecarDeviceState var1) {
         k.e(var1, "newDeviceState");
         Collection var2 = SidecarCompat.this.c.values();
         SidecarCompat var3 = SidecarCompat.this;
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            Activity var5 = (Activity)var4.next();
            IBinder var6 = SidecarCompat.f.a(var5);
            SidecarCompat.b var7 = null;
            SidecarWindowLayoutInfo var9 = var7;
            if (var6 != null) {
               SidecarInterface var8 = var3.h();
               var9 = var7;
               if (var8 != null) {
                  var9 = var8.getWindowLayoutInfo(var6);
               }
            }

            var7 = var3.e;
            if (var7 != null) {
               var7.a(var5, var3.b.f(var9, var1));
            }
         }

      }

      public void onWindowLayoutChanged(IBinder var1, SidecarWindowLayoutInfo var2) {
         k.e(var1, "windowToken");
         k.e(var2, "newLayout");
         Activity var3 = (Activity)SidecarCompat.this.c.get(var1);
         if (var3 == null) {
            Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
         } else {
            u.a var4;
            SidecarDeviceState var7;
            label18: {
               var4 = SidecarCompat.this.b;
               SidecarInterface var6 = SidecarCompat.this.h();
               if (var6 != null) {
                  SidecarDeviceState var5 = var6.getDeviceState();
                  var7 = var5;
                  if (var5 != null) {
                     break label18;
                  }
               }

               var7 = new SidecarDeviceState();
            }

            r.j var9 = var4.f(var2, var7);
            SidecarCompat.b var8 = SidecarCompat.this.e;
            if (var8 != null) {
               var8.a(var3, var9);
            }

         }
      }
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(g var1) {
         this();
      }

      public final IBinder a(Activity var1) {
         IBinder var4;
         if (var1 != null) {
            Window var2 = var1.getWindow();
            if (var2 != null) {
               LayoutParams var3 = var2.getAttributes();
               if (var3 != null) {
                  var4 = var3.token;
                  return var4;
               }
            }
         }

         var4 = null;
         return var4;
      }

      public final SidecarInterface b(Context var1) {
         k.e(var1, "context");
         return SidecarProvider.getSidecarImpl(var1.getApplicationContext());
      }

      public final o.k c() {
         Object var1 = null;

         o.k var3;
         label28: {
            boolean var10001;
            String var2;
            try {
               var2 = SidecarProvider.getApiVersion();
            } catch (UnsupportedOperationException | NoClassDefFoundError var5) {
               var10001 = false;
               break label28;
            }

            var3 = (o.k)var1;

            try {
               if (!TextUtils.isEmpty(var2)) {
                  var3 = o.k.j.b(var2);
               }

               return var3;
            } catch (UnsupportedOperationException | NoClassDefFoundError var4) {
               var10001 = false;
            }
         }

         var3 = (o.k)var1;
         return var3;
      }
   }

   private static final class b implements androidx.window.layout.adapter.sidecar.a.a {
      private final androidx.window.layout.adapter.sidecar.a.a a;
      private final ReentrantLock b;
      private final WeakHashMap<Activity, r.j> c;

      public b(androidx.window.layout.adapter.sidecar.a.a var1) {
         k.e(var1, "callbackInterface");
         super();
         this.a = var1;
         this.b = new ReentrantLock();
         this.c = new WeakHashMap();
      }

      public void a(Activity var1, r.j var2) {
         k.e(var1, "activity");
         k.e(var2, "newLayout");
         ReentrantLock var3 = this.b;
         var3.lock();

         Throwable var10000;
         label78: {
            boolean var10001;
            boolean var4;
            try {
               var4 = k.a(var2, (r.j)this.c.get(var1));
            } catch (Throwable var11) {
               var10000 = var11;
               var10001 = false;
               break label78;
            }

            if (var4) {
               var3.unlock();
               return;
            }

            try {
               r.j var5 = (r.j)this.c.put(var1, var2);
            } catch (Throwable var10) {
               var10000 = var10;
               var10001 = false;
               break label78;
            }

            var3.unlock();
            this.a.a(var1, var2);
            return;
         }

         Throwable var12 = var10000;
         var3.unlock();
         throw var12;
      }

      public final void b(Activity var1) {
         k.e(var1, "activity");
         ReentrantLock var2 = this.b;
         var2.lock();

         try {
            this.c.put(var1, (Object)null);
            q var5 = q.a;
         } finally {
            var2.unlock();
         }

      }
   }

   private static final class c implements OnAttachStateChangeListener {
      private final SidecarCompat a;
      private final WeakReference<Activity> b;

      public c(SidecarCompat var1, Activity var2) {
         k.e(var1, "sidecarCompat");
         k.e(var2, "activity");
         super();
         this.a = var1;
         this.b = new WeakReference(var2);
      }

      public void onViewAttachedToWindow(View var1) {
         k.e(var1, "view");
         var1.removeOnAttachStateChangeListener(this);
         Activity var3 = (Activity)this.b.get();
         IBinder var2 = SidecarCompat.f.a(var3);
         if (var3 != null) {
            if (var2 != null) {
               this.a.j(var2, var3);
            }
         }
      }

      public void onViewDetachedFromWindow(View var1) {
         k.e(var1, "view");
      }
   }
}
