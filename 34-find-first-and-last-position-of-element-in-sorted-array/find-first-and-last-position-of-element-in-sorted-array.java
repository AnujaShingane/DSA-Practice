class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;

        int[] res = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            if(first == -1 && nums[i] == target){
                first = i;
                last = i;
            }else if(first != -1 && nums[i] == target)last = i;
        }
        res[0] = first;
        res[1] = last;
        return res;
    }
}