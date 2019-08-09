package ru.job4j.condition;

public class Max {
    public int max(int first, int second) {
        int result = first > second ? first : second;
        return result;
    }

    public int max(int first, int second, int third) {
        int result = max(first, second) > third ? max(first, second) : third;
        return result;
    }

    public int max(int first, int second, int third, int forth) {
        int result = max(first, second, third) > forth ? max(first, second, third) : forth;
        return result;
    }
}
