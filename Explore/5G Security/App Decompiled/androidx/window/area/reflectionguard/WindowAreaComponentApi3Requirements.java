package androidx.window.area.reflectionguard;

import android.app.Activity;
import android.util.DisplayMetrics;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.core.util.function.Consumer;

public interface WindowAreaComponentApi3Requirements extends WindowAreaComponentApi2Requirements {
   void addRearDisplayPresentationStatusListener(Consumer<ExtensionWindowAreaStatus> var1);

   void endRearDisplayPresentationSession();

   DisplayMetrics getRearDisplayMetrics();

   ExtensionWindowAreaPresentation getRearDisplayPresentation();

   void removeRearDisplayPresentationStatusListener(Consumer<ExtensionWindowAreaStatus> var1);

   void startRearDisplayPresentationSession(Activity var1, Consumer<Integer> var2);
}
