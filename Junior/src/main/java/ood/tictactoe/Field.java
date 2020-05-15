package ood.tictactoe;

public class Field {
    static int fieldSize;
    private static char[][] pole;
    static final char EMPTY_SYMBOL = '-';

    public static void init(final int fieldSize) {
        Field.fieldSize = fieldSize;
        Field.pole = new char[fieldSize][fieldSize];
        for (int i = 0; i < Field.fieldSize; i++) {
            for (int j = 0; j < Field.fieldSize; j++) {
                pole[i][j] = EMPTY_SYMBOL;
            }
        }
    }

    public static void print() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(pole[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void set(int x, int y, char symbol) {
        Field.pole[x][y] = symbol;
    }

    public static char getSymbol(int x, int y) {
        return Field.pole[x][y];
    }

    static boolean isFreeSpace() {
        for (int i = 0; i < Field.fieldSize; i++) {
            for (int j = 0; j < Field.fieldSize; j++) {
                if (Field.getSymbol(i, j) == Field.EMPTY_SYMBOL) {
                    return true;
                }
            }
        }
        return false;
    }

    static void clearField() {
        Field.init(fieldSize);
    }
}
