class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        double maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < k ; i++){
            sum+=nums[i];
        }
        maxSum=Math.max(maxSum,sum);

        int l = 0;
        int r = k-1;
        while(r<n-1){
            sum-=nums[l];
            l++;
            r++;
            sum+=nums[r];

            maxSum = Math.max(maxSum,sum);
        }

        return (double)(maxSum/k);
    }
}