import java.util.*;
/**
 * A class implementing the Player interface
 */
public class HumanPlayer implements Player {
    /**
     * Default constructor
     */
    public HumanPlayer() {}

    /**
     * Plays a turn according to HumanPlayer's strategy
     * @param board the board to play on
     * @param mark the mark of the player
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player" + mark + ", type coordinates: ");
        while (true) {
            String coordinates = scanner.nextLine();
            int x = Integer.parseInt(coordinates.substring(0, 1));
            int y = Integer.parseInt(coordinates.substring(1, 2));
            if (coordinates.length() == 2 && board.putMark(mark, x, y)) {
                return;
            }
            System.out.println("Invalid coordinates, type again: ");
        }
    }

}
