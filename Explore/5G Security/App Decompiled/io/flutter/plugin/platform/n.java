package io.flutter.plugin.platform;

import android.view.Surface;

public interface n {
   void a(int var1, int var2);

   int getHeight();

   long getId();

   Surface getSurface();

   int getWidth();

   void release();

   void scheduleFrame();
}
