package ru.job4j.condition;

public class Max {
    public int max(int first, int second) {
        int result = first > second ? first : second;
        return result;
    }

    public int max(int first, int second, int third) {
        int result = max(max(first, second), third);
        return result;
    }

    public int max(int first, int second, int third, int forth) {
        int result = max(max(max(first, second), third), forth);
        return result;
    }
}
