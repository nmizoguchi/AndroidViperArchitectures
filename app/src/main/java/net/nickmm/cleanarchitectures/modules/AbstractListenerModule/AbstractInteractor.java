package net.nickmm.cleanarchitectures.modules.AbstractListenerModule;

import android.app.Activity;
import android.content.Context;

/**
 * Created by owner on 1/11/16.
 */
public abstract class AbstractInteractor<Listener_T> {

    protected Listener_T mListener;
    private Context mContext;

    public abstract void onResume();
    public abstract void onPause();
    public abstract void onDestroy();

    public AbstractInteractor(Context context) {
        mContext = context;
    }

    public void addListener(Listener_T listener) {
        mListener = listener;
    }

    public void removeListener() {
        mListener = null;
    }

    public Context getContext() {
        return mContext;
    }
}
