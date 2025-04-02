package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {
   protected final e.a<String, Method> a;
   protected final e.a<String, Method> b;
   protected final e.a<String, Class> c;

   public a(e.a<String, Method> var1, e.a<String, Method> var2, e.a<String, Class> var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private void N(m.a var1) {
      Class var5;
      try {
         var5 = this.c(var1.getClass());
      } catch (ClassNotFoundException var4) {
         StringBuilder var2 = new StringBuilder();
         var2.append(var1.getClass().getSimpleName());
         var2.append(" does not have a Parcelizer");
         throw new RuntimeException(var2.toString(), var4);
      }

      this.I(var5.getName());
   }

   private Class c(Class<? extends m.a> var1) {
      Class var2 = (Class)this.c.get(var1.getName());
      Class var3 = var2;
      if (var2 == null) {
         var3 = Class.forName(String.format("%s.%sParcelizer", var1.getPackage().getName(), var1.getSimpleName()), false, var1.getClassLoader());
         this.c.put(var1.getName(), var3);
      }

      return var3;
   }

   private Method d(String var1) {
      Method var2 = (Method)this.a.get(var1);
      Method var3 = var2;
      if (var2 == null) {
         System.currentTimeMillis();
         var3 = Class.forName(var1, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
         this.a.put(var1, var3);
      }

      return var3;
   }

   private Method e(Class var1) {
      Method var2 = (Method)this.b.get(var1.getName());
      Method var3 = var2;
      if (var2 == null) {
         Class var4 = this.c(var1);
         System.currentTimeMillis();
         var3 = var4.getDeclaredMethod("write", var1, a.class);
         this.b.put(var1.getName(), var3);
      }

      return var3;
   }

   protected abstract void A(byte[] var1);

   public void B(byte[] var1, int var2) {
      this.w(var2);
      this.A(var1);
   }

   protected abstract void C(CharSequence var1);

   public void D(CharSequence var1, int var2) {
      this.w(var2);
      this.C(var1);
   }

   protected abstract void E(int var1);

   public void F(int var1, int var2) {
      this.w(var2);
      this.E(var1);
   }

   protected abstract void G(Parcelable var1);

   public void H(Parcelable var1, int var2) {
      this.w(var2);
      this.G(var1);
   }

   protected abstract void I(String var1);

   public void J(String var1, int var2) {
      this.w(var2);
      this.I(var1);
   }

   protected <T extends m.a> void K(T var1, a var2) {
      try {
         this.e(var1.getClass()).invoke((Object)null, var1, var2);
      } catch (IllegalAccessException var3) {
         throw new RuntimeException("VersionedParcel encountered IllegalAccessException", var3);
      } catch (InvocationTargetException var4) {
         if (var4.getCause() instanceof RuntimeException) {
            throw (RuntimeException)var4.getCause();
         } else {
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", var4);
         }
      } catch (NoSuchMethodException var5) {
         throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", var5);
      } catch (ClassNotFoundException var6) {
         throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", var6);
      }
   }

   protected void L(m.a var1) {
      if (var1 == null) {
         this.I((String)null);
      } else {
         this.N(var1);
         a var2 = this.b();
         this.K(var1, var2);
         var2.a();
      }
   }

   public void M(m.a var1, int var2) {
      this.w(var2);
      this.L(var1);
   }

   protected abstract void a();

   protected abstract a b();

   public boolean f() {
      return false;
   }

   protected abstract boolean g();

   public boolean h(boolean var1, int var2) {
      return !this.m(var2) ? var1 : this.g();
   }

   protected abstract byte[] i();

   public byte[] j(byte[] var1, int var2) {
      return !this.m(var2) ? var1 : this.i();
   }

   protected abstract CharSequence k();

   public CharSequence l(CharSequence var1, int var2) {
      return !this.m(var2) ? var1 : this.k();
   }

   protected abstract boolean m(int var1);

   protected <T extends m.a> T n(String var1, a var2) {
      try {
         m.a var7 = (m.a)this.d(var1).invoke((Object)null, var2);
         return var7;
      } catch (IllegalAccessException var3) {
         throw new RuntimeException("VersionedParcel encountered IllegalAccessException", var3);
      } catch (InvocationTargetException var4) {
         if (var4.getCause() instanceof RuntimeException) {
            throw (RuntimeException)var4.getCause();
         } else {
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", var4);
         }
      } catch (NoSuchMethodException var5) {
         throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", var5);
      } catch (ClassNotFoundException var6) {
         throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", var6);
      }
   }

   protected abstract int o();

   public int p(int var1, int var2) {
      return !this.m(var2) ? var1 : this.o();
   }

   protected abstract <T extends Parcelable> T q();

   public <T extends Parcelable> T r(T var1, int var2) {
      return !this.m(var2) ? var1 : this.q();
   }

   protected abstract String s();

   public String t(String var1, int var2) {
      return !this.m(var2) ? var1 : this.s();
   }

   protected <T extends m.a> T u() {
      String var1 = this.s();
      return var1 == null ? null : this.n(var1, this.b());
   }

   public <T extends m.a> T v(T var1, int var2) {
      return !this.m(var2) ? var1 : this.u();
   }

   protected abstract void w(int var1);

   public void x(boolean var1, boolean var2) {
   }

   protected abstract void y(boolean var1);

   public void z(boolean var1, int var2) {
      this.w(var2);
      this.y(var1);
   }
}
