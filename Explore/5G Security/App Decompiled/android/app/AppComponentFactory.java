package android.app;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

// $FF: synthetic class
public class AppComponentFactory {
   static {
      throw new NoClassDefFoundError();
   }

   // $FF: synthetic method
   @NonNull
   public native Activity instantiateActivity(@NonNull ClassLoader var1, @NonNull String var2, @Nullable Intent var3) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

   // $FF: synthetic method
   @NonNull
   public native Application instantiateApplication(@NonNull ClassLoader var1, @NonNull String var2) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

   // $FF: synthetic method
   @NonNull
   public native ContentProvider instantiateProvider(@NonNull ClassLoader var1, @NonNull String var2) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

   // $FF: synthetic method
   @NonNull
   public native BroadcastReceiver instantiateReceiver(@NonNull ClassLoader var1, @NonNull String var2, @Nullable Intent var3) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

   // $FF: synthetic method
   @NonNull
   public native Service instantiateService(@NonNull ClassLoader var1, @NonNull String var2, @Nullable Intent var3) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
