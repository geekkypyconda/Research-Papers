package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class m extends h {
   public static final m.a k = new m.a((a1.g)null);
   private final boolean b;
   private d.a<k, m.b> c;
   private h.b d;
   private final WeakReference<l> e;
   private int f;
   private boolean g;
   private boolean h;
   private ArrayList<h.b> i;
   private final k1.j<h.b> j;

   public m(l var1) {
      a1.k.e(var1, "provider");
      this(var1, true);
   }

   private m(l var1, boolean var2) {
      this.b = var2;
      this.c = new d.a();
      h.b var3 = h.b.f;
      this.d = var3;
      this.i = new ArrayList();
      this.e = new WeakReference(var1);
      this.j = k1.o.a(var3);
   }

   private final void b(l var1) {
      Iterator var2 = this.c.descendingIterator();
      a1.k.d(var2, "observerMap.descendingIterator()");

      while(var2.hasNext() && !this.h) {
         Entry var3 = (Entry)var2.next();
         a1.k.d(var3, "next()");
         k var4 = (k)var3.getKey();
         m.b var7 = (m.b)var3.getValue();

         while(var7.b().compareTo(this.d) > 0 && !this.h && this.c.contains(var4)) {
            h.a var5 = h.a.Companion.a(var7.b());
            if (var5 == null) {
               StringBuilder var6 = new StringBuilder();
               var6.append("no event down from ");
               var6.append(var7.b());
               throw new IllegalStateException(var6.toString());
            }

            this.k(var5.b());
            var7.a(var1, var5);
            this.j();
         }
      }

   }

   private final h.b c(k var1) {
      h.b var2;
      h.b var6;
      label16: {
         Entry var4 = this.c.e(var1);
         var2 = null;
         if (var4 != null) {
            m.b var5 = (m.b)var4.getValue();
            if (var5 != null) {
               var6 = var5.b();
               break label16;
            }
         }

         var6 = null;
      }

      if (this.i.isEmpty() ^ true) {
         ArrayList var7 = this.i;
         var2 = (h.b)var7.get(var7.size() - 1);
      }

      m.a var3 = k;
      return var3.a(var3.a(this.d, var6), var2);
   }

   private final void d(String var1) {
      if (this.b && !c.c.f().b()) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Method ");
         var2.append(var1);
         var2.append(" must be called on the main thread");
         throw new IllegalStateException(var2.toString().toString());
      }
   }

   private final void e(l var1) {
      d.b.d var2 = this.c.b();
      a1.k.d(var2, "observerMap.iteratorWithAdditions()");

      while(var2.hasNext() && !this.h) {
         Entry var3 = (Entry)var2.next();
         k var4 = (k)var3.getKey();
         m.b var7 = (m.b)var3.getValue();

         while(var7.b().compareTo(this.d) < 0 && !this.h && this.c.contains(var4)) {
            this.k(var7.b());
            h.a var5 = h.a.Companion.b(var7.b());
            if (var5 == null) {
               StringBuilder var6 = new StringBuilder();
               var6.append("no event up from ");
               var6.append(var7.b());
               throw new IllegalStateException(var6.toString());
            }

            var7.a(var1, var5);
            this.j();
         }
      }

   }

   private final boolean h() {
      int var1 = this.c.size();
      boolean var2 = true;
      if (var1 == 0) {
         return true;
      } else {
         Entry var3 = this.c.a();
         a1.k.b(var3);
         h.b var5 = ((m.b)var3.getValue()).b();
         Entry var4 = this.c.c();
         a1.k.b(var4);
         h.b var6 = ((m.b)var4.getValue()).b();
         if (var5 != var6 || this.d != var6) {
            var2 = false;
         }

         return var2;
      }
   }

   private final void i(h.b var1) {
      h.b var2 = this.d;
      if (var2 != var1) {
         boolean var3;
         if (var2 == h.b.f && var1 == h.b.e) {
            var3 = false;
         } else {
            var3 = true;
         }

         if (var3) {
            this.d = var1;
            if (!this.g && this.f == 0) {
               this.g = true;
               this.l();
               this.g = false;
               if (this.d == h.b.e) {
                  this.c = new d.a();
               }

            } else {
               this.h = true;
            }
         } else {
            StringBuilder var4 = new StringBuilder();
            var4.append("no event down from ");
            var4.append(this.d);
            var4.append(" in component ");
            var4.append(this.e.get());
            throw new IllegalStateException(var4.toString().toString());
         }
      }
   }

   private final void j() {
      ArrayList var1 = this.i;
      var1.remove(var1.size() - 1);
   }

   private final void k(h.b var1) {
      this.i.add(var1);
   }

   private final void l() {
      l var1 = (l)this.e.get();
      if (var1 != null) {
         while(true) {
            boolean var2 = this.h();
            this.h = false;
            if (var2) {
               this.j.setValue(this.f());
               return;
            }

            h.b var3 = this.d;
            Entry var4 = this.c.a();
            a1.k.b(var4);
            if (var3.compareTo(((m.b)var4.getValue()).b()) < 0) {
               this.b(var1);
            }

            Entry var5 = this.c.c();
            if (!this.h && var5 != null && this.d.compareTo(((m.b)var5.getValue()).b()) > 0) {
               this.e(var1);
            }
         }
      } else {
         throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
      }
   }

   public void a(k var1) {
      a1.k.e(var1, "observer");
      this.d("addObserver");
      h.b var2 = this.d;
      h.b var3 = h.b.e;
      if (var2 != var3) {
         var3 = h.b.f;
      }

      m.b var7 = new m.b(var1, var3);
      if ((m.b)this.c.g(var1, var7) == null) {
         l var4 = (l)this.e.get();
         if (var4 != null) {
            boolean var5;
            if (this.f == 0 && !this.g) {
               var5 = false;
            } else {
               var5 = true;
            }

            var3 = this.c(var1);
            ++this.f;

            while(var7.b().compareTo(var3) < 0 && this.c.contains(var1)) {
               this.k(var7.b());
               h.a var8 = h.a.Companion.b(var7.b());
               if (var8 == null) {
                  StringBuilder var6 = new StringBuilder();
                  var6.append("no event up from ");
                  var6.append(var7.b());
                  throw new IllegalStateException(var6.toString());
               }

               var7.a(var4, var8);
               this.j();
               var3 = this.c(var1);
            }

            if (!var5) {
               this.l();
            }

            --this.f;
         }
      }
   }

   public h.b f() {
      return this.d;
   }

   public void g(h.a var1) {
      a1.k.e(var1, "event");
      this.d("handleLifecycleEvent");
      this.i(var1.b());
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(a1.g var1) {
         this();
      }

      public final h.b a(h.b var1, h.b var2) {
         a1.k.e(var1, "state1");
         h.b var3 = var1;
         if (var2 != null) {
            var3 = var1;
            if (var2.compareTo(var1) < 0) {
               var3 = var2;
            }
         }

         return var3;
      }
   }

   public static final class b {
      private h.b a;
      private j b;

      public b(k var1, h.b var2) {
         a1.k.e(var2, "initialState");
         super();
         a1.k.b(var1);
         this.b = o.f(var1);
         this.a = var2;
      }

      public final void a(l var1, h.a var2) {
         a1.k.e(var2, "event");
         h.b var3 = var2.b();
         this.a = m.k.a(this.a, var3);
         j var4 = this.b;
         a1.k.b(var1);
         var4.d(var1, var2);
         this.a = var3;
      }

      public final h.b b() {
         return this.a;
      }
   }
}
