class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        func(0,candidates,target,ans,new ArrayList<>());

        return ans;
    }

    public void func(int ind,int[] candidates,int target,List<List<Integer>> ans,List<Integer> list) {
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target<0)return;

        for(int i = ind ; i < candidates.length ; i++){
            if(i>ind && candidates[i]==candidates[i-1])continue;

            list.add(candidates[i]);
            func(i+1,candidates,target-candidates[i],ans,list);
            list.remove(list.size()-1);
        }
    }
}