package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс удаления из массива дубликатов
 * @author Bischev Ramil
 * @since 06-08-2019
 * @version 1.0
 */
public class ArrayDuplicate {

    /**
     * метод удаления дубликатов из массива
     * @param array String
     * @return array String
     */
    public String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for (int out = 0; out<unique; out++){
            for (int in = out+1; in<unique; in++){
                if (array[out].equals(array[in])){
                    array[in]=array[unique-1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array,unique);
    }
}
