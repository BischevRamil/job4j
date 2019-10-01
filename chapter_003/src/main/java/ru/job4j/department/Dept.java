package ru.job4j.department;


import java.util.Objects;

public class Dept {
    private String name;

    public Dept(String string) {
        this.name = string;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Dept{" + name + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Dept dept = (Dept) o;
        return name.equals(dept.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
