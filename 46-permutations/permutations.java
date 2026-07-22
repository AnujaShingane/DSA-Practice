class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] freq = new boolean[n];

        func(0,new ArrayList<>(),res,freq,nums);

        return res;
    }

    public void func(int ind,List<Integer> ds,List<List<Integer>> res,boolean[] freq,int[] nums) {
        if(ind==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            if(!freq[i]){
                ds.add(num);
                freq[i]=true;
                func(ind+1,ds,res,freq,nums);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
}