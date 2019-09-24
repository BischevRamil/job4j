package ru.job4j.ru.job4j.sort;

import org.junit.Test;
import ru.job4j.sort.SortUser;
import ru.job4j.sort.User;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        Set<User> treeSet = new SortUser().sort(users);
        Iterator<User> userIterator = treeSet.iterator();
        assertThat(ivan, is(userIterator.next()));
        assertThat(alex, is(userIterator.next()));
        assertThat(petr, is(userIterator.next()));
        assertThat(gogi, is(userIterator.next()));
    }

    @Test
    public void sortNameLengthTest() {
        User petr = new User("petr22", 34);
        User ivan = new User("ivan1", 20);
        User gogi = new User("gogi4444", 38);
        User alex = new User("alex333", 26);
        List<User> users = List.of(petr, ivan, gogi, alex);
        List<User> expected = List.of(ivan, petr, alex, gogi);
        assertThat(expected, is(new SortUser().sortNameLength(users)));
    }

    @Test
    public void sortByAllFieldsTest() {
        User usr1 = new User("sergey", 25);
        User usr2 = new User("ivan", 30);
        User usr3 = new User("sergey", 20);
        User usr4 = new User("ivan", 25);
        List<User> users = List.of(usr1, usr2, usr3, usr4);
        List<User> expected = List.of(usr4, usr2, usr3, usr1);
        assertThat(expected, is(new SortUser().sortByAllFields(users)));
    }
}
