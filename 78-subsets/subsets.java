class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        func(0,new ArrayList<>(),res,nums);

        return res;
    }

    public void func(int ind,List<Integer> ds,List<List<Integer>> res,int[] nums) {
        if(ind==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        //take
        ds.add(nums[ind]);
        func(ind+1,ds,res,nums);
        ds.remove(ds.size()-1);

        //nottake
        func(ind+1,ds,res,nums);
    }
}