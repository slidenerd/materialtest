package materialtest.vivz.slidenerd.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Windows on 07-01-2015.
 */
public class LayoutCustom extends FrameLayout {
    public static final String TAG="VIVZ";
    Paint paint=null;
    public LayoutCustom(Context context) {
        super(context);

        init();
    }

    public LayoutCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LayoutCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }
    public void init(){
        paint=new Paint();

        paint.setAntiAlias(true);
        setWillNotDraw(false);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout dispatchTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout dispatchTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout dispatchTouchEvent CANCEL");
                break;
        }
        boolean b=super.dispatchTouchEvent(ev);
        Log.d(TAG,"MyLayout dispatchTouchEvent RETURNS "+b);
        return b;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout onInterceptTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout onInterceptTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout onInterceptTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout onInterceptTouchEvent CANCEL");
                break;
        }
        boolean b=super.onInterceptTouchEvent(ev);
        Log.d(TAG,"MyLayout onInterceptTouchEvent RETURNS "+b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout onTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout onTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout onTouchEvent CANCEL");
                break;
        }
        boolean b=super.onTouchEvent(event);
        Log.d(TAG,"MyLayout onTouchEvent RETURNS "+b);
        return b;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
    }
}
