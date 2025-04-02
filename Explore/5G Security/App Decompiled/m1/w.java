package m1;

import h1.r1;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public final class w {
   public static final w a;
   private static final boolean b;
   public static final r1 c;

   static {
      w var0 = new w();
      a = var0;
      b = i0.f("kotlinx.coroutines.fast.service.loader", true);
      c = var0.a();
   }

   private w() {
   }

   private final r1 a() {
      Object var3;
      Throwable var10000;
      label989: {
         List var1;
         boolean var10001;
         label992: {
            try {
               if (b) {
                  var1 = l.a.c();
                  break label992;
               }
            } catch (Throwable var118) {
               var10000 = var118;
               var10001 = false;
               break label989;
            }

            try {
               var1 = f1.c.e(f1.c.a(ServiceLoader.load(v.class, v.class.getClassLoader()).iterator()));
            } catch (Throwable var117) {
               var10000 = var117;
               var10001 = false;
               break label989;
            }
         }

         label975: {
            label993: {
               Iterator var2;
               try {
                  var2 = var1.iterator();
                  if (!var2.hasNext()) {
                     break label993;
                  }
               } catch (Throwable var116) {
                  var10000 = var116;
                  var10001 = false;
                  break label989;
               }

               label967:
               try {
                  var3 = var2.next();
                  if (var2.hasNext()) {
                     break label967;
                  }
                  break label975;
               } catch (Throwable var115) {
                  var10000 = var115;
                  var10001 = false;
                  break label989;
               }

               int var4;
               try {
                  var4 = ((v)var3).a();
               } catch (Throwable var113) {
                  var10000 = var113;
                  var10001 = false;
                  break label989;
               }

               Object var5 = var3;

               while(true) {
                  Object var6;
                  int var7;
                  try {
                     var6 = var2.next();
                     var7 = ((v)var6).a();
                  } catch (Throwable var112) {
                     var10000 = var112;
                     var10001 = false;
                     break label989;
                  }

                  var3 = var5;
                  int var8 = var4;
                  if (var4 < var7) {
                     var3 = var6;
                     var8 = var7;
                  }

                  var5 = var3;
                  var4 = var8;

                  try {
                     if (!var2.hasNext()) {
                        break label975;
                     }
                  } catch (Throwable var114) {
                     var10000 = var114;
                     var10001 = false;
                     break label989;
                  }
               }
            }

            var3 = null;
         }

         v var120;
         try {
            var120 = (v)var3;
         } catch (Throwable var111) {
            var10000 = var111;
            var10001 = false;
            break label989;
         }

         if (var120 != null) {
            r1 var119;
            try {
               var119 = x.e(var120, var1);
            } catch (Throwable var110) {
               var10000 = var110;
               var10001 = false;
               break label989;
            }

            var3 = var119;
            if (var119 != null) {
               return (r1)var3;
            }
         }

         label942:
         try {
            var3 = x.b((Throwable)null, (String)null, 3, (Object)null);
            return (r1)var3;
         } catch (Throwable var109) {
            var10000 = var109;
            var10001 = false;
            break label942;
         }
      }

      Throwable var121 = var10000;
      var3 = x.b(var121, (String)null, 2, (Object)null);
      return (r1)var3;
   }
}
