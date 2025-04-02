package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowInsetsController.OnControllableInsetsChangedListener;

public final class c0 {
   private final c0.e a;

   public c0(Window var1, View var2) {
      androidx.core.view.d var5 = new androidx.core.view.d(var2);
      int var3 = VERSION.SDK_INT;
      Object var4;
      if (var3 >= 30) {
         var4 = new c0.d(var1, this, var5);
      } else if (var3 >= 26) {
         var4 = new c0.c(var1, var5);
      } else if (var3 >= 23) {
         var4 = new c0.b(var1, var5);
      } else {
         var4 = new c0.a(var1, var5);
      }

      this.a = (c0.e)var4;
   }

   public void a(boolean var1) {
      this.a.a(var1);
   }

   public void b(boolean var1) {
      this.a.b(var1);
   }

   private static class a extends c0.e {
      protected final Window a;
      private final androidx.core.view.d b;

      a(Window var1, androidx.core.view.d var2) {
         this.a = var1;
         this.b = var2;
      }

      protected void c(int var1) {
         View var2 = this.a.getDecorView();
         var2.setSystemUiVisibility(var1 | var2.getSystemUiVisibility());
      }

      protected void d(int var1) {
         this.a.addFlags(var1);
      }

      protected void e(int var1) {
         View var2 = this.a.getDecorView();
         var2.setSystemUiVisibility(var1 & var2.getSystemUiVisibility());
      }

      protected void f(int var1) {
         this.a.clearFlags(var1);
      }
   }

   private static class b extends c0.a {
      b(Window var1, androidx.core.view.d var2) {
         super(var1, var2);
      }

      public void b(boolean var1) {
         if (var1) {
            this.f(67108864);
            this.d(Integer.MIN_VALUE);
            this.c(8192);
         } else {
            this.e(8192);
         }

      }
   }

   private static class c extends c0.b {
      c(Window var1, androidx.core.view.d var2) {
         super(var1, var2);
      }

      public void a(boolean var1) {
         if (var1) {
            this.f(134217728);
            this.d(Integer.MIN_VALUE);
            this.c(16);
         } else {
            this.e(16);
         }

      }
   }

   private static class d extends c0.e {
      final c0 a;
      final WindowInsetsController b;
      final androidx.core.view.d c;
      private final e.d<Object, OnControllableInsetsChangedListener> d;
      protected Window e;

      d(Window var1, c0 var2, androidx.core.view.d var3) {
         this(d0.a(var1), var2, var3);
         this.e = var1;
      }

      d(WindowInsetsController var1, c0 var2, androidx.core.view.d var3) {
         this.d = new e.d();
         this.b = var1;
         this.a = var2;
         this.c = var3;
      }

      public void a(boolean var1) {
         if (var1) {
            if (this.e != null) {
               this.c(16);
            }

            this.b.setSystemBarsAppearance(16, 16);
         } else {
            if (this.e != null) {
               this.d(16);
            }

            this.b.setSystemBarsAppearance(0, 16);
         }

      }

      public void b(boolean var1) {
         if (var1) {
            if (this.e != null) {
               this.c(8192);
            }

            this.b.setSystemBarsAppearance(8, 8);
         } else {
            if (this.e != null) {
               this.d(8192);
            }

            this.b.setSystemBarsAppearance(0, 8);
         }

      }

      protected void c(int var1) {
         View var2 = this.e.getDecorView();
         var2.setSystemUiVisibility(var1 | var2.getSystemUiVisibility());
      }

      protected void d(int var1) {
         View var2 = this.e.getDecorView();
         var2.setSystemUiVisibility(var1 & var2.getSystemUiVisibility());
      }
   }

   private static class e {
      e() {
      }

      public void a(boolean var1) {
      }

      public void b(boolean var1) {
      }
   }
}
