class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int sum = 0;
        int[] res = new int[n * (n + 1) / 2];
        int ind = 0;

        for(int i = 0 ; i < n ; i++){
            sum = 0;
            for(int j = i ; j < n ; j++){
                sum += nums[j];
                res[ind++] = sum;
            }
        }

        Arrays.sort(res);

        int finalSum =0;
        int mod = 1_000_000_007;
        for(int i = left-1 ; i <= right-1 ; i++){
            finalSum = (finalSum + res[i]) % mod;
        }
        return (int)finalSum;
    }
}

