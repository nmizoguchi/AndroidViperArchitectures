package net.nickmm.cleanarchitectures.modules.ListenerModule.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.nickmm.cleanarchitectures.R;
import net.nickmm.cleanarchitectures.modules.ListenerModule.ListenerInteractor;
import net.nickmm.cleanarchitectures.modules.ListenerModule.ListenerPresenter;
import net.nickmm.cleanarchitectures.modules.ListenerModule.ListenerPresenterListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListenerActivityFragment extends Fragment {

    private ListenerPresenter presenter;

    public ListenerActivityFragment() {
        presenter = new ListenerPresenter(getContext());
        presenter.addListener(new ListenerPresenterListener() {
            @Override
            public void showData(String data) {
                Log.d("ACTIVITY", data);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listener, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button b = (Button)view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRequestData();
            }
        });
    }
}
