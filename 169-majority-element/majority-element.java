class Solution {
    public int majorityElement(int[] nums) {
        int majEle = 0;
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(count == 0){
                majEle = nums[i];
                count++;
            }else if(majEle != nums[i]){
                count--;
            }else{
                count++;
            }
        }
        return majEle;
    }
}