import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralOrderTest {
    @Test
    void threeByThree() {
        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5),
                ProblemSolving.spiralOrder(new int[][]{
                        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                }));
    }

    @Test
    void wideRectangle() {
        assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                ProblemSolving.spiralOrder(new int[][]{
                        {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
                }));
    }

    @Test
    void tallRectangle() {
        assertEquals(List.of(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8),
                ProblemSolving.spiralOrder(new int[][]{
                        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}
                }));
    }

    @Test
    void fourByFour() {
        assertEquals(List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10),
                ProblemSolving.spiralOrder(new int[][]{
                        {1, 2, 3, 4}, {5, 6, 7, 8},
                        {9, 10, 11, 12}, {13, 14, 15, 16}
                }));
    }

    @Test
    void emptyMatrix() {
        assertEquals(List.of(), ProblemSolving.spiralOrder(new int[][]{}));
    }

    @Test
    void noColumns() {
        assertEquals(List.of(), ProblemSolving.spiralOrder(new int[][]{{}, {}}));
    }

    @Test
    void singleElement() {
        assertEquals(List.of(7), ProblemSolving.spiralOrder(new int[][]{{7}}));
    }

    @Test
    void singleRow() {
        assertEquals(List.of(1, 2, 3, 4), ProblemSolving.spiralOrder(new int[][]{{1, 2, 3, 4}}));
    }

    @Test
    void singleColumn() {
        assertEquals(List.of(1, 2, 3), ProblemSolving.spiralOrder(new int[][]{{1}, {2}, {3}}));
    }

    @Test
    void twoRows() {
        assertEquals(List.of(1, 2, 3, 6, 5, 4), ProblemSolving.spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}
        }));
    }

    @Test
    void twoColumns() {
        assertEquals(List.of(1, 2, 4, 6, 5, 3), ProblemSolving.spiralOrder(new int[][]{
                {1, 2}, {3, 4}, {5, 6}
        }));
    }

    @Test
    void negativesZerosAndDuplicatesWithoutModifyingInput() {
        int[][] matrix = {{0, -1, 0}, {2, -3, 2}, {0, -1, 0}};
        assertEquals(List.of(0, -1, 0, 2, 0, -1, 0, 2, -3), ProblemSolving.spiralOrder(matrix));
        assertArrayEquals(new int[]{0, -1, 0}, matrix[0]);
        assertArrayEquals(new int[]{2, -3, 2}, matrix[1]);
        assertArrayEquals(new int[]{0, -1, 0}, matrix[2]);
    }
}
