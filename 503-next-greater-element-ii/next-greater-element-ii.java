class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = -1;                // default
            int j = i + 1;
            int steps = 0;              // reset per i
            while (steps < n - 1) {     // scan at most n-1 others
                int idx = j % n;        // wrap around
                if (nums[idx] > nums[i]) {
                    res[i] = nums[idx];
                    break;
                }
                j++;
                steps++;
            }
        }
        return res;
    }
}
