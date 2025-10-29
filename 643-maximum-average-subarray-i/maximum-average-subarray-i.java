class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        int i=0;

        for(i = 0 ; i < k ; i++){
            sum+=nums[i];
        }
        double avg = sum/k;
        double maxAvg = avg;

        int j = 0;
        while(i<n){
            sum-=nums[j];
            j++;
            sum+=nums[i];
            i++;
            avg=sum/k;
            maxAvg = Math.max(avg,maxAvg);
        }
        return maxAvg;
    }
}