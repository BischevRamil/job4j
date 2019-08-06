package ru.job4j.array;

/**
 * Проверка массива на True или False.
 * @author Bischev Ramil
 * @since 06-08-2019
 * @version 1.0
 */

public class Check {

    public boolean mono(boolean[] data) {
        boolean result = true;
       for (int i = 0; i < data.length - 1; i++) {
           if (data[i] != data[i + 1]) {
               result = false;
               break;
           }
       }
        return result;
    }
}
