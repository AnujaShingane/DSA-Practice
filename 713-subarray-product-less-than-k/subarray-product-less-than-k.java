class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            long prod = 1;                 // reset per i
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (prod < k) count++;     // check every [i..j]
                else break;                // nums are positive ⇒ product only grows
            }
        }
        return count;
    }
}
