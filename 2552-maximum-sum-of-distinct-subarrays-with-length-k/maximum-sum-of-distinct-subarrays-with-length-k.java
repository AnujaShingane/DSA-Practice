class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        long sum = 0;
        long max = 0;

        Set<Integer> set = new HashSet<>();

        for (int r = 0; r < n; r++) {
            // If duplicate found, shrink window
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }

            // Add current element
            set.add(nums[r]);
            sum += nums[r];

            // If window size == k, consider answer
            if (r - l + 1 == k) {
                max = Math.max(max, sum);

                // Slide window
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
        }

        return max;
    }
}
