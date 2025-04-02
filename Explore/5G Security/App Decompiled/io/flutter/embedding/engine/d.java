package io.flutter.embedding.engine;

import android.content.Context;
import io.flutter.plugin.platform.w;
import java.util.ArrayList;
import java.util.List;

public class d {
   final List<a> a = new ArrayList();

   public d(Context var1, String[] var2) {
      b0.d var3 = y.a.e().c();
      if (!var3.i()) {
         var3.k(var1.getApplicationContext());
         var3.f(var1.getApplicationContext(), var2);
      }

   }

   public a a(d.b var1) {
      Context var2 = var1.b();
      z.a.b var3 = var1.c();
      String var4 = var1.e();
      List var5 = var1.d();
      w var6 = var1.f();
      if (var6 == null) {
         var6 = new w();
      }

      boolean var7 = var1.a();
      boolean var8 = var1.g();
      z.a.b var9;
      if (var3 == null) {
         var9 = z.a.b.a();
      } else {
         var9 = var3;
      }

      final a var10;
      if (this.a.size() == 0) {
         a var11 = this.b(var2, var6, var7, var8);
         if (var4 != null) {
            var11.o().c(var4);
         }

         var11.k().g(var9, var5);
         var10 = var11;
      } else {
         var10 = ((a)this.a.get(0)).z(var2, var9, var4, var5, var6, var7, var8);
      }

      this.a.add(var10);
      var10.e(new a.b() {
         public void a() {
         }

         public void b() {
            d.this.a.remove(var10);
         }
      });
      return var10;
   }

   a b(Context var1, w var2, boolean var3, boolean var4) {
      return new a(var1, (b0.d)null, (FlutterJNI)null, var2, (String[])null, var3, var4, this);
   }

   public static class b {
      private Context a;
      private z.a.b b;
      private String c;
      private List<String> d;
      private w e;
      private boolean f = true;
      private boolean g = false;

      public b(Context var1) {
         this.a = var1;
      }

      public boolean a() {
         return this.f;
      }

      public Context b() {
         return this.a;
      }

      public z.a.b c() {
         return this.b;
      }

      public List<String> d() {
         return this.d;
      }

      public String e() {
         return this.c;
      }

      public w f() {
         return this.e;
      }

      public boolean g() {
         return this.g;
      }

      public d.b h(boolean var1) {
         this.f = var1;
         return this;
      }

      public d.b i(z.a.b var1) {
         this.b = var1;
         return this;
      }

      public d.b j(List<String> var1) {
         this.d = var1;
         return this;
      }

      public d.b k(String var1) {
         this.c = var1;
         return this;
      }

      public d.b l(boolean var1) {
         this.g = var1;
         return this;
      }
   }
}
