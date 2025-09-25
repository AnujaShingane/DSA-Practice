import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Make a presence array only of size n+1
        int[] present = new int[n + 1];
        Arrays.fill(present, -1);

        // Step 2: Mark valid positives in range [1..n]
        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = num;
            }
        }

        // Step 3: Find the first missing positive
        for (int i = 1; i <= n; i++) {
            if (present[i] == -1) {
                return i;
            }
        }

        // Step 4: If all present, answer is n+1
        return n + 1;
    }
}
