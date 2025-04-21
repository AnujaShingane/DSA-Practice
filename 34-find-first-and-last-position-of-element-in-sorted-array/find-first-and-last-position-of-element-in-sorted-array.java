class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;

        for(int i = 0 ; i < nums.length ; i++){
            if(first != -1 && nums[i] == target){
                last = i;
            }
            if(first == -1 && nums[i] == target){
                last = i;
                first = i;
            }
        }
        int[] res = new int[2];
        res[0] = first;
        res[1] = last;
        return res;
    }
}