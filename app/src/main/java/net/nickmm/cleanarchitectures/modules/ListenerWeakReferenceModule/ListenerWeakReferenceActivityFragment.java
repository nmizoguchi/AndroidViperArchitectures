package net.nickmm.cleanarchitectures.modules.ListenerWeakReferenceModule;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.nickmm.cleanarchitectures.R;
import net.nickmm.cleanarchitectures.modules.ListenerModule.ListenerPresenterListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListenerWeakReferenceActivityFragment extends Fragment implements ListenerWeakReferencePresenterListener {

    private ListenerWeakReferencePresenter mPresenter;
    public ListenerWeakReferenceActivityFragment() {
        mPresenter = new ListenerWeakReferencePresenter(getContext(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listener_weak_reference, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button b = (Button)view.findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onRequestData();
            }
        });
    }

    @Override
    public void showData(String data) {
        Log.d("ACTIVITY", data);
    }
}
