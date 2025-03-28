class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            if(nums[i] != 0){
                list.add(nums[i]);
                i++;
            }else{
                i++;
            }
        }
        
        for(i = 0 ; i < list.size(); i++){
            nums[i] = list.get(i);
        }
        for(i = list.size() ; i < nums.length ; i++){
            nums[i] = 0;
        }
    }
}