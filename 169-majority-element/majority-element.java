class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int cnt=1;
        int num=nums[0];
        int i=1;

        while(i<n){
            if(cnt==0){
                num=nums[i];
                cnt=1;
            }
            else if(nums[i]==num)cnt++;
            else if(nums[i]!=num)cnt--;
            i++;
        }
        return num;
    }
}