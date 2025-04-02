package o0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import r.k;
import r.l;

public final class i {
   // $FF: synthetic method
   public static boolean a(View var0) {
      return g(var0);
   }

   // $FF: synthetic method
   public static boolean b(Class[] var0, View var1) {
      return h(var0, var1);
   }

   public static void c(Context var0, i.a var1) {
      Activity var2 = e(var0);
      if (var2 != null) {
         k var3 = l.a().a(var2);
         var1.a((float)var3.a().width(), (float)var3.a().height(), var0.getResources().getDisplayMetrics().density);
      }

   }

   public static boolean d(View var0) {
      return i(var0, new g());
   }

   public static Activity e(Context var0) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof Activity) {
         return (Activity)var0;
      } else {
         return var0 instanceof ContextWrapper ? e(((ContextWrapper)var0).getBaseContext()) : null;
      }
   }

   public static boolean f(View var0, Class<? extends View>[] var1) {
      return i(var0, new h(var1));
   }

   // $FF: synthetic method
   private static boolean g(View var0) {
      return var0.hasFocus();
   }

   // $FF: synthetic method
   private static boolean h(Class[] var0, View var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         if (var0[var2].isInstance(var1)) {
            return true;
         }
      }

      return false;
   }

   public static boolean i(View var0, i.b var1) {
      if (var0 == null) {
         return false;
      } else if (var1.a(var0)) {
         return true;
      } else {
         if (var0 instanceof ViewGroup) {
            ViewGroup var3 = (ViewGroup)var0;

            for(int var2 = 0; var2 < var3.getChildCount(); ++var2) {
               if (i(var3.getChildAt(var2), var1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public interface a {
      void a(float var1, float var2, float var3);
   }

   public interface b {
      boolean a(View var1);
   }
}
