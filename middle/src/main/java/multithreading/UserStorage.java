package multithreading;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.*;

/**
 * @author Bischev Ramil
 * @since 2020-06-12
 * Thread safe class with jcip annotations.
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Set<User> users = new HashSet<>();

    public synchronized boolean add(User user) {
        return this.users.add(user);
    }

    public synchronized boolean delete(User user) {
        return this.users.remove(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        if (this.users.contains(user)) {
            this.delete(user);
            this.add(user);
            result = true;
        }
        return result;
    }

    public synchronized Optional<User> get(int id) {
        Optional<User> result = Optional.empty();
        for (User user : this.users) {
            if (id == user.getId()) {
                result = Optional.of(user);
            }
        }
        return result;
    }

    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (get(fromId).get().turnDownMoney(amount)) {
            get(toId).get().addMoney(amount);
            result = true;
        }
        return result;
    }
}

