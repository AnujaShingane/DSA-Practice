class Solution {

    List<Integer>[][] dp;

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        dp = new ArrayList[n][n + 1];

        return func(0, -1, nums);
    }

    public List<Integer> func(int ind, int prev, int[] nums) {

        if (ind == nums.length) {
            return new ArrayList<>();
        }

        if (dp[ind][prev + 1] != null) {
            return new ArrayList<>(dp[ind][prev + 1]);
        }

        // Not Take
        List<Integer> notTake = func(ind + 1, prev, nums);

        // Take
        List<Integer> take = new ArrayList<>();
        if (prev == -1 || nums[ind] % nums[prev] == 0) {
            take.add(nums[ind]);
            take.addAll(func(ind + 1, ind, nums));
        }

        List<Integer> ans;

        if (take.size() > notTake.size()) {
            ans = take;
        } else {
            ans = notTake;
        }

        dp[ind][prev + 1] = new ArrayList<>(ans);

        return new ArrayList<>(ans);
    }
}