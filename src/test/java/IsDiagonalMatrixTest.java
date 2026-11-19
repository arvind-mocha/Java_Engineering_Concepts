import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsDiagonalMatrixTest {
    @Test
    void validDiagonalMatrix() {
        assertTrue(ProblemSolving.isDiagonalMatrix(new int[][]{
                {4, 0, 0}, {0, 7, 0}, {0, 0, 2}
        }));
    }

    @Test
    void emptyMatrix() {
        assertTrue(ProblemSolving.isDiagonalMatrix(new int[][]{}));
    }

    @Test
    void singleElement() {
        assertTrue(ProblemSolving.isDiagonalMatrix(new int[][]{{-7}}));
    }

    @Test
    void allZeros() {
        assertTrue(ProblemSolving.isDiagonalMatrix(new int[][]{
                {0, 0}, {0, 0}
        }));
    }

    @Test
    void zeroAllowedOnMainDiagonal() {
        assertTrue(ProblemSolving.isDiagonalMatrix(new int[][]{
                {4, 0, 0}, {0, 0, 0}, {0, 0, 2}
        }));
    }

    @Test
    void negativeDiagonalValues() {
        assertTrue(ProblemSolving.isDiagonalMatrix(new int[][]{
                {-4, 0}, {0, -7}
        }));
    }

    @Test
    void nonZeroAboveMainDiagonal() {
        assertFalse(ProblemSolving.isDiagonalMatrix(new int[][]{
                {4, 3, 0}, {0, 7, 0}, {0, 0, 2}
        }));
    }

    @Test
    void nonZeroBelowMainDiagonal() {
        assertFalse(ProblemSolving.isDiagonalMatrix(new int[][]{
                {4, 0, 0}, {3, 7, 0}, {0, 0, 2}
        }));
    }

    @Test
    void secondaryDiagonalIsNotMainDiagonal() {
        assertFalse(ProblemSolving.isDiagonalMatrix(new int[][]{
                {0, 0, 4}, {0, 7, 0}, {2, 0, 0}
        }));
    }

    @Test
    void negativeOutsideMainDiagonal() {
        assertFalse(ProblemSolving.isDiagonalMatrix(new int[][]{
                {4, 0}, {-1, 7}
        }));
    }

    @Test
    void checksLastRowAndColumn() {
        assertFalse(ProblemSolving.isDiagonalMatrix(new int[][]{
                {4, 0, 0}, {0, 7, 0}, {0, 9, 2}
        }));
        assertFalse(ProblemSolving.isDiagonalMatrix(new int[][]{
                {4, 0, 0}, {0, 7, 9}, {0, 0, 2}
        }));
    }

    @Test
    void doesNotModifyMatrix() {
        int[][] matrix = {{4, 3}, {0, 7}};
        assertFalse(ProblemSolving.isDiagonalMatrix(matrix));
        assertArrayEquals(new int[]{4, 3}, matrix[0]);
        assertArrayEquals(new int[]{0, 7}, matrix[1]);
    }
}
