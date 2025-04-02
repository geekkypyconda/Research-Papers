package v;

import a1.k;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.inputmethodservice.InputMethodService;

public final class c {
   public static final c a = new c();

   private c() {
   }

   public final Context a(Context var1) {
      k.e(var1, "context");
      Context var2 = var1;

      while(var2 instanceof ContextWrapper) {
         if (var2 instanceof Activity) {
            return var2;
         }

         if (var2 instanceof InputMethodService) {
            return var2;
         }

         ContextWrapper var3 = (ContextWrapper)var2;
         if (var3.getBaseContext() == null) {
            return var2;
         }

         var2 = var3.getBaseContext();
         k.d(var2, "iterator.baseContext");
      }

      StringBuilder var4 = new StringBuilder();
      var4.append("Context ");
      var4.append(var1);
      var4.append(" is not a UiContext");
      throw new IllegalArgumentException(var4.toString());
   }
}
