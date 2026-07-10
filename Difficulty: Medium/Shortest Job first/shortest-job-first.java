class Solution {
    static int solve(int bt[]) {
        int n = bt.length;
        Arrays.sort(bt);
        int prevSum = 0;
        int sum = 0;
        
        for(int i = 0 ; i < n-1 ; i++){
            prevSum += bt[i];
            sum += prevSum;
        }
        
        return sum/n;
    }
}
