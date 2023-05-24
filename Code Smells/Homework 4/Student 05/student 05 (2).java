import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class BoardTest {

    @Test
    public void testPlayerAt() {
        Board board = new Board(10);
        assertNull(board.playerAt(0, 0));
        board.play(new Board.Place(0, 0));
        assertEquals(Board.Player.BLACK, board.playerAt(0, 0));
    }

    @Test
    public void testIsWonByHorizontal() {
        Board board = new Board(10);
        assertFalse(board.isWonBy(Board.Player.BLACK));
        for (int i = 0; i < 5; i++) {
            board.play(new Board.Place(i, 0));
        }
        assertTrue(board.isWonBy(Board.Player.BLACK));
    }

    @Test
    public void testIsWonByVertical() {
        Board board = new Board(10);
        assertFalse(board.isWonBy(Board.Player.WHITE));
        for (int i = 0; i < 5; i++) {
            board.play(new Board.Place(0, i));
        }
        assertTrue(board.isWonBy(Board.Player.WHITE));
    }

    @Test
    public void testIsWonByDiagonal() {
        Board board = new Board(10);
        assertFalse(board.isWonBy(Board.Player.BLACK));
        board.play(new Board.Place(0, 0));
        board.play(new Board.Place(1, 1));
        board.play(new Board.Place(2, 2));
        board.play(new Board.Place(3, 3));
        board.play(new Board.Place(4, 4));
        assertTrue(board.isWonBy(Board.Player.BLACK));
    }

    @Test
    public void testWinningRowHorizontal() {
        Board board = new Board(10);
        assertNull(board.winningRow());
        for (int i = 0; i < 5; i++) {
            board.play(new Board.Place(i, 0));
        }
        List<Board.Place> winningRow = board.winningRow();
        assertNotNull(winningRow);
        assertEquals(5, winningRow.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(new Board.Place(i, 0), winningRow.get(i));
        }
    }

    @Test
    public void testWinningRowVertical() {
        Board board = new Board(10);
        assertNull(board.winningRow());
        for (int i = 0; i < 5; i++) {
            board.play(new Board.Place(0, i));
        }
        List<Board.Place> winningRow = board.winningRow();
        assertNotNull(winningRow);
        assertEquals(5, winningRow.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(new Board.Place(0, i), winningRow.get(i));
        }
    }

    @Test
    public void testWinningRowDiagonal() {
        Board board = new Board(10);
        assertNull(board.winningRow());
        board.play(new Board.Place(0, 0));
        board.play(new Board.Place(1, 1));
        board.play(new Board.Place(2, 2));
        board.play(new Board.Place(3, 3));
        board.play(new Board.Place(4, 4));
        List<Board.Place> winningRow = board.winningRow();
        assertNotNull(winningRow);
        assertEquals(5, winningRow.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(new Board.Place(i, i), winningRow.get(i));
        }
    }
}

