package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o {
   public static final o a = new o();
   private static final Map<Class<?>, Integer> b = new HashMap();
   private static final Map<Class<?>, List<Constructor<? extends g>>> c = new HashMap();

   private o() {
   }

   private final g a(Constructor<? extends g> var1, Object var2) {
      try {
         Object var6 = var1.newInstance(var2);
         a1.k.d(var6, "{\n            constructo…tance(`object`)\n        }");
         g var7 = (g)var6;
         return var7;
      } catch (IllegalAccessException var3) {
         throw new RuntimeException(var3);
      } catch (InstantiationException var4) {
         throw new RuntimeException(var4);
      } catch (InvocationTargetException var5) {
         throw new RuntimeException(var5);
      }
   }

   private final Constructor<? extends g> b(Class<?> var1) {
      NoSuchMethodException var10000;
      label118: {
         Constructor var22;
         Constructor var26;
         label119: {
            label109: {
               Package var2;
               String var3;
               boolean var10001;
               try {
                  var2 = var1.getPackage();
                  var3 = var1.getCanonicalName();
               } catch (ClassNotFoundException var20) {
                  var10001 = false;
                  break label109;
               } catch (NoSuchMethodException var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label118;
               }

               String var24;
               if (var2 != null) {
                  try {
                     var24 = var2.getName();
                  } catch (ClassNotFoundException var18) {
                     var10001 = false;
                     break label109;
                  } catch (NoSuchMethodException var19) {
                     var10000 = var19;
                     var10001 = false;
                     break label118;
                  }
               } else {
                  var24 = "";
               }

               boolean var4;
               label95: {
                  label94: {
                     try {
                        a1.k.d(var24, "fullPackage");
                        if (var24.length() == 0) {
                           break label94;
                        }
                     } catch (ClassNotFoundException var16) {
                        var10001 = false;
                        break label109;
                     } catch (NoSuchMethodException var17) {
                        var10000 = var17;
                        var10001 = false;
                        break label118;
                     }

                     var4 = false;
                     break label95;
                  }

                  var4 = true;
               }

               if (!var4) {
                  try {
                     a1.k.d(var3, "name");
                     var3 = var3.substring(var24.length() + 1);
                     a1.k.d(var3, "this as java.lang.String).substring(startIndex)");
                  } catch (ClassNotFoundException var14) {
                     var10001 = false;
                     break label109;
                  } catch (NoSuchMethodException var15) {
                     var10000 = var15;
                     var10001 = false;
                     break label118;
                  }
               }

               label83: {
                  label82: {
                     try {
                        a1.k.d(var3, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                        var3 = c(var3);
                        if (var24.length() == 0) {
                           break label82;
                        }
                     } catch (ClassNotFoundException var12) {
                        var10001 = false;
                        break label109;
                     } catch (NoSuchMethodException var13) {
                        var10000 = var13;
                        var10001 = false;
                        break label118;
                     }

                     var4 = false;
                     break label83;
                  }

                  var4 = true;
               }

               if (var4) {
                  var24 = var3;
               } else {
                  try {
                     StringBuilder var5 = new StringBuilder();
                     var5.append(var24);
                     var5.append('.');
                     var5.append(var3);
                     var24 = var5.toString();
                  } catch (ClassNotFoundException var10) {
                     var10001 = false;
                     break label109;
                  } catch (NoSuchMethodException var11) {
                     var10000 = var11;
                     var10001 = false;
                     break label118;
                  }
               }

               try {
                  Class var25 = Class.forName(var24);
                  a1.k.c(var25, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
                  var26 = var25.getDeclaredConstructor(var1);
               } catch (ClassNotFoundException var8) {
                  var10001 = false;
                  break label109;
               } catch (NoSuchMethodException var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label118;
               }

               var22 = var26;

               try {
                  if (var26.isAccessible()) {
                     return var22;
                  }

                  var26.setAccessible(true);
                  break label119;
               } catch (ClassNotFoundException var6) {
                  var10001 = false;
               } catch (NoSuchMethodException var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label118;
               }
            }

            var22 = null;
            return var22;
         }

         var22 = var26;
         return var22;
      }

      NoSuchMethodException var23 = var10000;
      throw new RuntimeException(var23);
   }

   public static final String c(String var0) {
      a1.k.e(var0, "className");
      StringBuilder var1 = new StringBuilder();
      var1.append(g1.d.k(var0, ".", "_", false, 4, (Object)null));
      var1.append("_LifecycleAdapter");
      return var1.toString();
   }

   private final int d(Class<?> var1) {
      Map var2 = b;
      Integer var3 = (Integer)var2.get(var1);
      if (var3 != null) {
         return var3;
      } else {
         int var4 = this.g(var1);
         var2.put(var1, var4);
         return var4;
      }
   }

   private final boolean e(Class<?> var1) {
      boolean var2;
      if (var1 != null && k.class.isAssignableFrom(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static final j f(Object var0) {
      a1.k.e(var0, "object");
      boolean var1 = var0 instanceof j;
      boolean var2 = var0 instanceof d;
      if (var1 && var2) {
         return new e((d)var0, (j)var0);
      } else if (var2) {
         return new e((d)var0, (j)null);
      } else if (var1) {
         return (j)var0;
      } else {
         Class var3 = var0.getClass();
         o var4 = a;
         if (var4.d(var3) != 2) {
            return new u(var0);
         } else {
            Object var7 = c.get(var3);
            a1.k.b(var7);
            List var8 = (List)var7;
            int var5 = var8.size();
            int var6 = 0;
            if (var5 == 1) {
               return new w(var4.a((Constructor)var8.get(0), var0));
            } else {
               var5 = var8.size();

               g[] var9;
               for(var9 = new g[var5]; var6 < var5; ++var6) {
                  var9[var6] = a.a((Constructor)var8.get(var6), var0);
               }

               return new b(var9);
            }
         }
      }
   }

   private final int g(Class<?> var1) {
      if (var1.getCanonicalName() == null) {
         return 1;
      } else {
         Constructor var2 = this.b(var1);
         if (var2 != null) {
            c.put(var1, q0.l.b(var2));
            return 2;
         } else if (androidx.lifecycle.a.c.d(var1)) {
            return 1;
         } else {
            Class var8 = var1.getSuperclass();
            ArrayList var3 = null;
            if (this.e(var8)) {
               a1.k.d(var8, "superclass");
               if (this.d(var8) == 1) {
                  return 1;
               }

               Object var9 = c.get(var8);
               a1.k.b(var9);
               var3 = new ArrayList((Collection)var9);
            }

            Class[] var4 = var1.getInterfaces();
            a1.k.d(var4, "klass.interfaces");
            int var5 = 0;

            ArrayList var10;
            for(int var6 = var4.length; var5 < var6; var3 = var10) {
               Class var7 = var4[var5];
               if (!this.e(var7)) {
                  var10 = var3;
               } else {
                  a1.k.d(var7, "intrface");
                  if (this.d(var7) == 1) {
                     return 1;
                  }

                  var10 = var3;
                  if (var3 == null) {
                     var10 = new ArrayList();
                  }

                  Object var11 = c.get(var7);
                  a1.k.b(var11);
                  var10.addAll((Collection)var11);
               }

               ++var5;
            }

            if (var3 != null) {
               c.put(var1, var3);
               return 2;
            } else {
               return 1;
            }
         }
      }
   }
}
