package be.vergauwen.simon.fasterankolayouts;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;

public class AnkoApplication extends Application {
    public RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
            refWatcher = LeakCanary.install(this);
        }
    }
}
