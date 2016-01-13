package net.nickmm.cleanarchitectures.modules.MainModule;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.leakcanary.RefWatcher;

import net.nickmm.cleanarchitectures.R;
import net.nickmm.cleanarchitectures.data.UserRepositorySharedPrefImpl;
import net.nickmm.cleanarchitectures.modules.AppApplication;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = AppApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
