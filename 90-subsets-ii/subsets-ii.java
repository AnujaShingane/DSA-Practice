class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        func(0,nums,ans,new ArrayList<>());

        return ans;
    }

    public void func(int ind,int[] nums,List<List<Integer>> ans,List<Integer> list) {
        ans.add(new ArrayList<>(list));

        for(int i = ind ; i < nums.length ; i++){
            if(i>ind && nums[i] == nums[i-1])continue;

            list.add(nums[i]);
            func(i+1,nums,ans,list);
            list.remove(list.size()-1);
        }
    }
}