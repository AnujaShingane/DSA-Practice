class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int firstIndex = 0;
        int lastIndex = 0;

        while(j < nums.length){
            sum += nums[j];
            while(sum >= target){
                minLen = Math.min(minLen,j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if(minLen == Integer.MAX_VALUE)return 0;
        return minLen;
    }
}