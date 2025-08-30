// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        int prevSum = 0;
        int wtSum = 0;
        Arrays.sort(bt);
        
        for(int i = 0 ; i < bt.length ; i++){
            wtSum += prevSum;
            prevSum += bt[i];
        }
        return wtSum/bt.length;
    }
}
