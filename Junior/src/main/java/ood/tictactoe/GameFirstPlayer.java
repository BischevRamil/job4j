package ood.tictactoe;

/**
 * The class describes the logic when the first move for the player
 */
public class GameFirstPlayer implements IGame {

    @Override
    public void play(GamerPlayer player, GamerComputer computer, int games) {
        int playerWins = 0;
        int computerWins = 0;
        while (playerWins < games && computerWins < games) {
            System.out.println("Enter coordinates");
            player.move();
            System.out.println("Your turn");
            Field.print();
            if (Win.check(GamerPlayer.SYMBOL)) {
                System.out.println("You win");
                playerWins++;
                printResult(playerWins, computerWins);
                Field.clearField();
                continue;
            }
            if (!Field.isFreeSpace()) {
                System.out.println("Draw result");
                printResult(playerWins, computerWins);
                Field.clearField();
                continue;
            }
            computer.move();
            System.out.println("Computer turn");
            Field.print();
            if (Win.check(GamerComputer.SYMBOL)) {
                System.out.println("Computer win");
                computerWins++;
                printResult(playerWins, computerWins);
                Field.clearField();
            }
            if (!Field.isFreeSpace()) {
                System.out.println("Draw result");
                printResult(playerWins, computerWins);
                Field.clearField();
            }
        }
    }

    private void printResult(int x, int y) {
        System.out.format("The game score: Player - Computer %d - %d", x, y);
        System.out.println();
    }
}
