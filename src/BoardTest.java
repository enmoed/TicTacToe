import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board boardDefault;
    Board boardSizeTwo;
    Board boardSizeNine;
    Board[] boards;

    @BeforeEach
    void setUp() {
        boardDefault = new Board();
        boardSizeTwo = new Board(2);
        boardSizeNine = new Board(9);
        boards = new Board[]{boardDefault, boardSizeTwo, boardSizeNine};

    }

    @Test
    void getSize() {
        assertEquals(boardDefault.getSize(), 4);
        assertEquals(boardSizeTwo.getSize(), 2);
        assertEquals(boardSizeNine.getSize(), 9);
    }

    @Test
    void getBoard() {
        assertEquals(boardDefault.getSize(), 4);
        assertEquals(boardSizeTwo.getSize(), 2);
        assertEquals(boardSizeNine.getSize(), 9);
    }

    @Test
    void putThenGetMark() {
        for (Board board : boards) {
            for (int i = 0; i < board.getSize(); i++) {
                for (int j = 0; j < board.getSize(); j++) {
                    assertTrue(board.putMark(Mark.X, i, j));
                    assertFalse(board.putMark(Mark.X, i, j));
                    assertFalse(board.putMark(Mark.X, i + board.getSize(), j + board.getSize()));
                    assertFalse(board.putMark(Mark.X, -i, -j));
                }
            }
        }
        for (Board board : boards){
            for (int i=0;i<board.getSize();i++) {
                for (int j=0;j<board.getSize();j++) {
                    assertEquals(board.getMark(i, j), Mark.X);
                    assertEquals(board.getMark(i + board.getSize(), j + board.getSize()), Mark.BLANK);
                    assertEquals(board.getMark(-i-1, -j), Mark.BLANK);
                }
            }
        }
    }
}
