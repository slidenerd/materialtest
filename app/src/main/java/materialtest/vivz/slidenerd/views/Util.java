package materialtest.vivz.slidenerd.views;

import android.widget.EditText;

/**
 * Created by Windows on 12-03-2015.
 */
public class Util {
    public static boolean hasValidContents(EditText editText) {
        if (editText != null
                && editText.getText() != null
                && editText.getText().toString() != null
                && editText.getText().toString().trim().length() > 0) {
            return true;
        }
        return false;
    }
}
