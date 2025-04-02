package io.flutter.plugin.editing;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.View.OnApplyWindowInsetsListener;
import androidx.core.view.b0;
import java.util.Iterator;
import java.util.List;

class ImeSyncDeferringInsetsCallback {
   private boolean animating = false;
   private ImeSyncDeferringInsetsCallback.AnimationCallback animationCallback;
   private final int deferredInsetTypes = WindowInsets$Type.ime();
   private ImeSyncDeferringInsetsCallback.b insetsListener;
   private WindowInsets lastWindowInsets;
   private boolean needsSave = false;
   private View view;

   ImeSyncDeferringInsetsCallback(View var1) {
      this.view = var1;
      this.animationCallback = new ImeSyncDeferringInsetsCallback.AnimationCallback();
      this.insetsListener = new ImeSyncDeferringInsetsCallback.b();
   }

   WindowInsetsAnimation$Callback getAnimationCallback() {
      return this.animationCallback;
   }

   OnApplyWindowInsetsListener getInsetsListener() {
      return this.insetsListener;
   }

   void install() {
      io.flutter.plugin.editing.b.a(this.view, this.animationCallback);
      this.view.setOnApplyWindowInsetsListener(this.insetsListener);
   }

   void remove() {
      io.flutter.plugin.editing.b.a(this.view, (WindowInsetsAnimation$Callback)null);
      this.view.setOnApplyWindowInsetsListener((OnApplyWindowInsetsListener)null);
   }

   private class AnimationCallback extends WindowInsetsAnimation$Callback {
      AnimationCallback() {
         super(1);
      }

      public void onEnd(WindowInsetsAnimation var1) {
         if (ImeSyncDeferringInsetsCallback.this.animating && (var1.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
            ImeSyncDeferringInsetsCallback.this.animating = false;
            if (ImeSyncDeferringInsetsCallback.this.lastWindowInsets != null && ImeSyncDeferringInsetsCallback.this.view != null) {
               ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
            }
         }

      }

      public void onPrepare(WindowInsetsAnimation var1) {
         ImeSyncDeferringInsetsCallback.this.needsSave = true;
         if ((var1.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
            ImeSyncDeferringInsetsCallback.this.animating = true;
         }

      }

      public WindowInsets onProgress(WindowInsets var1, List<WindowInsetsAnimation> var2) {
         if (ImeSyncDeferringInsetsCallback.this.animating && !ImeSyncDeferringInsetsCallback.this.needsSave) {
            Iterator var5 = var2.iterator();
            boolean var3 = false;

            while(var5.hasNext()) {
               if ((((WindowInsetsAnimation)var5.next()).getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                  var3 = true;
               }
            }

            if (!var3) {
               return var1;
            }

            int var7 = ImeSyncDeferringInsetsCallback.this.view.getWindowSystemUiVisibility();
            if ((var7 & 512) == 0 && (var7 & 2) == 0) {
               var7 = b0.a(var1, WindowInsets$Type.navigationBars()).bottom;
            } else {
               var7 = 0;
            }

            WindowInsets$Builder var6 = new WindowInsets$Builder(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
            Insets var4 = Insets.of(0, 0, 0, Math.max(b0.a(var1, ImeSyncDeferringInsetsCallback.this.deferredInsetTypes).bottom - var7, 0));
            c.a(var6, ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, var4);
            ImeSyncDeferringInsetsCallback.this.view.onApplyWindowInsets(var6.build());
         }

         return var1;
      }
   }

   private class b implements OnApplyWindowInsetsListener {
      private b() {
      }

      // $FF: synthetic method
      b(Object var2) {
         this();
      }

      public WindowInsets onApplyWindowInsets(View var1, WindowInsets var2) {
         ImeSyncDeferringInsetsCallback.this.view = var1;
         if (ImeSyncDeferringInsetsCallback.this.needsSave) {
            ImeSyncDeferringInsetsCallback.this.lastWindowInsets = var2;
            ImeSyncDeferringInsetsCallback.this.needsSave = false;
         }

         return ImeSyncDeferringInsetsCallback.this.animating ? WindowInsets.CONSUMED : var1.onApplyWindowInsets(var2);
      }
   }
}
