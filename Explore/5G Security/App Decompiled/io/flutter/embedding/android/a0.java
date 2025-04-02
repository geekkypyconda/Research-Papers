package io.flutter.embedding.android;

import android.view.KeyEvent;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a0 implements b0.d {
   private final k0.b a;
   private final HashMap<Long, Long> b = new HashMap();
   private final HashMap<Long, c0.e> c = new HashMap();
   private final b0.b d = new b0.b();

   public a0(k0.b var1) {
      this.a = var1;
      c0.e[] var5 = c0.a();
      int var2 = var5.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         c0.e var4 = var5[var3];
         this.c.put(var4.c, var4);
      }

   }

   // $FF: synthetic method
   public static void b(a0 var0, c0.c var1, KeyEvent var2) {
      var0.m(var1, var2);
   }

   // $FF: synthetic method
   public static void c(b0.d.a var0, ByteBuffer var1) {
      k(var0, var1);
   }

   // $FF: synthetic method
   public static void d(a0 var0, c0.c var1, long var2, KeyEvent var4) {
      var0.l(var1, var2, var4);
   }

   private static w.b e(KeyEvent var0) {
      boolean var1;
      if (var0.getRepeatCount() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      int var2 = var0.getAction();
      if (var2 != 0) {
         if (var2 == 1) {
            return w.b.g;
         } else {
            throw new AssertionError("Unexpected event type");
         }
      } else {
         w.b var3;
         if (var1) {
            var3 = w.b.h;
         } else {
            var3 = w.b.f;
         }

         return var3;
      }
   }

   private Long f(KeyEvent var1) {
      Long var2 = (Long)c0.b.get((long)var1.getKeyCode());
      return var2 != null ? var2 : j((long)var1.getKeyCode(), 73014444032L);
   }

   private Long g(KeyEvent var1) {
      long var2 = (long)var1.getScanCode();
      int var4;
      if (var2 == 0L) {
         var4 = var1.getKeyCode();
      } else {
         Long var5 = (Long)c0.a.get(var2);
         if (var5 != null) {
            return var5;
         }

         var4 = var1.getScanCode();
      }

      return j((long)var4, 73014444032L);
   }

   private boolean i(KeyEvent var1, b0.d.a var2) {
      if (var1.getScanCode() == 0 && var1.getKeyCode() == 0) {
         return false;
      } else {
         Long var3 = this.g(var1);
         Long var4 = this.f(var1);
         ArrayList var5 = new ArrayList();
         c0.d[] var6 = c0.c;
         int var7 = var6.length;

         int var8;
         boolean var10;
         for(var8 = 0; var8 < var7; ++var8) {
            c0.d var9 = var6[var8];
            if ((var1.getMetaState() & var9.a) != 0) {
               var10 = true;
            } else {
               var10 = false;
            }

            this.o(var9, var10, var4, var3, var1, var5);
         }

         c0.e var19;
         for(Iterator var15 = this.c.values().iterator(); var15.hasNext(); this.p(var19, var10, var4, var1)) {
            var19 = (c0.e)var15.next();
            if ((var1.getMetaState() & var19.a) != 0) {
               var10 = true;
            } else {
               var10 = false;
            }
         }

         var8 = var1.getAction();
         boolean var18;
         if (var8 != 0) {
            if (var8 != 1) {
               return false;
            }

            var18 = false;
         } else {
            var18 = true;
         }

         w var11;
         String var13;
         w.b var16;
         Long var20;
         label96: {
            var20 = (Long)this.b.get(var3);
            var11 = null;
            if (var18) {
               w.b var21;
               label93: {
                  if (var20 != null) {
                     if (var1.getRepeatCount() > 0) {
                        var21 = w.b.h;
                        break label93;
                     }

                     this.q(false, var20, var3, var1.getEventTime());
                  }

                  var21 = w.b.f;
               }

               char var12 = this.d.a(var1.getUnicodeChar());
               var16 = var21;
               if (var12 != 0) {
                  StringBuilder var17 = new StringBuilder();
                  var17.append("");
                  var17.append(var12);
                  var13 = var17.toString();
                  var16 = var21;
                  break label96;
               }
            } else {
               if (var20 == null) {
                  return false;
               }

               var16 = w.b.g;
            }

            var13 = null;
         }

         if (var16 != w.b.h) {
            var20 = var11;
            if (var18) {
               var20 = var4;
            }

            this.r(var3, var20);
         }

         if (var16 == w.b.f) {
            var19 = (c0.e)this.c.get(var4);
            if (var19 != null) {
               var19.d ^= true;
            }
         }

         var11 = new w();
         var8 = var1.getSource();
         w.a var22;
         if (var8 != 513) {
            if (var8 != 1025) {
               if (var8 != 16777232) {
                  if (var8 != 33554433) {
                     var22 = w.a.f;
                  } else {
                     var22 = w.a.j;
                  }
               } else {
                  var22 = w.a.i;
               }
            } else {
               var22 = w.a.h;
            }
         } else {
            var22 = w.a.g;
         }

         var11.f = var22;
         var11.a = var1.getEventTime();
         var11.b = var16;
         var11.d = var4;
         var11.c = var3;
         var11.g = var13;
         var11.e = false;
         var11.f = w.a.f;
         this.n(var11, var2);
         Iterator var14 = var5.iterator();

         while(var14.hasNext()) {
            ((Runnable)var14.next()).run();
         }

         return true;
      }
   }

   private static long j(long var0, long var2) {
      return var0 & 4294967295L | var2;
   }

   // $FF: synthetic method
   private static void k(b0.d.a var0, ByteBuffer var1) {
      Boolean var2 = Boolean.FALSE;
      if (var1 != null) {
         var1.rewind();
         if (var1.capacity() != 0) {
            boolean var3;
            if (var1.get() != 0) {
               var3 = true;
            } else {
               var3 = false;
            }

            var2 = var3;
         }
      } else {
         y.b.g("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
      }

      var0.a(var2);
   }

   // $FF: synthetic method
   private void l(c0.c var1, long var2, KeyEvent var4) {
      this.q(false, var1.b, var2, var4.getEventTime());
   }

   // $FF: synthetic method
   private void m(c0.c var1, KeyEvent var2) {
      this.q(false, var1.b, var1.a, var2.getEventTime());
   }

   private void n(w var1, b0.d.a var2) {
      x var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = new x(var2);
      }

      this.a.a("flutter/keydata", var1.a(), var3);
   }

   private void q(boolean var1, Long var2, Long var3, long var4) {
      w var6 = new w();
      var6.a = var4;
      w.b var7;
      if (var1) {
         var7 = w.b.f;
      } else {
         var7 = w.b.g;
      }

      var6.b = var7;
      var6.d = var2;
      var6.c = var3;
      var6.g = null;
      var6.e = true;
      var6.f = w.a.f;
      if (var3 != 0L && var2 != 0L) {
         if (!var1) {
            var2 = null;
         }

         this.r(var3, var2);
      }

      this.n(var6, (b0.d.a)null);
   }

   public void a(KeyEvent var1, b0.d.a var2) {
      if (!this.i(var1, var2)) {
         this.q(true, 0L, 0L, 0L);
         var2.a(true);
      }

   }

   public Map<Long, Long> h() {
      return Collections.unmodifiableMap(this.b);
   }

   void o(c0.d var1, boolean var2, long var3, long var5, KeyEvent var7, ArrayList<Runnable> var8) {
      c0.c[] var9 = var1.b;
      boolean[] var10 = new boolean[var9.length];
      Boolean[] var19 = new Boolean[var9.length];
      byte var11 = 0;
      boolean var12 = false;
      int var13 = 0;

      while(true) {
         c0.c[] var14 = var1.b;
         int var15 = var14.length;
         boolean var16 = true;
         if (var13 >= var15) {
            if (var2) {
               for(var15 = 0; var15 < var1.b.length; ++var15) {
                  if (var19[var15] == null) {
                     if (var12) {
                        var19[var15] = var10[var15];
                     } else {
                        var19[var15] = Boolean.TRUE;
                        var12 = true;
                     }
                  }
               }

               var15 = var11;
               if (!var12) {
                  var19[0] = Boolean.TRUE;
                  var15 = var11;
               }
            } else {
               int var20 = 0;

               while(true) {
                  var15 = var11;
                  if (var20 >= var1.b.length) {
                     break;
                  }

                  if (var19[var20] == null) {
                     var19[var20] = Boolean.FALSE;
                  }

                  ++var20;
               }
            }

            for(; var15 < var1.b.length; ++var15) {
               if (var10[var15] != var19[var15]) {
                  c0.c var18 = var1.b[var15];
                  this.q(var19[var15], var18.b, var18.a, var7.getEventTime());
               }
            }

            return;
         }

         c0.c var21 = var14[var13];
         boolean var17 = this.b.containsKey(var21.a);
         var10[var13] = var17;
         if (var21.b == var3) {
            label83: {
               var15 = null.a[e(var7).ordinal()];
               if (var15 != 1) {
                  if (var15 == 2) {
                     var19[var13] = var10[var13];
                     break label83;
                  }

                  if (var15 != 3) {
                     break label83;
                  }

                  if (!var2) {
                     var8.add(new z(this, var21, var7));
                  }

                  var19[var13] = var10[var13];
               } else {
                  var19[var13] = Boolean.FALSE;
                  if (!var2) {
                     var8.add(new y(this, var21, var5, var7));
                  }
               }

               var12 = true;
            }
         } else {
            boolean var22 = var16;
            if (!var12) {
               if (var17) {
                  var22 = var16;
               } else {
                  var22 = false;
               }
            }

            var12 = var22;
         }

         ++var13;
      }
   }

   void p(c0.e var1, boolean var2, long var3, KeyEvent var5) {
      if (var1.c != var3) {
         if (var1.d != var2) {
            var2 = this.b.containsKey(var1.b) ^ true;
            if (var2) {
               var1.d ^= true;
            }

            this.q(var2, var1.c, var1.b, var5.getEventTime());
            if (!var2) {
               var1.d ^= true;
            }

            this.q(var2 ^ true, var1.c, var1.b, var5.getEventTime());
         }

      }
   }

   void r(Long var1, Long var2) {
      if (var2 != null) {
         if ((Long)this.b.put(var1, var2) != null) {
            throw new AssertionError("The key was not empty");
         }
      } else if ((Long)this.b.remove(var1) == null) {
         throw new AssertionError("The key was empty");
      }

   }
}
