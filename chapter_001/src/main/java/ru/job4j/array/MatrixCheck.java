package ru.job4j.array;

/**
 * Класс проверки диагоналей матрицы.
 * @author Ramil Bischev.
 * @since 06-08-2019.
 * @version 1.1.
 */
public class MatrixCheck {

    /**
     * Метод проверки диагоналей матрицы.
     * Принимает матрицу размерностью data.
     * Возвращает true если диагонали имеют одно значение
     * @param data
     * @return
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if ((data[i][i] != data[i + 1][i + 1]) | (data[data.length - 1 - i][i] != data[data.length - 1 - i - 1][i + 1])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
