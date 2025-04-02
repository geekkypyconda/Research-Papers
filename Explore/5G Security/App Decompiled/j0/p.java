package j0;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class p {
   private static final p.a b = new p.a();
   public final k0.a<Object> a;

   public p(z.a var1) {
      this.a = new k0.a(var1, "flutter/settings", k0.d.a);
   }

   public static DisplayMetrics b(int var0) {
      p.a.b var1 = b.c(var0);
      DisplayMetrics var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.b;
      }

      return var2;
   }

   public static boolean c() {
      boolean var0;
      if (VERSION.SDK_INT >= 34) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public p.b d() {
      return new p.b(this.a);
   }

   public static class a {
      private final ConcurrentLinkedQueue<p.a.b> a = new ConcurrentLinkedQueue();
      private p.a.b b;
      private p.a.b c;

      // $FF: synthetic method
      static ConcurrentLinkedQueue a(p.a var0) {
         return var0.a;
      }

      public k0.a.e b(p.a.b var1) {
         this.a.add(var1);
         p.a.b var2 = this.c;
         this.c = var1;
         k0.a.e var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = new k0.a.e(var2) {
               // $FF: synthetic field
               final p.a.b a;
               // $FF: synthetic field
               final p.a b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void a(Object var1) {
                  p.a.a(this.b).remove(this.a);
                  if (!p.a.a(this.b).isEmpty()) {
                     StringBuilder var2 = new StringBuilder();
                     var2.append("The queue becomes empty after removing config generation ");
                     var2.append(String.valueOf(this.a.a));
                     y.b.b("SettingsChannel", var2.toString());
                  }

               }
            };
         }

         return var3;
      }

      public p.a.b c(int var1) {
         if (this.b == null) {
            this.b = (p.a.b)this.a.poll();
         }

         while(true) {
            p.a.b var2 = this.b;
            if (var2 == null || var2.a >= var1) {
               StringBuilder var3;
               String var4;
               if (var2 == null) {
                  var3 = new StringBuilder();
                  var3.append("Cannot find config with generation: ");
                  var3.append(String.valueOf(var1));
                  var4 = ", after exhausting the queue.";
               } else {
                  if (var2.a == var1) {
                     return var2;
                  }

                  var3 = new StringBuilder();
                  var3.append("Cannot find config with generation: ");
                  var3.append(String.valueOf(var1));
                  var3.append(", the oldest config is now: ");
                  var4 = String.valueOf(this.b.a);
               }

               var3.append(var4);
               y.b.b("SettingsChannel", var3.toString());
               return null;
            }

            this.b = (p.a.b)this.a.poll();
         }
      }

      public static class b {
         private static int c;
         public final int a;
         private final DisplayMetrics b;

         public b(DisplayMetrics var1) {
            int var2 = c++;
            this.a = var2;
            this.b = var1;
         }
      }
   }

   public static class b {
      private final k0.a<Object> a;
      private Map<String, Object> b = new HashMap();
      private DisplayMetrics c;

      b(k0.a<Object> var1) {
         this.a = var1;
      }

      public void a() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Sending message: \ntextScaleFactor: ");
         var1.append(this.b.get("textScaleFactor"));
         var1.append("\nalwaysUse24HourFormat: ");
         var1.append(this.b.get("alwaysUse24HourFormat"));
         var1.append("\nplatformBrightness: ");
         var1.append(this.b.get("platformBrightness"));
         y.b.f("SettingsChannel", var1.toString());
         DisplayMetrics var3 = this.c;
         if (p.c() && var3 != null) {
            p.a.b var2 = new p.a.b(var3);
            k0.a.e var4 = p.b.b(var2);
            this.b.put("configurationId", var2.a);
            this.a.d(this.b, var4);
         } else {
            this.a.c(this.b);
         }
      }

      public p.b b(boolean var1) {
         this.b.put("brieflyShowPassword", var1);
         return this;
      }

      public p.b c(DisplayMetrics var1) {
         this.c = var1;
         return this;
      }

      public p.b d(boolean var1) {
         this.b.put("nativeSpellCheckServiceDefined", var1);
         return this;
      }

      public p.b e(p.c var1) {
         this.b.put("platformBrightness", var1.e);
         return this;
      }

      public p.b f(float var1) {
         this.b.put("textScaleFactor", var1);
         return this;
      }

      public p.b g(boolean var1) {
         this.b.put("alwaysUse24HourFormat", var1);
         return this;
      }
   }

   public static enum c {
      f("light"),
      g("dark");

      public String e;

      private c(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static p.c[] a() {
         return new p.c[]{f, g};
      }
   }
}
