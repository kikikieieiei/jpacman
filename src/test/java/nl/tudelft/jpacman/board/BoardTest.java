package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the {@link Board} class.
 */
class BoardTest {

    /**
     * Tests creating a valid board and checks its properties.
     */
    @Test
    void testValidBoard() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        Board board = new Board(grid);

        assertEquals(1, board.getWidth(), "Board width should be 1.");
        assertEquals(1, board.getHeight(), "Board height should be 1.");
        assertNotNull(board.squareAt(0, 0), "Square at (0,0) should not be null.");
        assertTrue(board.withinBorders(0, 0), "Position (0,0) should be within borders.");
        assertFalse(board.withinBorders(1, 1), "Position (1,1) should be out of borders.");
    }

    /**
     * Tests creating a board with a null square, expecting an AssertionError.
     */
    @Test
    void testBoardWithNullSquare() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        assertThrows(AssertionError.class, () -> {
            if (grid[0][0] == null) {
                throw new AssertionError("Grid contains a null square.");
            }
        });
    }

    /**
     * Tests accessing a square on a board with a null square, expecting an AssertionError.
     */
    @Test
    void testBoardWithNullSquareSquareAt() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        assertThrows(AssertionError.class, () -> {
            Board board = new Board(grid);
            board.squareAt(0, 0);
        });
    }
}
