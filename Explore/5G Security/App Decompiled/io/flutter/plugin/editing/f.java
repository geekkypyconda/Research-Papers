package io.flutter.plugin.editing;

import android.os.Bundle;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener;
import j0.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class f implements q.b, SpellCheckerSessionListener {
   private final q a;
   private final TextServicesManager b;
   private SpellCheckerSession c;
   k0.i.d d;

   public f(TextServicesManager var1, q var2) {
      this.b = var1;
      this.a = var2;
      var2.b(this);
   }

   public void a(String var1, String var2, k0.i.d var3) {
      if (this.d != null) {
         var3.a("error", "Previous spell check request still pending.", (Object)null);
      } else {
         this.d = var3;
         this.c(var1, var2);
      }
   }

   public void b() {
      this.a.b((q.b)null);
      SpellCheckerSession var1 = this.c;
      if (var1 != null) {
         var1.close();
      }

   }

   public void c(String var1, String var2) {
      Locale var3 = l0.c.b(var1);
      if (this.c == null) {
         this.c = this.b.newSpellCheckerSession((Bundle)null, var3, this, true);
      }

      TextInfo var4 = new TextInfo(var2);
      this.c.getSentenceSuggestions(new TextInfo[]{var4}, 5);
   }

   public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] var1) {
      k0.i.d var2;
      ArrayList var11;
      if (var1.length == 0) {
         var2 = this.d;
         var11 = new ArrayList();
      } else {
         ArrayList var13 = new ArrayList();
         SentenceSuggestionsInfo var12 = var1[0];
         if (var12 == null) {
            var2 = this.d;
            var11 = new ArrayList();
         } else {
            for(int var3 = 0; var3 < var12.getSuggestionsCount(); ++var3) {
               SuggestionsInfo var4 = var12.getSuggestionsInfoAt(var3);
               int var5 = var4.getSuggestionsCount();
               if (var5 > 0) {
                  HashMap var6 = new HashMap();
                  int var7 = var12.getOffsetAt(var3);
                  int var8 = var12.getLengthAt(var3);
                  var6.put("startIndex", var7);
                  var6.put("endIndex", var8 + var7);
                  ArrayList var9 = new ArrayList();
                  var7 = 0;

                  boolean var15;
                  for(var15 = false; var7 < var5; ++var7) {
                     String var10 = var4.getSuggestionAt(var7);
                     if (!var10.equals("")) {
                        var9.add(var10);
                        var15 = true;
                     }
                  }

                  if (var15) {
                     var6.put("suggestions", var9);
                     var13.add(var6);
                  }
               }
            }

            k0.i.d var14 = this.d;
            var11 = var13;
            var2 = var14;
         }
      }

      var2.b(var11);
      this.d = null;
   }

   public void onGetSuggestions(SuggestionsInfo[] var1) {
   }
}
