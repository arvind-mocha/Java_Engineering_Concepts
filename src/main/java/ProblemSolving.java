import java.util.HashSet;
import java.util.List;

public class ProblemSolving {
    public static void invokeProblems() {
        // findLargestExample();
        // countOccurrencesExample();
        // reverseArrayExample();
        // isSortedExample();
         // moveZerosExample();
        // rotateRightExample();
        // removeDuplicatesExample();
        // containsDuplicateExample();
        // mainDiagonalSumExample();
        // secondaryDiagonalSumExample();
        // isDiagonalMatrixExample();
        // transposeMatrixExample();
        // rotateMatrixClockwiseExample();
        // boundarySumExample();
        spiralOrderExample();
    }

    public static void spiralOrderExample() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Spiral order: " + spiralOrder(matrix));
        // Expected output: Spiral order: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }

    /**
     * Problem 16: Return the matrix elements in clockwise spiral order.
     * Start at the top-left, move right across the top, down the right side,
     * left across the bottom, and up the left side. Continue inward.
     * Visit each position exactly once, including repeated values.
     * Use loops and an ArrayList<Integer> to collect the result.
     * You may add import java.util.ArrayList; to use it.
     * Do not modify the matrix or use streams or a visited array.
     * Aim for O(rows * columns) time and O(1) extra space apart from
     * the returned list. The result itself takes O(rows * columns) space.
     * Assume matrix and its rows are non-null and all rows have equal length.
     * The matrix may be rectangular. Return an empty list for no rows or columns.
     * Examples:
     * [[1, 2], [3, 4]] -> [1, 2, 4, 3]
     * [[1, 2, 3]] -> [1, 2, 3]
     * [] -> []
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        // TODO: Write your solution here.
        throw new UnsupportedOperationException("Implement spiralOrder");
    }

    public static void boundarySumExample() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("Boundary sum: " + boundarySum(matrix));
        // Boundary: 1, 2, 3, 4, 5, 8, 9, 10, 11, 12
        // Expected output: Boundary sum: 65
    }

    /**
     * Problem 15: Return the sum of the elements on a matrix's outer boundary.
     * A position is on the boundary if it is in the first or last row,
     * or the first or last column. Count each position only once,
     * including corners and positions in single-row or single-column matrices.
     * Unlike earlier problems, this matrix may be rectangular.
     * Use loops, no streams, and O(1) extra space. Do not modify the matrix.
     * A full scan is acceptable; optionally aim for O(rows + columns) time.
     * Assume matrix and its rows are non-null, all rows have the same length,
     * and all sums fit in an int. Return 0 if there are no rows or no columns.
     * Examples:
     * [[1, 2, 3], [4, 5, 6], [7, 8, 9]] -> 40 (exclude the center 5)
     * [[1, 2, 3]] -> 6
     * [[1], [2], [3]] -> 6
     */
    public static int boundarySum(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int sum = 0;

        // Sum the top and bottom rows; a single row counts only once.
        for (int column = 0; column < columns; column++) {
            sum += matrix[0][column];
            if (rows > 1) {
                sum += matrix[rows - 1][column];
            }
        }

        // Sum the sides, excluding corners already counted above.
        for (int row = 1; row < rows - 1; row++) {
            sum += matrix[row][0];
            if (columns > 1) {
                sum += matrix[row][columns - 1];
            }
        }

        return sum;
    }

    public static void rotateMatrixClockwiseExample() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrixClockwise(matrix);
        System.out.println("Matrix rotated 90 degrees clockwise:");
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
        // Expected rows: [7, 4, 1], [8, 5, 2], [9, 6, 3]
    }

    /**
     * Problem 14: Rotate a square matrix 90 degrees clockwise in place.
     * The original top row becomes the rightmost column, top to bottom.
     * Modify the original matrix; this method returns nothing.
     * Use loops and O(1) extra space: no extra arrays, collections,
     * streams, or library methods that move elements. Aim for O(n * n) time.
     * You may reuse your existing methods from earlier problems.
     * Assume matrix and its rows are non-null, every row has n elements,
     * and rows are separate arrays, where n is the number of rows.
     * Empty and single-element matrices remain unchanged.
     * Examples:
     * [[1, 2], [3, 4]] -> [[3, 1], [4, 2]]
     * [[7]] -> [[7]]
     * [] -> []
     */
    public static void rotateMatrixClockwise(int[][] matrix) {
        int size = matrix.length;
        for(int i=0; i<size;i++){
            for(int j=i+1;j<size;j++){
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }

        for(int[] row :matrix){
            int len = row.length-1;
            for (int i = 0; i<row.length/2; i++){
                int swap = row[i];
                row[i] = row[len];
                row[len] = swap;
                len --;
            }
        }
    }

    public static void transposeMatrixExample() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        transposeMatrix(matrix);
        System.out.println("Transposed matrix:");
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
        // Expected rows: [1, 4, 7], [2, 5, 8], [3, 6, 9]
    }

    /**
     * Problem 13: Transpose a square matrix in place.
     * Rows become columns: the value originally at [row][column]
     * must end up at [column][row]. Main-diagonal values stay in place.
     * Modify the original matrix; this method returns nothing.
     * Use loops and O(1) extra space, with no extra arrays, collections,
     * streams, or library methods that move elements. Aim for O(n * n) time.
     * Assume matrix and its rows are non-null, every row has n elements,
     * and rows are separate arrays, where n is the number of rows.
     * Empty and single-element matrices remain unchanged.
     * Examples:
     * [[1, 2], [3, 4]] -> [[1, 3], [2, 4]]
     * [[7]] -> [[7]]
     * [] -> []
     */
    public static void transposeMatrix(int[][] matrix) {
        int size = matrix.length;
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                int swapRow = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swapRow;
            }
        }
    }

    public static void isDiagonalMatrixExample() {
        int[][] matrix = {
                {4, 0, 0},
                {0, 7, 0},
                {0, 0, 2}
        };
        System.out.println("Is diagonal matrix: " + isDiagonalMatrix(matrix));
        // Expected output: Is diagonal matrix: true
    }

    /**
     * Problem 12: Return true if every element outside the main diagonal is zero.
     * Main-diagonal elements may be positive, negative, or zero.
     * Use loops without streams or extra arrays. Do not modify the matrix.
     * Aim for O(n * n) time and O(1) extra space, where n is the row count.
     * Assume matrix and its rows are non-null and every row has n elements.
     * Empty and single-element matrices return true.
     * Examples:
     * [[4, 0], [0, 7]] -> true
     * [[4, 3], [0, 7]] -> false
     * [[0, 0], [0, 0]] -> true
     */
    public static boolean isDiagonalMatrix(int[][] matrix) {
        int size = matrix.length;

        for(int i=0; i<size;i++){
            for(int j=0; j<size; j++){
                if((i != j && matrix[i][j] != 0)){
                    return false;
                }
            }
        }

        return true;
    }


    public static void secondaryDiagonalSumExample() {
        int[][] matrix = {
                {1, 2, 8},
                {4, 5, 6},
                {3, 7, 9}
        };
        System.out.println("Secondary diagonal sum: " + secondaryDiagonalSum(matrix));
        // Secondary diagonal: 8, 5, 3
        // Expected output: Secondary diagonal sum: 16
    }

    /**
     * Problem 10: Return the sum of the secondary diagonal of a square matrix.
     * This diagonal runs from the top-right to the bottom-left.
     * As the row index increases, the column index decreases.
     * Use a single loop, O(n) time, and O(1) extra space, where n is
     * the number of rows. Do not modify the matrix or use streams.
     * Assume matrix and its rows are non-null, every row has n elements,
     * and the diagonal sum fits in an int. An empty matrix returns 0.
     * Examples:
     * [[1, 7], [3, 4]] -> 10 (7 + 3)
     * [[7]] -> 7
     * [] -> 0
     */
    public static int secondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int counter = 0;
        for(int i=matrix.length-1; i>=0; i--){
            sum = sum + matrix[i][counter];
            counter ++;
        }
        return sum;
    }

    public static void mainDiagonalSumExample() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Main diagonal sum: " + mainDiagonalSum(matrix));
        // Main diagonal: 1, 5, 9
        // Expected output: Main diagonal sum: 15
    }

    /**
     * Problem 9: Return the sum of the main diagonal of a square matrix.
     * The main diagonal runs from the top-left to the bottom-right.
     * In Java, matrix[row][column] accesses one element.
     * On the main diagonal, the row and column indices are equal.
     * Use a single loop, O(n) time, and O(1) extra space, where n is
     * the number of rows. Do not modify the matrix or use streams.
     * Assume matrix and its rows are non-null, every row has n elements,
     * and the diagonal sum fits in an int. An empty matrix returns 0.
     * Examples:
     * [[1, 2], [3, 4]] -> 5 (1 + 4)
     * [[7]] -> 7
     * [] -> 0
     */
    public static int mainDiagonalSum(int[][] matrix) {
        // TODO: Write your solution here.
        int size = matrix.length;
        int sum = 0;
       for(int i=0; i<size;i++){
           sum = sum+matrix[i][i];
       }
       return sum;
    }

    public static void containsDuplicateExample() {
        int[] numbers = {4, 1, 7, 4, 2};
        System.out.println("Contains duplicate: " + containsDuplicate(numbers));
        // Expected output: Contains duplicate: true
    }

    /**
     * Problem 8: Return true if any number appears more than once.
     * The array is NOT necessarily sorted. Do not modify it.
     * Use a loop and a java.util.HashSet<Integer>; no sorting or streams.
     * A HashSet stores unique values and supports add() and contains().
     * Aim for O(n) expected time and O(n) extra space.
     * numbers is non-null, but it may be empty.
     * Examples:
     * [4, 1, 7, 4, 2] -> true
     * [4, 1, 7, 2] -> false
     * [] -> false
     */
    public static boolean containsDuplicate(int[] numbers) {
        if(numbers.length < 2) return false;

        HashSet<Integer> hashset = new HashSet<>();
        for(int i=0; i<numbers.length;i++){
            if(hashset.contains(numbers[i])) return true;
            hashset.add(numbers[i]);
        }
        return false;
    }

    public static void removeDuplicatesExample() {
        int[] numbers = {1, 1, 2, 2, 3, 4, 4};
        int uniqueCount = removeDuplicates(numbers);
        System.out.println("Unique count: " + uniqueCount);
        System.out.print("Unique elements: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        // Expected: Unique count: 4
        //           Unique elements: 1 2 3 4
    }

    /**
     * Problem 7: Remove duplicates from a sorted array in place.
     * Put each distinct value once at the front, in ascending order,
     * and return the number of unique elements (k).
     * Only the first k positions matter; remaining values are ignored.
     * Java arrays cannot shrink: keep the original array length.
     * Use a loop and O(1) extra space: no second array, collections,
     * streams, or library methods that move elements. Aim for O(n) time.
     * numbers is non-null and sorted in ascending order; it may be empty.
     * Examples:
     * [1, 1, 2, 2, 3] -> return 3; first 3 elements: [1, 2, 3]
     * [5, 5, 5] -> return 1; first element: [5]
     * [] -> return 0
     */
    public static int removeDuplicates(int[] numbers) {
        if(numbers.length == 0) return 0;

        int count = 1;
        int val = numbers[0];
        for(int i=1; i<numbers.length;i++){
            if(numbers[i] != val){
                val = numbers[i];
                numbers[count] = val;
                count++;
            }
        }
        return count;
    }

    public static void rotateRightExample() {
        int[] numbers = {1, 2, 3, 4, 5};
        rotateRight(numbers);
        System.out.println("Rotated array: " + java.util.Arrays.toString(numbers));
        // Expected output: Rotated array: [5, 1, 2, 3, 4]
    }

    /**
     * Problem 6: Rotate the array one position to the right.
     * The last element becomes the first; every other element moves
     * one position to the right. Modify the original array in place.
     * Empty and single-element arrays remain unchanged.
     * Use a loop and O(1) extra space: no second array, collections,
     * streams, or library methods that move elements. Aim for O(n) time.
     * You can assume numbers is non-null.
     * Examples:
     * [1, 2, 3, 4, 5] -> [5, 1, 2, 3, 4]
     * [8, 3] -> [3, 8]
     * [] -> []
     */
    public static void rotateRight(int[] numbers) {
        if(numbers.length < 2) return;
        int last = numbers[numbers.length-1];
        for(int i=numbers.length-2; i>=0;i--){
            numbers[i+1] = numbers[i];
        }
        numbers[0] = last;
    }

    public static void moveZerosExample() {
        int[] numbers = {0, 1, 0, 3, 12};
        moveZeros(numbers);
        System.out.println("Zeros moved: " + java.util.Arrays.toString(numbers));
        // Expected output: Zeros moved: [1, 3, 12, 0, 0]
    }

    /**
     * Problem 5: Move every zero to the end of the original array.
     * Keep non-zero elements in their original relative order.
     * Modify numbers in place; this method returns nothing.
     * Use loops and O(1) extra space: no second array, sorting, streams,
     * or collections. Aim for O(n) time.
     * You can assume numbers is non-null, but it may be empty.
     * Examples:
     * [0, 1, 0, 3, 12] -> [1, 3, 12, 0, 0]
     * [4, 0, -2, 0, 4] -> [4, -2, 4, 0, 0]
     * [] -> []
     */
    public static void moveZeros(int[] numbers) {
        int destinationLocation = 0;
        for(int i=0; i<numbers.length;i++){
            if(numbers[i] != 0){
                if(i != destinationLocation){
                    numbers[destinationLocation] = numbers[i];
                    numbers[i] = 0;
                }
                destinationLocation ++;
            }
        }
    }

    public static void isSortedExample() {
        int[] numbers = {1, 2, 2, 4, 7};
        System.out.println("Is sorted: " + isSorted(numbers));
        // Expected output: Is sorted: true
    }

    /**
     * Problem 4: Return true if the array is sorted in ascending order
     * (each element is greater than or equal to the previous element).
     * Equal values are allowed. Empty and single-element arrays are sorted.
     * Use a loop without sorting, streams, or collections.
     * Do not modify the array. You can assume numbers is non-null.
     * Examples:
     * [1, 2, 2, 4, 7] -> true
     * [1, 4, 3, 7] -> false
     * [] -> true
     */
    public static boolean isSorted(int[] numbers) {
        int i=0;
        if(numbers.length < 2){
            return true;
        }

        while (numbers[i] <= numbers[i+1]){
            i++;
            if (i == numbers.length-1){
                return true;
            }
        }

        return false;
    }

    public static void reverseArrayExample() {
        int[] numbers = {1, 2, 3, 4, 5};
        reverseArray(numbers);
        System.out.println("Reversed array: " + java.util.Arrays.toString(numbers));
        // Expected output: Reversed array: [5, 4, 3, 2, 1]
    }

    /**
     * Problem 3: Reverse the order of elements in the original array.
     * This method returns nothing; modify numbers directly (in place).
     * Use a loop and O(1) extra space: no second array, collections, or streams.
     * You can assume numbers is non-null, but it may be empty.
     * Examples:
     * [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
     * [8, 3] -> [3, 8]
     * [] -> []
     */
    public static void reverseArray(int[] numbers) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int temp = numbers[leftIndex];
            numbers[leftIndex] = numbers[rightIndex];
            numbers[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }

    public static void countOccurrencesExample() {
        int[] numbers = {3, 7, 3, 9, 3, 4};
        int target = 3;
        System.out.println("Occurrences: " + countOccurrences(numbers, target));
        // Expected output: Occurrences: 3
    }

    /**
     * Problem 2: Return how many times target appears in numbers.
     * Use a loop without streams or collections.
     * You can assume numbers is non-null, but it may be empty.
     * Examples:
     * [3, 7, 3, 9, 3, 4], target 3 -> 3
     * [1, 2, 4], target 3 -> 0
     * [], target 3 -> 0
     */
    public static int countOccurrences(int[] numbers, int target) {
        int counter = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == target){
                counter ++;
            }
        }
        return counter;
    }

    public static void findLargestExample() {
        int[] numbers = {3, 7, 2, 9, 4};
        System.out.println("Largest number: " + findLargest(numbers));
        // Expected output: Largest number: 9
    }

    /**
     * Problem 1: Return the largest number in a non-empty array.
     * Use a loop without sorting or streams.
     * You can assume numbers is non-null and contains at least one element.
     */
    public static int findLargest(int[] numbers) {
        if (numbers.length == 0) return 0;
        int largestNumber = numbers[0];
        for (int number : numbers) {
            largestNumber = Math.max(largestNumber, number);
        }
        return largestNumber;
    }
}
