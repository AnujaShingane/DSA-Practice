class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}