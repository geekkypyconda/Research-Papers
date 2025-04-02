package j0;

import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
   public final k0.a<Object> a;

   public e(k0.b var1) {
      this.a = new k0.a(var1, "flutter/keyevent", k0.d.a);
   }

   // $FF: synthetic method
   public static void a(e.a var0, Object var1) {
      d(var0, var1);
   }

   private static k0.a.e<Object> b(e.a var0) {
      return new d(var0);
   }

   private Map<String, Object> c(e.b var1, boolean var2) {
      HashMap var3 = new HashMap();
      String var4;
      if (var2) {
         var4 = "keyup";
      } else {
         var4 = "keydown";
      }

      var3.put("type", var4);
      var3.put("keymap", "android");
      var3.put("flags", var1.a.getFlags());
      var3.put("plainCodePoint", var1.a.getUnicodeChar(0));
      var3.put("codePoint", var1.a.getUnicodeChar());
      var3.put("keyCode", var1.a.getKeyCode());
      var3.put("scanCode", var1.a.getScanCode());
      var3.put("metaState", var1.a.getMetaState());
      Character var5 = var1.b;
      if (var5 != null) {
         var3.put("character", var5.toString());
      }

      var3.put("source", var1.a.getSource());
      var3.put("deviceId", var1.a.getDeviceId());
      var3.put("repeatCount", var1.a.getRepeatCount());
      return var3;
   }

   // $FF: synthetic method
   private static void d(e.a var0, Object var1) {
      boolean var2 = false;
      boolean var3 = var2;
      if (var1 != null) {
         try {
            var3 = ((JSONObject)var1).getBoolean("handled");
         } catch (JSONException var5) {
            StringBuilder var6 = new StringBuilder();
            var6.append("Unable to unpack JSON message: ");
            var6.append(var5);
            y.b.b("KeyEventChannel", var6.toString());
            var3 = var2;
         }
      }

      var0.a(var3);
   }

   public void e(e.b var1, boolean var2, e.a var3) {
      this.a.d(this.c(var1, var2), b(var3));
   }

   public interface a {
      void a(boolean var1);
   }

   public static class b {
      public final KeyEvent a;
      public final Character b;

      public b(KeyEvent var1, Character var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
