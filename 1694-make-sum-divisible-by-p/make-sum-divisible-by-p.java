class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        long total = 0;
        for(int num : nums){
            total+=num;
        }
        int goal = (int)(total%p);
        if(goal==0)return 0;
        long sum = 0;
        int len = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            sum += nums[i];

            int currRem = (int)(sum%p);
            int req = (currRem-goal+p)%p;

            if(map.containsKey(req)){
                len = Math.min(len,i-map.get(req));
            }
            
            map.put(currRem,i);
        }

        return len==Integer.MAX_VALUE || len==n ? -1 : len;
    }
}