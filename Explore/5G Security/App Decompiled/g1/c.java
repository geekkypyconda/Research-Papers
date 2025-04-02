package g1;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class c implements f1.b<d1.c> {
   private final CharSequence a;
   private final int b;
   private final int c;
   private final z0.p<CharSequence, Integer, p0.j<Integer, Integer>> d;

   public c(CharSequence var1, int var2, int var3, z0.p<? super CharSequence, ? super Integer, p0.j<Integer, Integer>> var4) {
      a1.k.e(var1, "input");
      a1.k.e(var4, "getNextMatch");
      super();
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public Iterator<d1.c> iterator() {
      return new Iterator<d1.c>() {
         private int e = -1;
         private int f;
         private int g;
         private d1.c h;
         private int i;

         {
            int var2 = d1.d.e(c.this.b, 0, c.this.a.length());
            this.f = var2;
            this.g = var2;
         }

         private final void a() {
            int var1 = this.g;
            byte var2 = 0;
            if (var1 < 0) {
               this.e = 0;
               this.h = null;
            } else {
               int var6;
               label31: {
                  byte var5;
                  d1.c var7;
                  label30: {
                     label29: {
                        int var3 = c.this.c;
                        var5 = -1;
                        if (var3 > 0) {
                           var3 = this.i + 1;
                           this.i = var3;
                           if (var3 >= c.this.c) {
                              break label29;
                           }
                        }

                        if (this.g <= c.this.a.length()) {
                           p0.j var4 = (p0.j)c.this.d.h(c.this.a, this.g);
                           if (var4 != null) {
                              var3 = ((Number)var4.a()).intValue();
                              var1 = ((Number)var4.b()).intValue();
                              this.h = d1.d.g(this.f, var3);
                              var3 += var1;
                              this.f = var3;
                              if (var1 == 0) {
                                 var2 = 1;
                              }

                              var6 = var3 + var2;
                              break label31;
                           }

                           var7 = new d1.c(this.f, n.q(c.this.a));
                           break label30;
                        }
                     }

                     var7 = new d1.c(this.f, n.q(c.this.a));
                  }

                  this.h = var7;
                  var6 = var5;
               }

               this.g = var6;
               this.e = 1;
            }

         }

         public d1.c b() {
            if (this.e == -1) {
               this.a();
            }

            if (this.e != 0) {
               d1.c var1 = this.h;
               a1.k.c(var1, "null cannot be cast to non-null type kotlin.ranges.IntRange");
               this.h = null;
               this.e = -1;
               return var1;
            } else {
               throw new NoSuchElementException();
            }
         }

         public boolean hasNext() {
            if (this.e == -1) {
               this.a();
            }

            int var1 = this.e;
            boolean var2 = true;
            if (var1 != 1) {
               var2 = false;
            }

            return var2;
         }

         public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
         }
      };
   }
}
