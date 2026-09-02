class Solution {
    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int[] query : queries){
            if(query[0]==1){
                int sum = 0;
                for(int i = query[1] ; i <= query[2] ; i++){
                    sum+=arr[i];
                }
                ans.add(sum);
            }else{
                arr[query[1]]=query[2];
            }
        }
        
        return ans;
    }
}