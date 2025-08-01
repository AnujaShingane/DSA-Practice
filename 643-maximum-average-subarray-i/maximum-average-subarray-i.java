class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0 ,r = k-1;
        int n = nums.length;
        double sum = 0;
        double maxAvg = 0;

        for(int i = 0 ; i < k ; i++){
            sum += nums[i]; 
        }
        maxAvg = (double)sum/k;

        while(r <= n-2){
            sum -= nums[l];
            l++;
            r++;
            sum += nums[r];
            maxAvg = Math.max(maxAvg,(double)sum/k);
        }
        return maxAvg;
    }
}