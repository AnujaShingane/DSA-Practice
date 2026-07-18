class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        func(0,new ArrayList<>(),res,target,candidates);
        return res;
    }

    public void func(int ind,List<Integer> ds,List<List<Integer>> res,int target, int[] candidates){
        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }

        if(ind==candidates.length){
            return;
        }
        
        if(target>=candidates[ind]){
            ds.add(candidates[ind]);
            func(ind,ds,res,target-candidates[ind],candidates);
            ds.remove(ds.size()-1);
        }

        func(ind+1,ds,res,target,candidates);
    }
}