package m1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class b<T> extends a0 {
   private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
   private volatile Object _consensus;

   public b() {
      this._consensus = m1.a.a;
   }

   private final Object c(Object var1) {
      AtomicReferenceFieldUpdater var2 = a;
      Object var3 = var2.get(this);
      Object var4 = m1.a.a;
      if (var3 != var4) {
         return var3;
      } else {
         return androidx.concurrent.futures.b.a(var2, this, var4, var1) ? var1 : var2.get(this);
      }
   }

   public final Object a(Object var1) {
      Object var2 = a.get(this);
      Object var3 = var2;
      if (var2 == m1.a.a) {
         var3 = this.c(this.d(var1));
      }

      this.b(var1, var3);
      return var3;
   }

   public abstract void b(T var1, Object var2);

   public abstract Object d(T var1);
}
