package ood.tictactoe;

public interface Gamer {

    void move();

    default boolean isCellValid(int x, int y) {
        if (x < 0 || x >= Field.fieldSize || y < 0 || y >= Field.fieldSize) {
            return false;
        }
        return Field.getSymbol(x, y) == Field.EMPTY_SYMBOL;
    }
}
