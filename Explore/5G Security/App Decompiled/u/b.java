package u;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.window.layout.adapter.sidecar.SidecarCompat;

// $FF: synthetic class
public final class b implements h.a {
   // $FF: synthetic field
   public final SidecarCompat a;
   // $FF: synthetic field
   public final Activity b;

   // $FF: synthetic method
   public b(SidecarCompat var1, Activity var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void accept(Object var1) {
      SidecarCompat.d(this.a, this.b, (Configuration)var1);
   }
}
