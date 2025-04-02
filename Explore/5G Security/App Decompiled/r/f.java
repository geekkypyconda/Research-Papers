package r;

import a1.r;
import android.app.Activity;
import android.content.Context;

public interface f {
   f.a a = f.a.a;

   k1.c<j> a(Activity var1);

   public static final class a {
      // $FF: synthetic field
      static final f.a a = new f.a();
      private static final boolean b = false;
      private static final String c = r.b(f.class).b();
      private static final p0.e<s.a> d;
      private static g e;

      static {
         d = p0.f.a(null.f);
         e = b.a;
      }

      private a() {
      }

      // $FF: synthetic method
      public static final boolean a() {
         return b;
      }

      // $FF: synthetic method
      public static final String b() {
         return c;
      }

      public final s.a c() {
         return (s.a)d.getValue();
      }

      public final f d(Context var1) {
         a1.k.e(var1, "context");
         s.a var2 = this.c();
         Object var3 = var2;
         if (var2 == null) {
            var3 = androidx.window.layout.adapter.sidecar.b.c.a(var1);
         }

         i var4 = new i(n.b, (s.a)var3);
         return e.a(var4);
      }
   }
}
