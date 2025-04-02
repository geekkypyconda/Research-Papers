package i0;

import io.flutter.plugins.GeneratedPluginRegistrant;
import y.b;

public class a {
   public static void a(io.flutter.embedding.engine.a var0) {
      try {
         GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", io.flutter.embedding.engine.a.class).invoke((Object)null, var0);
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Tried to automatically register plugins with FlutterEngine (");
         var2.append(var0);
         var2.append(") but could not find or invoke the GeneratedPluginRegistrant.");
         b.b("GeneratedPluginsRegister", var2.toString());
         b.c("GeneratedPluginsRegister", "Received exception while registering", var3);
      }

   }
}
