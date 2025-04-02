package l;

import android.os.Trace;

final class b {
   public static void a(String var0) {
      Trace.beginSection(var0);
   }

   public static void b() {
      Trace.endSection();
   }
}
