class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k>n)return -1;

        int low = 1;
        int high = Integer.MIN_VALUE; // max num in array

        for(int num : bloomDay){
            high=Math.max(high,num);
        }

        int ans = -1;
        while(low<=high){
            int mid =(low+high)/2;
            int bouquetsGot = bouquets(bloomDay,k,mid);

            if(bouquetsGot>=m){
                ans = mid;
                high=mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public static int bouquets(int[] bloomDay,int k , int days){
        int n = bloomDay.length;
        int[] dummy = new int[n];
        for(int i = 0 ; i < n ; i++){
            dummy[i]= bloomDay[i];
        }

        for(int j = 0 ; j < n ; j++){
            if(bloomDay[j] <= days)dummy[j]=1;
            else dummy[j]=0;
        }

        int z = 0;
        int cnt = 0;
        int bouquets = 0;
        while(z<n){
            if(dummy[z]==1){
                cnt++;
                if(cnt==k){
                    bouquets++;
                    cnt=0;
                }
            }else{
                if(cnt>0 &&cnt<k){
                    cnt=0;
                }
            }
            z++;
        }

        return bouquets;
    }
}