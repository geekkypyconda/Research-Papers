package j0;

import java.util.HashMap;

public class i {
   public final k0.i a;
   private i.b b;
   private final k0.i.c c;

   public i(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h var1, k0.i.d var2) {
            if (i.this.b != null) {
               String var3 = var1.a;
               StringBuilder var4 = new StringBuilder();
               var4.append("Received '");
               var4.append(var3);
               var4.append("' message.");
               y.b.f("MouseCursorChannel", var4.toString());
               byte var5 = -1;

               Exception var10000;
               label63: {
                  boolean var10001;
                  label64: {
                     try {
                        if (var3.hashCode() != -1307105544) {
                           break label64;
                        }
                     } catch (Exception var11) {
                        var10000 = var11;
                        var10001 = false;
                        break label63;
                     }

                     try {
                        if (!var3.equals("activateSystemCursor")) {
                           break label64;
                        }
                     } catch (Exception var10) {
                        var10000 = var10;
                        var10001 = false;
                        break label63;
                     }

                     var5 = 0;
                  }

                  if (var5 != 0) {
                     return;
                  }

                  String var12;
                  try {
                     var12 = (String)((HashMap)var1.b).get("kind");
                  } catch (Exception var9) {
                     var10000 = var9;
                     var10001 = false;
                     break label63;
                  }

                  try {
                     i.this.b.a(var12);
                  } catch (Exception var8) {
                     Exception var13 = var8;

                     try {
                        StringBuilder var15 = new StringBuilder();
                        var15.append("Error when setting cursors: ");
                        var15.append(var13.getMessage());
                        var2.a("error", var15.toString(), (Object)null);
                        return;
                     } catch (Exception var6) {
                        var10000 = var6;
                        var10001 = false;
                        break label63;
                     }
                  }

                  try {
                     var2.b(Boolean.TRUE);
                     return;
                  } catch (Exception var7) {
                     var10000 = var7;
                     var10001 = false;
                  }
               }

               Exception var16 = var10000;
               StringBuilder var14 = new StringBuilder();
               var14.append("Unhandled error: ");
               var14.append(var16.getMessage());
               var2.a("error", var14.toString(), (Object)null);
            }
         }
      };
      this.c = var2;
      k0.i var3 = new k0.i(var1, "flutter/mousecursor", k0.p.b);
      this.a = var3;
      var3.e(var2);
   }

   public void b(i.b var1) {
      this.b = var1;
   }

   public interface b {
      void a(String var1);
   }
}
