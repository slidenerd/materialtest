package materialtest.vivz.slidenerd.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Windows on 07-01-2015.
 */
public class ViewCustom extends TextView {
    public static final String TAG="VIVZ";
    Paint paint;
    public ViewCustom(Context context) {
        super(context);
        init();
    }

    public ViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "View dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "View dispatchTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "View dispatchTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "View dispatchTouchEvent CANCEL");
                break;
        }
        boolean b=super.dispatchTouchEvent(event);
        Log.d(TAG,"View dispatchTouchEvent RETURNS "+b);
        return b;
    }

    @Override
     public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "View onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:

                Log.d(TAG, "View onTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "View onTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "View onTouchEvent CANCEL");
                break;
        }
        boolean b=super.onTouchEvent(event);
        Log.d(TAG,"View onTouchEvent RETURNS "+b);
        return b;
    }

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

}
