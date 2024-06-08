import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // First row is always [1].
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            // The first element is always 1.
            row.add(1);

            // Each element (except the first and last) is equal to the sum of the elements
            // above-and-to-the-left and above-and-to-the-right.
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numRows = 5;  // You can change this value to generate more rows

        List<List<Integer>> triangle = solution.generate(numRows);

        // Print the triangle
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
