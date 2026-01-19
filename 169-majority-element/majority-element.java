class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int num = -1;

        for(int i = 0 ; i < n ;i++){
            if(cnt==0){
                cnt++;
                num=nums[i];
            }else{
                if(nums[i]==num)cnt++;
                else cnt--;
            }
        }

        return num;
    }
}