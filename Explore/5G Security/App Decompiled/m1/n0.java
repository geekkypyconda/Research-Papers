package m1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class n0<T extends o0 & Comparable<? super T>> {
   private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_size");
   private volatile int _size;
   private T[] a;

   private final T[] f() {
      o0[] var1 = this.a;
      o0[] var2;
      if (var1 == null) {
         var2 = new o0[4];
         this.a = var2;
      } else {
         var2 = var1;
         if (this.c() >= var1.length) {
            Object[] var3 = Arrays.copyOf(var1, this.c() * 2);
            a1.k.d(var3, "copyOf(this, newSize)");
            var2 = (o0[])var3;
            this.a = var2;
         }
      }

      return var2;
   }

   private final void j(int var1) {
      b.set(this, var1);
   }

   private final void k(int var1) {
      int var2 = var1;

      while(true) {
         int var3 = var2 * 2 + 1;
         if (var3 >= this.c()) {
            return;
         }

         o0[] var4 = this.a;
         a1.k.b(var4);
         int var5 = var3 + 1;
         var1 = var3;
         o0 var6;
         Comparable var9;
         if (var5 < this.c()) {
            var6 = var4[var5];
            a1.k.b(var6);
            var9 = (Comparable)var6;
            o0 var7 = var4[var3];
            a1.k.b(var7);
            var1 = var3;
            if (var9.compareTo(var7) < 0) {
               var1 = var5;
            }
         }

         var6 = var4[var2];
         a1.k.b(var6);
         var9 = (Comparable)var6;
         o0 var8 = var4[var1];
         a1.k.b(var8);
         if (var9.compareTo(var8) <= 0) {
            return;
         }

         this.m(var2, var1);
         var2 = var1;
      }
   }

   private final void l(int var1) {
      while(var1 > 0) {
         o0[] var2 = this.a;
         a1.k.b(var2);
         int var3 = (var1 - 1) / 2;
         o0 var4 = var2[var3];
         a1.k.b(var4);
         Comparable var6 = (Comparable)var4;
         o0 var5 = var2[var1];
         a1.k.b(var5);
         if (var6.compareTo(var5) <= 0) {
            return;
         }

         this.m(var1, var3);
         var1 = var3;
      }

   }

   private final void m(int var1, int var2) {
      o0[] var3 = this.a;
      a1.k.b(var3);
      o0 var4 = var3[var2];
      a1.k.b(var4);
      o0 var5 = var3[var1];
      a1.k.b(var5);
      var3[var1] = var4;
      var3[var2] = var5;
      var4.b(var1);
      var5.b(var2);
   }

   public final void a(T var1) {
      var1.f(this);
      o0[] var2 = this.f();
      int var3 = this.c();
      this.j(var3 + 1);
      var2[var3] = var1;
      var1.b(var3);
      this.l(var3);
   }

   public final T b() {
      o0[] var1 = this.a;
      o0 var2;
      if (var1 != null) {
         var2 = var1[0];
      } else {
         var2 = null;
      }

      return var2;
   }

   public final int c() {
      return b.get(this);
   }

   public final boolean d() {
      boolean var1;
      if (this.c() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final T e() {
      synchronized(this){}

      o0 var1;
      try {
         var1 = this.b();
      } finally {
         ;
      }

      return var1;
   }

   public final boolean g(T var1) {
      synchronized(this){}
      boolean var4 = false;

      boolean var2;
      label52: {
         try {
            var4 = true;
            if (var1.d() == null) {
               var4 = false;
               break label52;
            }

            this.h(var1.e());
            var4 = false;
         } finally {
            if (var4) {
               ;
            }
         }

         var2 = true;
         return var2;
      }

      var2 = false;
      return var2;
   }

   public final T h(int var1) {
      o0[] var2 = this.a;
      a1.k.b(var2);
      this.j(this.c() - 1);
      o0 var4;
      if (var1 < this.c()) {
         label13: {
            this.m(var1, this.c());
            int var3 = (var1 - 1) / 2;
            if (var1 > 0) {
               var4 = var2[var1];
               a1.k.b(var4);
               Comparable var6 = (Comparable)var4;
               o0 var5 = var2[var3];
               a1.k.b(var5);
               if (var6.compareTo(var5) < 0) {
                  this.m(var1, var3);
                  this.l(var3);
                  break label13;
               }
            }

            this.k(var1);
         }
      }

      var4 = var2[this.c()];
      a1.k.b(var4);
      var4.f((n0)null);
      var4.b(-1);
      var2[this.c()] = null;
      return var4;
   }

   public final T i() {
      synchronized(this){}
      boolean var3 = false;

      o0 var1;
      try {
         var3 = true;
         if (this.c() > 0) {
            var1 = this.h(0);
            var3 = false;
            return var1;
         }

         var3 = false;
      } finally {
         if (var3) {
            ;
         }
      }

      var1 = null;
      return var1;
   }
}
