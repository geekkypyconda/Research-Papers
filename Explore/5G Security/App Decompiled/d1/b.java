package d1;

import java.util.NoSuchElementException;
import q0.a0;

public final class b extends a0 {
   private final int e;
   private final int f;
   private boolean g;
   private int h;

   public b(int var1, int var2, int var3) {
      boolean var4;
      label20: {
         super();
         this.e = var3;
         this.f = var2;
         var4 = true;
         if (var3 > 0) {
            if (var1 <= var2) {
               break label20;
            }
         } else if (var1 >= var2) {
            break label20;
         }

         var4 = false;
      }

      this.g = var4;
      if (!var4) {
         var1 = var2;
      }

      this.h = var1;
   }

   public boolean hasNext() {
      return this.g;
   }

   public int nextInt() {
      int var1 = this.h;
      if (var1 == this.f) {
         if (!this.g) {
            throw new NoSuchElementException();
         }

         this.g = false;
      } else {
         this.h = this.e + var1;
      }

      return var1;
   }
}
