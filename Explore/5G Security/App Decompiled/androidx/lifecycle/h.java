package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class h {
   private AtomicReference<Object> a = new AtomicReference();

   public abstract void a(k var1);

   public static enum a {
      public static final h.a.a Companion = new h.a.a((a1.g)null);
      ON_ANY,
      ON_CREATE,
      ON_DESTROY,
      ON_PAUSE,
      ON_RESUME,
      ON_START,
      ON_STOP;

      // $FF: synthetic method
      private static final h.a[] a() {
         return new h.a[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY};
      }

      public final h.b b() {
         switch(h.a.b.a[this.ordinal()]) {
         case 1:
         case 2:
            return h.b.g;
         case 3:
         case 4:
            return h.b.h;
         case 5:
            return h.b.i;
         case 6:
            return h.b.e;
         default:
            StringBuilder var1 = new StringBuilder();
            var1.append(this);
            var1.append(" has no target state");
            throw new IllegalArgumentException(var1.toString());
         }
      }

      public static final class a {
         private a() {
         }

         // $FF: synthetic method
         public a(a1.g var1) {
            this();
         }

         public final h.a a(h.b var1) {
            a1.k.e(var1, "state");
            int var2 = h.a.a.a.a[var1.ordinal()];
            h.a var3;
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 3) {
                     var3 = null;
                  } else {
                     var3 = h.a.ON_PAUSE;
                  }
               } else {
                  var3 = h.a.ON_STOP;
               }
            } else {
               var3 = h.a.ON_DESTROY;
            }

            return var3;
         }

         public final h.a b(h.b var1) {
            a1.k.e(var1, "state");
            int var2 = h.a.a.a.a[var1.ordinal()];
            h.a var3;
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 5) {
                     var3 = null;
                  } else {
                     var3 = h.a.ON_CREATE;
                  }
               } else {
                  var3 = h.a.ON_RESUME;
               }
            } else {
               var3 = h.a.ON_START;
            }

            return var3;
         }

         // $FF: synthetic class
         public final class a {
            // $FF: synthetic field
            public static final int[] a;

            static {
               int[] var0 = new int[h.b.values().length];

               try {
                  var0[h.b.g.ordinal()] = 1;
               } catch (NoSuchFieldError var6) {
               }

               try {
                  var0[h.b.h.ordinal()] = 2;
               } catch (NoSuchFieldError var5) {
               }

               try {
                  var0[h.b.i.ordinal()] = 3;
               } catch (NoSuchFieldError var4) {
               }

               try {
                  var0[h.b.e.ordinal()] = 4;
               } catch (NoSuchFieldError var3) {
               }

               try {
                  var0[h.b.f.ordinal()] = 5;
               } catch (NoSuchFieldError var2) {
               }

               a = var0;
            }
         }
      }

      // $FF: synthetic class
      public final class b {
         // $FF: synthetic field
         public static final int[] a;

         static {
            int[] var0 = new int[h.a.values().length];

            try {
               var0[h.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError var8) {
            }

            try {
               var0[h.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError var7) {
            }

            try {
               var0[h.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError var6) {
            }

            try {
               var0[h.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError var5) {
            }

            try {
               var0[h.a.ON_RESUME.ordinal()] = 5;
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

   public static enum b {
      e,
      f,
      g,
      h,
      i;

      // $FF: synthetic method
      private static final h.b[] a() {
         return new h.b[]{e, f, g, h, i};
      }
   }
}
