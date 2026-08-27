class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)set.add(num);
        int size = set.size();

        HashMap<Integer,Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int ans = 0;

        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()==size){
                ans += n-r;

                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0)map.remove(nums[l]);
                l++;
            }

            r++;
        }

        return ans;
    }
}