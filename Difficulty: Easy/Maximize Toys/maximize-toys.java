// User function Template for Java

class Solution {
    static int toyCount(int N, int K, int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int cnt = 0;
        int sum=0;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i]<K && sum+arr[i]<=K){
                sum+=arr[i];
                cnt++;
            }
        }
        
        return cnt;
    }
}