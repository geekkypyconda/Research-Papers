package j0;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.HashMap;

public class a {
   public final k0.a<Object> a;
   public final FlutterJNI b;
   private a.b c;
   public final k0.a.d<Object> d;

   public a(z.a var1, FlutterJNI var2) {
      k0.a.d var3 = new k0.a.d<Object>() {
         public void a(Object var1, k0.a.e<Object> var2) {
            if (a.this.c == null) {
               var2.a((Object)null);
            } else {
               HashMap var3 = (HashMap)var1;
               String var4 = (String)var3.get("type");
               HashMap var5 = (HashMap)var3.get("data");
               StringBuilder var7 = new StringBuilder();
               var7.append("Received ");
               var7.append(var4);
               var7.append(" message.");
               y.b.f("AccessibilityChannel", var7.toString());
               var4.hashCode();
               byte var6 = -1;
               switch(var4.hashCode()) {
               case -1140076541:
                  if (var4.equals("tooltip")) {
                     var6 = 0;
                  }
                  break;
               case -649620375:
                  if (var4.equals("announce")) {
                     var6 = 1;
                  }
                  break;
               case 114595:
                  if (var4.equals("tap")) {
                     var6 = 2;
                  }
                  break;
               case 97604824:
                  if (var4.equals("focus")) {
                     var6 = 3;
                  }
                  break;
               case 114203431:
                  if (var4.equals("longPress")) {
                     var6 = 4;
                  }
               }

               Integer var8;
               String var9;
               switch(var6) {
               case 0:
                  var9 = (String)var5.get("message");
                  if (var9 != null) {
                     a.this.c.c(var9);
                  }
                  break;
               case 1:
                  var9 = (String)var5.get("message");
                  if (var9 != null) {
                     a.this.c.f(var9);
                  }
                  break;
               case 2:
                  var8 = (Integer)var3.get("nodeId");
                  if (var8 != null) {
                     a.this.c.g(var8);
                  }
                  break;
               case 3:
                  var8 = (Integer)var3.get("nodeId");
                  if (var8 != null) {
                     a.this.c.d(var8);
                  }
                  break;
               case 4:
                  var8 = (Integer)var3.get("nodeId");
                  if (var8 != null) {
                     a.this.c.e(var8);
                  }
               }

               var2.a((Object)null);
            }
         }
      };
      this.d = var3;
      k0.a var4 = new k0.a(var1, "flutter/accessibility", k0.o.a);
      this.a = var4;
      var4.e(var3);
      this.b = var2;
   }

   public void b(int var1, io.flutter.view.h.g var2) {
      this.b.dispatchSemanticsAction(var1, var2);
   }

   public void c(int var1, io.flutter.view.h.g var2, Object var3) {
      this.b.dispatchSemanticsAction(var1, var2, var3);
   }

   public void d() {
      this.b.setSemanticsEnabled(false);
   }

   public void e() {
      this.b.setSemanticsEnabled(true);
   }

   public void f(int var1) {
      this.b.setAccessibilityFeatures(var1);
   }

   public void g(a.b var1) {
      this.c = var1;
      this.b.setAccessibilityDelegate(var1);
   }

   public interface b extends FlutterJNI.a {
      void c(String var1);

      void d(int var1);

      void e(int var1);

      void f(String var1);

      void g(int var1);
   }
}
