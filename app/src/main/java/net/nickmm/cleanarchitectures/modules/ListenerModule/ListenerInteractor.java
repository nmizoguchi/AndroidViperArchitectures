package net.nickmm.cleanarchitectures.modules.ListenerModule;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by nickmm on 1/8/16.
 */

public class ListenerInteractor {

    private Context mContext;
    private ListenerInteractorListener mListener;
    private int counter = 0;

    public ListenerInteractor(Context context) {
        mContext = context;
    }

    public void addListener(ListenerInteractorListener listener) {
        mListener = listener;
    }

    public void removeListener(ListenerInteractorListener listener) {
        if(listener != null && listener.equals(mListener))
            mListener = null;
    }

    public void data() {
        if(mListener != null) {
            mListener.data(counter++);
        }
    }
}
