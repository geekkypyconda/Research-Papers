package b0;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import o0.f;

public class d {
   private boolean a;
   private d.c b;
   private long c;
   private b0.b d;
   private FlutterJNI e;
   private ExecutorService f;
   Future<d.b> g;

   public d() {
      this(y.a.e().d().a());
   }

   public d(FlutterJNI var1) {
      this(var1, y.a.e().b());
   }

   public d(FlutterJNI var1, ExecutorService var2) {
      this.a = false;
      this.e = var1;
      this.f = var2;
   }

   // $FF: synthetic method
   static e a(d var0, Context var1) {
      var0.h(var1);
      return null;
   }

   // $FF: synthetic method
   static b0.b c(d var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static ExecutorService d(d var0) {
      return var0.f;
   }

   private e h(Context var1) {
      return null;
   }

   private static boolean j(Bundle var0) {
      return var0 == null ? true : var0.getBoolean("io.flutter.embedding.android.LeakVM", true);
   }

   public boolean e() {
      return this.d.g;
   }

   public void f(Context var1, String[] var2) {
      if (!this.a) {
         if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
         } else if (this.b != null) {
            Exception var10000;
            label3027: {
               f var3;
               boolean var10001;
               try {
                  var3 = o0.f.f("FlutterLoader#ensureInitializationComplete");
               } catch (Exception var391) {
                  var10000 = var391;
                  var10001 = false;
                  break label3027;
               }

               label3028: {
                  Throwable var402;
                  label3029: {
                     d.b var4;
                     ArrayList var5;
                     StringBuilder var6;
                     String var7;
                     try {
                        var4 = (d.b)this.g.get();
                        var5 = new ArrayList();
                        var5.add("--icu-symbol-prefix=_binary_icudtl_dat");
                        var6 = new StringBuilder();
                        var6.append("--icu-native-lib-path=");
                        var6.append(this.d.f);
                        var7 = File.separator;
                        var6.append(var7);
                        var6.append("libflutter.so");
                        var5.add(var6.toString());
                     } catch (Throwable var390) {
                        var402 = var390;
                        var10001 = false;
                        break label3029;
                     }

                     if (var2 != null) {
                        try {
                           Collections.addAll(var5, var2);
                        } catch (Throwable var389) {
                           var402 = var389;
                           var10001 = false;
                           break label3029;
                        }
                     }

                     StringBuilder var394;
                     try {
                        var394 = new StringBuilder();
                        var394.append("--aot-shared-library-name=");
                        var394.append(this.d.a);
                        var5.add(var394.toString());
                        var394 = new StringBuilder();
                        var394.append("--aot-shared-library-name=");
                        var394.append(this.d.f);
                        var394.append(var7);
                        var394.append(this.d.a);
                        var5.add(var394.toString());
                        var394 = new StringBuilder();
                        var394.append("--cache-dir-path=");
                        var394.append(var4.b);
                        var5.add(var394.toString());
                        if (this.d.e != null) {
                           var394 = new StringBuilder();
                           var394.append("--domain-network-policy=");
                           var394.append(this.d.e);
                           var5.add(var394.toString());
                        }
                     } catch (Throwable var388) {
                        var402 = var388;
                        var10001 = false;
                        break label3029;
                     }

                     try {
                        if (this.b.a() != null) {
                           var394 = new StringBuilder();
                           var394.append("--log-tag=");
                           var394.append(this.b.a());
                           var5.add(var394.toString());
                        }
                     } catch (Throwable var387) {
                        var402 = var387;
                        var10001 = false;
                        break label3029;
                     }

                     Bundle var395;
                     try {
                        var395 = var1.getPackageManager().getApplicationInfo(var1.getPackageName(), 128).metaData;
                     } catch (Throwable var386) {
                        var402 = var386;
                        var10001 = false;
                        break label3029;
                     }

                     int var8;
                     if (var395 != null) {
                        try {
                           var8 = var395.getInt("io.flutter.embedding.android.OldGenHeapSize");
                        } catch (Throwable var385) {
                           var402 = var385;
                           var10001 = false;
                           break label3029;
                        }
                     } else {
                        var8 = 0;
                     }

                     int var9 = var8;
                     if (var8 == 0) {
                        try {
                           ActivityManager var399 = (ActivityManager)var1.getSystemService("activity");
                           MemoryInfo var398 = new MemoryInfo();
                           var399.getMemoryInfo(var398);
                           var9 = (int)((double)var398.totalMem / 1000000.0D / 2.0D);
                        } catch (Throwable var384) {
                           var402 = var384;
                           var10001 = false;
                           break label3029;
                        }
                     }

                     StringBuilder var400;
                     try {
                        var400 = new StringBuilder();
                        var400.append("--old-gen-heap-size=");
                        var400.append(var9);
                        var5.add(var400.toString());
                        DisplayMetrics var401 = var1.getResources().getDisplayMetrics();
                        var8 = var401.widthPixels;
                        var9 = var401.heightPixels;
                        var400 = new StringBuilder();
                        var400.append("--resource-cache-max-bytes-threshold=");
                        var400.append(var8 * var9 * 12 * 4);
                        var5.add(var400.toString());
                        var5.add("--prefetched-default-font-manager");
                     } catch (Throwable var383) {
                        var402 = var383;
                        var10001 = false;
                        break label3029;
                     }

                     if (var395 != null) {
                        try {
                           if (var395.getBoolean("io.flutter.embedding.android.EnableImpeller", false)) {
                              var5.add("--enable-impeller");
                           }
                        } catch (Throwable var380) {
                           var402 = var380;
                           var10001 = false;
                           break label3029;
                        }

                        try {
                           if (var395.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                              var5.add("--enable-vulkan-validation");
                           }
                        } catch (Throwable var382) {
                           var402 = var382;
                           var10001 = false;
                           break label3029;
                        }

                        try {
                           if (var395.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                              var5.add("--enable-opengl-gpu-tracing");
                           }
                        } catch (Throwable var379) {
                           var402 = var379;
                           var10001 = false;
                           break label3029;
                        }

                        try {
                           if (var395.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                              var5.add("--enable-vulkan-gpu-tracing");
                           }
                        } catch (Throwable var381) {
                           var402 = var381;
                           var10001 = false;
                           break label3029;
                        }

                        try {
                           var7 = var395.getString("io.flutter.embedding.android.ImpellerBackend");
                        } catch (Throwable var378) {
                           var402 = var378;
                           var10001 = false;
                           break label3029;
                        }

                        if (var7 != null) {
                           try {
                              var6 = new StringBuilder();
                              var6.append("--impeller-backend=");
                              var6.append(var7);
                              var5.add(var6.toString());
                           } catch (Throwable var377) {
                              var402 = var377;
                              var10001 = false;
                              break label3029;
                           }
                        }
                     }

                     String var396;
                     label2964: {
                        label2963: {
                           try {
                              if (j(var395)) {
                                 break label2963;
                              }
                           } catch (Throwable var376) {
                              var402 = var376;
                              var10001 = false;
                              break label3029;
                           }

                           var396 = "false";
                           break label2964;
                        }

                        var396 = "true";
                     }

                     label2957:
                     try {
                        var400 = new StringBuilder();
                        var400.append("--leak-vm=");
                        var400.append(var396);
                        var5.add(var400.toString());
                        long var10 = SystemClock.uptimeMillis();
                        long var12 = this.c;
                        this.e.init(var1, (String[])var5.toArray(new String[0]), (String)null, var4.a, var4.b, var10 - var12);
                        this.a = true;
                        break label3028;
                     } catch (Throwable var375) {
                        var402 = var375;
                        var10001 = false;
                        break label2957;
                     }
                  }

                  Throwable var392 = var402;
                  if (var3 != null) {
                     try {
                        var3.close();
                     } catch (Throwable var373) {
                        Throwable var397 = var373;

                        label2945:
                        try {
                           var392.addSuppressed(var397);
                           break label2945;
                        } catch (Exception var372) {
                           var10000 = var372;
                           var10001 = false;
                           break label3027;
                        }
                     }
                  }

                  try {
                     throw var392;
                  } catch (Exception var371) {
                     var10000 = var371;
                     var10001 = false;
                     break label3027;
                  }
               }

               if (var3 == null) {
                  return;
               }

               try {
                  var3.close();
                  return;
               } catch (Exception var374) {
                  var10000 = var374;
                  var10001 = false;
               }
            }

            Exception var393 = var10000;
            y.b.c("FlutterLoader", "Flutter initialization failed.", var393);
            throw new RuntimeException(var393);
         } else {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
         }
      }
   }

   public String g() {
      return this.d.d;
   }

   public boolean i() {
      return this.a;
   }

   public void k(Context var1) {
      this.l(var1, new d.c());
   }

   public void l(final Context var1, d.c var2) {
      if (this.b == null) {
         if (Looper.myLooper() == Looper.getMainLooper()) {
            f var3 = o0.f.f("FlutterLoader#startInitialization");

            try {
               var1 = var1.getApplicationContext();
               this.b = var2;
               this.c = SystemClock.uptimeMillis();
               this.d = b0.a.e(var1);
               t.f((DisplayManager)var1.getSystemService("display"), this.e).g();
               Callable var10 = new Callable<d.b>() {
                  // $FF: synthetic method
                  public static void a(Object var0) {
                     var0.c();
                  }

                  // $FF: synthetic method
                  private void c() {
                     d.this.e.prefetchDefaultFontManager();
                  }

                  public d.b b() {
                     // $FF: Couldn't be decompiled
                  }
               };
               this.g = this.f.submit(var10);
            } catch (Throwable var9) {
               if (var3 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var8) {
                     var9.addSuppressed(var8);
                     throw var9;
                  }
               }

               throw var9;
            }

            if (var3 != null) {
               var3.close();
            }

         } else {
            throw new IllegalStateException("startInitialization must be called on the main thread");
         }
      }
   }

   private static class b {
      final String a;
      final String b;
      final String c;

      private b(String var1, String var2, String var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      b(String var1, String var2, String var3, Object var4) {
         this(var1, var2, var3);
      }
   }

   public static class c {
      private String a;

      public String a() {
         return this.a;
      }
   }
}
