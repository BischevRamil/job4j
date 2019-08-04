package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first;
        // if ...
        int s = first > second ? first : second;
        result = s > third ? s : third;
        return result;
    }
}
