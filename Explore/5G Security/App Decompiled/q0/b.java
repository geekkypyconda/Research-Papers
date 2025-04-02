package q0;

import java.util.List;

public abstract class b<E> extends q0.a<E> implements List<E> {
   public static final b.a e = new b.a((a1.g)null);

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      public final void a(int var1, int var2) {
         if (var1 < 0 || var1 >= var2) {
            StringBuilder var3 = new StringBuilder();
            var3.append("index: ");
            var3.append(var1);
            var3.append(", size: ");
            var3.append(var2);
            throw new IndexOutOfBoundsException(var3.toString());
         }
      }

      public final void b(int var1, int var2) {
         if (var1 < 0 || var1 > var2) {
            StringBuilder var3 = new StringBuilder();
            var3.append("index: ");
            var3.append(var1);
            var3.append(", size: ");
            var3.append(var2);
            throw new IndexOutOfBoundsException(var3.toString());
         }
      }
   }
}
