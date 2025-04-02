package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class d0 {
   private static d0 c;
   private final LongSparseArray<MotionEvent> a = new LongSparseArray();
   private final PriorityQueue<Long> b = new PriorityQueue();

   private d0() {
   }

   public static d0 a() {
      if (c == null) {
         c = new d0();
      }

      return c;
   }

   public MotionEvent b(d0.a var1) {
      while(!this.b.isEmpty() && (Long)this.b.peek() < var1.a) {
         this.a.remove((Long)this.b.poll());
      }

      if (!this.b.isEmpty() && (Long)this.b.peek() == var1.a) {
         this.b.poll();
      }

      MotionEvent var2 = (MotionEvent)this.a.get(var1.a);
      this.a.remove(var1.a);
      return var2;
   }

   public d0.a c(MotionEvent var1) {
      d0.a var2 = d0.a.b();
      var1 = MotionEvent.obtain(var1);
      this.a.put(var2.a, var1);
      this.b.add(var2.a);
      return var2;
   }

   public static class a {
      private static final AtomicLong b = new AtomicLong(0L);
      private final long a;

      private a(long var1) {
         this.a = var1;
      }

      public static d0.a b() {
         return c(b.incrementAndGet());
      }

      public static d0.a c(long var0) {
         return new d0.a(var0);
      }

      public long d() {
         return this.a;
      }
   }
}
