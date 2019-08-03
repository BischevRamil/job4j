package ru.job4j.calculator;

public class Calculator {
    // метод сложения
    public static void add(double first, double second) {
        double result=first+second;
        System.out.println(first + "+" + second + " = " + result);
    }
    // метод вычитания
    public static void subtract(double first, double second) {
        double result=first-second;
        System.out.println(first + "-" + second + " = " + result);
    }
    // метод деления
    public static void div(double first, double second) {
        double result=first/second;
        System.out.println(first + "/" + second + " = " + result);
    }
    // метод умножения
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
