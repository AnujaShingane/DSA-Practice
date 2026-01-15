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
        int j = k-1;   // right pointer

        while (j < nums.length-1) {
            sum -= nums[i];   // remove left
            i++;

            if(j!=nums.length-1){
                j++;
                sum += nums[j];
            }   

            max = Math.max(max, sum);
        }

        return max / k;
    }
}
