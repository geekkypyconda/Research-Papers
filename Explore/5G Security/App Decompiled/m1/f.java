package m1;

public final class f implements h1.e0 {
   private final r0.g e;

   public f(r0.g var1) {
      this.e = var1;
   }

   public r0.g r() {
      return this.e;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("CoroutineScope(coroutineContext=");
      var1.append(this.r());
      var1.append(')');
      return var1.toString();
   }
}
