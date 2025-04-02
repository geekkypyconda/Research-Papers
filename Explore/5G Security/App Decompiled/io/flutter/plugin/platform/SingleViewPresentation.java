package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

class SingleViewPresentation extends Presentation {
   private static final String TAG = "PlatformViewsController";
   private final io.flutter.plugin.platform.a accessibilityEventsDelegate;
   private FrameLayout container;
   private final OnFocusChangeListener focusChangeListener;
   private final Context outerContext;
   private SingleViewPresentation.a rootView;
   private boolean startFocused = false;
   private final SingleViewPresentation.d state;
   private int viewId;

   public SingleViewPresentation(Context var1, Display var2, io.flutter.plugin.platform.a var3, SingleViewPresentation.d var4, OnFocusChangeListener var5, boolean var6) {
      super(new SingleViewPresentation.b(var1), var2);
      this.accessibilityEventsDelegate = var3;
      this.state = var4;
      this.focusChangeListener = var5;
      this.outerContext = var1;
      this.getWindow().setFlags(8, 8);
      this.startFocused = var6;
   }

   public SingleViewPresentation(Context var1, Display var2, i var3, io.flutter.plugin.platform.a var4, int var5, OnFocusChangeListener var6) {
      super(new SingleViewPresentation.b(var1), var2);
      this.accessibilityEventsDelegate = var4;
      this.viewId = var5;
      this.focusChangeListener = var6;
      this.outerContext = var1;
      SingleViewPresentation.d var7 = new SingleViewPresentation.d();
      this.state = var7;
      var7.a = var3;
      this.getWindow().setFlags(8, 8);
      this.getWindow().setType(2030);
   }

   public SingleViewPresentation.d detachState() {
      FrameLayout var1 = this.container;
      if (var1 != null) {
         var1.removeAllViews();
      }

      SingleViewPresentation.a var2 = this.rootView;
      if (var2 != null) {
         var2.removeAllViews();
      }

      return this.state;
   }

   public i getView() {
      return this.state.a;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      if (this.state.c == null) {
         this.state.c = new x(this.getContext());
      }

      if (this.state.b == null) {
         WindowManager var3 = (WindowManager)this.getContext().getSystemService("window");
         SingleViewPresentation.d var2 = this.state;
         var2.b = new h0(var3, var2.c);
      }

      this.container = new FrameLayout(this.getContext());
      SingleViewPresentation.c var5 = new SingleViewPresentation.c(this.getContext(), this.state.b, this.outerContext);
      View var4 = this.state.a.f();
      if (var4.getContext() instanceof MutableContextWrapper) {
         ((MutableContextWrapper)var4.getContext()).setBaseContext(var5);
      } else {
         StringBuilder var6 = new StringBuilder();
         var6.append("Unexpected platform view context for view ID ");
         var6.append(this.viewId);
         var6.append("; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
         y.b.g("PlatformViewsController", var6.toString());
      }

      this.container.addView(var4);
      SingleViewPresentation.a var7 = new SingleViewPresentation.a(this.getContext(), this.accessibilityEventsDelegate, var4);
      this.rootView = var7;
      var7.addView(this.container);
      this.rootView.addView(this.state.c);
      var4.setOnFocusChangeListener(this.focusChangeListener);
      this.rootView.setFocusableInTouchMode(true);
      if (this.startFocused) {
         var4.requestFocus();
      } else {
         this.rootView.requestFocus();
      }

      this.setContentView(this.rootView);
   }

   private static class a extends FrameLayout {
      private final io.flutter.plugin.platform.a a;
      private final View b;

      public a(Context var1, io.flutter.plugin.platform.a var2, View var3) {
         super(var1);
         this.a = var2;
         this.b = var3;
      }

      public boolean requestSendAccessibilityEvent(View var1, AccessibilityEvent var2) {
         return this.a.b(this.b, var1, var2);
      }
   }

   private static class b extends ContextWrapper {
      private final InputMethodManager a;

      b(Context var1) {
         this(var1, (InputMethodManager)null);
      }

      private b(Context var1, InputMethodManager var2) {
         super(var1);
         if (var2 == null) {
            var2 = (InputMethodManager)var1.getSystemService("input_method");
         }

         this.a = var2;
      }

      public Context createDisplayContext(Display var1) {
         return new SingleViewPresentation.b(super.createDisplayContext(var1), this.a);
      }

      public Object getSystemService(String var1) {
         return "input_method".equals(var1) ? this.a : super.getSystemService(var1);
      }
   }

   private static class c extends ContextWrapper {
      private final h0 a;
      private WindowManager b;
      private final Context c;

      c(Context var1, h0 var2, Context var3) {
         super(var1);
         this.a = var2;
         this.c = var3;
      }

      private WindowManager a() {
         if (this.b == null) {
            this.b = this.a;
         }

         return this.b;
      }

      private boolean b() {
         StackTraceElement[] var1 = Thread.currentThread().getStackTrace();

         for(int var2 = 0; var2 < var1.length && var2 < 11; ++var2) {
            if (var1[var2].getClassName().equals(AlertDialog.class.getCanonicalName()) && var1[var2].getMethodName().equals("<init>")) {
               return true;
            }
         }

         return false;
      }

      public Object getSystemService(String var1) {
         if ("window".equals(var1)) {
            return this.b() ? this.c.getSystemService(var1) : this.a();
         } else {
            return super.getSystemService(var1);
         }
      }
   }

   static class d {
      private i a;
      private h0 b;
      private x c;
   }
}
