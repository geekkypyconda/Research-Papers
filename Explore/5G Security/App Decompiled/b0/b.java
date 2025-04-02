package b0;

public final class b {
   public final String a;
   public final String b;
   public final String c;
   public final String d;
   public final String e;
   public final String f;
   final boolean g;

   public b(String var1, String var2, String var3, String var4, String var5, String var6, boolean var7) {
      String var8 = var1;
      if (var1 == null) {
         var8 = "libapp.so";
      }

      this.a = var8;
      var1 = var2;
      if (var2 == null) {
         var1 = "vm_snapshot_data";
      }

      this.b = var1;
      var1 = var3;
      if (var3 == null) {
         var1 = "isolate_snapshot_data";
      }

      this.c = var1;
      var1 = var4;
      if (var4 == null) {
         var1 = "flutter_assets";
      }

      this.d = var1;
      this.f = var6;
      var1 = var5;
      if (var5 == null) {
         var1 = "";
      }

      this.e = var1;
      this.g = var7;
   }
}
