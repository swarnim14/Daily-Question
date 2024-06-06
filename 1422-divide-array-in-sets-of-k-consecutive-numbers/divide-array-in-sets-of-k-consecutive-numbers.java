import java.util.*;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;

        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            int first = countMap.firstKey();
            for (int i = 0; i < k; i++) {
                int current = first + i;
                if (!countMap.containsKey(current)) return false;
                int count = countMap.get(current);
                if (count == 1) {
                    countMap.remove(current);
                } else {
                    countMap.put(current, count - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,3,4,4,5,6};
        int k = 4;
        System.out.println(solution.isPossibleDivide(nums, k));  // Output: true
    }
}
