package k0;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements j {
   public static final e a = new e();

   private e() {
   }

   public ByteBuffer a(Object var1) {
      return d.a.b((new JSONArray()).put(f.a(var1)));
   }

   public ByteBuffer b(h var1) {
      try {
         JSONObject var2 = new JSONObject();
         var2.put("method", var1.a);
         var2.put("args", f.a(var1.b));
         ByteBuffer var4 = d.a.b(var2);
         return var4;
      } catch (JSONException var3) {
         throw new IllegalArgumentException("Invalid JSON", var3);
      }
   }

   public h c(ByteBuffer var1) {
      try {
         Object var5 = d.a.a(var1);
         if (var5 instanceof JSONObject) {
            JSONObject var2 = (JSONObject)var5;
            Object var3 = var2.get("method");
            Object var6 = this.g(var2.opt("args"));
            if (var3 instanceof String) {
               return new h((String)var3, var6);
            }
         }

         StringBuilder var7 = new StringBuilder();
         var7.append("Invalid method call: ");
         var7.append(var5);
         IllegalArgumentException var8 = new IllegalArgumentException(var7.toString());
         throw var8;
      } catch (JSONException var4) {
         throw new IllegalArgumentException("Invalid JSON", var4);
      }
   }

   public Object d(ByteBuffer var1) {
      JSONException var10000;
      label47: {
         Object var3;
         Object var4;
         Object var13;
         boolean var10001;
         label46: {
            Object var10;
            label49: {
               JSONArray var2;
               try {
                  var10 = d.a.a(var1);
                  if (!(var10 instanceof JSONArray)) {
                     break label49;
                  }

                  var2 = (JSONArray)var10;
                  if (var2.length() == 1) {
                     return this.g(var2.opt(0));
                  }
               } catch (JSONException var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label47;
               }

               try {
                  if (var2.length() != 3) {
                     break label49;
                  }

                  var3 = var2.get(0);
                  var4 = this.g(var2.opt(1));
                  var13 = this.g(var2.opt(2));
                  if (!(var3 instanceof String)) {
                     break label49;
                  }
               } catch (JSONException var8) {
                  var10000 = var8;
                  var10001 = false;
                  break label47;
               }

               if (var4 == null) {
                  break label46;
               }

               try {
                  if (var4 instanceof String) {
                     break label46;
                  }
               } catch (JSONException var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label47;
               }
            }

            try {
               StringBuilder var14 = new StringBuilder();
               var14.append("Invalid envelope: ");
               var14.append(var10);
               IllegalArgumentException var15 = new IllegalArgumentException(var14.toString());
               throw var15;
            } catch (JSONException var6) {
               var10000 = var6;
               var10001 = false;
               break label47;
            }
         }

         try {
            c var11 = new c((String)var3, (String)var4, var13);
            throw var11;
         } catch (JSONException var5) {
            var10000 = var5;
            var10001 = false;
         }
      }

      JSONException var12 = var10000;
      throw new IllegalArgumentException("Invalid JSON", var12);
   }

   public ByteBuffer e(String var1, String var2, Object var3, String var4) {
      return d.a.b((new JSONArray()).put(var1).put(f.a(var2)).put(f.a(var3)).put(f.a(var4)));
   }

   public ByteBuffer f(String var1, String var2, Object var3) {
      return d.a.b((new JSONArray()).put(var1).put(f.a(var2)).put(f.a(var3)));
   }

   Object g(Object var1) {
      Object var2 = var1;
      if (var1 == JSONObject.NULL) {
         var2 = null;
      }

      return var2;
   }
}
