package androidx.lifecycle;

public final class e implements j {
   private final d a;
   private final j b;

   public e(d var1, j var2) {
      a1.k.e(var1, "defaultLifecycleObserver");
      super();
      this.a = var1;
      this.b = var2;
   }

   public void d(l var1, h.a var2) {
      a1.k.e(var1, "source");
      a1.k.e(var2, "event");
      switch(e.a.a[var2.ordinal()]) {
      case 1:
         this.a.c(var1);
         break;
      case 2:
         this.a.g(var1);
         break;
      case 3:
         this.a.a(var1);
         break;
      case 4:
         this.a.e(var1);
         break;
      case 5:
         this.a.f(var1);
         break;
      case 6:
         this.a.b(var1);
         break;
      case 7:
         throw new IllegalArgumentException("ON_ANY must not been send by anybody");
      }

      j var3 = this.b;
      if (var3 != null) {
         var3.d(var1, var2);
      }

   }

   // $FF: synthetic class
   public final class a {
      // $FF: synthetic field
      public static final int[] a;

      static {
         int[] var0 = new int[h.a.values().length];

         try {
            var0[h.a.ON_CREATE.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[h.a.ON_START.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[h.a.ON_RESUME.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[h.a.ON_PAUSE.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[h.a.ON_STOP.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[h.a.ON_DESTROY.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[h.a.ON_ANY.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
         }

         a = var0;
      }
   }
}
