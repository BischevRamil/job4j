package ru.job4j.sort;

import java.util.*;

/**
 * @author ramil bishev
 * @since 2019-09-20
 * Sort with comparator
 */
public class SortUser {

    public Set<User> sort (List<User> list) {
        return new TreeSet<User>(list);
    }

    public List<User> sortNameLength (List<User> list) {
        List<User> result = new ArrayList<>(list);
        result.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getName().length() - u2.getName().length();
            }
        });
        return result;
    }

    public List<User> sortByAllFields (List<User> list) {
        List<User> result = new ArrayList<>(list);
        result.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int rst = u1.getName().compareTo(u2.getName());
                return rst != 0 ? rst : u1.getAge() - u2.getAge();
            }
        });
        return result;
    }
}
