import java.util.Random;

/**
 * A class implementing the Player interface
 */
public class WhateverPlayer implements Player  {
    /**
     * Default constructor
     */
    public WhateverPlayer(){}

    /**
     * Plays a turn according to WhateverPlayer's strategy
     * @param board the board to play on
     * @param mark the mark of the player
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        int x = random.nextInt(board.getSize());
        int y = random.nextInt(board.getSize());
        board.putMark(mark, x, y);
    }
}
