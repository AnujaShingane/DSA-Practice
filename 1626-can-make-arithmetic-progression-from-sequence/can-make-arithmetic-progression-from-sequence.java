class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int diff = arr[1]-arr[0];

        for(int i = 1 ; i < n-1 ; i++){
            if(diff==arr[i+1]-arr[i])continue;
            else return false;
        }
        return true;
    }
}