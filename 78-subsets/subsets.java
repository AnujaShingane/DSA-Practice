class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsequences(0,nums,list,res);
        return res;
    }

    public void subsequences(int ind , int[] nums , List<Integer> list,List<List<Integer>> res) {
        if(ind == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        subsequences(ind+1, nums, list,res);
        list.remove(list.size()-1);
        subsequences(ind+1, nums, list,res);
    }
}