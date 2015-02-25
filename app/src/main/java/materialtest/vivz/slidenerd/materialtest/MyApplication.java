package materialtest.vivz.slidenerd.materialtest;

import android.app.Application;
import android.content.Context;

import materialtest.vivz.slidenerd.database.MoviesDatabase;

/**
 * Created by Windows on 30-01-2015.
 */
public class MyApplication extends Application {


    public static final String API_KEY_ROTTEN_TOMATOES = "54wzfswsa4qmjg8hjwa64d4c";
    private static MyApplication sInstance;

    private static MoviesDatabase mDatabase;

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    public synchronized static MoviesDatabase getWritableDatabase() {
        if (mDatabase == null) {
            mDatabase = new MoviesDatabase(getAppContext());
        }
        return mDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mDatabase = new MoviesDatabase(this);
    }

}
