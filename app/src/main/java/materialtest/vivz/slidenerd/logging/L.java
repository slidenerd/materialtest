package materialtest.vivz.slidenerd.logging;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Windows on 13-01-2015.
 */
public class L {
    public static void m(String message) {
        Log.d("VIVZ", "" + message);
    }

    public static void t(Context context, String message) {
        Toast.makeText(context, message + "", Toast.LENGTH_SHORT).show();
    }
    public static void T(Context context, String message) {
        Toast.makeText(context, message + "", Toast.LENGTH_LONG).show();
    }
}
