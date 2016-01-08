package net.nickmm.cleanarchitectures.modules.ListenerWeakReferenceModule;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by nickmm on 1/8/16.
 */

public class ListenerWeakReferenceInteractor {

    private Context mContext;
    private int counter = 0;

    private WeakReference<ListenerWeakReferenceInteractorListener> mListenerRef;

    public ListenerWeakReferenceInteractor(Context context, ListenerWeakReferenceInteractorListener listener) {
        mContext = context;
        mListenerRef = new WeakReference<ListenerWeakReferenceInteractorListener>(listener);
    }

    public void data() {
        if(mListenerRef != null && mListenerRef.get() != null) {
            mListenerRef.get().data(counter++);
        }
    }
}
