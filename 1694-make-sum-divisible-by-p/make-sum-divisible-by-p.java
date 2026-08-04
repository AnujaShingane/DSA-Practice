class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        long total = 0;
        for(int num : nums){
            total += num;
        }
        int rem = (int)(total%p);

        if(rem==0)return 0;

        map.put(0,-1);
        int len = n;
        long prefix = 0;

        for(int i = 0 ; i < n ; i++){
            prefix = (prefix+nums[i])%p;
            int need = (int)((prefix-rem+p)%p);

            if(map.containsKey(need)){
                len = Math.min(len,i-map.get(need));
            }

            map.put((int)prefix,i);
        }

        return (len==n) ? -1 : len;
    }
}