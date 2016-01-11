package net.nickmm.cleanarchitectures.modules.AbstractListenerModule;

import android.content.Context;

/**
 * Created by owner on 1/11/16.
 */

public abstract class AbstractPresenter<Listener_T> {

    private Context mContext;
    protected Listener_T mListener;

    public AbstractPresenter(Context context) {
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
