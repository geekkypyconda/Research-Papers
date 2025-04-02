package r;

import java.util.List;

public final class j {
   private final List<a> a;

   public j(List<? extends a> var1) {
      a1.k.e(var1, "displayFeatures");
      super();
      this.a = var1;
   }

   public final List<a> a() {
      return this.a;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && a1.k.a(j.class, var1.getClass())) {
         j var2 = (j)var1;
         return a1.k.a(this.a, var2.a);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.a.hashCode();
   }

   public String toString() {
      return q0.l.o(this.a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, (CharSequence)null, (z0.l)null, 56, (Object)null);
   }
}
