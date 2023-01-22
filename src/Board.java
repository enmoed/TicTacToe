/**
 * An n*n board for games that use Marks
 */
public class Board {
    private static final int DEFAULT_SIZE = 4; // default board size
    private final int size; // size of board
    private Mark [][] board; // represents the marks on the board

    /**
     * Default constructor of board
     */
    public Board(){
        this.size = DEFAULT_SIZE;
        newBoard();
    }

    /**
     * Constructor of board
     * @param size int of size of board
     */
    public Board(int size){
        this.size = size;
        newBoard();
    }

    /**
     * Creates a new board representation
     */
    private void newBoard(){
        board = new Mark[size][size];
        for (int i=0; i < size; i++){
            for (int j=0; j < size; j++){
                board[i][j]= Mark.BLANK;
            }
        }
    }

    /**
     * @return int size of the board
     */
    public int getSize(){
        return size;
    }

    /**
     * @return Mark [][] board representation
     */
    public Mark[][] getBoard(){
        return board;
    }

    /**
     * Adds a Mark to the board
     * @param mark the type of mark to add to the board
     * @param row the row to add the mark
     * @param col the column to add the mark
     * @return boolean true upon success and otherwise false
     */
    public boolean putMark(Mark mark, int row, int col){
        if (inBoard(row, col) && getMark(row, col) == Mark.BLANK){
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    /**
     * @param row the row of the mark
     * @param col the column of the mark
     * @return the mark on the board at the given coordinates
     */
    public Mark getMark(int row, int col){
        if (inBoard(row, col)){
            return board[row][col];
        }
        return Mark.BLANK;
    }

    /**
     * checks if a set of coordinates is on the board
     * @param row the row of the coordinate
     * @param col the column of the coordinate
     * @return true upon coordinates being in the board and false otherwise
     */
    private boolean inBoard(int row, int col){
        return row >= 0 && col >= 0 && row < size && col < size;
    }

}
