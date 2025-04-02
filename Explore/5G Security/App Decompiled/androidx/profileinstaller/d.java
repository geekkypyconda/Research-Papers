package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class d {
   private final AssetManager a;
   private final Executor b;
   private final j.c c;
   private final byte[] d;
   private final File e;
   private final String f;
   private final String g;
   private final String h;
   private boolean i = false;
   private e[] j;
   private byte[] k;

   public d(AssetManager var1, Executor var2, j.c var3, String var4, String var5, String var6, File var7) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.e = var7;
      this.d = d();
   }

   // $FF: synthetic method
   public static void a(d var0, int var1, Object var2) {
      var0.g(var1, var2);
   }

   private d b(e[] var1, byte[] var2) {
      byte var4;
      Object var57;
      j.c var59;
      label216: {
         FileNotFoundException var61;
         label215: {
            IOException var60;
            label214: {
               IllegalStateException var10000;
               label213: {
                  InputStream var3;
                  boolean var10001;
                  try {
                     var3 = this.h(this.a, this.h);
                  } catch (FileNotFoundException var53) {
                     var61 = var53;
                     var10001 = false;
                     break label215;
                  } catch (IOException var54) {
                     var60 = var54;
                     var10001 = false;
                     break label214;
                  } catch (IllegalStateException var55) {
                     var10000 = var55;
                     var10001 = false;
                     break label213;
                  }

                  if (var3 != null) {
                     label206: {
                        try {
                           this.j = o.q(var3, o.o(var3, o.b), var2, var1);
                        } catch (Throwable var49) {
                           Throwable var56 = var49;

                           try {
                              var3.close();
                           } catch (Throwable var45) {
                              Throwable var58 = var45;

                              label196:
                              try {
                                 var56.addSuppressed(var58);
                                 break label196;
                              } catch (FileNotFoundException var42) {
                                 var61 = var42;
                                 var10001 = false;
                                 break label215;
                              } catch (IOException var43) {
                                 var60 = var43;
                                 var10001 = false;
                                 break label214;
                              } catch (IllegalStateException var44) {
                                 var10000 = var44;
                                 var10001 = false;
                                 break label206;
                              }
                           }

                           try {
                              throw var56;
                           } catch (FileNotFoundException var39) {
                              var61 = var39;
                              var10001 = false;
                              break label215;
                           } catch (IOException var40) {
                              var60 = var40;
                              var10001 = false;
                              break label214;
                           } catch (IllegalStateException var41) {
                              var10000 = var41;
                              var10001 = false;
                              break label206;
                           }
                        }

                        try {
                           var3.close();
                           return this;
                        } catch (FileNotFoundException var46) {
                           var61 = var46;
                           var10001 = false;
                           break label215;
                        } catch (IOException var47) {
                           var60 = var47;
                           var10001 = false;
                           break label214;
                        } catch (IllegalStateException var48) {
                           var10000 = var48;
                           var10001 = false;
                        }
                     }
                  } else {
                     if (var3 == null) {
                        return null;
                     }

                     try {
                        var3.close();
                        return null;
                     } catch (FileNotFoundException var50) {
                        var61 = var50;
                        var10001 = false;
                        break label215;
                     } catch (IOException var51) {
                        var60 = var51;
                        var10001 = false;
                        break label214;
                     } catch (IllegalStateException var52) {
                        var10000 = var52;
                        var10001 = false;
                     }
                  }
               }

               var57 = var10000;
               this.j = null;
               var59 = this.c;
               var4 = 8;
               break label216;
            }

            var57 = var60;
            var59 = this.c;
            var4 = 7;
            break label216;
         }

         var57 = var61;
         var59 = this.c;
         var4 = 9;
      }

      var59.b(var4, var57);
      return null;
   }

   private void c() {
      if (!this.i) {
         throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
      }
   }

   private static byte[] d() {
      int var0 = VERSION.SDK_INT;
      if (var0 >= 24 && var0 <= 34) {
         switch(var0) {
         case 24:
         case 25:
            return q.e;
         case 26:
            return q.d;
         case 27:
            return q.c;
         case 28:
         case 29:
         case 30:
            return q.b;
         case 31:
         case 32:
         case 33:
         case 34:
            return q.a;
         default:
            return null;
         }
      } else {
         return null;
      }
   }

   private InputStream f(AssetManager var1) {
      j.c var2;
      byte var3;
      Object var6;
      InputStream var7;
      try {
         var7 = this.h(var1, this.g);
         return var7;
      } catch (FileNotFoundException var4) {
         var6 = var4;
         var2 = this.c;
         var3 = 6;
      } catch (IOException var5) {
         var6 = var5;
         var2 = this.c;
         var3 = 7;
      }

      var2.b(var3, var6);
      var7 = null;
      return var7;
   }

   // $FF: synthetic method
   private void g(int var1, Object var2) {
      this.c.b(var1, var2);
   }

   private InputStream h(AssetManager var1, String var2) {
      Object var3 = null;

      FileInputStream var5;
      try {
         var5 = var1.openFd(var2).createInputStream();
      } catch (FileNotFoundException var4) {
         var2 = var4.getMessage();
         var5 = (FileInputStream)var3;
         if (var2 != null) {
            var5 = (FileInputStream)var3;
            if (var2.contains("compressed")) {
               this.c.a(5, (Object)null);
               var5 = (FileInputStream)var3;
            }
         }
      }

      return var5;
   }

   private e[] j(InputStream var1) {
      e[] var40;
      e[] var43;
      label239: {
         Throwable var10000;
         label249: {
            label233: {
               IOException var44;
               label240: {
                  IOException var41;
                  boolean var10001;
                  label241: {
                     IllegalStateException var2;
                     try {
                        try {
                           var43 = o.w(var1, o.o(var1, o.a), this.f);
                           break label239;
                        } catch (IOException var36) {
                           var41 = var36;
                           break label241;
                        } catch (IllegalStateException var37) {
                           var2 = var37;
                        }
                     } catch (Throwable var38) {
                        var10000 = var38;
                        var10001 = false;
                        break label249;
                     }

                     try {
                        this.c.b(8, var2);
                     } catch (Throwable var33) {
                        var10000 = var33;
                        var10001 = false;
                        break label249;
                     }

                     try {
                        var1.close();
                        break label233;
                     } catch (IOException var35) {
                        var44 = var35;
                        var10001 = false;
                        break label240;
                     }
                  }

                  try {
                     this.c.b(7, var41);
                  } catch (Throwable var32) {
                     var10000 = var32;
                     var10001 = false;
                     break label249;
                  }

                  try {
                     var1.close();
                     break label233;
                  } catch (IOException var34) {
                     var44 = var34;
                     var10001 = false;
                  }
               }

               IOException var39 = var44;
               this.c.b(7, var39);
            }

            var40 = null;
            return var40;
         }

         Throwable var42 = var10000;

         try {
            var1.close();
         } catch (IOException var30) {
            this.c.b(7, var30);
         }

         throw var42;
      }

      try {
         var1.close();
      } catch (IOException var31) {
         this.c.b(7, var31);
         var40 = var43;
         return var40;
      }

      var40 = var43;
      return var40;
   }

   private static boolean k() {
      int var0 = VERSION.SDK_INT;
      if (var0 >= 24 && var0 <= 34) {
         if (var0 != 24 && var0 != 25) {
            switch(var0) {
            case 31:
            case 32:
            case 33:
            case 34:
               break;
            default:
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private void l(int var1, Object var2) {
      this.b.execute(new c(this, var1, var2));
   }

   public boolean e() {
      if (this.d == null) {
         this.l(3, VERSION.SDK_INT);
         return false;
      } else {
         if (this.e.exists()) {
            if (!this.e.canWrite()) {
               this.l(4, (Object)null);
               return false;
            }
         } else {
            try {
               this.e.createNewFile();
            } catch (IOException var2) {
               this.l(4, (Object)null);
               return false;
            }
         }

         this.i = true;
         return true;
      }
   }

   public d i() {
      this.c();
      if (this.d == null) {
         return this;
      } else {
         InputStream var1 = this.f(this.a);
         if (var1 != null) {
            this.j = this.j(var1);
         }

         e[] var2 = this.j;
         if (var2 != null && k()) {
            d var3 = this.b(var2, this.d);
            if (var3 != null) {
               return var3;
            }
         }

         return this;
      }
   }

   public d m() {
      e[] var1 = this.j;
      byte[] var2 = this.d;
      if (var1 != null && var2 != null) {
         this.c();

         label334: {
            byte var4;
            j.c var58;
            Object var60;
            label333: {
               IOException var61;
               label332: {
                  IllegalStateException var10000;
                  label339: {
                     ByteArrayOutputStream var3;
                     boolean var10001;
                     try {
                        var3 = new ByteArrayOutputStream();
                     } catch (IOException var55) {
                        var61 = var55;
                        var10001 = false;
                        break label332;
                     } catch (IllegalStateException var56) {
                        var10000 = var56;
                        var10001 = false;
                        break label339;
                     }

                     Throwable var62;
                     label340: {
                        label326: {
                           try {
                              o.E(var3, var2);
                              if (o.B(var3, var2, var1)) {
                                 break label326;
                              }

                              this.c.b(5, (Object)null);
                              this.j = null;
                           } catch (Throwable var54) {
                              var62 = var54;
                              var10001 = false;
                              break label340;
                           }

                           try {
                              var3.close();
                              return this;
                           } catch (IOException var49) {
                              var61 = var49;
                              var10001 = false;
                              break label332;
                           } catch (IllegalStateException var50) {
                              var10000 = var50;
                              var10001 = false;
                              break label339;
                           }
                        }

                        try {
                           this.k = var3.toByteArray();
                        } catch (Throwable var53) {
                           var62 = var53;
                           var10001 = false;
                           break label340;
                        }

                        try {
                           var3.close();
                           break label334;
                        } catch (IOException var51) {
                           var61 = var51;
                           var10001 = false;
                           break label332;
                        } catch (IllegalStateException var52) {
                           var10000 = var52;
                           var10001 = false;
                           break label339;
                        }
                     }

                     Throwable var57 = var62;

                     try {
                        var3.close();
                     } catch (Throwable var48) {
                        Throwable var59 = var48;

                        label307:
                        try {
                           var57.addSuppressed(var59);
                           break label307;
                        } catch (IOException var46) {
                           var61 = var46;
                           var10001 = false;
                           break label332;
                        } catch (IllegalStateException var47) {
                           var10000 = var47;
                           var10001 = false;
                           break label339;
                        }
                     }

                     try {
                        throw var57;
                     } catch (IOException var44) {
                        var61 = var44;
                        var10001 = false;
                        break label332;
                     } catch (IllegalStateException var45) {
                        var10000 = var45;
                        var10001 = false;
                     }
                  }

                  var60 = var10000;
                  var58 = this.c;
                  var4 = 8;
                  break label333;
               }

               var60 = var61;
               var58 = this.c;
               var4 = 7;
            }

            var58.b(var4, var60);
         }

         this.j = null;
      }

      return this;
   }

   public boolean n() {
      // $FF: Couldn't be decompiled
   }
}
