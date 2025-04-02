package t0;

public abstract class j extends a {
   public j(r0.d<Object> var1) {
      super(var1);
      if (var1 != null) {
         boolean var2;
         if (var1.a() == r0.h.e) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (!var2) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
         }
      }

   }

   public r0.g a() {
      return r0.h.e;
   }
}
