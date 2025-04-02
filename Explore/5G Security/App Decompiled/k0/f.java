package k0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
   public static Object a(Object var0) {
      if (var0 == null) {
         return JSONObject.NULL;
      } else {
         Object var1 = var0;
         if (!(var0 instanceof JSONArray)) {
            if (var0 instanceof JSONObject) {
               var1 = var0;
            } else {
               if (var0.equals(JSONObject.NULL)) {
                  return var0;
               }

               label230: {
                  boolean var10001;
                  Iterator var20;
                  JSONArray var22;
                  label207: {
                     try {
                        if (var0 instanceof Collection) {
                           var22 = new JSONArray();
                           var20 = ((Collection)var0).iterator();
                           break label207;
                        }
                     } catch (Exception var19) {
                        var10001 = false;
                        break label230;
                     }

                     int var2;
                     label195: {
                        try {
                           if (var0.getClass().isArray()) {
                              var22 = new JSONArray();
                              var2 = Array.getLength(var0);
                              break label195;
                           }
                        } catch (Exception var18) {
                           var10001 = false;
                           break label230;
                        }

                        JSONObject var21;
                        label196: {
                           try {
                              if (var0 instanceof Map) {
                                 var21 = new JSONObject();
                                 var20 = ((Map)var0).entrySet().iterator();
                                 break label196;
                              }
                           } catch (Exception var17) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           try {
                              if (var0 instanceof Boolean) {
                                 return var1;
                              }
                           } catch (Exception var15) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           try {
                              if (var0 instanceof Byte) {
                                 return var1;
                              }
                           } catch (Exception var14) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           try {
                              if (var0 instanceof Character) {
                                 return var1;
                              }
                           } catch (Exception var13) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           try {
                              if (var0 instanceof Double) {
                                 return var1;
                              }
                           } catch (Exception var12) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           try {
                              if (var0 instanceof Float) {
                                 return var1;
                              }
                           } catch (Exception var11) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           try {
                              if (var0 instanceof Integer) {
                                 return var1;
                              }
                           } catch (Exception var10) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           try {
                              if (var0 instanceof Long) {
                                 return var1;
                              }
                           } catch (Exception var9) {
                              var10001 = false;
                              break label230;
                           }

                           var1 = var0;

                           label231: {
                              try {
                                 if (var0 instanceof Short) {
                                    return var1;
                                 }

                                 if (!(var0 instanceof String)) {
                                    break label231;
                                 }
                              } catch (Exception var16) {
                                 var10001 = false;
                                 break label230;
                              }

                              var1 = var0;
                              return var1;
                           }

                           try {
                              if (!var0.getClass().getPackage().getName().startsWith("java.")) {
                                 break label230;
                              }

                              var1 = var0.toString();
                              return var1;
                           } catch (Exception var8) {
                              var10001 = false;
                              break label230;
                           }
                        }

                        while(true) {
                           try {
                              if (!var20.hasNext()) {
                                 return var21;
                              }

                              Entry var4 = (Entry)var20.next();
                              var21.put((String)var4.getKey(), a(var4.getValue()));
                           } catch (Exception var7) {
                              var10001 = false;
                              break label230;
                           }
                        }
                     }

                     for(int var3 = 0; var3 < var2; ++var3) {
                        try {
                           var22.put(a(Array.get(var0, var3)));
                        } catch (Exception var5) {
                           var10001 = false;
                           break label230;
                        }
                     }

                     return var22;
                  }

                  while(true) {
                     try {
                        if (!var20.hasNext()) {
                           return var22;
                        }

                        var22.put(a(var20.next()));
                     } catch (Exception var6) {
                        var10001 = false;
                        break;
                     }
                  }
               }

               var1 = null;
            }
         }

         return var1;
      }
   }
}
