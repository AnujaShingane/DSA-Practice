class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new LinkedHashSet<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            set.add(nums[i]);
        }
        int j = 0;
        for(int num : set){
            nums[j++] = num;
        }
        return set.size();
    }
}