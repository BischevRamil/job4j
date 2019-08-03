package ru.job4j.converter;

public class Converter {
    //метод рубли в евро
    public static int rubleToEuro(int value) {
        return value / 70;
    }
    //метод рубли в доллары
    public static int rubleToDollar(int value) {
        return value / 60;
    }
    //метод евро в рубли
    public static int euroToRuble(int value) {
        return value * 70;
    }
    //метод доллары в рубли
    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");


        int dollar = rubleToDollar(120);
        System.out.println("120 rubles are " + dollar + " dollars.");


        int euror = euroToRuble(3);
        System.out.println("3 euro are " + euror + " rubles.");


        int dollarr = dollarToRuble(4);
        System.out.println("4 dollar are " + dollarr + " rubles.");


    }
}
