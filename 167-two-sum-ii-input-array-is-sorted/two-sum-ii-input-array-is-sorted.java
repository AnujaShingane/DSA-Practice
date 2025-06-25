class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0; 
        int r = n-1;
        int[] ans = new int[2];

        while(r < n){
            if((numbers[l] + numbers[r])==target){
                ans[0] = l+1;
                ans[1] = r+1;
                return ans;
            }else if((numbers[l] + numbers[r])<target){
                l++;
            }else if((numbers[l] + numbers[r])>target){
                r--;
            }
        }
        return ans;
    }
}