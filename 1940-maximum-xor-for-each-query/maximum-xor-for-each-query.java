class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res = new int[n];

        // Largest value with 'maximumBit' bits (e.g. 111..111)
        int max = (1 << maximumBit) - 1;

        // Compute total XOR
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Process queries in reverse
        for (int i = 0; i < n; i++) {
            res[i] = xor ^ max;  // Best k
            xor ^= nums[n - 1 - i];  // Remove last element for next query
        }

        return res;
    }
}
