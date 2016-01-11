package net.nickmm.cleanarchitectures.modules.AbstractListenerModule.Module;

import android.content.Context;

import net.nickmm.cleanarchitectures.modules.AbstractListenerModule.AbstractInteractor;

/**
 * Created by owner on 1/11/16.
 */

interface InteractorImplListener {
    public void loadedData(int num);
}

public class InteractorImpl extends AbstractInteractor<InteractorImplListener> {

    private static int count = 0;

    public InteractorImpl(Context context) {
        super(context);
    }

    public void data() {
        if(mListener != null) {
            mListener.loadedData(count++);
        }
    }
}
