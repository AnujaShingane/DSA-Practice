class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int rem = (int)(total % p);
        if (rem == 0) return 0;  // already divisible

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int curr = (int)(prefix % p);

            // we want a prefix that differs by "rem"
            int needed = (curr - rem + p) % p;
            if (map.containsKey(needed)) {
                ans = Math.min(ans, i - map.get(needed));
            }

            map.put(curr, i); // store/overwrite latest index
        }

        return ans == nums.length ? -1 : ans;
    }
}
