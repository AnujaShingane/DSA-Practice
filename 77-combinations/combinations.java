class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for(int i = 1 ; i <= n ; i++){
            arr[i-1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();

        func(0,new ArrayList<>(),res,k,arr);

        return res;
    }

    public void func(int ind,List<Integer> ds,List<List<Integer>> res,int k,int[] arr) {
        if(k==0){
            res.add(new ArrayList<>(ds));
            return;
        }

        if(ind==arr.length)return;

        //take
        ds.add(arr[ind]);
        func(ind+1,ds,res,k-1,arr);
        ds.remove(ds.size()-1);

        //nottake
        func(ind+1,ds,res,k,arr);
    }
}