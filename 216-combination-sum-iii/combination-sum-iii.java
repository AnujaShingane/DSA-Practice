class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();

        func(0,new ArrayList<>(),res,k,n,arr);

        return res;
    }
    
    public void func(int ind,List<Integer> ds,List<List<Integer>> res,int k,int target,int[] arr) {
        if(target==0 && k==0){
            res.add(new ArrayList<>(ds));
            return;
        }

        if(ind==arr.length)return;

        //take
        if(target>=arr[ind]){
            ds.add(arr[ind]);
            func(ind+1,ds,res,k-1,target-arr[ind],arr);
            ds.remove(ds.size()-1);
        }

        //nottake
        func(ind+1,ds,res,k,target,arr);
    }
}