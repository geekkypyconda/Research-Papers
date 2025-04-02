package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import androidx.window.sidecar.SidecarInterface.SidecarCallback;
import java.util.Map;
import java.util.WeakHashMap;

public class DistinctElementSidecarCallback implements SidecarCallback {
   private final Object a = new Object();
   private SidecarDeviceState b;
   private final Map<IBinder, SidecarWindowLayoutInfo> c = new WeakHashMap();
   private final u.a d;
   private final SidecarCallback e;

   DistinctElementSidecarCallback(u.a var1, SidecarCallback var2) {
      this.d = var1;
      this.e = var2;
   }

   public void onDeviceStateChanged(SidecarDeviceState var1) {
      if (var1 != null) {
         Object var2 = this.a;
         synchronized(var2){}

         Throwable var10000;
         boolean var10001;
         label137: {
            try {
               if (this.d.a(this.b, var1)) {
                  return;
               }
            } catch (Throwable var14) {
               var10000 = var14;
               var10001 = false;
               break label137;
            }

            label131:
            try {
               this.b = var1;
               this.e.onDeviceStateChanged(var1);
               return;
            } catch (Throwable var13) {
               var10000 = var13;
               var10001 = false;
               break label131;
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
      }
   }

   public void onWindowLayoutChanged(IBinder var1, SidecarWindowLayoutInfo var2) {
      Object var3 = this.a;
      synchronized(var3){}

      Throwable var10000;
      boolean var10001;
      label123: {
         try {
            SidecarWindowLayoutInfo var4 = (SidecarWindowLayoutInfo)this.c.get(var1);
            if (this.d.d(var4, var2)) {
               return;
            }
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label123;
         }

         label117:
         try {
            this.c.put(var1, var2);
            this.e.onWindowLayoutChanged(var1, var2);
            return;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label117;
         }
      }

      while(true) {
         Throwable var17 = var10000;

         try {
            throw var17;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            continue;
         }
      }
   }
}
