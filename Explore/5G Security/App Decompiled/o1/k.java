package o1;

import h1.i0;

public final class k extends h {
   public final Runnable g;

   public k(Runnable var1, long var2, i var4) {
      super(var2, var4);
      this.g = var1;
   }

   public void run() {
      try {
         this.g.run();
      } finally {
         super.f.b();
      }

   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Task[");
      var1.append(i0.a(this.g));
      var1.append('@');
      var1.append(i0.b(this.g));
      var1.append(", ");
      var1.append(super.e);
      var1.append(", ");
      var1.append(super.f);
      var1.append(']');
      return var1.toString();
   }
}
