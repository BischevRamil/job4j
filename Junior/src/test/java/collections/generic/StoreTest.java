package collections.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreTest {
    private UserStore userStore;
    private User user1 = new User("user1");
    private User user2 = new User("user2");


    @Before
    public void init() {
        userStore = new UserStore(10);
    }

    @Test
    public void addNewUser() {
        userStore.add(user1);
        assertThat(userStore.findById("user1").getId(), is("user1"));
    }

    @Test
    public void replaceUser() {
        userStore.add(user1);
        userStore.replace("user1", user2);
        assertThat(userStore.findById("user2").getId(), is("user2"));
    }

    @Test
    public void deleteUser() {
        userStore.add(user1);
        assertThat(userStore.delete("user1"), is(true));
    }
}
