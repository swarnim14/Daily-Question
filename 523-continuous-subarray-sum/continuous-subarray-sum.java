import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Handle edge case where k is zero
        if (k == 0) {
            // Check if there are at least two consecutive zeros
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        // Normalize k to positive
        k = Math.abs(k);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // To handle the case where the sum itself is a multiple of k

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;

            if (map.containsKey(mod)) {
                int index = map.get(mod);
                if (i - index >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i); // Store first occurrence
            }
        }
        return false;
    }
}
