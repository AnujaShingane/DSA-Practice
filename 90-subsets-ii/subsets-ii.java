class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0 ; i < (1<<n) ; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                if((i&(1<<j))!=0)list.add(nums[j]);
            }
            Collections.sort(list);
            set.add(list);
        }

        List<List<Integer>> res = new ArrayList<>(set);

        return res;
    }
}