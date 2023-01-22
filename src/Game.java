import java.util.Arrays;

/**
 * A two player game of TicTacToe
 */
public class Game {
    private static final int DEFAULT_STREAK = 3; // default streak to win the game
    private final Player playerX, playerO; // the two players playing
    private final Board board; // the game board
    private final int winStreak; // the streak to win the game
    private final Renderer renderer; // represents the game board to the user
    private Mark winner; // the winning mark of the game

    /**
     * Constructor creating a default game instance
     * @param playerX Player player1
     * @param playerO Player player2
     * @param renderer Renderer represents how the board should be shown to the user
     */
    public Game(Player playerX, Player playerO, Renderer renderer){
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        winStreak = DEFAULT_STREAK;
        board = new Board();

    }

    /**
     * Constructor creating a game instance
     * @param playerX Player player1
     * @param playerO Player player2
     * @param size int size of the board
     * @param winStreak int streak to win the game
     * @param renderer Renderer represents how the board should be shown to the user
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer){
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.winStreak = Math.min(winStreak, size);
        board = new Board(size);
    }

    /**
     * @return int streak to win the game
     */
    public int getWinStreak(){
        return winStreak;
    }

    /**
     * Runs the TicTacToe game
     * @return Mark that represents the winner of the game
     */
    public Mark run(){
        Player [] players = {playerX, playerO};
        Mark [] marks = {Mark.X, Mark.O};
        for (int turn = 0; playAnotherTurn(turn); turn++){
            players[turn % 2].playTurn(board, marks[turn % 2]);
            renderer.renderBoard(board);
        }
        return winner;
    }

    /**
     * Checks to see if there is another turn to be played
     * @param turn the amount of turns already played
     * @return boolean true if we should play another turn and false otherwise
     */
    private boolean playAnotherTurn(int turn){
        if (checkVerticalHorizontalWinner() || checkDiagonalWinner()){ //checks if there is winning sequence
            return false;
        }
        if (turn == Math.pow(board.getSize(), 2)) { //checks if board is full by comparing turn to board size
            winner = Mark.BLANK;
            return false;
        }
        return true;

    }

    /**
     * Checks if there is a diagonal sequence of size winStreak and declares winner if so
     * @return boolean true if there is a winner or false if not
     */
    private boolean checkDiagonalWinner(){
        return checkRightToLeftDiagonalWinner() || checkLeftToRightDiagonalWinner();
    }

    /**
     * Checks if there is a vertical or horizontal sequence of size winStreak and declares winner if so
     * @return boolean true if there is a winner or false if not
     */
    private boolean checkVerticalHorizontalWinner() {
        for (int direction = 0; direction<2; direction++) { // two iterations to check rows then columns
            for (int i = 0; i < board.getSize(); i++) { // outer loop of board
                Mark streakMark = Mark.BLANK;
                int streak = 1;
                for (int j = 0; j < board.getSize(); j++) { // inner loop of board
                    // direction determines if we are checking rows or columns
                    Mark currentMark = direction == 0 ? board.getMark(i, j) : board.getMark(j, i);
                    // check if the current mark is not blank and equal to the previous mark
                    if (currentMark == streakMark && streakMark != Mark.BLANK) {
                        streak++; // add to streak
                        if (streak == getWinStreak()) { // streak length is equal to winStreak
                            winner = streakMark;
                            return true; // there is a winner
                        }
                    } else { // start over the streak
                        streakMark = currentMark;
                        streak = 1;
                    }
                }
            }
        }
        return false; // there is not a winner
    }

    /**
     * Checks if there is a top left to bottom right sequence of size winStreak and declares winner if so
     * @return boolean true if there is a winner or false if not
     */
    private boolean checkLeftToRightDiagonalWinner() {
        int [] streak = new int[board.getSize()];
        Arrays.fill(streak, 1); // an array to track the streak of the diagonal ending in each index
        for (int i = 0; i < board.getSize(); i++){ // outer row loop
            for (int j = board.getSize()-1; j > 0; j--){ // inner column loop reviews from right to left
                if (board.getMark(i, j) == board.getMark(i-1, j-1) &&
                        board.getMark(i, j) != Mark.BLANK){
                    //updates streak by incrementing the streak in the previous index from the previous round
                    streak[j] = streak[j-1]+1;
                    if (streak[j] == getWinStreak()){
                        winner = board.getMark(i, j);
                        return true; // there is a winner
                    }
                }
                else {
                    streak[j] = 1;
                }
            }
        }
        return false; // there is no winner
    }

    /**
     * Checks if there is a top right to bottom left sequence of size winStreak and declares winner if so
     * @return boolean true if there is a winner or false if not
     */
    private boolean checkRightToLeftDiagonalWinner() {
        int [] streak = new int[board.getSize()];
        Arrays.fill(streak, 1); // an array to track the streak of the diagonal ending in each index
        for (int i = 0; i < board.getSize(); i++){ //outer row loop
            for (int j = 0; j < board.getSize()-1; j++){ //inner column loop
                if (board.getMark(i, j) == board.getMark(i-1, j+1) &&
                        board.getMark(i, j) != Mark.BLANK){
                    //updates streak by incrementing the streak in the following index from the previous round
                    streak[j] = streak[j+1]+1;
                    if (streak[j] == getWinStreak()){
                        winner = board.getMark(i, j);
                        return true; // there is a winner
                    }
                }
                else {
                    streak[j] = 1;
                }
            }
        }
        return false; // there is no winner
    }

}
