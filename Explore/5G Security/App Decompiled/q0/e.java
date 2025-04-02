package q0;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<E> extends c<E> {
   public static final e.a h = new e.a((a1.g)null);
   private static final Object[] i = new Object[0];
   private int e;
   private Object[] f;
   private int g;

   public e() {
      this.f = i;
   }

   private final void c(int var1, Collection<? extends E> var2) {
      Iterator var3 = var2.iterator();

      int var4;
      for(var4 = this.f.length; var1 < var4 && var3.hasNext(); ++var1) {
         this.f[var1] = var3.next();
      }

      var1 = 0;

      for(var4 = this.e; var1 < var4 && var3.hasNext(); ++var1) {
         this.f[var1] = var3.next();
      }

      this.g = this.size() + var2.size();
   }

   private final void d(int var1) {
      Object[] var2 = new Object[var1];
      Object[] var3 = this.f;
      q0.i.c(var3, var2, 0, this.e, var3.length);
      var3 = this.f;
      var1 = var3.length;
      int var4 = this.e;
      q0.i.c(var3, var2, var1 - var4, 0, var4);
      this.e = 0;
      this.f = var2;
   }

   private final int e(int var1) {
      if (var1 == 0) {
         var1 = j.h(this.f);
      } else {
         --var1;
      }

      return var1;
   }

   private final void f(int var1) {
      if (var1 >= 0) {
         Object[] var2 = this.f;
         if (var1 > var2.length) {
            if (var2 == i) {
               this.f = new Object[d1.d.a(var1, 10)];
            } else {
               this.d(h.a(var2.length, var1));
            }
         }
      } else {
         throw new IllegalStateException("Deque is too big.");
      }
   }

   private final int g(int var1) {
      if (var1 == j.h(this.f)) {
         var1 = 0;
      } else {
         ++var1;
      }

      return var1;
   }

   private final int h(int var1) {
      int var2 = var1;
      if (var1 < 0) {
         var2 = var1 + this.f.length;
      }

      return var2;
   }

   private final int i(int var1) {
      Object[] var2 = this.f;
      int var3 = var1;
      if (var1 >= var2.length) {
         var3 = var1 - var2.length;
      }

      return var3;
   }

   public int a() {
      return this.g;
   }

   public void add(int var1, E var2) {
      b.e.b(var1, this.size());
      if (var1 == this.size()) {
         this.addLast(var2);
      } else if (var1 == 0) {
         this.addFirst(var2);
      } else {
         this.f(this.size() + 1);
         int var3 = this.i(this.e + var1);
         Object[] var5;
         if (var1 < this.size() + 1 >> 1) {
            int var4 = this.e(var3);
            var1 = this.e(this.e);
            var3 = this.e;
            if (var4 >= var3) {
               var5 = this.f;
               var5[var1] = var5[var3];
               q0.i.c(var5, var5, var3, var3 + 1, var4 + 1);
            } else {
               var5 = this.f;
               q0.i.c(var5, var5, var3 - 1, var3, var5.length);
               var5 = this.f;
               var5[var5.length - 1] = var5[0];
               q0.i.c(var5, var5, 0, 1, var4 + 1);
            }

            this.f[var4] = var2;
            this.e = var1;
         } else {
            var1 = this.i(this.e + this.size());
            var5 = this.f;
            if (var3 < var1) {
               q0.i.c(var5, var5, var3 + 1, var3, var1);
            } else {
               q0.i.c(var5, var5, 1, 0, var1);
               var5 = this.f;
               var5[0] = var5[var5.length - 1];
               q0.i.c(var5, var5, var3 + 1, var3, var5.length - 1);
            }

            this.f[var3] = var2;
         }

         this.g = this.size() + 1;
      }
   }

   public boolean add(E var1) {
      this.addLast(var1);
      return true;
   }

   public boolean addAll(int var1, Collection<? extends E> var2) {
      a1.k.e(var2, "elements");
      b.e.b(var1, this.size());
      if (var2.isEmpty()) {
         return false;
      } else if (var1 == this.size()) {
         return this.addAll(var2);
      } else {
         this.f(this.size() + var2.size());
         int var3 = this.i(this.e + this.size());
         int var4 = this.i(this.e + var1);
         int var5 = var2.size();
         Object[] var6;
         if (var1 < this.size() + 1 >> 1) {
            var3 = this.e;
            var1 = var3 - var5;
            if (var4 >= var3) {
               if (var1 >= 0) {
                  var6 = this.f;
                  q0.i.c(var6, var6, var1, var3, var4);
               } else {
                  var6 = this.f;
                  var1 += var6.length;
                  int var7 = var6.length - var1;
                  if (var7 >= var4 - var3) {
                     q0.i.c(var6, var6, var1, var3, var4);
                  } else {
                     q0.i.c(var6, var6, var1, var3, var3 + var7);
                     var6 = this.f;
                     q0.i.c(var6, var6, 0, this.e + var7, var4);
                  }
               }
            } else {
               var6 = this.f;
               q0.i.c(var6, var6, var1, var3, var6.length);
               var6 = this.f;
               if (var5 >= var4) {
                  q0.i.c(var6, var6, var6.length - var5, 0, var4);
               } else {
                  q0.i.c(var6, var6, var6.length - var5, 0, var5);
                  var6 = this.f;
                  q0.i.c(var6, var6, 0, var5, var4);
               }
            }

            this.e = var1;
            this.c(this.h(var4 - var5), var2);
         } else {
            var1 = var4 + var5;
            if (var4 < var3) {
               label41: {
                  var5 += var3;
                  var6 = this.f;
                  if (var5 > var6.length) {
                     if (var1 < var6.length) {
                        var5 = var3 - (var5 - var6.length);
                        q0.i.c(var6, var6, 0, var5, var3);
                        var6 = this.f;
                        q0.i.c(var6, var6, var1, var4, var5);
                        break label41;
                     }

                     var1 -= var6.length;
                  }

                  q0.i.c(var6, var6, var1, var4, var3);
               }
            } else {
               var6 = this.f;
               q0.i.c(var6, var6, var5, 0, var3);
               var6 = this.f;
               if (var1 >= var6.length) {
                  q0.i.c(var6, var6, var1 - var6.length, var4, var6.length);
               } else {
                  q0.i.c(var6, var6, 0, var6.length - var5, var6.length);
                  var6 = this.f;
                  q0.i.c(var6, var6, var1, var4, var6.length - var5);
               }
            }

            this.c(var4, var2);
         }

         return true;
      }
   }

   public boolean addAll(Collection<? extends E> var1) {
      a1.k.e(var1, "elements");
      if (var1.isEmpty()) {
         return false;
      } else {
         this.f(this.size() + var1.size());
         this.c(this.i(this.e + this.size()), var1);
         return true;
      }
   }

   public final void addFirst(E var1) {
      this.f(this.size() + 1);
      int var2 = this.e(this.e);
      this.e = var2;
      this.f[var2] = var1;
      this.g = this.size() + 1;
   }

   public final void addLast(E var1) {
      this.f(this.size() + 1);
      this.f[this.i(this.e + this.size())] = var1;
      this.g = this.size() + 1;
   }

   public E b(int var1) {
      b.e.a(var1, this.size());
      if (var1 == l.f(this)) {
         return this.removeLast();
      } else if (var1 == 0) {
         return this.removeFirst();
      } else {
         int var2 = this.i(this.e + var1);
         Object var3 = this.f[var2];
         Object[] var4;
         if (var1 < this.size() >> 1) {
            var1 = this.e;
            if (var2 >= var1) {
               var4 = this.f;
               q0.i.c(var4, var4, var1 + 1, var1, var2);
            } else {
               var4 = this.f;
               q0.i.c(var4, var4, 1, 0, var2);
               var4 = this.f;
               var4[0] = var4[var4.length - 1];
               var1 = this.e;
               q0.i.c(var4, var4, var1 + 1, var1, var4.length - 1);
            }

            var4 = this.f;
            var1 = this.e;
            var4[var1] = null;
            this.e = this.g(var1);
         } else {
            var1 = this.i(this.e + l.f(this));
            var4 = this.f;
            if (var2 <= var1) {
               q0.i.c(var4, var4, var2, var2 + 1, var1 + 1);
            } else {
               q0.i.c(var4, var4, var2, var2 + 1, var4.length);
               var4 = this.f;
               var4[var4.length - 1] = var4[0];
               q0.i.c(var4, var4, 0, 1, var1 + 1);
            }

            this.f[var1] = null;
         }

         this.g = this.size() - 1;
         return var3;
      }
   }

   public void clear() {
      int var1 = this.i(this.e + this.size());
      int var2 = this.e;
      if (var2 < var1) {
         q0.i.e(this.f, (Object)null, var2, var1);
      } else if (this.isEmpty() ^ true) {
         Object[] var3 = this.f;
         q0.i.e(var3, (Object)null, this.e, var3.length);
         q0.i.e(this.f, (Object)null, 0, var1);
      }

      this.e = 0;
      this.g = 0;
   }

   public boolean contains(Object var1) {
      boolean var2;
      if (this.indexOf(var1) != -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public E get(int var1) {
      b.e.a(var1, this.size());
      return this.f[this.i(this.e + var1)];
   }

   public int indexOf(Object var1) {
      int var2 = this.i(this.e + this.size());
      int var3 = this.e;
      if (var3 < var2) {
         while(true) {
            if (var3 >= var2) {
               return -1;
            }

            if (a1.k.a(var1, this.f[var3])) {
               break;
            }

            ++var3;
         }
      } else {
         if (var3 < var2) {
            return -1;
         }

         int var4 = this.f.length;

         while(true) {
            if (var3 >= var4) {
               for(var3 = 0; var3 < var2; ++var3) {
                  if (a1.k.a(var1, this.f[var3])) {
                     var3 += this.f.length;
                     return var3 - this.e;
                  }
               }

               return -1;
            }

            if (a1.k.a(var1, this.f[var3])) {
               break;
            }

            ++var3;
         }
      }

      return var3 - this.e;
   }

   public boolean isEmpty() {
      boolean var1;
      if (this.size() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final E j() {
      Object var1;
      if (this.isEmpty()) {
         var1 = null;
      } else {
         var1 = this.removeFirst();
      }

      return var1;
   }

   public int lastIndexOf(Object var1) {
      int var2 = this.i(this.e + this.size());
      int var3 = this.e;
      if (var3 < var2) {
         --var2;
         if (var3 > var2) {
            return -1;
         }

         while(!a1.k.a(var1, this.f[var2])) {
            if (var2 == var3) {
               return -1;
            }

            --var2;
         }
      } else {
         if (var3 <= var2) {
            return -1;
         }

         --var2;

         while(true) {
            if (-1 >= var2) {
               var2 = j.h(this.f);
               var3 = this.e;
               if (var3 > var2) {
                  return -1;
               }

               while(!a1.k.a(var1, this.f[var2])) {
                  if (var2 == var3) {
                     return -1;
                  }

                  --var2;
               }

               return var2 - this.e;
            }

            if (a1.k.a(var1, this.f[var2])) {
               var2 += this.f.length;
               break;
            }

            --var2;
         }
      }

      return var2 - this.e;
   }

   public boolean remove(Object var1) {
      int var2 = this.indexOf(var1);
      if (var2 == -1) {
         return false;
      } else {
         this.remove(var2);
         return true;
      }
   }

   public boolean removeAll(Collection<? extends Object> var1) {
      a1.k.e(var1, "elements");
      boolean var2 = this.isEmpty();
      byte var3 = 0;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = var4;
      if (!var2) {
         boolean var7;
         if (this.f.length == 0) {
            var7 = true;
         } else {
            var7 = false;
         }

         if (var7) {
            var6 = var4;
         } else {
            int var8 = this.i(this.e + this.size());
            int var13 = this.e;
            int var9;
            Object var10;
            if (var13 < var8) {
               for(var9 = var13; var13 < var8; ++var13) {
                  var10 = this.f[var13];
                  if (var1.contains(var10) ^ true) {
                     this.f[var9] = var10;
                     ++var9;
                  } else {
                     var5 = true;
                  }
               }

               q0.i.e(this.f, (Object)null, var9, var8);
               var13 = var9;
            } else {
               int var11 = this.f.length;
               var9 = var13;

               for(var5 = false; var13 < var11; ++var13) {
                  Object[] var12 = this.f;
                  var10 = var12[var13];
                  var12[var13] = null;
                  if (var1.contains(var10) ^ true) {
                     this.f[var9] = var10;
                     ++var9;
                  } else {
                     var5 = true;
                  }
               }

               var13 = this.i(var9);

               for(var9 = var3; var9 < var8; ++var9) {
                  Object[] var14 = this.f;
                  Object var15 = var14[var9];
                  var14[var9] = null;
                  if (var1.contains(var15) ^ true) {
                     this.f[var13] = var15;
                     var13 = this.g(var13);
                  } else {
                     var5 = true;
                  }
               }
            }

            var6 = var5;
            if (var5) {
               this.g = this.h(var13 - this.e);
               var6 = var5;
            }
         }
      }

      return var6;
   }

   public final E removeFirst() {
      if (!this.isEmpty()) {
         Object[] var1 = this.f;
         int var2 = this.e;
         Object var3 = var1[var2];
         var1[var2] = null;
         this.e = this.g(var2);
         this.g = this.size() - 1;
         return var3;
      } else {
         throw new NoSuchElementException("ArrayDeque is empty.");
      }
   }

   public final E removeLast() {
      if (!this.isEmpty()) {
         int var1 = this.i(this.e + l.f(this));
         Object[] var2 = this.f;
         Object var3 = var2[var1];
         var2[var1] = null;
         this.g = this.size() - 1;
         return var3;
      } else {
         throw new NoSuchElementException("ArrayDeque is empty.");
      }
   }

   public boolean retainAll(Collection<? extends Object> var1) {
      a1.k.e(var1, "elements");
      boolean var2 = this.isEmpty();
      byte var3 = 0;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = var4;
      if (!var2) {
         boolean var7;
         if (this.f.length == 0) {
            var7 = true;
         } else {
            var7 = false;
         }

         if (var7) {
            var6 = var4;
         } else {
            int var8 = this.i(this.e + this.size());
            int var13 = this.e;
            int var9;
            if (var13 < var8) {
               for(var9 = var13; var13 < var8; ++var13) {
                  Object var14 = this.f[var13];
                  if (var1.contains(var14)) {
                     this.f[var9] = var14;
                     ++var9;
                  } else {
                     var5 = true;
                  }
               }

               q0.i.e(this.f, (Object)null, var9, var8);
               var13 = var9;
            } else {
               int var11 = this.f.length;
               var9 = var13;

               Object[] var10;
               Object var12;
               for(var5 = false; var13 < var11; ++var13) {
                  var10 = this.f;
                  var12 = var10[var13];
                  var10[var13] = null;
                  if (var1.contains(var12)) {
                     this.f[var9] = var12;
                     ++var9;
                  } else {
                     var5 = true;
                  }
               }

               var13 = this.i(var9);

               for(var9 = var3; var9 < var8; ++var9) {
                  var10 = this.f;
                  var12 = var10[var9];
                  var10[var9] = null;
                  if (var1.contains(var12)) {
                     this.f[var13] = var12;
                     var13 = this.g(var13);
                  } else {
                     var5 = true;
                  }
               }
            }

            var6 = var5;
            if (var5) {
               this.g = this.h(var13 - this.e);
               var6 = var5;
            }
         }
      }

      return var6;
   }

   public E set(int var1, E var2) {
      b.e.a(var1, this.size());
      var1 = this.i(this.e + var1);
      Object[] var3 = this.f;
      Object var4 = var3[var1];
      var3[var1] = var2;
      return var4;
   }

   public Object[] toArray() {
      return this.toArray(new Object[this.size()]);
   }

   public <T> T[] toArray(T[] var1) {
      a1.k.e(var1, "array");
      if (var1.length < this.size()) {
         var1 = q0.g.a(var1, this.size());
      }

      int var2 = this.i(this.e + this.size());
      int var3 = this.e;
      if (var3 < var2) {
         q0.i.d(this.f, var1, 0, var3, var2, 2, (Object)null);
      } else if (this.isEmpty() ^ true) {
         Object[] var4 = this.f;
         q0.i.c(var4, var1, 0, this.e, var4.length);
         var4 = this.f;
         q0.i.c(var4, var1, var4.length - this.e, 0, var2);
      }

      if (var1.length > this.size()) {
         var1[this.size()] = null;
      }

      return var1;
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      public final int a(int var1, int var2) {
         int var3 = var1 + (var1 >> 1);
         var1 = var3;
         if (var3 - var2 < 0) {
            var1 = var2;
         }

         var3 = var1;
         if (var1 - 2147483639 > 0) {
            if (var2 > 2147483639) {
               var3 = Integer.MAX_VALUE;
            } else {
               var3 = 2147483639;
            }
         }

         return var3;
      }
   }
}
