package e;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class d<K, V> {
   static Object[] h;
   static int i;
   static Object[] j;
   static int k;
   int[] e;
   Object[] f;
   int g;

   public d() {
      this.e = b.a;
      this.f = b.c;
      this.g = 0;
   }

   private void a(int var1) {
      Throwable var10000;
      boolean var10001;
      Throwable var113;
      label951: {
         Object[] var2;
         if (var1 == 8) {
            synchronized(d.class){}

            try {
               var2 = j;
            } catch (Throwable var110) {
               var10000 = var110;
               var10001 = false;
               break label951;
            }

            if (var2 != null) {
               try {
                  this.f = var2;
                  j = (Object[])var2[0];
                  this.e = (int[])var2[1];
               } catch (Throwable var106) {
                  var10000 = var106;
                  var10001 = false;
                  break label951;
               }

               var2[1] = null;
               var2[0] = null;

               try {
                  --k;
                  return;
               } catch (Throwable var105) {
                  var10000 = var105;
                  var10001 = false;
                  break label951;
               }
            }

            try {
               ;
            } catch (Throwable var109) {
               var10000 = var109;
               var10001 = false;
               break label951;
            }
         } else if (var1 == 4) {
            label950: {
               synchronized(d.class){}

               label936: {
                  try {
                     var2 = h;
                  } catch (Throwable var112) {
                     var10000 = var112;
                     var10001 = false;
                     break label936;
                  }

                  if (var2 != null) {
                     label948: {
                        try {
                           this.f = var2;
                           h = (Object[])var2[0];
                           this.e = (int[])var2[1];
                        } catch (Throwable var108) {
                           var10000 = var108;
                           var10001 = false;
                           break label948;
                        }

                        var2[1] = null;
                        var2[0] = null;

                        label916:
                        try {
                           --i;
                           return;
                        } catch (Throwable var107) {
                           var10000 = var107;
                           var10001 = false;
                           break label916;
                        }
                     }
                  } else {
                     label932:
                     try {
                        break label950;
                     } catch (Throwable var111) {
                        var10000 = var111;
                        var10001 = false;
                        break label932;
                     }
                  }
               }

               while(true) {
                  var113 = var10000;

                  try {
                     throw var113;
                  } catch (Throwable var104) {
                     var10000 = var104;
                     var10001 = false;
                     continue;
                  }
               }
            }
         }

         this.e = new int[var1];
         this.f = new Object[var1 << 1];
         return;
      }

      while(true) {
         var113 = var10000;

         try {
            throw var113;
         } catch (Throwable var103) {
            var10000 = var103;
            var10001 = false;
            continue;
         }
      }
   }

   private static int b(int[] var0, int var1, int var2) {
      try {
         var1 = b.a(var0, var1, var2);
         return var1;
      } catch (ArrayIndexOutOfBoundsException var3) {
         throw new ConcurrentModificationException();
      }
   }

   private static void d(int[] var0, Object[] var1, int var2) {
      Throwable var75;
      Throwable var10000;
      boolean var10001;
      if (var0.length == 8) {
         synchronized(d.class){}

         label811: {
            label838: {
               try {
                  if (k >= 10) {
                     break label838;
                  }

                  var1[0] = j;
               } catch (Throwable var71) {
                  var10000 = var71;
                  var10001 = false;
                  break label811;
               }

               var1[1] = var0;
               var2 = (var2 << 1) - 1;

               while(true) {
                  if (var2 < 2) {
                     try {
                        j = var1;
                        ++k;
                        break;
                     } catch (Throwable var70) {
                        var10000 = var70;
                        var10001 = false;
                        break label811;
                     }
                  }

                  var1[var2] = null;
                  --var2;
               }
            }

            label798:
            try {
               return;
            } catch (Throwable var69) {
               var10000 = var69;
               var10001 = false;
               break label798;
            }
         }

         while(true) {
            var75 = var10000;

            try {
               throw var75;
            } catch (Throwable var67) {
               var10000 = var67;
               var10001 = false;
               continue;
            }
         }
      } else if (var0.length == 4) {
         synchronized(d.class){}

         label829: {
            label839: {
               try {
                  if (i >= 10) {
                     break label839;
                  }

                  var1[0] = h;
               } catch (Throwable var74) {
                  var10000 = var74;
                  var10001 = false;
                  break label829;
               }

               var1[1] = var0;
               var2 = (var2 << 1) - 1;

               while(true) {
                  if (var2 < 2) {
                     try {
                        h = var1;
                        ++i;
                        break;
                     } catch (Throwable var73) {
                        var10000 = var73;
                        var10001 = false;
                        break label829;
                     }
                  }

                  var1[var2] = null;
                  --var2;
               }
            }

            label816:
            try {
               return;
            } catch (Throwable var72) {
               var10000 = var72;
               var10001 = false;
               break label816;
            }
         }

         while(true) {
            var75 = var10000;

            try {
               throw var75;
            } catch (Throwable var68) {
               var10000 = var68;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public void c(int var1) {
      int var2 = this.g;
      int[] var3 = this.e;
      if (var3.length < var1) {
         Object[] var4 = this.f;
         this.a(var1);
         if (this.g > 0) {
            System.arraycopy(var3, 0, this.e, 0, var2);
            System.arraycopy(var4, 0, this.f, 0, var2 << 1);
         }

         d(var3, var4, var2);
      }

      if (this.g != var2) {
         throw new ConcurrentModificationException();
      }
   }

   public void clear() {
      int var1 = this.g;
      if (var1 > 0) {
         int[] var2 = this.e;
         Object[] var3 = this.f;
         this.e = b.a;
         this.f = b.c;
         this.g = 0;
         d(var2, var3, var1);
      }

      if (this.g > 0) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean containsKey(Object var1) {
      boolean var2;
      if (this.f(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean containsValue(Object var1) {
      boolean var2;
      if (this.h(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   int e(Object var1, int var2) {
      int var3 = this.g;
      if (var3 == 0) {
         return -1;
      } else {
         int var4 = b(this.e, var3, var2);
         if (var4 < 0) {
            return var4;
         } else if (var1.equals(this.f[var4 << 1])) {
            return var4;
         } else {
            int var5;
            for(var5 = var4 + 1; var5 < var3 && this.e[var5] == var2; ++var5) {
               if (var1.equals(this.f[var5 << 1])) {
                  return var5;
               }
            }

            --var4;

            while(var4 >= 0 && this.e[var4] == var2) {
               if (var1.equals(this.f[var4 << 1])) {
                  return var4;
               }

               --var4;
            }

            return var5;
         }
      }
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         boolean var10001;
         int var3;
         Object var4;
         Object var5;
         boolean var6;
         if (var1 instanceof d) {
            d var13 = (d)var1;
            if (this.size() != var13.size()) {
               return false;
            } else {
               var3 = 0;

               while(true) {
                  try {
                     if (var3 >= this.g) {
                        return true;
                     }

                     var4 = this.i(var3);
                     var1 = this.l(var3);
                     var5 = var13.get(var4);
                  } catch (ClassCastException | NullPointerException var9) {
                     var10001 = false;
                     break;
                  }

                  if (var1 == null) {
                     label67: {
                        if (var5 == null) {
                           try {
                              if (var13.containsKey(var4)) {
                                 break label67;
                              }
                           } catch (ClassCastException | NullPointerException var8) {
                              var10001 = false;
                              break;
                           }
                        }

                        return false;
                     }
                  } else {
                     try {
                        var6 = var1.equals(var5);
                     } catch (ClassCastException | NullPointerException var7) {
                        var10001 = false;
                        break;
                     }

                     if (!var6) {
                        return false;
                     }
                  }

                  ++var3;
               }

               return false;
            }
         } else {
            if (var1 instanceof Map) {
               Map var2 = (Map)var1;
               if (this.size() != var2.size()) {
                  return false;
               }

               var3 = 0;

               while(true) {
                  try {
                     if (var3 >= this.g) {
                        return true;
                     }

                     var1 = this.i(var3);
                     var4 = this.l(var3);
                     var5 = var2.get(var1);
                  } catch (ClassCastException | NullPointerException var12) {
                     var10001 = false;
                     break;
                  }

                  if (var4 == null) {
                     label91: {
                        if (var5 == null) {
                           try {
                              if (var2.containsKey(var1)) {
                                 break label91;
                              }
                           } catch (ClassCastException | NullPointerException var11) {
                              var10001 = false;
                              break;
                           }
                        }

                        return false;
                     }
                  } else {
                     try {
                        var6 = var4.equals(var5);
                     } catch (ClassCastException | NullPointerException var10) {
                        var10001 = false;
                        break;
                     }

                     if (!var6) {
                        return false;
                     }
                  }

                  ++var3;
               }
            }

            return false;
         }
      }
   }

   public int f(Object var1) {
      int var2;
      if (var1 == null) {
         var2 = this.g();
      } else {
         var2 = this.e(var1, var1.hashCode());
      }

      return var2;
   }

   int g() {
      int var1 = this.g;
      if (var1 == 0) {
         return -1;
      } else {
         int var2 = b(this.e, var1, 0);
         if (var2 < 0) {
            return var2;
         } else if (this.f[var2 << 1] == null) {
            return var2;
         } else {
            int var3;
            for(var3 = var2 + 1; var3 < var1 && this.e[var3] == 0; ++var3) {
               if (this.f[var3 << 1] == null) {
                  return var3;
               }
            }

            --var2;

            while(var2 >= 0 && this.e[var2] == 0) {
               if (this.f[var2 << 1] == null) {
                  return var2;
               }

               --var2;
            }

            return var3;
         }
      }
   }

   public V get(Object var1) {
      return this.getOrDefault(var1, (Object)null);
   }

   public V getOrDefault(Object var1, V var2) {
      int var3 = this.f(var1);
      if (var3 >= 0) {
         var2 = this.f[(var3 << 1) + 1];
      }

      return var2;
   }

   int h(Object var1) {
      int var2 = this.g * 2;
      Object[] var3 = this.f;
      int var4;
      if (var1 == null) {
         for(var4 = 1; var4 < var2; var4 += 2) {
            if (var3[var4] == null) {
               return var4 >> 1;
            }
         }
      } else {
         for(var4 = 1; var4 < var2; var4 += 2) {
            if (var1.equals(var3[var4])) {
               return var4 >> 1;
            }
         }
      }

      return -1;
   }

   public int hashCode() {
      int[] var1 = this.e;
      Object[] var2 = this.f;
      int var3 = this.g;
      int var4 = 1;
      int var5 = 0;

      int var6;
      for(var6 = 0; var5 < var3; var4 += 2) {
         Object var7 = var2[var4];
         int var8 = var1[var5];
         int var9;
         if (var7 == null) {
            var9 = 0;
         } else {
            var9 = var7.hashCode();
         }

         var6 += var9 ^ var8;
         ++var5;
      }

      return var6;
   }

   public K i(int var1) {
      return this.f[var1 << 1];
   }

   public boolean isEmpty() {
      boolean var1;
      if (this.g <= 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public V j(int var1) {
      Object[] var2 = this.f;
      int var3 = var1 << 1;
      Object var4 = var2[var3 + 1];
      int var5 = this.g;
      byte var6 = 0;
      if (var5 <= 1) {
         d(this.e, var2, var5);
         this.e = b.a;
         this.f = b.c;
         var1 = var6;
      } else {
         int var7 = var5 - 1;
         int[] var8 = this.e;
         int var9 = var8.length;
         int var11 = 8;
         if (var9 > 8 && var5 < var8.length / 3) {
            if (var5 > 8) {
               var11 = var5 + (var5 >> 1);
            }

            this.a(var11);
            if (var5 != this.g) {
               throw new ConcurrentModificationException();
            }

            if (var1 > 0) {
               System.arraycopy(var8, 0, this.e, 0, var1);
               System.arraycopy(var2, 0, this.f, 0, var3);
            }

            if (var1 < var7) {
               var11 = var1 + 1;
               int[] var12 = this.e;
               var9 = var7 - var1;
               System.arraycopy(var8, var11, var12, var1, var9);
               System.arraycopy(var2, var11 << 1, this.f, var3, var9 << 1);
            }
         } else {
            Object[] var10;
            if (var1 < var7) {
               var11 = var1 + 1;
               var9 = var7 - var1;
               System.arraycopy(var8, var11, var8, var1, var9);
               var10 = this.f;
               System.arraycopy(var10, var11 << 1, var10, var3, var9 << 1);
            }

            var10 = this.f;
            var1 = var7 << 1;
            var10[var1] = null;
            var10[var1 + 1] = null;
         }

         var1 = var7;
      }

      if (var5 == this.g) {
         this.g = var1;
         return var4;
      } else {
         throw new ConcurrentModificationException();
      }
   }

   public V k(int var1, V var2) {
      var1 = (var1 << 1) + 1;
      Object[] var3 = this.f;
      Object var4 = var3[var1];
      var3[var1] = var2;
      return var4;
   }

   public V l(int var1) {
      return this.f[(var1 << 1) + 1];
   }

   public V put(K var1, V var2) {
      int var3 = this.g;
      int var4;
      int var5;
      if (var1 == null) {
         var4 = this.g();
         var5 = 0;
      } else {
         var5 = var1.hashCode();
         var4 = this.e(var1, var5);
      }

      if (var4 >= 0) {
         var4 = (var4 << 1) + 1;
         Object[] var10 = this.f;
         Object var12 = var10[var4];
         var10[var4] = var2;
         return var12;
      } else {
         int var7 = var4;
         int[] var6 = this.e;
         if (var3 >= var6.length) {
            var4 = 4;
            if (var3 >= 8) {
               var4 = (var3 >> 1) + var3;
            } else if (var3 >= 4) {
               var4 = 8;
            }

            Object[] var8 = this.f;
            this.a(var4);
            if (var3 != this.g) {
               throw new ConcurrentModificationException();
            }

            int[] var9 = this.e;
            if (var9.length > 0) {
               System.arraycopy(var6, 0, var9, 0, var6.length);
               System.arraycopy(var8, 0, this.f, 0, var8.length);
            }

            d(var6, var8, var3);
         }

         Object[] var11;
         if (var4 < var3) {
            var6 = this.e;
            ++var4;
            System.arraycopy(var6, var7, var6, var4, var3 - var7);
            var11 = this.f;
            System.arraycopy(var11, var7 << 1, var11, var4 << 1, this.g - var7 << 1);
         }

         var4 = this.g;
         if (var3 == var4) {
            var6 = this.e;
            if (var7 < var6.length) {
               var6[var7] = var5;
               var11 = this.f;
               var5 = var7 << 1;
               var11[var5] = var1;
               var11[var5 + 1] = var2;
               this.g = var4 + 1;
               return null;
            }
         }

         throw new ConcurrentModificationException();
      }
   }

   public V putIfAbsent(K var1, V var2) {
      Object var3 = this.get(var1);
      Object var4 = var3;
      if (var3 == null) {
         var4 = this.put(var1, var2);
      }

      return var4;
   }

   public V remove(Object var1) {
      int var2 = this.f(var1);
      return var2 >= 0 ? this.j(var2) : null;
   }

   public boolean remove(Object var1, Object var2) {
      int var3 = this.f(var1);
      if (var3 >= 0) {
         var1 = this.l(var3);
         if (var2 == var1 || var2 != null && var2.equals(var1)) {
            this.j(var3);
            return true;
         }
      }

      return false;
   }

   public V replace(K var1, V var2) {
      int var3 = this.f(var1);
      return var3 >= 0 ? this.k(var3, var2) : null;
   }

   public boolean replace(K var1, V var2, V var3) {
      int var4 = this.f(var1);
      if (var4 >= 0) {
         var1 = this.l(var4);
         if (var1 == var2 || var2 != null && var2.equals(var1)) {
            this.k(var4, var3);
            return true;
         }
      }

      return false;
   }

   public int size() {
      return this.g;
   }

   public String toString() {
      if (this.isEmpty()) {
         return "{}";
      } else {
         StringBuilder var1 = new StringBuilder(this.g * 28);
         var1.append('{');

         for(int var2 = 0; var2 < this.g; ++var2) {
            if (var2 > 0) {
               var1.append(", ");
            }

            Object var3 = this.i(var2);
            if (var3 != this) {
               var1.append(var3);
            } else {
               var1.append("(this Map)");
            }

            var1.append('=');
            var3 = this.l(var2);
            if (var3 != this) {
               var1.append(var3);
            } else {
               var1.append("(this Map)");
            }
         }

         var1.append('}');
         return var1.toString();
      }
   }
}
