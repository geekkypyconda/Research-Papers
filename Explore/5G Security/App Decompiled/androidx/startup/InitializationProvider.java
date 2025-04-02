package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import k.c;

public class InitializationProvider extends ContentProvider {
   public final int delete(Uri var1, String var2, String[] var3) {
      throw new IllegalStateException("Not allowed.");
   }

   public final String getType(Uri var1) {
      throw new IllegalStateException("Not allowed.");
   }

   public final Uri insert(Uri var1, ContentValues var2) {
      throw new IllegalStateException("Not allowed.");
   }

   public final boolean onCreate() {
      Context var1 = this.getContext();
      if (var1 != null) {
         if (var1.getApplicationContext() != null) {
            a.d(var1).a();
         }

         return true;
      } else {
         throw new c("Context cannot be null");
      }
   }

   public final Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      throw new IllegalStateException("Not allowed.");
   }

   public final int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      throw new IllegalStateException("Not allowed.");
   }
}
