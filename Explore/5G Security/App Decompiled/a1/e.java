package a1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import q0.b0;
import z0.u;
import z0.v;
import z0.w;

public final class e implements e1.b<Object>, d {
   public static final e.a b = new e.a((g)null);
   private static final Map<Class<? extends p0.c<?>>, Integer> c;
   private static final HashMap<String, String> d;
   private static final HashMap<String, String> e;
   private static final HashMap<String, String> f;
   private static final Map<String, String> g;
   private final Class<?> a;

   static {
      int var0 = 0;
      List var1 = q0.l.g(z0.a.class, z0.l.class, z0.p.class, z0.q.class, z0.r.class, z0.s.class, z0.t.class, u.class, v.class, w.class, z0.b.class, z0.c.class, z0.d.class, z0.e.class, z0.f.class, z0.g.class, z0.h.class, z0.i.class, z0.j.class, z0.k.class, z0.m.class, z0.n.class, z0.o.class);
      ArrayList var2 = new ArrayList(q0.l.j(var1, 10));

      Iterator var6;
      for(var6 = var1.iterator(); var6.hasNext(); ++var0) {
         Object var3 = var6.next();
         if (var0 < 0) {
            q0.l.i();
         }

         var2.add(p0.n.a((Class)var3, var0));
      }

      c = b0.g(var2);
      HashMap var7 = new HashMap();
      var7.put("boolean", "kotlin.Boolean");
      var7.put("char", "kotlin.Char");
      var7.put("byte", "kotlin.Byte");
      var7.put("short", "kotlin.Short");
      var7.put("int", "kotlin.Int");
      var7.put("float", "kotlin.Float");
      var7.put("long", "kotlin.Long");
      var7.put("double", "kotlin.Double");
      d = var7;
      HashMap var12 = new HashMap();
      var12.put("java.lang.Boolean", "kotlin.Boolean");
      var12.put("java.lang.Character", "kotlin.Char");
      var12.put("java.lang.Byte", "kotlin.Byte");
      var12.put("java.lang.Short", "kotlin.Short");
      var12.put("java.lang.Integer", "kotlin.Int");
      var12.put("java.lang.Float", "kotlin.Float");
      var12.put("java.lang.Long", "kotlin.Long");
      var12.put("java.lang.Double", "kotlin.Double");
      e = var12;
      HashMap var9 = new HashMap();
      var9.put("java.lang.Object", "kotlin.Any");
      var9.put("java.lang.String", "kotlin.String");
      var9.put("java.lang.CharSequence", "kotlin.CharSequence");
      var9.put("java.lang.Throwable", "kotlin.Throwable");
      var9.put("java.lang.Cloneable", "kotlin.Cloneable");
      var9.put("java.lang.Number", "kotlin.Number");
      var9.put("java.lang.Comparable", "kotlin.Comparable");
      var9.put("java.lang.Enum", "kotlin.Enum");
      var9.put("java.lang.annotation.Annotation", "kotlin.Annotation");
      var9.put("java.lang.Iterable", "kotlin.collections.Iterable");
      var9.put("java.util.Iterator", "kotlin.collections.Iterator");
      var9.put("java.util.Collection", "kotlin.collections.Collection");
      var9.put("java.util.List", "kotlin.collections.List");
      var9.put("java.util.Set", "kotlin.collections.Set");
      var9.put("java.util.ListIterator", "kotlin.collections.ListIterator");
      var9.put("java.util.Map", "kotlin.collections.Map");
      var9.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
      var9.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
      var9.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
      var9.putAll(var7);
      var9.putAll(var12);
      Collection var8 = var7.values();
      k.d(var8, "primitiveFqNames.values");
      var6 = var8.iterator();

      String var15;
      while(var6.hasNext()) {
         String var13 = (String)var6.next();
         StringBuilder var4 = new StringBuilder();
         var4.append("kotlin.jvm.internal.");
         k.d(var13, "kotlinName");
         var4.append(g1.d.R(var13, '.', (String)null, 2, (Object)null));
         var4.append("CompanionObject");
         var15 = var4.toString();
         StringBuilder var5 = new StringBuilder();
         var5.append(var13);
         var5.append(".Companion");
         p0.j var14 = p0.n.a(var15, var5.toString());
         var9.put(var14.c(), var14.d());
      }

      var6 = c.entrySet().iterator();

      Entry var16;
      while(var6.hasNext()) {
         var16 = (Entry)var6.next();
         Class var17 = (Class)var16.getKey();
         var0 = ((Number)var16.getValue()).intValue();
         var15 = var17.getName();
         StringBuilder var18 = new StringBuilder();
         var18.append("kotlin.Function");
         var18.append(var0);
         var9.put(var15, var18.toString());
      }

      f = var9;
      LinkedHashMap var11 = new LinkedHashMap(b0.a(var9.size()));
      Iterator var10 = var9.entrySet().iterator();

      while(var10.hasNext()) {
         var16 = (Entry)var10.next();
         var11.put(var16.getKey(), g1.d.R((String)var16.getValue(), '.', (String)null, 2, (Object)null));
      }

      g = var11;
   }

   public e(Class<?> var1) {
      k.e(var1, "jClass");
      super();
      this.a = var1;
   }

   public String a() {
      return b.a(this.c());
   }

   public String b() {
      return b.b(this.c());
   }

   public Class<?> c() {
      return this.a;
   }

   public boolean d(Object var1) {
      return b.c(var1, this.c());
   }

   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof e && k.a(y0.a.b(this), y0.a.b((e1.b)var1))) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      return y0.a.b(this).hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.c().toString());
      var1.append(" (Kotlin reflection is not available)");
      return var1.toString();
   }

   public static final class a {
      private a() {
      }

      // $FF: synthetic method
      public a(g var1) {
         this();
      }

      public final String a(Class<?> var1) {
         k.e(var1, "jClass");
         boolean var2 = var1.isAnonymousClass();
         Class var3 = null;
         String var4 = null;
         if (var2) {
            var4 = var3;
         } else if (var1.isLocalClass()) {
            var4 = var3;
         } else {
            String var7;
            if (var1.isArray()) {
               var3 = var1.getComponentType();
               String var5 = var4;
               if (var3.isPrimitive()) {
                  var7 = (String)a1.e.f.get(var3.getName());
                  var5 = var4;
                  if (var7 != null) {
                     StringBuilder var6 = new StringBuilder();
                     var6.append(var7);
                     var6.append("Array");
                     var5 = var6.toString();
                  }
               }

               var4 = var5;
               if (var5 == null) {
                  var4 = "kotlin.Array";
               }
            } else {
               var7 = (String)a1.e.f.get(var1.getName());
               var4 = var7;
               if (var7 == null) {
                  var4 = var1.getCanonicalName();
               }
            }
         }

         return var4;
      }

      public final String b(Class<?> var1) {
         k.e(var1, "jClass");
         boolean var2 = var1.isAnonymousClass();
         String var3 = "Array";
         String var4 = null;
         String var5 = null;
         if (var2) {
            var4 = var5;
         } else if (var1.isLocalClass()) {
            var5 = var1.getSimpleName();
            Method var9 = var1.getEnclosingMethod();
            StringBuilder var10;
            if (var9 != null) {
               k.d(var5, "name");
               var10 = new StringBuilder();
               var10.append(var9.getName());
               var10.append('$');
               var3 = g1.d.P(var5, var10.toString(), (String)null, 2, (Object)null);
               var4 = var3;
               if (var3 != null) {
                  return var4;
               }
            }

            Constructor var6 = var1.getEnclosingConstructor();
            k.d(var5, "name");
            if (var6 != null) {
               var10 = new StringBuilder();
               var10.append(var6.getName());
               var10.append('$');
               var4 = g1.d.P(var5, var10.toString(), (String)null, 2, (Object)null);
            } else {
               var4 = g1.d.O(var5, '$', (String)null, 2, (Object)null);
            }
         } else if (var1.isArray()) {
            Class var11 = var1.getComponentType();
            String var7 = var4;
            if (var11.isPrimitive()) {
               var5 = (String)a1.e.g.get(var11.getName());
               var7 = var4;
               if (var5 != null) {
                  StringBuilder var8 = new StringBuilder();
                  var8.append(var5);
                  var8.append("Array");
                  var7 = var8.toString();
               }
            }

            var4 = var7;
            if (var7 == null) {
               var4 = var3;
            }
         } else {
            var3 = (String)a1.e.g.get(var1.getName());
            var4 = var3;
            if (var3 == null) {
               var4 = var1.getSimpleName();
            }
         }

         return var4;
      }

      public final boolean c(Object var1, Class<?> var2) {
         k.e(var2, "jClass");
         Map var3 = a1.e.c;
         k.c(var3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
         Integer var4 = (Integer)var3.get(var2);
         if (var4 != null) {
            return t.c(var1, var4.intValue());
         } else {
            Class var5 = var2;
            if (var2.isPrimitive()) {
               var5 = y0.a.b(y0.a.c(var2));
            }

            return var5.isInstance(var1);
         }
      }
   }
}
