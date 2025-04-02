package l;

import android.os.Trace;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a {
   private static long a;
   private static Method b;
   private static Method c;
   private static Method d;

   public static void a(String var0, int var1) {
      int var2 = VERSION.SDK_INT;
      var0 = j(var0);
      if (var2 >= 29) {
         f.a(var0, var1);
      } else {
         b(var0, var1);
      }

   }

   private static void b(String var0, int var1) {
      try {
         if (c == null) {
            c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
         }

         c.invoke((Object)null, a, var0, var1);
      } catch (Exception var2) {
         g("asyncTraceBegin", var2);
      }

   }

   public static void c(String var0) {
      l.b.a(j(var0));
   }

   public static void d(String var0, int var1) {
      int var2 = VERSION.SDK_INT;
      var0 = j(var0);
      if (var2 >= 29) {
         f.b(var0, var1);
      } else {
         e(var0, var1);
      }

   }

   private static void e(String var0, int var1) {
      try {
         if (d == null) {
            d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
         }

         d.invoke((Object)null, a, var0, var1);
      } catch (Exception var2) {
         g("asyncTraceEnd", var2);
      }

   }

   public static void f() {
      l.b.b();
   }

   private static void g(String var0, Exception var1) {
      if (var1 instanceof InvocationTargetException) {
         Throwable var3 = var1.getCause();
         if (var3 instanceof RuntimeException) {
            throw (RuntimeException)var3;
         } else {
            throw new RuntimeException(var3);
         }
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("Unable to call ");
         var2.append(var0);
         var2.append(" via reflection");
         Log.v("Trace", var2.toString(), var1);
      }
   }

   public static boolean h() {
      return VERSION.SDK_INT >= 29 ? f.c() : i();
   }

   private static boolean i() {
      try {
         if (b == null) {
            a = Trace.class.getField("TRACE_TAG_APP").getLong((Object)null);
            b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
         }

         boolean var0 = (Boolean)b.invoke((Object)null, a);
         return var0;
      } catch (Exception var2) {
         g("isTagEnabled", var2);
         return false;
      }
   }

   private static String j(String var0) {
      return var0.length() <= 127 ? var0 : var0.substring(0, 127);
   }
}
