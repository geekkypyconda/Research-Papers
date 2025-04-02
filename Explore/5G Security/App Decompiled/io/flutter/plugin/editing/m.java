package io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.b0;
import io.flutter.plugin.platform.w;
import j0.s;
import java.util.ArrayList;
import java.util.HashMap;

public class m implements e.b {
   private final View a;
   private final InputMethodManager b;
   private final AutofillManager c;
   private final s d;
   private m.c e;
   private s.b f;
   private SparseArray<s.b> g;
   private e h;
   private boolean i;
   private InputConnection j;
   private w k;
   private Rect l;
   private ImeSyncDeferringInsetsCallback m;
   private s.e n;
   private boolean o;

   public m(View var1, s var2, w var3) {
      this.e = new m.c(m.c.a.e, 0);
      this.a = var1;
      AutofillManager var4 = null;
      this.h = new e((s.e)null, var1);
      this.b = (InputMethodManager)var1.getContext().getSystemService("input_method");
      int var5 = VERSION.SDK_INT;
      if (var5 >= 26) {
         var4 = (AutofillManager)v.d.a(var1.getContext(), AutofillManager.class);
      }

      this.c = var4;
      if (var5 >= 30) {
         ImeSyncDeferringInsetsCallback var6 = new ImeSyncDeferringInsetsCallback(var1);
         this.m = var6;
         var6.install();
      }

      this.d = var2;
      var2.n(new s.f() {
         public void a(String var1, Bundle var2) {
            m.this.A(var1, var2);
         }

         public void b() {
            m.this.l();
         }

         public void c() {
            m var1 = m.this;
            var1.E(var1.a);
         }

         public void d(int var1, boolean var2) {
            m.this.B(var1, var2);
         }

         public void e(double var1, double var3, double[] var5) {
            m.this.z(var1, var3, var5);
         }

         public void f(int var1, s.b var2) {
            m.this.C(var1, var2);
         }

         public void g() {
            m.this.w();
         }

         public void h(s.e var1) {
            m var2 = m.this;
            var2.D(var2.a, var1);
         }

         public void i(boolean var1) {
            if (VERSION.SDK_INT >= 26 && m.this.c != null) {
               if (var1) {
                  m.this.c.commit();
               } else {
                  m.this.c.cancel();
               }
            }

         }

         public void j() {
            if (m.this.e.a == m.c.a.h) {
               m.this.x();
            } else {
               m var1 = m.this;
               var1.r(var1.a);
            }

         }
      });
      var2.k();
      this.k = var3;
      var3.D(this);
   }

   private void B(int var1, boolean var2) {
      if (var2) {
         this.a.requestFocus();
         this.e = new m.c(m.c.a.g, var1);
         this.b.restartInput(this.a);
         this.i = false;
      } else {
         this.e = new m.c(m.c.a.h, var1);
         this.j = null;
      }

   }

   private void G(s.b var1) {
      if (VERSION.SDK_INT >= 26) {
         if (var1 != null && var1.j != null) {
            s.b[] var2 = var1.l;
            SparseArray var3 = new SparseArray();
            this.g = var3;
            if (var2 == null) {
               var3.put(var1.j.a.hashCode(), var1);
            } else {
               int var4 = var2.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  var1 = var2[var5];
                  s.b.a var6 = var1.j;
                  if (var6 != null) {
                     this.g.put(var6.a.hashCode(), var1);
                     this.c.notifyValueChanged(this.a, var6.a.hashCode(), AutofillValue.forText(var6.c.a));
                  }
               }
            }

         } else {
            this.g = null;
         }
      }
   }

   private static boolean m(s.e var0, s.e var1) {
      int var2 = var0.e - var0.d;
      if (var2 != var1.e - var1.d) {
         return true;
      } else {
         for(int var3 = 0; var3 < var2; ++var3) {
            if (var0.a.charAt(var0.d + var3) != var1.a.charAt(var1.d + var3)) {
               return true;
            }
         }

         return false;
      }
   }

   private void r(View var1) {
      this.x();
      this.b.hideSoftInputFromWindow(var1.getApplicationWindowToken(), 0);
   }

   private static int s(s.c var0, boolean var1, boolean var2, boolean var3, boolean var4, s.d var5) {
      s.g var6 = var0.a;
      if (var6 == s.g.g) {
         return 4;
      } else {
         int var8;
         if (var6 == s.g.j) {
            short var9 = 2;
            if (var0.b) {
               var9 = 4098;
            }

            var8 = var9;
            if (var0.c) {
               var8 = var9 | 8192;
            }

            return var8;
         } else if (var6 == s.g.k) {
            return 3;
         } else if (var6 == s.g.p) {
            return 0;
         } else {
            int var7 = 1;
            if (var6 == s.g.l) {
               var7 = 131073;
            } else if (var6 == s.g.m) {
               var7 = 33;
            } else if (var6 == s.g.n) {
               var7 = 17;
            } else if (var6 == s.g.o) {
               var7 = 145;
            } else if (var6 == s.g.h) {
               var7 = 97;
            } else if (var6 == s.g.i) {
               var7 = 113;
            }

            if (var1) {
               var7 = var7 | 524288 | 128;
            } else {
               var8 = var7;
               if (var2) {
                  var8 = var7 | '耀';
               }

               var7 = var8;
               if (!var3) {
                  var7 = var8 | 524288 | 144;
               }
            }

            if (var5 == s.d.f) {
               var8 = var7 | 4096;
            } else if (var5 == s.d.g) {
               var8 = var7 | 8192;
            } else {
               var8 = var7;
               if (var5 == s.d.h) {
                  var8 = var7 | 16384;
               }
            }

            return var8;
         }
      }
   }

   private boolean u() {
      boolean var1;
      if (this.g != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void v(String var1) {
      if (VERSION.SDK_INT >= 26 && this.c != null && this.u()) {
         String var2 = this.f.j.a;
         this.c.notifyValueChanged(this.a, var2.hashCode(), AutofillValue.forText(var1));
      }

   }

   private void w() {
      if (VERSION.SDK_INT >= 26 && this.c != null && this.u()) {
         String var1 = this.f.j.a;
         int[] var2 = new int[2];
         this.a.getLocationOnScreen(var2);
         Rect var3 = new Rect(this.l);
         var3.offset(var2[0], var2[1]);
         this.c.notifyViewEntered(this.a, var1.hashCode(), var3);
      }

   }

   private void x() {
      if (VERSION.SDK_INT >= 26 && this.c != null) {
         s.b var1 = this.f;
         if (var1 != null && var1.j != null && this.u()) {
            String var2 = this.f.j.a;
            this.c.notifyViewExited(this.a, var2.hashCode());
         }
      }

   }

   private void z(double var1, double var3, final double[] var5) {
      final double[] var6 = new double[4];
      final boolean var7;
      if (var5[3] == 0.0D && var5[7] == 0.0D && var5[15] == 1.0D) {
         var7 = true;
      } else {
         var7 = false;
      }

      double var8 = var5[12];
      double var10 = var5[15];
      var8 /= var10;
      var6[1] = var8;
      var6[0] = var8;
      var10 = var5[13] / var10;
      var6[3] = var10;
      var6[2] = var10;
      m.d var12 = new m.d() {
         public void a(double var1, double var3) {
            boolean var5x = var7;
            double var6x = 1.0D;
            double[] var8;
            if (!var5x) {
               var8 = var5;
               var6x = 1.0D / (var8[3] * var1 + var8[7] * var3 + var8[15]);
            }

            var8 = var5;
            double var9 = (var8[0] * var1 + var8[4] * var3 + var8[12]) * var6x;
            var1 = (var8[1] * var1 + var8[5] * var3 + var8[13]) * var6x;
            var8 = var6;
            if (var9 < var8[0]) {
               var8[0] = var9;
            } else if (var9 > var8[1]) {
               var8[1] = var9;
            }

            if (var1 < var8[2]) {
               var8[2] = var1;
            } else if (var1 > var8[3]) {
               var8[3] = var1;
            }

         }
      };
      var12.a(var1, 0.0D);
      var12.a(var1, var3);
      var12.a(0.0D, var3);
      Float var13 = this.a.getContext().getResources().getDisplayMetrics().density;
      this.l = new Rect((int)(var6[0] * (double)var13), (int)(var6[2] * (double)var13), (int)Math.ceil(var6[1] * (double)var13), (int)Math.ceil(var6[3] * (double)var13));
   }

   public void A(String var1, Bundle var2) {
      this.b.sendAppPrivateCommand(this.a, var1, var2);
   }

   void C(int var1, s.b var2) {
      this.x();
      this.f = var2;
      this.e = new m.c(m.c.a.f, var1);
      this.h.l(this);
      s.b.a var3 = var2.j;
      s.e var4;
      if (var3 != null) {
         var4 = var3.c;
      } else {
         var4 = null;
      }

      this.h = new e(var4, this.a);
      this.G(var2);
      this.i = true;
      this.F();
      this.l = null;
      this.h.a(this);
   }

   void D(View var1, s.e var2) {
      if (!this.i) {
         s.e var3 = this.n;
         if (var3 != null && var3.b()) {
            boolean var4 = m(this.n, var2);
            this.i = var4;
            if (var4) {
               y.b.e("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
         }
      }

      this.n = var2;
      this.h.n(var2);
      if (this.i) {
         this.b.restartInput(var1);
         this.i = false;
      }

   }

   void E(View var1) {
      s.b var2 = this.f;
      if (var2 != null) {
         s.c var3 = var2.g;
         if (var3 != null && var3.a == s.g.p) {
            this.r(var1);
            return;
         }
      }

      var1.requestFocus();
      this.b.showSoftInput(var1, 0);
   }

   public void F() {
      if (this.e.a == m.c.a.g) {
         this.o = false;
      }

   }

   public void a(boolean var1, boolean var2, boolean var3) {
      if (var1) {
         this.v(this.h.toString());
      }

      int var4;
      int var5;
      int var6;
      int var7;
      ArrayList var8;
      boolean var10;
      label40: {
         label39: {
            var4 = this.h.i();
            var5 = this.h.h();
            var6 = this.h.g();
            var7 = this.h.f();
            var8 = this.h.e();
            if (this.n != null) {
               if (!this.h.toString().equals(this.n.a)) {
                  break label39;
               }

               s.e var9 = this.n;
               if (var4 != var9.b || var5 != var9.c || var6 != var9.d || var7 != var9.e) {
                  break label39;
               }
            }

            var10 = true;
            break label40;
         }

         var10 = false;
      }

      if (!var10) {
         StringBuilder var11 = new StringBuilder();
         var11.append("send EditingState to flutter: ");
         var11.append(this.h.toString());
         y.b.f("TextInputPlugin", var11.toString());
         if (this.f.e) {
            this.d.q(this.e.b, var8);
            this.h.c();
         } else {
            this.d.p(this.e.b, this.h.toString(), var4, var5, var6, var7);
         }

         this.n = new s.e(this.h.toString(), var4, var5, var6, var7);
      } else {
         this.h.c();
      }

   }

   public void j(SparseArray<AutofillValue> var1) {
      if (VERSION.SDK_INT >= 26) {
         s.b var2 = this.f;
         if (var2 != null && this.g != null) {
            s.b.a var3 = var2.j;
            if (var3 != null) {
               HashMap var8 = new HashMap();

               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  int var5 = var1.keyAt(var4);
                  s.b var6 = (s.b)this.g.get(var5);
                  if (var6 != null) {
                     s.b.a var9 = var6.j;
                     if (var9 != null) {
                        String var7 = ((AutofillValue)var1.valueAt(var4)).getTextValue().toString();
                        s.e var10 = new s.e(var7, var7.length(), var7.length(), -1, -1);
                        if (var9.a.equals(var3.a)) {
                           this.h.n(var10);
                        } else {
                           var8.put(var9.a, var10);
                        }
                     }
                  }
               }

               this.d.r(this.e.b, var8);
            }
         }

      }
   }

   public void k(int var1) {
      m.c var2 = this.e;
      m.c.a var3 = var2.a;
      if ((var3 == m.c.a.g || var3 == m.c.a.h) && var2.b == var1) {
         this.e = new m.c(m.c.a.e, 0);
         this.x();
         this.b.hideSoftInputFromWindow(this.a.getApplicationWindowToken(), 0);
         this.b.restartInput(this.a);
         this.i = false;
      }

   }

   void l() {
      if (this.e.a != m.c.a.g) {
         this.h.l(this);
         this.x();
         this.f = null;
         this.G((s.b)null);
         this.e = new m.c(m.c.a.e, 0);
         this.F();
         this.l = null;
         this.b.restartInput(this.a);
      }
   }

   public InputConnection n(View var1, b0 var2, EditorInfo var3) {
      m.c var4 = this.e;
      m.c.a var5 = var4.a;
      if (var5 == m.c.a.e) {
         this.j = null;
         return null;
      } else if (var5 == m.c.a.h) {
         return null;
      } else if (var5 == m.c.a.g) {
         if (this.o) {
            return this.j;
         } else {
            InputConnection var8 = this.k.d(var4.b).onCreateInputConnection(var3);
            this.j = var8;
            return var8;
         }
      } else {
         s.b var10 = this.f;
         int var6 = s(var10.g, var10.a, var10.b, var10.c, var10.d, var10.f);
         var3.inputType = var6;
         var3.imeOptions = 33554432;
         if (VERSION.SDK_INT >= 26 && !this.f.d) {
            var3.imeOptions = 33554432 | 16777216;
         }

         Integer var11 = this.f.h;
         if (var11 == null) {
            if ((var6 & 131072) != 0) {
               var6 = 1;
            } else {
               var6 = 6;
            }
         } else {
            var6 = var11;
         }

         var10 = this.f;
         String var9 = var10.i;
         if (var9 != null) {
            var3.actionLabel = var9;
            var3.actionId = var6;
         }

         var3.imeOptions |= var6;
         String[] var12 = var10.k;
         if (var12 != null) {
            j.a.a(var3, var12);
         }

         io.flutter.plugin.editing.d var7 = new io.flutter.plugin.editing.d(var1, this.e.b, this.d, var2, this.h, var3);
         var3.initialSelStart = this.h.i();
         var3.initialSelEnd = this.h.h();
         this.j = var7;
         return var7;
      }
   }

   public void o() {
      this.k.Q();
      this.d.n((s.f)null);
      this.x();
      this.h.l(this);
      ImeSyncDeferringInsetsCallback var1 = this.m;
      if (var1 != null) {
         var1.remove();
      }

   }

   public InputMethodManager p() {
      return this.b;
   }

   public boolean q(KeyEvent var1) {
      if (this.p().isAcceptingText()) {
         InputConnection var2 = this.j;
         if (var2 != null) {
            boolean var3;
            if (var2 instanceof io.flutter.plugin.editing.d) {
               var3 = ((io.flutter.plugin.editing.d)var2).f(var1);
            } else {
               var3 = var2.sendKeyEvent(var1);
            }

            return var3;
         }
      }

      return false;
   }

   public void t() {
      if (this.e.a == m.c.a.g) {
         this.o = true;
      }

   }

   public void y(ViewStructure var1, int var2) {
      if (VERSION.SDK_INT >= 26 && this.u()) {
         String var3 = this.f.j.a;
         AutofillId var4 = io.flutter.plugin.editing.h.a(var1);

         for(var2 = 0; var2 < this.g.size(); ++var2) {
            int var5 = this.g.keyAt(var2);
            s.b.a var6 = ((s.b)this.g.valueAt(var2)).j;
            if (var6 != null) {
               var1.addChildCount(1);
               ViewStructure var7 = var1.newChild(var2);
               io.flutter.plugin.editing.i.a(var7, var4, var5);
               String[] var8 = var6.b;
               if (var8.length > 0) {
                  io.flutter.plugin.editing.j.a(var7, var8);
               }

               io.flutter.plugin.editing.k.a(var7, 1);
               var7.setVisibility(0);
               String var9 = var6.d;
               if (var9 != null) {
                  var7.setHint(var9);
               }

               if (var3.hashCode() == var5) {
                  Rect var10 = this.l;
                  if (var10 != null) {
                     var7.setDimens(var10.left, var10.top, 0, 0, var10.width(), this.l.height());
                     io.flutter.plugin.editing.l.a(var7, AutofillValue.forText(this.h));
                     continue;
                  }
               }

               var7.setDimens(0, 0, 0, 0, 1, 1);
               io.flutter.plugin.editing.l.a(var7, AutofillValue.forText(var6.c.a));
            }
         }
      }

   }

   private static class c {
      m.c.a a;
      int b;

      public c(m.c.a var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      static enum a {
         e,
         f,
         g,
         h;

         // $FF: synthetic method
         private static m.c.a[] a() {
            return new m.c.a[]{e, f, g, h};
         }
      }
   }

   private interface d {
      void a(double var1, double var3);
   }
}
