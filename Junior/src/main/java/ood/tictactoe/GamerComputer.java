package ood.tictactoe;

import java.util.Random;

/**
 * Computer Class. Sets random coordinates and sets cross to the field if the field is not occupied
 */
public class GamerComputer extends Gamer {
    static final char SYMBOL = 'X';
    static Random random = new Random();

    @Override
    public void move() {
        int x, y;
        do {
            x = random.nextInt(Field.fieldSize);
            y = random.nextInt(Field.fieldSize);
        } while (!super.isCellValid(x, y));
        Field.set(x, y, SYMBOL);
    }
}
