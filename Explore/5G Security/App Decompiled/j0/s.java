package j0;

import android.os.Bundle;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s {
   public final k0.i a;
   private s.f b;
   final k0.i.c c;

   public s(z.a var1) {
      k0.i.c var2 = new k0.i.c() {
         public void a(k0.h param1, k0.i.d param2) {
            // $FF: Couldn't be decompiled
         }
      };
      this.c = var2;
      k0.i var3 = new k0.i(var1, "flutter/textinput", k0.e.a);
      this.a = var3;
      var3.e(var2);
   }

   // $FF: synthetic method
   static s.f a(s var0) {
      return var0.b;
   }

   private static HashMap<Object, Object> c(ArrayList<io.flutter.plugin.editing.g> var0) {
      HashMap var1 = new HashMap();
      JSONArray var2 = new JSONArray();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         var2.put(((io.flutter.plugin.editing.g)var3.next()).b());
      }

      var1.put("deltas", var2);
      return var1;
   }

   private static HashMap<Object, Object> d(String var0, int var1, int var2, int var3, int var4) {
      HashMap var5 = new HashMap();
      var5.put("text", var0);
      var5.put("selectionBase", var1);
      var5.put("selectionExtent", var2);
      var5.put("composingBase", var3);
      var5.put("composingExtent", var4);
      return var5;
   }

   public void b(int var1, Map<String, Object> var2) {
      y.b.f("TextInputChannel", "Sending 'commitContent' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.commitContent", var2));
   }

   public void e(int var1) {
      y.b.f("TextInputChannel", "Sending 'done' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.done"));
   }

   public void f(int var1) {
      y.b.f("TextInputChannel", "Sending 'go' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.go"));
   }

   public void g(int var1) {
      y.b.f("TextInputChannel", "Sending 'newline' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.newline"));
   }

   public void h(int var1) {
      y.b.f("TextInputChannel", "Sending 'next' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.next"));
   }

   public void i(int var1, String var2, Bundle var3) {
      HashMap var4 = new HashMap();
      var4.put("action", var2);
      if (var3 != null) {
         HashMap var5 = new HashMap();
         Iterator var8 = var3.keySet().iterator();

         while(var8.hasNext()) {
            String var6 = (String)var8.next();
            Object var7 = var3.get(var6);
            if (var7 instanceof byte[]) {
               var5.put(var6, var3.getByteArray(var6));
            } else if (var7 instanceof Byte) {
               var5.put(var6, var3.getByte(var6));
            } else if (var7 instanceof char[]) {
               var5.put(var6, var3.getCharArray(var6));
            } else if (var7 instanceof Character) {
               var5.put(var6, var3.getChar(var6));
            } else if (var7 instanceof CharSequence[]) {
               var5.put(var6, var3.getCharSequenceArray(var6));
            } else if (var7 instanceof CharSequence) {
               var5.put(var6, var3.getCharSequence(var6));
            } else if (var7 instanceof float[]) {
               var5.put(var6, var3.getFloatArray(var6));
            } else if (var7 instanceof Float) {
               var5.put(var6, var3.getFloat(var6));
            }
         }

         var4.put("data", var5);
      }

      this.a.c("TextInputClient.performPrivateCommand", Arrays.asList(var1, var4));
   }

   public void j(int var1) {
      y.b.f("TextInputChannel", "Sending 'previous' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.previous"));
   }

   public void k() {
      this.a.c("TextInputClient.requestExistingInputState", (Object)null);
   }

   public void l(int var1) {
      y.b.f("TextInputChannel", "Sending 'search' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.search"));
   }

   public void m(int var1) {
      y.b.f("TextInputChannel", "Sending 'send' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.send"));
   }

   public void n(s.f var1) {
      this.b = var1;
   }

   public void o(int var1) {
      y.b.f("TextInputChannel", "Sending 'unspecified' message.");
      this.a.c("TextInputClient.performAction", Arrays.asList(var1, "TextInputAction.unspecified"));
   }

   public void p(int var1, String var2, int var3, int var4, int var5, int var6) {
      StringBuilder var7 = new StringBuilder();
      var7.append("Sending message to update editing state: \nText: ");
      var7.append(var2);
      var7.append("\nSelection start: ");
      var7.append(var3);
      var7.append("\nSelection end: ");
      var7.append(var4);
      var7.append("\nComposing start: ");
      var7.append(var5);
      var7.append("\nComposing end: ");
      var7.append(var6);
      y.b.f("TextInputChannel", var7.toString());
      HashMap var8 = d(var2, var3, var4, var5, var6);
      this.a.c("TextInputClient.updateEditingState", Arrays.asList(var1, var8));
   }

   public void q(int var1, ArrayList<io.flutter.plugin.editing.g> var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Sending message to update editing state with deltas: \nNumber of deltas: ");
      var3.append(var2.size());
      y.b.f("TextInputChannel", var3.toString());
      HashMap var4 = c(var2);
      this.a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(var1, var4));
   }

   public void r(int var1, HashMap<String, s.e> var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Sending message to update editing state for ");
      var3.append(String.valueOf(var2.size()));
      var3.append(" field(s).");
      y.b.f("TextInputChannel", var3.toString());
      HashMap var7 = new HashMap();
      Iterator var6 = var2.entrySet().iterator();

      while(var6.hasNext()) {
         Entry var4 = (Entry)var6.next();
         s.e var5 = (s.e)var4.getValue();
         var7.put((String)var4.getKey(), d(var5.a, var5.b, var5.c, -1, -1));
      }

      this.a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(var1, var7));
   }

   public static class b {
      public final boolean a;
      public final boolean b;
      public final boolean c;
      public final boolean d;
      public final boolean e;
      public final s.d f;
      public final s.c g;
      public final Integer h;
      public final String i;
      public final s.b.a j;
      public final String[] k;
      public final s.b[] l;

      public b(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, s.d var6, s.c var7, Integer var8, String var9, s.b.a var10, String[] var11, s.b[] var12) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.h = var8;
         this.i = var9;
         this.j = var10;
         this.k = var11;
         this.l = var12;
      }

      public static s.b a(JSONObject var0) {
         String var1 = var0.getString("inputAction");
         if (var1 == null) {
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
         } else {
            boolean var2 = var0.isNull("fields");
            byte var3 = 0;
            Object var4 = null;
            s.b[] var7;
            int var8;
            if (!var2) {
               JSONArray var5 = var0.getJSONArray("fields");
               int var6 = var5.length();
               var7 = new s.b[var6];

               for(var8 = 0; var8 < var6; ++var8) {
                  var7[var8] = a(var5.getJSONObject(var8));
               }
            } else {
               var7 = null;
            }

            Integer var18 = b(var1);
            ArrayList var9 = new ArrayList();
            JSONArray var17;
            if (var0.isNull("contentCommitMimeTypes")) {
               var17 = null;
            } else {
               var17 = var0.getJSONArray("contentCommitMimeTypes");
            }

            if (var17 != null) {
               for(var8 = var3; var8 < var17.length(); ++var8) {
                  var9.add(var17.optString(var8));
               }
            }

            boolean var10 = var0.optBoolean("obscureText");
            boolean var11 = var0.optBoolean("autocorrect", true);
            boolean var12 = var0.optBoolean("enableSuggestions");
            boolean var13 = var0.optBoolean("enableIMEPersonalizedLearning");
            var2 = var0.optBoolean("enableDeltaModel");
            s.d var14 = s.d.b(var0.getString("textCapitalization"));
            s.c var15 = s.c.a(var0.getJSONObject("inputType"));
            if (var0.isNull("actionLabel")) {
               var1 = null;
            } else {
               var1 = var0.getString("actionLabel");
            }

            s.b.a var16;
            if (var0.isNull("autofill")) {
               var16 = (s.b.a)var4;
            } else {
               var16 = s.b.a.a(var0.getJSONObject("autofill"));
            }

            return new s.b(var10, var11, var12, var13, var2, var14, var15, var18, var1, var16, (String[])var9.toArray(new String[var9.size()]), var7);
         }
      }

      private static Integer b(String var0) {
         byte var2;
         Integer var3;
         Integer var4;
         label57: {
            var0.hashCode();
            int var1 = var0.hashCode();
            var2 = 1;
            var3 = 1;
            var4 = 0;
            switch(var1) {
            case -810971940:
               if (var0.equals("TextInputAction.unspecified")) {
                  var2 = 0;
                  break label57;
               }
               break;
            case -737377923:
               if (var0.equals("TextInputAction.done")) {
                  break label57;
               }
               break;
            case -737089298:
               if (var0.equals("TextInputAction.next")) {
                  var2 = 2;
                  break label57;
               }
               break;
            case -737080013:
               if (var0.equals("TextInputAction.none")) {
                  var2 = 3;
                  break label57;
               }
               break;
            case -736940669:
               if (var0.equals("TextInputAction.send")) {
                  var2 = 4;
                  break label57;
               }
               break;
            case 469250275:
               if (var0.equals("TextInputAction.search")) {
                  var2 = 5;
                  break label57;
               }
               break;
            case 1241689507:
               if (var0.equals("TextInputAction.go")) {
                  var2 = 6;
                  break label57;
               }
               break;
            case 1539450297:
               if (var0.equals("TextInputAction.newline")) {
                  var2 = 7;
                  break label57;
               }
               break;
            case 2110497650:
               if (var0.equals("TextInputAction.previous")) {
                  var2 = 8;
                  break label57;
               }
            }

            var2 = -1;
         }

         switch(var2) {
         case 0:
            return var4;
         case 1:
            return 6;
         case 2:
            return 5;
         case 3:
            return var3;
         case 4:
            return 4;
         case 5:
            return 3;
         case 6:
            return 2;
         case 7:
            return var3;
         case 8:
            return 7;
         default:
            return var4;
         }
      }

      public static class a {
         public final String a;
         public final String[] b;
         public final s.e c;
         public final String d;

         public a(String var1, String[] var2, String var3, s.e var4) {
            this.a = var1;
            this.b = var2;
            this.d = var3;
            this.c = var4;
         }

         public static s.b.a a(JSONObject var0) {
            String var1 = var0.getString("uniqueIdentifier");
            JSONArray var2 = var0.getJSONArray("hints");
            String var3;
            if (var0.isNull("hintText")) {
               var3 = null;
            } else {
               var3 = var0.getString("hintText");
            }

            var0 = var0.getJSONObject("editingValue");
            String[] var4 = new String[var2.length()];

            for(int var5 = 0; var5 < var2.length(); ++var5) {
               var4[var5] = b(var2.getString(var5));
            }

            return new s.b.a(var1, var4, var3, s.e.a(var0));
         }

         private static String b(String var0) {
            int var1 = VERSION.SDK_INT;
            byte var2 = 26;
            if (var1 < 26) {
               return var0;
            } else {
               label195: {
                  var0.hashCode();
                  switch(var0.hashCode()) {
                  case -2058889126:
                     if (var0.equals("birthdayYear")) {
                        var2 = 0;
                        break label195;
                     }
                     break;
                  case -1917283616:
                     if (var0.equals("oneTimeCode")) {
                        var2 = 1;
                        break label195;
                     }
                     break;
                  case -1844815832:
                     if (var0.equals("creditCardExpirationMonth")) {
                        var2 = 2;
                        break label195;
                     }
                     break;
                  case -1825589953:
                     if (var0.equals("telephoneNumberNational")) {
                        var2 = 3;
                        break label195;
                     }
                     break;
                  case -1821235109:
                     if (var0.equals("newPassword")) {
                        var2 = 4;
                        break label195;
                     }
                     break;
                  case -1757573738:
                     if (var0.equals("creditCardSecurityCode")) {
                        var2 = 5;
                        break label195;
                     }
                     break;
                  case -1682373820:
                     if (var0.equals("creditCardExpirationDay")) {
                        var2 = 6;
                        break label195;
                     }
                     break;
                  case -1658955742:
                     if (var0.equals("fullStreetAddress")) {
                        var2 = 7;
                        break label195;
                     }
                     break;
                  case -1567118045:
                     if (var0.equals("telephoneNumberDevice")) {
                        var2 = 8;
                        break label195;
                     }
                     break;
                  case -1476752575:
                     if (var0.equals("countryName")) {
                        var2 = 9;
                        break label195;
                     }
                     break;
                  case -1413737489:
                     if (var0.equals("middleInitial")) {
                        var2 = 10;
                        break label195;
                     }
                     break;
                  case -1377792129:
                     if (var0.equals("addressCity")) {
                        var2 = 11;
                        break label195;
                     }
                     break;
                  case -1249512767:
                     if (var0.equals("gender")) {
                        var2 = 12;
                        break label195;
                     }
                     break;
                  case -1186060294:
                     if (var0.equals("postalAddressExtendedPostalCode")) {
                        var2 = 13;
                        break label195;
                     }
                     break;
                  case -1151034798:
                     if (var0.equals("creditCardNumber")) {
                        var2 = 14;
                        break label195;
                     }
                     break;
                  case -835992323:
                     if (var0.equals("namePrefix")) {
                        var2 = 15;
                        break label195;
                     }
                     break;
                  case -818219584:
                     if (var0.equals("middleName")) {
                        var2 = 16;
                        break label195;
                     }
                     break;
                  case -747304516:
                     if (var0.equals("nameSuffix")) {
                        var2 = 17;
                        break label195;
                     }
                     break;
                  case -613980922:
                     if (var0.equals("creditCardExpirationDate")) {
                        var2 = 18;
                        break label195;
                     }
                     break;
                  case -613352043:
                     if (var0.equals("creditCardExpirationYear")) {
                        var2 = 19;
                        break label195;
                     }
                     break;
                  case -549230602:
                     if (var0.equals("telephoneNumberCountryCode")) {
                        var2 = 20;
                        break label195;
                     }
                     break;
                  case -265713450:
                     if (var0.equals("username")) {
                        var2 = 21;
                        break label195;
                     }
                     break;
                  case 3373707:
                     if (var0.equals("name")) {
                        var2 = 22;
                        break label195;
                     }
                     break;
                  case 96619420:
                     if (var0.equals("email")) {
                        var2 = 23;
                        break label195;
                     }
                     break;
                  case 253202685:
                     if (var0.equals("addressState")) {
                        var2 = 24;
                        break label195;
                     }
                     break;
                  case 588174851:
                     if (var0.equals("birthdayMonth")) {
                        var2 = 25;
                        break label195;
                     }
                     break;
                  case 798554127:
                     if (var0.equals("familyName")) {
                        break label195;
                     }
                     break;
                  case 892233837:
                     if (var0.equals("telephoneNumber")) {
                        var2 = 27;
                        break label195;
                     }
                     break;
                  case 991032982:
                     if (var0.equals("newUsername")) {
                        var2 = 28;
                        break label195;
                     }
                     break;
                  case 1069376125:
                     if (var0.equals("birthday")) {
                        var2 = 29;
                        break label195;
                     }
                     break;
                  case 1216985755:
                     if (var0.equals("password")) {
                        var2 = 30;
                        break label195;
                     }
                     break;
                  case 1469046696:
                     if (var0.equals("givenName")) {
                        var2 = 31;
                        break label195;
                     }
                     break;
                  case 1662667945:
                     if (var0.equals("postalAddress")) {
                        var2 = 32;
                        break label195;
                     }
                     break;
                  case 1921869058:
                     if (var0.equals("postalAddressExtended")) {
                        var2 = 33;
                        break label195;
                     }
                     break;
                  case 2011152728:
                     if (var0.equals("postalCode")) {
                        var2 = 34;
                        break label195;
                     }
                     break;
                  case 2011773919:
                     if (var0.equals("birthdayDay")) {
                        var2 = 35;
                        break label195;
                     }
                  }

                  var2 = -1;
               }

               switch(var2) {
               case 0:
                  return "birthDateYear";
               case 1:
                  return "smsOTPCode";
               case 2:
                  return "creditCardExpirationMonth";
               case 3:
                  return "phoneNational";
               case 4:
                  return "newPassword";
               case 5:
                  return "creditCardSecurityCode";
               case 6:
                  return "creditCardExpirationDay";
               case 7:
                  return "streetAddress";
               case 8:
                  return "phoneNumberDevice";
               case 9:
                  return "addressCountry";
               case 10:
                  return "personMiddleInitial";
               case 11:
                  return "addressLocality";
               case 12:
                  return "gender";
               case 13:
                  return "extendedPostalCode";
               case 14:
                  return "creditCardNumber";
               case 15:
                  return "personNamePrefix";
               case 16:
                  return "personMiddleName";
               case 17:
                  return "personNameSuffix";
               case 18:
                  return "creditCardExpirationDate";
               case 19:
                  return "creditCardExpirationYear";
               case 20:
                  return "phoneCountryCode";
               case 21:
                  return "username";
               case 22:
                  return "personName";
               case 23:
                  return "emailAddress";
               case 24:
                  return "addressRegion";
               case 25:
                  return "birthDateMonth";
               case 26:
                  return "personFamilyName";
               case 27:
                  return "phoneNumber";
               case 28:
                  return "newUsername";
               case 29:
                  return "birthDateFull";
               case 30:
                  return "password";
               case 31:
                  return "personGivenName";
               case 32:
                  return "postalAddress";
               case 33:
                  return "extendedAddress";
               case 34:
                  return "postalCode";
               case 35:
                  return "birthDateDay";
               default:
                  return var0;
               }
            }
         }
      }
   }

   public static class c {
      public final s.g a;
      public final boolean b;
      public final boolean c;

      public c(s.g var1, boolean var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public static s.c a(JSONObject var0) {
         return new s.c(s.g.b(var0.getString("name")), var0.optBoolean("signed", false), var0.optBoolean("decimal", false));
      }
   }

   public static enum d {
      f("TextCapitalization.characters"),
      g("TextCapitalization.words"),
      h("TextCapitalization.sentences"),
      i("TextCapitalization.none");

      private final String e;

      private d(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static s.d[] a() {
         return new s.d[]{f, g, h, i};
      }

      static s.d b(String var0) {
         s.d[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            s.d var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such TextCapitalization: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }

   public static class e {
      public final String a;
      public final int b;
      public final int c;
      public final int d;
      public final int e;

      public e(String var1, int var2, int var3, int var4, int var5) {
         StringBuilder var6;
         if (var2 == -1 && var3 == -1 || var2 >= 0 && var3 >= 0) {
            if (var4 == -1 && var5 == -1 || var4 >= 0 && var4 <= var5) {
               if (var5 <= var1.length()) {
                  if (var2 <= var1.length()) {
                     if (var3 <= var1.length()) {
                        this.a = var1;
                        this.b = var2;
                        this.c = var3;
                        this.d = var4;
                        this.e = var5;
                     } else {
                        var6 = new StringBuilder();
                        var6.append("invalid selection end: ");
                        var6.append(String.valueOf(var3));
                        throw new IndexOutOfBoundsException(var6.toString());
                     }
                  } else {
                     var6 = new StringBuilder();
                     var6.append("invalid selection start: ");
                     var6.append(String.valueOf(var2));
                     throw new IndexOutOfBoundsException(var6.toString());
                  }
               } else {
                  var6 = new StringBuilder();
                  var6.append("invalid composing start: ");
                  var6.append(String.valueOf(var4));
                  throw new IndexOutOfBoundsException(var6.toString());
               }
            } else {
               var6 = new StringBuilder();
               var6.append("invalid composing range: (");
               var6.append(String.valueOf(var4));
               var6.append(", ");
               var6.append(String.valueOf(var5));
               var6.append(")");
               throw new IndexOutOfBoundsException(var6.toString());
            }
         } else {
            var6 = new StringBuilder();
            var6.append("invalid selection: (");
            var6.append(String.valueOf(var2));
            var6.append(", ");
            var6.append(String.valueOf(var3));
            var6.append(")");
            throw new IndexOutOfBoundsException(var6.toString());
         }
      }

      public static s.e a(JSONObject var0) {
         return new s.e(var0.getString("text"), var0.getInt("selectionBase"), var0.getInt("selectionExtent"), var0.getInt("composingBase"), var0.getInt("composingExtent"));
      }

      public boolean b() {
         int var1 = this.d;
         boolean var2;
         if (var1 >= 0 && this.e > var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public boolean c() {
         boolean var1;
         if (this.b >= 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   public interface f {
      void a(String var1, Bundle var2);

      void b();

      void c();

      void d(int var1, boolean var2);

      void e(double var1, double var3, double[] var5);

      void f(int var1, s.b var2);

      void g();

      void h(s.e var1);

      void i(boolean var1);

      void j();
   }

   public static enum g {
      f("TextInputType.text"),
      g("TextInputType.datetime"),
      h("TextInputType.name"),
      i("TextInputType.address"),
      j("TextInputType.number"),
      k("TextInputType.phone"),
      l("TextInputType.multiline"),
      m("TextInputType.emailAddress"),
      n("TextInputType.url"),
      o("TextInputType.visiblePassword"),
      p("TextInputType.none");

      private final String e;

      private g(String var3) {
         this.e = var3;
      }

      // $FF: synthetic method
      private static s.g[] a() {
         return new s.g[]{f, g, h, i, j, k, l, m, n, o, p};
      }

      static s.g b(String var0) {
         s.g[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            s.g var4 = var1[var3];
            if (var4.e.equals(var0)) {
               return var4;
            }
         }

         StringBuilder var5 = new StringBuilder();
         var5.append("No such TextInputType: ");
         var5.append(var0);
         throw new NoSuchFieldException(var5.toString());
      }
   }
}
