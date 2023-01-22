import java.util.Random;

/**
 * A class implementing the Player interface
 */
public class GeniusPlayer implements Player {
    /**
     * Default constructor
     */
    public GeniusPlayer(){}

    /**
     * Plays a turn according to GeniusPlayer's strategy
     * @param board the board to play on
     * @param mark the mark of the player
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Mark [][] status = board.getBoard();
        Random random = new Random();
        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                int randomNumber = random.nextInt(j+1);
                if (status[i][randomNumber] == Mark.BLANK) {
                    board.putMark(mark, i, j);
                    return;
                }
            }
        }
    }
}
