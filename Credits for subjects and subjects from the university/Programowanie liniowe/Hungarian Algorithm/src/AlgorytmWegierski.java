import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class AlgorytmWegierski {

    private int[][] costMatrix;
    private int[] markedZeroInRow, markedZeroInCol, rowCovered, colCovered, starredZeroesInRow;

    public AlgorytmWegierski(int[][] costMatrix) {
        if (costMatrix.length != costMatrix[0].length) {
            throw new IllegalArgumentException("To nie jest kwadratowa macierz!");
        }

        this.costMatrix = costMatrix;
        markedZeroInRow = new int[costMatrix.length];
        markedZeroInCol = new int[costMatrix[0].length];
        rowCovered = new int[costMatrix.length];
        colCovered = new int[costMatrix[0].length];
        starredZeroesInRow = new int[costMatrix.length];
        Arrays.fill(starredZeroesInRow, -1);
        Arrays.fill(markedZeroInRow, -1);
        Arrays.fill(markedZeroInCol, -1);
    }

    public int[][] optimize() {
        reduceMatrix();
        markIndependentZeroes();
        coverColumnsWithMarkedZero();

        while (!allColumnsCovered()) {
            int[] primeZero = findAndStarZero();
            while (primeZero == null) {
                updateMatrix();
                primeZero = findAndStarZero();
            }
            if (markedZeroInRow[primeZero[0]] == -1) {
                starZero(primeZero);
                coverColumnsWithMarkedZero();
            } else {
                coverRowAndUncoverColumn(primeZero);
                updateMatrix();
            }
        }

        int[][] optimalAssignment = new int[costMatrix.length][];
        for (int i = 0; i < markedZeroInCol.length; i++) {
            optimalAssignment[i] = new int[]{i, markedZeroInCol[i]};
        }
        return optimalAssignment;
    }

    private boolean allColumnsCovered() {
        for (int i : colCovered) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    private void reduceMatrix() {
        for (int i = 0; i < costMatrix.length; i++) {
            int minValInRow = Arrays.stream(costMatrix[i]).min().getAsInt();
            for (int j = 0; j < costMatrix[i].length; j++) {
                costMatrix[i][j] -= minValInRow;
            }
        }

        for (int i = 0; i < costMatrix[0].length; i++) {
            int minValInCol = Integer.MAX_VALUE;
            for (int j = 0; j < costMatrix.length; j++) {
                minValInCol = Math.min(minValInCol, costMatrix[j][i]);
            }
            for (int j = 0; j < costMatrix.length; j++) {
                costMatrix[j][i] -= minValInCol;
            }
        }
    }

    private void markIndependentZeroes() {
        int[] rowHasMarkedZero = new int[costMatrix.length];
        int[] colHasMarkedZero = new int[costMatrix[0].length];

        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix.length; j++) {
                if (costMatrix[i][j] == 0 && rowHasMarkedZero[i] == 0 && colHasMarkedZero[j] == 0) {
                    rowHasMarkedZero[i] = 1;
                    colHasMarkedZero[j] = 1;
                    markedZeroInRow[i] = j;
                    markedZeroInCol[j] = i;
                }
            }
        }
    }

    private void coverColumnsWithMarkedZero() {
        Arrays.fill(colCovered, 0);
        for (int i = 0; i < markedZeroInCol.length; i++) {
            colCovered[i] = markedZeroInCol[i] != -1 ? 1 : 0;
        }
    }

    private void updateMatrix() {
        int minUncoveredValue = Integer.MAX_VALUE;
        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix[0].length; j++) {
                if (rowCovered[i] == 0 && colCovered[j] == 0) {
                    minUncoveredValue = Math.min(minUncoveredValue, costMatrix[i][j]);
                }
            }
        }

        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix[0].length; j++) {
                if (rowCovered[i] == 1 && colCovered[j] == 1) {
                    costMatrix[i][j] += minUncoveredValue;
                } else if (rowCovered[i] == 0 && colCovered[j] == 0) {
                    costMatrix[i][j] -= minUncoveredValue;
                }
            }
        }
    }

    private int[] findAndStarZero() {
        for (int i = 0; i < costMatrix.length; i++) {
            if (rowCovered[i] == 0) {
                for (int j = 0; j < costMatrix[i].length; j++) {
                    if (costMatrix[i][j] == 0 && colCovered[j] == 0) {
                        starredZeroesInRow[i] = j;
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    private void starZero(int[] primeZero) {
        Set<int[]> alternatingPath = new LinkedHashSet<>();
        alternatingPath.add(primeZero);
        boolean pathComplete = false;

        do {
            int[] lastZeroInPath = (int[]) alternatingPath.toArray()[alternatingPath.size() - 1];
            if (markedZeroInCol[lastZeroInPath[1]] != -1) {
                alternatingPath.add(new int[]{markedZeroInCol[lastZeroInPath[1]], lastZeroInPath[1]});
                pathComplete = true;
            } else {
                pathComplete = false;
            }

            if (!pathComplete) {
                break;
            }

            int i = markedZeroInCol[lastZeroInPath[1]];
            int j = starredZeroesInRow[i];
            if (j != -1) {
                alternatingPath.add(new int[]{i, j});
                pathComplete = true;
            } else {
                pathComplete = false;
            }

        } while (pathComplete);

        for (int[] zero : alternatingPath) {
            if (markedZeroInCol[zero[1]] == zero[0]) {
                markedZeroInCol[zero[1]] = -1;
                markedZeroInRow[zero[0]] = -1;
            }
            if (starredZeroesInRow[zero[0]] == zero[1]) {
                markedZeroInRow[zero[0]] = zero[1];
                markedZeroInCol[zero[1]] = zero[0];
            }
        }

        Arrays.fill(starredZeroesInRow, -1);
        Arrays.fill(rowCovered, 0);
        Arrays.fill(colCovered, 0);
    }

    private void coverRowAndUncoverColumn(int[] primeZero) {
        rowCovered[primeZero[0]] = 1;
        colCovered[markedZeroInRow[primeZero[0]]] = 0;
    }

    public static void main(String[] args) {
        final int[][] costMatrix = {
                {4, 13, 8, 7},
                {12, 2, 9, 11},
                {15, 12, 11, 14},
                {6, 13, 8, 22}
        };
        var copyOfCostMatrix = Arrays.stream(costMatrix).map(int[]::clone).toArray(int[][]::new);
        AlgorytmWegierski optimizer = new AlgorytmWegierski(costMatrix);
        int[][] assignment = optimizer.optimize();
        System.out.printf("Optymalne rozwiazanie: %s%n", Arrays.deepToString(assignment));
        int temp = 0;
        for (int i = 0; i < assignment.length; i++) {
            int cost = copyOfCostMatrix[assignment[i][0]][assignment[i][1]];
            System.out.printf("Koszt dla przypisania %s: %d%n", Arrays.toString(assignment[i]), cost);
            temp += cost;
        }
        System.out.printf("Calkowity koszt: %d%n", temp);
    }
}