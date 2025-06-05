class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] dummy = new int[n];
        int pos = 0;
        int neg = 1;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] >= 0){
                dummy[pos] = nums[i];
                pos = pos+2;
            }else{
                dummy[neg] = nums[i];
                neg = neg+2;
            }
        }
        return dummy;
    }
}