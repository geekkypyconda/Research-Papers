package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
final class a {
   static androidx.lifecycle.a c = new androidx.lifecycle.a();
   private final Map<Class<?>, androidx.lifecycle.a.a> a = new HashMap();
   private final Map<Class<?>, Boolean> b = new HashMap();

   private androidx.lifecycle.a.a a(Class<?> var1, Method[] var2) {
      Class var3 = var1.getSuperclass();
      HashMap var4 = new HashMap();
      if (var3 != null) {
         androidx.lifecycle.a.a var12 = this.c(var3);
         if (var12 != null) {
            var4.putAll(var12.b);
         }
      }

      Class[] var5 = var1.getInterfaces();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Iterator var13 = this.c(var5[var7]).b.entrySet().iterator();

         while(var13.hasNext()) {
            Entry var8 = (Entry)var13.next();
            this.e(var4, (androidx.lifecycle.a.b)var8.getKey(), (h.a)var8.getValue(), var1);
         }
      }

      if (var2 == null) {
         var2 = this.b(var1);
      }

      int var9 = var2.length;
      var6 = 0;

      boolean var10;
      for(var10 = false; var6 < var9; ++var6) {
         Method var15 = var2[var6];
         q var17 = (q)var15.getAnnotation(q.class);
         if (var17 != null) {
            Class[] var14 = var15.getParameterTypes();
            byte var16;
            if (var14.length > 0) {
               if (!l.class.isAssignableFrom(var14[0])) {
                  throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
               }

               var16 = 1;
            } else {
               var16 = 0;
            }

            h.a var18 = var17.value();
            if (var14.length > 1) {
               if (!h.a.class.isAssignableFrom(var14[1])) {
                  throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
               }

               if (var18 != h.a.ON_ANY) {
                  throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
               }

               var16 = 2;
            }

            if (var14.length > 2) {
               throw new IllegalArgumentException("cannot have more than 2 params");
            }

            this.e(var4, new androidx.lifecycle.a.b(var16, var15), var18, var1);
            var10 = true;
         }
      }

      androidx.lifecycle.a.a var11 = new androidx.lifecycle.a.a(var4);
      this.a.put(var1, var11);
      this.b.put(var1, var10);
      return var11;
   }

   private Method[] b(Class<?> var1) {
      try {
         Method[] var3 = var1.getDeclaredMethods();
         return var3;
      } catch (NoClassDefFoundError var2) {
         throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", var2);
      }
   }

   private void e(Map<androidx.lifecycle.a.b, h.a> var1, androidx.lifecycle.a.b var2, h.a var3, Class<?> var4) {
      h.a var5 = (h.a)var1.get(var2);
      if (var5 != null && var3 != var5) {
         Method var6 = var2.b;
         StringBuilder var7 = new StringBuilder();
         var7.append("Method ");
         var7.append(var6.getName());
         var7.append(" in ");
         var7.append(var4.getName());
         var7.append(" already declared with different @OnLifecycleEvent value: previous value ");
         var7.append(var5);
         var7.append(", new value ");
         var7.append(var3);
         throw new IllegalArgumentException(var7.toString());
      } else {
         if (var5 == null) {
            var1.put(var2, var3);
         }

      }
   }

   androidx.lifecycle.a.a c(Class<?> var1) {
      androidx.lifecycle.a.a var2 = (androidx.lifecycle.a.a)this.a.get(var1);
      return var2 != null ? var2 : this.a(var1, (Method[])null);
   }

   boolean d(Class<?> var1) {
      Boolean var2 = (Boolean)this.b.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         Method[] var5 = this.b(var1);
         int var3 = var5.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            if ((q)var5[var4].getAnnotation(q.class) != null) {
               this.a(var1, var5);
               return true;
            }
         }

         this.b.put(var1, Boolean.FALSE);
         return false;
      }
   }

   @Deprecated
   static class a {
      final Map<h.a, List<androidx.lifecycle.a.b>> a;
      final Map<androidx.lifecycle.a.b, h.a> b;

      a(Map<androidx.lifecycle.a.b, h.a> var1) {
         this.b = var1;
         this.a = new HashMap();

         Entry var3;
         Object var6;
         for(Iterator var2 = var1.entrySet().iterator(); var2.hasNext(); ((List)var6).add((androidx.lifecycle.a.b)var3.getKey())) {
            var3 = (Entry)var2.next();
            h.a var4 = (h.a)var3.getValue();
            List var5 = (List)this.a.get(var4);
            var6 = var5;
            if (var5 == null) {
               var6 = new ArrayList();
               this.a.put(var4, var6);
            }
         }

      }

      private static void b(List<androidx.lifecycle.a.b> var0, l var1, h.a var2, Object var3) {
         if (var0 != null) {
            for(int var4 = var0.size() - 1; var4 >= 0; --var4) {
               ((androidx.lifecycle.a.b)var0.get(var4)).a(var1, var2, var3);
            }
         }

      }

      void a(l var1, h.a var2, Object var3) {
         b((List)this.a.get(var2), var1, var2, var3);
         b((List)this.a.get(h.a.ON_ANY), var1, var2, var3);
      }
   }

   @Deprecated
   static final class b {
      final int a;
      final Method b;

      b(int var1, Method var2) {
         this.a = var1;
         this.b = var2;
         var2.setAccessible(true);
      }

      void a(l var1, h.a var2, Object var3) {
         InvocationTargetException var15;
         label49: {
            IllegalAccessException var10000;
            label48: {
               int var4;
               boolean var10001;
               try {
                  var4 = this.a;
               } catch (InvocationTargetException var11) {
                  var15 = var11;
                  var10001 = false;
                  break label49;
               } catch (IllegalAccessException var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label48;
               }

               if (var4 != 0) {
                  if (var4 != 1) {
                     if (var4 != 2) {
                        return;
                     }

                     try {
                        this.b.invoke(var3, var1, var2);
                        return;
                     } catch (InvocationTargetException var5) {
                        var15 = var5;
                        var10001 = false;
                        break label49;
                     } catch (IllegalAccessException var6) {
                        var10000 = var6;
                        var10001 = false;
                     }
                  } else {
                     try {
                        this.b.invoke(var3, var1);
                        return;
                     } catch (InvocationTargetException var7) {
                        var15 = var7;
                        var10001 = false;
                        break label49;
                     } catch (IllegalAccessException var8) {
                        var10000 = var8;
                        var10001 = false;
                     }
                  }
               } else {
                  try {
                     this.b.invoke(var3);
                     return;
                  } catch (InvocationTargetException var9) {
                     var15 = var9;
                     var10001 = false;
                     break label49;
                  } catch (IllegalAccessException var10) {
                     var10000 = var10;
                     var10001 = false;
                  }
               }
            }

            IllegalAccessException var13 = var10000;
            throw new RuntimeException(var13);
         }

         InvocationTargetException var14 = var15;
         throw new RuntimeException("Failed to call observer method", var14.getCause());
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof androidx.lifecycle.a.b)) {
            return false;
         } else {
            androidx.lifecycle.a.b var3 = (androidx.lifecycle.a.b)var1;
            if (this.a != var3.a || !this.b.getName().equals(var3.b.getName())) {
               var2 = false;
            }

            return var2;
         }
      }

      public int hashCode() {
         return this.a * 31 + this.b.getName().hashCode();
      }
   }
}
