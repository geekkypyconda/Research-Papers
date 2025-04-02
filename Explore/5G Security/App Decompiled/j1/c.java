package j1;

import m1.h0;
import m1.i0;

public final class c {
   private static final j<Object> a = new j(-1L, (j)null, (b)null, 0);
   public static final int b = i0.g("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object)null);
   private static final int c = i0.g("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object)null);
   public static final h0 d = new h0("BUFFERED");
   private static final h0 e = new h0("SHOULD_BUFFER");
   private static final h0 f = new h0("S_RESUMING_BY_RCV");
   private static final h0 g = new h0("RESUMING_BY_EB");
   private static final h0 h = new h0("POISONED");
   private static final h0 i = new h0("DONE_RCV");
   private static final h0 j = new h0("INTERRUPTED_SEND");
   private static final h0 k = new h0("INTERRUPTED_RCV");
   private static final h0 l = new h0("CHANNEL_CLOSED");
   private static final h0 m = new h0("SUSPEND");
   private static final h0 n = new h0("SUSPEND_NO_WAITER");
   private static final h0 o = new h0("FAILED");
   private static final h0 p = new h0("NO_RECEIVE_RESULT");
   private static final h0 q = new h0("CLOSE_HANDLER_CLOSED");
   private static final h0 r = new h0("CLOSE_HANDLER_INVOKED");
   private static final h0 s = new h0("NO_CLOSE_CAUSE");

   private static final long A(int var0) {
      long var1;
      if (var0 != 0) {
         if (var0 != Integer.MAX_VALUE) {
            var1 = (long)var0;
         } else {
            var1 = Long.MAX_VALUE;
         }
      } else {
         var1 = 0L;
      }

      return var1;
   }

   private static final <T> boolean B(h1.j<? super T> var0, T var1, z0.l<? super Throwable, p0.q> var2) {
      var1 = var0.l(var1, (Object)null, var2);
      boolean var3;
      if (var1 != null) {
         var0.C(var1);
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   // $FF: synthetic method
   static boolean C(h1.j var0, Object var1, z0.l var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      return B(var0, var1, var2);
   }

   // $FF: synthetic method
   public static final long a(long var0, boolean var2) {
      return v(var0, var2);
   }

   // $FF: synthetic method
   public static final long b(long var0, int var2) {
      return w(var0, var2);
   }

   // $FF: synthetic method
   public static final h0 d() {
      return q;
   }

   // $FF: synthetic method
   public static final h0 e() {
      return r;
   }

   // $FF: synthetic method
   public static final h0 f() {
      return i;
   }

   // $FF: synthetic method
   public static final int g() {
      return c;
   }

   // $FF: synthetic method
   public static final h0 h() {
      return o;
   }

   // $FF: synthetic method
   public static final h0 i() {
      return k;
   }

   // $FF: synthetic method
   public static final h0 j() {
      return j;
   }

   // $FF: synthetic method
   public static final h0 k() {
      return e;
   }

   // $FF: synthetic method
   public static final h0 l() {
      return s;
   }

   // $FF: synthetic method
   public static final h0 m() {
      return p;
   }

   // $FF: synthetic method
   public static final j n() {
      return a;
   }

   // $FF: synthetic method
   public static final h0 o() {
      return h;
   }

   // $FF: synthetic method
   public static final h0 p() {
      return g;
   }

   // $FF: synthetic method
   public static final h0 q() {
      return f;
   }

   // $FF: synthetic method
   public static final h0 r() {
      return m;
   }

   // $FF: synthetic method
   public static final h0 s() {
      return n;
   }

   // $FF: synthetic method
   public static final long t(int var0) {
      return A(var0);
   }

   // $FF: synthetic method
   public static final boolean u(h1.j var0, Object var1, z0.l var2) {
      return B(var0, var1, var2);
   }

   private static final long v(long var0, boolean var2) {
      long var3;
      if (var2) {
         var3 = 4611686018427387904L;
      } else {
         var3 = 0L;
      }

      return var3 + var0;
   }

   private static final long w(long var0, int var2) {
      return ((long)var2 << 60) + var0;
   }

   private static final <E> j<E> x(long var0, j<E> var2) {
      return new j(var0, var2, var2.u(), 0);
   }

   public static final <E> e1.e<j<E>> y() {
      return null.n;
   }

   public static final h0 z() {
      return l;
   }
}
