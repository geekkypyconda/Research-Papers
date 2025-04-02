package m1;

import java.util.concurrent.atomic.AtomicReferenceArray;

public final class c0<T> {
   private volatile AtomicReferenceArray<T> array;

   public c0(int var1) {
      this.array = new AtomicReferenceArray(var1);
   }

   public final int a() {
      return this.array.length();
   }

   public final T b(int var1) {
      AtomicReferenceArray var2 = this.array;
      Object var3;
      if (var1 < var2.length()) {
         var3 = var2.get(var1);
      } else {
         var3 = null;
      }

      return var3;
   }

   public final void c(int var1, T var2) {
      AtomicReferenceArray var3 = this.array;
      int var4 = var3.length();
      if (var1 < var4) {
         var3.set(var1, var2);
      } else {
         AtomicReferenceArray var5 = new AtomicReferenceArray(d1.d.a(var1 + 1, var4 * 2));

         for(int var6 = 0; var6 < var4; ++var6) {
            var5.set(var6, var3.get(var6));
         }

         var5.set(var1, var2);
         this.array = var5;
      }
   }
}
