package net.nickmm.cleanarchitectures.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import net.nickmm.business.User;

import rx.Observable;

/**
 * Created by owner on 1/11/16.
 */

public class UserRepositorySharedPrefImpl implements UserRepository {

    public static final String USER_REPO_SHARED_PREF_NAME = "user_repository";
    public static final String USER_REPO_ID = "user_repository_id";
    public static final String USER_REPO_NAME = "user_repository_name";
    public static int count = 0;

    private Context mContext;
    public UserRepositorySharedPrefImpl(Context context) {
        mContext = context;
    }



    public Observable<Integer> fetchUser() {
        return Observable.defer(() -> Observable.just(getnum(), getnum(), getnum(), getnum()));
    }

    public int getnum() {

        try {
            Log.d("SLEEP", "5s");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("SLEEP", "count = "+count);
        return count++;
    }

    @Override
    public User getUser() {
        SharedPreferences sharedPrefs = mContext.getSharedPreferences(USER_REPO_SHARED_PREF_NAME, Context.MODE_PRIVATE);
        sharedPrefs.getInt(USER_REPO_ID, 0);
        sharedPrefs.getString(USER_REPO_NAME, "undefined");
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(USER_REPO_SHARED_PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(USER_REPO_ID, user.id);
        editor.putString(USER_REPO_NAME, user.name);
        return editor.commit();
    }
}
