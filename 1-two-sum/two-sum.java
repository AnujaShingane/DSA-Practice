class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int req = target-nums[i];
            if(map.containsKey(req)){
                result[0] = i;
                result[1] = map.get(req);
            }
            map.put(nums[i],i);
        }
        return result;
    }
}