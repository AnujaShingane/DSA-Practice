class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                count++;
            }else{
                list.add(nums[i]);
            }
        }

        for(int i = 0 ; i < list.size() ; i++){
            nums[i] = list.get(i);
        }
        for(int i = list.size() ; i < n ; i++){
            nums[i] = 0;
        }

    }
}