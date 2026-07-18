class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        func(0,new ArrayList<>(),res,nums);

        return res;     
    }

    public void func(int ind,List<Integer> ds,List<List<Integer>> res,int[] nums) {
        res.add(new ArrayList<>(ds));

        for(int i = ind ; i < nums.length ; i++){
            if(i>ind && nums[i]==nums[i-1])continue;

            //take
            ds.add(nums[i]);
            func(i+1,ds,res,nums);
            ds.remove(ds.size()-1);
        }
    }
}