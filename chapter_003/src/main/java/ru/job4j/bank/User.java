package ru.job4j.bank;

import java.util.Objects;

/**
 * @author ramil bishev
 * @since 2019-09-27
 */

public class User implements Comparable<User> {
    private String name;
    private String passport;

    User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return passport == user.passport && (name == user.name || name != null && name.equals(user.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        return "User{"
                + "passport=" + passport
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public int compareTo(User user) {
        return this.name.compareTo(user.name);
    }
}
