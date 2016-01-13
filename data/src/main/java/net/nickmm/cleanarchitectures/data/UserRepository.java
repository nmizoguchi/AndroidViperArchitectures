package net.nickmm.cleanarchitectures.data;

import net.nickmm.business.User;

/**
 * Created by owner on 1/11/16.
 */
public interface UserRepository {

    public User getUser();
    public boolean saveUser(User user);
}
