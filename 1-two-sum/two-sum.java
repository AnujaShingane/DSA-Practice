class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else if(map.containsKey(target-nums[i])){
                res[1]=map.get(target-nums[i]);
                res[0]=i;
            }
        }

        return res;
    }
}