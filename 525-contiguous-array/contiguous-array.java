class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int ones = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = 0;
        int maxlen = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i]==0)zeros++;
            else ones++;
            int diff = zeros-ones;

            if(map.containsKey(diff)){
                len = i-map.get(diff);
                maxlen = Math.max(len,maxlen);
            }else{
                map.put(diff,i);
            }
        }

        return maxlen;
    }
}