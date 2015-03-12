package materialtest.vivz.slidenerd.activities;


import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import materialtest.vivz.slidenerd.materialtest.R;


public class ActivityTouchEvent extends ActionBarActivity {

    public static final String TAG = "VIVZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        setupToolbar();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present. 
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will 
        // automatically handle clicks on the Home/Up button, so long 
        // as you specify a parent activity in AndroidManifest.xml. 
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement 
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "Activity dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Activity dispatchTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "Activity dispatchTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "Activity dispatchTouchEvent CANCEL");
                break;
        }
        boolean b = super.dispatchTouchEvent(ev);
        Log.d(TAG, "Activity dispatchTouchEvent RETURNS " + b);
        return b;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "Activity onTouch DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Activity onTouch MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "Activity onTouch UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "Activity onTouch CANCEL");
                break;
        }
        boolean b = super.onTouchEvent(event);
        Log.d(TAG, "Activity onTouchEvent RETURNS " + b);
        return b;
    }
} 