class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sec = -1;
        int first = -1;

        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(target-nums[i])){
                sec = i;
                first = map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }

        return new int[]{first,sec};
    }
}