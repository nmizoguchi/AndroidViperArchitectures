package net.nickmm.cleanarchitectures.modules.ListenerWeakReferenceModule;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by nickmm on 1/8/16.
 */

public class ListenerWeakReferencePresenter implements ListenerWeakReferenceInteractorListener {

    private Context mContext;
    private ListenerWeakReferenceInteractor mInteractor;
    private WeakReference<ListenerWeakReferencePresenterListener> mListenerRef;

    public ListenerWeakReferencePresenter(Context context, ListenerWeakReferencePresenterListener listener) {
        mContext = context;
        mListenerRef = new WeakReference<ListenerWeakReferencePresenterListener>(listener);
        mInteractor = new ListenerWeakReferenceInteractor(context,this);
    }

    public void data(int id) {
        if(mListenerRef != null && mListenerRef.get() != null) {
            mListenerRef.get().showData("Id passed is: "+String.valueOf(id));
        }
    }

    public void onRequestData() {
        mInteractor.data();
    }
}