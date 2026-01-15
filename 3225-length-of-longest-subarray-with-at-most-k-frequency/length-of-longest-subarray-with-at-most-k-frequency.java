class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int maxlen = 0;
        int j = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(i<n && j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            if(map.get(nums[j])>k){
                maxlen = Math.max(maxlen,j-i);
                while(map.get(nums[j])!=k){
                    map.put(nums[i],map.get(nums[i])-1);
                    //if(map.get(nums[i]) == 0)map.remove(nums[i]);
                    i++;
                }
            }

            j++;
        }

        maxlen = Math.max(maxlen, j - i);

        return maxlen;
    }
}