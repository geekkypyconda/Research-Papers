package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import java.util.HashSet;
import java.util.Map;

public class b0 implements io.flutter.plugin.editing.d.a, j0.f.b {
   protected final b0.d[] a;
   private final HashSet<KeyEvent> b = new HashSet();
   private final b0.e c;

   public b0(b0.e var1) {
      this.c = var1;
      this.a = new b0.d[]{new a0(var1.getBinaryMessenger()), new v(new j0.e(var1.getBinaryMessenger()))};
      (new j0.f(var1.getBinaryMessenger())).b(this);
   }

   private void e(KeyEvent var1) {
      b0.e var2 = this.c;
      if (var2 != null && !var2.b(var1)) {
         this.b.add(var1);
         this.c.a(var1);
         if (this.b.remove(var1)) {
            y.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
         }
      }

   }

   public Map<Long, Long> a() {
      return ((a0)this.a[0]).h();
   }

   public boolean b(KeyEvent var1) {
      boolean var2 = this.b.remove(var1);
      int var3 = 0;
      if (var2) {
         return false;
      } else {
         if (this.a.length > 0) {
            b0.c var4 = new b0.c(var1);
            b0.d[] var5 = this.a;

            for(int var6 = var5.length; var3 < var6; ++var3) {
               var5[var3].a(var1, var4.a());
            }
         } else {
            this.e(var1);
         }

         return true;
      }
   }

   public void d() {
      int var1 = this.b.size();
      if (var1 > 0) {
         StringBuilder var2 = new StringBuilder();
         var2.append("A KeyboardManager was destroyed with ");
         var2.append(String.valueOf(var1));
         var2.append(" unhandled redispatch event(s).");
         y.b.g("KeyboardManager", var2.toString());
      }

   }

   public static class b {
      private int a = 0;

      Character a(int var1) {
         char var2 = (char)var1;
         boolean var3;
         if ((Integer.MIN_VALUE & var1) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         char var5;
         int var7;
         if (var3) {
            var7 = var1 & Integer.MAX_VALUE;
            int var4 = this.a;
            var1 = var7;
            if (var4 != 0) {
               var1 = KeyCharacterMap.getDeadChar(var4, var7);
            }

            this.a = var1;
            var5 = var2;
         } else {
            var7 = this.a;
            var5 = var2;
            if (var7 != 0) {
               var7 = KeyCharacterMap.getDeadChar(var7, var1);
               char var6 = var2;
               if (var7 > 0) {
                  var6 = (char)var7;
               }

               this.a = 0;
               var5 = var6;
            }
         }

         return var5;
      }
   }

   private class c {
      final KeyEvent a;
      int b;
      boolean c;

      c(KeyEvent var2) {
         this.b = b0.this.a.length;
         this.c = false;
         this.a = var2;
      }

      public b0.d.a a() {
         return new b0.c.a();
      }

      private class a implements b0.d.a {
         boolean a;

         private a() {
            this.a = false;
         }

         // $FF: synthetic method
         a(Object var2) {
            this();
         }

         public void a(boolean var1) {
            if (!this.a) {
               this.a = true;
               b0.c var2 = c.this;
               int var3 = var2.b - 1;
               var2.b = var3;
               var1 |= var2.c;
               var2.c = var1;
               if (var3 == 0 && !var1) {
                  b0.this.e(var2.a);
               }

            } else {
               throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
         }
      }
   }

   public interface d {
      void a(KeyEvent var1, b0.d.a var2);

      public interface a {
         void a(boolean var1);
      }
   }

   public interface e {
      void a(KeyEvent var1);

      boolean b(KeyEvent var1);

      k0.b getBinaryMessenger();
   }
}
