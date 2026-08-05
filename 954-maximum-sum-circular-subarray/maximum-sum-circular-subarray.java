class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int one = normalKadane(nums);
        int two = circularKadane(nums);

        if(one<0)return one;

        return Math.max(one,two);
    }

    public int normalKadane(int[] nums){
        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1 ; i < n ; i++){
            currSum = Math.max(nums[i],nums[i]+currSum);
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
    }

    public int circularKadane(int[] nums){
        int n = nums.length;
        int currSum = nums[0];
        int minSum = nums[0];

        int totalSum = 0;
        for(int num : nums){
            totalSum+=num;
        }
        
        for(int i = 1 ; i < n ; i++){
            currSum = Math.min(nums[i],nums[i]+currSum);
            minSum = Math.min(currSum,minSum);
        }

        return totalSum-minSum;
    }
}