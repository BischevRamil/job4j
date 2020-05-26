package ood.tictactoe;

import java.util.Scanner;

/**
 * Player Class. Reads coordinates from the console and sets zero to the field if the field is not occupied
 */
public class GamerPlayer implements Gamer {
    static Scanner vvod = new Scanner(System.in);
    static final char SYMBOL = 'O';

    @Override
    public void move() {
        int x, y;
        do {
            x = vvod.nextInt() - 1;
            y = vvod.nextInt() - 1;
        } while (!isCellValid(x, y));
        Field.set(x, y, SYMBOL);
    }


}
