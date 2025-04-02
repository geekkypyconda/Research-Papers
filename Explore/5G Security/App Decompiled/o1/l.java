package o1;

import java.util.concurrent.TimeUnit;
import m1.i0;

public final class l {
   public static final String a = i0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
   public static final long b = i0.h("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object)null);
   public static final int c = i0.g("kotlinx.coroutines.scheduler.core.pool.size", d1.d.a(i0.a(), 2), 1, 0, 8, (Object)null);
   public static final int d = i0.g("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object)null);
   public static final long e;
   public static g f;
   public static final i g;
   public static final i h;

   static {
      e = TimeUnit.SECONDS.toNanos(i0.h("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object)null));
      f = o1.e.a;
      g = new j(0);
      h = new j(1);
   }
}
