package n0;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.ResolveInfoFlags;
import android.os.Build.VERSION;
import e0.c;
import j0.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k0.i;
import k0.k;

public class a implements d0.a, e0.a, k, n.b {
   private final n a;
   private final PackageManager b;
   private c c;
   private Map<String, ResolveInfo> d;
   private Map<Integer, i.d> e = new HashMap();

   public a(n var1) {
      this.a = var1;
      this.b = var1.b;
      var1.b(this);
   }

   private void j() {
      this.d = new HashMap();
      int var1 = VERSION.SDK_INT;
      if (var1 >= 23) {
         Intent var2 = (new Intent()).setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
         List var5;
         if (var1 >= 33) {
            var5 = this.b.queryIntentActivities(var2, ResolveInfoFlags.of(0L));
         } else {
            var5 = this.b.queryIntentActivities(var2, 0);
         }

         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            ResolveInfo var3 = (ResolveInfo)var6.next();
            String var4 = var3.activityInfo.name;
            var3.loadLabel(this.b).toString();
            this.d.put(var4, var3);
         }

      }
   }

   public boolean a(int var1, int var2, Intent var3) {
      if (!this.e.containsKey(var1)) {
         return false;
      } else {
         String var4 = null;
         if (var2 == -1) {
            var4 = var3.getStringExtra("android.intent.extra.PROCESS_TEXT");
         }

         ((i.d)this.e.remove(var1)).b(var4);
         return true;
      }
   }

   public void b(String var1, String var2, boolean var3, i.d var4) {
      if (this.c == null) {
         var4.a("error", "Plugin not bound to an Activity", (Object)null);
      } else if (VERSION.SDK_INT < 23) {
         var4.a("error", "Android version not supported", (Object)null);
      } else {
         Map var5 = this.d;
         if (var5 == null) {
            var4.a("error", "Can not process text actions before calling queryTextActions", (Object)null);
         } else {
            ResolveInfo var6 = (ResolveInfo)var5.get(var1);
            if (var6 == null) {
               var4.a("error", "Text processing activity not found", (Object)null);
            } else {
               Integer var8 = var4.hashCode();
               this.e.put(var8, var4);
               Intent var9 = new Intent();
               ActivityInfo var7 = var6.activityInfo;
               var9.setClassName(var7.packageName, var7.name);
               var9.setAction("android.intent.action.PROCESS_TEXT");
               var9.setType("text/plain");
               var9.putExtra("android.intent.extra.PROCESS_TEXT", var2);
               var9.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", var3);
               this.c.e().startActivityForResult(var9, var8);
            }
         }
      }
   }

   public Map<String, String> c() {
      if (this.d == null) {
         this.j();
      }

      HashMap var1 = new HashMap();
      Iterator var2 = this.d.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, ((ResolveInfo)this.d.get(var3)).loadLabel(this.b).toString());
      }

      return var1;
   }

   public void d(d0.a.b var1) {
   }

   public void e(c var1) {
      this.c = var1;
      var1.f(this);
   }

   public void f() {
      this.c.g(this);
      this.c = null;
   }

   public void g(d0.a.b var1) {
   }

   public void h(c var1) {
      this.c = var1;
      var1.f(this);
   }

   public void i() {
      this.c.g(this);
      this.c = null;
   }
}
