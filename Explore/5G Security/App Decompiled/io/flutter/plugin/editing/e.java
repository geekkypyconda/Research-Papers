package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import j0.s;
import java.util.ArrayList;
import java.util.Iterator;

class e extends SpannableStringBuilder {
   private int e = 0;
   private int f = 0;
   private ArrayList<e.b> g = new ArrayList();
   private ArrayList<e.b> h = new ArrayList();
   private ArrayList<g> i = new ArrayList();
   private String j;
   private String k;
   private int l;
   private int m;
   private int n;
   private int o;
   private BaseInputConnection p;

   public e(s.e var1, View var2) {
      this.p = new BaseInputConnection(var2, true) {
         public Editable getEditable() {
            return e.this;
         }
      };
      if (var1 != null) {
         this.n(var1);
      }

   }

   private void j(e.b var1, boolean var2, boolean var3, boolean var4) {
      ++this.f;
      var1.a(var2, var3, var4);
      --this.f;
   }

   private void k(boolean var1, boolean var2, boolean var3) {
      if (var1 || var2 || var3) {
         Iterator var4 = this.g.iterator();

         while(var4.hasNext()) {
            this.j((e.b)var4.next(), var1, var2, var3);
         }
      }

   }

   public void a(e.b var1) {
      if (this.f > 0) {
         StringBuilder var2 = new StringBuilder();
         var2.append("adding a listener ");
         var2.append(var1.toString());
         var2.append(" in a listener callback");
         y.b.b("ListenableEditingState", var2.toString());
      }

      ArrayList var3;
      if (this.e > 0) {
         y.b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
         var3 = this.h;
      } else {
         var3 = this.g;
      }

      var3.add(var1);
   }

   public void b() {
      ++this.e;
      if (this.f > 0) {
         y.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
      }

      if (this.e == 1 && !this.g.isEmpty()) {
         this.k = this.toString();
         this.l = this.i();
         this.m = this.h();
         this.n = this.g();
         this.o = this.f();
      }

   }

   public void c() {
      this.i.clear();
   }

   public void d() {
      int var1 = this.e;
      if (var1 == 0) {
         y.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
      } else {
         if (var1 == 1) {
            Iterator var2 = this.h.iterator();

            while(var2.hasNext()) {
               this.j((e.b)var2.next(), true, true, true);
            }

            if (!this.g.isEmpty()) {
               StringBuilder var7 = new StringBuilder();
               var7.append("didFinishBatchEdit with ");
               var7.append(String.valueOf(this.g.size()));
               var7.append(" listener(s)");
               y.b.f("ListenableEditingState", var7.toString());
               boolean var3 = this.toString().equals(this.k);
               var1 = this.l;
               int var4 = this.i();
               boolean var5 = false;
               boolean var6;
               if (var1 == var4 && this.m == this.h()) {
                  var6 = false;
               } else {
                  var6 = true;
               }

               if (this.n != this.g() || this.o != this.f()) {
                  var5 = true;
               }

               this.k(var3 ^ true, var6, var5);
            }
         }

         this.g.addAll(this.h);
         this.h.clear();
         --this.e;
      }
   }

   public ArrayList<g> e() {
      ArrayList var1 = new ArrayList(this.i);
      this.i.clear();
      return var1;
   }

   public final int f() {
      return BaseInputConnection.getComposingSpanEnd(this);
   }

   public final int g() {
      return BaseInputConnection.getComposingSpanStart(this);
   }

   public final int h() {
      return Selection.getSelectionEnd(this);
   }

   public final int i() {
      return Selection.getSelectionStart(this);
   }

   public void l(e.b var1) {
      if (this.f > 0) {
         StringBuilder var2 = new StringBuilder();
         var2.append("removing a listener ");
         var2.append(var1.toString());
         var2.append(" in a listener callback");
         y.b.b("ListenableEditingState", var2.toString());
      }

      this.g.remove(var1);
      if (this.e > 0) {
         this.h.remove(var1);
      }

   }

   public void m(int var1, int var2) {
      if (var1 >= 0 && var1 < var2) {
         this.p.setComposingRegion(var1, var2);
      } else {
         BaseInputConnection.removeComposingSpans(this);
      }

   }

   public void n(s.e var1) {
      this.b();
      this.replace(0, this.length(), var1.a);
      if (var1.c()) {
         Selection.setSelection(this, var1.b, var1.c);
      } else {
         Selection.removeSelection(this);
      }

      this.m(var1.d, var1.e);
      this.c();
      this.d();
   }

   public SpannableStringBuilder replace(int var1, int var2, CharSequence var3, int var4, int var5) {
      if (this.f > 0) {
         y.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
      }

      String var6 = this.toString();
      int var7 = var2 - var1;
      boolean var8;
      if (var7 != var5 - var4) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var9;
      for(var9 = 0; var9 < var7 && !var8; ++var9) {
         boolean var10;
         if (this.charAt(var1 + var9) != var3.charAt(var4 + var9)) {
            var10 = true;
         } else {
            var10 = false;
         }

         var8 |= var10;
      }

      if (var8) {
         this.j = null;
      }

      int var15 = this.i();
      int var11 = this.h();
      var7 = this.g();
      var9 = this.f();
      SpannableStringBuilder var12 = super.replace(var1, var2, var3, var4, var5);
      this.i.add(new g(var6, var1, var2, var3, this.i(), this.h(), this.g(), this.f()));
      if (this.e > 0) {
         return var12;
      } else {
         boolean var13;
         if (this.i() == var15 && this.h() == var11) {
            var13 = false;
         } else {
            var13 = true;
         }

         boolean var14;
         if (this.g() == var7 && this.f() == var9) {
            var14 = false;
         } else {
            var14 = true;
         }

         this.k(var8, var13, var14);
         return var12;
      }
   }

   public void setSpan(Object var1, int var2, int var3, int var4) {
      super.setSpan(var1, var2, var3, var4);
      this.i.add(new g(this.toString(), this.i(), this.h(), this.g(), this.f()));
   }

   public String toString() {
      String var1 = this.j;
      if (var1 == null) {
         var1 = super.toString();
         this.j = var1;
      }

      return var1;
   }

   interface b {
      void a(boolean var1, boolean var2, boolean var3);
   }
}
