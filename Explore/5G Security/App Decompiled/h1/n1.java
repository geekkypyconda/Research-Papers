package h1;

public abstract class n1 extends w implements r0, d1 {
   public o1 h;

   public void a() {
      this.y().u0(this);
   }

   public boolean d() {
      return true;
   }

   public s1 f() {
      return null;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(i0.a(this));
      var1.append('@');
      var1.append(i0.b(this));
      var1.append("[job@");
      var1.append(i0.b(this.y()));
      var1.append(']');
      return var1.toString();
   }

   public final o1 y() {
      o1 var1 = this.h;
      if (var1 != null) {
         return var1;
      } else {
         a1.k.n("job");
         return null;
      }
   }

   public final void z(o1 var1) {
      this.h = var1;
   }
}
