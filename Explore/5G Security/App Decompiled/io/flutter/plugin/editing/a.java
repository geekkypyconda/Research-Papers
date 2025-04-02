package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

class a {
   private final FlutterJNI a;

   public a(FlutterJNI var1) {
      this.a = var1;
   }

   public int a(CharSequence var1, int var2) {
      int var3 = var1.length();
      int var4 = var3 - 1;
      if (var2 >= var4) {
         return var3;
      } else {
         int var5 = Character.codePointAt(var1, var2);
         int var6 = Character.charCount(var5);
         int var7 = var2 + var6;
         int var8 = 0;
         if (var7 == 0) {
            return 0;
         } else if (var5 == 10) {
            var8 = var6;
            if (Character.codePointAt(var1, var7) == 13) {
               var8 = var6 + 1;
            }

            return var2 + var8;
         } else if (this.g(var5)) {
            if (var7 < var4 && this.g(Character.codePointAt(var1, var7))) {
               for(var5 = var2; var5 > 0 && this.g(Character.codePointBefore(var1, var2)); ++var8) {
                  var5 -= Character.charCount(Character.codePointBefore(var1, var2));
               }

               var5 = var6;
               if (var8 % 2 == 0) {
                  var5 = var6 + 2;
               }

               return var2 + var5;
            } else {
               return var7;
            }
         } else {
            var8 = var6;
            if (this.f(var5)) {
               var8 = var6 + Character.charCount(var5);
            }

            if (var5 == 8419) {
               var5 = Character.codePointBefore(var1, var7);
               var6 = var7 + Character.charCount(var5);
               if (var6 < var3 && this.i(var5)) {
                  var7 = Character.codePointAt(var1, var6);
                  var6 = var8;
                  if (this.f(var7)) {
                     var6 = var8 + Character.charCount(var5) + Character.charCount(var7);
                  }
               } else {
                  var6 = var8;
                  if (this.f(var5)) {
                     var6 = var8 + Character.charCount(var5);
                  }
               }

               return var2 + var6;
            } else {
               var6 = var8;
               if (this.c(var5)) {
                  boolean var9 = false;
                  int var10 = 0;
                  int var11 = var8;
                  var6 = var5;

                  while(true) {
                     var8 = var11;
                     boolean var12 = var9;
                     if (var9) {
                        var8 = var11 + Character.charCount(var6) + var10 + 1;
                        var12 = false;
                     }

                     if (this.d(var6)) {
                        var6 = var8;
                        break;
                     }

                     label121: {
                        var5 = var6;
                        var6 = var7;
                        var9 = var12;
                        if (var7 < var3) {
                           var10 = Character.codePointAt(var1, var7);
                           var7 += Character.charCount(var10);
                           if (var10 == 8419) {
                              var5 = Character.codePointBefore(var1, var7);
                              var6 = var7 + Character.charCount(var5);
                              if (var6 < var3 && this.i(var5)) {
                                 var7 = Character.codePointAt(var1, var6);
                                 var6 = var8;
                                 if (this.f(var7)) {
                                    var6 = var8 + Character.charCount(var5) + Character.charCount(var7);
                                 }
                              } else {
                                 var6 = var8;
                                 if (this.f(var5)) {
                                    var6 = var8 + Character.charCount(var5);
                                 }
                              }

                              return var2 + var6;
                           }

                           if (this.d(var10) || this.i(var10)) {
                              var6 = var8 + Character.charCount(var10) + 0;
                              break;
                           }

                           var5 = var10;
                           var6 = var7;
                           var9 = var12;
                           if (var10 == 8205) {
                              var5 = Character.codePointAt(var1, var7);
                              var6 = var7 + Character.charCount(var5);
                              if (var6 < var3 && this.i(var5)) {
                                 var5 = Character.codePointAt(var1, var6);
                                 var4 = Character.charCount(var5);
                                 var7 = var6 + Character.charCount(var5);
                                 var9 = true;
                                 break label121;
                              }

                              var9 = true;
                           }
                        }

                        var4 = 0;
                        var7 = var6;
                     }

                     if (var7 >= var3) {
                        var6 = var8;
                        break;
                     }

                     var6 = var8;
                     if (!var9) {
                        break;
                     }

                     var6 = var5;
                     var11 = var8;
                     var10 = var4;
                     if (!this.c(var5)) {
                        var6 = var8;
                        break;
                     }
                  }
               }

               return var2 + var6;
            }
         }
      }
   }

   public int b(CharSequence var1, int var2) {
      byte var3 = 0;
      byte var4 = 1;
      if (var2 <= 1) {
         return 0;
      } else {
         int var5 = Character.codePointBefore(var1, var2);
         int var6 = Character.charCount(var5);
         int var7 = var2 - var6;
         if (var7 == 0) {
            return 0;
         } else {
            int var8;
            if (var5 == 10) {
               var8 = var6;
               if (Character.codePointBefore(var1, var7) == 13) {
                  var8 = var6 + 1;
               }

               return var2 - var8;
            } else if (this.g(var5)) {
               var5 = Character.codePointBefore(var1, var7);
               var8 = var7 - Character.charCount(var5);

               for(var7 = var4; var8 > 0 && this.g(var5); ++var7) {
                  var5 = Character.codePointBefore(var1, var8);
                  var8 -= Character.charCount(var5);
               }

               var8 = var6;
               if (var7 % 2 == 0) {
                  var8 = var6 + 2;
               }

               return var2 - var8;
            } else if (var5 == 8419) {
               var8 = Character.codePointBefore(var1, var7);
               var7 -= Character.charCount(var8);
               if (var7 > 0 && this.i(var8)) {
                  var5 = Character.codePointBefore(var1, var7);
                  var7 = var6;
                  if (this.f(var5)) {
                     var7 = var6 + Character.charCount(var8) + Character.charCount(var5);
                  }
               } else {
                  var7 = var6;
                  if (this.f(var8)) {
                     var7 = var6 + Character.charCount(var8);
                  }
               }

               return var2 - var7;
            } else {
               int var9 = var5;
               int var12 = var6;
               var8 = var7;
               if (var5 == 917631) {
                  while(true) {
                     var9 = Character.codePointBefore(var1, var7);
                     var8 = var7 - Character.charCount(var9);
                     if (var8 <= 0 || !this.h(var9)) {
                        if (!this.c(var9)) {
                           return var2 - 2;
                        }

                        var12 = var6 + Character.charCount(var9);
                        break;
                     }

                     var6 += Character.charCount(var9);
                     var7 = var8;
                  }
               }

               var7 = var9;
               var6 = var12;
               var5 = var8;
               if (this.i(var9)) {
                  var7 = Character.codePointBefore(var1, var8);
                  if (!this.c(var7)) {
                     return var2 - var12;
                  }

                  var6 = var12 + Character.charCount(var7);
                  var5 = var8 - var6;
               }

               int var10 = var6;
               if (this.c(var7)) {
                  boolean var14 = false;
                  var10 = 0;
                  int var11 = var6;
                  var6 = var7;

                  while(true) {
                     var8 = var11;
                     boolean var13 = var14;
                     if (var14) {
                        var8 = var11 + Character.charCount(var6) + var10 + 1;
                        var13 = false;
                     }

                     if (this.d(var6)) {
                        var12 = Character.codePointBefore(var1, var5);
                        var5 -= Character.charCount(var12);
                        var7 = var3;
                        var6 = var12;
                        if (var5 > 0) {
                           var7 = var3;
                           var6 = var12;
                           if (this.i(var12)) {
                              var6 = Character.codePointBefore(var1, var5);
                              if (!this.c(var6)) {
                                 return var2 - var8;
                              }

                              var7 = Character.charCount(var6);
                              Character.charCount(var6);
                           }
                        }

                        var10 = var8;
                        if (this.e(var6)) {
                           var10 = var8 + var7 + Character.charCount(var6);
                        }
                        break;
                     }

                     label115: {
                        var7 = var6;
                        var6 = var5;
                        var14 = var13;
                        if (var5 > 0) {
                           var10 = Character.codePointBefore(var1, var5);
                           var5 -= Character.charCount(var10);
                           var7 = var10;
                           var6 = var5;
                           var14 = var13;
                           if (var10 == 8205) {
                              var7 = Character.codePointBefore(var1, var5);
                              var6 = var5 - Character.charCount(var7);
                              if (var6 > 0 && this.i(var7)) {
                                 var7 = Character.codePointBefore(var1, var6);
                                 var12 = Character.charCount(var7);
                                 var5 = var6 - Character.charCount(var7);
                                 var14 = true;
                                 break label115;
                              }

                              var14 = true;
                           }
                        }

                        var12 = 0;
                        var5 = var6;
                     }

                     if (var5 == 0) {
                        var10 = var8;
                        break;
                     }

                     var10 = var8;
                     if (!var14) {
                        break;
                     }

                     var6 = var7;
                     var11 = var8;
                     var10 = var12;
                     if (!this.c(var7)) {
                        var10 = var8;
                        break;
                     }
                  }
               }

               return var2 - var10;
            }
         }
      }
   }

   public boolean c(int var1) {
      return this.a.isCodePointEmoji(var1);
   }

   public boolean d(int var1) {
      return this.a.isCodePointEmojiModifier(var1);
   }

   public boolean e(int var1) {
      return this.a.isCodePointEmojiModifierBase(var1);
   }

   public boolean f(int var1) {
      boolean var2;
      if ((48 > var1 || var1 > 57) && var1 != 35 && var1 != 42) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public boolean g(int var1) {
      return this.a.isCodePointRegionalIndicator(var1);
   }

   public boolean h(int var1) {
      boolean var2;
      if (917536 <= var1 && var1 <= 917630) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean i(int var1) {
      return this.a.isCodePointVariantSelector(var1);
   }
}
