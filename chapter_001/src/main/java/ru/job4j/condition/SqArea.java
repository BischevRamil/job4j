package ru.job4j.condition;

public class SqArea {
    public static int square(int p, int k) {
        int l=(p/2)/(k+1);
        int h=l*k;
        return h*l;
    }

    public static void main(String[] args) {
        int result1 = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 1, real = " + result1);
    }
}
