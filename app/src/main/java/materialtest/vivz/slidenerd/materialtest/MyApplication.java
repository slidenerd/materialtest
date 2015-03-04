package materialtest.vivz.slidenerd.materialtest;

import android.app.Application;
import android.content.Context;

import materialtest.vivz.slidenerd.database.DBMovies;

/**
 * Created by Windows on 30-01-2015.
 */
public class MyApplication extends Application {


    public static final String API_KEY_ROTTEN_TOMATOES = "54wzfswsa4qmjg8hjwa64d4c";
    private static MyApplication sInstance;

    private static DBMovies mDatabase;

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    public synchronized static DBMovies getWritableDatabase() {
        if (mDatabase == null) {
            mDatabase = new DBMovies(getAppContext());
        }
        return mDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mDatabase = new DBMovies(this);
    }

}
