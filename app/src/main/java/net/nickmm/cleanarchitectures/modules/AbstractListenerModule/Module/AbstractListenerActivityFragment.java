package net.nickmm.cleanarchitectures.modules.AbstractListenerModule.Module;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.squareup.leakcanary.RefWatcher;

import net.nickmm.cleanarchitectures.R;
import net.nickmm.cleanarchitectures.modules.AppApplication;
import net.nickmm.cleanarchitectures.modules.ListenerModule.ListenerPresenter;
import net.nickmm.cleanarchitectures.modules.ListenerModule.ListenerPresenterListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class AbstractListenerActivityFragment extends Fragment {

    private PresenterImpl mPresenter;

    public AbstractListenerActivityFragment() {
        InteractorImpl interactor = new InteractorImpl(getContext());
        mPresenter = new PresenterImpl(getActivity(),interactor);
        mPresenter.addListener(new PresenterImplListener() {
            @Override
            public void showData(String data) {
                Log.d("ACTIVITY", data);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_abstract_listener, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button b = (Button)view.findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onRequestData();
            }
        });
    }

    @Override public void onDestroy() {
        RefWatcher refWatcher = AppApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
        super.onDestroy();
        Log.d("ACTIVITY", "Watching");
    }
}
