package io.flutter.embedding.engine.renderer;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.Builder;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.view.Surface;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import io.flutter.embedding.android.i;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterRenderer implements TextureRegistry {
   public static boolean i;
   public static boolean j;
   private final FlutterJNI a;
   private final AtomicLong b = new AtomicLong(0L);
   private Surface c;
   private boolean d = false;
   private final Handler e = new Handler();
   private final Set<WeakReference<TextureRegistry.b>> f = new HashSet();
   private final List<FlutterRenderer.ImageReaderSurfaceProducer> g = new ArrayList();
   private final io.flutter.embedding.engine.renderer.d h;

   public FlutterRenderer(FlutterJNI var1) {
      io.flutter.embedding.engine.renderer.d var2 = new io.flutter.embedding.engine.renderer.d() {
         public void d() {
            FlutterRenderer.this.d = false;
         }

         public void g() {
            FlutterRenderer.this.d = true;
         }
      };
      this.h = var2;
      this.a = var1;
      var1.addIsDisplayingFlutterUiListener(var2);
      t.n().b().a(new androidx.lifecycle.d() {
         public void a(l var1) {
            y.b.f("FlutterRenderer", "onResume called; notifying SurfaceProducers");
            Iterator var2 = FlutterRenderer.this.g.iterator();

            while(var2.hasNext()) {
               FlutterRenderer.ImageReaderSurfaceProducer var3 = (FlutterRenderer.ImageReaderSurfaceProducer)var2.next();
               if (var3.callback != null) {
                  var3.callback.b();
               }
            }

         }

         // $FF: synthetic method
         public void b(l var1) {
            androidx.lifecycle.c.b(this, var1);
         }

         // $FF: synthetic method
         public void c(l var1) {
            androidx.lifecycle.c.a(this, var1);
         }

         // $FF: synthetic method
         public void e(l var1) {
            androidx.lifecycle.c.c(this, var1);
         }

         // $FF: synthetic method
         public void f(l var1) {
            androidx.lifecycle.c.e(this, var1);
         }

         // $FF: synthetic method
         public void g(l var1) {
            androidx.lifecycle.c.d(this, var1);
         }
      });
   }

   private void D(long var1) {
      this.a.unregisterTexture(var1);
   }

   private void l() {
      Iterator var1 = this.f.iterator();

      while(var1.hasNext()) {
         if ((TextureRegistry.b)((WeakReference)var1.next()).get() == null) {
            var1.remove();
         }
      }

   }

   private void q(long var1, TextureRegistry.ImageConsumer var3) {
      this.a.registerImageTexture(var1, var3);
   }

   private TextureRegistry.SurfaceTextureEntry r(long var1, SurfaceTexture var3) {
      var3.detachFromGLContext();
      FlutterRenderer.f var5 = new FlutterRenderer.f(var1, var3);
      StringBuilder var4 = new StringBuilder();
      var4.append("New SurfaceTexture ID: ");
      var4.append(var5.id());
      y.b.f("FlutterRenderer", var4.toString());
      this.t(var5.id(), var5.f());
      this.k(var5);
      return var5;
   }

   private void t(long var1, SurfaceTextureWrapper var3) {
      this.a.registerTexture(var1, var3);
   }

   private void w() {
      this.a.scheduleFrame();
   }

   public void A() {
      if (this.c != null) {
         this.a.onSurfaceDestroyed();
         if (this.d) {
            this.h.d();
         }

         this.d = false;
         this.c = null;
      }

   }

   public void B(int var1, int var2) {
      this.a.onSurfaceChanged(var1, var2);
   }

   public void C(Surface var1) {
      this.c = var1;
      this.a.onSurfaceWindowChanged(var1);
   }

   public TextureRegistry.SurfaceProducer a() {
      Object var3;
      StringBuilder var4;
      if (!i && VERSION.SDK_INT >= 29) {
         long var1 = this.b.getAndIncrement();
         var3 = new FlutterRenderer.ImageReaderSurfaceProducer(var1);
         this.q(var1, (TextureRegistry.ImageConsumer)var3);
         this.k((TextureRegistry.b)var3);
         this.g.add(var3);
         var4 = new StringBuilder();
         var4.append("New ImageReaderSurfaceProducer ID: ");
         var4.append(var1);
         y.b.f("FlutterRenderer", var4.toString());
      } else {
         TextureRegistry.SurfaceTextureEntry var5 = this.c();
         var3 = new io.flutter.embedding.engine.renderer.f(var5.id(), this.e, this.a, var5);
         var4 = new StringBuilder();
         var4.append("New SurfaceTextureSurfaceProducer ID: ");
         var4.append(var5.id());
         y.b.f("FlutterRenderer", var4.toString());
      }

      return (TextureRegistry.SurfaceProducer)var3;
   }

   public TextureRegistry.ImageTextureEntry b() {
      FlutterRenderer.ImageTextureRegistryEntry var1 = new FlutterRenderer.ImageTextureRegistryEntry(this.b.getAndIncrement());
      StringBuilder var2 = new StringBuilder();
      var2.append("New ImageTextureEntry ID: ");
      var2.append(var1.id());
      y.b.f("FlutterRenderer", var2.toString());
      this.q(var1.id(), var1);
      return var1;
   }

   public TextureRegistry.SurfaceTextureEntry c() {
      y.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
      return this.s(new SurfaceTexture(0));
   }

   public void j(io.flutter.embedding.engine.renderer.d var1) {
      this.a.addIsDisplayingFlutterUiListener(var1);
      if (this.d) {
         var1.g();
      }

   }

   void k(TextureRegistry.b var1) {
      this.l();
      this.f.add(new WeakReference(var1));
   }

   public void m(ByteBuffer var1, int var2) {
      this.a.dispatchPointerDataPacket(var1, var2);
   }

   public boolean n() {
      return this.d;
   }

   public boolean o() {
      return this.a.getIsSoftwareRenderingEnabled();
   }

   public void p(int var1) {
      Iterator var2 = this.f.iterator();

      while(var2.hasNext()) {
         TextureRegistry.b var3 = (TextureRegistry.b)((WeakReference)var2.next()).get();
         if (var3 != null) {
            var3.onTrimMemory(var1);
         } else {
            var2.remove();
         }
      }

   }

   public TextureRegistry.SurfaceTextureEntry s(SurfaceTexture var1) {
      return this.r(this.b.getAndIncrement(), var1);
   }

   public void u(io.flutter.embedding.engine.renderer.d var1) {
      this.a.removeIsDisplayingFlutterUiListener(var1);
   }

   void v(TextureRegistry.b var1) {
      Iterator var2 = this.f.iterator();

      while(var2.hasNext()) {
         WeakReference var3 = (WeakReference)var2.next();
         if (var3.get() == var1) {
            this.f.remove(var3);
            break;
         }
      }

   }

   public void x(boolean var1) {
      this.a.setSemanticsEnabled(var1);
   }

   public void y(FlutterRenderer.h var1) {
      if (var1.a()) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Setting viewport metrics\nSize: ");
         var2.append(var1.b);
         var2.append(" x ");
         var2.append(var1.c);
         var2.append("\nPadding - L: ");
         var2.append(var1.g);
         var2.append(", T: ");
         var2.append(var1.d);
         var2.append(", R: ");
         var2.append(var1.e);
         var2.append(", B: ");
         var2.append(var1.f);
         var2.append("\nInsets - L: ");
         var2.append(var1.k);
         var2.append(", T: ");
         var2.append(var1.h);
         var2.append(", R: ");
         var2.append(var1.i);
         var2.append(", B: ");
         var2.append(var1.j);
         var2.append("\nSystem Gesture Insets - L: ");
         var2.append(var1.o);
         var2.append(", T: ");
         var2.append(var1.l);
         var2.append(", R: ");
         var2.append(var1.m);
         var2.append(", B: ");
         var2.append(var1.m);
         var2.append("\nDisplay Features: ");
         var2.append(var1.q.size());
         y.b.f("FlutterRenderer", var2.toString());
         int[] var3 = new int[var1.q.size() * 4];
         int[] var4 = new int[var1.q.size()];
         int[] var5 = new int[var1.q.size()];

         for(int var6 = 0; var6 < var1.q.size(); ++var6) {
            FlutterRenderer.c var7 = (FlutterRenderer.c)var1.q.get(var6);
            int var8 = var6 * 4;
            Rect var9 = var7.a;
            var3[var8] = var9.left;
            var3[var8 + 1] = var9.top;
            var3[var8 + 2] = var9.right;
            var3[var8 + 3] = var9.bottom;
            var4[var6] = var7.b.e;
            var5[var6] = var7.c.e;
         }

         this.a.setViewportMetrics(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f, var1.g, var1.h, var1.i, var1.j, var1.k, var1.l, var1.m, var1.n, var1.o, var1.p, var3, var4, var5);
      }
   }

   public void z(Surface var1, boolean var2) {
      if (!var2) {
         this.A();
      }

      this.c = var1;
      if (var2) {
         this.a.onSurfaceWindowChanged(var1);
      } else {
         this.a.onSurfaceCreated(var1);
      }

   }

   final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer, TextureRegistry.b {
      private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
      private static final int MAX_IMAGES = 5;
      private static final String TAG = "ImageReaderSurfaceProducer";
      private static final boolean VERBOSE_LOGS = false;
      private static final boolean trimOnMemoryPressure = true;
      private TextureRegistry.SurfaceProducer.a callback = null;
      private boolean createNewReader = true;
      private final long id;
      private boolean ignoringFence = false;
      private final ArrayDeque<FlutterRenderer.ImageReaderSurfaceProducer.b> imageReaderQueue = new ArrayDeque();
      private long lastDequeueTime = 0L;
      private FlutterRenderer.ImageReaderSurfaceProducer.a lastDequeuedImage = null;
      private long lastQueueTime = 0L;
      private FlutterRenderer.ImageReaderSurfaceProducer.b lastReaderDequeuedFrom = null;
      private long lastScheduleTime = 0L;
      private final Object lock = new Object();
      private int numTrims = 0;
      private final HashMap<ImageReader, FlutterRenderer.ImageReaderSurfaceProducer.b> perImageReaders = new HashMap();
      private boolean released;
      private int requestedHeight = 1;
      private int requestedWidth = 1;

      ImageReaderSurfaceProducer(long var2) {
         this.id = var2;
      }

      private void cleanup() {
         Object var1 = this.lock;
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label740: {
            Iterator var2;
            try {
               var2 = this.perImageReaders.values().iterator();
            } catch (Throwable var92) {
               var10000 = var92;
               var10001 = false;
               break label740;
            }

            while(true) {
               FlutterRenderer.ImageReaderSurfaceProducer.b var3;
               try {
                  if (!var2.hasNext()) {
                     break;
                  }

                  var3 = (FlutterRenderer.ImageReaderSurfaceProducer.b)var2.next();
                  if (this.lastReaderDequeuedFrom == var3) {
                     this.lastReaderDequeuedFrom = null;
                  }
               } catch (Throwable var93) {
                  var10000 = var93;
                  var10001 = false;
                  break label740;
               }

               try {
                  var3.d();
               } catch (Throwable var91) {
                  var10000 = var91;
                  var10001 = false;
                  break label740;
               }
            }

            FlutterRenderer.ImageReaderSurfaceProducer.a var94;
            try {
               this.perImageReaders.clear();
               var94 = this.lastDequeuedImage;
            } catch (Throwable var90) {
               var10000 = var90;
               var10001 = false;
               break label740;
            }

            if (var94 != null) {
               try {
                  var94.a.close();
                  this.lastDequeuedImage = null;
               } catch (Throwable var89) {
                  var10000 = var89;
                  var10001 = false;
                  break label740;
               }
            }

            FlutterRenderer.ImageReaderSurfaceProducer.b var95;
            try {
               var95 = this.lastReaderDequeuedFrom;
            } catch (Throwable var88) {
               var10000 = var88;
               var10001 = false;
               break label740;
            }

            if (var95 != null) {
               try {
                  var95.d();
                  this.lastReaderDequeuedFrom = null;
               } catch (Throwable var87) {
                  var10000 = var87;
                  var10001 = false;
                  break label740;
               }
            }

            label709:
            try {
               this.imageReaderQueue.clear();
               return;
            } catch (Throwable var86) {
               var10000 = var86;
               var10001 = false;
               break label709;
            }
         }

         while(true) {
            Throwable var96 = var10000;

            try {
               throw var96;
            } catch (Throwable var85) {
               var10000 = var85;
               var10001 = false;
               continue;
            }
         }
      }

      private ImageReader createImageReader() {
         int var1 = VERSION.SDK_INT;
         if (var1 >= 33) {
            return this.createImageReader33();
         } else if (var1 >= 29) {
            return this.createImageReader29();
         } else {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
         }
      }

      private ImageReader createImageReader29() {
         return io.flutter.embedding.android.i.a(this.requestedWidth, this.requestedHeight, 34, 5, 256L);
      }

      private ImageReader createImageReader33() {
         Builder var1 = new Builder(this.requestedWidth, this.requestedHeight);
         var1.setMaxImages(5);
         var1.setImageFormat(34);
         var1.setUsage(256L);
         return var1.build();
      }

      private FlutterRenderer.ImageReaderSurfaceProducer.b getActiveReader() {
         Object var1 = this.lock;
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label123: {
            FlutterRenderer.ImageReaderSurfaceProducer.b var15;
            try {
               if (this.createNewReader) {
                  this.createNewReader = false;
                  var15 = this.getOrCreatePerImageReader(this.createImageReader());
                  return var15;
               }
            } catch (Throwable var14) {
               var10000 = var14;
               var10001 = false;
               break label123;
            }

            label117:
            try {
               var15 = (FlutterRenderer.ImageReaderSurfaceProducer.b)this.imageReaderQueue.peekLast();
               return var15;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label117;
            }
         }

         while(true) {
            Throwable var2 = var10000;

            try {
               throw var2;
            } catch (Throwable var12) {
               var10000 = var12;
               var10001 = false;
               continue;
            }
         }
      }

      private void maybeWaitOnFence(Image var1) {
         if (var1 != null) {
            if (!this.ignoringFence) {
               if (VERSION.SDK_INT >= 33) {
                  this.waitOnFence(var1);
               } else {
                  this.ignoringFence = true;
                  y.b.a("ImageReaderSurfaceProducer", "ImageTextureEntry can't wait on the fence on Android < 33");
               }
            }
         }
      }

      private void releaseInternal() {
         this.cleanup();
         this.released = true;
         FlutterRenderer.this.g.remove(this);
      }

      private void waitOnFence(Image var1) {
         try {
            var1.getFence().awaitForever();
         } catch (IOException var2) {
         }

      }

      public Image acquireLatestImage() {
         FlutterRenderer.ImageReaderSurfaceProducer.a var1 = this.dequeueImage();
         if (var1 == null) {
            return null;
         } else {
            this.maybeWaitOnFence(var1.a);
            return var1.a;
         }
      }

      double deltaMillis(long var1) {
         return (double)var1 / 1000000.0D;
      }

      FlutterRenderer.ImageReaderSurfaceProducer.a dequeueImage() {
         Object var1 = this.lock;
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label465: {
            Iterator var2;
            try {
               var2 = this.imageReaderQueue.iterator();
            } catch (Throwable var60) {
               var10000 = var60;
               var10001 = false;
               break label465;
            }

            FlutterRenderer.ImageReaderSurfaceProducer.a var3 = null;

            while(true) {
               FlutterRenderer.ImageReaderSurfaceProducer.b var4;
               try {
                  if (!var2.hasNext()) {
                     break;
                  }

                  var4 = (FlutterRenderer.ImageReaderSurfaceProducer.b)var2.next();
                  var3 = var4.e();
               } catch (Throwable var59) {
                  var10000 = var59;
                  var10001 = false;
                  break label465;
               }

               if (var3 != null) {
                  FlutterRenderer.ImageReaderSurfaceProducer.a var61;
                  try {
                     var61 = this.lastDequeuedImage;
                  } catch (Throwable var58) {
                     var10000 = var58;
                     var10001 = false;
                     break label465;
                  }

                  if (var61 != null) {
                     try {
                        var61.a.close();
                     } catch (Throwable var57) {
                        var10000 = var57;
                        var10001 = false;
                        break label465;
                     }
                  }

                  try {
                     this.lastDequeuedImage = var3;
                     this.lastReaderDequeuedFrom = var4;
                     break;
                  } catch (Throwable var56) {
                     var10000 = var56;
                     var10001 = false;
                     break label465;
                  }
               }
            }

            label441:
            try {
               this.pruneImageReaderQueue();
               return var3;
            } catch (Throwable var55) {
               var10000 = var55;
               var10001 = false;
               break label441;
            }
         }

         while(true) {
            Throwable var62 = var10000;

            try {
               throw var62;
            } catch (Throwable var54) {
               var10000 = var54;
               var10001 = false;
               continue;
            }
         }
      }

      public void disableFenceForTest() {
         this.ignoringFence = true;
      }

      protected void finalize() {
         // $FF: Couldn't be decompiled
      }

      public int getHeight() {
         return this.requestedHeight;
      }

      FlutterRenderer.ImageReaderSurfaceProducer.b getOrCreatePerImageReader(ImageReader var1) {
         FlutterRenderer.ImageReaderSurfaceProducer.b var2 = (FlutterRenderer.ImageReaderSurfaceProducer.b)this.perImageReaders.get(var1);
         FlutterRenderer.ImageReaderSurfaceProducer.b var3 = var2;
         if (var2 == null) {
            var3 = new FlutterRenderer.ImageReaderSurfaceProducer.b(var1);
            this.perImageReaders.put(var1, var3);
            this.imageReaderQueue.add(var3);
         }

         return var3;
      }

      public Surface getSurface() {
         return this.getActiveReader().a.getSurface();
      }

      public int getWidth() {
         return this.requestedWidth;
      }

      public long id() {
         return this.id;
      }

      public int numImageReaders() {
         // $FF: Couldn't be decompiled
      }

      public int numImages() {
         Object var1 = this.lock;
         synchronized(var1){}

         Throwable var10000;
         boolean var10001;
         label211: {
            Iterator var2;
            try {
               var2 = this.imageReaderQueue.iterator();
            } catch (Throwable var23) {
               var10000 = var23;
               var10001 = false;
               break label211;
            }

            int var3 = 0;

            while(true) {
               try {
                  if (!var2.hasNext()) {
                     break;
                  }

                  var3 += ((FlutterRenderer.ImageReaderSurfaceProducer.b)var2.next()).b.size();
               } catch (Throwable var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label211;
               }
            }

            label195:
            try {
               return var3;
            } catch (Throwable var21) {
               var10000 = var21;
               var10001 = false;
               break label195;
            }
         }

         while(true) {
            Throwable var24 = var10000;

            try {
               throw var24;
            } catch (Throwable var20) {
               var10000 = var20;
               var10001 = false;
               continue;
            }
         }
      }

      public int numTrims() {
         // $FF: Couldn't be decompiled
      }

      void onImage(ImageReader param1, Image param2) {
         // $FF: Couldn't be decompiled
      }

      public void onTrimMemory(int param1) {
         // $FF: Couldn't be decompiled
      }

      void pruneImageReaderQueue() {
         while(true) {
            if (this.imageReaderQueue.size() > 1) {
               FlutterRenderer.ImageReaderSurfaceProducer.b var1 = (FlutterRenderer.ImageReaderSurfaceProducer.b)this.imageReaderQueue.peekFirst();
               if (var1 != null && var1.c()) {
                  this.imageReaderQueue.removeFirst();
                  this.perImageReaders.remove(var1.a);
                  var1.d();
                  continue;
               }
            }

            return;
         }
      }

      public void release() {
         if (!this.released) {
            this.releaseInternal();
            FlutterRenderer.this.D(this.id);
         }
      }

      public void scheduleFrame() {
         FlutterRenderer.this.w();
      }

      public void setCallback(TextureRegistry.SurfaceProducer.a var1) {
         this.callback = var1;
      }

      public void setSize(int var1, int var2) {
         var1 = Math.max(1, var1);
         var2 = Math.max(1, var2);
         if (this.requestedWidth != var1 || this.requestedHeight != var2) {
            this.createNewReader = true;
            this.requestedHeight = var2;
            this.requestedWidth = var1;
         }
      }

      private class a {
         public final Image a;
         public final long b;

         public a(Image var2, long var3) {
            this.a = var2;
            this.b = var3;
         }
      }

      private class b {
         public final ImageReader a;
         private final ArrayDeque<FlutterRenderer.ImageReaderSurfaceProducer.a> b = new ArrayDeque();
         private boolean c = false;

         public b(ImageReader var2) {
            this.a = var2;
            var2.setOnImageAvailableListener(new io.flutter.embedding.engine.renderer.a(this), new Handler(Looper.getMainLooper()));
         }

         // $FF: synthetic method
         public static void a(FlutterRenderer.ImageReaderSurfaceProducer.b var0, ImageReader var1) {
            var0.f(var1);
         }

         // $FF: synthetic method
         private void f(ImageReader var1) {
            Image var2;
            try {
               var2 = var1.acquireLatestImage();
            } catch (IllegalStateException var4) {
               StringBuilder var3 = new StringBuilder();
               var3.append("onImageAvailable acquireLatestImage failed: ");
               var3.append(var4);
               y.b.b("ImageReaderSurfaceProducer", var3.toString());
               var2 = null;
            }

            if (var2 != null) {
               if (!ImageReaderSurfaceProducer.this.released && !this.c) {
                  ImageReaderSurfaceProducer.this.onImage(var1, var2);
               } else {
                  var2.close();
               }
            }
         }

         boolean c() {
            boolean var1;
            if (this.b.isEmpty() && ImageReaderSurfaceProducer.this.lastReaderDequeuedFrom != this) {
               var1 = true;
            } else {
               var1 = false;
            }

            return var1;
         }

         void d() {
            this.c = true;
            this.a.close();
            this.b.clear();
         }

         FlutterRenderer.ImageReaderSurfaceProducer.a e() {
            return this.b.isEmpty() ? null : (FlutterRenderer.ImageReaderSurfaceProducer.a)this.b.removeFirst();
         }

         FlutterRenderer.ImageReaderSurfaceProducer.a g(Image var1) {
            if (this.c) {
               return null;
            } else {
               FlutterRenderer.ImageReaderSurfaceProducer.a var2 = ImageReaderSurfaceProducer.this.new a(var1, System.nanoTime());
               this.b.add(var2);

               while(this.b.size() > 2) {
                  ((FlutterRenderer.ImageReaderSurfaceProducer.a)this.b.removeFirst()).a.close();
               }

               return var2;
            }
         }
      }
   }

   final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
      private static final String TAG = "ImageTextureRegistryEntry";
      private final long id;
      private boolean ignoringFence = false;
      private Image image;
      private boolean released;

      ImageTextureRegistryEntry(long var2) {
         this.id = var2;
      }

      private void maybeWaitOnFence(Image var1) {
         if (var1 != null) {
            if (!this.ignoringFence) {
               if (VERSION.SDK_INT >= 33) {
                  this.waitOnFence(var1);
               } else {
                  this.ignoringFence = true;
                  y.b.a("ImageTextureRegistryEntry", "ImageTextureEntry can't wait on the fence on Android < 33");
               }
            }
         }
      }

      private void waitOnFence(Image var1) {
         try {
            var1.getFence().awaitForever();
         } catch (IOException var2) {
         }

      }

      public Image acquireLatestImage() {
         // $FF: Couldn't be decompiled
      }

      protected void finalize() {
         Throwable var10000;
         label170: {
            boolean var1;
            boolean var10001;
            try {
               var1 = this.released;
            } catch (Throwable var23) {
               var10000 = var23;
               var10001 = false;
               break label170;
            }

            if (var1) {
               super.finalize();
               return;
            }

            Image var2;
            try {
               var2 = this.image;
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label170;
            }

            if (var2 != null) {
               try {
                  var2.close();
                  this.image = null;
               } catch (Throwable var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label170;
               }
            }

            try {
               this.released = true;
               Handler var3 = FlutterRenderer.this.e;
               FlutterRenderer.g var25 = new FlutterRenderer.g(this.id, FlutterRenderer.this.a);
               var3.post(var25);
            } catch (Throwable var20) {
               var10000 = var20;
               var10001 = false;
               break label170;
            }

            super.finalize();
            return;
         }

         Throwable var24 = var10000;
         super.finalize();
         throw var24;
      }

      public long id() {
         return this.id;
      }

      public void pushImage(Image param1) {
         // $FF: Couldn't be decompiled
      }

      public void release() {
         if (!this.released) {
            this.released = true;
            Image var1 = this.image;
            if (var1 != null) {
               var1.close();
               this.image = null;
            }

            FlutterRenderer.this.D(this.id);
         }
      }
   }

   public static final class c {
      public final Rect a;
      public final FlutterRenderer.e b;
      public final FlutterRenderer.d c;

      public c(Rect var1, FlutterRenderer.e var2) {
         this.a = var1;
         this.b = var2;
         this.c = FlutterRenderer.d.f;
      }

      public c(Rect var1, FlutterRenderer.e var2, FlutterRenderer.d var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }

   public static enum d {
      f(0),
      g(1),
      h(2);

      public final int e;

      private d(int var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static FlutterRenderer.d[] a() {
         return new FlutterRenderer.d[]{f, g, h};
      }
   }

   public static enum e {
      f(0),
      g(1),
      h(2),
      i(3);

      public final int e;

      private e(int var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static FlutterRenderer.e[] a() {
         return new FlutterRenderer.e[]{f, g, h, i};
      }
   }

   final class f implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.b {
      private final long a;
      private final SurfaceTextureWrapper b;
      private boolean c;
      private TextureRegistry.b d;
      private TextureRegistry.a e;

      f(long var2, SurfaceTexture var4) {
         this.a = var2;
         this.b = new SurfaceTextureWrapper(var4, new io.flutter.embedding.engine.renderer.b(this));
         io.flutter.embedding.engine.renderer.c var5 = new io.flutter.embedding.engine.renderer.c(this);
         this.surfaceTexture().setOnFrameAvailableListener(var5, new Handler());
      }

      // $FF: synthetic method
      public static void a(FlutterRenderer.f var0, SurfaceTexture var1) {
         var0.d(var1);
      }

      // $FF: synthetic method
      public static void b(FlutterRenderer.f var0) {
         var0.c();
      }

      // $FF: synthetic method
      private void c() {
         TextureRegistry.a var1 = this.e;
         if (var1 != null) {
            var1.a();
         }

      }

      // $FF: synthetic method
      private void d(SurfaceTexture var1) {
         if (!this.c && FlutterRenderer.this.a.isAttached()) {
            this.b.markDirty();
            FlutterRenderer.this.w();
         }

      }

      private void e() {
         FlutterRenderer.this.v(this);
      }

      public SurfaceTextureWrapper f() {
         return this.b;
      }

      protected void finalize() {
         // $FF: Couldn't be decompiled
      }

      public long id() {
         return this.a;
      }

      public void onTrimMemory(int var1) {
         TextureRegistry.b var2 = this.d;
         if (var2 != null) {
            var2.onTrimMemory(var1);
         }

      }

      public void release() {
         if (!this.c) {
            StringBuilder var1 = new StringBuilder();
            var1.append("Releasing a SurfaceTexture (");
            var1.append(this.a);
            var1.append(").");
            y.b.f("FlutterRenderer", var1.toString());
            this.b.release();
            FlutterRenderer.this.D(this.a);
            this.e();
            this.c = true;
         }
      }

      public void setOnFrameConsumedListener(TextureRegistry.a var1) {
         this.e = var1;
      }

      public void setOnTrimMemoryListener(TextureRegistry.b var1) {
         this.d = var1;
      }

      public SurfaceTexture surfaceTexture() {
         return this.b.surfaceTexture();
      }
   }

   static final class g implements Runnable {
      private final long e;
      private final FlutterJNI f;

      g(long var1, FlutterJNI var3) {
         this.e = var1;
         this.f = var3;
      }

      public void run() {
         if (this.f.isAttached()) {
            StringBuilder var1 = new StringBuilder();
            var1.append("Releasing a Texture (");
            var1.append(this.e);
            var1.append(").");
            y.b.f("FlutterRenderer", var1.toString());
            this.f.unregisterTexture(this.e);
         }
      }
   }

   public static final class h {
      public float a = 1.0F;
      public int b = 0;
      public int c = 0;
      public int d = 0;
      public int e = 0;
      public int f = 0;
      public int g = 0;
      public int h = 0;
      public int i = 0;
      public int j = 0;
      public int k = 0;
      public int l = 0;
      public int m = 0;
      public int n = 0;
      public int o = 0;
      public int p = -1;
      public List<FlutterRenderer.c> q = new ArrayList();

      boolean a() {
         boolean var1;
         if (this.b > 0 && this.c > 0 && this.a > 0.0F) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }
}
