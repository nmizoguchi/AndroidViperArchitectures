package net.nickmm.cleanarchitectures.modules.AbstractListenerModule;

import android.content.Context;

/**
 * Created by owner on 1/11/16.
 */
public class AbstractInteractor<Listener_T> {

    protected Listener_T mListener;
    private Context mContext;

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
