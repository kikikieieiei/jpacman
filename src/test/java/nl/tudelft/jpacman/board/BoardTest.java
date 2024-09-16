package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the Board class.
 */
class BoardTest {

    private Board board;
    private Square[][] grid;

    @BeforeEach
    void setUp() {
        grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        board = new Board(grid);
    }

    @Test
    void testBoardConstruction() {
        assertThat(board).isNotNull();
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
    }

    @Test
    void testSquareAt() {
        Square square = board.squareAt(0, 0);
        assertThat(square).isNotNull();
    }

    @Test
    void testBoardWithNullSquare() {
        // Create a grid with a null square
        Square[][] gridWithNull = new Square[1][1];
        gridWithNull[0][0] = null; // Assigning the null square

        // Assert that the Board constructor throws an AssertionError due to null square
        assertThrows(AssertionError.class, () -> new Board(gridWithNull), "Initial grid cannot contain null squares");
    }

}
