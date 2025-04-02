package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Path.Direction;
import java.util.ArrayList;
import java.util.List;

public class FlutterMutatorsStack {
   private List<Path> finalClippingPaths = new ArrayList();
   private Matrix finalMatrix = new Matrix();
   private List<FlutterMutatorsStack.a> mutators = new ArrayList();

   public List<Path> getFinalClippingPaths() {
      return this.finalClippingPaths;
   }

   public Matrix getFinalMatrix() {
      return this.finalMatrix;
   }

   public List<FlutterMutatorsStack.a> getMutators() {
      return this.mutators;
   }

   public void pushClipRRect(int var1, int var2, int var3, int var4, float[] var5) {
      Rect var6 = new Rect(var1, var2, var3, var4);
      FlutterMutatorsStack.a var7 = new FlutterMutatorsStack.a(var6, var5);
      this.mutators.add(var7);
      Path var8 = new Path();
      var8.addRoundRect(new RectF(var6), var5, Direction.CCW);
      var8.transform(this.finalMatrix);
      this.finalClippingPaths.add(var8);
   }

   public void pushClipRect(int var1, int var2, int var3, int var4) {
      Rect var5 = new Rect(var1, var2, var3, var4);
      FlutterMutatorsStack.a var6 = new FlutterMutatorsStack.a(var5);
      this.mutators.add(var6);
      Path var7 = new Path();
      var7.addRect(new RectF(var5), Direction.CCW);
      var7.transform(this.finalMatrix);
      this.finalClippingPaths.add(var7);
   }

   public void pushTransform(float[] var1) {
      Matrix var2 = new Matrix();
      var2.setValues(var1);
      FlutterMutatorsStack.a var3 = new FlutterMutatorsStack.a(var2);
      this.mutators.add(var3);
      this.finalMatrix.preConcat(var3.a());
   }

   public class a {
      private Matrix a;
      private Rect b;
      private float[] c;
      private FlutterMutatorsStack.b d;

      public a(Matrix var2) {
         this.d = FlutterMutatorsStack.b.h;
         this.a = var2;
      }

      public a(Rect var2) {
         this.d = FlutterMutatorsStack.b.e;
         this.b = var2;
      }

      public a(Rect var2, float[] var3) {
         this.d = FlutterMutatorsStack.b.f;
         this.b = var2;
         this.c = var3;
      }

      public Matrix a() {
         return this.a;
      }
   }

   public static enum b {
      e,
      f,
      g,
      h,
      i;

      // $FF: synthetic method
      private static FlutterMutatorsStack.b[] a() {
         return new FlutterMutatorsStack.b[]{e, f, g, h, i};
      }
   }
}
