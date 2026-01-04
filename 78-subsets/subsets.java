class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        func(nums,0,list,res);

        return res;
    }

    public void func(int[] nums,int i,List<Integer> list,List<List<Integer>> res) {
        if(i>=nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        func(nums,i+1,list,res);
        list.remove(list.size()-1);
        func(nums,i+1,list,res);
    }
}


//pick  notpick

/*
    notpick = func();
    pick = list.add(nums[i]) + func();
*/