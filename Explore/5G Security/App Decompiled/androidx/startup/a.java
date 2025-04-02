package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.b;
import k.c;

public final class a {
   private static volatile a d;
   private static final Object e = new Object();
   final Map<Class<?>, Object> a;
   final Set<Class<? extends k.a<?>>> b;
   final Context c;

   a(Context var1) {
      this.c = var1.getApplicationContext();
      this.b = new HashSet();
      this.a = new HashMap();
   }

   private <T> T c(Class<? extends k.a<?>> var1, Set<Class<?>> var2) {
      Object var78;
      label720: {
         Throwable var10000;
         label722: {
            boolean var10001;
            if (l.a.h()) {
               try {
                  l.a.c(var1.getSimpleName());
               } catch (Throwable var77) {
                  var10000 = var77;
                  var10001 = false;
                  break label722;
               }
            }

            label723: {
               label713: {
                  try {
                     if (var2.contains(var1)) {
                        break label723;
                     }

                     if (!this.a.containsKey(var1)) {
                        var2.add(var1);
                        break label713;
                     }
                  } catch (Throwable var76) {
                     var10000 = var76;
                     var10001 = false;
                     break label722;
                  }

                  try {
                     var78 = this.a.get(var1);
                     break label720;
                  } catch (Throwable var75) {
                     var10000 = var75;
                     var10001 = false;
                     break label722;
                  }
               }

               label725: {
                  k.a var3;
                  label699: {
                     Iterator var5;
                     try {
                        var3 = (k.a)var1.getDeclaredConstructor().newInstance();
                        List var4 = var3.a();
                        if (var4.isEmpty()) {
                           break label699;
                        }

                        var5 = var4.iterator();
                     } catch (Throwable var73) {
                        var10000 = var73;
                        var10001 = false;
                        break label725;
                     }

                     label698:
                     while(true) {
                        try {
                           Class var85;
                           do {
                              if (!var5.hasNext()) {
                                 break label698;
                              }

                              var85 = (Class)var5.next();
                           } while(this.a.containsKey(var85));

                           this.c(var85, var2);
                        } catch (Throwable var74) {
                           var10000 = var74;
                           var10001 = false;
                           break label725;
                        }
                     }
                  }

                  Object var84;
                  try {
                     var84 = var3.b(this.c);
                     var2.remove(var1);
                     this.a.put(var1, var84);
                  } catch (Throwable var72) {
                     var10000 = var72;
                     var10001 = false;
                     break label725;
                  }

                  var78 = var84;
                  break label720;
               }

               Throwable var80 = var10000;

               try {
                  c var79 = new c(var80);
                  throw var79;
               } catch (Throwable var70) {
                  var10000 = var70;
                  var10001 = false;
                  break label722;
               }
            }

            label680:
            try {
               String var82 = String.format("Cannot initialize %s. Cycle detected.", var1.getName());
               IllegalStateException var83 = new IllegalStateException(var82);
               throw var83;
            } catch (Throwable var71) {
               var10000 = var71;
               var10001 = false;
               break label680;
            }
         }

         Throwable var81 = var10000;
         l.a.f();
         throw var81;
      }

      l.a.f();
      return var78;
   }

   public static a d(Context var0) {
      if (d == null) {
         Object var1 = e;
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label144: {
            try {
               if (d == null) {
                  a var2 = new a(var0);
                  d = var2;
               }
            } catch (Throwable var14) {
               var10000 = var14;
               var10001 = false;
               break label144;
            }

            label141:
            try {
               return d;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label141;
            }
         }

         while(true) {
            Throwable var15 = var10000;

            try {
               throw var15;
            } catch (Throwable var12) {
               var10000 = var12;
               var10001 = false;
               continue;
            }
         }
      } else {
         return d;
      }
   }

   void a() {
      try {
         l.a.c("Startup");
         ComponentName var1 = new ComponentName(this.c.getPackageName(), InitializationProvider.class.getName());
         this.b(this.c.getPackageManager().getProviderInfo(var1, 128).metaData);
      } catch (NameNotFoundException var5) {
         c var2 = new c(var5);
         throw var2;
      } finally {
         l.a.f();
      }

   }

   void b(Bundle var1) {
      String var2 = this.c.getString(k.b.a);
      if (var1 != null) {
         ClassNotFoundException var10000;
         label57: {
            HashSet var3;
            Iterator var4;
            boolean var10001;
            try {
               var3 = new HashSet();
               var4 = var1.keySet().iterator();
            } catch (ClassNotFoundException var8) {
               var10000 = var8;
               var10001 = false;
               break label57;
            }

            while(true) {
               try {
                  if (!var4.hasNext()) {
                     break;
                  }

                  String var5 = (String)var4.next();
                  if (var2.equals(var1.getString(var5, (String)null))) {
                     Class var12 = Class.forName(var5);
                     if (k.a.class.isAssignableFrom(var12)) {
                        this.b.add(var12);
                     }
                  }
               } catch (ClassNotFoundException var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label57;
               }
            }

            Iterator var10;
            try {
               var10 = this.b.iterator();
            } catch (ClassNotFoundException var7) {
               var10000 = var7;
               var10001 = false;
               break label57;
            }

            while(true) {
               try {
                  if (!var10.hasNext()) {
                     return;
                  }

                  this.c((Class)var10.next(), var3);
               } catch (ClassNotFoundException var6) {
                  var10000 = var6;
                  var10001 = false;
                  break;
               }
            }
         }

         ClassNotFoundException var11 = var10000;
         throw new c(var11);
      }
   }

   public boolean e(Class<? extends k.a<?>> var1) {
      return this.b.contains(var1);
   }
}
