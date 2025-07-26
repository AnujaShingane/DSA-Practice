class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0 ; i < nums.length ; i++){
            currSum += nums[i];
            if(currSum > maxSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}


//Moore's Voting Algorithm

// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         int element = 0, count = 0;

//         for(int i = 0 ; i < n ; i++){
//             if(count == 0){
//                 element = nums[i];
//                 count = 1;
//             }else if(nums[i] != element){
//                 count--;
//             }else{
//                 count++;
//             }
//         }

//         return element; 
//     }
// }