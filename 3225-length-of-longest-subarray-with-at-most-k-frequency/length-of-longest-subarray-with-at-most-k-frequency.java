class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxlen=0;
        int l = 0;
        int r = 0;

        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.get(nums[r])<=k)maxlen=Math.max(maxlen,r-l+1);

            while(map.get(nums[r])>k){
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }

            r++;
        }

        return maxlen;
    }
}