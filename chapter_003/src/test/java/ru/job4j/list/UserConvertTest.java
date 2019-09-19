package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void when2Users() {
        User ivan = new User(1, "ivan", "moscow");
        User alex = new User(2, "alex", "spb");
        User petr = new User(3, "petr", "london");
        List<User> users = List.of(ivan, alex, petr);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, ivan);
        expected.put(2, alex);
        expected.put(3, petr);
        assertThat(expected, is(new UserConvert().process(users)));
    }
}
