class Solution {
    public void sortColors(int[] nums) {
        int countZeros = 0;
        int countOne = 0;
        int countTwo = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) countZeros++;
            else if(nums[i] == 1) countOne++;
            else if(nums[i] == 2) countTwo++;
        }

        for(int i = 0 ; i < countZeros ; i++){
            nums[i] = 0;
        }
        for(int i = countZeros ; i < countZeros+countOne ; i++){
            nums[i] = 1;
        }
        for(int i = countZeros+countOne ; i < nums.length ; i++){
            nums[i] = 2;
        }
    }
}