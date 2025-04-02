package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

public class t {
   private static t e;
   private static t.b f;
   private long a = -1L;
   private FlutterJNI b;
   private t.c c = new t.c(0L);
   private final FlutterJNI.b d = new FlutterJNI.b() {
      private FrameCallback b(long var1) {
         if (t.this.c != null) {
            t.this.c.a = var1;
            t.c var3 = t.this.c;
            t.this.c = null;
            return var3;
         } else {
            return t.this.new c(var1);
         }
      }

      public void a(long var1) {
         Choreographer.getInstance().postFrameCallback(this.b(var1));
      }
   };

   private t(FlutterJNI var1) {
      this.b = var1;
   }

   public static t f(DisplayManager var0, FlutterJNI var1) {
      if (e == null) {
         e = new t(var1);
      }

      if (f == null) {
         t var2 = e;
         Objects.requireNonNull(var2);
         t.b var4 = var2.new b(var0);
         f = var4;
         var4.a();
      }

      if (e.a == -1L) {
         float var3 = var0.getDisplay(0).getRefreshRate();
         e.a = (long)(1.0E9D / (double)var3);
         var1.setRefreshRateFPS(var3);
      }

      return e;
   }

   public void g() {
      this.b.setAsyncWaitForVsyncDelegate(this.d);
   }

   class b implements DisplayListener {
      private DisplayManager a;

      b(DisplayManager var2) {
         this.a = var2;
      }

      void a() {
         this.a.registerDisplayListener(this, (Handler)null);
      }

      public void onDisplayAdded(int var1) {
      }

      public void onDisplayChanged(int var1) {
         if (var1 == 0) {
            float var2 = this.a.getDisplay(0).getRefreshRate();
            t.this.a = (long)(1.0E9D / (double)var2);
            t.this.b.setRefreshRateFPS(var2);
         }

      }

      public void onDisplayRemoved(int var1) {
      }
   }

   private class c implements FrameCallback {
      private long a;

      c(long var2) {
         this.a = var2;
      }

      public void doFrame(long var1) {
         var1 = System.nanoTime() - var1;
         if (var1 < 0L) {
            var1 = 0L;
         }

         t.this.b.onVsync(var1, t.this.a, this.a);
         t.this.c = this;
      }
   }
}
