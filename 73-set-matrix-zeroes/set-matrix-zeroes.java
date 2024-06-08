public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isRow0 = false, isCol0 = false;

        // Check if first row has any zeros
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isRow0 = true;
                break;
            }
        }

        // Check if first column has any zeros
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isCol0 = true;
                break;
            }
        }

        // Mark zeros in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Use marks to set elements to zero
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Update first row if needed
        if (isRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Update first column if needed
        if (isCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        solution.setZeroes(matrix);

        // Print the matrix to verify the result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
