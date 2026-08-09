class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,-1);
        long sum = 0;
        int len = -1;

        long total = 0;
        for(int num : nums){
            total += num;
        }
        long goal = total-x;

        if (goal == 0) {
            return n;
        }

        for(int i = 0 ; i < n ; i++){
            sum += nums[i];

            if(map.containsKey(sum-goal)){
                len = Math.max(len,i-map.get(sum-goal));
            }
            
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }

        return len==-1 ? -1 : n-len;
    }
}

