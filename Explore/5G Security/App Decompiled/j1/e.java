package j1;

import h1.i1;
import h1.o1;
import java.util.concurrent.CancellationException;

public class e<E> extends h1.a<p0.q> implements d<E> {
   private final d<E> h;

   public e(r0.g var1, d<E> var2, boolean var3, boolean var4) {
      super(var1, var3, var4);
      this.h = var2;
   }

   public void K(Throwable var1) {
      CancellationException var2 = o1.z0(this, var1, (String)null, 1, (Object)null);
      this.h.c(var2);
      this.I(var2);
   }

   protected final d<E> K0() {
      return this.h;
   }

   public final void c(CancellationException var1) {
      if (!this.f0()) {
         Object var2 = var1;
         if (var1 == null) {
            var2 = new i1(o1.D(this), (Throwable)null, this);
         }

         this.K((Throwable)var2);
      }
   }

   public Object e(E var1, r0.d<? super p0.q> var2) {
      return this.h.e(var1, var2);
   }

   public f<E> iterator() {
      return this.h.iterator();
   }

   public boolean p(Throwable var1) {
      return this.h.p(var1);
   }

   public Object q(E var1) {
      return this.h.q(var1);
   }

   public boolean w() {
      return this.h.w();
   }

   public void z(z0.l<? super Throwable, p0.q> var1) {
      this.h.z(var1);
   }
}
