package net.nickmm.cleanarchitectures.modules.ListenerModule;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by nickmm on 1/8/16.
 */

public class ListenerPresenter {

    private Context mContext;
    private ListenerInteractor mInteractor;
    private ListenerPresenterListener mListener;

    public ListenerPresenter(Context context) {
        mContext = context;
        mInteractor = new ListenerInteractor(context);
        mInteractor.addListener(new ListenerInteractorListener() {

            public void data(int id) {
                if(mListener != null) {
                    mListener.showData("Id passed is: "+String.valueOf(id));
                }
            }


        });
    }

    public void addListener(ListenerPresenterListener listener) {
        mListener = listener;
    }

    public void removeListener(ListenerPresenterListener listener) {
        if(listener != null && listener.equals(mListener))
            mListener = null;
    }

    public void onRequestData() {
        mInteractor.data();
    }
}