package net.nickmm.cleanarchitectures.modules.AbstractListenerModule.Module;

import android.content.Context;

import net.nickmm.cleanarchitectures.modules.AbstractListenerModule.AbstractPresenter;

/**
 * Created by owner on 1/11/16.
 */

interface PresenterImplListener {
    void showData(String data);
}

public class PresenterImpl extends AbstractPresenter<PresenterImplListener> {

    private InteractorImpl mInteractor;

    public PresenterImpl(Context context, InteractorImpl interactor) {
        super(context);
        mInteractor = interactor;
        mInteractor.addListener(new InteractorImplListener() {
            @Override
            public void loadedData(int num) {
                if(mListener != null) mListener.showData("Count " + num);
            }
        });
    }

    public void onRequestData() {
        mInteractor.data();
    }

    @Override
    public void removeListener() {
        super.removeListener();
        if(mInteractor != null)
            mInteractor.removeListener();
    }
}
