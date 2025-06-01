class Solution {
    public int missingNumber(int[] arr) {
        // int n = nums.length;
        // int sum = (n-1)*(n-1+1)/2;
        // int count =  0;

        // for(int i = 0 ; i < n ; i++){
        //     count += nums[i];
        // }
        // Solution 2: Time Complexity: O(N) & Space Complexity: O(1)
        int sum = 0;
        int N = arr.length;
        // calculating sum of all elements of the array.
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        // calculation sum till 0 to N - 1
        int sum2 = (N * (N + 1))/2;
        // We will get our ans by subtracting
        int ans = sum2 - sum;
        return ans;
    }
}