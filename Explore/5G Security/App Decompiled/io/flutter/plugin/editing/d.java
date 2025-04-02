package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.text.Layout.Alignment;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import io.flutter.embedding.engine.FlutterJNI;
import j0.s;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class d extends BaseInputConnection implements e.b {
   private final View a;
   private final int b;
   private final s c;
   private final e d;
   private final EditorInfo e;
   private ExtractedTextRequest f;
   private boolean g;
   private Builder h;
   private ExtractedText i;
   private InputMethodManager j;
   private final Layout k;
   private io.flutter.plugin.editing.a l;
   private final d.a m;
   private int n;

   public d(View var1, int var2, s var3, d.a var4, e var5, EditorInfo var6) {
      this(var1, var2, var3, var4, var5, var6, new FlutterJNI());
   }

   public d(View var1, int var2, s var3, d.a var4, e var5, EditorInfo var6, FlutterJNI var7) {
      super(var1, true);
      this.g = false;
      this.i = new ExtractedText();
      this.n = 0;
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var5;
      var5.a(this);
      this.e = var6;
      this.m = var4;
      this.l = new io.flutter.plugin.editing.a(var7);
      this.k = new DynamicLayout(var5, new TextPaint(), Integer.MAX_VALUE, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      this.j = (InputMethodManager)var1.getContext().getSystemService("input_method");
   }

   private boolean b(int var1) {
      if (var1 == 16908319) {
         this.setSelection(0, this.d.length());
         return true;
      } else {
         int var2;
         int var3;
         CharSequence var5;
         if (var1 == 16908320) {
            var2 = Selection.getSelectionStart(this.d);
            var3 = Selection.getSelectionEnd(this.d);
            if (var2 != var3) {
               var1 = Math.min(var2, var3);
               var3 = Math.max(var2, var3);
               var5 = this.d.subSequence(var1, var3);
               ((ClipboardManager)this.a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", var5));
               this.d.delete(var1, var3);
               this.setSelection(var1, var1);
            }

            return true;
         } else if (var1 == 16908321) {
            var1 = Selection.getSelectionStart(this.d);
            var3 = Selection.getSelectionEnd(this.d);
            if (var1 != var3) {
               var5 = this.d.subSequence(Math.min(var1, var3), Math.max(var1, var3));
               ((ClipboardManager)this.a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", var5));
            }

            return true;
         } else if (var1 == 16908322) {
            ClipData var4 = ((ClipboardManager)this.a.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (var4 != null) {
               var5 = var4.getItemAt(0).coerceToText(this.a.getContext());
               var3 = Math.max(0, Selection.getSelectionStart(this.d));
               var2 = Math.max(0, Selection.getSelectionEnd(this.d));
               var1 = Math.min(var3, var2);
               var3 = Math.max(var3, var2);
               if (var1 != var3) {
                  this.d.delete(var1, var3);
               }

               this.d.insert(var1, var5);
               var1 += var5.length();
               this.setSelection(var1, var1);
            }

            return true;
         } else {
            return false;
         }
      }
   }

   private CursorAnchorInfo c() {
      Builder var1 = this.h;
      if (var1 == null) {
         this.h = new Builder();
      } else {
         var1.reset();
      }

      this.h.setSelectionRange(this.d.i(), this.d.h());
      int var2 = this.d.g();
      int var3 = this.d.f();
      if (var2 >= 0 && var3 > var2) {
         this.h.setComposingText(var2, this.d.toString().subSequence(var2, var3));
      } else {
         this.h.setComposingText(-1, "");
      }

      return this.h.build();
   }

   private ExtractedText d(ExtractedTextRequest var1) {
      ExtractedText var2 = this.i;
      var2.startOffset = 0;
      var2.partialStartOffset = -1;
      var2.partialEndOffset = -1;
      var2.selectionStart = this.d.i();
      this.i.selectionEnd = this.d.h();
      var2 = this.i;
      Object var3;
      if (var1 != null && (var1.flags & 1) != 0) {
         var3 = this.d;
      } else {
         var3 = this.d.toString();
      }

      var2.text = (CharSequence)var3;
      return this.i;
   }

   private boolean e(boolean var1, boolean var2) {
      int var3 = Selection.getSelectionStart(this.d);
      int var4 = Selection.getSelectionEnd(this.d);
      boolean var5 = false;
      if (var3 >= 0 && var4 >= 0) {
         int var6;
         if (var1) {
            var6 = Math.max(this.l.b(this.d, var4), 0);
         } else {
            var6 = Math.min(this.l.a(this.d, var4), this.d.length());
         }

         boolean var7 = var5;
         if (var3 == var4) {
            var7 = var5;
            if (!var2) {
               var7 = true;
            }
         }

         if (var7) {
            this.setSelection(var6, var6);
         } else {
            this.setSelection(var3, var6);
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean g(boolean var1, boolean var2) {
      int var3 = Selection.getSelectionStart(this.d);
      int var4 = Selection.getSelectionEnd(this.d);
      boolean var5 = false;
      if (var3 >= 0 && var4 >= 0) {
         boolean var6 = var5;
         if (var3 == var4) {
            var6 = var5;
            if (!var2) {
               var6 = true;
            }
         }

         this.beginBatchEdit();
         if (var6) {
            if (var1) {
               Selection.moveUp(this.d, this.k);
            } else {
               Selection.moveDown(this.d, this.k);
            }

            int var7 = Selection.getSelectionStart(this.d);
            this.setSelection(var7, var7);
         } else {
            if (var1) {
               Selection.extendUp(this.d, this.k);
            } else {
               Selection.extendDown(this.d, this.k);
            }

            this.setSelection(Selection.getSelectionStart(this.d), Selection.getSelectionEnd(this.d));
         }

         this.endBatchEdit();
         return true;
      } else {
         return false;
      }
   }

   private byte[] h(InputStream var1, int var2) {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      byte[] var4 = new byte[var2];

      while(true) {
         try {
            var2 = var1.read(var4);
         } catch (IOException var6) {
            var2 = -1;
         }

         if (var2 == -1) {
            return var3.toByteArray();
         }

         var3.write(var4, 0, var2);
      }
   }

   public void a(boolean var1, boolean var2, boolean var3) {
      this.j.updateSelection(this.a, this.d.i(), this.d.h(), this.d.g(), this.d.f());
      ExtractedTextRequest var4 = this.f;
      if (var4 != null) {
         this.j.updateExtractedText(this.a, var4.token, this.d(var4));
      }

      if (this.g) {
         CursorAnchorInfo var5 = this.c();
         this.j.updateCursorAnchorInfo(this.a, var5);
      }

   }

   public boolean beginBatchEdit() {
      this.d.b();
      ++this.n;
      return super.beginBatchEdit();
   }

   public boolean clearMetaKeyStates(int var1) {
      return super.clearMetaKeyStates(var1);
   }

   public void closeConnection() {
      super.closeConnection();
      this.d.l(this);

      while(this.n > 0) {
         this.endBatchEdit();
         --this.n;
      }

   }

   public boolean commitContent(InputContentInfo var1, int var2, Bundle var3) {
      if (VERSION.SDK_INT >= 25 && (var2 & 1) != 0) {
         try {
            var1.requestPermission();
         } catch (Exception var8) {
            return false;
         }

         if (var1.getDescription().getMimeTypeCount() > 0) {
            var1.requestPermission();
            Uri var4 = var1.getContentUri();
            String var9 = var1.getDescription().getMimeType(0);
            Context var5 = this.a.getContext();
            if (var4 != null) {
               InputStream var10;
               try {
                  var10 = var5.getContentResolver().openInputStream(var4);
               } catch (FileNotFoundException var7) {
                  var1.releasePermission();
                  return false;
               }

               if (var10 != null) {
                  byte[] var11 = this.h(var10, 65536);
                  HashMap var6 = new HashMap();
                  var6.put("mimeType", var9);
                  var6.put("data", var11);
                  var6.put("uri", var4.toString());
                  this.c.b(this.b, var6);
                  var1.releasePermission();
                  return true;
               }
            }

            var1.releasePermission();
         }
      }

      return false;
   }

   public boolean commitText(CharSequence var1, int var2) {
      return super.commitText(var1, var2);
   }

   public boolean deleteSurroundingText(int var1, int var2) {
      return this.d.i() == -1 ? true : super.deleteSurroundingText(var1, var2);
   }

   public boolean deleteSurroundingTextInCodePoints(int var1, int var2) {
      return super.deleteSurroundingTextInCodePoints(var1, var2);
   }

   public boolean endBatchEdit() {
      boolean var1 = super.endBatchEdit();
      --this.n;
      this.d.d();
      return var1;
   }

   public boolean f(KeyEvent var1) {
      if (var1.getAction() == 0) {
         if (var1.getKeyCode() == 21) {
            return this.e(true, var1.isShiftPressed());
         }

         if (var1.getKeyCode() == 22) {
            return this.e(false, var1.isShiftPressed());
         }

         if (var1.getKeyCode() == 19) {
            return this.g(true, var1.isShiftPressed());
         }

         if (var1.getKeyCode() == 20) {
            return this.g(false, var1.isShiftPressed());
         }

         if (var1.getKeyCode() == 66 || var1.getKeyCode() == 160) {
            EditorInfo var2 = this.e;
            if ((131072 & var2.inputType) == 0) {
               this.performEditorAction(var2.imeOptions & 255);
               return true;
            }
         }

         int var3 = Selection.getSelectionStart(this.d);
         int var4 = Selection.getSelectionEnd(this.d);
         int var5 = var1.getUnicodeChar();
         if (var3 >= 0 && var4 >= 0 && var5 != 0) {
            int var6 = Math.min(var3, var4);
            var4 = Math.max(var3, var4);
            this.beginBatchEdit();
            if (var6 != var4) {
               this.d.delete(var6, var4);
            }

            this.d.insert(var6, String.valueOf((char)var5));
            ++var6;
            this.setSelection(var6, var6);
            this.endBatchEdit();
            return true;
         }
      }

      return false;
   }

   public boolean finishComposingText() {
      return super.finishComposingText();
   }

   public Editable getEditable() {
      return this.d;
   }

   public ExtractedText getExtractedText(ExtractedTextRequest var1, int var2) {
      boolean var3 = true;
      boolean var6;
      if ((var2 & 1) != 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      if (this.f != null) {
         var3 = false;
      }

      if (var6 == var3) {
         StringBuilder var4 = new StringBuilder();
         var4.append("The input method toggled text monitoring ");
         String var5;
         if (var6) {
            var5 = "on";
         } else {
            var5 = "off";
         }

         var4.append(var5);
         y.b.a("InputConnectionAdaptor", var4.toString());
      }

      ExtractedTextRequest var7;
      if (var6) {
         var7 = var1;
      } else {
         var7 = null;
      }

      this.f = var7;
      return this.d(var1);
   }

   public boolean performContextMenuAction(int var1) {
      this.beginBatchEdit();
      boolean var2 = this.b(var1);
      this.endBatchEdit();
      return var2;
   }

   public boolean performEditorAction(int var1) {
      if (var1 != 0) {
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  if (var1 != 4) {
                     if (var1 != 5) {
                        if (var1 != 7) {
                           this.c.e(this.b);
                        } else {
                           this.c.j(this.b);
                        }
                     } else {
                        this.c.h(this.b);
                     }
                  } else {
                     this.c.m(this.b);
                  }
               } else {
                  this.c.l(this.b);
               }
            } else {
               this.c.f(this.b);
            }
         } else {
            this.c.g(this.b);
         }
      } else {
         this.c.o(this.b);
      }

      return true;
   }

   public boolean performPrivateCommand(String var1, Bundle var2) {
      this.c.i(this.b, var1, var2);
      return true;
   }

   public boolean requestCursorUpdates(int var1) {
      if ((var1 & 1) != 0) {
         this.j.updateCursorAnchorInfo(this.a, this.c());
      }

      boolean var2;
      if ((var1 & 2) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2 != this.g) {
         StringBuilder var3 = new StringBuilder();
         var3.append("The input method toggled cursor monitoring ");
         String var4;
         if (var2) {
            var4 = "on";
         } else {
            var4 = "off";
         }

         var3.append(var4);
         y.b.a("InputConnectionAdaptor", var3.toString());
      }

      this.g = var2;
      return true;
   }

   public boolean sendKeyEvent(KeyEvent var1) {
      return this.m.b(var1);
   }

   public boolean setComposingRegion(int var1, int var2) {
      return super.setComposingRegion(var1, var2);
   }

   public boolean setComposingText(CharSequence var1, int var2) {
      this.beginBatchEdit();
      boolean var3;
      if (var1.length() == 0) {
         var3 = super.commitText(var1, var2);
      } else {
         var3 = super.setComposingText(var1, var2);
      }

      this.endBatchEdit();
      return var3;
   }

   public boolean setSelection(int var1, int var2) {
      this.beginBatchEdit();
      boolean var3 = super.setSelection(var1, var2);
      this.endBatchEdit();
      return var3;
   }

   public interface a {
      boolean b(KeyEvent var1);
   }
}
