/**
 * interface of Player object
 */
public interface Player {
    /**
     * Plays a turn according to player strategy
     * @param board the board to play on
     * @param mark the mark of the player
     */
    void playTurn(Board board, Mark mark);
}
