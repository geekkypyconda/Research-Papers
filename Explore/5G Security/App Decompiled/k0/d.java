package k0;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class d implements g<Object> {
   public static final d a = new d();

   private d() {
   }

   public Object a(ByteBuffer var1) {
      if (var1 == null) {
         return null;
      } else {
         try {
            String var2 = q.b.c(var1);
            JSONTokener var4 = new JSONTokener(var2);
            Object var6 = var4.nextValue();
            if (!var4.more()) {
               return var6;
            } else {
               IllegalArgumentException var5 = new IllegalArgumentException("Invalid JSON");
               throw var5;
            }
         } catch (JSONException var3) {
            throw new IllegalArgumentException("Invalid JSON", var3);
         }
      }
   }

   public ByteBuffer b(Object var1) {
      if (var1 == null) {
         return null;
      } else {
         var1 = f.a(var1);
         q var2;
         String var3;
         if (var1 instanceof String) {
            var2 = q.b;
            var3 = JSONObject.quote((String)var1);
         } else {
            var2 = q.b;
            var3 = var1.toString();
         }

         return var2.d(var3);
      }
   }
}
