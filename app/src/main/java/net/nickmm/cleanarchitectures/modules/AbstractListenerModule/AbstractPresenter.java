package net.nickmm.cleanarchitectures.modules.AbstractListenerModule;

import android.app.Activity;
import android.content.Context;

/**
 * Created by owner on 1/11/16.
 */

public abstract class AbstractPresenter<Listener_T> {

    private Activity mActivity;

    public abstract void onResume();
    public abstract void onPause();
    public abstract void onDestroy();

    public void resume() {
        onResume();
    }

    public void pause() {
        onPause();
    }

    public void destroy() {
        onDestroy();
        mActivity = null;
        mListener = null;
    }

    protected Listener_T mListener;

    public AbstractPresenter(Activity activity) {
        mActivity = activity;
    }

    public void addListener(Listener_T listener) {
        mListener = listener;
    }

    public void removeListener() {
        mListener = null;
    }

    public Activity getActivity() {
        return mActivity;
    }
}
