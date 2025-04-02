package m0;

import android.view.PointerIcon;
import j0.i;
import java.util.HashMap;

public class b {
   private static HashMap<String, Integer> c;
   private final b.c a;
   private final i b;

   public b(b.c var1, i var2) {
      this.a = var1;
      this.b = var2;
      var2.b(new i.b() {
         public void a(String var1) {
            b.this.a.setPointerIcon(b.this.d(var1));
         }
      });
   }

   private PointerIcon d(String var1) {
      if (c == null) {
         c = new HashMap<String, Integer>() {
            {
               this.put("alias", 1010);
               Integer var2 = 1013;
               this.put("allScroll", var2);
               this.put("basic", 1000);
               this.put("cell", 1006);
               this.put("click", 1002);
               this.put("contextMenu", 1001);
               this.put("copy", 1011);
               Integer var5 = 1012;
               this.put("forbidden", var5);
               this.put("grab", 1020);
               this.put("grabbing", 1021);
               this.put("help", 1003);
               this.put("move", var2);
               this.put("none", 0);
               this.put("noDrop", var5);
               this.put("precise", 1007);
               this.put("text", 1008);
               var2 = 1014;
               this.put("resizeColumn", var2);
               Integer var3 = 1015;
               this.put("resizeDown", var3);
               var5 = 1016;
               this.put("resizeUpLeft", var5);
               Integer var4 = 1017;
               this.put("resizeDownRight", var4);
               this.put("resizeLeft", var2);
               this.put("resizeLeftRight", var2);
               this.put("resizeRight", var2);
               this.put("resizeRow", var3);
               this.put("resizeUp", var3);
               this.put("resizeUpDown", var3);
               this.put("resizeUpLeft", var4);
               this.put("resizeUpRight", var5);
               this.put("resizeUpLeftDownRight", var4);
               this.put("resizeUpRightDownLeft", var5);
               this.put("verticalText", 1009);
               this.put("wait", 1004);
               this.put("zoomIn", 1018);
               this.put("zoomOut", 1019);
            }
         };
      }

      int var2 = (Integer)m0.a.a(c, var1, 1000);
      return this.a.c(var2);
   }

   public void c() {
      this.b.b((i.b)null);
   }

   public interface c {
      PointerIcon c(int var1);

      void setPointerIcon(PointerIcon var1);
   }
}
