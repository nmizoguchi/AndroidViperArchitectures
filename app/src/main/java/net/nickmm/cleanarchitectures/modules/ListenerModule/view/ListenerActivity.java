package net.nickmm.cleanarchitectures.modules.ListenerModule.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.squareup.leakcanary.RefWatcher;

import net.nickmm.cleanarchitectures.R;
import net.nickmm.cleanarchitectures.modules.AppApplication;

public class ListenerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override public void onDestroy() {
        RefWatcher refWatcher = AppApplication.getRefWatcher(this);
        refWatcher.watch(this);
        super.onDestroy();
        Log.d("ACTIVITY", "Watching");
    }
}
