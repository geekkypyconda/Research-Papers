package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

public class e {
   private static volatile e b;
   private final Map<String, d> a = new HashMap();

   e() {
   }

   public static e b() {
      if (b == null) {
         synchronized(e.class){}

         Throwable var10000;
         boolean var10001;
         label144: {
            try {
               if (b == null) {
                  e var0 = new e();
                  b = var0;
               }
            } catch (Throwable var12) {
               var10000 = var12;
               var10001 = false;
               break label144;
            }

            label141:
            try {
               return b;
            } catch (Throwable var11) {
               var10000 = var11;
               var10001 = false;
               break label141;
            }
         }

         while(true) {
            Throwable var13 = var10000;

            try {
               throw var13;
            } catch (Throwable var10) {
               var10000 = var10;
               var10001 = false;
               continue;
            }
         }
      } else {
         return b;
      }
   }

   public d a(String var1) {
      return (d)this.a.get(var1);
   }
}
