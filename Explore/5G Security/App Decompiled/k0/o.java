package k0;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class o implements g<Object> {
   public static final o a = new o();
   private static final boolean b;
   private static final Charset c;

   static {
      boolean var0;
      if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
      c = Charset.forName("UTF8");
   }

   protected static final void c(ByteBuffer var0, int var1) {
      int var2 = var0.position() % var1;
      if (var2 != 0) {
         var0.position(var0.position() + var1 - var2);
      }

   }

   protected static final byte[] d(ByteBuffer var0) {
      byte[] var1 = new byte[e(var0)];
      var0.get(var1);
      return var1;
   }

   protected static final int e(ByteBuffer var0) {
      if (var0.hasRemaining()) {
         int var1 = var0.get() & 255;
         if (var1 < 254) {
            return var1;
         } else {
            return var1 == 254 ? var0.getChar() : var0.getInt();
         }
      } else {
         throw new IllegalArgumentException("Message corrupted");
      }
   }

   protected static final void h(ByteArrayOutputStream var0, int var1) {
      int var2 = var0.size() % var1;
      if (var2 != 0) {
         for(int var3 = 0; var3 < var1 - var2; ++var3) {
            var0.write(0);
         }
      }

   }

   protected static final void i(ByteArrayOutputStream var0, byte[] var1) {
      o(var0, var1.length);
      var0.write(var1, 0, var1.length);
   }

   protected static final void j(ByteArrayOutputStream var0, int var1) {
      if (b) {
         var0.write(var1);
         var1 >>>= 8;
      } else {
         var0.write(var1 >>> 8);
      }

      var0.write(var1);
   }

   protected static final void k(ByteArrayOutputStream var0, double var1) {
      n(var0, Double.doubleToLongBits(var1));
   }

   protected static final void l(ByteArrayOutputStream var0, float var1) {
      m(var0, Float.floatToIntBits(var1));
   }

   protected static final void m(ByteArrayOutputStream var0, int var1) {
      if (b) {
         var0.write(var1);
         var0.write(var1 >>> 8);
         var0.write(var1 >>> 16);
         var1 >>>= 24;
      } else {
         var0.write(var1 >>> 24);
         var0.write(var1 >>> 16);
         var0.write(var1 >>> 8);
      }

      var0.write(var1);
   }

   protected static final void n(ByteArrayOutputStream var0, long var1) {
      if (b) {
         var0.write((byte)((int)var1));
         var0.write((byte)((int)(var1 >>> 8)));
         var0.write((byte)((int)(var1 >>> 16)));
         var0.write((byte)((int)(var1 >>> 24)));
         var0.write((byte)((int)(var1 >>> 32)));
         var0.write((byte)((int)(var1 >>> 40)));
         var0.write((byte)((int)(var1 >>> 48)));
         var1 >>>= 56;
      } else {
         var0.write((byte)((int)(var1 >>> 56)));
         var0.write((byte)((int)(var1 >>> 48)));
         var0.write((byte)((int)(var1 >>> 40)));
         var0.write((byte)((int)(var1 >>> 32)));
         var0.write((byte)((int)(var1 >>> 24)));
         var0.write((byte)((int)(var1 >>> 16)));
         var0.write((byte)((int)(var1 >>> 8)));
      }

      var0.write((byte)((int)var1));
   }

   protected static final void o(ByteArrayOutputStream var0, int var1) {
      if (var1 < 254) {
         var0.write(var1);
      } else if (var1 <= 65535) {
         var0.write(254);
         j(var0, var1);
      } else {
         var0.write(255);
         m(var0, var1);
      }

   }

   public Object a(ByteBuffer var1) {
      if (var1 == null) {
         return null;
      } else {
         var1.order(ByteOrder.nativeOrder());
         Object var2 = this.f(var1);
         if (!var1.hasRemaining()) {
            return var2;
         } else {
            throw new IllegalArgumentException("Message corrupted");
         }
      }
   }

   public ByteBuffer b(Object var1) {
      if (var1 == null) {
         return null;
      } else {
         o.a var2 = new o.a();
         this.p(var2, var1);
         ByteBuffer var3 = ByteBuffer.allocateDirect(var2.size());
         var3.put(var2.a(), 0, var2.size());
         return var3;
      }
   }

   protected final Object f(ByteBuffer var1) {
      if (var1.hasRemaining()) {
         return this.g(var1.get(), var1);
      } else {
         throw new IllegalArgumentException("Message corrupted");
      }
   }

   protected Object g(byte var1, ByteBuffer var2) {
      Object var5;
      Object var8;
      label132: {
         int var7;
         label133: {
            byte var3 = 0;
            byte var4 = 0;
            switch(var1) {
            case 0:
               var8 = null;
               return var8;
            case 1:
               var8 = Boolean.TRUE;
               return var8;
            case 2:
               var8 = Boolean.FALSE;
               return var8;
            case 3:
               var8 = var2.getInt();
               return var8;
            case 4:
               var8 = var2.getLong();
               return var8;
            case 5:
               var8 = new BigInteger(new String(d(var2), c), 16);
               return var8;
            case 6:
               c(var2, 8);
               var8 = var2.getDouble();
               return var8;
            case 7:
               var8 = new String(d(var2), c);
               return var8;
            case 8:
               var8 = d(var2);
               return var8;
            case 9:
               var7 = e(var2);
               var5 = new int[var7];
               c(var2, 4);
               var2.asIntBuffer().get((int[])var5);
               break;
            case 10:
               var7 = e(var2);
               var5 = new long[var7];
               c(var2, 8);
               var2.asLongBuffer().get((long[])var5);
               break label133;
            case 11:
               var7 = e(var2);
               var5 = new double[var7];
               c(var2, 8);
               var2.asDoubleBuffer().get((double[])var5);
               break label133;
            case 12:
               int var10 = e(var2);
               ArrayList var11 = new ArrayList(var10);
               var7 = var3;

               while(true) {
                  var5 = var11;
                  if (var7 >= var10) {
                     break label132;
                  }

                  var11.add(this.f(var2));
                  ++var7;
               }
            case 13:
               int var9 = e(var2);
               HashMap var6 = new HashMap();
               var7 = var4;

               while(true) {
                  var5 = var6;
                  if (var7 >= var9) {
                     break label132;
                  }

                  var6.put(this.f(var2), this.f(var2));
                  ++var7;
               }
            case 14:
               var7 = e(var2);
               var5 = new float[var7];
               c(var2, 4);
               var2.asFloatBuffer().get((float[])var5);
               break;
            default:
               throw new IllegalArgumentException("Message corrupted");
            }

            var2.position(var2.position() + var7 * 4);
            var8 = var5;
            return var8;
         }

         var2.position(var2.position() + var7 * 8);
         var8 = var5;
         return var8;
      }

      var8 = var5;
      return var8;
   }

   protected void p(ByteArrayOutputStream var1, Object var2) {
      byte var3 = 0;
      byte var4 = 0;
      byte var5 = 0;
      int var6 = 0;
      if (var2 != null && !var2.equals((Object)null)) {
         if (var2 instanceof Boolean) {
            byte var19;
            if ((Boolean)var2) {
               var19 = 1;
            } else {
               var19 = 2;
            }

            var1.write(var19);
         } else {
            StringBuilder var8;
            if (var2 instanceof Number) {
               if (!(var2 instanceof Integer) && !(var2 instanceof Short) && !(var2 instanceof Byte)) {
                  if (var2 instanceof Long) {
                     var1.write(4);
                     n(var1, (Long)var2);
                  } else if (!(var2 instanceof Float) && !(var2 instanceof Double)) {
                     if (!(var2 instanceof BigInteger)) {
                        var8 = new StringBuilder();
                        var8.append("Unsupported Number type: ");
                        var8.append(var2.getClass());
                        throw new IllegalArgumentException(var8.toString());
                     }

                     var1.write(5);
                     i(var1, ((BigInteger)var2).toString(16).getBytes(c));
                  } else {
                     var1.write(6);
                     h(var1, 8);
                     k(var1, ((Number)var2).doubleValue());
                  }
               } else {
                  var1.write(3);
                  m(var1, ((Number)var2).intValue());
               }
            } else if (var2 instanceof CharSequence) {
               var1.write(7);
               i(var1, var2.toString().getBytes(c));
            } else if (var2 instanceof byte[]) {
               var1.write(8);
               i(var1, (byte[])var2);
            } else {
               int var12;
               if (var2 instanceof int[]) {
                  var1.write(9);
                  int[] var9 = (int[])var2;
                  o(var1, var9.length);
                  h(var1, 4);

                  for(var12 = var9.length; var6 < var12; ++var6) {
                     m(var1, var9[var6]);
                  }
               } else if (var2 instanceof long[]) {
                  var1.write(10);
                  long[] var10 = (long[])var2;
                  o(var1, var10.length);
                  h(var1, 8);
                  int var16 = var10.length;

                  for(var6 = var3; var6 < var16; ++var6) {
                     n(var1, var10[var6]);
                  }
               } else if (var2 instanceof double[]) {
                  var1.write(11);
                  double[] var11 = (double[])var2;
                  o(var1, var11.length);
                  h(var1, 8);
                  var12 = var11.length;

                  for(var6 = var4; var6 < var12; ++var6) {
                     k(var1, var11[var6]);
                  }
               } else if (var2 instanceof List) {
                  var1.write(12);
                  List var13 = (List)var2;
                  o(var1, var13.size());
                  Iterator var14 = var13.iterator();

                  while(var14.hasNext()) {
                     this.p(var1, var14.next());
                  }
               } else if (var2 instanceof Map) {
                  var1.write(13);
                  Map var15 = (Map)var2;
                  o(var1, var15.size());
                  Iterator var7 = var15.entrySet().iterator();

                  while(var7.hasNext()) {
                     Entry var17 = (Entry)var7.next();
                     this.p(var1, var17.getKey());
                     this.p(var1, var17.getValue());
                  }
               } else {
                  if (!(var2 instanceof float[])) {
                     var8 = new StringBuilder();
                     var8.append("Unsupported value: '");
                     var8.append(var2);
                     var8.append("' of type '");
                     var8.append(var2.getClass());
                     var8.append("'");
                     throw new IllegalArgumentException(var8.toString());
                  }

                  var1.write(14);
                  float[] var18 = (float[])var2;
                  o(var1, var18.length);
                  h(var1, 4);
                  var12 = var18.length;

                  for(var6 = var5; var6 < var12; ++var6) {
                     l(var1, var18[var6]);
                  }
               }
            }
         }
      } else {
         var1.write(0);
      }

   }

   static final class a extends ByteArrayOutputStream {
      byte[] a() {
         return super.buf;
      }
   }
}
