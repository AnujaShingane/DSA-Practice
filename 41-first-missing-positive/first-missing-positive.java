class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);

        for(int num : nums){
            if(num > 0 && num <= n){
                arr[num] = num;
            }
        }

        for(int i = 1 ; i <= n ; i++){
            if(arr[i] == -1){
                return i;
            }
        }
        return n+1;
    }
}