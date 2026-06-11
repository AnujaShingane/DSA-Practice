import java.util.*;

class Solution {
    public ArrayList<Integer> getLIS(int nums[]) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp,1);
        for(int i = 0 ; i < n ; i++)hash[i]=i;

        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[i]>nums[prev] && 1+dp[prev]>dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
        }

        int max = 1;
        int ind = 0;
        for(int i = 0 ; i < n ; i++){
            if(dp[i]>max){
                max = dp[i];
                ind = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[ind]);
        while(hash[ind]!=ind){
            ind = hash[ind];
            list.add(nums[ind]);
        }

        Collections.reverse(list);
        
        return list;
    }
}
