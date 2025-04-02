package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;

public final class g {
   private CharSequence a;
   private CharSequence b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;

   public g(CharSequence var1, int var2, int var3, int var4, int var5) {
      this.e = var2;
      this.f = var3;
      this.g = var4;
      this.h = var5;
      this.a(var1, "", -1, -1);
   }

   public g(CharSequence var1, int var2, int var3, CharSequence var4, int var5, int var6, int var7, int var8) {
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.a(var1, var4.toString(), var2, var3);
   }

   private void a(CharSequence var1, CharSequence var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public JSONObject b() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("oldText", this.a.toString());
         var1.put("deltaText", this.b.toString());
         var1.put("deltaStart", this.c);
         var1.put("deltaEnd", this.d);
         var1.put("selectionBase", this.e);
         var1.put("selectionExtent", this.f);
         var1.put("composingBase", this.g);
         var1.put("composingExtent", this.h);
      } catch (JSONException var4) {
         StringBuilder var3 = new StringBuilder();
         var3.append("unable to create JSONObject: ");
         var3.append(var4);
         y.b.b("TextEditingDelta", var3.toString());
      }

      return var1;
   }
}
