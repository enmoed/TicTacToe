/**
 * A class implementing the Player interface
 */
public class CleverPlayer implements Player {
    /**
     * Default constructor
     */
    public CleverPlayer(){}

    /**
     * Plays a turn according to CleverPlayer's strategy
     * @param board the board to play on
     * @param mark the mark of the player
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Mark [][] status = board.getBoard();
        for (int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                if (status[i][j] == Mark.BLANK){
                    board.putMark(mark, i, j);
                    return;
                }
            }
        }
    }
}
