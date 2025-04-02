package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;

public class SurfaceTextureWrapper {
   private boolean attached;
   private boolean newFrameAvailable;
   private Runnable onFrameConsumed;
   private boolean released;
   private SurfaceTexture surfaceTexture;

   public SurfaceTextureWrapper(SurfaceTexture var1) {
      this(var1, (Runnable)null);
   }

   public SurfaceTextureWrapper(SurfaceTexture var1, Runnable var2) {
      this.newFrameAvailable = false;
      this.surfaceTexture = var1;
      this.released = false;
      this.onFrameConsumed = var2;
   }

   public void attachToGLContext(int var1) {
      synchronized(this){}

      Throwable var10000;
      boolean var10001;
      label197: {
         try {
            if (this.released) {
               return;
            }
         } catch (Throwable var22) {
            var10000 = var22;
            var10001 = false;
            break label197;
         }

         try {
            if (this.attached) {
               this.surfaceTexture.detachFromGLContext();
            }
         } catch (Throwable var21) {
            var10000 = var21;
            var10001 = false;
            break label197;
         }

         label187:
         try {
            this.surfaceTexture.attachToGLContext(var1);
            this.attached = true;
            return;
         } catch (Throwable var20) {
            var10000 = var20;
            var10001 = false;
            break label187;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var19) {
            var10000 = var19;
            var10001 = false;
            continue;
         }
      }
   }

   public void detachFromGLContext() {
      synchronized(this){}

      Throwable var10000;
      boolean var10001;
      label130: {
         try {
            if (this.attached && !this.released) {
               this.surfaceTexture.detachFromGLContext();
               this.attached = false;
            }
         } catch (Throwable var13) {
            var10000 = var13;
            var10001 = false;
            break label130;
         }

         label127:
         try {
            return;
         } catch (Throwable var12) {
            var10000 = var12;
            var10001 = false;
            break label127;
         }
      }

      while(true) {
         Throwable var1 = var10000;

         try {
            throw var1;
         } catch (Throwable var11) {
            var10000 = var11;
            var10001 = false;
            continue;
         }
      }
   }

   public void getTransformMatrix(float[] var1) {
      this.surfaceTexture.getTransformMatrix(var1);
   }

   public void markDirty() {
      // $FF: Couldn't be decompiled
   }

   public void release() {
      synchronized(this){}

      Throwable var10000;
      boolean var10001;
      label122: {
         try {
            if (!this.released) {
               this.surfaceTexture.release();
               this.released = true;
               this.attached = false;
            }
         } catch (Throwable var13) {
            var10000 = var13;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var12) {
            var10000 = var12;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var1 = var10000;

         try {
            throw var1;
         } catch (Throwable var11) {
            var10000 = var11;
            var10001 = false;
            continue;
         }
      }
   }

   public boolean shouldUpdate() {
      // $FF: Couldn't be decompiled
   }

   public SurfaceTexture surfaceTexture() {
      return this.surfaceTexture;
   }

   public void updateTexImage() {
      synchronized(this){}

      Throwable var10000;
      boolean var10001;
      label183: {
         label182: {
            Runnable var1;
            try {
               this.newFrameAvailable = false;
               if (this.released) {
                  break label182;
               }

               this.surfaceTexture.updateTexImage();
               var1 = this.onFrameConsumed;
            } catch (Throwable var21) {
               var10000 = var21;
               var10001 = false;
               break label183;
            }

            if (var1 != null) {
               try {
                  var1.run();
               } catch (Throwable var20) {
                  var10000 = var20;
                  var10001 = false;
                  break label183;
               }
            }
         }

         label174:
         try {
            return;
         } catch (Throwable var19) {
            var10000 = var19;
            var10001 = false;
            break label174;
         }
      }

      while(true) {
         Throwable var22 = var10000;

         try {
            throw var22;
         } catch (Throwable var18) {
            var10000 = var18;
            var10001 = false;
            continue;
         }
      }
   }
}
