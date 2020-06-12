package multithreading;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStorageTest {

    @Test
    public void whenUpdateUserThenHaveNewAmount() {
        UserStorage storage = new UserStorage();
        User u1 = new User(1, 100);
        User u2 = new User(1, 200);
        storage.add(u1);
        storage.update(u2);
        assertThat(storage.get(1).get().getAmount(), is(200));
    }

    @Test
    public void whenTransferMoneyAndEnoughMoneyThenTrue() {
        UserStorage storage = new UserStorage();
        User u1 = new User(1, 100);
        User u2 = new User(2, 200);
        storage.add(u1);
        storage.add(u2);
        assertThat(storage.transfer(1,2,50), is(true));
    }

    @Test
    public void whenTransferMoneyAndNoEnoughMoneyThenFalse() {
        UserStorage storage = new UserStorage();
        User u1 = new User(1, 100);
        User u2 = new User(2, 200);
        storage.add(u1);
        storage.add(u2);
        assertThat(storage.transfer(1,2,150), is(false));
    }
}
