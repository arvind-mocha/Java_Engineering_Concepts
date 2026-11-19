import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoundarySumTest {
    @Test
    void threeByThree() {
        assertEquals(40, ProblemSolving.boundarySum(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
    }

    @Test
    void rectangularMatrix() {
        assertEquals(65, ProblemSolving.boundarySum(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        }));
    }

    @Test
    void emptyMatrix() {
        assertEquals(0, ProblemSolving.boundarySum(new int[][]{}));
    }

    @Test
    void noColumns() {
        assertEquals(0, ProblemSolving.boundarySum(new int[][]{{}, {}}));
    }

    @Test
    void singleElementCountsOnce() {
        assertEquals(7, ProblemSolving.boundarySum(new int[][]{{7}}));
    }

    @Test
    void singleRowCountsEachPositionOnce() {
        assertEquals(10, ProblemSolving.boundarySum(new int[][]{{1, 2, 3, 4}}));
    }

    @Test
    void singleColumnCountsEachPositionOnce() {
        assertEquals(6, ProblemSolving.boundarySum(new int[][]{{1}, {2}, {3}}));
    }

    @Test
    void twoRowsAreEntirelyBoundary() {
        assertEquals(21, ProblemSolving.boundarySum(new int[][]{
                {1, 2, 3}, {4, 5, 6}
        }));
    }

    @Test
    void twoColumnsAreEntirelyBoundary() {
        assertEquals(21, ProblemSolving.boundarySum(new int[][]{
                {1, 2}, {3, 4}, {5, 6}
        }));
    }

    @Test
    void ignoresInteriorValues() {
        assertEquals(12, ProblemSolving.boundarySum(new int[][]{
                {1, 1, 1, 1}, {1, 100, -50, 1},
                {1, 200, 300, 1}, {1, 1, 1, 1}
        }));
    }

    @Test
    void negativeBoundaryValues() {
        assertEquals(-40, ProblemSolving.boundarySum(new int[][]{
                {-1, -2, -3}, {-4, 99, -6}, {-7, -8, -9}
        }));
    }

    @Test
    void doesNotModifyMatrix() {
        int[][] matrix = {{2, 9}, {8, 5}};
        assertEquals(24, ProblemSolving.boundarySum(matrix));
        assertArrayEquals(new int[]{2, 9}, matrix[0]);
        assertArrayEquals(new int[]{8, 5}, matrix[1]);
    }
}
