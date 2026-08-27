class Solution {

    public int countCompleteSubarrays(int[] nums) {

        HashMap<Integer, Integer> all = new HashMap<>();

        for (int num : nums) {
            all.put(num, all.getOrDefault(num, 0) + 1);
        }

        int size = all.size();

        return func(0, nums, size);
    }

    public int func(int start, int[] nums, int size) {

        if (start == nums.length)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 0;

        // Find complete subarrays starting at 'start'
        for (int i = start; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.size() == size) {
                cnt++;
            }
        }

        // Now process the next starting position
        return cnt + func(start + 1, nums, size);
    }
}