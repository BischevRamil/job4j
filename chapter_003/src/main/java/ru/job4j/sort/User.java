package ru.job4j.sort;

import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



    @Override
    public int compareTo(User user) {
        return this.age - user.getAge();
    }

    @Override
    public String toString() {
        return "User{"
                + "age=" + age
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && (name == user.name || name != null && name.equals(user.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
