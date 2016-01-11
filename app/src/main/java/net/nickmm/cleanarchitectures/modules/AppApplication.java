package net.nickmm.cleanarchitectures.modules;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by owner on 1/11/16.
 */
public class AppApplication extends Application {

    public static RefWatcher getRefWatcher(Context context) {
        AppApplication application = (AppApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        Log.d("APPLICATION", "Set Canary");
    }
}
