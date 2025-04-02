package io.flutter.embedding.engine;

import android.content.Intent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g {
   private Set<String> a;

   public g(List<String> var1) {
      this.a = new HashSet(var1);
   }

   public static g a(Intent var0) {
      ArrayList var1 = new ArrayList();
      if (var0.getBooleanExtra("trace-startup", false)) {
         var1.add("--trace-startup");
      }

      if (var0.getBooleanExtra("start-paused", false)) {
         var1.add("--start-paused");
      }

      StringBuilder var3;
      label87: {
         int var2 = var0.getIntExtra("vm-service-port", 0);
         if (var2 > 0) {
            var3 = new StringBuilder();
         } else {
            var2 = var0.getIntExtra("observatory-port", 0);
            if (var2 <= 0) {
               break label87;
            }

            var3 = new StringBuilder();
         }

         var3.append("--vm-service-port=");
         var3.append(Integer.toString(var2));
         var1.add(var3.toString());
      }

      if (var0.getBooleanExtra("disable-service-auth-codes", false)) {
         var1.add("--disable-service-auth-codes");
      }

      if (var0.getBooleanExtra("endless-trace-buffer", false)) {
         var1.add("--endless-trace-buffer");
      }

      if (var0.getBooleanExtra("use-test-fonts", false)) {
         var1.add("--use-test-fonts");
      }

      if (var0.getBooleanExtra("enable-dart-profiling", false)) {
         var1.add("--enable-dart-profiling");
      }

      if (var0.getBooleanExtra("enable-software-rendering", false)) {
         var1.add("--enable-software-rendering");
      }

      if (var0.getBooleanExtra("skia-deterministic-rendering", false)) {
         var1.add("--skia-deterministic-rendering");
      }

      if (var0.getBooleanExtra("trace-skia", false)) {
         var1.add("--trace-skia");
      }

      String var5 = var0.getStringExtra("trace-skia-allowlist");
      if (var5 != null) {
         StringBuilder var4 = new StringBuilder();
         var4.append("--trace-skia-allowlist=");
         var4.append(var5);
         var1.add(var4.toString());
      }

      if (var0.getBooleanExtra("trace-systrace", false)) {
         var1.add("--trace-systrace");
      }

      if (var0.hasExtra("trace-to-file")) {
         var3 = new StringBuilder();
         var3.append("--trace-to-file=");
         var3.append(var0.getStringExtra("trace-to-file"));
         var1.add(var3.toString());
      }

      if (var0.getBooleanExtra("enable-impeller", false)) {
         var1.add("--enable-impeller");
      }

      if (var0.getBooleanExtra("enable-vulkan-validation", false)) {
         var1.add("--enable-vulkan-validation");
      }

      if (var0.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
         var1.add("--dump-skp-on-shader-compilation");
      }

      if (var0.getBooleanExtra("cache-sksl", false)) {
         var1.add("--cache-sksl");
      }

      if (var0.getBooleanExtra("purge-persistent-cache", false)) {
         var1.add("--purge-persistent-cache");
      }

      if (var0.getBooleanExtra("verbose-logging", false)) {
         var1.add("--verbose-logging");
      }

      if (var0.hasExtra("dart-flags")) {
         var3 = new StringBuilder();
         var3.append("--dart-flags=");
         var3.append(var0.getStringExtra("dart-flags"));
         var1.add(var3.toString());
      }

      return new g(var1);
   }

   public String[] b() {
      String[] var1 = new String[this.a.size()];
      return (String[])this.a.toArray(var1);
   }
}
