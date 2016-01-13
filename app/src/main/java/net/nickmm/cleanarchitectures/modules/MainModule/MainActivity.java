package net.nickmm.cleanarchitectures.modules.MainModule;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.leakcanary.RefWatcher;

import net.nickmm.cleanarchitectures.R;
import net.nickmm.cleanarchitectures.data.UserRepositorySharedPrefImpl;
import net.nickmm.cleanarchitectures.modules.AbstractListenerModule.Module.AbstractListenerActivity;
import net.nickmm.cleanarchitectures.modules.AppApplication;
import net.nickmm.cleanarchitectures.modules.ListenerModule.view.ListenerActivity;
import net.nickmm.cleanarchitectures.modules.ListenerWeakReferenceModule.ListenerWeakReferenceActivity;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UserRepositorySharedPrefImpl repo = new UserRepositorySharedPrefImpl(this);
        final Observable<Integer> o = repo.fetchUser();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                o.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Integer>() {

                            @Override
                            public void onCompleted() {
                                Log.d("RX", "onCompleted");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("RX", "onError");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.d("RX", "onNext: "+integer);
                            }
                        });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startListenerActivity(View view) {
        Intent intent = new Intent(this, ListenerActivity.class);
        startActivity(intent);
    }

    public void startListenerWeakReferenceActivity(View view) {
        Intent intent = new Intent(this, ListenerWeakReferenceActivity.class);
        startActivity(intent);
    }

    public void startAbstractListenerActivity(View view) {
        Intent intent = new Intent(this, AbstractListenerActivity.class);
        startActivity(intent);
    }


}
