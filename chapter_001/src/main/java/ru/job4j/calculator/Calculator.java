package ru.job4j.calculator;

/**
 * Класс для вычисления арифметических операций.
 * @author Bischev Ramil
 * @since 05-08-2019
 * @version 1.0
 */

public class Calculator {
    /**
     * метод сложения
     * @param first
     * @param second
     */
    public static void add(double first, double second) {
        double result=first+second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     * метод вычитания
     * @param first
     * @param second
     */
    public static void subtract(double first, double second) {
        double result=first-second;
        System.out.println(first + "-" + second + " = " + result);
    }

    /**
     * метод деления
     * @param first
     * @param second
     */
    public static void div(double first, double second) {
        double result=first/second;
        System.out.println(first + "/" + second + " = " + result);
    }

    /**
     * метод умножения
     * @param first
     * @param second
     */
    public static void multiple(double first, double second) {
        double result=first*second;
        System.out.println(first + "*" + second + " = " + result);
    }

    public static void main(String[] args) {
        add(1,1);
        subtract(4,2);
        div(10,5);
        multiple(2,3);
    }
}
