import java.util.Arrays;

public class ProblemSolver {

    static int MAX = 1000;

    public static void main(String[] args) {
        int[][] matrix = {{3, 1, 7, 4}, {2, 6, 5, 9}, {8, 3, 3, 2}};
        int[] source = {300, 400, 500};
        int[] target = {250, 350, 400, 200};

        int result = solveProblem(matrix, source, target);
        System.out.println("Rozwiązanie to: " + result);
    }

    public static int solveProblem(int[][] matrix, int[] source, int[] target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = {0};

        while (Arrays.stream(source).sum() > 0 && Arrays.stream(target).sum() > 0) {
            int[] rowDifferences = new int[rows];
            int[] colDifferences = new int[cols];

            calculateDifferences(matrix, rowDifferences, colDifferences);

            int maxRowDiff = Arrays.stream(rowDifferences).max().getAsInt();
            int maxColDiff = Arrays.stream(colDifferences).max().getAsInt();

            if (maxRowDiff >= maxColDiff) {
                handleRow(matrix, source, target, rows, cols, rowDifferences, maxRowDiff, result);
            } else {
                handleColumn(matrix, source, target, rows, cols, colDifferences, maxColDiff, result);
            }
        }
        return result[0];
    }

    public static void handleRow(int[][] matrix, int[] source, int[] target, int rows, int cols, int[] rowDifferences, int maxRowDiff, int[] result) {
        for (int i = 0; i < rows; i++) {
            if (rowDifferences[i] == maxRowDiff) {
                int minVal = Arrays.stream(matrix[i]).min().getAsInt();
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == minVal) {
                        int minVal2 = Math.min(source[i], target[j]);
                        result[0] += minVal2 * minVal;
                        source[i] -= minVal2;
                        target[j] -= minVal2;
                        if (target[j] == 0) {
                            for (int r = 0; r < rows; r++) {
                                matrix[r][j] = MAX;
                            }
                        } else {
                            Arrays.fill(matrix[i], MAX);
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void handleColumn(int[][] matrix, int[] source, int[] target, int rows, int cols, int[] colDifferences, int maxColDiff, int[] result) {
        for (int j = 0; j < cols; j++) {
            if (colDifferences[j] == maxColDiff) {
                int finalJ = j;
                int minVal = Arrays.stream(matrix).mapToInt(row -> row[finalJ]).min().getAsInt();
                for (int i = 0; i < rows; i++) {
                    if (matrix[i][j] == minVal) {
                        int minVal2 = Math.min(source[i], target[j]);
                        result[0] += minVal2 * minVal;
                        source[i] -= minVal2;
                        target[j] -= minVal2;
                        if (target[j] == 0) {
                            for (int r = 0; r < rows; r++) {
                                matrix[r][j] = MAX;
                            }
                        } else {
                            Arrays.fill(matrix[i], MAX);
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void calculateDifferences(int[][] matrix, int[] rowDifferences, int[] colDifferences) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.copyOf(matrix[i], matrix[i].length);
            Arrays.sort(arr);
            rowDifferences[i] = arr[1] - arr[0];
        }

        for (int col = 0; col < matrix[0].length; col++) {
            int[] arr = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                arr[i] = matrix[i][col];
            }
            Arrays.sort(arr);
            colDifferences[col] = arr[1] - arr[0];
        }
    }
}