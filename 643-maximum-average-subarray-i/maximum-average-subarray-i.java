class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max;

        // first window
        for (int z = 0; z < k; z++) {
            sum += nums[z];
        }
        max = sum;   // store sum, not average

        int i = 0;   // left pointer
        int j = k;   // right pointer

        while (j < nums.length) {
            sum -= nums[i];   // remove left
            i++;

            sum += nums[j];   // add right
            j++;

            max = Math.max(max, sum);
        }

        return max / k;
    }
}
