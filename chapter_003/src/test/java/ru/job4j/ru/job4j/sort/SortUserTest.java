package ru.job4j.ru.job4j.sort;

import org.junit.Test;
import ru.job4j.sort.SortUser;
import ru.job4j.sort.User;

import java.util.List;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {
    @Test
    public void sortTest() {
        User petr = new User("petr", 34);
        User ivan = new User("ivan", 20);
        User gogi = new User("gogi", 38);
        User alex = new User("alex", 26);
        List<User> users = List.of(petr, ivan, gogi, alex);
        Set<User> expected = Set.of(ivan, alex, petr, gogi);
        assertThat(expected, is(new SortUser().sort(users)));


    }
}
