package ood.tictactoe;

import java.util.Scanner;

/**
 * @author Ramil Bischev
 * @since 2020-05-15
 * @version 1.2
 * Main class for TicTacToe Game.
 * The first question asks what size of the playing field(You must enter an odd number, an even number will decrease).
 * The second question asks who will go first.
 * The third question asks what result to win.
 */
public class TicTacToe {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Welcome to TicTacToe Game. Enter field size: ");
        int x = scanner.nextInt();
        int size;
        if (x % 2 == 1) {
            size = x;
        } else {
            size = x - 1;
        }
        Field.init(size);
        Field.print();
        System.out.print("Do you want the computer to play first(y/n): ");
        String answer = scanner.next();
        System.out.print("What result will we play: ");
        int games = scanner.nextInt();
        GamerPlayer player = new GamerPlayer();
        GamerComputer computer = new GamerComputer();
        IGame game;
        if ("y".equals(answer)) {
            game = new GameFirstComputer();
        } else {
            game = new GameFirstPlayer();
        }
        game.play(player, computer, games);
    }
}
