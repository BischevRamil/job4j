package ood.tictactoe;

/**
 * Class for check wining combination.
 */
public class Win {

    public static boolean check(char symbol) {
        for (int i = 0; i < Field.fieldSize; i++) {
            int result = 0;
            for (int j = 0; j < Field.fieldSize; j++) {
                if (Field.getSymbol(i, j) == symbol) {
                    result++;
                }
            }
            if (result == Field.fieldSize) {
                return true;
            }
        }

        for (int i = 0; i < Field.fieldSize; i++) {
            int result = 0;
            for (int j = 0; j < Field.fieldSize; j++) {
                if (Field.getSymbol(j, i) == symbol) {
                    result++;
                }
            }
            if (result == Field.fieldSize) {
                return true;
            }
        }

        int first = 0;
        for (int i = 0; i < Field.fieldSize; i++) {
            for (int j = 0; j < Field.fieldSize; j++) {
                if (i == j && Field.getSymbol(i, j) == symbol) {
                    first++;
                }
            }
            if (first == Field.fieldSize) {
                return true;
            }
        }

        int second = 0;
        for (int i = 0, j = Field.fieldSize - 1; i < Field.fieldSize && j >= 0; i++, j--) {
            if (Field.getSymbol(i, j) == symbol) {
                second++;
            }
            if (second == Field.fieldSize) {
                return true;
            }
        }
        return false;
    }

}
