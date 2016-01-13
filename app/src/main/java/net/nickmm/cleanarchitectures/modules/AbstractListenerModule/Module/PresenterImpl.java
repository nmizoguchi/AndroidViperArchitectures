package net.nickmm.cleanarchitectures.modules.AbstractListenerModule.Module;

import android.app.Activity;

import net.nickmm.cleanarchitectures.modules.AbstractListenerModule.AbstractPresenter;

/**
 * Created by owner on 1/11/16.
 */

interface PresenterImplListener {
    void showData(String data);
}

public class PresenterImpl extends AbstractPresenter<PresenterImplListener> {

    private InteractorImpl mInteractor;

    public PresenterImpl(Activity activity, InteractorImpl interactor) {
        super(activity);
        mInteractor = interactor;
        mInteractor.addListener(new InteractorImplListener() {
            @Override
            public void loadedData(int num) {
                if (mListener != null) mListener.showData("Count " + num);
            }
        });
    }

    public void onRequestData() {
        mInteractor.data();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        mInteractor.removeListener();
    }
}
