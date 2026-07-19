class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        func(0,new ArrayList<>(),res,target,candidates);

        return res;
    }

    public void func(int ind,List<Integer> ds,List<List<Integer>> res,int target,int[] candidates) {
        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }

        if(target<0)return;

        for(int i = ind ; i < candidates.length ; i++){
            //skip duplicates
            if(i>ind && candidates[i]==candidates[i-1])continue;

            //take
            ds.add(candidates[i]);
            func(i+1,ds,res,target-candidates[i],candidates);
            ds.remove(ds.size()-1);
        }    
    }
}