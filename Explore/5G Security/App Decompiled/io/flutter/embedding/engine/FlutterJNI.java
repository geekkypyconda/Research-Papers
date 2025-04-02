package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$ImageInfo;
import android.graphics.ImageDecoder.Source;
import android.os.Looper;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.Surface;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.platform.w;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry;
import io.flutter.view.h;
import j0.p;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Locale.Builder;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k0.o;

public class FlutterJNI {
   private static final String TAG = "FlutterJNI";
   private static FlutterJNI.b asyncWaitForVsyncDelegate;
   private static float displayDensity;
   private static float displayHeight;
   private static float displayWidth;
   private static boolean initCalled;
   private static boolean loadLibraryCalled;
   private static boolean prefetchDefaultFontManagerCalled;
   private static float refreshRateFPS;
   private static String vmServiceUri;
   private FlutterJNI.a accessibilityDelegate;
   private a0.a deferredComponentManager;
   private final Set<io.flutter.embedding.engine.a.b> engineLifecycleListeners = new CopyOnWriteArraySet();
   private final Set<io.flutter.embedding.engine.renderer.d> flutterUiDisplayListeners = new CopyOnWriteArraySet();
   private l0.c localizationPlugin;
   private final Looper mainLooper = Looper.getMainLooper();
   private Long nativeShellHolderId;
   private z.d platformMessageHandler;
   private w platformViewsController;
   private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();

   // $FF: synthetic method
   public static void a(long var0, ImageDecoder var2, ImageDecoder$ImageInfo var3, Source var4) {
      lambda$decodeImage$0(var0, var2, var3, var4);
   }

   private static void asyncWaitForVsync(long var0) {
      FlutterJNI.b var2 = asyncWaitForVsyncDelegate;
      if (var2 != null) {
         var2.a(var0);
      } else {
         throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
      }
   }

   public static Bitmap decodeImage(ByteBuffer var0, long var1) {
      if (VERSION.SDK_INT >= 28) {
         Source var3 = ImageDecoder.createSource(var0);

         try {
            f var5 = new f(var1);
            Bitmap var6 = ImageDecoder.decodeBitmap(var3, var5);
            return var6;
         } catch (IOException var4) {
            y.b.c("FlutterJNI", "Failed to decode image", var4);
         }
      }

      return null;
   }

   private void ensureAttachedToNative() {
      if (this.nativeShellHolderId == null) {
         throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
      }
   }

   private void ensureNotAttachedToNative() {
      if (this.nativeShellHolderId != null) {
         throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
      }
   }

   private void ensureRunningOnMainThread() {
      if (Looper.myLooper() != this.mainLooper) {
         StringBuilder var1 = new StringBuilder();
         var1.append("Methods marked with @UiThread must be executed on the main thread. Current thread: ");
         var1.append(Thread.currentThread().getName());
         throw new RuntimeException(var1.toString());
      }
   }

   @Deprecated
   public static String getObservatoryUri() {
      return vmServiceUri;
   }

   public static String getVMServiceUri() {
      return vmServiceUri;
   }

   private void handlePlatformMessageResponse(int var1, ByteBuffer var2) {
      z.d var3 = this.platformMessageHandler;
      if (var3 != null) {
         var3.d(var1, var2);
      }

   }

   // $FF: synthetic method
   private static void lambda$decodeImage$0(long var0, ImageDecoder var2, ImageDecoder$ImageInfo var3, Source var4) {
      var2.setTargetColorSpace(ColorSpace.get(ColorSpace$Named.SRGB));
      var2.setAllocator(1);
      Size var5 = var3.getSize();
      nativeImageHeaderCallback(var0, var5.getWidth(), var5.getHeight());
   }

   private native long nativeAttach(FlutterJNI var1);

   private native void nativeCleanupMessageData(long var1);

   private native void nativeDeferredComponentInstallFailure(int var1, String var2, boolean var3);

   private native void nativeDestroy(long var1);

   private native void nativeDispatchEmptyPlatformMessage(long var1, String var3, int var4);

   private native void nativeDispatchPlatformMessage(long var1, String var3, ByteBuffer var4, int var5, int var6);

   private native void nativeDispatchPointerDataPacket(long var1, ByteBuffer var3, int var4);

   private native void nativeDispatchSemanticsAction(long var1, int var3, int var4, ByteBuffer var5, int var6);

   private native boolean nativeFlutterTextUtilsIsEmoji(int var1);

   private native boolean nativeFlutterTextUtilsIsEmojiModifier(int var1);

   private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int var1);

   private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int var1);

   private native boolean nativeFlutterTextUtilsIsVariationSelector(int var1);

   private native Bitmap nativeGetBitmap(long var1);

   private native boolean nativeGetIsSoftwareRenderingEnabled();

   public static native void nativeImageHeaderCallback(long var0, int var2, int var3);

   private static native void nativeInit(Context var0, String[] var1, String var2, String var3, String var4, long var5);

   private native void nativeInvokePlatformMessageEmptyResponseCallback(long var1, int var3);

   private native void nativeInvokePlatformMessageResponseCallback(long var1, int var3, ByteBuffer var4, int var5);

   private native void nativeLoadDartDeferredLibrary(long var1, int var3, String[] var4);

   @Deprecated
   public static native FlutterCallbackInformation nativeLookupCallbackInformation(long var0);

   private native void nativeMarkTextureFrameAvailable(long var1, long var3);

   private native void nativeNotifyLowMemoryWarning(long var1);

   private native void nativeOnVsync(long var1, long var3, long var5);

   private static native void nativePrefetchDefaultFontManager();

   private native void nativeRegisterImageTexture(long var1, long var3, WeakReference<TextureRegistry.ImageConsumer> var5);

   private native void nativeRegisterTexture(long var1, long var3, WeakReference<SurfaceTextureWrapper> var5);

   private native void nativeRunBundleAndSnapshotFromLibrary(long var1, String var3, String var4, String var5, AssetManager var6, List<String> var7);

   private native void nativeScheduleFrame(long var1);

   private native void nativeSetAccessibilityFeatures(long var1, int var3);

   private native void nativeSetSemanticsEnabled(long var1, boolean var3);

   private native void nativeSetViewportMetrics(long var1, float var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int[] var19, int[] var20, int[] var21);

   private native FlutterJNI nativeSpawn(long var1, String var3, String var4, String var5, List<String> var6);

   private native void nativeSurfaceChanged(long var1, int var3, int var4);

   private native void nativeSurfaceCreated(long var1, Surface var3);

   private native void nativeSurfaceDestroyed(long var1);

   private native void nativeSurfaceWindowChanged(long var1, Surface var3);

   private native void nativeUnregisterTexture(long var1, long var3);

   private native void nativeUpdateDisplayMetrics(long var1);

   private native void nativeUpdateJavaAssetManager(long var1, AssetManager var3, String var4);

   private native void nativeUpdateRefreshRate(float var1);

   private void onPreEngineRestart() {
      Iterator var1 = this.engineLifecycleListeners.iterator();

      while(var1.hasNext()) {
         ((io.flutter.embedding.engine.a.b)var1.next()).a();
      }

   }

   private void updateCustomAccessibilityActions(ByteBuffer var1, String[] var2) {
      this.ensureRunningOnMainThread();
      FlutterJNI.a var3 = this.accessibilityDelegate;
      if (var3 != null) {
         var3.b(var1, var2);
      }

   }

   private void updateSemantics(ByteBuffer var1, String[] var2, ByteBuffer[] var3) {
      this.ensureRunningOnMainThread();
      FlutterJNI.a var4 = this.accessibilityDelegate;
      if (var4 != null) {
         var4.a(var1, var2, var3);
      }

   }

   public void addEngineLifecycleListener(io.flutter.embedding.engine.a.b var1) {
      this.ensureRunningOnMainThread();
      this.engineLifecycleListeners.add(var1);
   }

   public void addIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.d var1) {
      this.ensureRunningOnMainThread();
      this.flutterUiDisplayListeners.add(var1);
   }

   public void attachToNative() {
      this.ensureRunningOnMainThread();
      this.ensureNotAttachedToNative();
      this.shellHolderLock.writeLock().lock();

      try {
         this.nativeShellHolderId = this.performNativeAttach(this);
      } finally {
         this.shellHolderLock.writeLock().unlock();
      }

   }

   public void cleanupMessageData(long var1) {
      this.nativeCleanupMessageData(var1);
   }

   public String[] computePlatformResolvedLocale(String[] var1) {
      if (this.localizationPlugin == null) {
         return new String[0];
      } else {
         ArrayList var2 = new ArrayList();

         for(int var3 = 0; var3 < var1.length; var3 += 3) {
            String var4 = var1[var3 + 0];
            String var5 = var1[var3 + 1];
            String var6 = var1[var3 + 2];
            Builder var7 = new Builder();
            if (!var4.isEmpty()) {
               var7.setLanguage(var4);
            }

            if (!var5.isEmpty()) {
               var7.setRegion(var5);
            }

            if (!var6.isEmpty()) {
               var7.setScript(var6);
            }

            var2.add(var7.build());
         }

         Locale var8 = this.localizationPlugin.c(var2);
         if (var8 == null) {
            return new String[0];
         } else {
            return new String[]{var8.getLanguage(), var8.getCountry(), var8.getScript()};
         }
      }
   }

   public FlutterOverlaySurface createOverlaySurface() {
      this.ensureRunningOnMainThread();
      w var1 = this.platformViewsController;
      if (var1 != null) {
         return var1.K();
      } else {
         throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      }
   }

   public void deferredComponentInstallFailure(int var1, String var2, boolean var3) {
      this.ensureRunningOnMainThread();
      this.nativeDeferredComponentInstallFailure(var1, var2, var3);
   }

   public void destroyOverlaySurfaces() {
      this.ensureRunningOnMainThread();
      w var1 = this.platformViewsController;
      if (var1 != null) {
         var1.N();
      } else {
         throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
      }
   }

   public void detachFromNativeAndReleaseResources() {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.shellHolderLock.writeLock().lock();

      try {
         this.nativeDestroy(this.nativeShellHolderId);
         this.nativeShellHolderId = null;
      } finally {
         this.shellHolderLock.writeLock().unlock();
      }

   }

   public void dispatchEmptyPlatformMessage(String var1, int var2) {
      this.ensureRunningOnMainThread();
      if (this.isAttached()) {
         this.nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId, var1, var2);
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ");
         var3.append(var1);
         var3.append(". Response ID: ");
         var3.append(var2);
         y.b.g("FlutterJNI", var3.toString());
      }

   }

   public void dispatchPlatformMessage(String var1, ByteBuffer var2, int var3, int var4) {
      this.ensureRunningOnMainThread();
      if (this.isAttached()) {
         this.nativeDispatchPlatformMessage(this.nativeShellHolderId, var1, var2, var3, var4);
      } else {
         StringBuilder var5 = new StringBuilder();
         var5.append("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ");
         var5.append(var1);
         var5.append(". Response ID: ");
         var5.append(var4);
         y.b.g("FlutterJNI", var5.toString());
      }

   }

   public void dispatchPointerDataPacket(ByteBuffer var1, int var2) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeDispatchPointerDataPacket(this.nativeShellHolderId, var1, var2);
   }

   public void dispatchSemanticsAction(int var1, int var2, ByteBuffer var3, int var4) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeDispatchSemanticsAction(this.nativeShellHolderId, var1, var2, var3, var4);
   }

   public void dispatchSemanticsAction(int var1, h.g var2) {
      this.dispatchSemanticsAction(var1, var2, (Object)null);
   }

   public void dispatchSemanticsAction(int var1, h.g var2, Object var3) {
      this.ensureAttachedToNative();
      int var4;
      ByteBuffer var5;
      if (var3 != null) {
         var5 = o.a.b(var3);
         var4 = var5.position();
      } else {
         var5 = null;
         var4 = 0;
      }

      this.dispatchSemanticsAction(var1, var2.e, var5, var4);
   }

   public Bitmap getBitmap() {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      return this.nativeGetBitmap(this.nativeShellHolderId);
   }

   public boolean getIsSoftwareRenderingEnabled() {
      return this.nativeGetIsSoftwareRenderingEnabled();
   }

   public float getScaledFontSize(float var1, int var2) {
      DisplayMetrics var3 = p.b(var2);
      if (var3 == null) {
         StringBuilder var4 = new StringBuilder();
         var4.append("getScaledFontSize called with configurationId ");
         var4.append(String.valueOf(var2));
         var4.append(", which can't be found.");
         y.b.b("FlutterJNI", var4.toString());
         return -1.0F;
      } else {
         return TypedValue.applyDimension(2, var1, var3) / var3.density;
      }
   }

   public void handlePlatformMessage(String var1, ByteBuffer var2, int var3, long var4) {
      z.d var6 = this.platformMessageHandler;
      if (var6 != null) {
         var6.e(var1, var2, var3, var4);
      } else {
         this.nativeCleanupMessageData(var4);
      }

   }

   public void init(Context var1, String[] var2, String var3, String var4, String var5, long var6) {
      if (initCalled) {
         y.b.g("FlutterJNI", "FlutterJNI.init called more than once");
      }

      nativeInit(var1, var2, var3, var4, var5, var6);
      initCalled = true;
   }

   public void invokePlatformMessageEmptyResponseCallback(int var1) {
      this.shellHolderLock.readLock().lock();

      try {
         if (this.isAttached()) {
            this.nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId, var1);
         } else {
            StringBuilder var2 = new StringBuilder();
            var2.append("Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ");
            var2.append(var1);
            y.b.g("FlutterJNI", var2.toString());
         }
      } finally {
         this.shellHolderLock.readLock().unlock();
      }

   }

   public void invokePlatformMessageResponseCallback(int var1, ByteBuffer var2, int var3) {
      if (var2.isDirect()) {
         this.shellHolderLock.readLock().lock();

         try {
            if (this.isAttached()) {
               this.nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId, var1, var2, var3);
            } else {
               StringBuilder var6 = new StringBuilder();
               var6.append("Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ");
               var6.append(var1);
               y.b.g("FlutterJNI", var6.toString());
            }
         } finally {
            this.shellHolderLock.readLock().unlock();
         }

      } else {
         throw new IllegalArgumentException("Expected a direct ByteBuffer.");
      }
   }

   public boolean isAttached() {
      boolean var1;
      if (this.nativeShellHolderId != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isCodePointEmoji(int var1) {
      return this.nativeFlutterTextUtilsIsEmoji(var1);
   }

   public boolean isCodePointEmojiModifier(int var1) {
      return this.nativeFlutterTextUtilsIsEmojiModifier(var1);
   }

   public boolean isCodePointEmojiModifierBase(int var1) {
      return this.nativeFlutterTextUtilsIsEmojiModifierBase(var1);
   }

   public boolean isCodePointRegionalIndicator(int var1) {
      return this.nativeFlutterTextUtilsIsRegionalIndicator(var1);
   }

   public boolean isCodePointVariantSelector(int var1) {
      return this.nativeFlutterTextUtilsIsVariationSelector(var1);
   }

   public void loadDartDeferredLibrary(int var1, String[] var2) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeLoadDartDeferredLibrary(this.nativeShellHolderId, var1, var2);
   }

   public void loadLibrary() {
      if (loadLibraryCalled) {
         y.b.g("FlutterJNI", "FlutterJNI.loadLibrary called more than once");
      }

      System.loadLibrary("flutter");
      loadLibraryCalled = true;
   }

   public void markTextureFrameAvailable(long var1) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeMarkTextureFrameAvailable(this.nativeShellHolderId, var1);
   }

   public void notifyLowMemoryWarning() {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeNotifyLowMemoryWarning(this.nativeShellHolderId);
   }

   public void onBeginFrame() {
      this.ensureRunningOnMainThread();
      w var1 = this.platformViewsController;
      if (var1 != null) {
         var1.h0();
      } else {
         throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
      }
   }

   public void onDisplayOverlaySurface(int var1, int var2, int var3, int var4, int var5) {
      this.ensureRunningOnMainThread();
      w var6 = this.platformViewsController;
      if (var6 != null) {
         var6.j0(var1, var2, var3, var4, var5);
      } else {
         throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      }
   }

   public void onDisplayPlatformView(int var1, int var2, int var3, int var4, int var5, int var6, int var7, FlutterMutatorsStack var8) {
      this.ensureRunningOnMainThread();
      w var9 = this.platformViewsController;
      if (var9 != null) {
         var9.k0(var1, var2, var3, var4, var5, var6, var7, var8);
      } else {
         throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
      }
   }

   public void onEndFrame() {
      this.ensureRunningOnMainThread();
      w var1 = this.platformViewsController;
      if (var1 != null) {
         var1.l0();
      } else {
         throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
      }
   }

   public void onFirstFrame() {
      this.ensureRunningOnMainThread();
      Iterator var1 = this.flutterUiDisplayListeners.iterator();

      while(var1.hasNext()) {
         ((io.flutter.embedding.engine.renderer.d)var1.next()).g();
      }

   }

   void onRenderingStopped() {
      this.ensureRunningOnMainThread();
      Iterator var1 = this.flutterUiDisplayListeners.iterator();

      while(var1.hasNext()) {
         ((io.flutter.embedding.engine.renderer.d)var1.next()).d();
      }

   }

   public void onSurfaceChanged(int var1, int var2) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeSurfaceChanged(this.nativeShellHolderId, var1, var2);
   }

   public void onSurfaceCreated(Surface var1) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeSurfaceCreated(this.nativeShellHolderId, var1);
   }

   public void onSurfaceDestroyed() {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.onRenderingStopped();
      this.nativeSurfaceDestroyed(this.nativeShellHolderId);
   }

   public void onSurfaceWindowChanged(Surface var1) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeSurfaceWindowChanged(this.nativeShellHolderId, var1);
   }

   public void onVsync(long var1, long var3, long var5) {
      this.nativeOnVsync(var1, var3, var5);
   }

   public long performNativeAttach(FlutterJNI var1) {
      return this.nativeAttach(var1);
   }

   public void prefetchDefaultFontManager() {
      if (prefetchDefaultFontManagerCalled) {
         y.b.g("FlutterJNI", "FlutterJNI.prefetchDefaultFontManager called more than once");
      }

      nativePrefetchDefaultFontManager();
      prefetchDefaultFontManagerCalled = true;
   }

   public void registerImageTexture(long var1, TextureRegistry.ImageConsumer var3) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeRegisterImageTexture(this.nativeShellHolderId, var1, new WeakReference(var3));
   }

   public void registerTexture(long var1, SurfaceTextureWrapper var3) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeRegisterTexture(this.nativeShellHolderId, var1, new WeakReference(var3));
   }

   public void removeEngineLifecycleListener(io.flutter.embedding.engine.a.b var1) {
      this.ensureRunningOnMainThread();
      this.engineLifecycleListeners.remove(var1);
   }

   public void removeIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.d var1) {
      this.ensureRunningOnMainThread();
      this.flutterUiDisplayListeners.remove(var1);
   }

   public void requestDartDeferredLibrary(int var1) {
      a0.a var2 = this.deferredComponentManager;
      if (var2 != null) {
         var2.d(var1, (String)null);
      } else {
         y.b.b("FlutterJNI", "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
      }

   }

   public void runBundleAndSnapshotFromLibrary(String var1, String var2, String var3, AssetManager var4, List<String> var5) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId, var1, var2, var3, var4, var5);
   }

   public void scheduleFrame() {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeScheduleFrame(this.nativeShellHolderId);
   }

   public void setAccessibilityDelegate(FlutterJNI.a var1) {
      this.ensureRunningOnMainThread();
      this.accessibilityDelegate = var1;
   }

   public void setAccessibilityFeatures(int var1) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeSetAccessibilityFeatures(this.nativeShellHolderId, var1);
   }

   public void setAsyncWaitForVsyncDelegate(FlutterJNI.b var1) {
      asyncWaitForVsyncDelegate = var1;
   }

   public void setDeferredComponentManager(a0.a var1) {
      this.ensureRunningOnMainThread();
      this.deferredComponentManager = var1;
      if (var1 != null) {
         var1.f(this);
      }

   }

   public void setLocalizationPlugin(l0.c var1) {
      this.ensureRunningOnMainThread();
      this.localizationPlugin = var1;
   }

   public void setPlatformMessageHandler(z.d var1) {
      this.ensureRunningOnMainThread();
      this.platformMessageHandler = var1;
   }

   public void setPlatformViewsController(w var1) {
      this.ensureRunningOnMainThread();
      this.platformViewsController = var1;
   }

   public void setRefreshRateFPS(float var1) {
      refreshRateFPS = var1;
      this.updateRefreshRate();
   }

   public void setSemanticsEnabled(boolean var1) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeSetSemanticsEnabled(this.nativeShellHolderId, var1);
   }

   public void setViewportMetrics(float var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int[] var17, int[] var18, int[] var19) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeSetViewportMetrics(this.nativeShellHolderId, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
   }

   public FlutterJNI spawn(String var1, String var2, String var3, List<String> var4) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      FlutterJNI var6 = this.nativeSpawn(this.nativeShellHolderId, var1, var2, var3, var4);
      Long var7 = var6.nativeShellHolderId;
      boolean var5;
      if (var7 != null && var7 != 0L) {
         var5 = true;
      } else {
         var5 = false;
      }

      o0.d.a(var5, "Failed to spawn new JNI connected shell from existing shell.");
      return var6;
   }

   public void unregisterTexture(long var1) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeUnregisterTexture(this.nativeShellHolderId, var1);
   }

   public void updateDisplayMetrics(int var1, float var2, float var3, float var4) {
      displayWidth = var2;
      displayHeight = var3;
      displayDensity = var4;
      if (loadLibraryCalled) {
         this.nativeUpdateDisplayMetrics(this.nativeShellHolderId);
      }
   }

   public void updateJavaAssetManager(AssetManager var1, String var2) {
      this.ensureRunningOnMainThread();
      this.ensureAttachedToNative();
      this.nativeUpdateJavaAssetManager(this.nativeShellHolderId, var1, var2);
   }

   public void updateRefreshRate() {
      if (loadLibraryCalled) {
         this.nativeUpdateRefreshRate(refreshRateFPS);
      }
   }

   public interface a {
      void a(ByteBuffer var1, String[] var2, ByteBuffer[] var3);

      void b(ByteBuffer var1, String[] var2);
   }

   public interface b {
      void a(long var1);
   }

   public static class c {
      public FlutterJNI a() {
         return new FlutterJNI();
      }
   }
}
