class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        func(nums,used,ans,new ArrayList<>());

        return ans;
    }

    public void func(int[] nums,boolean[] used,List<List<Integer>> ans,List<Integer> list) {
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(used[i])continue;

            if(i>0 && nums[i] == nums[i-1] && !used[i-1])continue;

            used[i] = true;
            list.add(nums[i]);
            func(nums,used,ans,list);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}