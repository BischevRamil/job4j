package ru.job4j.oop;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс вычисляет сдачу и возвращает в виде массива с монетками
 * @author Bishev Ramil
 * @version 1.0
 * @since 22-08-2019
 *
 */
public class CoffeeMashine {
    final private static int[] RUBS = {10, 5, 2, 1};


    public static int[] changes(int value, int price) {
        ArrayList<Integer> coins = new ArrayList<>();
        int change = value - price;
        int foo = 0;
        if (change < 0) {
            System.out.println("Мало денег!!");
            return new int[0];
        } else if (change == 0) {
            System.out.println("Без сдачи!");
            return new int[0];
        } else if (change > 0) {
            for (int i = 0; i < RUBS.length; i++) {
                foo = change / RUBS[i];
                for (int j = 0; j < foo; j++) {
                    coins.add(j, RUBS[i]);
                }
                change = change % RUBS[i];
            }
        }
        return listToArr(coins);
    }

    private static int[] listToArr(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(arr.length - 1 - i).intValue();
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(changes(100, 33)));
    }
}
