class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];

        for(int[] trip : trips){
            int seats = trip[0];
            int from = trip[1];
            int to = trip[2];

            arr[from]+=seats;
            arr[to]-=seats;
        }
        
        int cur = 0;
        for(int i = 0 ; i < arr.length ; i++){
            cur+=arr[i];
            if(cur>capacity)return false;
        }
        return true;
    }
}